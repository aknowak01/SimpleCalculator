package com.example.kalkulator.ui.views;

import com.example.kalkulator.data.model.CalculatorItemInt;
import com.example.kalkulator.data.model.CalculatorItemSumOperation;
import com.example.kalkulator.data.model.CalculatorPanelItem;
import com.example.kalkulator.data.model.CalculatorStrongOperation;
import com.example.kalkulator.data.model.utils.MathUtils;
import com.example.kalkulator.data.model.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
  private CalculatorActivity activity;
  private CalculatorPanelItem previousOperation;
  private List<String> contentPreviousOperations;

  public CalculatorController(CalculatorActivity activity) {
    this.contentPreviousOperations = new ArrayList<>();
    this.activity = activity;
  }

  public void updateNotepad(CalculatorPanelItem panelItem) {
    String mathText = activity.notepad.getText().toString();
    String result = panelItem.resultOnClick( previousOperation, mathText);
    if( result == null ) return;

    if(panelItem instanceof CalculatorItemSumOperation) {
      if( !MathUtils.isInt(mathText.charAt(mathText.length()-1)) && !MathUtils.isEquationSkip(mathText.charAt(mathText.length()-1))) {
        mathText = StringUtils.removeLastChar(mathText);
      }
      this.contentPreviousOperations.add(StringUtils.join(mathText, "=", result));
      activity.previousOperationAdapter.update(this.contentPreviousOperations);
      activity.listPreviousOperation.smoothScrollToPosition(contentPreviousOperations.size());
    }
    activity.update(result);
    char lastChar = 0;
    if(mathText.length() != 0) {
      lastChar = mathText.charAt(mathText.length() - 1);
    }
    if( !(panelItem instanceof CalculatorItemInt) && lastChar != 0 && MathUtils.isInt(lastChar)) {
      previousOperation = new CalculatorItemInt(String.valueOf(lastChar));
    } else if(panelItem instanceof CalculatorStrongOperation) {
      return;
    } else {
      previousOperation = panelItem;
    }
  }
}
