package dvt.ttm.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModTileEntities {
	public static void createTileEntities() {
		GameRegistry.registerTileEntity(ModTileEntity.class, "receiver_tile_entity");
	}
}
