
package javafxapplication1;

//import com.sun.prism.paint.Color;
//import java.awt.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {
    public static Group root = new Group();
    
    @Override
    public void start(Stage primaryStage) {
        //Самуйлов А.В.
        Image image;
        String path1 = "image/map.jpg";
        image = new Image(getClass().getResource(path1).toString());
        ImageView imageMap = new ImageView(image);
        //
       
        
        Scene scene = new Scene(root, 1500, 869);
        
        primaryStage.setTitle("Практика 9");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        map map1 = new map();
        aim [] aims  = new aim[2];
        rect [] shapes = new rect[5];
        shapes [0] = new rect(50,50,1,"Zerg1",aims);
        shapes [1] = new rect(150,50,2,"Terran",aims);
        shapes [2] = new rect(200,50,3,"Zerg2",aims);
        shapes [3] = new rect(250,50,4,"Protos",aims);
        shapes [4] = new rect(300,50,5,"Student",aims);
        Control c1 = new Control(shapes);
        aims[0]=new aim("Общий Замес",c1,1);
        aims[1]=new aim("Замес Пехоты",c1,0);
        launch(args);    
    }
    
}
