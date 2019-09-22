package pages;

import java.util.ArrayList;
import java.util.HashMap;

public class RAM {
    //como a memoria ram é ilimitada, cada processo sera adicionado o seu id,
    //e para cada id, terá uma list de paginas (4paginas disponiveis)
    
    HashMap<Processo, ArrayList<Pagina>> memoriaFisica;
    
    public RAM(){
        memoriaFisica = new HashMap<>();
    }
    
    void adicionaProcesso(Processo proc, ArrayList<Pagina> paginasAtivas){
        //adiciona os processos a memoria ram conforme novos processos forem sendo criados
    }
}
