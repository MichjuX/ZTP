import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ztp01 {
    public static void main(String[] args) {

        // Uzyskanie instancji Singletona - menedżera połączeń

        ConnectionManager cm = ConnectionManagerImpl.getInstance();

        // Uzyskanie połączenia do DB1

        DatabaseConnection dbConnection1 = cm.getConnection("DB1");
        DatabaseConnection dbConnection2 = cm.getConnection("DB2");

        System.out.println("DB1 connection 1(1): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 2(2): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 3(3): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 4(1): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 5(2): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 6(3): " + cm.getConnection("DB1").hashCode());

        System.out.println("DB2 connection 1(1): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 2(2): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 3(3): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 4(1): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 5(2): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 6(3): " + cm.getConnection("DB2").hashCode());

        dbConnection1.addRecord("Kamil", 20);
        dbConnection1.addRecord("Pawel", 20);
        dbConnection1.addRecord("Adam", 20);

        dbConnection2.addRecord("Wojtek", 20);
        dbConnection2.addRecord("Michal", 20);
        dbConnection2.addRecord("Agent", 20);

        DatabaseConnection dbConnection3 = cm.getConnection("DB1");
        DatabaseConnection dbConnection4 = cm.getConnection("DB2");
        dbConnection3.showAllRecords();
        dbConnection4.showAllRecords();

    }
}