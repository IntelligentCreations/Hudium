package dev.intelligentcreations.hudium.api.info.plugin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Environment(EnvType.CLIENT)
public class InfoPluginHandler {
    private static final List<InfoPlugin> plugins = new ArrayList<>();

    public static void loadPlugins() {
        List<InfoPlugin> pluginList = discoverPlugins();
        plugins.addAll(pluginList);
    }

    private static List<InfoPlugin> discoverPlugins() {
        List<EntrypointContainer<InfoPlugin>> pluginEntrypoints = FabricLoader.getInstance().getEntrypointContainers("hudium_info", InfoPlugin.class);
        List<InfoPlugin> discoveredPlugins = new ArrayList<>();
        for (EntrypointContainer<InfoPlugin> entrypoint : pluginEntrypoints) {
            discoveredPlugins.add(entrypoint.getEntrypoint());
        }
        return discoveredPlugins;
    }

    public static List<InfoPlugin> getPlugins() {
        return plugins;
    }
}
