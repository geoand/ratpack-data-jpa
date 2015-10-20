package geoand.ratdatajpa.customer.repository

import geoand.ratdatajpa.customer.model.Customer
import org.springframework.data.repository.Repository

/**
 * Created by gandrianakis on 20/10/2015.
 */
interface CustomerRepository extends Repository<Customer, Long> {

    List<Customer> findByLastName(String lastName)

    Customer save(Customer customer)
}