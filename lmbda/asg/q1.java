package asg;

import java.util.function.*;

class q1 {
  public static void main (String[] args) {
	  
	  BinaryOperator<Double> power = (x, y) -> Math.pow(x, y);
      System.out.println("Result: " + power.apply(2.0, 3.0));
}
  }
