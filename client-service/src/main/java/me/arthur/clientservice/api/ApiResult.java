package me.arthur.clientservice.api;

public class ApiResult<T> {
  private final boolean success;
  private final T response;
  private final ApiError error;

  public ApiResult(boolean success, T response, ApiError error) {
    this.success = success;
    this.response = response;
    this.error = error;
  }


  public boolean isSuccess() {
    return this.success;
  }

  public boolean getSuccess() {
    return this.success;
  }


  public T getResponse() {
    return this.response;
  }


  public ApiError getError() {
    return this.error;
  }



}
