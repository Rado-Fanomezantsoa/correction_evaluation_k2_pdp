package org.garage;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataRetriever dr = new DataRetriever();
        List<VenteParMarque> liste = dr.findVenteParMarque();
        System.out.println(liste);
    }
}