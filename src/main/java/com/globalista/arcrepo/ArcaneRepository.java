package com.globalista.arcrepo;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArcaneRepository implements ModInitializer {
	public static final String MOD_ID = "arcrepo";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Arcane Repository] Thank you for downloading!");
	}
}