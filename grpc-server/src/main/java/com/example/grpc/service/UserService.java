package com.example.grpc.service;
import com.example.grpc.UserOuterClass;
import com.example.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase{
    @Override
    public void login(UserOuterClass.LoginRequest request, StreamObserver<UserOuterClass.APIResponse> responseObserver) {
        String userName = request.getUsername();
        String password = request.getPassword();
        UserOuterClass.APIResponse.Builder response = UserOuterClass.APIResponse.newBuilder();
        if(userName.equals(password)){
            //success message
            response.setResponseCode(1).setResponseMessage("Success");
        } else {
            //failure message
            response.setResponseCode(0).setResponseMessage("Invalid username or password");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(UserOuterClass.Empty request, StreamObserver<UserOuterClass.APIResponse> responseObserver) {
    }
}
