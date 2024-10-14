public class Ztp01 {
    public static void main(String[] args) {
        // Tworzenie bazy danych
        ConnectionManager cm = ConnectionManagerImpl.getInstance();

        DatabaseConnection connection = cm.getConnection("DB1");

        System.out.println("DB1 connection 1(1): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 2(2): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 3(3): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 4(1): " + cm.getConnection("DB1").hashCode());
        System.out.println("DB1 connection 5(2): " + cm.getConnection("DB1").hashCode());

        System.out.println("DB2 connection 1(1): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 2(2): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 3(3): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 4(1): " + cm.getConnection("DB2").hashCode());
        System.out.println("DB2 connection 5(2): " + cm.getConnection("DB2").hashCode());

        connection.addRecord("jacek", 99);
        connection.showAllRecords();

    }
}