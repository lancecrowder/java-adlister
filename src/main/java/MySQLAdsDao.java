import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    @Override
    public List<Ad> all() {
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }

    MySQLAdsDao (Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        String url = Config.getUrl();
        String user = Config.getUser();
        String password = Config.getPassword();
        connection = DriverManager.getConnection(
                url,
                user,
                password
        );
    }
}