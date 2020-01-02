package com.rookeryapi.practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Twitter {

    String ConsumerKey = "YOSscd0IAoCPVt82rlDoX94wH";
    String ConsumerSecret = "DSEd6r1IJ95gLvLUCw6JGPMBg6hPP3iMX1vkwOIIcYwKBRS21L";
    String AccessToken = "1154153705194868741-g6VJnayjHI3KAqAa8rKFDOWDc4r0NN";
    String TokenSecret = "Ethx1YAlyy7qkKYDAweGaMgDC8oRfjVvuR9xOC2oYF0eo";

    @Test

    public void getTweet(){

        Response rs = given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");

        rs.prettyPrint();

    }
}
