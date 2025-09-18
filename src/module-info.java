/**
 * 
 */
/**
 * @author Admin
 *
 */
module VietnamHistory {
	requires javafx.base;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.web;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires javafx.swt;
	requires org.jsoup;
	requires json.simple;
	requires java.xml.crypto;
	
	opens vnhistory.entity to javafx.base, org.json.simple;
	opens vnhistory.screen to javafx.fxml;
	opens vnhistory.screen.EntityDetailScreen to javafx.fxml;
	opens vnhistory.screen.EntityScreen to javafx.fxml;
	opens vnhistory.test to javafx;
	
    exports vnhistory.screen;
    exports vnhistory.test;
    exports vnhistory;
}