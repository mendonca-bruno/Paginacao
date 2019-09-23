package pages;

public class Main {
    public static void main(String[] args) {
        
        RAM ram = new RAM();
        MMU mmu = new MMU(ram);
        Disco disco = new Disco();
        
        Processo p1 = new Processo(01, "Processo 01", ram, mmu, disco);
        
    }
}
