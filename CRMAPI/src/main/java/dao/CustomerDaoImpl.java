package dao;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.okaplan.demo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = currentSession.getCriteriaBuilder(); //create Builder
		CriteriaQuery<Customer> cr = cb.createQuery(Customer.class); //create Criteria
		Root<Customer> root = cr.from(Customer.class); //create root
		cr.orderBy(cb.asc(root.get("lastName")));
		cr.select(root);
		Query<Customer> query = currentSession.createQuery(cr); //create query
		List<Customer> results = query.getResultList();
		
		return results;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Customer result=currentSession.get(Customer.class, id);
		
		return result;
	}

	@Override
	public void delete(int id) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		CriteriaBuilder cb = currentSession.getCriteriaBuilder(); //create Builder
		CriteriaDelete<Customer> criteriaDelete = cb.createCriteriaDelete(Customer.class);
		Root<Customer> root = criteriaDelete.from(Customer.class);
		criteriaDelete.where(cb.equal(root.get("id"), id));
		
		currentSession.createQuery(criteriaDelete).executeUpdate();
		
	}
	

}
