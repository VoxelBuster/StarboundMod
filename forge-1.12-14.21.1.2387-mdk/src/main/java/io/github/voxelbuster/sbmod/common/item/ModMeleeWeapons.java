package io.github.voxelbuster.sbmod.common.item;

import com.google.common.collect.Multimap;
import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.ModAPI;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ModMeleeWeapons extends ItemSword {

    private String name;
    private float attackSpeed;

    private static ToolMaterial getToolMaterial(String name) {
        if (name.equals("tungsten_hammer")) return EnumHelper.addToolMaterial("tungsten_hammer", 1, 512, 4f, 12f, 14);
        else if (name.equals("titanium_dagger")) return EnumHelper.addToolMaterial("titanium_dagger", 1, 768, 5f, 7f, 14);
        else if (name.equals("titanium_spear")) return EnumHelper.addToolMaterial("titanium_spear", 1, 768, 5f, 10.5f, 14);
        else if (name.equals("durasteel_shortsword")) return EnumHelper.addToolMaterial("durasteel_shortsword", 1, 1024, 5f, 9f, 14);
        else if (name.equals("durasteel_broadsword")) return EnumHelper.addToolMaterial("durasteel_broadsword", 1, 1024, 5f, 12f, 14);
        else if (name.equals("violium_shortsword")) return EnumHelper.addToolMaterial("violium_shortsword", 1, 2048, 5f, 11f, 14);
        else if (name.equals("violium_broadsword")) return EnumHelper.addToolMaterial("violium_broadsword", 1, 2048, 5f, 15f, 14);
        else return null;
    }

    public static ModMeleeWeapons[] itemSet = new ModMeleeWeapons[]{
            new ModMeleeWeapons(getToolMaterial("tungsten_hammer")).setName("tungsten_hammer").setAttackSpeed(0.5f),
            new ModMeleeWeapons(getToolMaterial("titanium_dagger")).setName("titanium_dagger").setAttackSpeed(2f),
            new ModMeleeWeapons(getToolMaterial("titanium_spear")).setName("titanium_spear").setAttackSpeed(1.2f),
            new ModMeleeWeapons(getToolMaterial("durasteel_shortsword")).setName("durasteel_shortsword").setAttackSpeed(1.8f),
            new ModMeleeWeapons(getToolMaterial("durasteel_broadsword")).setName("durasteel_broadsword").setAttackSpeed(1.6f),
            new ModMeleeWeapons(getToolMaterial("violium_shortsword")).setName("violium_shortsword").setAttackSpeed(1.8f),
            new ModMeleeWeapons(getToolMaterial("violium_broadsword")).setName("violium_broadsword").setAttackSpeed(1.6f)
    };

    public String getName() {
        return name;
    }

    public ModMeleeWeapons setName(String s) {
        this.name = s;
        this.setRegistryName(s);
        return (ModMeleeWeapons) this.setUnlocalizedName(s);
    }

    public ModMeleeWeapons setAttackSpeed(float atkSpd) {
        this.attackSpeed = atkSpd;
        return this;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.MAINHAND) {
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, attackSpeed - 4);
        }

        return modifiers;
    }

    private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) {
        // Get the modifiers for the specified attribute
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

        // Find the modifier with the specified ID, if any
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

        if (modifierOptional.isPresent()) { // If it exists,
            final AttributeModifier modifier = modifierOptional.get();
            modifiers.remove(modifier); // Remove it
            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), multiplier, modifier.getOperation())); // Add the new modifier
        }
    }

    public ModMeleeWeapons(ToolMaterial material) {
        super(material);
        this.setHarvestLevel("sword",1);
        this.setCreativeTab(StarboundMod.creativeTab);
    }
}
