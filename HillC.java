import java.util.function.BiFunction;

public class HillC {

  public static double findMinimum(BiFunction<Double, Double, Double> f) {
    // Initialize the current solution and its function value
    double curX = 0;
    double curY = 0;
    double curF = f.apply(curX, curY);

    // Start with a large step size
    for (double step = 1e6; step > 1e-7;) {
      double bestF = curF;
      double bestX = curX;
      double bestY = curY;
      boolean find = false;

      // Explore neighboring solutions in a hexagonal pattern
      for (int i = 0; i < 6; i++) {
        double a = 2 * Math.PI * i / 6;
        double nextX = curX + step * Math.cos(a);
        double nextY = curY + step * Math.sin(a);
        double nextF = f.apply(nextX, nextY);

        // If a better solution is found, update the best values
        if (bestF > nextF) {
          bestF = nextF;
          bestX = nextX;
          bestY = nextY;
          find = true;
        }
      }

      // If no better solution is found, decrease the step size
      if (!find) {
        step /= 2;
      } else {
        // Update the current solution with the best values
        curX = bestX;
        curY = bestY;
        curF = bestF;
      }
    }
    
    // Print the final minimum solution coordinates
    System.out.println("Minimum solution coordinates: (" + curX + ", " + curY + ")");
    
    // Return the minimum function value
    return curF;
  }

  public static void main(String[] args) {
    // Define the function to minimize ((x - 2)^2 + (y - 3)^2)
    BiFunction<Double, Double, Double> function = (x, y) -> Math.pow(x - 2, 2) + Math.pow(y - 3, 2);

    // Find the minimum of the defined function using the hill climbing algorithm
    double minimumValue = findMinimum(function);
    
    // Print the minimum function value
    System.out.println("Minimum function value: " + minimumValue);
  }
}



































// import java.util.function.BiFunction;

// public class HillC {

//   public static double findMinimum(BiFunction<Double, Double, Double> f) {
//     double curX = 0;
//     double curY = 0;
//     double curF = f.apply(curX, curY);
//     for (double step = 1e6; step > 1e-7;) {
//       double bestF = curF;
//       double bestX = curX;
//       double bestY = curY;
//       boolean find = false;
//       for (int i = 0; i < 6; i++) {
//         double a = 2 * Math.PI * i / 6;
//         double nextX = curX + step * Math.cos(a);
//         double nextY = curY + step * Math.sin(a);
//         double nextF = f.apply(nextX, nextY);
//         if (bestF > nextF) {
//           bestF = nextF;
//           bestX = nextX;
//           bestY = nextY;
//           find = true;
//         }
//       }
//       if (!find) {
//         step /= 2;
//       } else {
//         curX = bestX;
//         curY = bestY;
//         curF = bestF;
//       }
//     }
//     System.out.println(curX + " " + curY);
//     return curF;
//   }

//   public static void main(String[] args) {
//     System.out.println(
//       findMinimum((x, y) -> (x - 2) * (x - 2) + (y - 3) * (y - 3))
//     );
//   }
// }
