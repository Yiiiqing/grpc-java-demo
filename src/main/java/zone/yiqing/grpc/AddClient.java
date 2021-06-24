package zone.yiqing.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import zone.yiqing.grpc.AddServiceGrpc.AddServiceBlockingStub;

/**
 * @author yiqing.zhang, {@literal <yiqing.zhang@leyantech.com>}
 * @date 2021-06-24.
 */
public class AddClient {

  AddServiceBlockingStub stub;
  ManagedChannel channel;

  public static void main(String[] args) {
    AddClient client = new AddClient();

    int a = 1;
    int b = 1;

    AddReply addReply = client.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
    System.out.println(addReply.getRes());
  }

  public AddClient() {
    channel = ManagedChannelBuilder
        .forAddress("127.0.0.1", 7777)
        .usePlaintext() // 文本的类型
        .build();
    stub = AddServiceGrpc.newBlockingStub(channel);
  }
}
