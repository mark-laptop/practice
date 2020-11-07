package ru.ndg.practice.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ndg.practice.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Office> getAll(Set<Integer> ids) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> officeCriteria = criteriaBuilder.createQuery(Office.class);
        Root<Office> officeRoot = officeCriteria.from(Office.class);
        officeCriteria.select(officeRoot);
        if (ids != null) {
            officeCriteria.where(officeRoot.get("id").in(ids));
        }
        return entityManager.createQuery(officeCriteria).getResultList();
    }

    @Override
    public Office getById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> officeCriteria = criteriaBuilder.createQuery(Office.class);
        Root<Office> officeRoot = officeCriteria.from(Office.class);
        officeCriteria.select(officeRoot);
        officeCriteria.where(criteriaBuilder.equal(officeRoot.get("id"), id));
        return entityManager.createQuery(officeCriteria).getSingleResult();
    }

    @Override
    public void save(Office office) {
        entityManager.persist(office);
    }

    @Override
    public void update(Office office) {
        entityManager.merge(office);
    }
}
