package twisted.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;

public class BlockWire extends BlockContainer {

	public BlockWire( int id ) {
		super(id, Material.cloth );
		this.setBlockName("twistedRedstoneWire");
		this.setStepSound(soundClothFootstep);
		this.setResistance(0.1f);
		this.setHardness(0.1f);
		this.setBlockBounds(0.25f, 0.25f, 0.25f, 0.75f, 0.75f, 0.75f);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO: return new TileEntityWire();
		return null;	
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		refreshEntity(world, x, y, z);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockID) {
		refreshEntity(world, x, y, z);
	}
	
	private void refreshEntity(World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if( tileEntity != null ) {
			// TODO: refresh connections
		}
	}
}
