package filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class Reader {
  protected BufferedReader reader;

  public Request read() throws IOException {
    String header = reader.readLine();

    HashMap<String, String> list = new HashMap<>();

    String line = reader.readLine();
    while (line.trim().length() != 0) {
      String[] item = line.split(": ");

      list.put(item[0], item[1]);

      line = reader.readLine();
    }

    String content = reader.readLine();

    return new Request(header, list, content);
  }
}
