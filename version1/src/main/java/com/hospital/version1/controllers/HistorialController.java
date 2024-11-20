package com.hospital.version1.controllers;

import com.hospital.version1.models.HistorialClinico;
import com.hospital.version1.services.HistorialClinicoService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.cell.PropertyValueFactory;


public class HistorialController {

    @FXML
    private TableView<HistorialClinico> tableHistorial;
    
    @FXML
    private TableColumn<HistorialClinico, String> colFecha;
    
    @FXML
    private TableColumn<HistorialClinico, String> colDescripcion;
    
    @FXML
    private TableColumn<HistorialClinico, String> colTratamiento;
    
    @FXML
    private TableColumn<HistorialClinico, String> colDuracion;
    
    @FXML
    private Button verDetallesButton;
    
    @FXML
    private Button cerrarButton;

    private HistorialClinicoService historialClinicoService;

    public HistorialController() {
        this.historialClinicoService = new HistorialClinicoService();
    }

    @FXML
    public void initialize() {
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colTratamiento.setCellValueFactory(new PropertyValueFactory<>("tratamiento"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        
        cargarHistorialPaciente();
        
        verDetallesButton.setOnAction(event -> verDetalles());
        
        cerrarButton.setOnAction(event -> cerrar());
    }

    private void cargarHistorialPaciente() {

        tableHistorial.getItems().setAll(historialClinicoService.obtenerHistorialPorPaciente(1L)); 
    }

    private void verDetalles() {

        HistorialClinico historialSeleccionado = tableHistorial.getSelectionModel().getSelectedItem();

        if (historialSeleccionado != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Detalles del Tratamiento");
            alert.setHeaderText("Detalles del tratamiento para " + historialSeleccionado.getFecha());
            alert.setContentText("Tratamiento: " + historialSeleccionado.getTratamiento() );
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("No se ha seleccionado ningún historial");
            alert.setContentText("Por favor, selecciona un historial de la tabla para ver los detalles.");
            alert.showAndWait();
        }
    }

    private void cerrar() {

    }
}
