package pages;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Processo> procLista;
    public static RAM ram;
    public static Disco disco;
    public static MMU mmu;
        
    public static void main(String[] args) {
        
        procLista = new ArrayList<>();
        ram = new RAM();        
        disco = new Disco();
        mmu = new MMU(ram,disco);
        ram.alocaSO();
        
        /*Processo p1 = new Processo(01, "Processo 01", ram, mmu, disco);
        
        Processo p3 = new Processo(03, "Processo 03", ram, mmu, disco);
        Processo p4 = new Processo(02, "Processo 04", ram, mmu, disco);
        Processo p5 = new Processo(02, "Processo 05", ram, mmu, disco);*/
        
        Interface interf = new Interface();
        interf.setVisible(true);
        
    }
}
