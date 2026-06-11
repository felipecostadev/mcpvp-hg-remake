package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.PotionContents;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("UnstableApiUsage")
public final class MadmanAbilityHandler extends Ability {

    public MadmanAbilityHandler() {
        setName("Madman");
        setIconStack(
                new ItemBuilder(Material.POTION)
                        .setGlint(true)
                        .setData(DataComponentTypes.POTION_CONTENTS, PotionContents.potionContents().addCustomEffect(PotionEffectType.WEAKNESS.createEffect(1, 1)).build())
                        .build()
        );
        setSummary(ObjectList.of("Create an aura of madness around", "yourself and weaken other players"));
    }

}