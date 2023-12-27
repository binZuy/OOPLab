package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.store.Store;

import java.awt.*;

public class AddDigitalVideoDiscToStore extends AddItemToStore {
    private JTextField txtTitle;
    private JTextField txtCategory;
    private JTextField txtDirector;
    private JTextField txtCost;

    public AddDigitalVideoDiscToStore(Store store) {
        super(store);
    }

    @Override
    protected void setupItemSpecificComponents() {
        JPanel specificPanel = new JPanel(new GridLayout(4, 2));

        // Add components for DigitalVideoDisc specific attributes
        specificPanel.add(new JLabel("Title:"));
        txtTitle = new JTextField();
        specificPanel.add(txtTitle);

        specificPanel.add(new JLabel("Category:"));
        txtCategory = new JTextField();
        specificPanel.add(txtCategory);

        specificPanel.add(new JLabel("Director:"));
        txtDirector = new JTextField();
        specificPanel.add(txtDirector);

        specificPanel.add(new JLabel("Cost:"));
        txtCost = new JTextField();
        specificPanel.add(txtCost);

        // Add the specific panel to the main content pane
        add(specificPanel, BorderLayout.CENTER);
    }

    @Override
    protected void handleAddItem() {
        // Retrieve values from text fields
        String title = txtTitle.getText();
        String category = txtCategory.getText();
        String director = txtDirector.getText();
        float cost = Float.parseFloat(txtCost.getText());

        try {
            cost = Float.parseFloat(txtCost.getText());
        } catch (NumberFormatException e) {
            // Handle the case where the user entered an invalid float value for cost
            JOptionPane.showMessageDialog(this, "Invalid cost value. Please enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Create a new DigitalVideoDisc object with the entered values
        DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, cost);

        // Add the new DVD to the store
        store.addMedia(newDVD);

        // Close the current window
        dispose();
    }
}

