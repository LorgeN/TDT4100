package org.tanberg.oving2;

import java.util.Arrays;

public enum Gender {
    MALE('M'), FEMALE('F'), UNKNOWN('\0');

    private final char id;

    Gender(char id) {
        this.id = id;
    }

    public char getId() {
        return this.id;
    }

    public static Gender byId(char id) {
        return Arrays.stream(Gender.values()).filter(gender -> gender.getId() == id).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
