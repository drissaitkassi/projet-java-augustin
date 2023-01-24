package exec;

import data.ActionBDDimpl;

import java.sql.SQLException;

public class Start {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
       menu.interfacePrincipale();
        ActionBDDimpl actionBDDimpl=new ActionBDDimpl();


    }


}