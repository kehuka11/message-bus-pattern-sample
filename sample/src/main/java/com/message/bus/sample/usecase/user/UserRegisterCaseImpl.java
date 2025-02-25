package com.message.bus.sample.usecase.user;

import com.message.bus.sample.usecase.core.UseCase;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterCaseImpl implements UseCase<UserRegisterInput, UserRegisterOutput> {
    @Override
    public UserRegisterOutput handle(UserRegisterInput inputData) {
        return UserRegisterOutput.builder()
                .message("user register")
                .build();
    }

    @Override
    public Class<UserRegisterInput> getInputType() {
        return UserRegisterInput.class;
    }
}
