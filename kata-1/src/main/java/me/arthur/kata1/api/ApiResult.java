package me.arthur.kata1.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResult<T> {
  private final boolean success;
  private final T response;
  private final ApiError error;

  public ApiResult(boolean success, T response, ApiError error) {
    this.success = success;
    this.response = response;
    this.error = error;
  }



}
