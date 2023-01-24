package data;

import exeptions.NomberOfAddQueriesExceeded;

import java.sql.*;
import java.util.ArrayList;

public interface ActionBDD {


    // DataBase Methods
    Connection getConnection() throws SQLException;
    // CRUD Methods
    ArrayList<ProgrammerBean> getProgrammerBeanList() throws SQLException;
    ProgrammerBean getProgrammer(int id) throws SQLException;

    String getIdCount() throws SQLException;



    int addProgrammer(ProgrammerBean programmerBean) throws SQLException, NomberOfAddQueriesExceeded;

    int updateProgrammerSalary(int id, float newSalary) throws SQLException;
    int deleteProgrammer(int id ) throws SQLException;

    // Application Features
    boolean verifier(int id) throws SQLException;
    void showProgrammer(int id) throws SQLException;
    void showAllProgrammers() throws SQLException;





}
