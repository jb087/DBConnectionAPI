package dbconnection.control;

import dbconnection.entity.Temperature;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Stateless
public class DBManager {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    public List<Temperature> getAllMeasurement() {
        //return entityManager.createQuery("SELECT t FROM Temperature t").getResultList();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Temperature> criteriaQuery = criteriaBuilder.createQuery(Temperature.class);
        Root<Temperature> root = criteriaQuery.from(Temperature.class);

        criteriaQuery.select(root);
        TypedQuery<Temperature> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public List<Temperature> getMeasurementForSensor(String sensorId) {
        return entityManager.createQuery("SELECT t FROM Temperature t WHERE t.sensorId =" + sensorId + " ORDER BY t.datetime").getResultList();
    }

    public void saveMeasurement(Temperature temperature) {
        entityManager.persist(temperature);
    }

    public void generateTemperatures() {
        List<Temperature> temperatures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Temperature temperature = new Temperature();
            temperature.setId(UUID.randomUUID().hashCode());
            temperature.setSensorId(6);

            Random random = new Random();
            temperature.setTemperature(36.0f + random.nextFloat());

            temperature.setDatetime(new Date());

            temperatures.add(temperature);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        temperatures.forEach(this::saveMeasurement);
    }
}
