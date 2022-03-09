package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Charley
 * @creat 2021-05-26 18:37
 */
public class JdbcUtilsTest {
    @Test
    public void jdbcUtilsTest() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        JdbcUtils.close(connection);
    }
}
