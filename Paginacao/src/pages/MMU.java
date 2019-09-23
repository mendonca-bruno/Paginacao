package pages;

import java.util.ArrayList;
import java.util.HashMap;

public class MMU {
    
    HashMap<Processo, ArrayList<Pagina>> memoriaVirtual;
    RAM ram;
    
    public MMU(RAM ram){
        memoriaVirtual = new HashMap<>();
        this.ram = ram;
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
    
    public void checaPagina(Processo proc, Pagina pagina){
        //verifica se pagina solicitada esta armazenada na MMU
        if(checaTamanho(proc)==1){
            //nao foram alocadas todas as memorias virtuais para o processo
            for(HashMap.Entry entry : memoriaVirtual.entrySet()){
                ArrayList<Pagina> paginas = new ArrayList<>(memoriaVirtual.get(entry.getKey()));
                            
            }
        }
        else if(checaTamanho(proc)==2){
            //todas as memorias virtuais ja armazenadas
        }
        else{
            //adiciona a primeira pagina
            adicionaPagina(proc, pagina);
            System.out.println("Done");
            mostraProcessos();
            //adicionaRam(proc, pagina);
        }
        
    }
    
    public void adicionaRam(Processo proc, Pagina pagina){
        //manda pagina para a ram
    }
    
    public void adicionaPagina(Processo proc, Pagina pagina){
        //cria espaço na mmu referente ao processo
        memoriaVirtual.get(proc).add(pagina);
    }
    
    public void trocaPagina(){
        //algortimo de troca de paginas aqui
    }
}
