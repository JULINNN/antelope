package com.ju.antelope.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractBaseVo {

  private static final Gson gson = new GsonBuilder().create();

  @Override
  public String toString() {
    return gson.toJson(this);
  }
}
