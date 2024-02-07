package explination;

import java.util.function.UnaryOperator;

public class Main {
  /*
   * public interface Function<T,R>.
   * basicly it use to replace things.
   * it has a method that is replace all.
   * 
   * public interface UnaryOperator extends Function<T,R>.
   * UnaryOperator inherit the apply() from Function<T,R>.
   */

  public static void main(String[] args) {
    // Main main = new Main();
    // Main().run();
    
    new Main().run();
    
    
  }
  public void run() {
    // System.out.println(!true);
    
    calculate(8, n -> n*n);   // it returns internally
    calculate(8, n -> n+2);   
    calculate(10, n -> n/3);
    
  }
  public void calculate(double value, UnaryOperator<Double> process) {
    double result = process.apply(value);
    System.out.println(result);
  }

}
