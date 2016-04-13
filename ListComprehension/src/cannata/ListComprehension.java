package cannata;

import java.util.*;
import java.util.stream.Collectors;

public class ListComprehension {

    public static void main(String[] args) {

        ArrayList<List<Object>> emp = new ArrayList<List<Object>>();
        List<Object> e0 = Arrays.asList("ID", "LAST_NAME","FIRST_NAME","USERID","START_DATE","COMMENTS","TITLE","SALARY","COMMISSION","DEPT_ID","MANAGER_ID");

        List<Object> e1 = Arrays.asList(1,"Martin","Carmen","martincu","3-Mar-90","","President",4500,0.0,50,0);

        List<Object> e2 = Arrays.asList(2,"Smith","Doris","smithdj","9-Mar-90","","VP. Operations",2450,0.0,41,1);

        List<Object> e3 = Arrays.asList(3,"Norton","Michael","nortonma","17-Jun-91","","VP. Sales",2400,0.0,31,1);

        List<Object> e4 = Arrays.asList(4,"Quentin","Mark","quentiml","7-Apr-90","","VP. Finance",2450,0.0,10,1);

        List<Object> e5 = Arrays.asList(5,"Roper","Joseph","roperjm","4-Mar-90","","VP. Administration",2550,0.0,50,1);

        List<Object> e6 = Arrays.asList(6,"Brown","Molly","brownmr","18-Jan-91","","Warehouse Manager",1600,0.0,41,2);

        List<Object> e7 = Arrays.asList(7,"Hawkins","Roberta","hawkinrt","14-May-90","","Warehouse Manager",1650,0.0,42,2);

        List<Object> e8 = Arrays.asList(8,"Burns","Ben","burnsba","7-Apr-90","","Warehouse Manager",1500,0.0,43,2);

        List<Object> e9 = Arrays.asList(9,"Catskill","Antoinette","catskiaw","9-Feb-92","","Warehouse Manager",1700,0.0,44,2);

        List<Object> e10 = Arrays.asList(10,"Jackson","Marta","jacksomt","27-Feb-91","","Warehouse Manager",1507,0.0,45,2);

        List<Object> e11 = Arrays.asList(11,"Henderson","Colin","hendercs","14-May-90","","Sales Representative",1400,10.0,31,3);

        List<Object> e12 = Arrays.asList(12,"Gilson","Sam","gilsonsj","18-Jan-92","","Sales Representative",1490,12.5,32,3);

        List<Object> e13 = Arrays.asList(13,"Sanders","Jason","sanderjk","18-Jan-91","","Sales Representative",1515,10.0,33,3);

        List<Object> e14 = Arrays.asList(14,"Dameron","Andre","dameroap","9-Oct-91","","Sales Representative",1450,17.5,35,3);

        List<Object> e15 = Arrays.asList(15,"Hardwick","Elaine","hardwiem","7-Feb-92","","Stock Clerk",1400,0.0,41,6);

        List<Object> e16 = Arrays.asList(16,"Brown","George","browngw","8-Mar-90","","Stock Clerk",940,0.0,41,6);

        List<Object> e17 = Arrays.asList(17,"Washington","Thomas","washintl","9-Feb-91","","Stock Clerk",1200,0.0,42,7);

        List<Object> e18 = Arrays.asList(18,"Patterson","Donald","patterdv","6-Aug-91","","Stock Clerk",795,0.0,42,7);

        List<Object> e19 = Arrays.asList(19,"Bell","Alexander","bellag","26-May-91","","Stock Clerk",850,0.0,43,8);

        List<Object> e20 = Arrays.asList(20,"Gantos","Eddie","gantosej","30-Nov-90","","Stock Clerk",800,0.0,44,9);

        List<Object> e21 = Arrays.asList(21,"Stephenson","Blaine","stephebs","17-Mar-91","","Stock Clerk",860,0.0,45,10);

        List<Object> e22 = Arrays.asList(22,"Chester","Eddie","chesteek","30-Nov-90","","Stock Clerk",800,0.0,44,9);

        List<Object> e23 = Arrays.asList(23,"Pearl","Roger","pearlrg","17-Oct-90","","Stock Clerk",795,0.0,34,9);

        List<Object> e24 = Arrays.asList(24,"Dancer","Bonnie","dancerbw","17-Mar-91","","Stock Clerk",860,0.0,45,7);

        List<Object> e25 = Arrays.asList(25,"Schmitt","Sandra","schmitss","9-May-91","","Stock Clerk",1100,0.0,45,8);


        emp.add(e1); emp.add(e2); emp.add(e3); emp.add(e4);emp.add(e5);emp.add(e6);emp.add(e7);emp.add(e8);emp.add(e9);emp.add(e10);
        emp.add(e11);emp.add(e12);emp.add(e13);emp.add(e14);emp.add(e15);emp.add(e16);emp.add(e17);emp.add(e18);emp.add(e19);emp.add(e20);
        emp.add(e21);emp.add(e22);emp.add(e23);emp.add(e24);emp.add(e25);
        //emp.stream()
        //        .forEach(n -> n.forEach(e -> { System.out.println(e); }));

        // select last_name, first_name, username, start date from emp where username starts with b
        System.out.println("select last_name, first_name, username, start date from emp where username starts with b");
        emp.stream()
                .filter(n -> {return n.get(3).toString().substring(0,1).equals("b");})
                .forEach(e -> System.out.println(e.get(1).toString() + ", " + e.get(2).toString() + ", " + e.get(3).toString() + ", " + e.get(4).toString()));

        System.out.println();


        // select last_name, first_name, title, salary from emp where salary > 1500 and dept_id > 40 order by last_name
        System.out.println("select last_name, first_name, title, salary from emp where salary > 1500 and dept_id > 40 order by last_name");
        emp.stream()
                .filter(n -> {return Integer.parseInt(n.get(7).toString()) > 1500;})
                .filter(n -> {return Integer.parseInt(n.get(9).toString()) > 40;})
                .sorted((x, y) -> x.get(1).toString().compareTo(y.get(1).toString()))
                .forEach(e -> System.out.println(e.get(1).toString() + ", " + e.get(2).toString() + ", " + e.get(6).toString() + ", " + e.get(7).toString()));

        //List<String> list = emp.stream()
        //        .collect(Collectors.toList());

        // select dept_id, avg(salary) from s_emp, group by dept_id
        System.out.println("\nselect dept_id, avg(salary) from s_emp, group by dept_id");
        emp.stream()
                .map(a -> {return Integer.parseInt(a.get(9).toString());})
                .distinct()
                .sorted((x,y) -> Integer.compare(Integer.parseInt(x.toString()), Integer.parseInt(y.toString())))
                .forEach(n -> System.out.println(n.toString() + " " + Integer.toString(emp.stream()
                        .filter(a -> Integer.parseInt(a.get(9).toString()) == n)
                        .map(q -> {return Integer.parseInt(q.get(7).toString());})
                        .reduce((b,v) -> b + v).get() /
                        (int)emp.stream()
                                .filter(a -> Integer.parseInt(a.get(9).toString()) == n)
                                .count()
                                )));

        // select dept_id, avg(salary) from s_emp, group by dept_id having avg(salary) < 1500
        System.out.println("\nselect dept_id, avg(salary) from s_emp, group by dept_id having avg(salary) > 1500");
        emp.stream()
                //.sorted((x,y) -> Integer.compare(Integer.parseInt(x.get(9).toString()), (Integer.parseInt(y.get(9).toString()))))
                .collect(
                        Collectors.groupingBy(
                                a -> Integer.parseInt(a.get(9).toString()),
                                Collectors.averagingInt(
                                        b -> Integer.parseInt(b.get(7).toString())
                                )
                        ))
                .entrySet()
                .stream()
                .filter(c -> {return c.getValue() > 1500;})
                .sorted((x, y) -> x.getKey().compareTo(y.getKey()))
                .forEachOrdered(c -> System.out.println(c.getKey() + " " + c.getValue()));

        // select first name, last name, title, salary from emp, filters highest salary by title, orders by salary desc
        System.out.println("\ncreate view Salaries as select title, max(salary) as 'maxsalary' from emp groupby title");
        System.out.println("select firstname, lastname, title, salary from emp inner join Salaries on emp.title = Salaries.title");
        System.out.println("where salary = maxsalary");
        emp.stream()
                .sorted((x,y) -> Integer.compare(Integer.parseInt(y.get(7).toString()), Integer.parseInt(x.get(7).toString())))
                .map(a -> a.get(6).toString())
                .distinct()
                .forEach(v -> System.out.println(
                        emp.stream()
                                .filter(n -> n.get(6).toString().equals(v))
                                .min((w,q) -> Integer.compare((Integer)q.get(7), (Integer)w.get(7) ))
                                .map(b -> b.get(2).toString() + " " + b.get(1).toString()).get()
                                + " " + v + " " +
                                emp.stream()
                                        .filter(n -> n.get(6).toString().equals(v))
                                        .map(a -> Integer.parseInt(a.get(7).toString()))
                                        .max((c,d) -> Integer.compare(c,d)).get()
                ));

    }
}









