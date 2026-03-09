package org.garage;

public class VenteParMarque {

    public VenteParMarque() {
    }

    public VenteParMarque(String marque, int nbrePiece) {
        this.marque = marque;
        this.nbrePiece = nbrePiece;
    }

    private String marque;
    private int nbrePiece;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(int nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    @Override
    public String toString() {
        return "VenteParMarque{" +
                "marque='" + marque + '\'' +
                ", nbrePiece=" + nbrePiece +
                '}';
    }
}
