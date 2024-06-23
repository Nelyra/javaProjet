package projet.javafx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projet.Bail;
import projet.Personne;
import projet.Etatdeslieux;
import projet.Location;
import projet.Adresse;
import projet.dao.BailDAOImpl;
import projet.dao.PersonneDAOImpl;
import projet.dao.EtatdeslieuxDAOImpl;
import projet.dao.LocationDAOImpl;
import projet.dao.AdresseDAOImpl;

import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Vue administrateur");

        Label label = new Label("Vue administrateur - Gestion des baux");
        label.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 40px; -fx-font-weight: bold;");
        BorderPane.setAlignment(label, Pos.TOP_LEFT);

        Label label2 = new Label("Changer de table");
        label2.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        ////// BAUX //////
        BailDAOImpl bailDAO = new BailDAOImpl();
        List<Bail> baux = bailDAO.getAllBails();

        Label label3 = new Label("Liste des baux");
        label3.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableView<Bail> tableView = new TableView<>();

        TableColumn<Bail, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        TableColumn<Bail, String> dateDebutColumn = new TableColumn<>("Date de début");
        dateDebutColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateDebut()));

        TableColumn<Bail, String> dateFinColumn = new TableColumn<>("Date de fin");
        dateFinColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateFin()));

        TableColumn<Bail, String> idProprioColumn = new TableColumn<>("ID propriétaire");
        idProprioColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProprio().getId().toString()));

        TableColumn<Bail, String> idLocataireColumn = new TableColumn<>("ID locataire");
        idLocataireColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdLocataire().getId().toString()));

        TableColumn<Bail, String> idAgentImmobilierColumn = new TableColumn<>("ID agent immobilier");
        idAgentImmobilierColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdAgentImmobilier().getId().toString()));

        TableColumn<Bail, String> idLocationColumn = new TableColumn<>("ID location");
        idLocationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdLocation().getId().toString()));

        TableColumn<Bail, String> idEtatEntreeColumn = new TableColumn<>("ID état d'entrée");
        idEtatEntreeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdEtatEntree().getId().toString()));

        TableColumn<Bail, String> idEtatSortieColumn = new TableColumn<>("ID état de sortie");
        idEtatSortieColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdEtatSortie().getId().toString()));

        tableView.getColumns().addAll(idColumn, dateDebutColumn, dateFinColumn, idProprioColumn, idLocataireColumn, idAgentImmobilierColumn, idLocationColumn, idEtatEntreeColumn, idEtatSortieColumn);
        tableView.getItems().addAll(baux);

        ////// ADRESSES //////

        AdresseDAOImpl adresseDAO = new AdresseDAOImpl();
        List<Adresse> adresses = adresseDAO.getAllAdresses();

        Label label4 = new Label("Liste des adresses");
        label4.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableView<Adresse> tableView1 = new TableView<>();

        TableColumn<Adresse, String> idColumn1 = new TableColumn<>("ID");
        idColumn1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        TableColumn<Adresse, String> villeColumn = new TableColumn<>("Ville");
        villeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVille()));

        TableColumn<Adresse, String> rueColumn = new TableColumn<>("Rue");
        rueColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRue()));

        TableColumn<Adresse, String> numeroColumn = new TableColumn<>("Numéro");
        numeroColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero().toString()));

        TableColumn<Adresse, String> codePostalColumn = new TableColumn<>("Code postal");
        codePostalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodePostal().toString()));

        tableView1.getColumns().addAll(idColumn1, villeColumn, rueColumn, numeroColumn, codePostalColumn);
        tableView1.getItems().addAll(adresses);

        ////// LOCATIONS //////

        LocationDAOImpl locationDAO = new LocationDAOImpl();
        List<Location> locations = locationDAO.getAllLocations();

        Label label5 = new Label("Liste des locations");
        label5.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableView<Location> tableView2 = new TableView<>();

        TableColumn<Location, String> idColumn2 = new TableColumn<>("ID");
        idColumn2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        TableColumn<Location, String> idAdresseColumn = new TableColumn<>("ID Adresse");
        idAdresseColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdAdresse().getId().toString()));

        TableColumn<Location, String> appartementColumn = new TableColumn<>("Appartement");
        appartementColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAppartement().toString()));

        tableView2.getColumns().addAll(idColumn2, idAdresseColumn, appartementColumn);
        tableView2.getItems().addAll(locations);

        ////// PROPRIETAIRES //////

        PersonneDAOImpl personneDAO = new PersonneDAOImpl();
        List<Personne> proprietaires = personneDAO.getAllProprietaires();

        TableView<Personne> tableView3 = new TableView<>();

        Label label6 = new Label("Liste des propriétaires");
        label6.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableColumn<Personne, String> idColumn3 = new TableColumn<>("ID");
        idColumn3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        TableColumn<Personne, String> nomColumn = new TableColumn<>("Nom");
        nomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));

        TableColumn<Personne, String> prenomColumn = new TableColumn<>("Prénom");
        prenomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));

        TableColumn<Personne, String> mailColumn = new TableColumn<>("Mail");
        mailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMail()));

        TableColumn<Personne, String> telephoneColumn = new TableColumn<>("Téléphone");
        telephoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelephone().toString()));

        TableColumn<Personne, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));

        TableColumn<Personne, String> ribColumn = new TableColumn<>("RIB");
        ribColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRib().toString()));

        tableView3.getColumns().addAll(idColumn3, nomColumn, prenomColumn, mailColumn, telephoneColumn, typeColumn, ribColumn);
        tableView3.getItems().addAll(proprietaires);

        ////// LOCATAIRES //////
        List<Personne> locataires = personneDAO.getAllLocataires();

        TableView<Personne> tableView4 = new TableView<>();

        Label label7 = new Label("Liste des locataires");
        label7.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableColumn<Personne, String> idColumn4 = new TableColumn<>("ID");
        idColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        TableColumn<Personne, String> nomColumn4 = new TableColumn<>("Nom");
        nomColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));

        TableColumn<Personne, String> prenomColumn4 = new TableColumn<>("Prénom");
        prenomColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));

        TableColumn<Personne, String> mailColumn4 = new TableColumn<>("Mail");
        mailColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMail()));

        TableColumn<Personne, String> telephoneColumn4 = new TableColumn<>("Téléphone");
        telephoneColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelephone().toString()));

        TableColumn<Personne, String> typeColumn4 = new TableColumn<>("Type");
        typeColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));

        TableColumn<Personne, String> ribColumn4 = new TableColumn<>("RIB");
        ribColumn4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRib().toString()));

        tableView4.getColumns().addAll(idColumn4, nomColumn4, prenomColumn4, mailColumn4, telephoneColumn4, typeColumn4, ribColumn4);
        tableView4.getItems().addAll(locataires);


        ////// ETATS DES LIEUX //////

        EtatdeslieuxDAOImpl etatdeslieuxDAO = new EtatdeslieuxDAOImpl();
        List<Etatdeslieux> etatsdeslieux = etatdeslieuxDAO.getAllEtatdeslieux();

        Label label8 = new Label("Liste des états des lieux");
        label8.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableView<Etatdeslieux> tableView5 = new TableView<>();

        TableColumn<Etatdeslieux, String> idColumn5 = new TableColumn<>("ID");
        idColumn5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

        TableColumn<Etatdeslieux, String> commentaireColumn = new TableColumn<>("Commentaire");
        commentaireColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCommentaire()));

        tableView5.getColumns().addAll(idColumn5, commentaireColumn);
        tableView5.getItems().addAll(etatsdeslieux);

        // Buttons for accessing the database tables
        Button button1 = new Button("Adresses");
        Button button2 = new Button("Baux");
        Button button3 = new Button("Locations");
        Button button4 = new Button("Propriétaires");
        Button button5 = new Button("Locataires");
        Button button6 = new Button("Etats des lieux");

        String buttonStyle = "-fx-font-size: 20px; -fx-padding: 10px 20px; -fx-alignment: center; "
                + "-fx-background-color: #f0f0f0; -fx-border-color: #000000; "
                + "-fx-border-width: 2px; -fx-border-radius: 5px; -fx-cursor: hand; "
                + "-fx-text-fill: #000000; -fx-font-family: 'Arial'; -fx-font-weight: bold; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0, 0, 0);";
        button1.setStyle(buttonStyle);
        button2.setStyle(buttonStyle);
        button3.setStyle(buttonStyle);
        button4.setStyle(buttonStyle);
        button5.setStyle(buttonStyle);
        button6.setStyle(buttonStyle);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label2, button1, button2, button3, button4, button5, button6);
        vbox.setAlignment(Pos.CENTER);

        // Buttons for table actions
        Button createButton = new Button("Créer");
        createButton.setStyle(buttonStyle);
        createButton.setOnAction(event -> handleCreateBail(tableView));

        Button updateButton = new Button("Modifier");
        updateButton.setStyle(buttonStyle);

        Button deleteButton = new Button("Supprimer");
        deleteButton.setStyle(buttonStyle);

        HBox hbox = new HBox(20);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(createButton, updateButton, deleteButton);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox2 = new VBox(20);
        vbox2.setPadding(new Insets(10));
        vbox2.getChildren().addAll(label3, tableView, hbox);
        vbox2.setAlignment(Pos.CENTER);

        button1.setOnAction(event -> {
            changeTabel(label4, tableView1, vbox2, hbox);
        });

        button2.setOnAction(event -> {
            changeTabel(label3, tableView, vbox2, hbox);
        });

        button3.setOnAction(event -> {
            changeTabel(label5, tableView2, vbox2, hbox);
        });

        button4.setOnAction(event -> {
            changeTabel(label6, tableView3, vbox2, hbox);
        });

        button5.setOnAction(event -> {
            changeTabel(label7, tableView4, vbox2, hbox);
        });

        button6.setOnAction(event -> {
            changeTabel(label8, tableView5, vbox2, hbox);
        });

        StackPane buttonPane = new StackPane();
        buttonPane.getChildren().add(vbox);
        StackPane.setAlignment(vbox, Pos.CENTER);
        buttonPane.setPadding(new Insets(0, 0, 50, 200));

        StackPane tablePane = new StackPane();
        tablePane.getChildren().add(vbox2);
        StackPane.setAlignment(vbox2, Pos.CENTER);
        tablePane.setPadding(new Insets(100, 0, 100, 200));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(label);
        borderPane.setLeft(tablePane);
        borderPane.setCenter(buttonPane);

        Scene scene = new Scene(borderPane, 1920, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCreateBail(TableView tableView) {
        Stage createStage = new Stage();
        createStage.setTitle("Créer un nouveau bail");

        Label idProprioLabel = new Label("ID Propriétaire:");
        TextField idProprioField = new TextField();

        Label idLocataireLabel = new Label("ID Locataire:");
        TextField idLocataireField = new TextField();

        Label idAgentImmobilierLabel = new Label("ID Agent Immobilier:");
        TextField idAgentImmobilierField = new TextField();

        Label idLocationLabel = new Label("ID Location:");
        TextField idLocationField = new TextField();

        Label idEtatEntreeLabel = new Label("ID État d'entrée:");
        TextField idEtatEntreeField = new TextField();

        Label idEtatSortieLabel = new Label("ID État de sortie:");
        TextField idEtatSortieField = new TextField();

        Label dateDebutLabel = new Label("Date de début:");
        TextField dateDebutField = new TextField();

        Label dateFinLabel = new Label("Date de fin:");
        TextField dateFinField = new TextField();

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(event -> {
            Bail newBail = new Bail();
            newBail.setIdProprio(new Personne(Integer.parseInt(idProprioField.getText())));
            newBail.setIdLocataire(new Personne(Integer.parseInt(idLocataireField.getText())));
            newBail.setIdAgentImmobilier(new Personne(Integer.parseInt(idAgentImmobilierField.getText())));
            newBail.setIdLocation(new Location(Integer.parseInt(idLocationField.getText())));
            newBail.setIdEtatEntree(new Etatdeslieux(Integer.parseInt(idEtatEntreeField.getText())));
            newBail.setIdEtatSortie(new Etatdeslieux(Integer.parseInt(idEtatSortieField.getText())));
            newBail.setDateDebut(dateDebutField.getText());
            newBail.setDateFin(dateFinField.getText());

            BailDAOImpl bailDAO = new BailDAOImpl();
            bailDAO.createBail(newBail);

            createStage.close();

            tableView.getItems().clear();
            BailDAOImpl bailDAO1 = new BailDAOImpl();
            tableView.getItems().addAll(bailDAO1.getAllBails());
        });

        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(event -> createStage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                idProprioLabel, idProprioField,
                idLocataireLabel, idLocataireField,
                idAgentImmobilierLabel, idAgentImmobilierField,
                idLocationLabel, idLocationField,
                idEtatEntreeLabel, idEtatEntreeField,
                idEtatSortieLabel, idEtatSortieField,
                dateDebutLabel, dateDebutField,
                dateFinLabel, dateFinField,
                saveButton, cancelButton
        );
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 800);
        createStage.setScene(scene);
        createStage.show();
    }

    private void handleUpdateBail(TableView<Bail> tableView) {
        Bail selectedBail = tableView.getSelectionModel().getSelectedItem();
        if (selectedBail != null) {
            System.out.println("Modifier un bail: " + selectedBail.getId());
        } else {
            System.out.println("No Bail selected for update.");
        }
    }

    private void handleDeleteBail(TableView<Bail> tableView, BailDAOImpl bailDAO) {
        Bail selectedBail = tableView.getSelectionModel().getSelectedItem();
        if (selectedBail != null) {
            System.out.println("Supprimer un bail: " + selectedBail.getId());
            bailDAO.deleteBail(selectedBail.getId());
            tableView.getItems().remove(selectedBail);
        } else {
            System.out.println("No Bail selected for deletion.");
        }
    }

    private void changeTabel(Label a, TableView b, VBox c, HBox d) {
        c.getChildren().clear();
        c.getChildren().addAll(a, b, d);
    }
}
