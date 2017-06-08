package org.lucaster.sandbox.arquillian.service.impl;

import javax.inject.Inject;

import org.lucaster.sandbox.arquillian.service.api.BarService;
import org.lucaster.sandbox.arquillian.service.api.FooService;

public class PojoBarService implements BarService {

	private final FooService fooService;

	// @Inject on constructor is the needed bare minimum:

	@Inject
	public PojoBarService(final FooService fooService) {
		this.fooService = fooService;
	}

	@Override
	public String getBar() {
		return "Bar uses " + fooService.getFoo();
	}
}
