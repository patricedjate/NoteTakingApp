module NoteTakingApp09072024 {
		requires transitive javafx.graphics;
		requires javafx.base;
		requires javafx.fxml;
		requires javafx.controls;
		requires junit;
		requires java.sql;
		opens ci.pigier to javafx.fxml;
		opens ci.pigier.controllers.ui to javafx.fxml;
		opens ci.pigier.model to javafx.fxml;
		opens unitTest to junit;
		exports unitTest;
		exports ci.pigier;
		exports ci.pigier.controllers.ui;
		exports ci.pigier.model;
	}