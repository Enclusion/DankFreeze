package com.buzznacker.freeze.manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FrozenManager {

    private Set<UUID> frozenUUIDs;

    public FrozenManager() {
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
