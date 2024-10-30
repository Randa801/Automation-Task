package APIS;

import Modules.Orders_Request;
import Utilities.Constant;
import Utilities.DataFaker;

public class Order_Api {


    DataFaker faker = new DataFaker();


    public Orders_Request OrderBook(){
        Orders_Request request = new Orders_Request();
        request.setBookId(Constant.bookId);
        request.setCustomerName(faker.generateCustomerName());
        return request;

    }

    public Orders_Request UpdateOrder(){
        Orders_Request request = new Orders_Request();
        request.setCustomerName(faker.generateCustomerName());
        return request;

    }




    }


