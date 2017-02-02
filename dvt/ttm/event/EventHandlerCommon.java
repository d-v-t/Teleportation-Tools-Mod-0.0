package dvt.ttm.event;

import dvt.ttm.items.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {
	//Overrides item drop and sends items to chest if location exists and player is not sneaking. If not, drops the items like normal.
	
	@SubscribeEvent
	public void onHarvestDrops(HarvestDropsEvent e) {
		//Initial check to minimize crashing. Always a good thing.
		
		if (e != null && e.getHarvester() != null) {
			Item inUse = e.getHarvester().getHeldItemMainhand().getItem();
			for (int i = 0; i < ModItems.TeleportToolsList.length; i++) {
				//Checks if the held tool is a TTM tool and that the player is not crouching. The for loop ensures all tools in the list are checked.
				if (inUse == ModItems.TeleportToolsList[i] && !e.getHarvester().isSneaking()) {
					//Finds the target inventory.
					int[] invPosArray = e.getHarvester().getHeldItemMainhand().getTagCompound().getIntArray("teleportPos");
					IInventory inv = (IInventory) e.getWorld().getTileEntity(new BlockPos(invPosArray[0], invPosArray[1], invPosArray[2]));
					
					//Scans target inventory, marking which slots are open.
					int[] slotsOpen = new int[inv.getSizeInventory()];
					int numOpen = 0;
					
					for (int j = 0; j < inv.getSizeInventory(); j++) {
						if (inv.getStackInSlot(j) != null) {
							slotsOpen[numOpen] = j;
							numOpen++;
						}
					}
					
					//Overwrites the target inventory, canceling drops as it goes. Stops when there are no more open slots or drops has finished.
					for (int k = 0; k < slotsOpen.length && k <= e.getDrops().size(); k++) {
						inv.setInventorySlotContents(slotsOpen[k], e.getDrops().get(k));
						e.getDrops().set(k, null);
					}
					break;
				}
			}
		}
	}
	
	//Used to set location of desired inventory when right clicking with a tool.
	@SubscribeEvent
	public void onPlayerInteract(RightClickBlock e) {
		//Crash check.
		if (e != null) {
			Item inUse = e.getItemStack().getItem();
			
			//Checks if block the tool was "used" on was an inventory.
			if (e.getWorld().getTileEntity(e.getPos()) instanceof IInventory) {
				for (int i = 0; i < ModItems.TeleportToolsList.length; i++) {
					//Edits the NBT tag so that the tool stores the position data.
					if (inUse == ModItems.TeleportToolsList[i]) {
						int[] loc = {e.getPos().getX(), e.getPos().getY(), e.getPos().getZ()};
						NBTTagCompound compound = e.getItemStack().getTagCompound();
						if (compound == null) {
							compound = new NBTTagCompound();
						}
						compound.setIntArray("teleportPos", loc);
						e.getItemStack().setTagCompound(compound);
					}
				}
			}
		}
	}
}
