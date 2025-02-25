package com.message.bus.sample.usecase.core;

public interface UseCase<TInputData extends InputData, TOutputData extends  OutputData> {
    TOutputData handle(TInputData inputData);

    Class<TInputData> getInputType();
}
