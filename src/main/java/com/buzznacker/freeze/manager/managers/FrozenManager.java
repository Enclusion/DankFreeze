package com.buzznacker.freeze.manager.managers;

import com.buzznacker.freeze.Freeze;
import com.buzznacker.freeze.manager.Manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FrozenManager extends Manager {

    private Set<UUID> frozenUUIDs;

    public FrozenManager(Freeze plugin) {
        super(plugin);
        frozenUUIDs = new HashSet<>();
    }

    public void freezeUUID(UUID uuid) {
        frozenUUIDs.add(uuid);
    }

    public void unfreezeUUID(UUID uuid) {
        frozenUUIDs.remove(uuid);
    }

    public boolean isFrozen(UUID uuid) {
        return frozenUUIDs.contains(uuid);
    }
}
