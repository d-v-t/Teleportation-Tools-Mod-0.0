package dvt.ttm.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe {
	public ItemModHoe(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setRegistryName(name);
	}
}
