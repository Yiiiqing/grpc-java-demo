package zone.yiqing.grpc;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @author yiqing.zhang, {@literal <yiqing.zhang@leyantech.com>}
 * @date 2021-06-24.
 */
public class AddServer extends AddServiceGrpc.AddServiceImplBase {

  public static void main(String[] args) throws IOException {
    ServerBuilder
        .forPort(7777)
        .addService(new AddServer())
        .build()
        .start();
    System.out.println("server on 7777");
    while (true){}
  }

  @Override
  public void add(AddRequest request, StreamObserver<AddReply> responseObserver) {
    int add = myAdd(request.getA(), request.getB());
    responseObserver.onNext(AddReply.newBuilder().setRes(add).build());
    responseObserver.onCompleted();
  }

  public int myAdd(int a, int b) {
    return a + b;
  }
}
