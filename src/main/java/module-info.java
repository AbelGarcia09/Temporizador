module es.ideas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens es.ideas to javafx.fxml;
    opens es.ideas.controller to javafx.fxml;
    
    exports es.ideas;
    exports es.ideas.controller;
}
