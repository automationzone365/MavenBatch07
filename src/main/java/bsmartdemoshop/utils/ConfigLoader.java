package bsmartdemoshop.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;

    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env=PropertyUtils.propertyLoader("src/main/resources/GlobalData.properties").getProperty("env","QA");

        switch(env){
            case "PROD":
                properties=PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                break;
            case "STAGE":
                properties=PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
                break;
            case "QA":
                properties=PropertyUtils.propertyLoader("src/test/resources/qa_config.properties");
                break;
            case "DEV":
                properties=PropertyUtils.propertyLoader("src/test/resources/dev_config.properties");
                break;
            case "CI":
                properties=PropertyUtils.propertyLoader("src/test/resources/ci_config.properties");
                break;
            default: throw new IllegalStateException("Invalid env "+env);
        }
    }


    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
       // return configLoader==null?new ConfigLoader():configLoader;
    }

    public String getBaseURL(){
        String prop=properties.getProperty("baseURL");
        if(prop!=null)
            return prop;
        else
            throw new RuntimeException("Property baseURL is not specified in the config properties file");
    }
}
