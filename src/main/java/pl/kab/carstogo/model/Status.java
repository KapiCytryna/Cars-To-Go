package pl.kab.carstogo.model;

public enum Status {
    LENT("Wypożyczony"),
    AVAILABLE("Dostępny"),
    UNAVAILABLE("Niedostępny");

    private final String displayName;

    Status(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
