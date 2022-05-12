package propertyFiles;

import org.testng.annotations.Test;

public class ConfigClass {

   @Test
    public void test_1 (){
       String url= Config.URL;
       System.out.println(url);
   }
}
