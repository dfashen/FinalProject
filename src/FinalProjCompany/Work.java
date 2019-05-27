package FinalProjCompany;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Work {

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Mycompany?serverTimezone=UTC";

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

    public void sortList(int r) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String que = "select e.id, name, salary, spec from employees e left join positions p on (e.id_work = p.id) where e.id = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(que);
            preparedStatement.setInt(1, r);
            preparedStatement.execute();
        } catch (SQLException e) {
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

    void delete(int x) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from employees e where e.id = ?;");
            preparedStatement.setInt(1, x);
            System.out.println("done");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employees where id = ?;");
            preparedStatement.setInt(1, x);
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


