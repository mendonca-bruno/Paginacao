package pages;

import java.util.ArrayList;
import java.util.HashMap;

public class Disco {
    //no disco serao armazenadas as paginas nao utilizadas pelo processo
    //toda vez que uma pagina for solicitada, o disco fornece essa pagina a mmu
    HashMap<Processo,ArrayList<Pagina>> memoriaArmazenamento;
    
    public Disco(){
        memoriaArmazenamento = new HashMap<>();
    }
    
    public void mostraPaginasProcesso(Processo proc){
        for(HashMap.Entry entry : memoriaArmazenamento.entrySet()){
            System.out.println("Processo: "+ proc.nome);
            ArrayList<Pagina> paginas = memoriaArmazenamento.get(entry.getKey());
            for(Pagina pagina : paginas){
                System.out.println(pagina.id);
            }
        }
    }
    
    public int armazenarDisco(Processo proc){
        //coloca todas as paginas do processo no seu arrayList
        ArrayList<Pagina> paginasProcesso = new ArrayList<>(proc.paginas);
        memoriaArmazenamento.put(proc, paginasProcesso);
        //mostraPaginasProcesso(proc);
        return 1;
        
    }
    
    public int acessaDisco(Processo proc, Pagina pagina){
        //simula o acesso ao disco para achar uma determinada pagina
        System.out.println("*Acessando disco*");
        for(HashMap.Entry entry : memoriaArmazenamento.entrySet()){
            ArrayList<Pagina> paginas = memoriaArmazenamento.get(entry.getKey());
            for (Pagina p : paginas){
                if(p.id == pagina.id) return 1;
            }
        }
        
        return 0;
    }
    
    public void removePaginasProc(Processo proc){
        memoriaArmazenamento.remove(proc);
    }
}
