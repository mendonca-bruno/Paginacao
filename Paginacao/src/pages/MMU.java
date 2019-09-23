package pages;

import java.util.HashMap;
import java.util.LinkedList;

public class MMU {
    
    HashMap<Processo, LinkedList<Pagina>> memoriaVirtual;
    RAM ram;
    Disco disco;
    
    public MMU(RAM ram, Disco disco){
        memoriaVirtual = new HashMap<>();
        this.ram = ram;
        this.disco = disco;
    }
    
    public void mostraProcessos(){
        for(HashMap.Entry entry : memoriaVirtual.entrySet()){
            
            LinkedList<Pagina> paginas = new LinkedList<>(memoriaVirtual.get(entry.getKey()));
            for(Pagina pag:paginas){
                System.out.println(pag.id);
            }
                            
        }
    }
    
    public void adicionaProcesso(Processo proc){
        LinkedList<Pagina> paginas = new LinkedList<>();
        memoriaVirtual.put(proc, paginas);
    }
    
    public int checaTamanho(Processo proc){
        LinkedList<Pagina> paginas = new LinkedList<>(memoriaVirtual.get(proc));
        if(paginas.isEmpty()) return 0;
        else if(paginas.size() < 4) return 1;
        else if(paginas.size() == 4) return 2;
        return 0;
    }
    
    public int paginaExiste(Pagina pag){
        for(HashMap.Entry procPag : memoriaVirtual.entrySet()){
            for(Pagina inpag: (LinkedList<Pagina>)procPag.getValue()){
              if(inpag.id == pag.id)return 1;  
            }
            
        }
        return 0;
    }
    
    public void checaPagina(Processo proc, Pagina pagina){
        //verifica se pagina solicitada esta armazenada na MMU
        System.out.println("Tamanho :" +checaTamanho(proc));
        if(checaTamanho(proc)==1){
            //nao foram alocadas todas as memorias virtuais para o processo
            disco.acessaDisco(proc, pagina);
            System.out.println("Adicionou mais uma pagininha");
            adicionaPagina(proc, pagina);
            mostraProcessos();
            adicionaRam(proc, pagina);
            proc.counter++;
            
        }
        else if(checaTamanho(proc)==2){
            //todas as memorias virtuais ja armazenadas
            if(paginaExiste(pagina)==1){ //pagina ja esta na mmu
                //neste caso nao acessa o disco
                proc.counter++;
                return;
            }
            //precisa trocar a pagina
            trocaPagina(proc, pagina);
            proc.counter++;
        }
        else{
            //adiciona a primeira pagina
            disco.acessaDisco(proc, pagina);
            adicionaPagina(proc, pagina);
            System.out.println("Primeira pagina adicionada");
            mostraProcessos();
            pagina.cabeca = true;
            ram.adicionaProcesso(proc,pagina);
            adicionaRam(proc, pagina);
            proc.counter++;
        }
        
    }
    
    public void adicionaRam(Processo proc, Pagina pagina){
        //manda pagina para a ram
        ram.alocaPagina(proc, pagina);
    }
    
    public void adicionaPagina(Processo proc, Pagina pagina){
        //cria espaço na mmu referente ao processo
        memoriaVirtual.get(proc).add(pagina);
    }
    
    public void trocaPagina(Processo proc, Pagina pag){
        //algortimo de troca de paginas aqui
        //FIFO
        Pagina p = memoriaVirtual.get(proc).getFirst();
        //int posicao = ram.pegaPosica(proc, pag);
        
        disco.acessaDisco(proc, pag);
        ram.remover(proc, p);
        //removo a cabeça da fila das paginas
        memoriaVirtual.get(proc).remove();
        adicionaPagina(proc, pag);
        System.out.println("Pagina trocada!");
        mostraProcessos();
        //System.out.println("pos : " +posicao);
        ram.alocaPagina(proc, pag);
    }
}
