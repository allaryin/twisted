package twisted;

import java.util.logging.Logger;

import twisted.common.CommonProxy;
import twisted.common.Config;
import twisted.common.Version;
import twisted.common.block.BlockWire;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Version.CHANNEL, name = Version.NAME, version = Version.VERSION, dependencies="required-after:Forge@[6.5.0.0,)")
@NetworkMod(channels = Version.CHANNEL, clientSideRequired = true, serverSideRequired = false) //TODO: connection & packet handlers
public class TwistedRedstone {
	@Instance(Version.CHANNEL)
	public static TwistedRedstone instance;
	
	public static Logger log = Logger.getLogger(Version.CHANNEL);
	
	@SidedProxy(clientSide = "twisted.client.ClientProxy", serverSide = "twisted.common.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent e) {
		log.setParent(FMLLog.getLogger());
		log.info(Version.NAME+" - v"+Version.VERSION);
		
		Config.instance.load();
		Config.blockWire = new BlockWire( Config.instance.getBlock("wire.basic", Config.DEFAULT_BLOCK_PREFIX + 0).getInt() );
		Config.instance.save();
		
		// TODO: register blocks
		// GameRegistry.registerBlock(Config.blockWire, ItemBlockWire.class, "Twisted Redstone Wire");
		
		proxy.preInit();
	}
	
	@Init
	public void init(FMLInitializationEvent e) {
		proxy.init();
		
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
