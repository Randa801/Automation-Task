package TestCases;

import APIS.Order_Api;
import Configurations.Config;
import Modules.Orders_Request;
import Utilities.ApiUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Orders_Test {
    Order_Api order = new Order_Api();
    Config config = new Config();
    ApiUtils api = new ApiUtils();


    @Test
    public void CreateNewOrder(){
        Response response = api.postWithAuth(config.BaseUrl+config.Orders,order.OrderBook());
        assertThat( response.path("created"),equalTo(true));
    }
    @Test
    public void GetAllOrders(){
        Response response = api.GetWithAuth(config.BaseUrl+config.Orders);
        Assert.assertEquals(200, response.getStatusCode());
    }
    @Test
    public void GetSpecificOrder(){
        Response response = api.postWithAuth(config.BaseUrl+config.Orders,order.OrderBook());
        String orderId = response.jsonPath().getString("orderId");
        Response next_api_response = api.GetSpecificOrder(config.BaseUrl+config.Orders,orderId);
        Assert.assertEquals(200, next_api_response.getStatusCode());
    }

    @Test
public void deleteSpecificOrder(){
        Response response = api.postWithAuth(config.BaseUrl+config.Orders,order.OrderBook());
        String orderId = response.jsonPath().getString("orderId");
        Response next_response = api.DeleteSpecificOrder(config.BaseUrl+config.Orders,orderId);
    }

    @Test
    public void UpdateOrder(){
        Response response = api.postWithAuth(config.BaseUrl+config.Orders,order.OrderBook());
        String orderId = response.jsonPath().getString("orderId");
        Response next_api_response = api.patchSpecificOrder(config.BaseUrl+config.Orders,order.UpdateOrder(),orderId);
    }

}
