import java.util.Scanner;

public class TheChelovekiTwo {

    static Scanner sc = new Scanner(System.in);

    public static void main(Human[] human) {
        System.out.print("Введите количество людей => ");
        int count = sc.nextInt();
        System.out.println("Введите информацию о людях:");

        for (int i = 0; i < count; i++) {
            sc.nextLine();
            human[i] = new Human();
            System.out.println("Фамилия человека номер " + (i + 1));
            human[i].fam = sc.nextLine();
            System.out.println("Имя человека номер " + (i + 1));
            human[i].name = sc.nextLine();
            System.out.println("Пол человека номер " + (i + 1) + "(м/ж)");
            human[i].sex = sc.nextLine();
            System.out.println("Рост человека номер " + (i + 1));
            human[i].height = sc.nextDouble();
            sc.nextLine();
        }

        int kolw = 0;
        int kolm = 0;
        double wheight = 0;
        double mheight = 0;

        for (int i = 0; i < human.length; i++) {
            if (human[i].sex.equals("ж")) {
                kolw++;
                wheight += human[i].height;
            } else if (human[i].sex.equals("м")) {
                kolm++;
                mheight += human[i].height;
            }
        }

        if (kolw != 0 && kolm != 0) {
            double averageHeightWomen = wheight / kolw;
            double averageHeightMen = mheight / kolm;
            System.out.println("\nСредний рост мужчин =>" + averageHeightMen + "\nСредний рост женщин =>" + averageHeightWomen);
        } else if (kolw == 0 && kolm != 0) {
            double averageHeightMen = mheight / kolm;
            System.out.println("Средний рост мужчин =>" + averageHeightMen);
        } else if (kolw != 0) {
            double averageHeightWomen = wheight / kolw;
            System.out.println("Средний рост женщин =>" + averageHeightWomen);
        }

        int nommax = 0;
        double max = 0.0;
        for (int i = 0; i < human.length; i++) {
            if (human[i].sex.equals("м") && human[i].height > max) {
                max = human[i].height;
                nommax = i;
            }
        }
        if (max != 0) {
            System.out.print("\nСамый высокий мужчина =>");
            System.out.println("" + human[nommax].fam + "\t" + human[nommax].name + "\t" + human[nommax].height + " см");
        }
        else {
            System.out.println("\nМужчин в списке нет");
        }

        for (int i = 0; i < human.length; i++)
            for (int j = 0; j < human.length - i; j++)
                if (human[j].height > human[j + 1].height) {
                    Human x = human[j + 1];
                    human[j + 1] = human[j];
                    human[j] = x;
                }
        System.out.println("\nОтсортированный список по росту:");
        for (int i = 0; i < human.length; i++) {
            System.out.println("" + human[i].fam + "\t" + human[i].name + "\t" + human[i].height + " см, пол:" + human[i].sex);
        }

        System.out.println("\nПОИСК ЧЕЛОВЕКА\nВведите имя и фамилию человека =>");
        String secondName = sc.nextLine();
        int indexS = -1;
        for (int i = 0; i < human.length; i++)
            if (human[i].fam.equals(secondName)) {
                System.out.println("" + human[i].fam + "\t" + human[i].name + "\t" + human[i].height + " см, пол:" + human[i].sex);
                indexS = i;
            }

        if (indexS != -1) {
            System.out.println("\nВведите номер поля, которую хотите изменить");
            System.out.println("1 - Имя, 2 - Фамилия, 3 - Рост, 4 - Пол");
            int indexPole = sc.nextInt();
            switch (indexPole) {
                case 1: {
                    System.out.println("Введите новое имя:");
                    sc.nextLine();
                    human[indexS].name = sc.nextLine();
                    System.out.println("" + human[indexS].fam + "\t" + human[indexS].name + "\t" + human[indexS].height + " см, пол:" + human[indexS].sex);
                }
                case 2: {
                    System.out.println("Введите новую фамилию:");
                    sc.nextLine();
                    human[indexS].fam = sc.nextLine();
                    System.out.println("" + human[indexS].fam + "\t" + human[indexS].name + "\t" + human[indexS].height + " см, пол:" + human[indexS].sex);
                }
                case 3: {
                    System.out.println("Введите новый рост:");
                    sc.nextDouble();
                    human[indexS].height = sc.nextDouble();
                    System.out.println("" + human[indexS].fam + "\t" + human[indexS].name + "\t" + human[indexS].height + " см, пол:" + human[indexS].sex);
                }
                case 4: {
                    System.out.println("Введите новый пол:");
                    sc.nextLine();
                    human[indexS].sex = sc.nextLine();
                    System.out.println("" + human[indexS].fam + "\t" + human[indexS].name + "\t" + human[indexS].height + " см, пол:" + human[indexS].sex);
                }
                default: {
                    System.out.println("Ничего не найдено");
                }
            }
        }
        else {
            System.out.println("Ничего не найдено");
        }
    }
}
