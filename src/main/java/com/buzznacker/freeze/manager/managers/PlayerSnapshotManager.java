package com.buzznacker.freeze.manager.managers;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.manager.Manager;
import com.buzznacker.freeze.player.PlayerSnapshot;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerSnapshotManager extends Manager {

    private Map<UUID, PlayerSnapshot> playerSnapshotMap = new HashMap<>();

    public PlayerSnapshotManager(Freeze plugin) {
        super(plugin);
    }

    public void takeSnapshot(Player player) {
        playerSnapshotMap.put(player.getUniqueId(), new PlayerSnapshot(player));
    }

    public void removeSnapshot(Player player) {
        playerSnapshotMap.remove(player.getUniqueId());
    }

    public PlayerSnapshot getSnapshot(Player player) {
        return playerSnapshotMap.get(player.getUniqueId());
    }
}
