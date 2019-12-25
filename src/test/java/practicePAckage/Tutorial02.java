package practicePAckage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Tutorial02 {

    @BeforeClass
    public void setUp(){

        //The GET method is used to retrieve information from the given server using a given URI. Requests using GET should only retrieve data and should have no other effect on the data.

        //https://reqres.in/
        RestAssured.baseURI="https://reqres.in";

    }

    @Test()
    public void create(){

        Response response = given().body(new File("src\\test\\java\\JsonFiles\\users.json")).when().post("/api/users").then().extract().response();
        System.out.println(response.asString());

    }

}
