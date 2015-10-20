package geoand.ratdatajpa.test.support

import geoand.ratdatajpa.test.support.modify.DefaultScriptModifier
import geoand.ratdatajpa.test.support.modify.SimpleDefaultScriptModifier
import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Profile
import ratpack.test.MainClassApplicationUnderTest

/**
 * Created by gandrianakis on 21/10/2015.
 *
 * Should be extended by custom configurations that serve as the basis for
 * creating minimal application contexts that will end up as registries in the Ratpack
 */
@Slf4j
abstract class AbstractMainClassApplicationUnderTestConfiguration {


    DefaultScriptModifier scriptModifier = new SimpleDefaultScriptModifier()

    /**
     *  Provides `MainClassApplicationUnderTest` as a bean in order for tests to able to access their corresponding
     *  `TestHttpClient`
     */
    @Bean
    @Lazy
    public MainClassApplicationUnderTest mainClassApplicationUnderTest(ApplicationContext applicationContext) {
        log.debug("Ensuring default script will not launch the explicit context")

        scriptModifier.ensureRatpackDoesntLaunchExplicitSpringContext()

        new SpringGroovyRatpackMainApplicationUnderTest(applicationContext)
    }
}
