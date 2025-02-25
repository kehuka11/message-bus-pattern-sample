# message-bus-pattern-sample

メッセージバスパターンを使用したクリーンアーキテクチャのインジェクション問題解決

## 解決すべき課題

クリーンアーキテクチャを採用したときに、ユースケースクラスが増えるたびに、コントローラクラスにインジェクションするクラス追加する必要がある。

ユースケース増えるたびにコントローラクラスも修正が必要なのと、フィールドが単調増加するのは避けたい

## 解決方法

メッセージバスパターンを使用

クリーンアーキテクチャでいう `InputData`でユースケースクラスを登録しておき（バス）、コントローラからはバスのメソッドをコールすれば、目的のユースケースクラスの処理が行われ、結果が返ってくるようにする。

## ポイント

~~~java
public interface UseCase<TInputData extends InputData, TOutputData extends  OutputData> {
    TOutputData handle(TInputData inputData);

    Class<TInputData> getInputType();
}

~~~

各ユースケースは上記インタフェースをImplementsする。

handleメソッドは各ユースケースごとの処理。

getInputTypeはInputDataのクラスの型を返却する。

~~~java
@Configuration
public class ServiceProvider {
    @Bean
    public Map<Class<?>, UseCase<?, ?>> useCaseMap(Map<String, UseCase<?, ?>> useCaseBeans) {
        return useCaseBeans.values().stream()
                .collect(Collectors.toMap(
                        UseCase::getInputType, // `UseCase` 側で `InputData` の型を定義
                        useCase -> useCase
                ));
    }

}
~~~

SpringBootの

~~~java
public class MovieRecommender {

 private Map<String, MovieCatalog> movieCatalogs;

 @Autowired
 public void setMovieCatalogs(Map<String, MovieCatalog> movieCatalogs) {
    this.movieCatalogs = movieCatalogs;
 }

}
~~~

のようにBeanの登録名をキーとしたMapでDIする仕組みを利用して

~~~java
@Configuration
public class ServiceProvider {
    @Bean
    public Map<Class<?>, UseCase<?, ?>> useCaseMap(Map<String, UseCase<?, ?>> useCaseBeans) {
        return useCaseBeans.values().stream()
                .collect(Collectors.toMap(
                        UseCase::getInputType, // `UseCase` 側で `InputData` の型を定義
                        useCase -> useCase
                ));
    }

}
~~~

InputDataの型によるUseCaseクラスのMapを作成する。

[参考](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired.html)

これによって、コントローラクラスからはメッセージバスのメソッドをコールし、バスがInputDataの型を元にユースケースクラスを判定し、目的のユースケースの処理を実行し、結果を返せ、課題を解消できる。
