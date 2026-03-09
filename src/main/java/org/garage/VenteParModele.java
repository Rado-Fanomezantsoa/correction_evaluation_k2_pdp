package org.garage;

public class VenteParModele {

    public VenteParModele() {
    }

    public VenteParModele(int getz, int lacetti, int pride) {
        this.getz = getz;
        this.lacetti = lacetti;
        this.pride = pride;
    }

    private int getz;
    private int pride;
    private int lacetti;

    public int getGetz() { return getz; }
    public void setGetz(int getz) { this.getz = getz; }

    public int getPride() { return pride; }
    public void setPride(int pride) { this.pride = pride; }

    public int getLacetti() { return lacetti; }
    public void setLacetti(int lacetti) { this.lacetti = lacetti; }

    @Override
    public String toString() {
        return "VenteParModele{" +
                "getz=" + getz +
                ", pride=" + pride +
                ", lacetti=" + lacetti +
                '}';
    }
}
