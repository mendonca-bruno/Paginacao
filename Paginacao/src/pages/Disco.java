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
    
    public void armazenarDisco(Processo proc){
        //coloca todas as paginas do processo no seu arrayList
    }
}
