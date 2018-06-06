import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
            String url = Config.getUrl();
            String user = Config.getUser();
            String password = Config.getPassword();
            connection = DriverManager.getConnection(
                    url,
                    user,
                    password
            );
        } catch (SQLException e){
            throw new RuntimeException("Error Connecting to the Database",e);
        }
    }
    @Override
    public List<Ad> all(){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(resultSet);
        } catch (SQLException e){
            throw new RuntimeException("Error Retrieving Ads");
        }
    }

    private List<Ad> createAdsFromResults(ResultSet resultSet) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (resultSet.next()) {
            ads.add(extractAd(resultSet));
        }
        return ads;
    }

    private Ad extractAd(ResultSet resultSet) throws SQLException {
        return new Ad(
                resultSet.getLong("id"),
                resultSet.getLong("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description")
        );
    }

    @Override
    public Long insert(Ad ad){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createQuery(Ad ad){
        return "INSERT INTO ads(user_id, title, description) VALUES"
                + "(" + ad.getUserId() + ","
                + "" + ad.getTitle() + ","
                + "" + ad.getDescription() + ")";
    }
}