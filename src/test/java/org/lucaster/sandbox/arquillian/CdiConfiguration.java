package org.lucaster.sandbox.arquillian;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import org.lucaster.sandbox.arquillian.service.api.BarService;
import org.lucaster.sandbox.arquillian.service.api.FooService;
import org.lucaster.sandbox.arquillian.service.impl.PojoBarService;
import org.lucaster.sandbox.arquillian.service.impl.PojoFooService;

@ApplicationScoped
public class CdiConfiguration {

	@Produces
	public BarService getBarService(@New PojoBarService barService) {
		return barService;
	}

	@Produces
	public FooService getFooService(@New PojoFooService fooService) {
		return fooService;
	}
}
