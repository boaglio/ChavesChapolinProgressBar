package com.boaglio.ccpb;

import javax.swing.*;
import java.util.Objects;

public enum Icon {

    MADRUGA("Madruga", "/madruga.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/madruga.gif")))),
    CHIQUINHA("Chiquinha", "/chiquinha.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/chiquinha.gif")))),
    CHAPOLIN("Chapolin", "/chapolin.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/chapolin.gif")))),
    BARRIL("Barril", "/barril.png" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/barril.png")))),
    CORAZON1("Corazon1", "/corazon1.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/corazon1.gif")))),
    CORAZON2("Corazon2", "/corazon2.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/corazon2.gif")))),
    CORAZON3("Corazon3", "/corazon3.png" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/corazon3.png")))),
    CORAZON4("Corazon4", "/corazon4.png" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/corazon4.png")))),
    MARRETA("Marreta", "/marreta.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/marreta.gif")))),
    MARRETA2("Marreta2", "/marreta2.png" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/marreta2.png")))),
    CHAVES1("Chaves1", "/chaves1.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/chaves1.gif")))),
    CHAVES2("Chaves2", "/chaves2.gif" , new ImageIcon(Objects.requireNonNull(Icon.class.getResource("/chaves2.gif"))));

    Icon(String description, String file, ImageIcon imageIcon) {
        this.file = file;
        this.description = description;
        this.imageIcon = imageIcon;
    }

    private final String file;
    private final String description;
    private final ImageIcon imageIcon;

    public String getFile() {
        return file;
    }

    public String getDescription() {
        return description;
    }

    public javax.swing.ImageIcon getImageIcon() {
        return imageIcon;
    }
}
