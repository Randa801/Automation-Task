package TestCases;

import Configurations.Config;
import Utilities.ApiUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.ApiUtils.GenerateAuthToken;
import static io.restassured.RestAssured.given;

public class Books_Test {
    ApiUtils api = new ApiUtils();
    Config config = new Config();

    @Test
    public void GetAllBooks() {
        Response response = api.GetWithAuth(config.BaseUrl + config.Books);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void GetFictionBooks() {
        Response response = api.GetSpecificBooks(config.BaseUrl + config.Books, "fiction");
        Assert.assertEquals(200, response.getStatusCode());

    }

}

