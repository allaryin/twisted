package twisted.common;

import java.io.File;

import twisted.TRVersion;
import twisted.common.block.BlockWire;
import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.Configuration;

public class Config extends Configuration {
	public static final Config instance = new Config();
	private Config() {
		super(new File(Loader.instance().getConfigDir(),TRVersion.CHANNEL+".cfg"));
	}
	
	public static final int DEFAULT_BLOCK_PREFIX = 1700;
	public static final int DEFAULT_ITEM_PREFIX = 17700;
	
	// blocks
	public static BlockWire blockWire;
	
	// items
}
