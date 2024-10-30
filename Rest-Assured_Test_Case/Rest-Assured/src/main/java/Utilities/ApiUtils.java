package Utilities;

import Modules.API_Authentication_Request;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.security.Key;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    static DataFaker faker = new DataFaker();
    static JsonPath jsonPath = API_Authentication_Request.register(faker.generateRegisteredName(),faker.generateFakeEmail()).jsonPath();
  public static String GenerateAuthToken (){

      String AuthToken = jsonPath.getString("accessToken");
      return AuthToken;
  }
    public Response postWithAuth(String endpoint , Object data){
      Response response=  given().log().all()
              .header("Authorization", GenerateAuthToken())

              .header("Content-Type", "application/json")
              .body(data)
              .post(endpoint).then().log().all().extract().response();
              return response;

  }

    public Response GetWithAuth(String endpoint ){
        Response response=  given().log().all()
                .header("Authorization", GenerateAuthToken())
                .header("Content-Type", "application/json")
                .get(endpoint).then().log().all().extract().response();
        return response;

    }
    public Response GetSpecificOrder(String endpoint , String orderId){
        Response response=  given().log().all()
                .header("Authorization", GenerateAuthToken())
                .header("Content-Type", "application/json")
                .queryParam("orderId", orderId)
                .get(endpoint).then().log().all().extract().response();
        return response;

    }

    public Response GetSpecificBooks(String endpoint , String type ){
        Response response=  given().log().all()
                .header("Authorization", GenerateAuthToken())
                .header("Content-Type", "application/json")
                .queryParam("type",type)
                .get(endpoint).then().log().all().extract().response();
        return response;

    }

    public Response DeleteSpecificOrder(String endpoint , String Key){
        Response response=  given().log().all()
                .header("Authorization", GenerateAuthToken())
                .header("Content-Type", "application/json")
                .pathParam("orderId", Key)
                .delete(endpoint + "/{orderId}") .then().log().all().extract().response();
        return response;

    }

    public Response patchSpecificOrder(String endpoint , Object data, String key){
        Response response=  given().log().all()
                .header("Authorization", GenerateAuthToken())
                .queryParam("orderId", key)
                .header("Content-Type", "application/json")
                .body(data)
                .patch(endpoint + "/" + "orderId").then().log().all().extract().response();
        return response;

    }




}
