package com.boaglio.ccpb.config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ChavesChapolinProgressBarConfigurable implements Configurable {

  private ChavesChapolinProgressBarSettingsComponent mySettingsComponent;

  // A default constructor with no arguments is required because this implementation
  // is registered as an applicationConfigurable EP

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "Chaves Chapolin Progress Bar";
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    mySettingsComponent = new ChavesChapolinProgressBarSettingsComponent();
    return mySettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    ChavesChapolinProgressBarSettingsState settings = ChavesChapolinProgressBarSettingsState.getInstance();
    boolean modifiedDP = !mySettingsComponent.getChosenCharacterDP().equals(settings.selectedCharacterDP);
    modifiedDP |= mySettingsComponent.getChosenCharacterDP() != settings.selectedCharacterDP;

    boolean modifiedIP = !mySettingsComponent.getChosenCharacterIP().equals(settings.selectedCharacterIP);
    modifiedIP |= mySettingsComponent.getChosenCharacterIP() != settings.selectedCharacterIP;

    boolean modifiedFiller = !mySettingsComponent.getChosenCharacterFiller().equals(settings.selectedCharacterFiller);
    modifiedFiller |= mySettingsComponent.getChosenCharacterFiller() != settings.selectedCharacterFiller;

    return modifiedIP && modifiedDP && modifiedFiller;
  }

  @Override
  public void apply() {
    ChavesChapolinProgressBarSettingsState settings = ChavesChapolinProgressBarSettingsState.getInstance();
    settings.selectedCharacterIP = mySettingsComponent.getChosenCharacterIP();
    settings.selectedCharacterDP = mySettingsComponent.getChosenCharacterDP();
    settings.selectedCharacterFiller = mySettingsComponent.getChosenCharacterFiller();
  }

  @Override
  public void reset() {
    ChavesChapolinProgressBarSettingsState settings = ChavesChapolinProgressBarSettingsState.getInstance();
    mySettingsComponent.setChosenCharacterDP(settings.selectedCharacterDP);
    mySettingsComponent.setChosenCharacterIP(settings.selectedCharacterIP);
    mySettingsComponent.setChosenCharacterFiller(settings.selectedCharacterFiller);
  }

  @Override
  public void disposeUIResources() {
    mySettingsComponent = null;
  }

}