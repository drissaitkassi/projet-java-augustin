package exeptions;

import data.ActionBDDimpl;

import java.sql.SQLException;

public class ExeptionGenerator {

    public void generateAddException() throws SQLException {
        ActionBDDimpl actionBDDimpl =new ActionBDDimpl();
        for (int i = 0; i <100 ; i++) {
            actionBDDimpl.addProgrammer();
        }
    }
}
