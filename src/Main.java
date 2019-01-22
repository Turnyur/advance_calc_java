
import java.awt.Image;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turnyur Siy
 */
public class Main extends Application {
     private static Stage stage;
     
     
     
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
       // Parent root=FXMLLoader.load(getClass().getResource("AdvanceCalculator.fxml"));
       
       // Scene scene=new Scene(root);
       
        //scene.getStylesheets().add("AdvanceCalculator.css");
        stage.setTitle("Advance Calculator");
        //primaryStage.setScene(scene);
         gotoLogin();
         primaryStage.sizeToScene();
        primaryStage.show();
        
 }
    private void gotoLogin() {
        try {/*
            AdvanceCalculatorController login = 
                    (AdvanceCalculatorController)*/ replaceSceneContent("AdvanceCalculator.fxml","AdvanceCalculator.css");
            //login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void  gotoAboutUs(ActionEvent event) throws Exception{ 
                
                 Main.replaceSceneContent("AdvanceCalculator.fxml","AdvanceCalculator.css");
        
            
    }

    
    public static void helpAbout_us_handler(){
        
    }
    
   public static Initializable replaceSceneContent(String fxml,String style) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        VBox root;
        try {
            root = (VBox) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene=new Scene(root,350,515);
        scene.getStylesheets().add(style);
        stage.setScene(scene);
        //stage.sizeToScene();
        stage.setResizable(false);
        stage.getIcons().add( new javafx.scene.image.Image("calculator-icon.png"));
        return (Initializable) loader.getController();
    } 
    
    
}
