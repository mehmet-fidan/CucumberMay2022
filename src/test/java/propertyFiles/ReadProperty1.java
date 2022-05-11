package propertyFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty1 {

    public static void main(String[] args) throws IOException {

        InputStream input =new FileInputStream("src/test/java/propertyFiles/file.properties");

        Properties prop = new Properties();
        prop.load(input);


        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));

    }
}
