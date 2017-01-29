package dvt.ttm.event;

import dvt.ttm.items.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {
	@SubscribeEvent
	public void onHarvestDrops(HarvestDropsEvent e) {
		Item inUse = e.getHarvester().getActiveItemStack().getItem();
		if (inUse == ModItems.TeleportAxe || inUse == ModItems.TeleportHoe || inUse == ModItems.TeleportPickaxe || inUse == ModItems.TeleportShovel) {
			
		}
	}
}
