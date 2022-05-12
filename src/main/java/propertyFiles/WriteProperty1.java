package propertyFiles;

import java.io.*;
import java.util.Properties;

public class WriteProperty1 {

    public static void main(String[] args) throws IOException {


        String file = "src/main/java/propertyFiles/fileWrite.properties";

        OutputStream out = new FileOutputStream(file);

        Properties prop = new Properties();

        prop.setProperty("url", "http://www.google.com");
        prop.setProperty("user1.username", "username1");
        prop.setProperty("user1.password", "pass1");
        prop.setProperty("user2.username", "username2");
        prop.setProperty("user2.password", "pass2");

        prop.store(out, "I have no comment");

        System.out.println(prop);

    }
}
