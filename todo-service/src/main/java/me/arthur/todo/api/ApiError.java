package me.arthur.todo.api;

import org.springframework.http.HttpStatus;

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

  public String getMessage() {
    return this.message;
  }
  
  public HttpStatus getStatus() {
    return this.status;
  }

}
