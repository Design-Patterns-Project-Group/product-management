import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class MainView extends JPanel implements TreeSelectionListener {
    private JTree tree;
    private JPanel detailsPanel;
    private JLabel positionValue;
    private JLabel salaryValue;
    private JLabel controlSpanSalaryValue;

    public MainView(HighLevelEmployee ceo) {
        super(new GridLayout(1,0));


        DefaultMutableTreeNode top = createNodes(ceo);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.addTreeSelectionListener(this);

        setNodeExpandedState(tree, top, true);
        detailsPanel = new JPanel();

        SpringLayout layout = new SpringLayout();
        detailsPanel.setLayout(layout);
        

        JLabel positionLabel = new JLabel("Position: ");
        detailsPanel.add(positionLabel);
        

        positionValue = new JLabel("<undefined>");
        detailsPanel.add(positionValue);

        JLabel salaryLabel = new JLabel("Salary (individual): ");
        detailsPanel.add(salaryLabel);
        

        salaryValue = new JLabel("<undefined>");
        detailsPanel.add(salaryValue);

        JLabel controlSpanSalaryLabel = new JLabel("Control-span Salary: ");
        detailsPanel.add(controlSpanSalaryLabel);
        

        controlSpanSalaryValue = new JLabel("<undefined>");
        detailsPanel.add(controlSpanSalaryValue);


        
        layout.putConstraint(SpringLayout.WEST, positionLabel, 5, SpringLayout.WEST, detailsPanel);
		layout.putConstraint(SpringLayout.NORTH, positionLabel, 5, SpringLayout.NORTH, detailsPanel);
		layout.putConstraint(SpringLayout.WEST, positionValue, 80, SpringLayout.EAST, positionLabel);
		layout.putConstraint(SpringLayout.NORTH, positionValue, 5, SpringLayout.NORTH, detailsPanel);

        layout.putConstraint(SpringLayout.WEST, salaryLabel, 5, SpringLayout.WEST, detailsPanel);
		layout.putConstraint(SpringLayout.NORTH, salaryLabel, 25, SpringLayout.NORTH, detailsPanel);
		layout.putConstraint(SpringLayout.WEST, salaryValue, 10, SpringLayout.EAST, salaryLabel);
		layout.putConstraint(SpringLayout.NORTH, salaryValue, 25, SpringLayout.NORTH, detailsPanel);

        layout.putConstraint(SpringLayout.WEST, controlSpanSalaryLabel, 5, SpringLayout.WEST, detailsPanel);
		layout.putConstraint(SpringLayout.NORTH, controlSpanSalaryLabel, 45, SpringLayout.NORTH, detailsPanel);
		layout.putConstraint(SpringLayout.WEST, controlSpanSalaryValue, 2, SpringLayout.EAST, controlSpanSalaryLabel);
		layout.putConstraint(SpringLayout.NORTH, controlSpanSalaryValue, 45, SpringLayout.NORTH, detailsPanel);

        JScrollPane treeView = new JScrollPane(tree);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(detailsPanel);

        Dimension minimumSize = new Dimension(100, 50);
        // detailsPanel.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(200); 
        splitPane.setPreferredSize(new Dimension(500, 300));
        detailsPanel.setPreferredSize(new Dimension(50, 10));
        add(splitPane);
        // add(treeView);
    }

    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    tree.getLastSelectedPathComponent();

        if (node == null) return;

        try {
            Object nodeInfo = node.getUserObject();
            System.out.println(nodeInfo);
            if (node.isLeaf()) {
                LowLevelEmployee employee = (LowLevelEmployee)nodeInfo;
                displayLowLevelEmployeeDetails(employee);
            } else {
                HighLevelEmployee employee = (HighLevelEmployee)nodeInfo;
                displayHighLevelEmployeeDetails(employee); 
            }
        } catch(Exception err) {
            System.out.println("error:  " + err.getMessage());
        }
    }

    private DefaultMutableTreeNode createNodes(HighLevelEmployee ceo) {
        DefaultMutableTreeNode root_node = new DefaultMutableTreeNode("[.]");

        addToNode(root_node, ceo);
        // book = new DefaultMutableTreeNode(ceo.getSubordinate(0));

        System.out.println(ceo.getSubordinates());
        // root_node.add(book);

        return root_node;

    }

    private void addToNode(DefaultMutableTreeNode node, Employee employee) {
        DefaultMutableTreeNode current =  new DefaultMutableTreeNode(employee);

        for (int i = 0; i < employee.getSubordinates().size(); i++) {
            addToNode(current, employee.getSubordinate(i));
        }
        
        node.add(current);
        
    }

    private void displayHighLevelEmployeeDetails(HighLevelEmployee employee) {
        System.out.println("position: " + employee.getName());
        this.positionValue.setText(employee.getName());

        System.out.println("salary: " + String.valueOf(employee.getSalary()));
        this.salaryValue.setText(String.valueOf(employee.getSalary()));

        System.out.println("control-span salary: " + String.valueOf(employee.getControlSpanSalary()));
        this.controlSpanSalaryValue.setText(String.valueOf(employee.getControlSpanSalary()));
    }

    private void displayLowLevelEmployeeDetails(LowLevelEmployee employee) {
        System.out.println("position: " + employee.getName());
        this.positionValue.setText(employee.getName());

        System.out.println("salary: " + String.valueOf(employee.getSalary()));
        this.salaryValue.setText(String.valueOf(employee.getSalary()));

        this.controlSpanSalaryValue.setText("None");
    }


    public static void setNodeExpandedState(JTree tree, DefaultMutableTreeNode node, boolean expanded) {
        ArrayList<DefaultMutableTreeNode> list = Collections.list(node.children());
        for (DefaultMutableTreeNode treeNode : list) {
            setNodeExpandedState(tree, treeNode, expanded);
        }
        if (!expanded && node.isRoot()) {
            return;
        }
        TreePath path = new TreePath(node.getPath());
        if (expanded) {
            tree.expandPath(path);
        } else {
            tree.collapsePath(path);
        }
    }
}