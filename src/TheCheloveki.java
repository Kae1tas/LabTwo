import java.util.Scanner;

class Human {
    String fam;
    String name;
    String sex;
    Double height;
}

public class TheCheloveki {
    static Scanner sc = new Scanner(System.in);

    public static Human[] setHumanArr(int k) {
        Human[] human = new Human[k];
        System.out.println("Введите информацию о людях:");

        for (int i = 0; i < human.length; i++) {
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
        return human;
    }

    public static void showArray(Human[] human) {
        for (int i = 0; i < human.length; i++) {
            System.out.println("" + human[i].fam + "\t" + human[i].name + "\t" + human[i].height + " см, пол:" + human[i].sex);
        }
    }

    public static void showHuman(Human human) {
        System.out.println("" + human.fam + "\t" + human.name + "\t" + human.height + " см, пол:" + human.sex);
    }

    public static void showHumanTwo(Human human) {
        System.out.println("" + human.fam + "\t" + human.name + "\t" + human.height + " см");
    }

    public static void sortSexFindHeight(Human[] human) {
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
    }

    public static Human manMax(Human[] human) {
        int nommax = 0;
        double max = 0.0;
        for (int i = 0; i < human.length; i++) {
            if (human[i].sex.equals("м") && human[i].height > max) {
                max = human[i].height;
                nommax = i;
            }
        }
        if (max != 0) {
            return human[nommax];
        }
        else return null;
    }

    public static void heightIncrease(Human[] human) {
        for (int i = 0; i < human.length - 1; i++)
            for (int j = 0; j < human.length - 1 - i; j++)
                if (human[j].height > human[j + 1].height) {
                    Human x = human[j + 1];
                    human[j + 1] = human[j];
                    human[j] = x;
                }
    }

    public static Human findHuman(Human[] human, String secondName) {
        int indexS = -1;
        for (int i = 0; i < human.length; i++)
            if (human[i].fam.equals(secondName)) {
                showHuman(human[i]);
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
                    return (human[indexS]);
                }
                case 2: {
                    System.out.println("Введите новую фамилию:");
                    sc.nextLine();
                    human[indexS].fam = sc.nextLine();
                    return (human[indexS]);
                }
                case 3: {
                    System.out.println("Введите новый рост:");
                    sc.nextLine();
                    human[indexS].height = sc.nextDouble();
                    return (human[indexS]);

                }
                case 4: {
                    System.out.println("Введите новый пол:");
                    sc.nextLine();
                    human[indexS].sex = sc.nextLine();
                    return (human[indexS]);

                }
                default: {
                    return null;
                }
            }
        }
        else{
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите количество людей => ");
        int count = sc.nextInt();
        Human[] human = setHumanArr(count);

        sortSexFindHeight(human);

        Human humanF = manMax(human);
        if (humanF != null) {
            System.out.print("Самый высокий мужчина =>");
            showHumanTwo(humanF);
        }
        else {
            System.out.println("Мужчин в списке нет");
        }

        heightIncrease(human);
        System.out.println("\nОтсортированный список по росту:");
        showArray(human);

        System.out.println("\nПОИСК ЧЕЛОВЕКА\nВведите имя и фамилию человека =>");
        String secondName = sc.nextLine();
        Human humanFind = findHuman(human, secondName);
        if (humanFind != null){
            showHuman(humanFind);
        }
        else{
            System.out.println("Ничего не найдено");
        }
    }
}