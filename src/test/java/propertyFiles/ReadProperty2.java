package propertyFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty2 {

    public static void main(String[] args) throws IOException {
        String file = "src/test/java/propertyFiles/file.properties";

        InputStream input = new FileInputStream(file);

        Properties prop = new Properties();
        prop.load(input);

        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));

        String adminUser = prop.getProperty("username.admin");
        String adminPass = prop.getProperty("password.admin");

        System.out.println(adminUser+" - "+adminPass);

        switch (prop.getProperty("browser")){
            case "chrome":
                System.out.println("CHROME");
                break;
            default:
                System.out.println("CHROME degil");
              //  break;
        }

    }
}
