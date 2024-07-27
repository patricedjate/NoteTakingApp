package ci.pigier;

import ci.pigier.ui.FXMLPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class NoteTakingApp extends Application {

	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(FXMLPage.LIST.getPage());
        
        Scene scene = new Scene(root);
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        stage.getIcons().add(icon);
     
        stage.setScene(scene);
        stage.setTitle("P'Note-Taking Application v1.0.0");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}
