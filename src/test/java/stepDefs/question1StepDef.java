package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class question1StepDef {
    private static int counter = 0;

    @Given(":{string} {string} {string} {string} {string} {string} {string} should match with the result")
    public void should_match_with_the_result(String customer_id, String first_name, String last_name, String city, String country, String count, String sum) throws SQLException {
        String query = "SELECT c.customer_id,c.first_name,c.last_name,ci.city,co.country,COUNT(p.payment_id),SUM(p.amount) FROM customer c\n" +
                "JOIN address ad ON ad.address_id =c.address_id\n" +
                "JOIN city ci ON ci.city_id = ad.city_id \n" +
                "JOIN country co ON co.country_id = ci.country_id\n" +
                "JOIN payment p ON p.customer_id = c.customer_id\n" +
                "GROUP BY c.customer_id,c.first_name,c.last_name,ci.city,co.country\n" +
                "ORDER BY SUM(p.amount) DESC\n" +
                "LIMIT 5";
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);
        Map<String, Object> map = queryResultMap.get(counter++);
        Assert.assertEquals(map.get("customer_id") + "", customer_id);
        Assert.assertEquals(map.get("first_name") + "", first_name);
        Assert.assertEquals(map.get("last_name") + "", last_name);
        Assert.assertEquals(map.get("city") + "", city);
        Assert.assertEquals(map.get("country") + "", country);
        Assert.assertEquals(map.get("count") + "", count);
        Assert.assertEquals(map.get("sum") + "", sum);
    }

}


