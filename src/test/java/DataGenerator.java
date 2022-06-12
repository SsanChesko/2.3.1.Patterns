import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String city() {

        String[] cities = {"Майкоп",
                "Горно-Алтайск",
                "Уфа",
                "Улан-Удэ",
                "Махачкала",
                "Магас",
                "Нальчик",
                "Элиста",
                "Черкесск",
                "Петрозаводск",
                "Сыктывкар",
                "Симферополь",
                "Йошкар-Ола",
                "Саранск",
                "Якутск",
                "Владикавказ",
                "Казань",
                "Кызыл",
                "Ижевск",
                "Абакан",
                "Грозный",
                "Чебоксары",
                "Барнаул",
                "Чита",
                "Петропавловск-Камчатский",
                "Краснодар",
                "Красноярск",
                "Пермь",
                "Владивосток",
                "Ставрополь",
                "Хабаровск",
                "Благовещенск",
                "Архангельск",
                "Астрахань",
                "Белгород",
                "Брянск",
                "Владимир",
                "Волгоград",
                "Вологда",
                "Воронеж",
                "Иваново",
                "Иркутск",
                "Калининград",
                "Калуга",
                "Кемерово",
                "Киров",
                "Кострома",
                "Курган",
                "Курск",
                "Санкт-Петербург",
                "Липецк",
                "Магадан",
                "Москва",
                "Красногорск",
                "Мурманск",
                "Нижний Новгород",
                "Великий Новгород",
                "Новосибирск",
                "Омск",
                "Оренбург",
                "Орёл",
                "Пенза",
                "Псков",
                "Ростов-на-Дону",
                "Рязань",
                "Самара",
                "Саратов",
                "Южно-Сахалинск",
                "Екатеринбург",
                "Смоленск",
                "Тамбов",
                "Тверь",
                "Томск",
                "Тула",
                "Тюмень",
                "Ульяновск",
                "Челябинск",
                "Ярославль",
                "Нарьян-Мар",
                "Ханты-Мансийск",
                "Анадырь",
                "Салехард",
        };
        Random random = new Random();
        String newCity = cities[random.nextInt(cities.length)];
        System.out.println(Arrays.toString(new String[]{newCity}));
        return newCity;
    }

    public static String generateDate(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }


    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }
}

