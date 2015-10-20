package geoand.ratdatajpa.customer.service

import geoand.ratdatajpa.customer.model.Customer

/**
 * Created by gandrianakis on 20/10/2015.
 */
interface CustomerService {

    Customer save(Customer customer)

    List<Customer> findByLastName(String lastName)
}