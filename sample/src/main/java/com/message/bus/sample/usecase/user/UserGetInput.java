package com.message.bus.sample.usecase.user;

import com.message.bus.sample.usecase.core.InputData;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserGetInput implements InputData {
    private final String userId;
}
