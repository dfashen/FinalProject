package FinalProjCompany;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Work {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Mycompany?serverTimezone=UTC";

    public int pincode(){
        Date date= new Date ();
        SimpleDateFormat format = new SimpleDateFormat ("dMy");
        int i = Integer.parseInt(format.format(date));
                     return i;
            }

            public void greateList(){
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
            }}catch (SQLException e) {
                    e.printStackTrace();
                }
                employeesList.forEach(System.out::print);}



        public void doWork() {
            Scanner sc = new Scanner(System.in);
            try {
                Class.forName(DRIVER_NAME);
            } catch (ClassNotFoundException e) {
                System.err.println(DRIVER_NAME + " не удалось загрузить");
                return;
            }

            System.out.println("-=Добро пожаловать в программу для учёта сотрудников фирмы=-");
            System.out.println("Введите пожалуйста пароль");   // пароль будет число/месяц(без 0)/год , например 2652019
            int a = sc.nextInt();
            int y = pincode();

            if (a != y) {
                System.out.println("Неверный пароль/Обратитесь к Офис-Менеджеру для уточнения пароля");
            } else {
                System.out.println("1. Полный список работающих людей;" +  '\n' +
                        "2. Работа с финансовыми вопросами сотрудников;" +  '\n' +
                        "3. Кадравая работа с сотрудниками компании"+  '\n' +
                        "0. Выход/Назад");
                int b = sc.nextInt();
                while (b!=0){
                    switch (b) {
                        case 1:
                            System.out.println("1. Полный список"+  '\n' + " 2. Сортировка списка ");
                            int c = sc.nextInt();
                            switch(c){
                                case 1:
                                    greateList();
                                    break;
                                case 2:

                            }
                    }
                }




            }

        }




    }


