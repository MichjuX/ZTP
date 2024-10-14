import java.util.Optional;

interface DatabaseConnection {
    int addRecord(String name, int age);
    void updateRecord(int id, String newName, int newAge);
    void deleteRecord(int id);
    Optional<Record> getRecord(int id);
    void showAllRecords();
}