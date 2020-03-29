package com.company;

public class fuvar {
    private int azonosito;
    private String indulas_idopont;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetes_modja;

    public fuvar(String sor) {
       String[] adatok= sor.split(";");
        this.azonosito = Integer.parseInt(adatok[0]);
        this.indulas_idopont = adatok[1];
        this.idotartam = Integer.parseInt(adatok[2]);
        this.tavolsag = Double.parseDouble(adatok[3].replace(",","."));
        this.viteldij = Double.parseDouble(adatok[4].replace(",","."));
        this.borravalo = Double.parseDouble(adatok[5].replace(",","."));
        this.fizetes_modja = adatok[6];
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getIndulas_idopont() {
        return indulas_idopont;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    @Override
    public String toString() {
        return "fuvar{" +
                "azonosito=" + azonosito +
                ", indulas_idopont='" + indulas_idopont + '\'' +
                ", idotartam=" + idotartam +
                ", tavolsag=" + tavolsag +
                ", viteldij=" + viteldij +
                ", borravalo=" + borravalo +
                ", fizetes_modja='" + fizetes_modja + '\'' +
                '}';
    }
}
