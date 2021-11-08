package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;


import javafx.application.Platform;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    private final double step = 0.01;
    private final static Logger log = Logger.getLogger(Main.class.getName());

    private PixelWriter pixelWriter;


    private Complex z = new Complex(0, 0);

    private int X_SIZE = 1000, Y_SIZE = 1000;





    @FXML
    private Button rplus;

    @FXML
    private Button rminus;

    @FXML
    private Button iplus;

    @FXML
    private Button iminus;

    @FXML
    private Label label;

    @FXML
    private TextField tf;

    @FXML
    private ImageView imageView;

    public void redrawFractal(Complex z) {
        MandelbrotSet fractal;
        double MIN_R = -2;
        double MIN_I = -2;
        double MAX_R = 2;
        double MAX_I = 2;
        fractal = new MandelbrotSet(new Complex(MIN_R, MIN_I), new Complex(MAX_R, MAX_I), z);
        ConvergenceCalculator service = new ConvergenceCalculator();
        FractalPainter painter = new FractalPainter(service);
        ExecutorService exec = Executors.newFixedThreadPool(1);

        long startTime = System.currentTimeMillis();
        exec.submit(() -> Platform.runLater(() -> painter.drawFractal(0, X_SIZE - 1, pixelWriter, fractal, X_SIZE, Y_SIZE)));
        long endTime = System.currentTimeMillis();
        exec.shutdown();

        log.finer("done in " + (endTime - startTime) + "ms");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        WritableImage writableImage = new WritableImage(X_SIZE, Y_SIZE);
        pixelWriter = writableImage.getPixelWriter();
        imageView.setImage(writableImage);
        redrawFractal(new Complex());
        label.setVisible(false);
        tf.setText("2");
        ConvergenceCalculator.power=Integer.parseInt(tf.getText());;

    }


    public void rplusAction() {
        z.setReal(z.getReal() + step);
        redrawFractal(z);
        label.setText("r = " + z.getReal() + ", " + z.getImaginary() + "i");
    }

    public void rminusAction() {
        z.setReal(z.getReal() - step);
        redrawFractal(z);
        label.setText("r = " + z.getReal() + ", " + z.getImaginary() + "i");
    }

    public void iplusAction() {
        z.setImaginary(z.getImaginary() + step);
        redrawFractal(z);
        label.setText("r = " + z.getReal() + ", " + z.getImaginary() + "i");
    }

    public void iminusAction() {
        z.setImaginary(z.getImaginary() - step);
        redrawFractal(z);
        label.setText("r = " + z.getReal() + ", " + z.getImaginary() + "i");
    }

    public void resetAction() {
        ConvergenceCalculator.power=Integer.parseInt(tf.getText());
        z = new Complex(0, 0);
        redrawFractal(z);
        label.setVisible(false);
        rplus.setVisible(false);
        rminus.setVisible(false);
        iplus.setVisible(false);
        iminus.setVisible(false);

    }

    public void juliaAction() {
        ConvergenceCalculator.power=Integer.parseInt(tf.getText());
        z = new Complex(1, 0.3);
        redrawFractal(z);
        label.setVisible(true);
        label.setText("r = " + z.getReal() + ", " + z.getImaginary() + "i");
        rplus.setVisible(true);
        rminus.setVisible(true);
        iplus.setVisible(true);
        iminus.setVisible(true);

    }

}
