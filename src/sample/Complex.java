package sample;


public class Complex {

    private double real;
    private double imaginary;

    public Complex(double re, double im) {
        real = re;
        imaginary = im;
    }
    public Complex() {

    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public static Complex mul(Complex a, Complex b) {
        Complex c = new Complex();
        c.setReal(a.real * b.real - a.imaginary * b.imaginary);
        c.setImaginary(a.real * b.imaginary + a.imaginary * b.real);
        return c;
    }
    public Complex power(int n) {
        if(n==1)
            return this;
        else return mul(this,this.power(n-1));

    }
    public Complex add(Complex b) {
        this.real = this.real + b.real;
        this.imaginary = this.imaginary + b.imaginary;
        return this;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double abs() {
        return real * real + imaginary * imaginary;
    }
}