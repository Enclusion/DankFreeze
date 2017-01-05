package com.buzznacker.freeze.listener;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.listener.listeners.EntityListener;
import com.buzznacker.freeze.listener.listeners.InventoryListener;
import com.buzznacker.freeze.listener.listeners.PlayerListener;
import org.bukkit.event.Listener;

public class ListenerHandler {

    private Freeze plugin;
    public ListenerHandler(Freeze plugin) {
        this.plugin = plugin;
        loadListeners();
        listeners = null;
    }

    private Listener[] listeners = {
            new EntityListener(plugin),
            new InventoryListener(plugin),
            new PlayerListener(plugin)
    };

    private void loadListeners() {
        for(Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


}
