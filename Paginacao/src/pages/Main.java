package pages;

public class Main {
    public static void main(String[] args) {
        
        RAM ram = new RAM();
        Disco disco = new Disco();
        MMU mmu = new MMU(ram,disco);
        ram.alocaSO();
        
        Processo p1 = new Processo(01, "Processo 01", ram, mmu, disco);
        Processo p2 = new Processo(02, "Processo 02", ram, mmu, disco);
        Processo p3 = new Processo(03, "Processo 03", ram, mmu, disco);
        Processo p4 = new Processo(02, "Processo 04", ram, mmu, disco);
        Processo p5 = new Processo(02, "Processo 05", ram, mmu, disco);
        
    }
}
