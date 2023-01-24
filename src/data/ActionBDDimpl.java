package data;

import exeptions.NomberOfAddQueriesExceeded;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionBDDimpl implements ActionBDD {

    //*************** GLOBAL OBJECTS *****************
    Constants constants = new Constants();

    //*************** DATABASE METHODS *****************
    @Override
    public Connection getConnection()  {
        Constants constants = new Constants();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(constants.getDB_URL(),
                    constants.getDB_USERNAME(),
                    constants.getDB_PASSWORD());
        } catch (SQLException e) {
            System.out.println("connection failed");
            throw new RuntimeException(e);
        }
        return connection;

    }

    //*************** CRUD METHODS *****************
    @Override
    public ArrayList<ProgrammerBean> getProgrammerBeanList() throws SQLException {

        Connection con = getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(constants.getGET_ALL_PROGRAMMERS_QUERY());

        ArrayList<ProgrammerBean> beanArrayList = new ArrayList<>();
        while (resultSet.next()) {

            ProgrammerBean programmerBean = new ProgrammerBean();
            programmerBean.setId(resultSet.getInt("id"));
            programmerBean.setNom(resultSet.getString("nom"));
            programmerBean.setPreNom(resultSet.getString("prenom"));
            programmerBean.setAdresse(resultSet.getString("adresse"));
            programmerBean.setPseudo(resultSet.getString("pseudo"));
            programmerBean.setResponsable(resultSet.getString("responsable"));
            programmerBean.setHobby(resultSet.getString("hobby"));
            programmerBean.setAnnissance(resultSet.getString("annaissance"));
            programmerBean.setSalaire(resultSet.getString("salaire"));
            programmerBean.setPrime(resultSet.getString("prime"));
            beanArrayList.add(programmerBean);


        }
        con.close();
        return beanArrayList;
    }
    @Override
    public ProgrammerBean getProgrammer(int id) throws SQLException {
        Connection conn = getConnection();
        Statement statement1 = conn.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(constants.getGET_A_PROGRAMMER_QUERY() + id);
        ProgrammerBean programmerBean = new ProgrammerBean();
        while (resultSet1.next()) {

            programmerBean.setId(resultSet1.getInt("id"));
            programmerBean.setNom(resultSet1.getString("nom"));
            programmerBean.setPreNom(resultSet1.getString("prenom"));
            programmerBean.setAdresse(resultSet1.getString("adresse"));
            programmerBean.setPseudo(resultSet1.getString("pseudo"));
            programmerBean.setResponsable(resultSet1.getString("responsable"));
            programmerBean.setHobby(resultSet1.getString("hobby"));
            programmerBean.setAnnissance(resultSet1.getString("annaissance"));
            programmerBean.setSalaire(resultSet1.getString("salaire"));
            programmerBean.setPrime(resultSet1.getString("prime"));
        }

        conn.close();
        if(programmerBean.getId()==0) {

        return null;}
        return programmerBean;
    }
    @Override
    public String getIdCount() throws SQLException {
        Connection conn=getConnection();
        Statement statement = conn.createStatement();
        ResultSet res=statement.executeQuery(constants.getMAX_ID());
        String maxId=null;
        while (res.next()){
            maxId=res.getString("count");
        }
        conn.close();
        return maxId;
    }



    @Override
    public int addProgrammer(ProgrammerBean programmerBean) throws SQLException, NomberOfAddQueriesExceeded {

        Connection conn=getConnection();
        int maxId=Integer.parseInt(getIdCount());
        if(maxId==100) throw new NomberOfAddQueriesExceeded("=====LIMIT AJOUT :"+maxId+" ATTEINT======");


        PreparedStatement preparedStatement = conn.prepareStatement(constants.getADD_PROGRAMMER_QUERY());
        preparedStatement.setString(1,programmerBean.getNom());
        preparedStatement.setString(2,programmerBean.getPreNom());
        preparedStatement.setString(3,programmerBean.getAdresse());
        preparedStatement.setString(4,programmerBean.getPseudo());
        preparedStatement.setString(5,programmerBean.getResponsable());
        preparedStatement.setString(6,programmerBean.getHobby());
        preparedStatement.setString(7,programmerBean.getAnnissance());
        preparedStatement.setString(8,programmerBean.getSalaire());
        preparedStatement.setString(9,programmerBean.getPrime());

        System.out.println("=====================");
        System.out.println("nom : " + programmerBean.getNom());
        System.out.println("prenom : " + programmerBean.getPreNom());
        System.out.println("adresse : " + programmerBean.getAdresse());
        System.out.println("psuedo : " + programmerBean.getPseudo());
        System.out.println("responsable : " + programmerBean.getResponsable());
        System.out.println("hobby : " + programmerBean.getHobby());
        System.out.println("annissance : " + programmerBean.getAnnissance());
        System.out.println("salaire : " + programmerBean.getSalaire());
        System.out.println("prime : " + programmerBean.getPrime());

        int row =preparedStatement.executeUpdate();

        if(row>0) System.out.println("Ajoute Reussi");
        conn.close();

       return row;

    }
    @Override
    public int updateProgrammerSalary(int id, float newSalary) throws SQLException {
        //open connection
        Connection conn=getConnection();
        ProgrammerBean programmer=getProgrammer(id);
        int rowAffected=0;
        if (programmer!=null){
        PreparedStatement preparedStatement = conn.prepareStatement(constants.getUPDATE_PROGRAMMER_QUERY()+id);
           // preparedStatement.setInt(1,programmer.getId());
            preparedStatement.setString(1,programmer.getNom());
            preparedStatement.setString(2,programmer.getPreNom());
            preparedStatement.setString(3,programmer.getAdresse());
            preparedStatement.setString(4,programmer.getPseudo());
            preparedStatement.setString(5,programmer.getResponsable());
            preparedStatement.setString(6,programmer.getHobby());
            preparedStatement.setString(7,programmer.getAnnissance());
            preparedStatement.setString(8, String.valueOf(newSalary));
            preparedStatement.setString(9,programmer.getPrime());


            int row = preparedStatement.executeUpdate();
            if (row>0) System.out.println("Modification succeded");
            //close connection
            conn.close();
            return rowAffected= row;
        }
            else System.out.println("Recherch KO saisir Id a nouveau");

            return rowAffected;
    }
    @Override
    public int deleteProgrammer(int id) throws SQLException {

        Connection conn = getConnection();

        Statement statement =conn.createStatement();
            int deleted =statement.executeUpdate(constants.getDELETE_PROGRAMMER_QUERY()+id);
            if (deleted>0) System.out.println("deleted succesfuly");
            else System.out.println("Suppression KO Enter Id a nouveau ");
            System.out.println(deleted);
            conn.close();
        return deleted;
    }


    //*************** APPLICATION FEATURES METHODS  *****************
    @Override
    public boolean verifier(int id) throws SQLException {
        if (deleteProgrammer(id)>0)return true;
        return false;
    }
    @Override
    public void showProgrammer(int id) throws SQLException {
        ProgrammerBean programmer=getProgrammer(id);
        if (programmer!=null){
            System.out.println("=====================");
            System.out.println("id : " + programmer.getId());
            System.out.println("nom : " + programmer.getNom());
            System.out.println("prenom : " + programmer.getPreNom());
            System.out.println("adresse : " + programmer.getAdresse());
            System.out.println("psuedo : " + programmer.getPseudo());
            System.out.println("responsable : " + programmer.getResponsable());
            System.out.println("hobby : " + programmer.getHobby());
            System.out.println("annissance : " + programmer.getAnnissance());
            System.out.println("salaire : " + programmer.getSalaire());
            System.out.println("prime : " + programmer.getPrime());
        }else System.out.println("Recherch KO saisir Id a nouveau");



    }
    @Override
    public void showAllProgrammers() throws SQLException {

        List<ProgrammerBean> programmers = getProgrammerBeanList();
        programmers.forEach(programmer -> {
            System.out.println("=====================");
            System.out.println("id : " + programmer.getId());
            System.out.println("nom : " + programmer.getNom());
            System.out.println("prenom : " + programmer.getPreNom());
            System.out.println("adresse : " + programmer.getAdresse());
            System.out.println("psuedo : " + programmer.getPseudo());
            System.out.println("responsable : " + programmer.getResponsable());
            System.out.println("hobby : " + programmer.getHobby());
            System.out.println("annissance : " + programmer.getAnnissance());
            System.out.println("salaire : " + programmer.getSalaire());
            System.out.println("prime : " + programmer.getPrime());

        });

    }
}
