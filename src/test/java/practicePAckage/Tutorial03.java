package practicePAckage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Tutorial03 {

    @BeforeClass
    public void setUp(){

        RestAssured.baseURI="https://gorest.co.in";
        //makeseleniumeasy
    }

    @Test
    public void create(){


       Response res= given().log().all().header("Content-Type","application/json").body(new File("src\\test\\java\\JsonFiles\\userGoRest.json")).auth().oauth2("Ph_Uqh5jI62ACbljOkgA0Oboq7UAnCejDL7C").post("/public-api/users").then().extract().response();
        System.out.println(res.asString());

    }
}
