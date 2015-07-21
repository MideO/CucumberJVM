package cukes.stepdefinitions.config;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class TestConfig {
    private static TestConfig instance = null;

    public Map<String, String> browserCapabilities;
    public XProperties testProperties;

    public TestConfig(){
        testProperties =  loadProperties("/src/tests/cukes/stepdefinitions/config/test.properties");
        browserCapabilities = loadTestBrowserCapabilities();
    }

    public static TestConfig getInstance() {
        if(instance == null) {
            instance = new TestConfig();
        }
        return instance;
    }

    public static void updateEnvProperties(XProperties properties){
        Map<String, String> envVars = System.getenv();
        for (String propertyName : envVars.keySet()) {
            properties.setProperty(propertyName, envVars.get(propertyName));
        }
    }

    public Map<String, String> loadTestBrowserCapabilities(){
        String pathTemplate = testProperties.getProperty("user.agent.capabilies.path");
        String browserName = testProperties.getProperty("user.agent");
        String browserPropertiesPath = pathTemplate.replace("{browser}", browserName);

        XProperties properties = loadProperties(browserPropertiesPath);

        Map<String, String> propertiesMap = new HashMap<String, String>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }
        return propertiesMap;
    }


    public static XProperties loadProperties(final String PropertyFile) {
        Properties properties = new Properties();

        File file = new File(System.getProperty("user.dir").concat(PropertyFile));
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            properties.load(inputStream);
            XProperties prop =  new XProperties(properties);
            updateEnvProperties(prop);
            return prop;
        } catch (IOException e) {
            System.out.println("IO file not found in "+ System.getProperty("user.dir") + file);
        }
        return new XProperties(properties);
    }
}
