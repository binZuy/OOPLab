package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStore extends JFrame {
    protected Store store;

    public AddItemToStore(Store store) {
        this.store = store;

        // Create and set up the GUI components
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        // Add common components or layout for all adding screens

        // Call a method to set up components specific to each item type
        setupItemSpecificComponents();

        // Add common buttons or controls for all adding screens
        add(createCommonButtons(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    // Abstract method to be implemented by subclasses for item-specific components
    protected abstract void setupItemSpecificComponents();

    // Method to create common buttons for all adding screens
    private JPanel createCommonButtons() {
        JPanel buttonPanel = new JPanel();
        JButton btnAddItem = new JButton("Add Item");
        JButton btnCancel = new JButton("Cancel");

        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call a method to handle the addition of the item to the store
                handleAddItem();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame if "Cancel" is clicked
            }
        });

        buttonPanel.add(btnAddItem);
        buttonPanel.add(btnCancel);

        return buttonPanel;
    }

    // Abstract method to be implemented by subclasses for handling item addition
    protected abstract void handleAddItem();
}

