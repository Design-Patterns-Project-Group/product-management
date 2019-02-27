import javax.swing.JFrame;

public class Main{

    public static void main(String... args) {
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

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                bootstrapGUI(ceo);
            }
        });

    }

    private static void bootstrapGUI(HighLevelEmployee ceo) {
 
        JFrame frame = new JFrame("Product management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.add(new MainView(ceo));
 
        frame.pack();
        frame.setVisible(true);
    }


}