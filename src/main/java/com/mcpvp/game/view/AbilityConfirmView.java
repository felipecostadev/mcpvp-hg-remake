package com.mcpvp.game.view;

import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import com.mcpvp.game.ability.Ability;
import io.papermc.paper.datacomponent.DataComponentTypes;
import me.devnatan.inventoryframework.View;
import me.devnatan.inventoryframework.context.OpenContext;
import me.devnatan.inventoryframework.context.RenderContext;
import me.devnatan.inventoryframework.context.SlotContext;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

@SuppressWarnings("UnstableApiUsage")
public final class AbilityConfirmView extends View {

    private final ItemStack emptyGlassItem = new ItemBuilder(Material.GLASS_PANE).setName(Components.SPACE).build();

    private final ItemStack availableConfirmBackItem = new ItemBuilder(Material.SUGAR).setName(Components.miniMessage("<italic:false><color:green>^ Up ^</color>")).build();

    private final ItemStack unavailablePreviousPageItem = new ItemBuilder(Material.LIGHT_GRAY_CARPET).setName(Components.SPACE).build();

    private final ItemStack unavailableNextPageItem = new ItemBuilder(Material.LIGHT_GRAY_CARPET).setName(Components.SPACE).build();

    private final ItemStack startingItem = new ItemBuilder(Material.OAK_SIGN).setName(Components.miniMessage("<italic:false><color:white>Starting Items</color>")).build();

    private final ItemStack selectItem = new ItemBuilder(Material.FLINT_AND_STEEL)
            .setData(DataComponentTypes.ITEM_MODEL, Key.key("minecraft:item/fire"))
            .setName(Components.miniMessage("<italic:false><color:white>Play with this kit!</color>"))
            .build();

    @Override
    public void onOpen(@NotNull OpenContext open) {

        if (!(open.getInitialData() instanceof Ability ability))
            return;

        open.modifyConfig()
                .cancelInteractions()
                .title("The " + ability.getName() + " kit")
                .size(54);

    }

    @Override
    public void onFirstRender(@NonNull RenderContext render) {

        if (!(render.getInitialData() instanceof Ability ability))
            return;

        final var viewKitIconItem = new ItemBuilder(ability.getIconStack())
                .setName(Components.miniMessage("<italic:false><color:gold>View kit icon</color>"))
                .build();

        final var kitDescriptionItem = new ItemBuilder(Material.BOOK)
                .setName(Components.miniMessage("<italic:false><color:yellow>Description</color>"))
                .build();

        final var player = render.getPlayer();

        for (var slot = 0; slot < 54; slot++)
            render.slot(slot, emptyGlassItem).cancelOnClick();

        render.slot(1, 1, unavailablePreviousPageItem)
                .cancelOnClick();

        render.slot(1, 5, availableConfirmBackItem)
                .onClick(SlotContext::back);

        render.slot(1, 9, unavailableNextPageItem)
                .cancelOnClick();

        render.slot(3, 3, viewKitIconItem)
                .cancelOnClick();

        render.slot(3, 5, kitDescriptionItem)
                .cancelOnClick();

        render.slot(5, 1, startingItem)
                .cancelOnClick();

        render.slot(5, 9, selectItem)
                .onClick(context -> {

                    context.closeForPlayer();

                    player.sendMessage(Components.miniMessage("<color:green>You are now a " + ability.getName() + "</color>"));
                    player.sendMessage(Components.miniMessage("<color:green>Use /kit to open up the kit gui again, or use /kit <kitname></color>"));

                });

        final var itemStacks = ability.getItemStacks();

        if (itemStacks != null && itemStacks.length > 0) {

            var column = 1;

            for (final var itemStack : itemStacks)
                render.slot(6, column++, itemStack).cancelOnClick();

        }

    }

}