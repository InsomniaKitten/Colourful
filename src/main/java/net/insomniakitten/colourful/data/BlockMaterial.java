package net.insomniakitten.colourful.data;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum BlockMaterial implements IStringSerializable {

    TERRACOTTA(Material.ROCK, SoundType.STONE, BlockRenderLayer.SOLID, 1.5F, 30.0F),
    METAL(Material.IRON, SoundType.METAL, BlockRenderLayer.SOLID, 5.0F, 30.0F),
    GLASS(Material.GLASS, SoundType.GLASS, BlockRenderLayer.TRANSLUCENT, 0.3F, 1.5F),
    QUARTZ(Material.ROCK, SoundType.STONE, BlockRenderLayer.SOLID, 0.8F, 4.0F);

    public static final BlockMaterial[] VALUES = BlockMaterial.values();

    private final Material material;
    private final SoundType sound;
    private final BlockRenderLayer layer;
    private final float hardness;
    private final float resistance;

    BlockMaterial(Material material, SoundType sound, BlockRenderLayer layer, float hardness, float resistance) {
        this.material = material;
        this.sound = sound;
        this.layer = layer;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    public Material getMaterial() {
        return material;
    }

    public SoundType getSound() {
        return sound;
    }

    public BlockRenderLayer getRenderLayer() {
        return layer;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

}
