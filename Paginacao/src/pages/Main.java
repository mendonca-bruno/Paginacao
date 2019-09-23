package pages;

public class Main {
    public static void main(String[] args) {
        
        RAM ram = new RAM();
        Disco disco = new Disco();
        MMU mmu = new MMU(ram,disco);
        
        Processo p1 = new Processo(01, "Processo 01", ram, mmu, disco);
        
    }
}
