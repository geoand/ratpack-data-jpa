package geoand.ratdatajpa.test.support.basespec

import geoand.ratdatajpa.SpringConfig
import org.springframework.boot.test.SpringApplicationConfiguration
import spock.lang.Specification

/**
 * Created by gandrianakis on 22/10/2015.
 */
@SpringApplicationConfiguration(classes = SpringConfig)
abstract class AbstractBaseSpringTest extends Specification{
}
