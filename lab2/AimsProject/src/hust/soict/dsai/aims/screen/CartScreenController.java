package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.cart.Cart;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {
	
	private Cart cart;
	
    @FXML
    private TableView<Media> tblMedia;
    
    @FXML 
    private Button btnPlay;
    
    @FXML 
    private Button btnRemove;
    
    @FXML
    private TextField tfFilter;
    
    @FXML 
    private RadioButton radiobtnFilterId;

    @FXML 
    private RadioButton radiobtnFilterTitle;
    
    @FXML 
    private Label lbTotalCost;
    
    @FXML 
    private Button btnPlaceOrder;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart= cart;
    }
    
    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media,String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media,String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media,Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue,
    						Media newValue) {
    					if(newValue != null) {
    						updateButtonBar(newValue);
    					}
    				}
    			});
    	
    	FilteredList<Media> filteredMediaList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
    	tblMedia.setItems(filteredMediaList);
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> 
    		observable, String oldValue, String newValue) {
    			filteredMediaList.setPredicate(media -> {
                    if (newValue == null || newValue.trim().isEmpty()) {
                        return true;
                    }
                        String lowerCaseFilter = newValue.toLowerCase();
                        return String.valueOf(media.getId()).contains(lowerCaseFilter) ||
                                media.getTitle().toLowerCase().contains(lowerCaseFilter);
                        });
    			}
    		});
    	updateTotalCost(cart);
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateTotalCost(cart);
    }
    
    public void updateTotalCost(Cart cart) {
    	lbTotalCost.setText(cart.totalCost() +" $");
    }
    
    @FXML
    void btnOrderPressed(ActionEvent event) {
    	cart.emptyCart();
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Success");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully!");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.showAndWait();
    }
}