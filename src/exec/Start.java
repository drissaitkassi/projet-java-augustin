package exec;

import exeptions.ProgrammerNotFound;

import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws SQLException, ProgrammerNotFound {
        Menu menu = new Menu();
        menu.interfacePrincipale();

      /*  ExeptionGenerator e=new ExeptionGenerator();
        e.generateAddException();*/


    }


}