package sample;


public class ConvergenceCalculator {
public static int power;


        public int calculateConvergence(Complex c, Complex z, int steps) {
            int i = 0;
            while(i < steps) {
                z=z.power(power);
                z.add(c);

                if (z.abs() >= 4.0) {
                    break;
                }
                i++;
            }
            return i;
        }

    }

