package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.PotionContents;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("UnstableApiUsage")
public final class SnailAbilityHandler extends Ability {

    public SnailAbilityHandler() {
        setName("Snail");
        setIconStack(
                new ItemBuilder(Material.POTION)
                        .setGlint(true)
                        .setData(DataComponentTypes.POTION_CONTENTS, PotionContents.potionContents().addCustomEffects(ObjectList.of(PotionEffectType.SLOWNESS.createEffect(1, 1), PotionEffectType.RESISTANCE.createEffect(1, 1))).build())
                        .build()
        );
        setSummary(ObjectList.of("Do damage to others and have a 1 in 3", "chance to give them slowness II"));
    }

}