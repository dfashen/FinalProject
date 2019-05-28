package FinalProjCompany;

import java.util.Scanner;

public class Start {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    Work wk = new Work();
    Scanner sc = new Scanner(System.in);

    public void doStart() {

        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println(DRIVER_NAME + " не удалось загрузить");
            return;
        }

        System.out.println("-=Добро пожаловать в программу для учёта сотрудников фирмы=-");
        System.out.println("Введите пожалуйста пароль");   // пароль будет число/месяц(без 0)/год , например 2652019, каждый день пароль меняется
        int a = sc.nextInt();
        int y = wk.pincode();

        if (a != y) {
            System.out.println("Неверный пароль/Обратитесь к Офис-Менеджеру для уточнения пароля");
        } else {
            System.out.println("Добро пожаловать!");
            prostoList();
            int b = sc.nextInt();
            while (b != 0) {
                switch (b) {
                    case 1:
                        doList();
                        break;
                    case 2:
                        finance();
                        break;
                    case 3:
                        personal();
                        break;


                    default:
                        System.out.println("Неправильный ввод");
                        break;
                }
            }

        }
    }

    public void prostoList() {
        System.out.println("1. Cписок работающих людей;" + '\n' +
                "2. Работа с финансовыми вопросами сотрудников;" + '\n' +
                "3. Кадравая работа с сотрудниками компании" + '\n' +
                "0. Выход");
        int x = sc.nextInt();
        if (x == 1) doList();
        else if (x == 2) finance();
        else if (x == 3) personal();
        else if (x == 0) {
            System.out.println("Вы уверенны? (0 для подтверждения)");
            System.out.println("До свидания!");

        }       else
        System.out.println("Неправильный ввод");
    }

    public void doList() {
        System.out.println("1. Полный список" + '\n' + "2. Вывод отдельного сотрудника " + '\n' + "0.Назад");
        int c = sc.nextInt();
        if (c == 1) {
            wk.greateList();

        } else if (c == 2) {
            System.out.println("Введите ID сотрудника");
            wk.sortList(sc.nextInt());
        } else if (c == 0)
            prostoList();
        else {
            System.out.println("Неправильный ввод");
        }

    }

    public void finance() {
        System.out.println("1. Увеличить зп сотрудника" + '\n' + "2. Снизить зп сотрудника" + '\n' + "0.Назад");
        int d = sc.nextInt();
        switch (d) {
            case 1:
                System.out.println("Введите через пробел сумму и ID сотрудника");
                wk.premia(sc.nextInt(), sc.nextInt());
                break;
            case 2:
                System.out.println("Введите через пробел сумму и ID сотрудника");
                wk.minus(sc.nextInt(), sc.nextInt());
                break;
            case 0:
                prostoList();
                break;
            default:
                System.out.println("Неправильный ввод");
                break;
        }
    }

    public void personal() {
        System.out.println("1. Уволить сотрудника" + '\n' + "2. Принять нового сотрудника" + '\n' + "0. Назад");
        int e = sc.nextInt();
        switch (e) {
            case 1:
                wk.delete();
                break;
            case 2:
                wk.priem();
                break;
            case 0:
                prostoList();
                break;
            default:
                System.out.println("Неправильный ввод");
                break;
        }

    }
}