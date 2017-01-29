package dvt.ttm.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe {
	public ItemModPickaxe(String name, ToolMaterial material, float damage) {
		super(material);
		this.damageVsEntity = damage;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	public ItemModPickaxe(String name, ToolMaterial material, float damage, float speed) {
		super(material);
		this.damageVsEntity = damage;
		this.attackSpeed = speed;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
