package com.message.bus.sample.userinterface.controller;

import com.message.bus.sample.usecase.UseCaseBus;
import com.message.bus.sample.usecase.core.OutputData;
import com.message.bus.sample.usecase.user.UserGetInput;
import com.message.bus.sample.usecase.user.UserRegisterInput;
import com.message.bus.sample.userinterface.model.GetUserRequest;
import com.message.bus.sample.userinterface.model.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UseCaseBus useCaseBus;

    @PostMapping("/register")
    public ResponseEntity<OutputData> registerUser(@RequestBody RegisterUserRequest request) {
        UserRegisterInput input = UserRegisterInput.builder()
                .userId(request.getUserId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        return ResponseEntity.ok(useCaseBus.dispatch(input));
    }

    @PostMapping("/get")
    public ResponseEntity<OutputData> getUser(@RequestBody GetUserRequest request) {
        UserGetInput input = UserGetInput.builder()
                .userId(request.getUserId())
                .build();
        return ResponseEntity.ok(useCaseBus.dispatch(input));
    }
}
