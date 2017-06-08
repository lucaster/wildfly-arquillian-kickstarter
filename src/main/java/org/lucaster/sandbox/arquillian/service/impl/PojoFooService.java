package org.lucaster.sandbox.arquillian.service.impl;

import org.lucaster.sandbox.arquillian.service.api.FooService;

public class PojoFooService implements FooService {

	@Override
	public String getFoo() {
		return "Foo";
	}
}
