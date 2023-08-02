package api.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Slf4j
public class BaseRequest {
    private RequestSpecification requestSpecification;

    public BaseRequest() {
        requestSpecification = given()
                .spec(new RequestSpecBuilder()
                        .setUrlEncodingEnabled(false)
                        .build())
                .baseUri("https://reqres.in")
                .log().method()
                .log().body()
                .log().uri()
                .log().headers();
    }

    public Response get(String url) {
        Response response = requestSpecification.get(url);
        logResponse(response);
        return response;
    }

    public Response post(String url){
        Response response = requestSpecification.post(url);
        logResponse(response);
        return response;
    }

    public Response put(String url){
        Response response = requestSpecification.put(url);
        logResponse(response);
        return response;
    }

    public Response delete(String url){
        Response response = requestSpecification.delete(url);
        logResponse(response);
        return response;
    }


    public BaseRequest body(Object body){
        if(body != null){
            requestSpecification.contentType(ContentType.JSON)
                    .body(body);
        }
        return this;
    }

    public BaseRequest header(String headerName, Object value){
        requestSpecification.header(headerName, value);
        return this;
    }

    public BaseRequest multipart(File file){
        requestSpecification.multiPart(file);
        return this;
    }

    public BaseRequest param(String name, Object value){
        if(value != null){
            requestSpecification.params(name, value.toString());
        }
        return this;
    }

    public BaseRequest queryParam(String name, Object value){
        if(value != null){
            requestSpecification.queryParam(name, value.toString());
        }
        return this;
    }

    private void logResponse(Response response) {
        String rxId = response.getHeader("x-request-id");
        log.info("Got response with x-request-id " + rxId + " in " + response.getTimeIn(MILLISECONDS) + " ms");
        log.debug(response.getBody().prettyPrint());
    }
}
