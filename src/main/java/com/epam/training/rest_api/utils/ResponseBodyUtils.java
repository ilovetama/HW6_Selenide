package com.epam.training.rest_api.utils;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import java.util.List;

public final class ResponseBodyUtils {

  private ResponseBodyUtils() {
  }

  @Step("Get objects by Json Path")
  public static <T> List<T> getObjectsByJsonPath(ResponseBody responseBody,
      String jsonPath, Class<T> genericType) {
    return responseBody
        .jsonPath()
        .getList(jsonPath, genericType);
  }

  @Step("Get string Json value")
  public static String getStringJsonValue(ResponseBody responseBody, String jsonPath) {
    return JsonPath.from(responseBody
            .asString())
        .getString(jsonPath);
  }
}
