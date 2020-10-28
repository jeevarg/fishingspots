package com.fishingspots.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishingspots.entity.ZipCodesByRadius;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


/**
 * The type Zip code api dao.
 * @author JeevaG
 */
public class ZipCodeAPIDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private String zipCodeAPIKey = "w8cOLHkz85LBWJfP9Yq5glFXpmFhORgKVJbyW25d4Jb9dTaiDRUeCL9G1w8wcPiR";
    private String zipCode = "53713";

    /**
     * Gets zip codes by radius.
     *
     * @return zipcodes
     */
    ZipCodesByRadius getZipCodesByRadius() {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.zipcodeapi.com/rest/"+zipCodeAPIKey+"/radius.json/"+zipCode+"/5/mile");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        ZipCodesByRadius zipCodes = null;
        try {
            zipCodes = mapper.readValue(response, ZipCodesByRadius.class);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            logger.error("ZipCodeAPIDao mapper.readValue() error: " + e);
        }
        return zipCodes;
    }
}
