package exec;

import data.ProgrammerBean;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {


    public static void main(String[] args) {
        int input = 11;
        Constants constants = new Constants();
        //Constants queries
        String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
        String GET_A_PROGRAMMER_QUERY = "SELECT * FROM programmeur where id =" + input;
        String ADD_PROGRAMMER_QUERY = "INSERT INTO PROGRAMMEUR(NOM,PRENOM,ADRESSE,PSEUDO,RESPONSABLE,HOBBY,ANNAISSANCE,SALAIRE,PRIME)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";

        String UPDATE_PROGRAMMER_QUERY = "UPDATE programmeur SET nom = ?,prenom = ?,adresse= ?,\n" +
                "pseudo = ?,responsable = ?,\n" +
                "hobby = ?,annaissance = ?,\n" +
                "salaire = ?,prime = ? WHERE id=" + input;
        String DELETE_PROGRAMMER_QUERY = "delete from programmeur where id =" + input;

        try {
            //****************** GET ALL PROGRAMMERS ******************

            // String GET_ALL_PROGRAMMERS_QUERY = "SELECT * FROM programmeur";
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
            /*Statement statement =connection.createStatement();
            int deleted =statement.executeUpdate(DELETE_PROGRAMMER_QUERY);
            if (deleted>0) System.out.println("deleted succesfuly");
            else System.out.println("failed to delete check that you got the right id ");
            System.out.println(deleted);*/

            //******** ADD PROGRAMMER ********
/*            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PROGRAMMER_QUERY);
           // preparedStatement.setInt(1,11);
            preparedStatement.setString(1,"ait kassi");
            preparedStatement.setString(2,"driss");
            preparedStatement.setString(3,"ain borja casablanca ");
            preparedStatement.setString(4,"akd");
            preparedStatement.setString(5,"nobody");
            preparedStatement.setString(6,"Music");
            preparedStatement.setString(7,"1991");
            preparedStatement.setString(8,"2400");
            preparedStatement.setString(9,"60");

            int row =preparedStatement.executeUpdate();

            System.out.println(row);*/

            //******** UPDATE PROGRAMMER ********
       /*     PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROGRAMMER_QUERY);

            preparedStatement.setString(1, " 3kassi");
            preparedStatement.setString(2, "3drissup");
            preparedStatement.setString(3, "3agadir ");
            preparedStatement.setString(4, "3upsudo");
            preparedStatement.setString(5, "3nobody");
            preparedStatement.setString(6, "3Music");
            preparedStatement.setString(7, "3991");
            preparedStatement.setString(8, "32400");
            preparedStatement.setString(9, "360");


            int row = preparedStatement.executeUpdate();

            System.out.println(row);*/


            System.out.println("connection succeded");
            connection.close();
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }

    }


}