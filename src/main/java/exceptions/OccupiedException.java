package exceptions;

public class OccupiedException extends Exception{
    public OccupiedException() {
        super("Termin is occupied");
    }
}
