package geoand.ratdatajpa.test.configurations

import geoand.ratdatajpa.customer.model.Customer
import geoand.ratdatajpa.customer.service.CustomerService
import geoand.ratdatajpa.test.support.AbstractMainClassApplicationUnderTestConfiguration
import geoand.ratdatajpa.test.support.IsolatedConfiguration
import org.springframework.context.annotation.Bean

/**
 * Created by gandrianakis on 22/10/2015.
 */

@IsolatedConfiguration
class CustomerConfiguration extends AbstractMainClassApplicationUnderTestConfiguration {

    static final LAST_NAME_WITH_CUSTOMER = 'nonEmpty'

    Map<String, List<Customer>> map = [
            (LAST_NAME_WITH_CUSTOMER): [new Customer(lastName: LAST_NAME_WITH_CUSTOMER)]
    ]

    @Bean
    public CustomerService dummyCustomerService() {

        return new CustomerService() {
            @Override
            Customer save(Customer customer) {
                return customer
            }

            @Override
            List<Customer> findByLastName(String lastName) {
                return map[lastName] ?: []
            }
        }
    }
}
