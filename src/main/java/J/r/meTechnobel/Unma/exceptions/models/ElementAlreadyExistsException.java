package J.r.meTechnobel.Unma.exceptions.models;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException() {
        super("L'élément à insérer existe déjà.");
    }

}
