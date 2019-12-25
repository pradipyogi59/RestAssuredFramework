package practicePAckage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tutorial01 {

    @BeforeClass
    public void setUp(){

        //The GET method is used to retrieve information from the given server using a given URI. Requests using GET should only retrieve data and should have no other effect on the data.

        //https://reqres.in/
        RestAssured.baseURI="https://reqres.in";

    }

    @Test
    public void getUser(){

        Response res= given().when().get("/users?page=2");

        int  res2= given().when().get("/api/users").then().extract().statusCode();

        Response res3=given().when().get("/api/users");
        String s = res3.asString();


        System.out.println(res2);
        System.out.println(s);
        System.out.println("Status code is : "+res.statusCode());

        /*
        we are using the  given - when - then format.
We start with given method and specify query and key parameter using the param method then we use the ‘when‘ method and use the ‘get’ method to call ‘Text Search API‘.

Now we use ‘then‘ part to check the response. We simply add a check ‘contentType(ContentType.JSON)‘ to make sure that the response we get is in JSON format

         */

        /*
        To represent the head of JSON we use $ sign and “.” means next node and subsequent “.” may mean next node.

$.results[0].geometry.location.lat - Example of getting latitude
$.results[0].types[0] - Example to get the first type i.e. train_station
         */

        Response res4=given().when().get("/api/users");
        //https://jsonpath.curiousconcept.com/
        //json validore

         res4.then().body("data[0].first_name", equalTo("George"));
         //body validation
        //hasItems(23, 54)); multiple items

    }

}
