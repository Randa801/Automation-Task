package Modules;

import Configurations.Config;
import Utilities.DataFaker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class API_Authentication_Request {


  DataFaker faker = new DataFaker();
  static Config config = new Config();

  public static Response register(String clientName , String clientEmail){
      JSONObject data = new JSONObject();
      data.put("clientName", clientName);
      data.put("clientEmail", clientEmail);
      return RestAssured.given().log().all()
              .header("Content-Type","application/json")
              .body(data.toString())
              .post(config.BaseUrl+config.API_Authentication).then().extract().response();
  }








}
