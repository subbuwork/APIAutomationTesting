package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.*;

/**
 * Created by subbu on 6/12/2017.
 */
public class TestClass_5 {
    // This class mainly focus on Post method in Restful web services...

    //This method explains how we can pass values  in post method..
   // @Test
    public void TC_001_PostRequest(){
        given().
                header("AppKey","App-Value").
                param("","").
                param("","").
                param("","").
                param("","").
        when().
                post("http://jsonplaceholder.typicode.com/posts/3").
        then().
                statusCode(200).log().all();

    }

    //This explain how we can convert response into string..
    //@Test
    public void TC_002(){

        String responseAsString = get("http://services.groupkt.com/country/search?text=lands").
                asString();
        System.out.println("Resposne as string.."+responseAsString);


    }

    //This explain how we can convert response into InputStream..
    //@Test
    public void TC_003(){

        InputStream responseAsString = get("http://services.groupkt.com/country/search?text=lands").asInputStream();
        System.out.println("Resposne as InputStream.."+responseAsString);


    }

    //This explain how we can convert response into ByteArray..
    //@Test
    public void TC_004(){

        byte[] responseAsString = get("http://services.groupkt.com/country/search?text=lands").asByteArray();
        System.out.println("Resposne as Byte array.."+responseAsString);


    }

    //Extract details using path..
    //@Test
    public void TC_005(){
        String href = when().
                            get("http://jsonplaceholder.typicode.com/photos/3").
                      then().
                            contentType(ContentType.JSON).
                      body("albumId", Matchers.equalTo(1)).
                            extract().path("url");
        System.out.println(href);
        when().get(href).then().statusCode(200);

    }

    //Extract details using path in single line..
    //@Test
    public void TC_006(){
       //Type #1
        String href = get("http://jsonplaceholder.typicode.com/photos/3").path("thumbnailUrl");
        System.out.println(href);
        when().get(href).then().statusCode(200);

        //Type# 2
        String href2 = get("http://jsonplaceholder.typicode.com/photos/3").
                       andReturn().jsonPath().
                       getString("thumbnailUrl");
        System.out.println(href2);
        when().get(href2).then().statusCode(200);
    }

    //Extract response as Response object...
    @Test
    public void TC_007(){
        Response response = get("http://jsonplaceholder.typicode.com/photos/3").
                            then().
                                extract().
                                   response();
        System.out.println("Status Code:::"+response.getStatusCode());
        System.out.println("Content type::"+response.getContentType());
        System.out.println("href::"+response.path("url"));
    }
}
