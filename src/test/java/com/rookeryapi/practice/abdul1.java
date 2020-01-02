package com.rookeryapi.practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class abdul1 {

    @Test

    public void listUsers()

    {

        Response rs = given().
                when().get("https://reqres.in/api/users?page=2");

        // rs.prettyPrint();

        rs.then().body("page", is(2)).body("data.id", hasItems(4, 5, 6)).statusCode(200);
    }

}



























//    public void creatUser()
//
//    {
//        String payload = "{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";
//
//        Response rs = given().contentType("application/json").
//                when().body(payload).
//                post("https://reqres.in/api/users");
//
//        rs.prettyPrint();
//
//    }
//
//}

