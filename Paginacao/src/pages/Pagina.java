package pages;

public class Pagina {
    
    Processo processo;
    Integer id;
    boolean cabeca;
    
    public Pagina(Processo proc, Integer id){
        this.processo = proc;
        this.id = id;
        cabeca = false;
    }
}
