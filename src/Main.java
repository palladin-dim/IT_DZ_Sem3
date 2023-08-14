import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество Дата_рождения Номер_телефона Пол), разделенные пробелом:");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: неверное количество данных.");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        long phoneNumber = Long.parseLong(data[4]);
        char gender = data[5].charAt(0);

        try {
            UserData userData = new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            saveUserDataToFile(userData);
            System.out.println("Данные успешно сохранены.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    private static void saveUserDataToFile(UserData userData) throws IOException {
        String fileName = userData.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userData.getLastName() + " " + userData.getFirstName() + " " + userData.getMiddleName() + " " + userData.getBirthDate() + " " + userData.getPhoneNumber() + " " + userData.getGender() + "\n");
        }
    }
}
