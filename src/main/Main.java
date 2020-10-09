package main;

import fachada.Banco;
import userinterface.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        Banco servidorBanco = new Banco();
        TelaPrincipal telaPrincipal = new TelaPrincipal(servidorBanco);
        telaPrincipal.iniciar();
    }
}