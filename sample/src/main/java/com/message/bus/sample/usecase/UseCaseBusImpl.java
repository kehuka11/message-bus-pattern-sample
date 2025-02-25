package com.message.bus.sample.usecase;

import com.message.bus.sample.usecase.core.InputData;
import com.message.bus.sample.usecase.core.OutputData;
import com.message.bus.sample.usecase.core.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class UseCaseBusImpl implements UseCaseBus{

    private final Map<Class<?>, UseCase<?, ?>> useCaseMap;

    @Override
    @SuppressWarnings("unchecked")
    public OutputData dispatch(InputData inputData) {
        UseCase<InputData, OutputData> useCase = (UseCase<InputData, OutputData>) useCaseMap.get(inputData.getClass());
        return useCase.handle(inputData);
    }
}
