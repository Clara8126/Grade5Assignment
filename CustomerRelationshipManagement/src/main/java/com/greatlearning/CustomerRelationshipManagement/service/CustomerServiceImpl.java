package com.greatlearning.CustomerRelationshipManagement.service;

import java.util.List;

import com.greatlearning.CustomerRelationshipManagement.model.Customer;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.*;

@Service
public  class CustomerServiceImpl implements CustomerService {

	 private  SessionFactory sessionFactory;
	 private Session session;
	 
	 @Autowired
	
		public CustomerServiceImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
			try {
				this.session = sessionFactory.getCurrentSession();
			}
			catch (HibernateException e) {
				// TODO: handle exception
				this.session=sessionFactory.openSession();
			}
		}
	@Override
	@Transactional
	public List<Customer> listAllData() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Customer> l1= (List<Customer>)session.createQuery("from Customer").list();
		return l1;
	}

	@Override
	public void save(Customer s1) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(s1);
		tx.commit();
		System.out.println("Save Completed");
	}

	@Override
	public Customer delete(int id) {
		// TODO Auto-generated method stub
		Customer s1 = session.get(Customer.class,id);
		Transaction tx = session.beginTransaction();
		session.delete(s1);
		tx.commit();
		return s1;
	}

	@Override
	public Customer getCustomerDetails(int id) {
		// TODO Auto-generated method stub
		Customer s1 = session.get(Customer.class,id);
		return s1;	}

}
