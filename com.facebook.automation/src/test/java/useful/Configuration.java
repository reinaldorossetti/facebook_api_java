package useful;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class Configuration {

    public String getConfig(String name) {

        InputStream inputStream = null;
        String value = null;
        try {
            Properties prop = new Properties();
            String propFileName = "conf.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            value = prop.getProperty(name);
            //System.out.println(value);
            return value;

        } catch (Exception e) {

            System.out.println("Exception: " + e);

        }

        return value;

    }

    public void setPropertiesToken(String publicKey) throws IOException, URISyntaxException {

        InputStream inputStream = null;
        Properties prop = new Properties();
        String propFileName = "conf.properties";

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
            inputStream.close();
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        prop.setProperty("token", publicKey);
        URL url = getClass().getClassLoader().getResource(propFileName);
        prop.store(new FileOutputStream(new File(url.toURI())), null);

    }
}
