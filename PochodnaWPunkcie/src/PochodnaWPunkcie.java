import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PochodnaWPunkcie {

    private final ArrayList<Punkt> listaPunktow;
    PochodnaWPunkcie (){

        listaPunktow=new ArrayList<>();

    }


    void odczytZPliku (String nazwaPliku){//metoda odczytująca z pliku punkty


        File file = new File(nazwaPliku);//tworzenie obiektu file

        try {
            Scanner scanner = new Scanner(file);
            //System.out.println("test");
            while (scanner.hasNextDouble()) {//dopóki są liczby double w pliku

                Punkt punkt=new Punkt();

                punkt.setLocation(scanner.nextDouble(), scanner.nextDouble());
                listaPunktow.add(punkt);
                System.out.println("punkt: ("+punkt.getX()+","+punkt.getY()+")");
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku lub nie da się otworzyć");
            System.exit(0);
        }
        catch (InputMismatchException e) {
            System.out.println("Dane w pliku nie są liczbami");
            System.exit(0);
        }
        //System.out.println(listaPunktow);
    }

    void obliczRoznicaZwykla(double x) {//metoda obliczająca pochodna w punkcie x za pomocą różnicy zwykłej

        int i = listaPunktow.size();
        double[][] roznicaZwykla;
        double h =listaPunktow.get(1).getX()-listaPunktow.get(0).getX();
        roznicaZwykla = new double[i - 1][i];

        for (int k = 0; k < i-1; k++) {

            int n = i-k-1;
            for (int j = 0; j < n; j++) {
                //System.out.println("test");
                if(k==0) {
                    roznicaZwykla[k][j] = listaPunktow.get(j + 1).getY() - listaPunktow.get(j).getY();
                    System.out.println("Różnica zwykła: " + roznicaZwykla[k][j]);
                }
                else{
                    roznicaZwykla[k][j] = roznicaZwykla[k-1][j+1] - roznicaZwykla[k-1][j];
                    System.out.println("Różnica zwykła "+ k +" " + roznicaZwykla[k][j]);
                }
            }
        }

        double wynik=0;
        for(int k=0; k<i-1; k++){

            if(listaPunktow.get(k).getX()==x){

                for(int j=0; j<i-k; j++){
                    System.out.println("test: "+roznicaZwykla[j][k]);
                    if (j%2==0){
                        if (j==0) {
                            wynik += roznicaZwykla[j][k];
                        }
                        else {
                            wynik += (1.0/(j + 1.0)) * roznicaZwykla[j][k];
                        }
                    }
                    else{
                        wynik += ((-1.0)/(j + 1.0)) * roznicaZwykla[j][k];
                    }
                    //System.out.println("test wynik: "+wynik);
                }
            }

        }
        wynik=wynik*(1/h);
        System.out.println("Wartość pochodnej przy użyciu metody różnicy zwykłej wynosi: " + wynik);

    }
    void obliczRoznicaWsteczna(double x){

        int i = listaPunktow.size();
        double[][] roznicaWsteczna;
        double h =listaPunktow.get(1).getX()-listaPunktow.get(0).getX();
        roznicaWsteczna = new double[i - 1][i];

        for (int k = 0; k < i-1; k++) {

            int n = i-k-1;
            for (int j = 0; j < n; j++) {
                //System.out.println("test");
                if(k==0) {
                    roznicaWsteczna[k][j] = listaPunktow.get(j + 1).getY() - listaPunktow.get(j).getY();

                    System.out.println("Różnica wsteczna: " + roznicaWsteczna[k][j]);
                }
                else{
                    roznicaWsteczna[k][j] = roznicaWsteczna[k-1][j+1] - roznicaWsteczna[k-1][j];
                    System.out.println("Różnica wsteczna "+ k +" " + roznicaWsteczna[k][j]);
                }
            }
        }
        double wynik=0;
        for(int k=0; k<i-1; k++){

            if(listaPunktow.get(k).getX()==x){

                for(int j=0; j<i-k; j++){
                    System.out.println("test: "+roznicaWsteczna[j][k]);
                    if (j%2==0){
                        if (j==0) {
                            wynik += roznicaWsteczna[j][k];
                        }
                        else {
                            wynik += (1.0/(j + 1.0)) * roznicaWsteczna[j][k];
                        }
                    }
                    else{
                        wynik += ((-1.0)/(j + 1.0)) * roznicaWsteczna[j][k];
                    }
                    //System.out.println("test wynik: "+wynik);
                }
            }

        }
        wynik=wynik*(1/h);
        System.out.println("Wartość pochodnej przy użyciu metody różnicy wstecznej wynosi: " + wynik);

    }



}
