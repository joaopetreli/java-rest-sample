package com.petreli.restsample.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private Integer code;
    private String message;
}
