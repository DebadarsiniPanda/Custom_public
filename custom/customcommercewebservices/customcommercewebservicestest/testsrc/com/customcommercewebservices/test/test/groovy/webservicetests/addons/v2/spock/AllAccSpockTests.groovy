/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.customcommercewebservices.test.test.groovy.webservicetests.addons.v2.spock


import de.hybris.platform.oauth2.constants.OAuth2Constants
import de.hybris.platform.util.Config
import com.customcommercewebservices.test.constants.YcommercewebservicestestConstants
import com.customcommercewebservices.test.setup.TestSetupUtils

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses([SopTest, ExtendedCartV2Tests, ExtendedBaseSitesTest])
class AllAccSpockTests {
	@BeforeClass
	public static void setUpClass() {
		if (Config.getBoolean("customcommercewebservicestest.enableAccTest", false)) {
			TestSetupUtils.loadData();
			String[] ext = [
					YcommercewebservicestestConstants.EXTENSIONNAME - "test",
					OAuth2Constants.EXTENSIONNAME,
					"acceleratorservices"
			]
			TestSetupUtils.startServer(ext);
		}
	}

	@AfterClass
	public static void tearDown() {
		if (Config.getBoolean("customcommercewebservicestest.enableAccTest", false)) {
			TestSetupUtils.stopServer();
			TestSetupUtils.cleanData();
		}
	}

	@Test
	public static void testing() {
		//dummy test class
	}
}
