package com.message.bus.sample.userinterface.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GetUserRequest {

    @JsonProperty("user_id")
    private String userId;
}
