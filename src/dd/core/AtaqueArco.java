package dd.core;

public class AtaqueArco implements Ataque{   
    private final int ATAQUE = 50;
    
    public int ejecutarAtaque(){
        return (int) (ATAQUE * (int) Math.random());
    }
}
