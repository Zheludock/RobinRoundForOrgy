import java.util.Scanner;

public class People {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество людей: ");
        int numPeoples = scanner.nextInt();
        if (numPeoples < 3) {
            System.out.println("Для оргии нужны хотя бы трое");
            return;
        }
        String[] people = new String[numPeoples];
        for (int i = 0; i < numPeoples; i++) {
            System.out.print("Введите имя человека(или животного, если у вас там полный пиздец) " + (i + 1) + ": ");
            String peopleName = scanner.next();
            people[i] = peopleName;
        }
        String[] evenPeoples;
        if (numPeoples % 2 == 0) {
            evenPeoples = new String[numPeoples - 1];
            for (int k = 0; k < numPeoples - 1; k++)
                evenPeoples[k] = people[k + 1];
        } else {
            evenPeoples = new String[numPeoples];
            for (int k = 0; k < numPeoples - 1; k++)
                evenPeoples[k] = people[k + 1];
            evenPeoples[numPeoples - 1] = "masturbate";
        }
        int peopleSize = evenPeoples.length; //it is even number
        int halfSize = (peopleSize + 1) / 2;
        int count = 0;
        for (int day = peopleSize - 1; day >= 0; day--) {
            System.out.println("week " + (++count));
            int whoFor0 = day % peopleSize;
            if (!evenPeoples[whoFor0].equals("masturbate")) {
                System.out.println(people[0] + " sex with " + evenPeoples[whoFor0]);
            }
            for (int i = 1; i < halfSize; i++) {
                int firstTeam = (day + i) % peopleSize;
                int secondTeam = (day + peopleSize - i) % peopleSize;
                if (!evenPeoples[firstTeam].equals("masturbate") && !evenPeoples[secondTeam].equals("masturbate")) {
                    System.out.println(evenPeoples[firstTeam] + " sex with " + evenPeoples[secondTeam]);
                }
            }
            System.out.println();
        }
    }
}