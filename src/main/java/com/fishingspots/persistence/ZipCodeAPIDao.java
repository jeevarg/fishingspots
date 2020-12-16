package com.fishingspots.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishingspots.entity.Spot;
import com.fishingspots.entity.ZipCodesByRadius;
import com.fishingspots.entity.ZipCodesItem;
import com.fishingspots.utilities.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * The type Zip code api dao.
 * @author JeevaG
 */
public class ZipCodeAPIDao {

    PropertiesLoader loader = new PropertiesLoader();
    Properties properties = loader.loadProperties();
    private final String key = properties.getProperty("zipCodeAPIKey");
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets zip codes by radius.
     *
     * @return zipcodes
     */
    public List<Spot> getZipCodesByRadius(int zipCode, int miles) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.zipcodeapi.com/rest/"+key+"/radius.json/"+zipCode+"/"+miles+"/mile");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        ZipCodesByRadius zipCodes = null;
        try {
            zipCodes = mapper.readValue(response, ZipCodesByRadius.class);
            //logger.info("ZCDao, line 43: " + zipCodes.toString());
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            logger.error("ZipCodeAPIDao mapper.readValue() error: " + e);
        }
        List<Spot> spots = new ArrayList<>();
        for (ZipCodesItem zip : zipCodes.getZipCodes()) {
            SpotDao spotDao = new SpotDao();
            //logger.info("ZCDao, line 51: " + zip.getZipCode());
            spots.addAll(spotDao.getByZipCode(zip.getZipCode()));

        }

        //return zipCodes.getZipCodes();
        return spots;
    }
}
