package geoand.ratdatajpa.handler

import geoand.ratdatajpa.customer.model.Customer
import geoand.ratdatajpa.test.configurations.CustomerConfiguration
import geoand.ratdatajpa.test.support.basespec.AbstractBaseSpringMainClassApplicationUnderTestProviderSpec
import geoand.ratdatajpa.test.support.MainApplicationUnderTestConfiguration
import groovy.json.JsonSlurper
import spock.lang.Shared

import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by gandrianakis on 21/10/2015.
 */
@MainApplicationUnderTestConfiguration(CustomerConfiguration)
class CustomerFunctionalSpec extends AbstractBaseSpringMainClassApplicationUnderTestProviderSpec {

    @Shared
    JsonSlurper jsonSlurper = new JsonSlurper()

    def "customer lastName handler empty"() {
        when:
            final List<Customer> result = getCustomers("-1")

        then:
            [] == result
    }

    def "customer lastName handler non empty"() {
        when:
            final List<Customer> result = getCustomers(CustomerConfiguration.LAST_NAME_WITH_CUSTOMER)

        then:
            assertThat(result).hasSize(1)
            result[0].lastName == CustomerConfiguration.LAST_NAME_WITH_CUSTOMER
    }

    private List<Customer> getCustomers(String lastName) {
        parseCustomers(getText("customer/$lastName"))
    }

    private List<Customer> parseCustomers(String customersStr) {
        return jsonSlurper.parseText(customersStr)
    }
}
