import javax.swing.*;
//import java.awt.*;

class Main{
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setTitle("Notepad");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextArea textArea=new JTextArea(20,20);
        frame.add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);


        JMenuBar menuBar=new JMenuBar();

        //file menu
        JMenu fileMenu=new JMenu("File");


        // Open File
        JMenuItem openFile = new JMenuItem("Open");
        openFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    textArea.read(new java.io.FileReader(fileChooser.getSelectedFile()), null);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error opening file: " + ex.getMessage());
                }
            }
        });

        // Save File
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    textArea.write(new java.io.FileWriter(fileChooser.getSelectedFile()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                }
            }
        });

        fileMenu.add(openFile);
        fileMenu.add(saveFile);

        //Exit

        JMenuItem exit=new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        fileMenu.add(exit);



        //edit menu
        JMenu editMenu=new JMenu("Edit");
        JMenuItem cut=new JMenuItem("Cut");
        cut.addActionListener(e -> textArea.cut());
        JMenuItem copy=new JMenuItem("Copy");
        copy.addActionListener(e -> textArea.copy());
        JMenuItem paste=new JMenuItem("Paste");
        paste.addActionListener(e -> textArea.paste());
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        //help menu
        JMenu helpMenu=new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Created by:Sinali\nID: s16755",
                    "About Notepad",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        helpMenu.add(about);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);


        frame.setVisible(true);


    }
}
