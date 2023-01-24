package exec;

import data.ActionBDDimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        ActionBDDimpl actionBDDimpl=new ActionBDDimpl();

        Connection con=actionBDDimpl.getConnection();
        Statement statement1 = con.createStatement();
        statement1.executeQuery("SELECT * FROM programmeur ");
        int affectedRow= statement1.executeUpdate("SELECT * FROM programmeur ");
        System.out.println(affectedRow);

        actionBDDimpl.getProgrammer(6);
    }
}
