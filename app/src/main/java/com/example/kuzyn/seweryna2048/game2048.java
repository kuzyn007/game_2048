package com.example.kuzyn.seweryna2048;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Kuzyn on 2015-08-18.
 */
public class game2048 {
    public int rozmiarPlanszy;
    public int[][] plansza;

    public game2048() {
        rozmiarPlanszy = 4;
        plansza = new int[rozmiarPlanszy][rozmiarPlanszy];
        AddNewNumber();
        AddNewNumber();
    }

    public int getRozmiarPlanszy() {
        return rozmiarPlanszy;
    }

    public void funCalc(String kierunek) {
        int wynik = 0;
        if(kierunek.equalsIgnoreCase("L"))
        {
            for(int j=0; j<rozmiarPlanszy; j++)
            {
                int pozycja=0;
                int ustawianieTablicy=0;
                for(int k=0; k<rozmiarPlanszy; k++)
                {
                    //przygotowanie pozycji liczb
                    if(plansza[j][k] == 0)
                    {
                        continue; //powrot do petli for z warunkiem "k"
                    }
                    if(k < rozmiarPlanszy-1)
                    {
                        pozycja = k+1;
                        while(pozycja < rozmiarPlanszy-1 && plansza[j][pozycja] == 0)
                        {
                            pozycja++;
                        }
                    }

                    //zakladanie kolejnych procesow co sie stanie z liczbami
                    if(plansza[j][k] == plansza[j][pozycja] && k<rozmiarPlanszy-1)
                    {
                        plansza[j][k] = plansza[j][k] + plansza[j][pozycja];
                        plansza[j][pozycja] = 0;
                        wynik += plansza[j][k]; //powiekszanie wyniku
                    }

                    //ustawianie nowej tablicy do wybranej krawedzi planszy
                    plansza[j][ustawianieTablicy] = plansza[j][k];
                    if(k>0 && k != ustawianieTablicy)
                    {
                        plansza[j][k]=0;
                    }
                    ustawianieTablicy++;
                }
            }
        }

        if(kierunek.equalsIgnoreCase("R"))
        {
            for(int j=rozmiarPlanszy-1; 0<=j; j--)
            {
                int pozycja=rozmiarPlanszy-1;
                int ustawianieTablicy=rozmiarPlanszy-1;
                for(int k=rozmiarPlanszy-1; 0<=k; k--)
                {
                    //przygotowanie pozycji liczb
                    if(plansza[j][k] == 0)
                    {
                        continue; //powrot do petli for z warunkiem "k"
                    }
                    if(k > 0)
                    {
                        pozycja = k-1;
                        while(pozycja > 0 && plansza[j][pozycja] == 0)
                        {
                            pozycja--;
                        }
                    }

                    //zakladanie kolejnych procesow co sie stanie z liczbami
                    if(plansza[j][k] == plansza[j][pozycja] && k>0)
                    {
                        plansza[j][k] = plansza[j][k] + plansza[j][pozycja];
                        plansza[j][pozycja] = 0;
                        wynik += plansza[j][k]; //powiekszanie wyniku
                    }

                    //ustawianie nowej tablicy do wybranej krawedzi planszy
                    plansza[j][ustawianieTablicy] = plansza[j][k];
                    if(k<rozmiarPlanszy-1 && k != ustawianieTablicy)
                    {
                        plansza[j][k]=0;
                    }
                    ustawianieTablicy--;
                }
            }
        }

        if(kierunek.equalsIgnoreCase("G"))
        {
            for(int k=0; k<rozmiarPlanszy; k++)
            {
                int pozycja=0;
                int ustawianieTablicy=0;
                for(int j=0; j<rozmiarPlanszy; j++)
                {
                    //przygotowanie pozycji liczb
                    if(plansza[j][k] == 0)
                    {
                        continue; //powrot do petli for z warunkiem "k"
                    }
                    if(j < rozmiarPlanszy-1)
                    {
                        pozycja = j+1;
                        while(pozycja < rozmiarPlanszy-1 && plansza[pozycja][k] == 0)
                        {
                            pozycja++;
                        }
                    }

                    //zakladanie kolejnych procesow co sie stanie z liczbami
                    if(plansza[j][k] == plansza[pozycja][k] && j<rozmiarPlanszy-1)
                    {
                        plansza[j][k] = plansza[j][k] + plansza[pozycja][k];
                        plansza[pozycja][k] = 0;
                        wynik += plansza[j][k]; //powiekszanie wyniku
                    }

                    //ustawianie nowej tablicy do wybranej krawedzi planszy
                    plansza[ustawianieTablicy][k] = plansza[j][k];
                    if(j>0 && j != ustawianieTablicy)
                    {
                        plansza[j][k]=0;
                    }
                    ustawianieTablicy++;
                }
            }
        }

        if(kierunek.equalsIgnoreCase("D")) {
            for (int k = rozmiarPlanszy - 1; 0 <= k; k--) {
                int pozycja = rozmiarPlanszy - 1;
                int ustawianieTablicy = rozmiarPlanszy - 1;
                for (int j = rozmiarPlanszy - 1; 0 <= j; j--) {
                    //przygotowanie pozycji liczb
                    if (plansza[j][k] == 0) {
                        continue; //powrot do petli for z warunkiem "k"
                    }
                    if (j > 0) {
                        pozycja = j - 1;
                        while (pozycja > 0 && plansza[pozycja][k] == 0) {
                            pozycja--;
                        }
                    }

                    //zakladanie kolejnych procesow co sie stanie z liczbami
                    if (plansza[j][k] == plansza[pozycja][k] && j > 0) {
                        plansza[j][k] = plansza[j][k] + plansza[pozycja][k];
                        plansza[pozycja][k] = 0;
                        wynik += plansza[j][k]; //powiekszanie wyniku
                    }

                    //ustawianie nowej tablicy do wybranej krawedzi planszy
                    plansza[ustawianieTablicy][k] = plansza[j][k];
                    if (j < rozmiarPlanszy - 1 && j != ustawianieTablicy) {
                        plansza[j][k] = 0;
                    }
                    ustawianieTablicy--;
                }
            }
        }
    }


    public boolean AddNewNumber() {
        boolean spr = true;
        breakLoop:
        for (int i = 0; i < rozmiarPlanszy; i++) {
            for (int j = 0; j < rozmiarPlanszy; j++) {
                if (plansza[i][j] == 0) {
                    spr = true;
                    break breakLoop;
                } else if (plansza[i][j] > 0) {
                    spr = false;
                    continue;
                }
            }
        }
        Random randd = new Random();
        while (spr == true) {
            int posX = randd.nextInt(rozmiarPlanszy);
            int posY = randd.nextInt(rozmiarPlanszy);
            if (plansza[posX][posY] > 0) {
                continue;
            } else if (plansza[posX][posY] == 0) {
                plansza[posX][posY] = 2;
                break;
            }
        }
        return spr;
    }

    public String getFromTable(int posX, int posY) {
        return Integer.toString(plansza[posX][posY]);
    }

    public void makeMoveForArrow(String kierunek, Vector<ImageView> komorki,HashMap<String, Drawable> mapImages) {
        funCalc(kierunek);
        AddNewNumber();
        updateText(komorki,mapImages);
    }

    private void updateText(Vector<ImageView> komorki,HashMap<String, Drawable> mapImages) {
        int lok=0;
        for(int i=0;i<rozmiarPlanszy;i++) {
            for(int j=0;j<rozmiarPlanszy;j++) {
                //komorki.get(lok).setText("10");
                komorki.get(lok).setImageDrawable(mapImages.get(getFromTable(i, j)));
                lok++;
            }
        }
    }

}
