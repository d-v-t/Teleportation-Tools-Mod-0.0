package dvt.ttm;

import dvt.ttm.blocks.ModBlocks;
import dvt.ttm.event.EventHandlerCommon;
import dvt.ttm.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();
	}

	public void init(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
	}

	public void postInit(FMLPostInitializationEvent e) {

	}
}
