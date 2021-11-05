/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.training.setup;

import static com.training.constants.TrainingConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.training.constants.TrainingConstants;
import com.training.service.TrainingService;


@SystemSetup(extension = TrainingConstants.EXTENSIONNAME)
public class TrainingSystemSetup
{
	private final TrainingService trainingService;

	public TrainingSystemSetup(final TrainingService trainingService)
	{
		this.trainingService = trainingService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		trainingService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TrainingSystemSetup.class.getResourceAsStream("/training/sap-hybris-platform.png");
	}
}
