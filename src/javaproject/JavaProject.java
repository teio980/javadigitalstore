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
        
        JButton addLaptopButton = new JButton("Add Laptop");
        JButton addHandphoneButton = new JButton("Add Handphone");
        JButton displayButton = new JButton("Display Product");
        JButton deleteLaptopButton = new JButton("Delete Laptop");
        JButton deleteHandphoneButton = new JButton("Delete Handphone");
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        addLaptopButton.setFont(buttonFont);
        addHandphoneButton.setFont(buttonFont);
        displayButton.setFont(buttonFont);
        deleteLaptopButton.setFont(buttonFont);
        deleteHandphoneButton.setFont(buttonFont);
        
        addLaptopButton.setIcon(new ImageIcon(getClass().getResource("/image/computer_icon.png")));
        addLaptopButton.setPreferredSize(new Dimension(208, 52));
        addLaptopButton.setBackground(new Color(0, 120, 215));
        addLaptopButton.setForeground(Color.WHITE);
        addLaptopButton.setOpaque(true);
        addLaptopButton.setBorderPainted(false);
        
        addHandphoneButton.setIcon(new ImageIcon(getClass().getResource("/image/phone_android_icon.png")));
        addHandphoneButton.setPreferredSize(new Dimension(208, 52));
        addHandphoneButton.setBackground(new Color(0, 120, 215));
        addHandphoneButton.setForeground(Color.WHITE);
        addHandphoneButton.setOpaque(true);
        addHandphoneButton.setBorderPainted(false);
        
        displayButton.setIcon(new ImageIcon(getClass().getResource("/image/table_view_icon.png")));
        displayButton.setPreferredSize(new Dimension(208, 52));
        displayButton.setBackground(new Color(0, 120, 215));
        displayButton.setForeground(Color.WHITE);
        displayButton.setOpaque(true);
        displayButton.setBorderPainted(false);
        
        JPanel southPanel = new JPanel(new GridLayout(2, 1));

        JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        firstRow.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        firstRow.add(addLaptopButton);
        firstRow.add(addHandphoneButton);
        firstRow.add(displayButton);

        
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/image/rubbish.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        deleteLaptopButton.setIcon(new ImageIcon(scaledImage));
        deleteLaptopButton.setPreferredSize(new Dimension(208, 52));
        deleteLaptopButton.setBackground(new Color(0, 120, 215));
        deleteLaptopButton.setForeground(Color.WHITE);
        deleteLaptopButton.setOpaque(true);
        deleteLaptopButton.setBorderPainted(false);
        
        deleteHandphoneButton.setIcon(new ImageIcon(scaledImage));
        deleteHandphoneButton.setPreferredSize(new Dimension(208, 52));
        deleteHandphoneButton.setBackground(new Color(0, 120, 215));
        deleteHandphoneButton.setForeground(Color.WHITE);
        deleteHandphoneButton.setOpaque(true);
        deleteHandphoneButton.setBorderPainted(false);

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        secondRow.add(deleteLaptopButton);
        secondRow.add(deleteHandphoneButton);

        southPanel.add(firstRow);
        southPanel.add(secondRow);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);

        addLaptopButton.addActionListener(e -> addLaptop());
        addHandphoneButton.addActionListener(e -> addHandphone());
        displayButton.addActionListener(e -> displayProduct());
        deleteLaptopButton.addActionListener(e -> deleteLaptop());
        deleteHandphoneButton.addActionListener(e -> deleteHandphone());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "Back" -> {
                getContentPane().removeAll();
                mainMenu();
                revalidate();
                repaint();
            }
            case "Exit" -> {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
    }
    
    private void addLaptop() {
        getContentPane().removeAll();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JTextField name = new JTextField();
        JTextField price = new JTextField();
        JTextField qty = new JTextField();

        String[] ramList = {"4", "8", "16", "32", "64"};
        JComboBox ram = new JComboBox(ramList);

        JPanel storage = new JPanel();
        JRadioButton ssd = new JRadioButton("SSD");
        JRadioButton hdd = new JRadioButton("HDD");
        ButtonGroup storageGroup = new ButtonGroup();
        storageGroup.add(ssd);
        storageGroup.add(hdd);       
        storage.add(ssd);
        storage.add(hdd);
        ssd.setSelected(true);

        JButton submit = new JButton("Submit");
        JButton back = new JButton("Back to Main Menu");

        panel.add(new JLabel("Laptop Name:"));
        panel.add(name);
        panel.add(new JLabel("Price:"));
        panel.add(price);
        panel.add(new JLabel("Quantity:"));
        panel.add(qty);
        panel.add(new JLabel("RAM (GB):"));
        panel.add(ram);
        panel.add(new JLabel("Storage Type:"));
        panel.add(storage);
        panel.add(submit);
        panel.add(back);

        getContentPane().add(panel);
        revalidate();
        repaint();

        submit.addActionListener(e -> {
            String n = name.getText();
            double p = Double.parseDouble(price.getText().trim());
            int q = Integer.parseInt(qty.getText().trim());
            int r = Integer.parseInt((String) ram.getSelectedItem());
            String s = ssd.isSelected() ? "SSD" : "HDD";

            Laptop l = new Laptop(n, "Laptop", p, q, r, s);
            if (l.save()) {
                JOptionPane.showMessageDialog(this, "Laptop added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save laptop.");
            }
        });

        back.addActionListener(e -> {
            getContentPane().removeAll();
            mainMenu();
            revalidate();
            repaint();
        });
    }

    private void addHandphone() {
        getContentPane().removeAll();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JTextField name = new JTextField();
        JTextField price = new JTextField();
        JTextField qty = new JTextField();
        JTextField screen = new JTextField();

        JPanel osPanel = new JPanel();
        JRadioButton ios = new JRadioButton("iOS");
        JRadioButton android = new JRadioButton("Android");
        ButtonGroup osGroup = new ButtonGroup();
        osGroup.add(ios);
        osGroup.add(android);
        osPanel.add(ios);
        osPanel.add(android);
        ios.setSelected(true);

        JButton submit = new JButton("Submit");
        JButton back = new JButton("Back to Main Menu");

        panel.add(new JLabel("Handphone Name:"));
        panel.add(name);
        panel.add(new JLabel("Price:"));
        panel.add(price);
        panel.add(new JLabel("Quantity:"));
        panel.add(qty);
        panel.add(new JLabel("Operating System:"));
        panel.add(osPanel);
        panel.add(new JLabel("Enter Screen Size (inches):"));
        panel.add(screen);
        panel.add(submit);
        panel.add(back);

        getContentPane().add(panel);
        revalidate();
        repaint();

        submit.addActionListener(e -> {
            String n = name.getText();
            double p = Double.parseDouble(price.getText().trim());
            int q = Integer.parseInt(qty.getText().trim());
            double s = Double.parseDouble(screen.getText().trim());
            String os = ios.isSelected() ? "iOS" : "Android";

            Handphone hp = new Handphone(n, "Handphone", p, q, os, s);
            if (hp.save()) {
                JOptionPane.showMessageDialog(this, "Handphone added successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save handphone.");
            }
        });

        back.addActionListener(e -> {
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
        String[] headers = {"Name", "Category", "Price(RM)", "Quantity", "RAM(GB)", "Storage Type"};
        String[][] rows = null;
        String file = "laptop.txt";

        int lineCount = 0;
        try (Scanner reader = new Scanner(new File(file))) {
            while (reader.hasNextLine()) {
                reader.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }

        try (Scanner reader2 = new Scanner(new File(file))) {
            rows = new String[lineCount][6];
            int i = 0;
            while (reader2.hasNextLine()) {
                String line = reader2.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    rows[i] = parts;
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }

        JTable table = new JTable(rows, headers);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700, 200));

        int choice = JOptionPane.showConfirmDialog(
            this,
            scroll,
            "Select Laptop to Delete (click a row)",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (choice == JOptionPane.OK_OPTION) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a laptop to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete Laptop #" + (selectedRow + 1) + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Laptop laptop = new Laptop();
                laptop.delete(selectedRow + 1);
                JOptionPane.showMessageDialog(this, "Laptop deleted successfully.");
            }
        }
    }

    private void deleteHandphone() {
        String[] headers = {"Name", "Category", "Price(RM)", "Quantity", "RAM(GB)", "Storage Type"};
        String[][] rows = null;
        String file = "handphone.txt";

        int lineCount = 0;
        try (Scanner reader = new Scanner(new File(file))) {
            while (reader.hasNextLine()) {
                reader.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }

        try (Scanner reader2 = new Scanner(new File(file))) {
            rows = new String[lineCount][6];
            int i = 0;
            while (reader2.hasNextLine()) {
                String line = reader2.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    rows[i] = parts;
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }

        JTable table = new JTable(rows, headers);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(700, 200));

        int choice = JOptionPane.showConfirmDialog(
            this,
            scroll,
            "Select Handphone to Delete (click a row)",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (choice == JOptionPane.OK_OPTION) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a handphone to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete Handphone #" + (selectedRow + 1) + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Handphone phone = new Handphone();
                phone.delete(selectedRow + 1);
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
            System.out.println("Error :"+e.getMessage());
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
            System.out.println("Error :"+e.getMessage());
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
            System.out.println("Error :"+e.getMessage());
        }
        
        table = new JTable(data, column);
        JScroll = new JScrollPane(table);
        return JScroll;
    }

    public void delete(int num) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(filename))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.out.println("Error :"+e.getMessage());
            return;
        }

        if (num < 1 || num > list.size()) {
            JOptionPane.showMessageDialog(null, "Invalid number to delete.");
            return;
        }

        list.remove(num - 1);

        try (PrintWriter out = new PrintWriter(filename)) {
            for (String line : list) {
                out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
            System.out.println("Error :"+e.getMessage());
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
            System.out.println("Error :"+e.getMessage());
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
            System.out.println("Error :"+e.getMessage());
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
            System.out.println("Error :"+e.getMessage());
        }
        
        table = new JTable(data, column);
        JScroll = new JScrollPane(table);
        return JScroll;
    }

    public void delete(int num) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(filename))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            System.out.println("Error :"+e.getMessage());
            return;
        }

        if (num < 1 || num > list.size()) {
            JOptionPane.showMessageDialog(null, "Invalid number to delete.");
            return;
        }

        list.remove(num - 1);

        try (PrintWriter out = new PrintWriter(filename)) {
            for (String line : list) {
                out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Cannot write file: " + filename);
            System.out.println("Error :"+e.getMessage());
        }

    }
}