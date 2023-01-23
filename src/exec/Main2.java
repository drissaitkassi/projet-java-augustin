package exec;

import data.ActionBDDimpl;
import exeptions.NomberOfAddQueriesExceeded;

import java.sql.SQLException;

public class Main2 {

    public static void main(String[] args) throws SQLException, NomberOfAddQueriesExceeded {
        ActionBDDimpl actionBDDimpl=new ActionBDDimpl();

        //show all programmers
        //actionBDDimpl.showAllProgrammers();
        //show a programmer
        actionBDDimpl.showProgrammer(4);
        // provoque add programmer exeption

      /*  for (int i = 0; i <90 ; i++) {
            actionBDDimpl.addProgrammer();
        }*/
        //actionBDDimpl.addProgrammer();


    }
}
