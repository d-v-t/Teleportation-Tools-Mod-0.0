package dvt.ttm.event;

import dvt.ttm.items.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {
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
	
	@SubscribeEvent
	public void onPlayerInteract(RightClickBlock e) {
		if (e != null) {
			Item inUse = e.getItemStack().getItem();
			if (e.getWorld().getTileEntity(e.getPos()) instanceof IInventory) {
				for (int i = 0; i < ModItems.TeleportToolsList.length; i++) {
					if (inUse == ModItems.TeleportToolsList[i]) {
						int[] loc = {e.getPos().getX(), e.getPos().getY(), e.getPos().getZ()};
						NBTTagCompound compound = e.getItemStack().getTagCompound();
						if (compound != null) {
							compound = new NBTTagCompound();
						}
						System.out.println(compound);
						compound.setIntArray("teleportPos", loc);
						e.getItemStack().setTagCompound(compound);
					}
				}
			}
		}
	}
}
