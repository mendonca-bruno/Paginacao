package pages;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class RAM {
    //como a memoria ram é ilimitada, cada processo sera adicionado o seu id,
    //e para cada id, terá uma list de paginas (4paginas disponiveis)
    HashMap<Processo, LinkedList<Pagina>> processoCabeca;  
    ArrayList<Pagina> memoriaFisica;
    
    public RAM(){
        memoriaFisica = new ArrayList<>();
        processoCabeca = new HashMap<>();
    }
    
    void alocaPagina(Pagina pagina){
        //adiciona as paginas na memoria ram
        memoriaFisica.add(pagina);
        if(pagina.cabeca){
            if(processoCabeca.containsKey(pagina.processo)){
                ((LinkedList<Pagina>)processoCabeca.get(pagina.processo)).add(pagina);
            }else{
                LinkedList<Pagina> pags = new LinkedList<>();
                pags.add(pagina);
                processoCabeca.put(pagina.processo, pags);
            }
            
        }
    }
}
