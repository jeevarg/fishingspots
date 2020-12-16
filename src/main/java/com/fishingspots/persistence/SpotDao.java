package com.fishingspots.persistence;

import com.fishingspots.entity.Spot;
import com.fishingspots.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Spot dao.
 */
public class SpotDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Spot getById(int id) {
        Session session = sessionFactory.openSession();
        Spot spot = session.get(Spot.class, id);
        session.close();
        return spot;
    }


    /**
     * Save or update.
     *
     * @param spot the spot
     */
    public void saveOrUpdate(Spot spot) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(spot);
        transaction.commit();
        session.close();
    }

    /**
     * Gets by zip code.
     *
     * @param zipCode the zip code
     * @return the by zip code
     */
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

    /**
     * Insert int.
     *
     * @param spot the spot
     * @return the int
     */
    public int insert(Spot spot) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(spot);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete.
     *
     * @param spot the spot
     */
    public void delete(Spot spot) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(spot);
        transaction.commit();
        session.close();
    }

}
