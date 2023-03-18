import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Hjälp en lärare att ta fram statistik om årets prov från filen prov.txt
        //  - Spara namnen i en endimensionell array
        //  - Spara provdata i en 2D-array
        //
        //  - Skriv ut varje students namn och genomsnittspoäng
        //  - Skriv för varje prov ut genomsnittspoängen (för alla studenter)

        int nbrStudents = 0;
        int nbrTests = 5;
        String[] names = new String[30];
        int[][] grades = new int[30][5];

        Scanner fileIn = new Scanner(new File("prov.txt"));
        while (fileIn.hasNextLine()) {
            names[nbrStudents] = fileIn.nextLine();
            for (int i=0; i < nbrTests; i++) {
                grades[nbrStudents][i] = fileIn.nextInt();
            }
            fileIn.nextLine();
            nbrStudents++;
        }

        for (int i=0; i < nbrStudents; i++) {
            double sum = 0;
            for (int j=0; j < nbrTests; j++) {
                sum += grades[i][j];
            }
            System.out.format("Genomsnittspoäng för %s: %.2f%n", names[i], (sum/nbrTests));
        }

        System.out.println();
        for (int i=0; i < nbrTests; i++) {
            double sum = 0;
            for (int j=0; j < nbrStudents; j++) {
                sum += grades[j][i];
            }
            System.out.format("Genomsnittspoäng för test %d: %.2f%n", i, (sum/nbrStudents));
        }
    }
}