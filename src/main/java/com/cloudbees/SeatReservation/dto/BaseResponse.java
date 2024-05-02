package com.cloudbees.SeatReservation.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private Boolean status;
    private String msg;

    public BaseResponse(Boolean status, @Nullable String msg) {
        this.status = status;
        this.msg = msg;
    }
}
