package com.message.bus.sample.usecase.user;

import com.message.bus.sample.usecase.core.OutputData;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegisterOutput implements OutputData {
    private final String message;
}
