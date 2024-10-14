import java.util.*;

// Prosta baza danych
class Database {

    private List<Record> records; // Lista przechowująca rekordy
    private int nextId = 1; // Licznik do generowania unikalnych ID
    private String name;
    private static Map<String, Database> instances = new HashMap<>();
    private List<DatabaseConnection> connections; // connection pool
    private int currentConnectionIndex = 0;

    public Database(String name) {
        this.records = new ArrayList<>();
        this.name = name;
        this.connections = new ArrayList<>();

    }
    public static Database getDB(String name){
        if (!instances.containsKey(name)) {
            instances.put(name, new Database(name));
        }
        return instances.get(name);
    }

    // Zwraca implementację interfejsu DatabaseConnection
    public DatabaseConnection getConnection() {
        DatabaseConnection connection;
        if(connections.size() < 3){
            connection = new DatabaseConnectionImpl();
            connections.add(connection);
        }
        else{
            connection = connections.get(currentConnectionIndex);
            currentConnectionIndex = (currentConnectionIndex + 1) % 3;
        }
        return connection;
    }


    // Prywatna klasa wewnętrzna implementująca interfejs DatabaseConnection
    // W Javie korzystamy z cech klas wewnętrznych, w C# ta klasa musiałaby posiadać
    // referencję na obiekt klasy Database
    private class DatabaseConnectionImpl implements DatabaseConnection {

        // Dodawanie nowego rekordu
        @Override
        public int addRecord(String name, int age) {
            Record newRecord = new Record(nextId++, name, age);
            records.add(newRecord);
            System.out.println("Inserted: " + newRecord);
            return nextId - 1; // zwracamy id dodanego rekordu
        }

        // Pobieranie rekordu po ID
        @Override
        public Optional<Record> getRecord(int id) {
            return records.stream()
                    .filter(record -> record.getId() == id)
                    .findFirst();
        }

        // Aktualizowanie rekordu po ID
        @Override
        public void updateRecord(int id, String newName, int newAge) {
            Optional<Record> optionalRecord = getRecord(id);

            if (optionalRecord.isPresent()) {
                Record record = optionalRecord.get();
                record.setName(newName);
                record.setAge(newAge);
                System.out.println("Updated: " + record);
            } else {
                System.out.println("Record with ID " + id + " not found.");
            }
        }

        // Usuwanie rekordu po ID
        @Override
        public void deleteRecord(int id) {
            Optional<Record> optionalRecord = getRecord(id);

            if (optionalRecord.isPresent()) {
                records.remove(optionalRecord.get());
                System.out.println("Deleted record with ID " + id);
            } else {
                System.out.println("Record with ID " + id + " not found.");
            }
        }

        // Wyświetlanie wszystkich rekordów
        @Override
        public void showAllRecords() {
            if (records.isEmpty()) {
                System.out.println("No records in the database.");
            } else {
                System.out.println("All records:");
                records.forEach(System.out::println);
            }
        }
    }
}
