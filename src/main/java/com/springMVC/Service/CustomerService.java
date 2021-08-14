package com.springMVC.Service;


import com.springMVC.Entity.Customer;

import java.util.List;

public interface CustomerService {

  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);
}
