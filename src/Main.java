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

        System.out.println("ceo's position(*SHRUG*): " + ceo.getName());
        System.out.println("ceo's salary: " + String.valueOf(ceo.getSalary()));
        System.out.println("ceo's control-span salary: " + String.valueOf(ceo.getControlSpanSalary()));

    }
}