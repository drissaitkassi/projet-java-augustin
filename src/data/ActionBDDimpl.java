package data;

import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionBDDimpl implements ActionBDD {

    //*************** GLOBAL OBJECTS *****************
    Constants constants = new Constants();

    //*************** DATABASE METHODS *****************
    @Override
    public Connection getConnection() throws SQLException {
        Constants constants = new Constants();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(constants.getDB_URL(),
                    constants.getDB_USERNAME(),
                    constants.getDB_PASSWORD());
            System.out.println("connection succeded");


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

        return programmerBean;
    }
    @Override
    public String getMaxId() throws SQLException {
        Connection conn=getConnection();
        Statement statement = conn.createStatement();
        ResultSet res=statement.executeQuery(constants.getMAX_ID());
        String maxId=null;
        while (res.next()){
            maxId=res.getString("id");
        }
        conn.close();
        return maxId;
    }
    @Override
    public int addProgrammer() throws SQLException {

        Connection conn=getConnection();
        int maxId=Integer.parseInt(getMaxId());
        if(maxId>100) throw new IllegalArgumentException("vous avez atteint votre limit d ajout");

        PreparedStatement preparedStatement = conn.prepareStatement(constants.getADD_PROGRAMMER_QUERY());
        ProgrammerBean akdriss=new ProgrammerBean("ait kassi","driss","ain borja casa","akd","nobody","music","1991","2400","26");
        preparedStatement.setString(1,akdriss.getNom());
        preparedStatement.setString(2,akdriss.getPreNom());
        preparedStatement.setString(3,akdriss.getAdresse());
        preparedStatement.setString(4,akdriss.getPseudo());
        preparedStatement.setString(5,akdriss.getResponsable());
        preparedStatement.setString(6,akdriss.getHobby());
        preparedStatement.setString(7,akdriss.getAnnissance());
        preparedStatement.setString(8,akdriss.getSalaire());
        preparedStatement.setString(9,akdriss.getPrime());

        System.out.println("=====================");
        System.out.println("nom : " + akdriss.getNom());
        System.out.println("prenom : " + akdriss.getPreNom());
        System.out.println("adresse : " + akdriss.getAdresse());
        System.out.println("psuedo : " + akdriss.getPseudo());
        System.out.println("responsable : " + akdriss.getResponsable());
        System.out.println("hobby : " + akdriss.getHobby());
        System.out.println("annissance : " + akdriss.getAnnissance());
        System.out.println("salaire : " + akdriss.getSalaire());
        System.out.println("prime : " + akdriss.getPrime());

        int row =preparedStatement.executeUpdate();

        if(row>0) System.out.println("Ajoute Reussi");
        conn.close();

       return row;

    }
    @Override
    public int updateProgrammerSalary(int id, float newSalary) throws SQLException {
        //open connection
        Connection conn=getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(constants.getUPDATE_PROGRAMMER_QUERY()+id);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,null);
            preparedStatement.setString(3,null);
            preparedStatement.setString(4,null);
            preparedStatement.setString(5,null);
            preparedStatement.setString(6,null);
            preparedStatement.setString(7,null);
            preparedStatement.setString(8, String.valueOf(newSalary));
            preparedStatement.setString(9,null);


            int row = preparedStatement.executeUpdate();
            if (row>0) System.out.println("Modification succeded");
            else System.out.println("merci de fournir un id valid entrer 0 et 99 ?:");
            //close connection
            conn.close();
            return row;
    }
    @Override
    public int deleteProgrammer(int id) throws SQLException {

        Connection conn = getConnection();

        Statement statement =conn.createStatement();
            int deleted =statement.executeUpdate(constants.getDELETE_PROGRAMMER_QUERY()+id);
            if (deleted>0) System.out.println("deleted succesfuly");
            else System.out.println("failed to delete check that you got the right id ");
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

        System.out.println("=====================");
        System.out.println("id : " + id);
        System.out.println("nom : " + programmer.getNom());
        System.out.println("prenom : " + programmer.getPreNom());
        System.out.println("adresse : " + programmer.getAdresse());
        System.out.println("psuedo : " + programmer.getPseudo());
        System.out.println("responsable : " + programmer.getResponsable());
        System.out.println("hobby : " + programmer.getHobby());
        System.out.println("annissance : " + programmer.getAnnissance());
        System.out.println("salaire : " + programmer.getSalaire());
        System.out.println("prime : " + programmer.getPrime());

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
