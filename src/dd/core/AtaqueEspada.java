package dd.core;

public class AtaqueEspada implements Ataque{
    private final int ATAQUE = 100;
    
    public int ejecutarAtaque(){
        return (int) (ATAQUE * (Math.random() * 10) + 1);
    }
}
