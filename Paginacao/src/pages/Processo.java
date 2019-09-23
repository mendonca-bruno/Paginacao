package pages;

import java.util.ArrayList;
import java.util.Collections;

public class Processo {
    Integer id;
    String nome;
    ArrayList<Pagina> paginas;
    RAM ram;
    MMU mmu;
    Disco disco;
    Integer armazenado;
    
    public Processo (Integer id, String nome, RAM ram, MMU mmu, Disco disco){
        this.id = id;
        this.nome = nome;
        paginas = new ArrayList<>();
        this.ram = ram;
        this.mmu = mmu;
        this.disco = disco;
        criaPaginas();
    }
    
    public void mostraPaginas(){
        for (Pagina p : paginas){
            System.out.println(p.id);
        }
    }
    
    public void embaralhaPaginas(){
        Collections.shuffle(paginas);
    }
    
    public void criaPaginas(){
        for(int i=0; i<16;i++){
            paginas.add(new Pagina(this, i));
        } 
        embaralhaPaginas();
        armazenaDisco();
    }
    
    public void solicitaPagina(){
        // o processo decide qual pagina é necessaria a ser utilizada
        // a mmu é responsavel por colocar essa pagina na memoria ram
        mmu.adicionaProcesso(this);
        mmu.checaPagina(this, paginas.get(2));
    }
    
    public void armazenaDisco(){
        armazenado = disco.armazenarDisco(this);
        if(armazenado == 1){
            embaralhaPaginas();
            solicitaPagina();
        }
    }
}
