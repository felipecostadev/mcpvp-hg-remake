package com.mcpvp.game.ability.handler;

import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.PotionContents;
import it.unimi.dsi.fastutil.objects.ObjectList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("UnstableApiUsage")
public final class UrgalAbilityHandler extends Ability {

    public UrgalAbilityHandler() {
        setName("Urgal");
        setIconStack(
                new ItemBuilder(Material.POTION)
                        .setGlint(true)
                        .setData(DataComponentTypes.POTION_CONTENTS, PotionContents.potionContents().addCustomEffect(PotionEffectType.INSTANT_DAMAGE.createEffect(1, 1)).build())
                        .build()
        );
        setSummary(ObjectList.of("You start the game with 3 Strength I", "potions"));
    }

}