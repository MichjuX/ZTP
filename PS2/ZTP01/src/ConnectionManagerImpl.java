import java.util.HashMap;
import java.util.Map;

class ConnectionManagerImpl implements ConnectionManager {

    private static ConnectionManagerImpl instance;
    private Map<String, Database> DBConnectionList;

    // Prywatny konstruktor
    private ConnectionManagerImpl() {
        DBConnectionList = new HashMap<>();
    }

    // Metoda do uzyskania instancji Singletona
    public static ConnectionManagerImpl getInstance() {
        if (instance == null) {
            instance = new ConnectionManagerImpl();
        }
        return instance;
    }

    @Override
    public DatabaseConnection getConnection(String databaseName) {
        // Logika uzyskiwania połączenia do bazy danych
        // Można tutaj dodać warunki w zależności od nazwy bazy
        Database db = DBConnectionList.get(databaseName);
        if (db == null) {
            db = Database.getDB(databaseName);
            DBConnectionList.put(databaseName, db);
        }

        return db.getConnection();
    }
}