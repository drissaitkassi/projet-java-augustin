package data;

import exeptions.NomberOfAddQueriesExceeded;
import exeptions.ProgrammerNotFound;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionBDDimpl implements ActionBDD {

    //*************** DATABASE METHODS *****************

    @Override
    public Connection getConnection()  {
        Constants Constants = new Constants();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constants.DB_URL,
                    Constants.DB_USERNAME,
                    Constants.DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("connection failed");
            
        }
        return connection;

    }

    //******************* CRUD METHODS **********************
    @Override
    public ArrayList<ProgrammerBean> getProgrammerBeanList() throws SQLException {

        Connection con = getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(Constants.GET_ALL_PROGRAMMERS_QUERY);
     //todo plus de commentaire

        // Definir Une list qu'on va populer par les Result set de notre requet
        // et par la suit en va la retourner comme valeur de retour

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

            // a chaque iteration on ajout l'objet programmer bean rempli par le result Set

            beanArrayList.add(programmerBean);


        }
        con.close();
        statement.close();
        resultSet.close();

        return beanArrayList;
    }
    @Override
    public ProgrammerBean getProgrammer(int id) throws SQLException, ProgrammerNotFound {
        Connection conn = getConnection();
        Statement statement1 = conn.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(Constants.GET_A_PROGRAMMER_QUERY + id);

        // Definir Un objet qu'on va populer par les Result set de notre requet
        // et par la suit en va la retourner comme valeur de retour
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
        if(programmerBean.getId()==0) throw new ProgrammerNotFound("Recherche KO Saisir a nouveau Id ");
        conn.close();
        statement1.close();
        resultSet1.close();


        return programmerBean;
    }

    // cette method est pour tester combien de lignes dans notre table programmer
    // pour limité l'ajout a 100 lignes
    @Override
    public String getIdCount() throws SQLException {
        Connection conn=getConnection();
        Statement statement = conn.createStatement();
        ResultSet res=statement.executeQuery(Constants.MAX_ID);
        String maxId=null;
        while (res.next()){
            maxId=res.getString("count");
        }
        conn.close();
        statement.close();
        res.close();
        return maxId;
    }



    @Override
    public int addProgrammer(ProgrammerBean programmerBean) throws SQLException, NomberOfAddQueriesExceeded {

        Connection conn=getConnection();
        //maxId récupere le nombre de lignes correcpondant a la column id  ce qui permet
        //de savoir le nombre de ligne sur toute la table
        int maxId=Integer.parseInt(getIdCount());
        // en fait un test pour voir si le nombre de ligne est > 100 pour interdir l'ajoute
        if(maxId==100) throw new NomberOfAddQueriesExceeded("=====LIMIT AJOUT :"+maxId+" ATTEINT======");


        PreparedStatement preparedStatement = conn.prepareStatement(Constants.ADD_PROGRAMMER_QUERY);
        preparedStatement.setString(1,programmerBean.getNom());
        preparedStatement.setString(2,programmerBean.getPreNom());
        preparedStatement.setString(3,programmerBean.getAdresse());
        preparedStatement.setString(4,programmerBean.getPseudo());
        preparedStatement.setString(5,programmerBean.getResponsable());
        preparedStatement.setString(6,programmerBean.getHobby());
        preparedStatement.setString(7,programmerBean.getAnnissance());
        preparedStatement.setString(8,programmerBean.getSalaire());
        preparedStatement.setString(9,programmerBean.getPrime());

        // retourn le nombre de ligne affecter pour savir est ce que la requette est executer correctement

        int rowAffected =preparedStatement.executeUpdate();

        if(rowAffected>0) System.out.println("Ajoute Reussi");
        conn.close();
        preparedStatement.close();


       return rowAffected;

    }
    @Override
    public int updateProgrammerSalary(int id, float newSalary) throws SQLException, ProgrammerNotFound {
        //open connection
        Connection conn=getConnection();
        //appeller la methode getProgramer pour recevior le programmer qu'on veut modifier
        ProgrammerBean programmer=getProgrammer(id);
        int rowAffected=0;
        if (programmer!=null){
        PreparedStatement preparedStatement = conn.prepareStatement(Constants.UPDATE_PROGRAMMER_QUERY+id);
            preparedStatement.setString(1,programmer.getNom());
            preparedStatement.setString(2,programmer.getPreNom());
            preparedStatement.setString(3,programmer.getAdresse());
            preparedStatement.setString(4,programmer.getPseudo());
            preparedStatement.setString(5,programmer.getResponsable());
            preparedStatement.setString(6,programmer.getHobby());
            preparedStatement.setString(7,programmer.getAnnissance());
            preparedStatement.setString(8, String.valueOf(newSalary));
            preparedStatement.setString(9,programmer.getPrime());


            rowAffected = preparedStatement.executeUpdate();
            if (rowAffected>0) System.out.println("Modification succeded");
            //close connection
            conn.close();
            preparedStatement.close();

            return rowAffected;
        }
            else System.out.println("Recherch KO saisir Id a nouveau");

            return rowAffected;
    }
    @Override
    public int deleteProgrammer(int id) throws SQLException {

        Connection conn = getConnection();

        Statement statement =conn.createStatement();
        // retourn le nombre de ligne affecter pour savir est ce que la requette est executer correctement
            int deleted =statement.executeUpdate(Constants.DELETE_PROGRAMMER_QUERY+id);
            if (deleted>0) System.out.println("deleted succesfuly");
            else System.out.println("Suppression KO Enter Id a nouveau ");
            conn.close();
            statement.close();

        return deleted;
    }


    //*************** APPLICATION FEATURES METHODS  *****************
  
    @Override
    public void showProgrammer(int id) throws SQLException, ProgrammerNotFound {
        //appeller la methode getProgramer pour recevior le programmer qu'on veut afficher
        ProgrammerBean programmer=getProgrammer(id);
        //todo to remove print progremmer
        System.out.println(programmer);
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


    }
    @Override
    public void showAllProgrammers() throws SQLException {
        //appeller la methode getProgramerBeanList pour recevior les programmeur qu'on veut afficher

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
