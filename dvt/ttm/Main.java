package dvt.ttm;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	public static final String MODID = "ttm";
	public static final String MODNAME = "Teleportation Tools Mod (TTM)";
	public static final String VERSION = "0.0";
	
	@SidedProxy(clientSide="dvt.ttm.ClientProxy", serverSide="dvt.ttm.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		this.proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
	}
}
