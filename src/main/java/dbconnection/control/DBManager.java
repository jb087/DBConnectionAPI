package dbconnection.control;

import dbconnection.entity.Temperature;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class DBManager {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    public List<Temperature> getAllTemperatures() {
        //return entityManager.createQuery("SELECT t FROM Temperature t").getResultList();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Temperature> criteriaQuery = criteriaBuilder.createQuery(Temperature.class);
        Root<Temperature> root = criteriaQuery.from(Temperature.class);

        criteriaQuery.select(root);
        TypedQuery<Temperature> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
