package at.htl.control;

import at.htl.Greeter;
import io.grpc.stub.StreamObserver;
import at.htl.Greeter;
import at.htl.HelloReply;
import at.htl.HelloRequest;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloService implements Greeter {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() ->
                HelloReply.newBuilder().setMessage("Hello " + request.getName()).build()
        );
    }
}
