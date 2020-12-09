package com.fishingspots.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * The type Properties loader.
 */
public class PropertiesLoader {

    private Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Load properties properties.
     *
     * @return the properties
     */
    public Properties loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/apiKeys.properties"));
        } catch (IOException ioe) {
            logger.error("apiKeys.loadProperties()...Cannot load the properties file: " + ioe);
            //ioe.printStackTrace();
        } catch (Exception e) {
            logger.error("apiKeys.loadProperties()..." + e);
            //e.printStackTrace();
        }
        return properties;
    }
}
