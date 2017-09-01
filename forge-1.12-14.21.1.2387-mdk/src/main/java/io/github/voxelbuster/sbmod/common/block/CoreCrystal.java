package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoreCrystal extends ModBlock {
    public CoreCrystal() {
        super(Material.ROCK, "corecrystal");
        this.setUnlocalizedName(this.getName());
        this.setResistance(30f);
        this.setLightLevel((float) 10/15);
        this.setCreativeTab(StarboundMod.creativeTab);
        this.setHardness(10f);
        this.setHarvestLevel("pickaxe", 1);
        this.setRegistryName(new ResourceLocation(StarboundMod.MODID, this.getName()));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        EnumFacing initialDirection;
        if (world.getBlockState(pos.offset(EnumFacing.NORTH).down()) == Blocks.OBSIDIAN.getDefaultState()) {
            initialDirection = EnumFacing.NORTH;
            BlockPos currentPos = pos.offset(initialDirection).down().offset(initialDirection).down();
            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                currentPos = currentPos.offset(initialDirection).down();
                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                    currentPos = currentPos.down();
                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                        currentPos = currentPos.down();
                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                            currentPos = currentPos.down();
                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                currentPos = currentPos.offset(initialDirection.getOpposite()).down();
                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                    currentPos = currentPos.offset(initialDirection.getOpposite()).up();
                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                        currentPos = currentPos.up();
                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                            currentPos = currentPos.up();
                                                                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                currentPos = currentPos.up();
                                                                                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                    currentPos = currentPos.up().offset(initialDirection);
                                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                        currentPos = currentPos.up().offset(initialDirection);
                                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState() &&
                                                                                                world.getBlockState(pos.offset(initialDirection.getOpposite(), 4)) == this.getDefaultState()) {
                                                                                            world.setBlockState(pos.down(), Blocks.GOLD_BLOCK.getDefaultState());
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (world.getBlockState(pos.offset(EnumFacing.SOUTH).down()) == Blocks.OBSIDIAN.getDefaultState()) {
            initialDirection = EnumFacing.SOUTH;
            BlockPos currentPos = pos.offset(initialDirection).down().offset(initialDirection).down();
            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                currentPos = currentPos.offset(initialDirection).down();
                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                    currentPos = currentPos.down();
                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                        currentPos = currentPos.down();
                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                            currentPos = currentPos.down();
                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                currentPos = currentPos.offset(initialDirection.getOpposite()).down();
                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                    currentPos = currentPos.offset(initialDirection.getOpposite()).up();
                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                        currentPos = currentPos.up();
                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                            currentPos = currentPos.up();
                                                                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                currentPos = currentPos.up();
                                                                                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                    currentPos = currentPos.up().offset(initialDirection);
                                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                        currentPos = currentPos.up().offset(initialDirection);
                                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState() &&
                                                                                                world.getBlockState(pos.offset(initialDirection.getOpposite(), 4)) == this.getDefaultState()) {
                                                                                            world.setBlockState(pos.down(), Blocks.GOLD_BLOCK.getDefaultState());
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (world.getBlockState(pos.offset(EnumFacing.EAST).down()) == Blocks.OBSIDIAN.getDefaultState()) {
            initialDirection = EnumFacing.EAST;
            BlockPos currentPos = pos.offset(initialDirection).down().offset(initialDirection).down();
            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                currentPos = currentPos.offset(initialDirection).down();
                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                    currentPos = currentPos.down();
                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                        currentPos = currentPos.down();
                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                            currentPos = currentPos.down();
                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                currentPos = currentPos.offset(initialDirection.getOpposite()).down();
                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                    currentPos = currentPos.offset(initialDirection.getOpposite()).up();
                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                        currentPos = currentPos.up();
                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                            currentPos = currentPos.up();
                                                                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                currentPos = currentPos.up();
                                                                                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                    currentPos = currentPos.up().offset(initialDirection);
                                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                        currentPos = currentPos.up().offset(initialDirection);
                                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState() &&
                                                                                                world.getBlockState(pos.offset(initialDirection.getOpposite(), 4)) == this.getDefaultState()) {
                                                                                            world.setBlockState(pos.down(), Blocks.GOLD_BLOCK.getDefaultState());
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (world.getBlockState(pos.offset(EnumFacing.WEST).down()) == Blocks.OBSIDIAN.getDefaultState()) {
            initialDirection = EnumFacing.WEST;
            BlockPos currentPos = pos.offset(initialDirection).down().offset(initialDirection).down();
            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                currentPos = currentPos.offset(initialDirection).down();
                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                    currentPos = currentPos.down();
                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                        currentPos = currentPos.down();
                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                            currentPos = currentPos.down();
                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                currentPos = currentPos.offset(initialDirection.getOpposite()).down();
                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                    currentPos = currentPos.offset(initialDirection.getOpposite());
                                                    if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                        currentPos = currentPos.offset(initialDirection.getOpposite());
                                                        if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                            currentPos = currentPos.offset(initialDirection.getOpposite());
                                                            if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                currentPos = currentPos.offset(initialDirection.getOpposite());
                                                                if(world.getBlockState(currentPos) == ModBuildingBlocks.ancientstone.getDefaultState()) {
                                                                    currentPos = currentPos.offset(initialDirection.getOpposite()).up();
                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                        currentPos = currentPos.up();
                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                            currentPos = currentPos.up();
                                                                            if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                currentPos = currentPos.up();
                                                                                if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                    currentPos = currentPos.up().offset(initialDirection);
                                                                                    if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState()) {
                                                                                        currentPos = currentPos.up().offset(initialDirection);
                                                                                        if(world.getBlockState(currentPos) == Blocks.OBSIDIAN.getDefaultState() &&
                                                                                                world.getBlockState(pos.offset(initialDirection.getOpposite(), 4)) == this.getDefaultState()) {
                                                                                            world.setBlockState(pos.down(), Blocks.GOLD_BLOCK.getDefaultState());
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
