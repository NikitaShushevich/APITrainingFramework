package api.requests;

import api.pojos.CreateUserRequest;
import api.pojos.GetUserResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresRequests {
    public Response createUser(CreateUserRequest userToBeCreated){
        return new BaseRequest()
                .body(userToBeCreated)
                .post("/api/users/")
                .then().statusCode(201).extract().response();
    }
    public Response getUser(){
        return new BaseRequest()
                .get("/api/users/2")
                .then().statusCode(200).extract().response();
    }
    public Response getNotFoundUser(){
        return new BaseRequest()
                .get("/api/users/23")
                .then().statusCode(404).extract().response();
    }
    public Response deleteUser(){
        return new BaseRequest()
                .delete("/api/users/23");
    }
}
