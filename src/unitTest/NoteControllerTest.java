package unitTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import ci.pigier.controllers.ui.AddEditUIController;
import ci.pigier.controllers.ui.ListNotesUIController;
import ci.pigier.model.Note;
import dbconnection.DatabaseConnection;
import service.noteService;

public class NoteControllerTest {
	 private AddEditUIController addNoteController;
	 private ListNotesUIController listNoteController;
	 private noteService NoteService;
	    @Before
	    public void setUp() {
	    	addNoteController = new AddEditUIController();
	    	listNoteController = new ListNotesUIController();
	    }

	    @Test
	//test unitaire créer une note en bd
	    public void testCreateNote() {
	        Note note = new Note();
	        note.setTitle("Test Titre");
	        note.setDescription("Test Description");
	        assertNotNull(note);
	    }
	    @Test
	//test unitaire connection bd
	    public void testDatabaseConnection() throws SQLException {
	        DatabaseConnection dbConnection = new DatabaseConnection();
	        assertNotNull(DatabaseConnection.getConnection());
	    }
	    @Test
	// test unitaire suuprimer les données en base
	    public void clearDatabase() {
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement("DELETE FROM note")) {
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	  
}
