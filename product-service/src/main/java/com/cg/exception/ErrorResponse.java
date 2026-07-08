package com.cg.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.Instant;
import java.time.LocalDate;

@Builder
public record ErrorResponse(

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm a", timezone = "Asia/Kolkata")
        Instant timeStamp,
        String path,
        String message,
        String statusCode,
        String error
) {
}
