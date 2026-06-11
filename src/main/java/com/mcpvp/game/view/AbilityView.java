package com.mcpvp.game.view;

import com.mcpvp.HungerGames;
import com.mcpvp.core.util.Components;
import com.mcpvp.core.util.ItemBuilder;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.TooltipDisplay;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import me.devnatan.inventoryframework.View;
import me.devnatan.inventoryframework.component.Pagination;
import me.devnatan.inventoryframework.context.OpenContext;
import me.devnatan.inventoryframework.context.RenderContext;
import me.devnatan.inventoryframework.state.State;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

@SuppressWarnings("UnstableApiUsage")
public final class AbilityView extends View {

    private final ItemStack emptyGlassItem = new ItemBuilder(Material.GLASS_PANE).setName(Components.SPACE).build();

    private final ItemStack unavailableConfirmBackItem = new ItemBuilder(Material.GUNPOWDER).setName(Components.SPACE).build();

    private final ItemStack unavailablePreviousPageItem = new ItemBuilder(Material.LIGHT_GRAY_CARPET).setName(Components.SPACE).build();
    private final ItemStack availablePreviousPageItem = new ItemBuilder(Material.WHITE_CARPET).setName(Components.miniMessage("<italic:false><color:green><-- Previous Page </color>")).build();

    private final ItemStack unavailableNextPageItem = new ItemBuilder(Material.LIGHT_GRAY_CARPET).setName(Components.SPACE).build();
    private final ItemStack availableNextPageItem = new ItemBuilder(Material.WHITE_CARPET).setName(Components.miniMessage("<italic:false><color:green> Next Page --></color>")).build();

    private final State<Pagination> paginationState = buildPaginationState(HungerGames.getInstance().getAbilityService().getCopyOfAbilities())
            .elementFactory((context, builder, index, ability) -> {

                final var abilityItem = new ItemBuilder(ability.getIconStack())
                        .setData(DataComponentTypes.TOOLTIP_DISPLAY, TooltipDisplay.tooltipDisplay().addHiddenComponents(DataComponentTypes.POTION_CONTENTS, DataComponentTypes.FIREWORKS, DataComponentTypes.ATTRIBUTE_MODIFIERS).build())
                        .setName(Components.miniMessage("<italic:false><color:white>" + ability.getName() + "</color>"));

                final var summary = ability.getSummary();

                if (summary != null && !summary.isEmpty()) {

                    final var lore = new ObjectArrayList<Component>();

                    for (final var text : summary)
                        lore.add(Components.miniMessage("<italic:false><color:white>" + text + "</color>"));

                    abilityItem.setLore(lore);

                }

                builder.withItem(abilityItem.build())
                        .onClick(handler -> handler.openForPlayer(AbilityConfirmView.class, ability));

            })
            .layoutTarget('O')
            .build();

    @Override
    public void onOpen(@NotNull OpenContext open) {

        open.modifyConfig()
                .cancelInteractions()
                .title("Your owned kits")
                .layout(
                        "         ",
                        "OOOOOOOOO",
                        "OOOOOOOOO",
                        "OOOOOOOOO",
                        "OOOOOOOOO",
                        "OOOOOOOOO"
                );

    }

    @Override
    public void onFirstRender(@NonNull RenderContext render) {

        final var pagination = paginationState.get(render);

        final var pageSize = 5 * 9;
        final var currentPageItems = Pagination.splitSourceForPage(pagination.currentPageIndex(), pageSize, pagination.lastPage(), pagination.source()).size();

        for (var index = currentPageItems; index < pageSize; index++) {

            final var row = (index / 9) + 2;
            final var column = (index % 9) + 1;

            render.slot(row, column, emptyGlassItem)
                    .updateOnStateChange(paginationState)
                    .cancelOnClick();

        }

        for (final var column : new int[] { 2, 3, 4, 6, 7, 8 } )
            render.slot(1, column, emptyGlassItem).cancelOnClick();

        render.slot(1, 1, unavailablePreviousPageItem)
                .displayIf(context -> !pagination.canBack())
                .updateOnStateChange(paginationState)
                .cancelOnClick();

        render.slot(1, 1, availablePreviousPageItem)
                .displayIf(pagination::canBack)
                .updateOnStateChange(paginationState)
                .onClick(pagination::back);

        render.slot(1, 5, unavailableConfirmBackItem)
                .cancelOnClick();

        render.slot(1, 9, unavailableNextPageItem)
                .displayIf(context -> !pagination.canAdvance())
                .updateOnStateChange(paginationState)
                .cancelOnClick();

        render.slot(1, 8, availableNextPageItem)
                .displayIf(pagination::canAdvance)
                .updateOnStateChange(paginationState)
                .onClick(pagination::advance);

    }

}