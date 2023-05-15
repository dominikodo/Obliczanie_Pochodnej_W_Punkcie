import java.util.ArrayList;
import java.util.Scanner;

public class PochodnaWPunkcieTest {

    public static void main(String[] args) {

        boolean wylacz = false;
        while (wylacz==false) {

            double x=0;

            ArrayList<Punkt> listaPunktow;
            listaPunktow = new ArrayList<>();


            PochodnaWPunkcie pochodnaWPunkcie = new PochodnaWPunkcie();
            Scanner scanner = new Scanner(System.in);

            String nazwaPliku = new String();

            System.out.println("Podaj nazwe ścieżkę pliku: ");

            nazwaPliku = scanner.nextLine();

            pochodnaWPunkcie.odczytZPliku(nazwaPliku);

            listaPunktow=pochodnaWPunkcie.getListaPunktow();

            for(int i=0;i<listaPunktow.size();i++) {
                pochodnaWPunkcie.obliczRoznicaZwykla(listaPunktow.get(i).getX());
            }

            System.out.println("");

            for(int i=0;i<listaPunktow.size();i++) {
                pochodnaWPunkcie.obliczRoznicaWsteczna(listaPunktow.get(i).getX());
            }

            System.out.println("");

            for(int i=0;i<listaPunktow.size();i++) {
                pochodnaWPunkcie.obliczRoznicaCentralnej(listaPunktow.get(i).getX());
            }

            //C:\Users\piese\Desktop\Metody Obliczeniowe\Obliczanie_Pochodnej_W_Punkcie\PochodnaWPunkcie\plik.txt
        }


    }
}
