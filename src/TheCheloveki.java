import java.util.Scanner;

class Human{
    String fam, name, sex, height;
}

public class TheCheloveki {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество людей");
        int count = sc.nextInt();
        sc.nextLine();
        Human[] human = new Human[count];
        System.out.println("Введите информацию людях: ");

        for (int i = 0; i < count; i++) {
            sc.nextLine();
            human[i] = new Human();
            System.out.print("Фамилия человека номер " + (i + 1));
            human[i].name = sc.nextLine();
            System.out.print("Имя человека номер " + (i + 1));
            /*sfdfdf

             */
        }
    
    }
}
