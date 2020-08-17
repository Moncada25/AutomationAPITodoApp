package com.bookverse.certification.packapps.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class ConverterJson {

  private static Gson gson;

  public static <T> T fromJson(String json, Type typeOfT) {
    gson = getGson();
    return gson.fromJson(json, typeOfT);
  }

  private static Gson getGson() {
    if (gson == null) {
      gson = new GsonBuilder().create();
    }

    return gson;
  }
}