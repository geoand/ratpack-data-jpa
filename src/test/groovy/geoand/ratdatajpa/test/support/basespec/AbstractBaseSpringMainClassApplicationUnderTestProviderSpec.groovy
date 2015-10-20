package geoand.ratdatajpa.test.support.basespec

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import ratpack.test.MainClassApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.Specification

import javax.annotation.PostConstruct

/**
 * Created by gandrianakis on 21/10/2015.
 *
 * Should be extended by specifications that provide their own custom configuration class
 * and launch Ratpack using it
 *
 * These specification need to be annotated with `@MainApplicationUnderTestConfiguration`
 */
@CompileStatic
abstract class AbstractBaseSpringMainClassApplicationUnderTestProviderSpec extends Specification {

    @Autowired
    @Lazy
    MainClassApplicationUnderTest aut


    @Delegate
    TestHttpClient client

    /**
     * Ensure the `client` is created after the `aut` is injected by Spring
     */
    @PostConstruct
    void initClient() {
        client = testHttpClient(aut)
    }

}
