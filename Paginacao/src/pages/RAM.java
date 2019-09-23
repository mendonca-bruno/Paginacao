package pages;

import java.util.ArrayList;
import java.util.HashMap;

public class RAM {
    //como a memoria ram é ilimitada, cada processo sera adicionado o seu id,
    //e para cada id, terá uma list de paginas (4paginas disponiveis) 
    HashMap<Processo,ArrayList<Pagina>> memoriaFisica;
    
    public RAM(){
        memoriaFisica = new HashMap<>();
    }
    
    public void adicionaProcesso(Processo proc, Pagina pag){
        ArrayList<Pagina> paginas = new ArrayList<>();
        paginas.add(pag);
        memoriaFisica.put(proc, paginas);
    }
    
    public void alocaPagina(Processo proc, Pagina pagina){
        memoriaFisica.get(proc).add(pagina);
    }
    
    public void mostraPaginas(){
        
        System.out.println("Paginas na ram:");
        for (HashMap.Entry pagProc : memoriaFisica.entrySet()){
            for(Pagina p : (ArrayList<Pagina>)pagProc.getValue()){
                System.out.println(p.id);
            }
        }
        
    }
    
    public int pegaPosica(Processo proc, Pagina pag){
        mostraPaginas();
        return memoriaFisica.get(proc).indexOf(pag);
    }
    
    public void remover(Processo proc, Pagina pag){
        memoriaFisica.get(proc).remove(pag);
    }
}
