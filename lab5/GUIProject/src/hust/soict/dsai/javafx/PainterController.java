package hust.soict.dsai.javafx;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	 @FXML
	    private Pane drawingAreaPane;
	 
	 @FXML
	    private RadioButton choice;
	 
	  @FXML
	    private ToggleGroup choiceTools;
	  @FXML
	    private RadioButton choice2;
	  
	    @FXML
	    void drawingAreaMouseDragged(MouseEvent event) {
	    	Circle newCircle = new Circle(event.getX(),event.getY(), 4,Color.BLACK);
	    	drawingAreaPane.getChildren().add(newCircle);
	    }

	    @FXML
	    void clearButtonPressed(ActionEvent event) {
	    	drawingAreaPane.getChildren().clear();
	    }

	    @FXML
	    void getChoice(ActionEvent event) {
	    	if(choice.isSelected()) {
	    		drawingAreaPane.setOnMouseDragged(this::drawingAreaMouseDragged);
	    	}
	    	if (choice2.isSelected()) {
	    		drawingAreaPane.setOnMouseDragged(this::drawWhite);
	    	}
	    }
	    @FXML
	    void drawWhite(MouseEvent event) {
	    	Circle newCircle = new Circle(event.getX(),event.getY(), 10,Color.WHITE);
	    	drawingAreaPane.getChildren().add(newCircle);
	    }
}
