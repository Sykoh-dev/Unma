package J.r.meTechnobel.Unma.exceptions.models;



public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException() {
        super("L'element recherché n'existe pas");
    }

}
