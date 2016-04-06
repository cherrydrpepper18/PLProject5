package cannata;

import java.lang.reflect.Array;
import java.util.*;

public class ListComprehension {

    private String[][] s_emp = new String[][] {
            new String[] {"ID", "LAST_NAME","FIRST_NAME","USERID","START_DATE","COMMENTS","TITLE","SALARY","COMMISSION","DEPT_ID","MANAGER_ID"},

            new String[] {"1","Martin","Carmen","martincu","3-Mar-90","","President","4500","0.0","50,0"},

            {"2","Smith","Doris","smithdj","9-Mar-90","","VP. Operations","2450","0.0","41","1"},

            {"3","Norton","Michael","nortonma","17-Jun-91","","VP. Sales","2400","0.0","31","1"},

            {"4","Quentin","Mark","quentiml","7-Apr-90","","VP. Finance","2450","0.0","10","1"},

            {"5","Roper","Joseph","roperjm","4-Mar-90","","VP. Administration","2550",0.0,50,1"},

            {6,"Brown","Molly","brownmr","18-Jan-91","","Warehouse Manager",1600,0.0,41,2},

            {7,"Hawkins","Roberta","hawkinrt","14-May-90","","Warehouse Manager",1650,0.0,42,2},

            {8,"Burns","Ben","burnsba","7-Apr-90","","Warehouse Manager",1500,0.0,43,2},

            {9,"Catskill","Antoinette","catskiaw","9-Feb-92","","Warehouse Manager",1700,0.0,44,2},

            {10,"Jackson","Marta","jacksomt","27-Feb-91","","Warehouse Manager",1507,0.0,45,2},

            {11,"Henderson","Colin","hendercs","14-May-90","","Sales Representative",1400,10.0,31,3},

            {12,"Gilson","Sam","gilsonsj","18-Jan-92","","Sales Representative",1490,12.5,32,3},

            {13,"Sanders","Jason","sanderjk","18-Jan-91","","Sales Representative",1515,10.0,33,3},

            {14,"Dameron","Andre","dameroap","9-Oct-91","","Sales Representative",1450,17.5,35,3},

            {15,"Hardwick","Elaine","hardwiem","7-Feb-92","","Stock Clerk",1400,0.0,41,6},

            {16,"Brown","George","browngw","8-Mar-90","","Stock Clerk",940,0.0,41,6},

            {17,"Washington","Thomas","washintl","9-Feb-91","","Stock Clerk",1200,0.0,42,7},

            {18,"Patterson","Donald","patterdv","6-Aug-91","","Stock Clerk",795,0.0,42,7},

            {19,"Bell","Alexander","bellag","26-May-91","","Stock Clerk",850,0.0,43,8},

            {20,"Gantos","Eddie","gantosej","30-Nov-90","","Stock Clerk",800,0.0,44,9},

            {21,"Stephenson","Blaine","stephebs","17-Mar-91","","Stock Clerk",860,0.0,45,10},

            {22,"Chester","Eddie","chesteek","30-Nov-90","","Stock Clerk",800,0.0,44,9},

            {23,"Pearl","Roger","pearlrg","17-Oct-90","","Stock Clerk",795,0.0,34,9},

            {24,"Dancer","Bonnie","dancerbw","17-Mar-91","","Stock Clerk",860,0.0,45,7},

            {25,"Schmitt","Sandra","schmitss","9-May-91","","Stock Clerk",1100,0.0,45,8}

    };
    // department directory
    private Array s_dept = {
            {"ID","NAME","REGION_ID"},

            {10,"Finance",1},

            {31,"Sales",1},

            {32,"Sales",2},

            {33,"Sales",3},

            {34,"Sales",4},

            {35,"Sales",5},

            {41,"Operations",1},

            {42,"Operations",2},

            {43,"Operations",3},

            {44,"Operations",4},

            {45,"Operations",5},

            {50,"Administration",1}

            }

    public static void main(String{] args) {
        ArrayList<List<Object>> emp = new ArrayList<List<Object>>();
        List<Object> e1 = Arrays.asList(10, "JACKSON", "MARTA", "JACKSOMT", "27-FEB-91", "", "WAREHOUSE MANAGER", 1507, 0, 45, 2);
        List<Object> e2 = Arrays.asList(11, "HENDERSON", "COLIN", "HENDERCS", "14-MAY-90", "", "SALES REPRESENTATIVE", 1400, 10, 31, 3);
        emp.add(e1); emp.add(e2);
        emp.stream()
                .forEach(e -> { System.out.println(e); });
    }
}
