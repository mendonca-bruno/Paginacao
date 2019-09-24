package pages;

import java.util.ArrayList;

public class RAM {
    //como a memoria ram é ilimitada, cada processo sera adicionado o seu id,
    //e para cada id, terá uma list de paginas (4paginas disponiveis) 
    ArrayList<Pagina> memoriaFisica;
    Integer index;
    
    public RAM(){
        memoriaFisica = new ArrayList<>();
        index = 20;
    }
    
    public void alocaSO(){
        for (int i=0; i<20; i++){
            Pagina p = new Pagina(null, i);
            memoriaFisica.add(p);
        }
    }
    
    public void alocaPagina(Pagina pagina){
        memoriaFisica.add(pagina);
        //mostraPaginas();
        
    }
    
    public void mostraPaginas(){
        
        System.out.println("Paginas na ram:");
        for(int i=20; i<memoriaFisica.size(); i++){
            System.out.println(memoriaFisica.get(i).processo.nome +" : " +memoriaFisica.get(i).id);
        }
        
    }
    
    public void removerPaginasProc(ArrayList<Pagina> pag){
        for(Pagina pagProc : pag){
            memoriaFisica.remove(pagProc);
        }
        return;
    }
    
    public void remover(Pagina pag){
        memoriaFisica.remove(pag);
    }
}
