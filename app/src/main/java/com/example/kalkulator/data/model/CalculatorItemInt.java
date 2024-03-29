package com.example.kalkulator.data.model;


import com.example.kalkulator.data.model.utils.StringUtils;

public class CalculatorItemInt implements CalculatorPanelItem{

  private final String name;

  public CalculatorItemInt(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String resultOnClick(CalculatorPanelItem previousOperation, String mathText) {
    if(mathText.length() != 0 && mathText.charAt(mathText.length()-1) == '!') {
      return mathText;
    }
    return StringUtils.join(mathText, this.name);
  }
}
