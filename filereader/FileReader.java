package filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class FileReader extends Reader {

  public FileReader(String filepath) throws FileNotFoundException {
    this.reader = new BufferedReader(
        new java.io.FileReader(filepath));
  }

  public static void main(String[] args) throws IOException {
    FileReader reader = new FileReader(
        Paths.get("resources", "example.txt").toString());

    Request content = reader.read();

    System.out.println(content);
  }
}
