package com.boaglio.ccpb;

import javax.swing.*;

public enum CCCharacter {

    CHAPOLIN(Icon.CHAPOLIN),
    CHAVES1(Icon.CHAVES1),
    CHAVES2(Icon.CHAVES2),
    MADRUGA(Icon.MADRUGA),
    CHIQUINHA(Icon.CHIQUINHA)
    ;

    private final Icon icon;

    CCCharacter(Icon icon) {
        this.icon = icon;
    }

    public String getDisplayName() {
        return icon.getDescription();
    }
    public ImageIcon getIcon() {
        return icon.getImageIcon();
    }

    public String file() {
        return icon.getFile();
    }
}