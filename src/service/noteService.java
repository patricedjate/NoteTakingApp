package service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ci.pigier.model.Note;
import dbconnection.DatabaseConnection;
public class noteService {

	private static ObservableList<Note> notes = FXCollections.observableArrayList();

    public static ObservableList<Note> getNotes() {
        notes.clear();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM note");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Note note = new Note();
                note.setTitle(rs.getString("title"));
                note.setDescription(rs.getString("description"));
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public static void addNote(Note note) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO note (title, description) VALUES (?, ?)")) {
            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNote(Note note) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE note SET title = ?, description = ? WHERE id = ?")) {

            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getDescription());
            stmt.setInt(3, note.getId());
            stmt.executeUpdate();
            getNotes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNote(Note note) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM note WHERE title = ?")) {

            stmt.setString(1, note.getTitle());
            stmt.executeUpdate();
            getNotes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int countNote() {
    	int nbre = 0;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM note");
        	ResultSet rs = stmt.executeQuery()) {
        	if (rs.next()) {
        		int nbreElement = rs.getInt(1);
        		nbre = nbreElement;
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbre;
    }
}
