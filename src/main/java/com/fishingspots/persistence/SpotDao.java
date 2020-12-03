package com.fishingspots.persistence;

import com.fishingspots.entity.Spot;
import com.fishingspots.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class SpotDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Spot> getByZipCode(String zipCode) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Spot> query = builder.createQuery(Spot.class);
        //CriteriaQuery<Spot> query1 = builder.
        Root<Spot> root = query.from(Spot.class);
        Expression<String> propertyPath = root.get("zipCode");
        query.where(builder.equal(propertyPath,zipCode));
        logger.info("SDao, line 29: " + query.toString());
        List<Spot> spots = session.createQuery(query).getResultList();
        session.close();
        return spots;
    }

}
