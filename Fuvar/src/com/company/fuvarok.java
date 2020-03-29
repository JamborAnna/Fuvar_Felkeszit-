package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fuvarok {
    private List<fuvar> lista;

    public fuvarok(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String elso_sor = reader.readLine();
        String sor = reader.readLine();
        lista = new ArrayList<fuvar>();
        while(sor != null){
            fuvar current = new fuvar(sor);
            lista.add(current);
            sor = reader.readLine();
        }
    }

    public void osszesFuvar(){
        int osszfuvar=lista.size();
        System.out.println("3. feladat: "+osszfuvar+"fuvar");
    }

    public void atlagBevetel(){
        int szamlalo = 0;
        double sum = 0;
        for (fuvar f:
                lista) {
            if(f.getAzonosito() == 6185){
                sum+=f.getViteldij();
                szamlalo++;
            }
        }
        System.out.println("4. feladat: "+szamlalo + " fuvar alatt: " + sum + "$");
    }

    public void atlagFizetesFajtankent(){
        List<String> fizetesTipusa = new ArrayList<>();
        List<Integer> fizetesSzama = new ArrayList<>();
        System.out.println("5. feladat: ");
        for (fuvar f:
                lista) {
            if(!fizetesTipusa.contains(f.getFizetes_modja())){
                fizetesTipusa.add(f.getFizetes_modja());
                fizetesSzama.add(1);
            }
            else{
                int index = fizetesTipusa.indexOf(f.getFizetes_modja());
                int set = fizetesSzama.get(index)+1;
                fizetesSzama.set(index,set);
            }
        }
        for(int i = 0; i < fizetesTipusa.size(); i++){
            System.out.println("\t \t" + fizetesTipusa.get(i) + ": " + fizetesSzama.get(i) + " fuvar");
        }
    }

    public void atvaltas(){
        double sum = 0;
        for (fuvar f:
                lista) {
            sum += f.getTavolsag();
        }
        sum = sum*1.6;
        sum = Math.round(sum*100.0)/100.0;
        System.out.println("6. feladat: "+sum + "km");
    }

    private fuvar indexOfLeghosszabb(){
        fuvar legnagyobb = this.lista.get(0);
        for (fuvar f: this.lista) {
            if(f.getIdotartam() > legnagyobb.getIdotartam()){
                legnagyobb = f;
            }
        }
        return legnagyobb;
    }

    public void leghosszabFuvar(){
        System.out.println("7. feladat: Leghosszabb fuvar:");
        fuvar leghosszabb = this.indexOfLeghosszabb();
        System.out.println("\t\tFuvar hossza: " + leghosszabb.getIdotartam() + " másodperc");
        System.out.println("\t\tTaxi azonosító: " + leghosszabb.getAzonosito() );
        System.out.println("\t\tMegtett távolság: " + leghosszabb.getTavolsag()+ " km");
        System.out.println("\t\tViteldíj: " + leghosszabb.getViteldij() + "$");
    }

    public void kiiratas() throws IOException {
        BufferedWriter bf = new BufferedWriter(new FileWriter(new File("hibak.txt")));
        bf.write("taxi_id;indulas;idotartam;tavolsag;viteldij;borravalo;fizetes_modja\n");
        for (fuvar f: this.lista) {
            if(f.getIdotartam() > 0 && f.getViteldij() > 0 && f.getTavolsag() == 0){
                bf.write(f.toString() + "\n");
            }
        }
        bf.close();
    }
}
