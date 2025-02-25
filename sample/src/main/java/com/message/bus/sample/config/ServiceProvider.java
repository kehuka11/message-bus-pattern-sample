package com.message.bus.sample.config;

import com.message.bus.sample.usecase.core.InputData;
import com.message.bus.sample.usecase.core.OutputData;
import com.message.bus.sample.usecase.core.UseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;

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
