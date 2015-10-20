package geoand.ratdatajpa.customer.service

import geoand.ratdatajpa.customer.model.Customer
import geoand.ratdatajpa.test.support.basespec.AbstractBaseSpringTest
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by gandrianakis on 22/10/2015.
 */
class CustomerServiceIntegrationSpec extends AbstractBaseSpringTest {

    @Autowired
    CustomerService customerService

    def "save"() {
        final String lastName = "test"
        when:
            final Customer savedCustomer = customerService.save(new Customer(lastName: lastName))

        then:
            savedCustomer.id
            savedCustomer.lastName == lastName
    }
}
