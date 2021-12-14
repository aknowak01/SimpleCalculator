package com.example.kalkulator.data.model;

public interface CalculatorPanelItem {
  String getName();
  String resultOnClick( CalculatorPanelItem previousOperation, String mathText );
}
