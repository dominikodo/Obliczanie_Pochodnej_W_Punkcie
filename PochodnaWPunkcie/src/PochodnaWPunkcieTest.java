import java.util.Scanner;

public class PochodnaWPunkcieTest {

    public static void main(String[] args) {

        boolean wylacz = false;
        while (wylacz==false) {

            double x=0;

            PochodnaWPunkcie pochodnaWPunkcie = new PochodnaWPunkcie();
            Scanner scanner = new Scanner(System.in);

            String nazwaPliku = new String();

            System.out.println("Podaj nazwe ścieżkę pliku: ");

            nazwaPliku = scanner.nextLine();

            pochodnaWPunkcie.odczytZPliku(nazwaPliku);

            System.out.println("Podaj x dla którego ma zostać obliczona pochodna: ");

            x=scanner.nextDouble();

            pochodnaWPunkcie.obliczRoznicaZwykla(x);

            pochodnaWPunkcie.obliczRoznicaWsteczna(x);

            //C:\Users\piese\Desktop\Metody Obliczeniowe\Obliczanie_Pochodnej_W_Punkcie\PochodnaWPunkcie\plik.txt
        }


    }
}
