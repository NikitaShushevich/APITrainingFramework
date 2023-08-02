package api.utils;

import api.pojos.CreateUserRequest;
import api.pojos.CreateUserResponse;
import api.pojos.GetUserResponse;
import api.requests.ReqresRequests;
import io.restassured.response.Response;

public class ReqresUtils {
    ReqresRequests requests;

    public ReqresUtils(ReqresRequests requests) {
        this.requests = requests;
    }

    public CreateUserRequest generateDataCreateUser(String name, String job){
        return CreateUserRequest.builder()
                .name(name)
                .job(job)
                .build();
    }

    public CreateUserResponse createUser(CreateUserRequest userToBeCreated) {
        Response response = requests.createUser(userToBeCreated);
        return response.as(CreateUserResponse.class);
    }
    public GetUserResponse getUser(){
        Response response = requests.getUser();
        return response.as(GetUserResponse.class);
    }
    public GetUserResponse getNotFoundUser(){
        Response response = requests.getNotFoundUser();
        return response.as(GetUserResponse.class);
    }
}
