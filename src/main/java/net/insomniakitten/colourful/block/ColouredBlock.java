package net.insomniakitten.colourful.block;

import net.insomniakitten.colourful.data.BlockMaterial;
import net.insomniakitten.colourful.data.ColorVariant;
import net.insomniakitten.colourful.item.SimpleBlockItem;
import net.insomniakitten.colourful.item.VariantBlockItem;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ColouredBlock extends AbstractBlock {

    public static final PropertyEnum<ColorVariant> COLOR = PropertyEnum.create("color", ColorVariant.class);

    private final SimpleBlockItem item = new VariantBlockItem<>(this, "color", ColorVariant.VALUES);

    public ColouredBlock(BlockMaterial material) {
        super(material);
    }

    @Override
    public int serialize(IBlockState state) {
        return state.getValue(COLOR).getMetadata();
    }

    @Override
    public IBlockState deserialize(int meta) {
        ColorVariant color = ColorVariant.VALUES[meta];
        return getDefaultState().withProperty(COLOR, color);
    }

    @Override
    public MapColor getColor(IBlockState state) {
        return state.getValue(COLOR).getMapColor();
    }

    @Override
    public void getVariants(NonNullList<ItemStack> variants) {
        for (ColorVariant color : ColorVariant.VALUES) {
            variants.add(new ItemStack(this, 1, color.getMetadata()));
        }
    }

    @Override
    public void getProperties(BlockStateContainer.Builder builder) {
        builder.add(COLOR);
    }

    @Override
    public SimpleBlockItem getItem() {
        return item;
    }

}