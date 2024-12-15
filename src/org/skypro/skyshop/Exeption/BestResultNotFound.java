package org.skypro.skyshop.Exeption;

public class BestResultNotFound extends Exception{

  public BestResultNotFound() {
  }

  public BestResultNotFound(Throwable cause) {
    super(cause);
  }

  public BestResultNotFound(String message) {
    super(message);
  }

  public BestResultNotFound(String message, Throwable cause) {
    super(message, cause);
  }

  public BestResultNotFound(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }


}
