package dvt.ttm.items;

import dvt.ttm.tools.ItemModAxe;
import dvt.ttm.tools.ItemModHoe;
import dvt.ttm.tools.ItemModPickaxe;
import dvt.ttm.tools.ItemModShovel;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	//Material list
	public static ToolMaterial TELEPORT = EnumHelper.addToolMaterial("teleport", 3, 1337, 2.5F, 7.0F, 16);
	
	//Item list
	public static Item TeleportAxe = new ItemModAxe("teleportAxe", TELEPORT, 8.0F, -3.15F);
	public static Item TeleportPickaxe = new ItemModPickaxe("teleportPickaxe", TELEPORT, 4.0F);
	public static Item TeleportShovel = new ItemModShovel("teleportShovel", TELEPORT, 4.0F);
	public static Item TeleportHoe = new ItemModHoe("teleportHoe", TELEPORT);
	
	
	public static void createItems() {
		GameRegistry.register(TeleportAxe);
		GameRegistry.register(TeleportPickaxe);
		GameRegistry.register(TeleportShovel);
		GameRegistry.register(TeleportHoe);
	}
}
