package com.example.kalkulator.data.model.utils;

import android.util.Log;

public class StringUtils {
  public static String EMPTY_STRING = "";
  public static String join(Object... values) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < values.length; i++) {
      sb.append(values[i]);
    }
    return sb.toString();
  }

  public static String removeLastChar( String stringToRemove ) {
    return stringToRemove.substring(0, stringToRemove.length()-1);
  }

  public static String removeCharsByRange( String stringToRemove, int index ) {
    Log.i("TEST", "I am here");
    return stringToRemove.substring(0, stringToRemove.length()-index);
  }
}
