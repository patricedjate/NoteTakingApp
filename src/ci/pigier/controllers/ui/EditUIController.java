package ci.pigier.controllers.ui;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import ci.pigier.controllers.BaseController;
import ci.pigier.model.Note;
import ci.pigier.ui.FXMLPage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.noteService;


public class EditUIController extends BaseController implements Initializable {

    @FXML
    private TextArea descriptionTxtArea;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField titleTxtFld;
    private noteService NoteService = new noteService();
    @FXML
    void doBack(ActionEvent event) throws IOException {
    	navigate(event, FXMLPage.LIST.getPage());
    }
    @FXML
    public void initialize() {
    	/*
        saveBtn.setOnAction(e -> {
			try {
				doSave();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		*/
        
    }
    @FXML
    void doClear(ActionEvent event) {
    	titleTxtFld.setText("");
    	descriptionTxtArea.setText("");
    }

    @FXML
    void doSave(Event event) throws IOException {
    	 Note note = new Note();
         note.setTitle(titleTxtFld.getText());
         note.setDescription(descriptionTxtArea.getText());
         noteService.addNote(note);
         navigate(event, FXMLPage.LIST.getPage());
        //data.add(new Note(titleTxtFld.getText(), descriptionTxtArea.getText()));
        //navigate(event, FXMLPage.LIST.getPage());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    if (Objects.nonNull(editNote)) {
	        titleTxtFld.setText(editNote.getTitle());
	        descriptionTxtArea.setText(editNote.getDescription());
	        saveBtn.setText("Mettre à jour");
	    }
	}

}
