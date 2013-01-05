package twisted.common;

import java.io.File;

import twisted.TRVersion;
import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.Configuration;

public class Config extends Configuration {
	public static final Config instance = new Config();
	
	public static final int DEFAULT_BLOCK_PREFIX = 1700;
	public static final int DEFAULT_ITEM_PREFIX = 17700;
	
	private Config() {
		super(new File(Loader.instance().getConfigDir(),TRVersion.CHANNEL+".cfg"));
	}
}
