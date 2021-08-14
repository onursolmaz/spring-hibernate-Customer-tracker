package com.springMVC.DAO;

import com.springMVC.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;    // todo: try to using constructor injection


    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        //create query and sort by last name or any field
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customerList = theQuery.getResultList();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession= sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {

        Session currentSession= sessionFactory.getCurrentSession();
        Customer customer=currentSession.get(Customer.class,id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession= sessionFactory.getCurrentSession();
        currentSession.delete(getCustomer(id));
    }
}
