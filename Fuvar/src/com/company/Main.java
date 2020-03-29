package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        fuvarok f = new fuvarok("fuvar.csv");
        f.osszesFuvar();
        f.atlagBevetel();
        f.atlagFizetesFajtankent();
        f.atvaltas();
        f.leghosszabFuvar();
        f.kiiratas();
    }
}
