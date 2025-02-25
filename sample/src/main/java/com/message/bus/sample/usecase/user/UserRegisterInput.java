package com.message.bus.sample.usecase.user;

import com.message.bus.sample.usecase.core.InputData;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegisterInput implements InputData {
    private final String userId;

    private final String firstName;

    private final String lastName;
}
