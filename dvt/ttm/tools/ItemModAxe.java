package dvt.ttm.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe {
	public ItemModAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
