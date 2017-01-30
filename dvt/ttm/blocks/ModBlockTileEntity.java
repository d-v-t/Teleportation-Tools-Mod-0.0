package dvt.ttm.blocks;

import dvt.ttm.tileentity.ModTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockTileEntity extends BlockContainer {
	protected ModBlockTileEntity(String name, Material material, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.isBlockContainer = true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ModTileEntity();
	}
}
