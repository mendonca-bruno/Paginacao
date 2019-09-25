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
    Integer counter;
    boolean processoFinalizou;
    boolean finalizado;
    
    public Processo (Integer id, String nome, RAM ram, MMU mmu, Disco disco){
        this.id = id;
        this.nome = nome;
        paginas = new ArrayList<>();
        this.ram = ram;
        this.mmu = mmu;
        this.disco = disco;
        counter = 0;
        processoFinalizou = false;
        finalizado = false;
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
        for(int i=0; i<16; i++){
            mmu.checaPagina(this, paginas.get(i));
        }
        System.out.println("*Finalizando Processo*");
        //remove paginas da ram
        System.out.println("*Desalocando da RAM*");
        ram.removerPaginasProc(paginas);
        //remove paginas do disco
        System.out.println("*Desalocando do DISCO*");
        disco.removePaginasProc(this);
    }
    
    public void solicitaPagina(Pagina p){
        if(finalizado==false){
            if(counter<16){
            mmu.checaPagina(this, p);
            counter++;
        }
        else{
           System.out.println("*Finalizando Processo*");
            //remove paginas da ram
            System.out.println("*Desalocando da RAM*");
            ram.removerPaginasProc(paginas);
            //remove paginas do disco
            System.out.println("*Desalocando do DISCO*");
            disco.removePaginasProc(this);
            //ram.mostraPaginas() 
            finalizado=true;
        }
        }else{
            System.out.println("Processo Finalizado!");
        }
        
    }
    
    public void armazenaDisco(){
        armazenado = disco.armazenarDisco(this);
        if(armazenado == 1){
            embaralhaPaginas();
            mmu.adicionaProcesso(this);
            //solicitaPagina();
        }
    }
    
    @Override
    public String toString(){
        return nome;
    }
    

}
