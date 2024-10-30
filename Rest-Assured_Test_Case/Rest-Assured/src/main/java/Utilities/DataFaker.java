package Utilities;

import com.github.javafaker.Faker;

public class DataFaker {

    private final Faker faker;
    public DataFaker() {faker = new Faker();}

    public String generateRegisteredName() {
        return faker.name().fullName();
    }

    public String generateFakeEmail() {
        return faker.internet().emailAddress();
    }
    public String generateCustomerName() {
        return faker.name().fullName();
    }

}
