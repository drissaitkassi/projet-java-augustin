package data;

import exeptions.NomberOfAddQueriesExceeded;
import exeptions.ProgrammerNotFound;

import java.sql.*;
import java.util.ArrayList;

public interface ActionBDD {


    //********************* DataBase Methods **************************
    Connection getConnection() throws SQLException;

    //********************* CRUD Methods ****************************
    ArrayList<ProgrammerBean> getProgrammerBeanList() throws SQLException;
    ProgrammerBean getProgrammer(int id) throws SQLException, ProgrammerNotFound;
    String getIdCount() throws SQLException;
    int addProgrammer(ProgrammerBean programmerBean) throws SQLException, NomberOfAddQueriesExceeded;
    int updateProgrammerSalary(int id, float newSalary) throws SQLException, ProgrammerNotFound;
    int deleteProgrammer(int id ) throws SQLException;

    //******************* Application Features ************************
    void showProgrammer(int id) throws SQLException, ProgrammerNotFound;
    void showAllProgrammers() throws SQLException;





}
