package com.message.bus.sample.usecase;

import com.message.bus.sample.usecase.core.InputData;
import com.message.bus.sample.usecase.core.OutputData;

public interface UseCaseBus {

    OutputData dispatch(InputData inputData);
}
