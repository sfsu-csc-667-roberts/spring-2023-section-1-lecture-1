package filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketReader extends Reader {
  public SocketReader(Socket socket) throws IOException {
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(9987);

    Socket socket = server.accept();
    System.out.println("I received a connection!\n");

    SocketReader reader = new SocketReader(socket);
    Request content = reader.read();

    System.out.println(content);

    server.close();
  }
}
