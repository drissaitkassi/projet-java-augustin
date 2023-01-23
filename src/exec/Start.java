package exec;

import data.ProgrammerBean;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {


    public static void main(String[] args) {
        int input=7;
        Constants constants =new Constants();
        //Constants queries
        String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
        String GET_A_PROGRAMMER_QUERY = "SELECT * FROM programmeur where id ="+input;
        String ADD_PROGRAMMER_QUERY = "INSERT INTO programmeur(id, name) VALUES( ?, ?)";
        String UPDATE_PROGRAMMER_QUERY = "INSERT INTO persons(id, name) VALUES( ?, ?)";
        String DELETE_PROGRAMMER_QUERY = "delete from programmeur where id ="+input;

        try {
            //****************** GET ALL PROGRAMMERS ******************

            // String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
            Connection connection = DriverManager.getConnection(constants.getDB_URL(),
                    constants.getDB_USERNAME(),
                    constants.getDB_PASSWORD());
           /* List<ProgrammerBean> programmerBeanList=new ArrayList<>();
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

            }*/
            // print all programers
            //programmerBeanList.forEach(programmerBean -> System.out.println(programmerBean));
            //****************** Get a Programmer ******************


         /*   Statement statement1=connection.createStatement();
            ResultSet resultSet1=statement1.executeQuery(GET_A_PROGRAMMER_QUERY);
            while (resultSet1.next()){
                ProgrammerBean programmerBean=new ProgrammerBean();

                programmerBean.setNom(resultSet1.getString("nom"));
                programmerBean.setPreNom(resultSet1.getString("prenom"));
                programmerBean.setAdresse(resultSet1.getString("adresse"));
                programmerBean.setPseudo(resultSet1.getString("pseudo"));
                programmerBean.setResponsable(resultSet1.getString("responsable"));
                programmerBean.setHobby( resultSet1.getString("hobby"));
                programmerBean.setAnnissance(resultSet1.getString("annaissance"));
                programmerBean.setSalaire(resultSet1.getString("salaire"));
                programmerBean.setPrime(resultSet1.getString("prime"));

                System.out.println(programmerBean);

            }*/

            //********* DELETE A PROGRAMMER ********
            Statement statement =connection.createStatement();
            int deleted =statement.executeUpdate(DELETE_PROGRAMMER_QUERY);
            if (deleted>0) System.out.println("deleted succesfuly");
            else System.out.println("failed to delete check that you got the right id ");
            System.out.println(deleted);

            //******** ADD PROGRAMMER ********

            INSERT INTO PROGRAMMEUR(NOM,PRENOM,ADRESSE,PSEUDO,RESPONSABLE,HOBBY,ANNAISSANCE,SALAIRE,PRIME) VALUES
                    ('Torvalds','Linus','2 avenue Linux Git','linuxroot','Didier Achvar','Salsa','1969','2170','50'),


            System.out.println("connection succeded");
            connection.close();
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }

    }


}