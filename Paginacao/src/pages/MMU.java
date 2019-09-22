package pages;

import java.util.ArrayList;
import java.util.HashMap;

public class MMU {
    
    HashMap<Processo, ArrayList<Pagina>> memoriaVirtual;
    
    public MMU(){
        memoriaVirtual = new HashMap<>();
    }
    
    public void checaPagina(Processo proc){
        //verifica se pagina solicitada esta armazenada na MMU
    }
    
    public void adicionaPagina(){
        //caso a pagina nao estiver, busca no disco e adiciona na MMU, realizando a troca
    }
    
    public void trocaPagina(){
        //algortimo de troca de paginas aqui
    }
}
