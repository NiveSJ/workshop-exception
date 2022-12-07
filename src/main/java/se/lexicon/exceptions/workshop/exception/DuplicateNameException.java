package se.lexicon.exceptions.workshop.exception;

public class DuplicateNameException extends Exception {
    ;
    private String message;
    private String attribute;

    public DuplicateNameException(String message, String attribute) {
        super(message);
        this.attribute = attribute;
    }



    public String getAttribute() {
        return attribute;
    }

}
