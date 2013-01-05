package twisted;

import java.util.logging.Logger;

import twisted.common.Config;
import twisted.common.block.BlockWire;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = TRVersion.CHANNEL, name = TRVersion.NAME, version = TRVersion.VERSION, dependencies="required-after:Forge@[6.5.0.0,)")
@NetworkMod(channels = TRVersion.CHANNEL, clientSideRequired = true, serverSideRequired = false) //TODO: connection & packet handlers
public class TwistedRedstone {
	@Instance(TRVersion.CHANNEL)
	public static TwistedRedstone instance;
	
	public static Logger log = Logger.getLogger(TRVersion.CHANNEL);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent e) {
		log.setParent(FMLLog.getLogger());
		log.info(TRVersion.NAME+" - v"+TRVersion.VERSION);
		
		Config.instance.load();
		Config.blockWire = new BlockWire( Config.instance.getBlock("wire.basic", Config.DEFAULT_BLOCK_PREFIX + 0).getInt() );
		Config.instance.save();
		
		// TODO: register blocks
		// GameRegistry.registerBlock(Config.blockWire, ItemBlockWire.class, "Twisted Redstone Wire");
	}
	
	@Init
	public void init(FMLInitializationEvent e) {
		// TODO: register things
		// TODO: init localization
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent e) {
	}
	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent e) {
	}
}
