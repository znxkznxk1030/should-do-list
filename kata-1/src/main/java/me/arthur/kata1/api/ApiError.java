package me.arthur.kata1.api;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiError {
  private final String message;
  private final HttpStatus status;

  public ApiError(String message, HttpStatus status) {
    this.message = message;
    this.status = status;
  }

  public ApiError(Throwable throwable, HttpStatus status) {
    this.message = throwable.getMessage();
    this.status = status;
  }



}
