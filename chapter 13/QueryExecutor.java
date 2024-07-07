import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class QueryExecutor {
    private Connection connection;

    public QueryExecutor(Connection connection) {
        this.connection = connection;
    }

    public List<Inhabitant> getInhabitantsByCityAndLanguage(String city, String language) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT i.* FROM inhabitants i JOIN cities c ON i.city_id = c.id JOIN inhabitant_types it ON i.type_id = it.id WHERE c.name =? AND it.language =?");
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, language);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Inhabitant> inhabitants = new ArrayList<>();
            while (resultSet.next()) {
                inhabitants.add(new Inhabitant(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("population")));
            }
            return inhabitants;
        } catch (SQLException e) {
            System.err.println("Error getting inhabitants by city and language: " + e.getMessage());
            return null;
        }
    }

    public List<City> getCitiesByInhabitantType(String type) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.* FROM cities c JOIN inhabitants i ON c.id = i.city_id JOIN inhabitant_types it ON i.type_id = it.id WHERE it.name =?");
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                cities.add(new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("foundation_year"), resultSet.getBigDecimal("area")));
            }
            return cities;
        } catch (SQLException e) {
            System.err.println("Error getting cities by inhabitant type: " + e.getMessage());
            return null;
        }
    }

    public City getCityByPopulationAndInhabitantTypes(int population, List<String> inhabitantTypes) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.* FROM cities c JOIN inhabitants i ON c.id = i.city_id WHERE i.population =? AND i.type_id IN (" + getInhabitantTypeIds(inhabitantTypes) + ")");
            preparedStatement.setInt(1, population);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("foundation_year"), resultSet.getBigDecimal("area"));
            }
        } catch (SQLException e) {
            System.err.println("Error getting city by population and inhabitant types: " + e.getMessage());
            return null;
        }
        return null;
    }

    public InhabitantType getOldestInhabitantType() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT it.* FROM inhabitant_types it ORDER BY it.foundation_year ASC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new InhabitantType(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("language"));
            }
        } catch (SQLException e) {
            System.err.println("Error getting oldest inhabitant type: " + e.getMessage());
            return null;
        }
        return null;
    }

    private String getInhabitantTypeIds(List<String> inhabitantTypes) {
        StringBuilder ids = new StringBuilder();
        for (String type : inhabitantTypes) {
            ids.append(getInhabitantTypeId(type)).append(",");
        }
        return ids.toString().replaceAll(",$", "");
    }

    private int getInhabitantTypeId(String type) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM inhabitant_types WHERE name =?");
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error getting inhabitant type ID: " + e.getMessage());
            return -1;
        }
        return -1;
    }
}