import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();
        QueryExecutor queryExecutor = new QueryExecutor(connection);


        String city = "New York";
        String language = "English";
        List<Inhabitant> inhabitants = queryExecutor.getInhabitantsByCityAndLanguage(city, language);
        System.out.println("Inhabitants in " + city + " who speak " + language + ":");
        for (Inhabitant inhabitant : inhabitants) {
            System.out.println(inhabitant.getName() + " - " + inhabitant.getPopulation());
        }


        String inhabitantType = "Student";
        List<City> cities = queryExecutor.getCitiesByInhabitantType(inhabitantType);
        System.out.println("Cities with " + inhabitantType + " inhabitants:");
        for (City cityObj : cities) {
            System.out.println(cityObj.getName());
        }


        int population = 100000;
        List<String> inhabitantTypes = new ArrayList<>();
        inhabitantTypes.add("Student");
        inhabitantTypes.add("Worker");
        City cityObj = queryExecutor.getCityByPopulationAndInhabitantTypes(population, inhabitantTypes);
        System.out.println("City with population " + population + " and inhabitants of type " + inhabitantTypes + ":");
        System.out.println(cityObj.getName());


        InhabitantType oldestInhabitantType = queryExecutor.getOldestInhabitantType();
        System.out.println("Oldest inhabitant type:");
        System.out.println(oldestInhabitantType.getName());
    }
}
