/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	 exports hust.soict.dsai.javafx;

	    opens hust.soict.dsai.javafx to javafx.fxml;
}