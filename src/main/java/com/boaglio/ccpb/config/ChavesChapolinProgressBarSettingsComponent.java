package com.boaglio.ccpb.config;// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.


import com.boaglio.ccpb.CCCharacterFiller;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import com.intellij.util.ui.UIUtil;
import com.boaglio.ccpb.CCCharacter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static com.boaglio.ccpb.CCCharacter.*;
import static com.boaglio.ccpb.CCCharacterFiller.*;


public class ChavesChapolinProgressBarSettingsComponent {

    private final JPanel configMainPanel;
    private final List<JBRadioButton> charactersRadioButtonsDP = new ArrayList<>();
    private final List<JBRadioButton> charactersRadioButtonsIP = new ArrayList<>();
    private final List<JBRadioButton> charactersRadioButtonsFiller = new ArrayList<>();

    public ChavesChapolinProgressBarSettingsComponent() {
        // determinate progress
        JBLabel titleDP = new JBLabel("Choose your character for determinate progress:", UIUtil.ComponentStyle.REGULAR);
        ButtonGroup characterSelectGroupDP = new ButtonGroup();
        FormBuilder formBuilder = FormBuilder.createFormBuilder().addComponent(titleDP);
        for (CCCharacter character : CCCharacter.values()) {
            JBRadioButton radioButtonDP = new JBRadioButton(character.getDisplayName());
            characterSelectGroupDP.add(radioButtonDP);
            charactersRadioButtonsDP.add(radioButtonDP);
            formBuilder.addLabeledComponent(new JLabel(character.getIcon()), radioButtonDP);
        }
        // undeterminate progress
        JBLabel titleIP = new JBLabel("Choose your character for indeterminate progress:", UIUtil.ComponentStyle.REGULAR);
        ButtonGroup characterSelectGroupIP = new ButtonGroup();
        formBuilder.addComponent(titleIP);
        for (CCCharacter character : CCCharacter.values()) {
            JBRadioButton radioButtonIP = new JBRadioButton(character.getDisplayName());
            characterSelectGroupIP.add(radioButtonIP);
            charactersRadioButtonsIP.add(radioButtonIP);
            formBuilder.addLabeledComponent(new JLabel(character.getIcon()), radioButtonIP);
        }
        // filler
        JBLabel titleFiller = new JBLabel("Choose your character for filler progress:", UIUtil.ComponentStyle.REGULAR);
        ButtonGroup characterSelectGroupFiller = new ButtonGroup();
        formBuilder.addComponent(titleFiller);
        for (CCCharacterFiller character : CCCharacterFiller.values()) {
            JBRadioButton radioButtonFiller = new JBRadioButton(character.getDisplayName());
            characterSelectGroupFiller.add(radioButtonFiller);
            charactersRadioButtonsFiller.add(radioButtonFiller);
            formBuilder.addLabeledComponent(new JLabel(character.getIcon()), radioButtonFiller);
        }
        configMainPanel = formBuilder.addComponentFillVertically(new JPanel(), 0).getPanel();
    }

    public JPanel getPanel() {
        return configMainPanel;
    }

    @NotNull
    public CCCharacter getChosenCharacterDP() {
        return charactersRadioButtonsDP.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(radioButton -> CCCharacter.valueOf(radioButton.getText().toUpperCase()))
                .orElse(CHAPOLIN);
    }

    @NotNull
    public CCCharacter getChosenCharacterIP() {
        return charactersRadioButtonsIP.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(radioButton -> CCCharacter.valueOf(radioButton.getText().toUpperCase()))
                .orElse(CHAVES1);
    }

    @NotNull
    public CCCharacterFiller getChosenCharacterFiller() {
        return charactersRadioButtonsFiller.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(radioButton -> CCCharacterFiller.valueOf(radioButton.getText().toUpperCase()))
                .orElse(CORAZON1);
    }

    public void setChosenCharacterDP(@NotNull CCCharacter character) {
        for (JBRadioButton charactersRadioButton : charactersRadioButtonsDP) {
            charactersRadioButton.setSelected(character.name().equals(charactersRadioButton.getText().toUpperCase()));
        }
    }

    public void setChosenCharacterIP(@NotNull CCCharacter character) {
        for (JBRadioButton charactersRadioButton : charactersRadioButtonsIP) {
            charactersRadioButton.setSelected(character.name().equals(charactersRadioButton.getText().toUpperCase()));
        }
    }

    public void setChosenCharacterFiller(@NotNull CCCharacterFiller character) {
        for (JBRadioButton charactersRadioButton : charactersRadioButtonsFiller) {
            charactersRadioButton.setSelected(character.name().equals(charactersRadioButton.getText().toUpperCase()));
        }
    }

}