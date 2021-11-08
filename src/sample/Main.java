package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.PixelWriter;
import javafx.stage.Stage;
import java.util.logging.Logger;


public class Main extends Application {
    Controller controller=new Controller();
    private final static Logger log = Logger.getLogger(Main.class.getName());

    private PixelWriter pixelWriter;
    private final double step = 0.01;

    private Complex z = new Complex(0, 0);

    private int X_SIZE = 1000, Y_SIZE = 1000;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mandelbrot or Julia");

        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }


}