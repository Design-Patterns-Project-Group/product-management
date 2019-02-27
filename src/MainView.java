import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
 
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import java.util.*;
import javax.swing.event.TreeSelectionListener;

public class MainView extends JPanel implements TreeSelectionListener {
    private JTree tree;
    private JPanel detailsPanel;

    public MainView() {
        super(new GridLayout(1,0));

        HighLevelEmployee ceo = new HighLevelEmployee("CEO", 10000.0);

        HighLevelEmployee vice1 = new HighLevelEmployee("Vice p. #1", 8100.0);
        HighLevelEmployee vice2 = new HighLevelEmployee("Vice p. #2", 8100.0);

        ceo.addSubordinate(vice1);
        ceo.addSubordinate(vice2);

        vice1.addSubordinate(new LowLevelEmployee("teacher #1", 4000.0));
        vice1.addSubordinate(new LowLevelEmployee("teacher #2", 4000.0));
        vice1.addSubordinate(new LowLevelEmployee("teacher #3", 4000.0));
        vice1.addSubordinate(new LowLevelEmployee("teacher #4", 4000.0));
        vice1.addSubordinate(new LowLevelEmployee("teacher #5", 4000.0));

        vice2.addSubordinate(new LowLevelEmployee("teacher #1", 4000.0));
        vice2.addSubordinate(new LowLevelEmployee("teacher #2", 4000.0));
        vice2.addSubordinate(new LowLevelEmployee("teacher #3", 4000.0));
        vice2.addSubordinate(new LowLevelEmployee("teacher #4", 4000.0));
        vice2.addSubordinate(new LowLevelEmployee("teacher #5", 4000.0));

        DefaultMutableTreeNode top = createNodes(ceo);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.addTreeSelectionListener(this);

        setNodeExpandedState(tree, top, true);
        detailsPanel = new JPanel();
        JScrollPane treeView = new JScrollPane(tree);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(detailsPanel);

        Dimension minimumSize = new Dimension(100, 50);
        detailsPanel.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(200); 
        splitPane.setPreferredSize(new Dimension(500, 300));

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
        System.out.println("salary: " + String.valueOf(employee.getSalary()));
        System.out.println("control-span salary: " + String.valueOf(employee.getControlSpanSalary()));
    }

    private void displayLowLevelEmployeeDetails(LowLevelEmployee employee) {
        System.out.println("position: " + employee.getName());
        System.out.println("salary: " + String.valueOf(employee.getSalary()));
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