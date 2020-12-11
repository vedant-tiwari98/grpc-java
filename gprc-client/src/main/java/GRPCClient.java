import com.example.grpc.UserOuterClass;
import com.example.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9091).usePlaintext().build();

        // stub from proto file
        userGrpc.userBlockingStub stub = userGrpc.newBlockingStub(channel);

        UserOuterClass.LoginRequest request = UserOuterClass.LoginRequest.newBuilder().setUsername("Hello").setPassword("Hello").build();

        UserOuterClass.APIResponse response = stub.login(request);

        System.out.println("Response: "+response.getResponseMessage());
    }
}
