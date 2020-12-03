package com.fishingspots.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishingspots.entity.Spot;
import com.fishingspots.entity.ZipCodesByRadius;
import com.fishingspots.entity.ZipCodesItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Zip code api dao.
 * @author JeevaG
 */
public class ZipCodeAPIDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private String zipCodeAPIKey = "KYG5KyPosZ1BsXNfv61Sclgn9zoBL6REukmKNd76nnDHhYwzv32Ko9DVkRD8Kz3y";
    //private String zipCode = "53713";

    /**
     * Gets zip codes by radius.
     *
     * @return zipcodes
     */
    public List<Spot> getZipCodesByRadius(int zipCode, int miles) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.zipcodeapi.com/rest/"+zipCodeAPIKey+"/radius.json/"+zipCode+"/"+miles+"/mile");
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
