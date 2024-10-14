import java.util.*;

public class Database {
    private String name;
    private List<Record> records; // Lista przechowująca rekordy
    private int nextId = 1; // Licznik do generowania unikalnych ID
    private List<DatabaseConnection> connections;
    private int currentIndex = 0;

    // Maksymalna liczba połączeń (np. 3)
    private static final int MAX_CONNECTIONS = 3;

    private static Map<String, Database> instances = new HashMap<>();
    private Database(String name) {
        this.name = name;
        this.records = new ArrayList<>();
        this.connections = new ArrayList<>();
        for(int i = 0; i<MAX_CONNECTIONS; i++){
            connections.add(new DatabaseConnectionImpl());
        }
    }
    public static Database getInstance(String databaseName) {
        if (!instances.containsKey(databaseName)) {
            instances.put(databaseName, new Database(databaseName));
        }
        return instances.get(databaseName);
    }
    // Zwraca implementację interfejsu DatabaseConnection
    public DatabaseConnection getConnection() { //tu naprawić
        if (connections.isEmpty()) {
            return null; // Brak połączeń
        }
        DatabaseConnection connection = connections.get(currentIndex);
        currentIndex = (currentIndex + 1) % MAX_CONNECTIONS; // Cykliczne przydzielanie połączeń
        return connection;
    }
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

