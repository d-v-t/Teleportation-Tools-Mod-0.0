package dvt.ttm.event;

import dvt.ttm.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {
	public BlockPos receiverPos;
	
	@SubscribeEvent
	public void onHarvestDrops(HarvestDropsEvent e) {
		if (e != null && e.getHarvester() != null) {
			Item inUse = e.getHarvester().getHeldItemMainhand().getItem();
			for (int i = 0; i < ModItems.TeleportToolsList.length; i++) {
				if (inUse == ModItems.TeleportToolsList[i]) {
					e.setDropChance(0.0F);
					break;
				}
			}
		}
	}
}
