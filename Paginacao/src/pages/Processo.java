package pages;

import java.util.ArrayList;

public class Processo {
    Integer id;
    String nome;
    ArrayList<Pagina> paginas;
    
    public Processo (Integer id, String nome){
        this.id = id;
        this.nome = nome;
        paginas = new ArrayList<>();
        criaPaginas();
    }
    
    public void criaPaginas(){
        for(int i=0; i<16;i++){
            paginas.add(new Pagina(this, i));
        }
    }
    
    public void solicitaPagina(){
        // o processo decide qual pagina é necessaria a ser utilizada
        // a mmu é responsavel por colocar essa pagina na memoria ram
    }
    
    public void armazenaDisco(){
        //adiciona todas as suas paginas no disco
    }
}
