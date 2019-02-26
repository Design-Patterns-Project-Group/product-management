public class Main{

    public static void main(String... args) {
        HighLevelEmployee ceo = new HighLevelEmployee("CEO", 10000.0);
        System.out.println("ceo's position(*SHRUG*): " + ceo.getName());
        System.out.println("ceo's salary: " + String.valueOf(ceo.getSalary()));
    }
}