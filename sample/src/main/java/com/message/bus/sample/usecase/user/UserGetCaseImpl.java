package com.message.bus.sample.usecase.user;

import com.message.bus.sample.usecase.core.UseCase;
import org.springframework.stereotype.Service;

@Service
public class UserGetCaseImpl implements UseCase<UserGetInput, UserGetOutput> {
    @Override
    public UserGetOutput handle(UserGetInput inputData) {
        return UserGetOutput.builder()
                .message("user get")
                .build();
    }

    @Override
    public Class<UserGetInput> getInputType() {
        return UserGetInput.class;
    }
}
