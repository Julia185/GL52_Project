package fr.utbm.gl52.proj.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.service.ClientService;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
    	double width = 685;
		double height = 1010;
		
		try {
			 scene = new Scene(loadFXML("mainScene"), height, width);
		        stage.setScene(scene);
		        stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

    	ClientService service  = new ClientService();
        for (Client c : service.getAllClient() ) {
			System.out.println(c.toString());
		}
        launch();
    }
    
   

}