package com.gs.self.calculator;

public class CalculatorFactory {
  public Calculate getOperation(char symbol) throws Exception {
    if (symbol == '+') {
      return new Add();
    } else if (symbol == '-') {
      return new Subtract();
    }else if(symbol == '*') {
      return new Multiple();
    }else {
      throw new Exception("Unable to determine operation !!!" + symbol);
    }
  }
}
