package exeptions;

import data.ActionBDDimpl;
import data.ProgrammerBean;

import java.sql.SQLException;

public class ExeptionGenerator {

    public void generateAddException() throws SQLException {
        ActionBDDimpl actionBDDimpl =new ActionBDDimpl();
        ProgrammerBean testProgramer=new ProgrammerBean("test","test","test","test","test","test","test","test","test");
        for (int i = 0; i <100 ; i++) {
            actionBDDimpl.addProgrammer(testProgramer);
        }
    }
}
