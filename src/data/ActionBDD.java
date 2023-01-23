package data;

import java.sql.*;
import java.util.ArrayList;

public interface ActionBDD {



    // DataBase Methods

    Connection getConnection() throws SQLException;

    // CRUD Methods

    ArrayList<ProgrammerBean> getProgrammerBeanList() throws SQLException;
    ProgrammerBean getProgrammer(int id) throws SQLException;


    String getMaxId() throws SQLException;

    int addProgrammer() throws SQLException;

    int updateProgrammerSalary(int id, float newSalary) throws SQLException;
    int deleteProgrammer(int id ) throws SQLException;

    // Application Features
    boolean verifier(int id) throws SQLException;
    void showProgrammer(int id) throws SQLException;
    void showAllProgrammers() throws SQLException;





}
