package battlePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Configurable {
    private static Map<String,Integer> config=new HashMap<>();
public static int getConfigurable(String configurable){
    return config.get(configurable);
}


    public static void loadConfig() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("resources/config.properties");


            prop.load(input);



        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            config.put("levelModifier",Integer.parseInt(prop.getProperty("levelModifier")));

        }

    }
    }