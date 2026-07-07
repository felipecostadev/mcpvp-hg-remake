package com.mcpvp.game.ability;

import com.mcpvp.HungerGames;
import com.mcpvp.game.ability.handler.*;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectCollection;

public final class AbilityService {

    private final Object2ObjectMap<String, Ability> abilities = new Object2ObjectOpenHashMap<>();

    public AbilityService(HungerGames plugin) {

        register(plugin, new AchillesAbilityHandler(), new AnchorAbilityHandler(), new BarbarianAbilityHandler(), new BoxerAbilityHandler(), new CamelAbilityHandler(), new CannibalAbilityHandler(), new ChameleonAbilityHandler(), new DiggerAbilityHandler(), new EndermageAbilityHandler(), new ExplorerAbilityHandler(), new FiremanAbilityHandler(), new FishermanAbilityHandler(), new FlashAbilityHandler(), new GamblerAbilityHandler(), new GladiatorAbilityHandler(), new GrandpaAbilityHandler(), new GrapplerAbilityHandler(), new HermitAbilityHandler(), new KangarooAbilityHandler(), new LauncherAbilityHandler(), new MadmanAbilityHandler(), new MinerAbilityHandler(), new MonkAbilityHandler(), new NoneAbilityHandler(), new PhantomAbilityHandler(), new PickpocketAbilityHandler(), new SnailAbilityHandler(), new SpecialistAbilityHandler(), new SpyAbilityHandler(), new StomperAbilityHandler(), new SurpriseAbilityHandler(), new SwitcherAbilityHandler(), new ThermoAbilityHandler(), new ThorAbilityHandler(), new TimelordAbilityHandler(), new TitanAbilityHandler(), new UrgalAbilityHandler(), new ViperAbilityHandler());

    }

    public ObjectCollection<Ability> getAbilities() {
        return abilities.values();
    }

    public ObjectArrayList<Ability> getCopyOfAbilities() {
        return new ObjectArrayList<>(abilities.values());
    }

    public Ability getAbility(String name) {
        return abilities.get(name);
    }

    public void register(HungerGames plugin, Ability... abilities) {

        final var pluginManager = plugin.getServer().getPluginManager();

        for (final var ability : abilities) {

            pluginManager.registerEvents(ability, plugin);

            this.abilities.put(ability.getName(), ability);

        }

    }

    public void unregister(Ability... abilities) {

        for (final var ability : abilities)
            this.abilities.remove(ability.getName());

    }

}