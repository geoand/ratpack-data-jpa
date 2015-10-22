package geoand.ratdatajpa.test.support.modify

import ratpack.groovy.Groovy

/**
 * Created by gandrianakis on 22/10/2015.
 *
 * This is a super simple implementation that performs all modifications
 * to the default script using String manipulation
 *
 */
class SimpleDefaultScriptModifier implements DefaultScriptModifier {

    @Lazy
    File file = new File(SimpleDefaultScriptModifier.class.getResource("/${Groovy.Script.DEFAULT_APP_PATH}").toURI())

    @Override
    void ensureRatpackDoesntLaunchExplicitSpringContext() {
        file.text = file.text
                .replaceFirst(/register\s*\(.*\)/, "//Spring registration was removed")
                .replaceFirst(/bindInstance\s*\(\s*ApplicationContext.*\)/, "//Spring binding was removed")
                .replaceFirst(/ApplicationContext\s+ctx\s+->/, "//context injection removed")
    }
}
