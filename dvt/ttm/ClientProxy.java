package dvt.ttm;

import dvt.ttm.blocks.BlockRenderRegister;
import dvt.ttm.items.ItemRenderRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
	}
}
