module com.evilcorp.laboratoryworktwo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.evilcorp.laboratoryworktwo to javafx.fxml;
    exports com.evilcorp.laboratoryworktwo;
}