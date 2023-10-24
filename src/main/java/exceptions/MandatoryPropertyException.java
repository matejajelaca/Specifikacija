package exceptions;

public class MandatoryPropertyException extends Exception{
    public MandatoryPropertyException() {
        super("You have to add properties: Capacity, GraphicTable, NumberOfComputer and Projector");
    }
}
