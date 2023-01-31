package filereader;

import java.util.HashMap;
import java.util.Map;

public class Request {
  private String header;
  private Map<String, String> list;
  private String content;

  public Request(String header, Map<String, String> list, String content) {
    this.header = header;
    this.list = list;
    this.content = content;
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(
        String.format("%s\n", this.header));

    list.entrySet().forEach(entry -> {
      buffer.append(
          String.format(
              "%s: %s\n",
              entry.getKey(),
              entry.getValue()));
    });

    buffer.append(String.format("\n%s", this.content));

    return buffer.toString();
  }

  public static void main(String[] args) {
    HashMap<String, String> list = new HashMap<>();
    list.put("a", "1");
    list.put("b", "2");

    Request content = new Request("This is the header", list, "This is the content");

    System.out.println(content);
  }
}
