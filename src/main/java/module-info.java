module com.project.ainurse {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.json;
    requires java.net.http;
    requires itextpdf;
    requires javafx.graphics;
    requires javafx.media;

    opens com.project.ainurse.controller to javafx.fxml;
    opens com.project.ainurse to javafx.fxml;


    opens com.project.ainurse.model to javafx.base;

    exports com.project.ainurse;
}
