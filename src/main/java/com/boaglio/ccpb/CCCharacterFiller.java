package com.boaglio.ccpb;

import javax.swing.*;

public enum CCCharacterFiller {

    CORAZON1(Icon.CORAZON1),
    CORAZON2(Icon.CORAZON2),
    CORAZON3(Icon.CORAZON3),
    CORAZON4(Icon.CORAZON4),
    BARRIL(Icon.BARRIL),
    MARRETA(Icon.MARRETA),
    MARRETA2(Icon.MARRETA2),
    ;

    private final Icon icon;

    CCCharacterFiller(Icon icon) {
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