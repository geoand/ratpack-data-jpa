package geoand.ratdatajpa.test.support;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by gandrianakis on 22/10/2015.
 */

@Configuration
@Profile("isolated")
@Retention(RetentionPolicy.RUNTIME)
public @interface IsolatedConfiguration {
}
