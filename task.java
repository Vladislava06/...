import java.util.Scanner;

public class task {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println("Введите данные: Фамилия Имя Отчество датарождения номер телефона пол");
String input = scanner.nextLine();

String[] data = input.split(" ");

try {
parseUserData(data);
System.out.println("Данные введены корректно.");
} catch (IllegalArgumentException e) {
System.out.println("Ошибка: " + e.getMessage());
}
}

private static void parseUserData(String[] data) {
if (data.length != 6) {
throw new IllegalArgumentException("Некорректное количество данных!");
}

String lastName = data[0];
String firstName = data[1];
String middleName = data[2];
String dateOfBirth = data[3];
String phoneNumber = data[4];
String gender = data[5];

parseDateOfBirth(dateOfBirth);
parsePhoneNumber(phoneNumber);
parseGender(gender);
}

private static void parseDateOfBirth(String dateOfBirth) {
if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
throw new IllegalArgumentException("Некорректный формат даты рождения! Ожидается формат dd.mm.yyyy");
}

}

private static void parsePhoneNumber(String phoneNumber) {
try {
Long.parseLong(phoneNumber);
} catch (NumberFormatException e) {
throw new IllegalArgumentException("Некорректный формат номера телефона! Ожидается целое беззнаковое число.");
}

}

private static void parseGender(String gender) {
if (!gender.equals("f") && !gender.equals("m")) {
throw new IllegalArgumentException("Некорректный пол! Ожидается символ 'f' или 'm'.");
}

}
}