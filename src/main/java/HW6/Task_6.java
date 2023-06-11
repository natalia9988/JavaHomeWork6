package HW6;
//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков (Set).
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map или в Сет. Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - цвет
//        2 - бренд
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
public class Task_6 { public static void main(String[] args) {
    Notebook nb1 = new Notebook("Asus", "15 D543MA-DM1368", "Windows 10", "black");
    Notebook nb2 = new Notebook("Acer", "Aspire 3 A315-23-R0HR",  "Windows 10", "black");
    Notebook nb3 = new Notebook("Lenovo", "IdeaPad 3 15IML05", "Windows 11", "gray");
    Notebook nb4 = new Notebook("MSI", "Modern 15 B11-002RU", "Windows 11", "black");
    Notebook nb5 = new Notebook("MSI", "Summit E13 Flip Evo A12MT-061RU",  "Без ОС", "gray");
    Notebook nb6 = new Notebook("Asus", "ROG Zephyrus G14 GA402RJ-L4045",  "Без ОС", "white");
    Notebook nb7 = new Notebook("MSI", "Raider GE78 HX 13VH-094RU", "Windows 11", "black");
    Notebook nb8 = new Notebook("Apple", "MacBook Air",  "macOS", "white");

    HashSet<Notebook> notebooks = new HashSet<Notebook>(
            Arrays.asList(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8));

    Scanner sc = new Scanner(System.in, "cp866");
    System.out.println();
    System.out.println("Добро пожаловать в наш интернет-магазин!\n" +
            "Введите цифру, соответствующую необходимому критерию: \n");
    boolean filter = true;
    while (filter) {
        System.out.println("1 - Выбрать по производителю.\n" +
                "2 - Выбрать по операционной системе.\n" +
                "3 - Выбрать по цвету.\n" +
                "4 - Посмотреть все модели.\n" +
                "0 - Для выхода из каталога.");

        String operation = sc.nextLine();
        switch (operation) {
            case "1":
                filterBrand(notebooks, sc);
                break;
            case "2":
                filterOS(notebooks, sc);
                break;
            case "3":
                filterColor(notebooks, sc);
                break;
            case "4":
                showCatalog(notebooks);
                break;
            case "0":
                System.out.println("Ждем вас снова!");
                filter = false;
                break;
            default:
                System.out.println("Введена неправильная операция");
                System.out.println();
                break;
        }
    }

}
    // Функция фильтра по брэнду
    public static void filterBrand(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> brand = new TreeSet<>();
        for (Notebook note : notebooks) {
            brand.add(note.getBrand());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки следующих фирм "
                + brand.toString().replaceAll("^\\[|\\]$", "") +
                "Введите интересующее значение: ");

        String op = scanner.nextLine();
        if (brand.contains(op)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getBrand().equals(op)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterBrand(notebooks, scanner);
        }

    }
  
    // Функция поиска по ОС
    public static void filterOS(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> opSystems = new TreeSet<>();
        for (Notebook note : notebooks) {
            opSystems.add(note.getOpSystem());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены операционные системы: "
                + opSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую ОС: ");

        String op = scanner.nextLine().toUpperCase();
        if (opSystems.contains(op)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getOpSystem().equals(op)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой ОС. Попробуйте снова");
            filterOS(notebooks, scanner);

        }
    }
    // Функция поиска по цвету
    public static void filterColor(HashSet<Notebook> notebooks, Scanner scanner){
        TreeSet<String> colors = new TreeSet<>();
        for (Notebook note: notebooks){
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("В нашем каталоге представлены ноутбуки следующих цветов: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий цвет: ");

        String op = scanner.nextLine().toLowerCase();
        if (colors.contains(op)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getColor().equals(op)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого цвета. Попробуйте снова");
            filterColor(notebooks, scanner);
        }
    }
    // Функция вывода полного каталога в консоль
    public static void showCatalog(HashSet<Notebook> notebooks){
        System.out.println();
        System.out.println("Полный каталог ноутбуков: ");
        System.out.println();
        for (Notebook note : notebooks) {
            note.showInfo();
        }
    }
}

