package me.arthur.clientservice.api;

public class ApiResult<T> {
  private boolean success;
  private T response;
  private ApiError error;

  public ApiResult(boolean success, T response, ApiError error) {
    this.success = success;
    this.response = response;
    this.error = error;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
  public void setResponse(T response) {
    this.response = response;
  }
  public void setError(ApiError error) {
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
