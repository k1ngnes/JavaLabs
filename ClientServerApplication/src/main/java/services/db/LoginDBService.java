package services.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDBService {

    public String getPassByLogin(String login){
        String password = null;
        DataBaseService dataBaseService = new DataBaseService();
        Connection connection = dataBaseService.getConnect();
        String sql = "select e.\"password\" from employees e where e.login = '"+login+"' ";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            password = rs.getString("password");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return password;
    }

}
