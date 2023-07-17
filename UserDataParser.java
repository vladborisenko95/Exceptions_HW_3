import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class UserDataParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите режим записи данных:");
        System.out.println("1. Записать в произвольном порядке");
        System.out.println("2. Записать по порядку");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки после выбора режима

        String[] data;

        if (choice == 1) {
            System.out.print("Введите данные (в формате '1 Фамилия 2 Имя 3 Отчество 4 Дата_рождения 5 Номер_телефона 6 Пол')\n" +
                             "Цифры перед каждым значением указывают на соответствующий ключ данных" +
                             "Например: 2 Иван 3 Иванович 5 8912356789 6 m 1 Иванов 4 01.02.1995\n: ");
            String userInput = scanner.nextLine();
            data = userInput.split("\\s+");
        } else if (choice == 2) {
            data = new String[12];

            System.out.print("Введите фамилию: ");
            data[0] = "1";
            data[1] = scanner.nextLine();

            System.out.print("Введите имя: ");
            data[2] = "2";
            data[3] = scanner.nextLine();

            System.out.print("Введите отчество: ");
            data[4] = "3";
            data[5] = scanner.nextLine();

            System.out.print("Введите дату рождения (в формате dd.mm.yyyy): ");
            data[6] = "4";
            data[7] = scanner.nextLine();

            System.out.print("Введите номер телефона: ");
            data[8] = "5";
            data[9] = scanner.nextLine();

            System.out.print("Введите пол (m или f): ");
            data[10] = "6";
            data[11] = scanner.nextLine();
        } else {
            System.out.println("Неверный выбор режима.");
            return;
        }

        scanner.close();

        try {
            // Распарсим данные и создадим объект UserData
            UserData userData = new UserData(data);

            // Записываем данные в файл
            FileWriter writer = new FileWriter(userData.getLastName() + ".txt", true);
            writer.write(userData.toString() + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}