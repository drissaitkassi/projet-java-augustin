package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface ActionBDD {



    // DataBase Methods

    Connection getConnection();
    PreparedStatement getPreparedStatment(String ps);
    Statement getStatement();
    ResultSet getResultSet(String ps);


    // CRUD Methods

    ArrayList<ProgrammerBean> getProgrammerBeanList();
    ProgrammerBean getProgrammer(int id);
    void addProgrammer(ProgrammerBean programmer);
    void updateProgrammerSalary(int id,float newSalary);
    void deleteProgrammer(int id );

    // Application Features
    boolean verifier(int id);
    void showProgrammer(int id);
    void showAllProgrammers();





}
