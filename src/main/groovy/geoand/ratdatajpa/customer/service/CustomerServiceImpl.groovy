package geoand.ratdatajpa.customer.service

import geoand.ratdatajpa.customer.repository.CustomerRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by gandrianakis on 20/10/2015.
 */
@Service
@CompileStatic
class CustomerServiceImpl implements CustomerService {

    @Delegate(interfaces = false)
    private final CustomerRepository repository

    @Autowired
    CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository
    }
}
