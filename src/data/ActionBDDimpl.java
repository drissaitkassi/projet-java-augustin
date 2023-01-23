package data;

import utils.Constants;

import java.sql.*;
import java.util.ArrayList;

public class ActionBDDimpl implements ActionBDD {


    @Override
    public Connection getConnection() {
        Constants constants =new Constants();
        Connection connection;

        try {
             connection = DriverManager.getConnection(constants.getDB_URL(),
                    constants.getDB_USERNAME(),
                    constants.getDB_PASSWORD());
            System.out.println("connection succeded");
            return connection;


        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public PreparedStatement getPreparedStatment(String ps) {
        return null;
    }

    @Override
    public Statement getStatement() {
        return null;
    }

    @Override
    public ResultSet getResultSet(String ps) {
        return null;
    }

    @Override
    public ArrayList<ProgrammerBean> getProgrammerBeanList() {
        return null;
    }

    @Override
    public ProgrammerBean getProgrammer(int id) {
        return null;
    }

    @Override
    public void addProgrammer(ProgrammerBean programmer) {

    }

    @Override
    public void updateProgrammerSalary(int id, float newSalary) {

    }

    @Override
    public void deleteProgrammer(int id) {

    }

    @Override
    public boolean verifier(int id) {
        return false;
    }

    @Override
    public void showProgrammer(int id) {

    }

    @Override
    public void showAllProgrammers() {

    }
}
