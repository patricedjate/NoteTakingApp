package ci.pigier.controllers.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ci.pigier.controllers.BaseController;
import ci.pigier.model.Note;
import ci.pigier.ui.FXMLPage;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.noteService;

public class ListNotesUIController extends BaseController implements Initializable {

    @FXML
    private TableColumn<?, ?> descriptionTc;

    @FXML
    private Label notesCount;

    @FXML
    private TableView<Note> notesListTable;

    @FXML
    private TextField searchNotes;

    @FXML
    private TableColumn<?, ?> titleTc;

    @FXML
    void doDelete() {
    	Note selectedNote = notesListTable.getSelectionModel().getSelectedItem();
    	  if (selectedNote != null) {
		  //supprimer les données en base
    		  NoteService.deleteNote(selectedNote);
    	        notesListTable.getItems().remove(selectedNote);
    	        notesCount.setText(NoteService.countNote()+" Notes");
    	    }
	       
    }

    @FXML
    void doEdit(ActionEvent event) throws IOException {
    	Note selectedNote = notesListTable.getSelectionModel().getSelectedItem();
    	navigate(event, FXMLPage.EDIT.getPage());
    }

    @FXML
    void newNote(ActionEvent event) throws IOException {
    	editNote = null;
    	navigate(event, FXMLPage.ADD.getPage());
    }
    private noteService NoteService = new noteService();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//recuperer les données en bd
		notesListTable.setItems(NoteService.getNotes());
		titleTc.setCellValueFactory(new PropertyValueFactory<>("title"));
		descriptionTc.setCellValueFactory(new
		PropertyValueFactory<>("description"));
		notesCount.setText(NoteService.countNote()+" Notes");
		
		//notesListTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showNoteDetails(newValue));
	}
	 
	

}
