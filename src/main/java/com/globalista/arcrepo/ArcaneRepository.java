package com.globalista.arcrepo;

import com.globalista.arcrepo.content.Content;
import com.globalista.arcrepo.content.Gem;
import com.globalista.arcrepo.content.trinkets.GenericRelic;
import com.globalista.arcrepo.content.trinkets.Relics;
import com.globalista.arcrepo.util.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArcaneRepository implements ModInitializer {
	public static final String MOD_ID = "arcrepo";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {

		GenericRelic.Type.initialize();
		Generator.initialize();
		Content.initialize();
		Relics.initialize();
		Gem.initialize();
		Group.initialize();
		LootTableModifier.initialize();

		LOGGER.info("[Arcane Repository] Thank you for downloading!");
	}
}