package org.lucaster.sandbox.arquillian;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lucaster.sandbox.arquillian.service.api.BarService;
import org.lucaster.sandbox.arquillian.service.api.FooService;
import org.lucaster.sandbox.arquillian.service.impl.PojoBarService;
import org.lucaster.sandbox.arquillian.service.impl.PojoFooService;

/**
 * @author <a href="mailto:mjobanek@redhat.com">Matous Jobanek</a>
 */
@RunWith(Arquillian.class)
public class DeploymentTest {

	@Deployment
	public static Archive<WebArchive> deploy() {

		final File beansXml = new File("src/test/resources/beans.xml");

		// Ambiguous dependencies because defaults to bean-discovery-mode="all"
		final Asset empty = EmptyAsset.INSTANCE;

		System.out.println("======================================");
		System.out.println(beansXml.getAbsolutePath());
		System.out.println("======================================");

		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addAsWebInfResource(beansXml, "beans.xml")
				.addClass(CdiConfiguration.class)
				.addClass(FooService.class)
				.addClass(PojoFooService.class)
				.addClass(BarService.class)
				.addClass(PojoBarService.class);
	}

	@Inject
	private BarService barService;

	@Inject
	private FooService fooService;

	@Test
	public void injectsBarService() {
		assertNotNull(this.barService);
	}

	@Test
	public void injectsFooService() {
		assertNotNull(this.fooService);
	}
}