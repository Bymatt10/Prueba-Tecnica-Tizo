package com.bymatt.pruebatecnica.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardResponseDto {

    private int code;
    private String description;
    @JsonIgnore
    private HttpStatus httpStatus;

    private Object data;

    public static ResponseEntity<StandardResponseDto> GenerateHttpResponse(StandardResponseDto dto){
        return ResponseEntity.status(dto.getHttpStatus()).body(dto);
    }

    public StandardResponseDto(int code, String description, HttpStatus httpStatus){
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public StandardResponseDto(HttpStatus httpStatus){
        this.code = httpStatus.value();
        this.description = httpStatus.getReasonPhrase();
        this.httpStatus = httpStatus;
    }

    public StandardResponseDto(HttpStatus httpStatus, Object data){
        this.code = httpStatus.value();
        this.description = httpStatus.getReasonPhrase();
        this.httpStatus = httpStatus;
        this.data = data;
    }
}
