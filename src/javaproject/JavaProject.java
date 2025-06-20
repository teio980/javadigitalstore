package javaproject;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class JavaProject extends JFrame implements ActionListener{
    
    private void mainMenu(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Welcome to Lk digital store.");
        titleLabel.setHorizontalAlignment(JLabel.CENTER); 
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32)); 
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/electronics.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("FILE");
        
        JMenuItem back = new JMenuItem("Back");
        JMenuItem exit = new JMenuItem("Exit");
        
        back.addActionListener(this);
        exit.addActionListener(this);
        
        back.setActionCommand("Back");
        exit.setActionCommand("Exit");
        
        fileMenu.add(back);
        fileMenu.add(exit);
        
        menuBar.add(fileMenu);
        
        setJMenuBar(menuBar);
        
        JButton add_L_Button = new JButton("Add Laptop");
        JButton add_H_Button = new JButton("Add Handphone");
        JButton displayButton = new JButton("Display Product");
        JButton delete_L_Button = new JButton("Delete Laptop");
        JButton delete_H_Button = new JButton("Delete Handphone");
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        add_L_Button.setFont(buttonFont);
        add_H_Button.setFont(buttonFont);
        displayButton.setFont(buttonFont);
        delete_L_Button.setFont(buttonFont);
        delete_H_Button.setFont(buttonFont);
        
        add_L_Button.setIcon(new ImageIcon(getClass().getResource("/image/computer_icon.png")));
        add_L_Button.setPreferredSize(new Dimension(208, 52));
        add_L_Button.setBackground(new Color(0, 120, 215));
        add_L_Button.setForeground(Color.WHITE);
        add_L_Button.setOpaque(true);
        add_L_Button.setBorderPainted(false);
        
        add_H_Button.setIcon(new ImageIcon(getClass().getResource("/image/phone_android_icon.png")));
        add_H_Button.setPreferredSize(new Dimension(208, 52));
        add_H_Button.setBackground(new Color(0, 120, 215));
        add_H_Button.setForeground(Color.WHITE);
        add_H_Button.setOpaque(true);
        add_H_Button.setBorderPainted(false);
        
        displayButton.setIcon(new ImageIcon(getClass().getResource("/image/table_view_icon.png")));
        displayButton.setPreferredSize(new Dimension(208, 52));
        displayButton.setBackground(new Color(0, 120, 215));
        displayButton.setForeground(Color.WHITE);
        displayButton.setOpaque(true);
        displayButton.setBorderPainted(false);
        
        JPanel southPanel = new JPanel(new GridLayout(2, 1));

        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        firstRow.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        firstRow.add(add_L_Button);
        firstRow.add(add_H_Button);
        firstRow.add(displayButton);

        
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/image/rubbish.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        delete_L_Button.setIcon(new ImageIcon(scaledImage));
        delete_L_Button.setPreferredSize(new Dimension(208, 52));
        delete_L_Button.setBackground(new Color(0, 120, 215));
        delete_L_Button.setForeground(Color.WHITE);
        delete_L_Button.setOpaque(true);
        delete_L_Button.setBorderPainted(false);
        
        delete_H_Button.setIcon(new ImageIcon(scaledImage));
        delete_H_Button.setPreferredSize(new Dimension(208, 52));
        delete_H_Button.setBackground(new Color(0, 120, 215));
        delete_H_Button.setForeground(Color.WHITE);
        delete_H_Button.setOpaque(true);
        delete_H_Button.setBorderPainted(false);

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        secondRow.add(delete_L_Button);
        secondRow.add(delete_H_Button);

        southPanel.add(firstRow);
        southPanel.add(secondRow);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);

        add_L_Button.addActionListener(e -> addLaptop());
        add_H_Button.addActionListener(e -> addHandphone());
        displayButton.addActionListener(e -> displayProduct());
        delete_L_Button.addActionListener(e -> deleteLaptop());
        delete_H_Button.addActionListener(e -> deleteHandphone());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "Back":
                getContentPane().removeAll();
                mainMenu();
                revalidate();
                repaint();
                break;
            case "Exit":
                int confirm = JOptionPane.showConfirmDialog(
                    this, 
                    "Are you sure you want to exit?", 
                    "Exit Confirmation", 
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
        }
    }
    
    private void addLaptop() {
        // clear the screen
        getContentPane().removeAll();
        
        JPanel addLaptopPanel = new JPanel();
        addLaptopPanel.setLayout(new GridLayout(6,2,10,10));
        
        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();
        
        //RAM combobox
        String[] ramOptions = {"4", "8", "16", "32", "64"};
        JComboBox ramComboBox = new JComboBox(ramOptions);
        
        //storage radio 
        JPanel storagePanel = new JPanel();
        JRadioButton ssdButton, hddButton;
        ssdButton = new JRadioButton("SSD");
        hddButton = new JRadioButton("HDD");
        ButtonGroup storageBG = new ButtonGroup();
        storageBG.add(ssdButton);
        storageBG.add(hddButton);
        storagePanel.add(ssdButton);
        storagePanel.add(hddButton);
        ssdButton.setSelected(true);
        
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back to Main Menu");
        
        addLaptopPanel.add(new JLabel("Laptop Name:"));
        addLaptopPanel.add(nameField);
        addLaptopPanel.add(new JLabel("Price:"));
        addLaptopPanel.add(priceField);
        addLaptopPanel.add(new JLabel("Quantity:"));
        addLaptopPanel.add(quantityField);
        addLaptopPanel.add(new JLabel("RAM (GB):"));
        addLaptopPanel.add(ramComboBox);
        addLaptopPanel.add(new JLabel("Storage Type:"));
        addLaptopPanel.add(storagePanel);
        addLaptopPanel.add(submitButton);
        addLaptopPanel.add(backButton);
        
        getContentPane().add(addLaptopPanel);
        revalidate();
        repaint();
        
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            int ram = Integer.parseInt((String) ramComboBox.getSelectedItem());
            String storage = null;
            
            if (ssdButton.isSelected()) {
                storage = "SSD";
            } else if (hddButton.isSelected()) {
                storage = "HDD";
            }
            
            Laptop laptop = new Laptop(name, "Laptop", price, quantity, ram, storage);
            if (laptop.save()) {
                JOptionPane.showMessageDialog(this, "Laptop added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save laptop.");
            }
        });
        
        backButton.addActionListener(e -> {
        getContentPane().removeAll();
        mainMenu();
        revalidate();
        repaint();
        });
    }

    private void addHandphone() {
        // clear the screen
        getContentPane().removeAll();
        
        JPanel addHandphonePanel = new JPanel();
        addHandphonePanel.setLayout(new GridLayout(6,2,10,10));
        
        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();
       
        //OS radio 
        JPanel OS_Panel = new JPanel();
        JRadioButton ios_Button, android_Button;
        ios_Button = new JRadioButton("iOS");
        android_Button = new JRadioButton("Android");
        ButtonGroup OS_BG = new ButtonGroup();
        OS_BG.add(ios_Button);
        OS_BG.add(android_Button);
        OS_Panel.add(ios_Button);
        OS_Panel.add(android_Button);
        ios_Button.setSelected(true);
        
        JTextField screenSizeField = new JTextField();
        
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back to Main Menu");
        
        addHandphonePanel.add(new JLabel("Handphone Name:"));
        addHandphonePanel.add(nameField);
        addHandphonePanel.add(new JLabel("Price:"));
        addHandphonePanel.add(priceField);
        addHandphonePanel.add(new JLabel("Quantity:"));
        addHandphonePanel.add(quantityField);
        addHandphonePanel.add(new JLabel("Operating System:"));
        addHandphonePanel.add(OS_Panel);
        addHandphonePanel.add(new JLabel("Enter Screen Size (inches):"));
        addHandphonePanel.add(screenSizeField);
        
        addHandphonePanel.add(submitButton);
        addHandphonePanel.add(backButton);
        
        getContentPane().add(addHandphonePanel);
        revalidate();
        repaint();
        
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            double screenSize = Double.parseDouble(screenSizeField.getText().trim());
            String os = null;
            
            if (ios_Button.isSelected()) {
                os = "iOS";
            } else if (android_Button.isSelected()) {
                os = "Android";
            }
            
            Handphone phone = new Handphone(name, "Handphone", price, quantity, os, screenSize);
            if (phone.save()) {
                JOptionPane.showMessageDialog(this, "Handphone added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save handphone.");
            }
        });
        
        backButton.addActionListener(e -> {
        getContentPane().removeAll();
        mainMenu();
        revalidate();
        repaint();
        });
    }
    
    private void displayProduct(){
    Handphone H = new Handphone();
    Laptop L = new Laptop();
    getContentPane().removeAll();
    
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
    
    JPanel laptopPanel = new JPanel(new BorderLayout());
    JPanel phonePanel = new JPanel(new BorderLayout());
    
    laptopPanel.add(new JLabel("Laptops", JLabel.CENTER), BorderLayout.NORTH);
    phonePanel.add(new JLabel("Handphones", JLabel.CENTER), BorderLayout.NORTH);
    
    JScrollPane laptopScroll = L.display();
    JScrollPane phoneScroll = H.display();
    
    laptopScroll.setPreferredSize(new Dimension(700, 200));
    phoneScroll.setPreferredSize(new Dimension(700, 200));
    
    laptopPanel.add(laptopScroll, BorderLayout.CENTER);
    phonePanel.add(phoneScroll, BorderLayout.CENTER);
    
    displayPanel.add(laptopPanel);
    displayPanel.add(phonePanel);
    
    JButton backButton = new JButton("Back to Main Menu");
    backButton.addActionListener(e -> {
        getContentPane().removeAll();
        mainMenu();
        revalidate();
        repaint();
    });
    
    backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    displayPanel.add(backButton);
    
    JScrollPane mainScroll = new JScrollPane(displayPanel);
    getContentPane().add(mainScroll);
    
    revalidate();
    repaint();
    }
    
    private void deleteLaptop() {
        String[] columns = {"Name", "Category", "Price(RM)", "Quantity", "RAM(GB)", "Storage Type"};
        String[][] data = null;
        String filename = "laptop.txt";

        int totalLines = 0;
        try (Scanner readFile = new Scanner(new File(filename))) {
            while (readFile.hasNextLine()) {
                readFile.nextLine();
                totalLines++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (Scanner readFile2 = new Scanner(new File(filename))) {
            data = new String[totalLines][6];
            int currentRow = 0;
            while (readFile2.hasNextLine()) {
                String line = readFile2.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] rowData = line.split(",");
                    data[currentRow] = rowData;
                    currentRow++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700, 200));

        int option = JOptionPane.showConfirmDialog(
            this,
            scroll,
            "Select Laptop to Delete (click a row)",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (option == JOptionPane.OK_OPTION) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a laptop to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete Laptop #" + (selectedRow + 1) + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Laptop L = new Laptop();
                L.delete(selectedRow + 1);
                JOptionPane.showMessageDialog(this, "Laptop deleted successfully.");
            }
        }
    }
     
    private void deleteHandphone() {
        String[] columns = {"Name", "Category", "Price(RM)", "Quantity", "RAM(GB)", "Storage Type"};
        String[][] data = null;
        String filename = "handphone.txt";

        int totalLines = 0;
        try (Scanner readFile = new Scanner(new File(filename))) {
            while (readFile.hasNextLine()) {
                readFile.nextLine();
                totalLines++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (Scanner readFile2 = new Scanner(new File(filename))) {
            data = new String[totalLines][6];
            int currentRow = 0;
            while (readFile2.hasNextLine()) {
                String line = readFile2.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] rowData = line.split(",");
                    data[currentRow] = rowData;
                    currentRow++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700, 200));

        int option = JOptionPane.showConfirmDialog(
            this,
            scroll,
            "Select Handphone to Delete (click a row)",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (option == JOptionPane.OK_OPTION) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a handphone to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete Handphone #" + (selectedRow + 1) + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Handphone H = new Handphone();
                H.delete(selectedRow + 1);
                JOptionPane.showMessageDialog(this, "Handphone deleted successfully.");
            }
        }
    }


    
    public static void main(String[] args) {
            JavaProject frame = new JavaProject();
            frame.setSize(720,540);
            frame.setTitle("Digital Product Management System");
            frame.mainMenu();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Product {
    protected String name;
    protected double price;
    protected String category;
    protected int quantity;

    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}

class Laptop extends Product{
    private int RAM;
    private String storageType;
    private String filename;
    
    public Laptop(){
    super("", "", 0.0, 0);
    this.RAM = 0;
    this.storageType = " ";
    this.filename = "laptop.txt";
    }
    
    public Laptop(String name, String category, double price, int quantity, int RAM, String storageType) {
        super(name, category, price, quantity);
        this.RAM = RAM;
        this.storageType = storageType;
        this.filename = "laptop.txt";
    }
    
    protected boolean save(){
        try{
            FileWriter file = new FileWriter(filename,true);
            String data = name +","+ category +","+ price +","+ quantity +","+ RAM +","+ storageType + "\n";
            file.append(data);
            file.close();
            return true;
            
        }
        catch(IOException e){
            System.out.println("Error :");
            e.printStackTrace();
            return false;
        }
    }
    
    protected JScrollPane display(){
        JScrollPane JScroll;
        JTable table;
        String[] column;
        String[][] data = null;
        
        column = new String []{"Name","Catagory","Price(RM)","Quantity","RAM(GB)","Storage Type"};
        
        int totalLines = 0;
        try(Scanner readFile = new Scanner(new File(filename))){
            while (readFile.hasNextLine()) {
                readFile.nextLine();
                totalLines++;
            }
        
            if (totalLines == 0) {
                JOptionPane.showMessageDialog(null, "File is empty!");
            }
        }catch(FileNotFoundException e){
            System.out.println("Error :");
            e.printStackTrace();
        }
        
        try(Scanner readFile2 = new Scanner(new File(filename))){
            data = new String[totalLines][6];

            int currentRow = 0;
            while (readFile2.hasNextLine()) {
                String line = readFile2.nextLine().trim();
                if (line.isEmpty()){
                    continue;
                }
                String[] rowData = line.split(",");
                data[currentRow] = rowData;
                currentRow++;

            }
        }catch(FileNotFoundException e){
            System.out.println("Error :");
            e.printStackTrace();
        }
        
        table = new JTable(data, column);
        JScroll = new JScrollPane(table);
        return JScroll;
    }

    public void delete(int number) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if (number < 1 || number > lines.size()) {
            JOptionPane.showMessageDialog(null, "Invalid number to delete.");
            return;
        }

        lines.remove(number - 1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class Handphone extends Product{
    private String OS_system;
    private Double screenSize;
    private String filename;
    
    public Handphone(){
        super("", "", 0.0, 0);
        OS_system = "";
        screenSize = 0.0;
        filename = "handphone.txt";
    }
    
    public Handphone(String name, String category, double price, int quantity, String OS_system, Double screenSize) {
        super(name, category, price, quantity);
        this.OS_system = OS_system;
        this.screenSize = screenSize;
        this.filename = "handphone.txt";
    }
    
    protected boolean save(){
        try{
            FileWriter file = new FileWriter(filename,true);
            String data = name +","+ category +","+ price +","+ quantity +","+ OS_system +","+ screenSize + "\n";
            file.append(data);
            file.close();
            return true;
        }
        catch(IOException e){
            System.out.println("Error :");
            e.printStackTrace();
            return false;
        }
    }
    
    protected JScrollPane display(){
        JScrollPane JScroll;
        JTable table;
        String[] column;
        String[][] data = null;
        
        column = new String []{"Name","Catagory","Price(RM)","Quantity","Operating System","Screen Size"};
        
        int totalLines = 0;
        try(Scanner readFile = new Scanner(new File(filename))){
            while (readFile.hasNextLine()) {
                readFile.nextLine();
                totalLines++;
            }
        
            if (totalLines == 0) {
                JOptionPane.showMessageDialog(null, "File is empty!");
            }
        }catch(FileNotFoundException e){
            System.out.println("Error :");
            e.printStackTrace();
        }
        
        try(Scanner readFile2 = new Scanner(new File(filename))){
            data = new String[totalLines][6];

            int currentRow = 0;
            while (readFile2.hasNextLine()) {
                String line = readFile2.nextLine().trim();
                if (line.isEmpty()){
                    continue;
                }
                String[] rowData = line.split(",");
                data[currentRow] = rowData;
                currentRow++;

            }
        }catch(FileNotFoundException e){
            System.out.println("Error :");
            e.printStackTrace();
        }
        
        table = new JTable(data, column);
        JScroll = new JScrollPane(table);
        return JScroll;
    }

    public void delete(int number) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if (number < 1 || number > lines.size()) {
            JOptionPane.showMessageDialog(null, "Invalid number to delete.");
            return;
        }

        lines.remove(number - 1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
