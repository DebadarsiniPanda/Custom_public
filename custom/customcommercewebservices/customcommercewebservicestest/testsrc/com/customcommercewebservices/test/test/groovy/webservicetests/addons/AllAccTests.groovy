/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.customcommercewebservices.test.test.groovy.webservicetests.addons


import de.hybris.platform.util.Config
import com.customcommercewebservices.test.setup.TestSetupUtils

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite.class)
@Suite.SuiteClasses([ExtendedCartTests.class, AccProductTests.class, ExtendedCustomersTests.class, ExtendedCustomersTests.class])
class AllAccTests {

	@BeforeClass
	public static void setUpClass() {
		if (Config.getBoolean("customcommercewebservicestest.enableAccTest", false)
				&& Config.getBoolean("customcommercewebservicestest.enableV1", false)) {
			TestSetupUtils.loadData();
			TestSetupUtils.startServer();
		}
	}

	@AfterClass
	public static void tearDown() {
		if (Config.getBoolean("customcommercewebservicestest.enableAccTest", false)
				&& Config.getBoolean("customcommercewebservicestest.enableV1", false)) {
			TestSetupUtils.stopServer();
			TestSetupUtils.cleanData();
		}
	}

	@Test
	public static void testing() {
		//dummy test class
	}
}
