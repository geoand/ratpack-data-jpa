package geoand.ratdatajpa.test.support

import groovy.transform.CompileStatic
import org.springframework.context.ApplicationContext
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.registry.Registry
import ratpack.spring.internal.SpringRegistryBacking

/**
 * Created by gandrianakis on 21/10/2015.
 *
 * Create a `MainApplicationUnder` that uses the supplied ApplicationContext
 * to populate the Ratpack Registry
 */
@CompileStatic
class SpringGroovyRatpackMainApplicationUnderTest extends GroovyRatpackMainApplicationUnderTest {

    final ApplicationContext applicationContext

    SpringGroovyRatpackMainApplicationUnderTest(ApplicationContext applicationContext) {
        super()
        this.applicationContext = applicationContext
    }

    @Override
    protected Registry createOverrides(Registry serverRegistry) throws Exception {
        Registry.backedBy(new SpringRegistryBacking(applicationContext))
    }
}
