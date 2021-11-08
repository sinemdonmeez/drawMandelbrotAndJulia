package sample;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;


public class FractalPainter {

    private ConvergenceCalculator calculator;

    public FractalPainter(ConvergenceCalculator calculator) {
        this.calculator = calculator;
    }

    public void drawFractal(int start, int end, PixelWriter writer, MandelbrotSet fractal, int X_SIZE, int Y_SIZE) {
        double precision = Math.max(
                (fractal.getReMax() - fractal.getReMin()) / X_SIZE,
                (fractal.getImMax() - fractal.getImMin()) / Y_SIZE);

        double convergenceVal;
        for (double c = fractal.getReMin() + (precision * start), xR = start; xR <= end; c += precision, xR++) {
            for (double ci = fractal.getImMin(), yR = 0; yR < Y_SIZE; ci += precision, yR++) {
                if (fractal.isMandelbrot()) {
                    convergenceVal = calculator.calculateConvergence(new Complex(c, ci), new Complex(fractal.getZ(), fractal.getZi()), fractal.getConvergenceSteps());
                } else { // isJulia
                    convergenceVal = calculator.calculateConvergence(new Complex(fractal.getZi(), fractal.getZ()), new Complex(ci, c), fractal.getConvergenceSteps());
                }

                double t1 =  convergenceVal / fractal.getConvergenceSteps();
                double withGamma = ( (t1 - 1) * (t1 - 1) * (t1 - 1) * (t1 - 1));




                if (convergenceVal < fractal.getConvergenceSteps())
                    writer.setColor((int)xR, (int)yR, Color.color(Math.abs(withGamma-0.3),Math.abs(withGamma-0.4) , Math.abs(withGamma-0.1) ));
                else
                    writer.setColor((int)xR, (int)yR, fractal.getConvergenceColor());
            }
        }

    }
}