package sample;

import javafx.scene.paint.Color;


public class MandelbrotSet {

    private double reMin, reMax, imMin, imMax, z = 0.0, zi = 0.0;
    private int convergenceSteps = 128;

    private Color convergenceColor = Color.BLACK;

    public boolean isMandelbrot() {
        return z == 0 && zi == 0;
    }

    public double getReMin() {
        return reMin;
    }

    public double getReMax() {
        return reMax;
    }

    public double getImMin() {
        return imMin;
    }

    public double getImMax() {
        return imMax;
    }

    public double getZ() {
        return z;
    }

    public double getZi() {
        return zi;
    }

    public int getConvergenceSteps() {
        return convergenceSteps;
    }

    public Color getConvergenceColor() {
        return convergenceColor;
    }

    public MandelbrotSet(Complex min, Complex max, Complex z) {
        reMin = min.getReal();
        imMin = min.getImaginary();
        reMax = max.getReal();
        imMax = max.getImaginary();
        this.z = z.getReal();
        zi = z.getImaginary();
    }
}