package dvt.ttm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	//Block list
	public static Block Receiver = new BasicBlock("receiver", Material.IRON, 1.0F, 10.0F);
	
	public static void createBlocks() {
		GameRegistry.register(Receiver);
		GameRegistry.register(new ItemBlock(Receiver), Receiver.getRegistryName());
	}
}
