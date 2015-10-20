package geoand.ratdatajpa.test.support;

import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by gandrianakis on 22/10/2015.
 *
 * Meta-annotation which is used on tests that use a custom configuration
 * and need to start Ratpack with the resulting ApplicationContext
 */

@ContextConfiguration
@ActiveProfiles("isolated")
@Retention(RetentionPolicy.RUNTIME)
public @interface MainApplicationUnderTestConfiguration {

    @AliasFor(annotation = ContextConfiguration.class, attribute = "classes")
    Class<? extends AbstractMainClassApplicationUnderTestConfiguration>[] value();

}