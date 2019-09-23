package pages;

import java.util.ArrayList;
import java.util.HashMap;

public class MMU {
    
    HashMap<Processo, ArrayList<Pagina>> memoriaVirtual;
    RAM ram;
    Disco disco;
    
    public MMU(RAM ram, Disco disco){
        memoriaVirtual = new HashMap<>();
        this.ram = ram;
        this.disco = disco;
    }
    
    public void mostraProcessos(){
        for(HashMap.Entry entry : memoriaVirtual.entrySet()){
            
            ArrayList<Pagina> paginas = new ArrayList<>(memoriaVirtual.get(entry.getKey()));
            for(Pagina pag:paginas){
                System.out.println(pag.id);
            }
                            
        }
    }
    
    public void adicionaProcesso(Processo proc){
        ArrayList<Pagina> paginas = new ArrayList<>();
        memoriaVirtual.put(proc, paginas);
    }
    
    public int checaTamanho(Processo proc){
        ArrayList<Pagina> paginas = new ArrayList<>(memoriaVirtual.get(proc));
        if(paginas.isEmpty()) return 0;
        else if(paginas.size() < 4) return 1;
        else if(paginas.size() == 4) return 2;
        return 0;
    }
    
    public int paginaExiste(Pagina pag){
        for(HashMap.Entry procPag : memoriaVirtual.entrySet()){
            for(Pagina inpag: (ArrayList<Pagina>)procPag.getValue()){
              if(inpag.id == pag.id)return 1;  
            }
            
        }
        return 0;
    }
    
    public void checaPagina(Processo proc, Pagina pagina){
        //verifica se pagina solicitada esta armazenada na MMU
        if(checaTamanho(proc)==1){
            //nao foram alocadas todas as memorias virtuais para o processo
            disco.acessaDisco(proc, pagina);
            System.out.println("Adicionou mais uma pagininha");
            adicionaPagina(proc, pagina);
            mostraProcessos();
            adicionaRam(pagina);
            proc.counter++;
            
        }
        else if(checaTamanho(proc)==2){
            //todas as memorias virtuais ja armazenadas
            if(paginaExiste(pagina)==1){ //pagina ja esta na mmu
                //neste caso nao acessa o disco
                proc.counter++;
                return;
            }
            
           
        }
        else{
            //adiciona a primeira pagina
            disco.acessaDisco(proc, pagina);
            adicionaPagina(proc, pagina);
            System.out.println("Primeira pagina adicionada");
            mostraProcessos();
            pagina.cabeca = true;
            adicionaRam(pagina);
            proc.counter++;
        }
        
    }
    
    public void adicionaRam(Pagina pagina){
        //manda pagina para a ram
        ram.alocaPagina(pagina);
    }
    
    public void adicionaPagina(Processo proc, Pagina pagina){
        //cria espaço na mmu referente ao processo
        memoriaVirtual.get(proc).add(pagina);
    }
    
    public void trocaPagina(){
        //algortimo de troca de paginas aqui
        //FIFO
        
    }
}
