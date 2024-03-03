package com.boaglio.ccpb.config;

import com.boaglio.ccpb.CCCharacterFiller;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.boaglio.ccpb.CCCharacter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.boaglio.ccpb.CCCharacter.*;
import static com.boaglio.ccpb.CCCharacterFiller.CORAZON1;
import static com.boaglio.ccpb.CCCharacterFiller.CORAZON3;


@State(
        name = "com.boaglio.ccpb.config.ChavesChapolinProgressBarSettingsState",
        storages = @Storage("ChavesChapolinProgressBarPluginSettings.xml")
)
public class ChavesChapolinProgressBarSettingsState implements PersistentStateComponent<ChavesChapolinProgressBarSettingsState> {

  public CCCharacter selectedCharacterDP = CHAPOLIN;
  public CCCharacter selectedCharacterIP = CHAVES1;
  public CCCharacterFiller selectedCharacterFiller = CORAZON3;

  public static ChavesChapolinProgressBarSettingsState getInstance() {
    return ApplicationManager.getApplication().getService(ChavesChapolinProgressBarSettingsState.class);
  }

  @Nullable
  @Override
  public ChavesChapolinProgressBarSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull ChavesChapolinProgressBarSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}