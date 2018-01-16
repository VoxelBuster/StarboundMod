package io.github.voxelbuster.sbmod.common.item;

import com.google.common.collect.Multimap;
import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ModMeleeWeapons extends ItemSword {

    private String name;
    private float attackSpeed;

    private static ToolMaterial getToolMaterial(String name) {
        if (name.equals("tungstenhammer")) return EnumHelper.addToolMaterial("tungstenhammer", 1, 512, 4f, 12f, 14);
        else if (name.equals("titaniumdagger"))
            return EnumHelper.addToolMaterial("titaniumdagger", 1, 768, 5f, 7f, 14);
        else if (name.equals("titaniumspear"))
            return EnumHelper.addToolMaterial("titaniumspear", 1, 768, 5f, 10.5f, 14);
        else if (name.equals("durasteelshortsword"))
            return EnumHelper.addToolMaterial("durasteelshortsword", 1, 1024, 5f, 9f, 14);
        else if (name.equals("durasteelbroadsword"))
            return EnumHelper.addToolMaterial("durasteelbroadsword", 1, 1024, 5f, 12f, 14);
        else if (name.equals("violiumshortsword"))
            return EnumHelper.addToolMaterial("violiumshortsword", 1, 2048, 5f, 11f, 14);
        else if (name.equals("violiumbroadsword"))
            return EnumHelper.addToolMaterial("violiumbroadsword", 1, 2048, 5f, 15f, 14);
        else return null;
    }

    public static ModMeleeWeapons[] itemSet = new ModMeleeWeapons[]{
            new ModMeleeWeapons(getToolMaterial("tungstenhammer")).setName("tungstenhammer").setAttackSpeed(0.5f),
            new ModMeleeWeapons(getToolMaterial("titaniumdagger")).setName("titaniumdagger").setAttackSpeed(2f),
            new ModMeleeWeapons(getToolMaterial("titaniumspear")).setName("titaniumspear").setAttackSpeed(1.2f),
            new ModMeleeWeapons(getToolMaterial("durasteelshortsword")).setName("durasteelshortsword").setAttackSpeed(1.8f),
            new ModMeleeWeapons(getToolMaterial("durasteelbroadsword")).setName("durasteelbroadsword").setAttackSpeed(1.6f),
            new ModMeleeWeapons(getToolMaterial("violiumshortsword")).setName("violiumshortsword").setAttackSpeed(1.8f),
            new ModMeleeWeapons(getToolMaterial("violiumbroadsword")).setName("violiumbroadsword").setAttackSpeed(1.6f)
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
        this.setHarvestLevel("sword", 1);
        this.setCreativeTab(StarboundMod.creativeTab);
    }
}
