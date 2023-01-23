package exec;

import data.ProgrammerBean;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        Constants constants =new Constants();
        //Constants queries
        String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
        String GET_A_PROGRAMMER_QUERY = "INSERT INTO persons(id, name) VALUES( ?, ?)";
        String ADD_PROGRAMMER_QUERY = "INSERT INTO programmeur(id, name) VALUES( ?, ?)";
        String UPDATE_PROGRAMMER_QUERY = "INSERT INTO persons(id, name) VALUES( ?, ?)";
        String DELETE_PROGRAMMER_QUERY = "INSERT INTO persons(id, name) VALUES( ?, ?)";

        try {
            //String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
            Connection connection = DriverManager.getConnection(constants.getDB_URL(),
                    constants.getDB_USERNAME(),
                    constants.getDB_PASSWORD());
            List<ProgrammerBean> programmerBeanList=new ArrayList<>();
            Statement  statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(GET_ALL_PROGRAMMERS_QUERY);
            while (resultSet.next()){
                ProgrammerBean programmerBean=new ProgrammerBean();

                programmerBean.setNom(resultSet.getString("nom"));
                programmerBean.setPreNom(resultSet.getString("prenom"));
                programmerBean.setAdresse(resultSet.getString("adresse"));
                programmerBean.setPseudo(resultSet.getString("pseudo"));
                programmerBean.setResponsable(resultSet.getString("responsable"));
                programmerBean.setHobby( resultSet.getString("hobby"));
                programmerBean.setAnnissance(resultSet.getString("annaissance"));
                programmerBean.setSalaire(resultSet.getString("salaire"));
                programmerBean.setPrime(resultSet.getString("prime"));

                programmerBeanList.add(programmerBean);

            }

            programmerBeanList.forEach(programmerBean -> System.out.println(programmerBean));
            programmerBeanList.stream().filter(programmerBean -> programmerBean)
            System.out.println("connection succeded");
            connection.close();
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }
    }


}