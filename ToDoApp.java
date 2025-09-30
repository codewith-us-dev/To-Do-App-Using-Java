import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, deleteButton;

    public ToDoApp() {
        setTitle("To-Do App");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskField = new JTextField(30);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addButton);
        panel.add(deleteButton); // ✅ only added once

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Add Task Event
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a Task First!");
                }
            }
        });

        // Delete Task Event
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a task to delete!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoApp().setVisible(true);
            }
        });
    }
}
