package org.lucaster.sandbox.arquillian;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import org.lucaster.sandbox.arquillian.service.api.BarService;
import org.lucaster.sandbox.arquillian.service.api.FooService;
import org.lucaster.sandbox.arquillian.service.impl.PojoBarService;
import org.lucaster.sandbox.arquillian.service.impl.PojoFooService;

/**
 * This is the only class that needs to be annotated with a CDI-specific
 * annotation
 *
 * @author Luca Cavagnoli
 *
 */
@ApplicationScoped
public class CdiConfiguration {

	@Produces
	public BarService getBarService(@New final PojoBarService barService) {
		return barService;
	}

	@Produces
	public FooService getFooService(@New final PojoFooService fooService) {
		return fooService;
	}
}
