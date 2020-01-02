package com.rookeryapi.practice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class abdultw {

    String ConsumerKey = "u87rXbIOCZdtGFMBmczw0N45r";
    String ConsumerSecret = "Rx9OEDDfbv17gByGDyIDXfdyStqncL4z72E18O61IfZ4eyC1lV";
    String AccessToken = "1154153705194868741-ewIZo495Dv8qsfZcwN4jn6bXLphJoD";
    String TokenSecret = "aC44NVHTxVmFxyLz82sZacn4LooJgqQ2nnahdm0xrfs3I";

    @Test

    public void getTweet()
    {
       Response rss = given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .when().get("https://api.twitter.com/1.1/statuses/home_timeline.json");

       rss.prettyPrint();

       rss.then().assertThat().body("id_str", hasItems("1154874159844986882", "1154696179680256005", "1154693681976401920"));

    }

    @Test

    public void postTweet(){
       Response rss = given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .queryParam("status","")
                .when().post("https://api.twitter.com/1.1/statuses/update.json");

       rss.prettyPrint();

        rss.then().assertThat().body("text",is(""));

    }

    @Test

    public void destroyTweet(){


       Response rss = given().auth().oauth(ConsumerKey,ConsumerSecret,AccessToken,TokenSecret)
                .queryParam("id","1155179883124994048")
                .when().post("https://api.twitter.com/1.1/statuses/destroy/id.json");
        rss.prettyPrint();
        rss.then().assertThat().body("text",is("Hi there"));



    }
}

