package FinalProjCompany;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Work {

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Mycompany?serverTimezone=UTC";
    Scanner sa = new Scanner(System.in);
    public int pincode() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dMy");
        int i = Integer.parseInt(format.format(date));
        return i;
    }

    public void greateList() {
        Connection connection;
        List<Employees> employeesList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String query = "select * from employees e " +
                    "left join positions p on (e.id_work = p.id);";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("e.id");
                String name = resultSet.getString("name");
                int idwork = resultSet.getInt("id_work");
                String spec = resultSet.getString("spec");
                int salary = resultSet.getInt("salary");

                Employees empl = new Employees(id, name, new Positions(idwork, spec), salary);
                employeesList.add(empl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        employeesList.forEach(System.out::println);
    }

    //?
    public void sortList(int r) {
             try {
                 Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String que = "select e.id, name, salary, spec from employees e left join positions p on (e.id_work = p.id) where e.id =" +r+ ";";
            ResultSet resultSet = statement.executeQuery(que);
            while (resultSet.next()) {
                int id = resultSet.getInt("e.id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("spec");
                int salary = resultSet.getInt("salary");
                System.out.printf("%d) %-10s %-10s %5d ", id, name, specialty, salary);
                System.out.println("");

        } }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void premia(int x, int z) {
        Connection connection;
        if (x >= 0 && z > 0) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement("update employees set salary = (salary + ?) where id = ?;");
                preparedStatement.setInt(1, x);
                preparedStatement.setInt(2, z);
                preparedStatement.execute();
                System.out.println("done");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("Вы сделали что то не так =(");
    }

    public void minus(int x, int z) {
        Connection connection;
        if (x >= 0 && z > 0) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement("update employees set salary = (salary - ?) where id = ?;");
                preparedStatement.setInt(1, x);
                preparedStatement.setInt(2, z);
                preparedStatement.execute();
                System.out.println("done");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("Вы сделали что то не так =(");
    }

    void delete() {

        System.out.println("Введите имя");
        String s =sa.nextLine();
                       try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    Statement statement = connection.createStatement();
                    statement.execute("delete from employees where name ='" +s+ "';");
                           System.out.println("Уволен");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
void priem(){
    System.out.println("Введите имя");
    String name = sa.nextLine();
    System.out.println("Введите номер должности");
    int id_work=sa.nextInt();
    System.out.println("Введите зарплату");
    int salary = sa.nextInt();
    try {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement statement = connection.createStatement();

        statement.execute("insert into employees values (null, '"+name+"',"+ id_work+","+ salary+");");
        System.out.println("Поздравляем с зачислением " + name + " в штат сотрудников!");
    } catch (SQLException e){
        e.printStackTrace();
    }

}
}




