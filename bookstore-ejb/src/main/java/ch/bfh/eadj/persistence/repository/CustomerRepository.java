package ch.bfh.eadj.persistence.repository;

import ch.bfh.eadj.BookstorePersistenceUnit;
import ch.bfh.eadj.persistence.dto.CustomerInfo;
import ch.bfh.eadj.persistence.entity.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static ch.bfh.eadj.persistence.entity.Customer.FIND_BY_NAME_QUERY.PARAM_NAME;

@Stateless
public class CustomerRepository extends AbstractRepository<Customer> {

    @Inject
    @BookstorePersistenceUnit
    public EntityManager em;

    public CustomerRepository() {
        super(Customer.class);
    }



    public List<CustomerInfo> findByName(String name) {
        List<String> param = new ArrayList<>();
        param.add(name);
        TypedQuery<CustomerInfo> query = em.createNamedQuery(Customer.FIND_BY_NAME_QUERY.QUERY_NAME, CustomerInfo.class);
        query.setParameter(PARAM_NAME, param);
        return query.getResultList();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
