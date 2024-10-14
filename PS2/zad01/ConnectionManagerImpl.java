import java.util.HashMap;
import java.util.Map;

public class ConnectionManagerImpl implements ConnectionManager{
    private static ConnectionManagerImpl instance = null;
    private Map<String, Database> databasePools;
    private ConnectionManagerImpl() {
        databasePools = new HashMap<>();
    }
    public static ConnectionManagerImpl getInstance() {
        if (instance == null) {
            instance = new ConnectionManagerImpl();
        }
        return instance;
    }
    @Override
    public DatabaseConnection getConnection(String databaseName) {
        // Sprawdzenie, czy istnieje już pula połączeń dla danej bazy danych
        Database pool = databasePools.get(databaseName);
        if (pool == null) {
            // Jeśli nie, utwórz nową pulę połączeń
            pool = Database.getInstance(databaseName);
            databasePools.put(databaseName, pool);
        }
        // Pobierz połączenie z puli
        return pool.getConnection();
    }
}
