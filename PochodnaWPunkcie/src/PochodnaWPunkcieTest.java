import java.util.Scanner;

public class PochodnaWPunkcieTest {

    public static void main(String[] args) {

        boolean wylacz = false;
        while (wylacz==false) {

            PochodnaWPunkcie pochodnaWPunkcie = new PochodnaWPunkcie();
            Scanner scanner = new Scanner(System.in);

            String nazwaPliku = new String();

            System.out.println("Podaj nazwe ścieżkę pliku: ");

            nazwaPliku = scanner.nextLine();

            pochodnaWPunkcie.odczytZPliku(nazwaPliku);

            pochodnaWPunkcie.obliczRoznicaZwykla();

            //C:\Users\piese\Desktop\Metody Obliczeniowe\Obliczanie_Pochodnej_W_Punkcie\PochodnaWPunkcie\plik.txt
        }


    }
}
