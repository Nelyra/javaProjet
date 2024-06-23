package projet.javafx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

        Image image = new Image("file:src/main/java/projet/javafx/KDC.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        HBox topHBox = new HBox();
        topHBox.setPadding(new Insets(10));
        topHBox.setAlignment(Pos.TOP_RIGHT);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topHBox.getChildren().addAll(label, spacer, imageView);

        ////// BAUX //////
        BailDAOImpl bailDAO = new BailDAOImpl();
        List<Bail> baux = bailDAO.getAllBails();

        Label label3 = new Label("Liste des baux");
        label3.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 30px; -fx-font-weight: bold;");

        TableView<Bail> tableView = new TableView<>();
        tableView.setMinWidth(800);
        tableView.setMinHeight(400);

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
        tableView1.setMinWidth(800);
        tableView1.setMinHeight(400);

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
        tableView2.setMinWidth(800);
        tableView2.setMinHeight(400);

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
        tableView3.setMinWidth(800);
        tableView3.setMinHeight(400);

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
        tableView4.setMinWidth(800);
        tableView4.setMinHeight(400);

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
        tableView5.setMinWidth(800);
        tableView5.setMinHeight(400);

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
        updateButton.setOnAction(event -> handleUpdateBail(tableView));

        Button deleteButton = new Button("Supprimer");
        deleteButton.setStyle(buttonStyle);
        deleteButton.setOnAction(event -> handleDeleteBail(tableView, bailDAO));

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
            createButton.setOnAction(event1 -> handleCreateAdresse(tableView1));
            updateButton.setOnAction(event1 -> handleUpdateAdresse(tableView1));
            deleteButton.setOnAction(event1 -> handleDeleteAdresse(tableView1, adresseDAO));
        });

        button2.setOnAction(event -> {
            changeTabel(label3, tableView, vbox2, hbox);
            createButton.setOnAction(event1 -> handleCreateBail(tableView));
            updateButton.setOnAction(event1 -> handleUpdateBail(tableView));
            deleteButton.setOnAction(event1 -> handleDeleteBail(tableView, bailDAO));
        });

        button3.setOnAction(event -> {
            changeTabel(label5, tableView2, vbox2, hbox);
            createButton.setOnAction(event1 -> handleCreateLocation(tableView2));
            updateButton.setOnAction(event1 -> handleUpdateLocation(tableView2));
            deleteButton.setOnAction(event1 -> handleDeleteLocation(tableView2, locationDAO));
        });

        button4.setOnAction(event -> {
            changeTabel(label6, tableView3, vbox2, hbox);
            createButton.setOnAction(event1 -> handleCreateProprietaire(tableView3));
            updateButton.setOnAction(event1 -> handleUpdateProprietaire(tableView3));
            deleteButton.setOnAction(event1 -> handleDeleteProprietaire(tableView3, personneDAO));
        });

        button5.setOnAction(event -> {
            changeTabel(label7, tableView4, vbox2, hbox);
            createButton.setOnAction(event1 -> handleCreateLocataire(tableView4));
            updateButton.setOnAction(event1 -> handleUpdateLocataire(tableView4));
            deleteButton.setOnAction(event1 -> handleDeleteLocataire(tableView4, personneDAO));
        });

        button6.setOnAction(event -> {
            changeTabel(label8, tableView5, vbox2, hbox);
            createButton.setOnAction(event1 -> handleCreateEtatdeslieux(tableView5));
            updateButton.setOnAction(event1 -> handleUpdateEtatdeslieux(tableView5));
            deleteButton.setOnAction(event1 -> handleDeleteEtatdeslieux(tableView5, etatdeslieuxDAO));
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
        borderPane.setTop(topHBox);
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
            newBail.setIdAgentImmobilier(new Personne(1));
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

            Stage updateStage = new Stage();

            Label idProprioLabel = new Label("ID Propriétaire:");
            TextField idProprioField = new TextField();
            idProprioField.setText(selectedBail.getIdProprio().getId().toString());

            Label idLocataireLabel = new Label("ID Locataire:");
            TextField idLocataireField = new TextField();
            idLocataireField.setText(selectedBail.getIdLocataire().getId().toString());

            Label idAgentImmobilierLabel = new Label("ID Agent Immobilier:");
            TextField idAgentImmobilierField = new TextField();
            idAgentImmobilierField.setText(selectedBail.getIdAgentImmobilier().getId().toString());

            Label idLocationLabel = new Label("ID Location:");
            TextField idLocationField = new TextField();
            idLocationField.setText(selectedBail.getIdLocation().getId().toString());

            Label idEtatEntreeLabel = new Label("ID État d'entrée:");
            TextField idEtatEntreeField = new TextField();
            idEtatEntreeField.setText(selectedBail.getIdEtatEntree().getId().toString());

            Label idEtatSortieLabel = new Label("ID État de sortie:");
            TextField idEtatSortieField = new TextField();
            idEtatSortieField.setText(selectedBail.getIdEtatSortie().getId().toString());

            Label dateDebutLabel = new Label("Date de début:");
            TextField dateDebutField = new TextField();
            dateDebutField.setText(selectedBail.getDateDebut());

            Label dateFinLabel = new Label("Date de fin:");
            TextField dateFinField = new TextField();
            dateFinField.setText(selectedBail.getDateFin());

            Button saveButton = new Button("Enregistrer");
            saveButton.setOnAction(event -> {
                selectedBail.setIdProprio(new Personne(Integer.parseInt(idProprioField.getText())));
                selectedBail.setIdLocataire(new Personne(Integer.parseInt(idLocataireField.getText())));
                selectedBail.setIdAgentImmobilier(new Personne(Integer.parseInt(idAgentImmobilierField.getText())));
                selectedBail.setIdLocation(new Location(Integer.parseInt(idLocationField.getText())));
                selectedBail.setIdEtatEntree(new Etatdeslieux(Integer.parseInt(idEtatEntreeField.getText())));
                selectedBail.setIdEtatSortie(new Etatdeslieux(Integer.parseInt(idEtatSortieField.getText())));
                selectedBail.setDateDebut(dateDebutField.getText());
                selectedBail.setDateFin(dateFinField.getText());

                BailDAOImpl bailDAO = new BailDAOImpl();
                bailDAO.updateBail(selectedBail);

                updateStage.close();

                tableView.getItems().clear();
                BailDAOImpl bailDAO1 = new BailDAOImpl();
                tableView.getItems().addAll(bailDAO1.getAllBails());
            });

            Button cancelButton = new Button("Annuler");
            cancelButton.setOnAction(event -> updateStage.close());

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
            updateStage.setScene(scene);
            updateStage.show();
        } else {
            System.out.println("No Bail selected for update.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun bail sélectionné pour la mise à jour.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
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

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun bail sélectionné pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleCreateAdresse(TableView tableView) {
        Stage createStage = new Stage();
        createStage.setTitle("Créer une nouvelle adresse");

        Label villeLabel = new Label("Ville:");
        TextField villeField = new TextField();

        Label rueLabel = new Label("Rue:");
        TextField rueField = new TextField();

        Label numeroLabel = new Label("Numéro:");
        TextField numeroField = new TextField();

        Label codePostalLabel = new Label("Code postal:");
        TextField codePostalField = new TextField();

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(event -> {
            Adresse newAdresse = new Adresse();
            newAdresse.setVille(villeField.getText());
            newAdresse.setRue(rueField.getText());
            newAdresse.setNumero(Integer.parseInt(numeroField.getText()));
            newAdresse.setCodePostal(Integer.parseInt(codePostalField.getText()));

            AdresseDAOImpl adresseDAO = new AdresseDAOImpl();
            adresseDAO.createAdresse(newAdresse);

            createStage.close();

            tableView.getItems().clear();
            AdresseDAOImpl adresseDAO1 = new AdresseDAOImpl();
            tableView.getItems().addAll(adresseDAO1.getAllAdresses());
        });

        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(event -> createStage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                villeLabel, villeField,
                rueLabel, rueField,
                numeroLabel, numeroField,
                codePostalLabel, codePostalField,
                saveButton, cancelButton
        );
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 800);
        createStage.setScene(scene);
        createStage.show();
    }

    private void handleUpdateAdresse(TableView<Adresse> tableView) {
        Adresse selectedAdresse = tableView.getSelectionModel().getSelectedItem();
        if (selectedAdresse != null) {
            System.out.println("Modifier une adresse: " + selectedAdresse.getId());

            Stage updateStage = new Stage();

            Label villeLabel = new Label("Ville:");
            TextField villeField = new TextField();
            villeField.setText(selectedAdresse.getVille());

            Label rueLabel = new Label("Rue:");
            TextField rueField = new TextField();
            rueField.setText(selectedAdresse.getRue());

            Label numeroLabel = new Label("Numéro:");
            TextField numeroField = new TextField();
            numeroField.setText(selectedAdresse.getNumero().toString());

            Label codePostalLabel = new Label("Code postal:");
            TextField codePostalField = new TextField();
            codePostalField.setText(selectedAdresse.getCodePostal().toString());

            Button saveButton = new Button("Enregistrer");
            saveButton.setOnAction(event -> {
                selectedAdresse.setVille(villeField.getText());
                selectedAdresse.setRue(rueField.getText());
                selectedAdresse.setNumero(Integer.parseInt(numeroField.getText()));
                selectedAdresse.setCodePostal(Integer.parseInt(codePostalField.getText()));

                AdresseDAOImpl adresseDAO = new AdresseDAOImpl();
                adresseDAO.updateAdresse(selectedAdresse);

                updateStage.close();

                tableView.getItems().clear();
                AdresseDAOImpl adresseDAO1 = new AdresseDAOImpl();
                tableView.getItems().addAll(adresseDAO1.getAllAdresses());
            });

            Button cancelButton = new Button("Annuler");
            cancelButton.setOnAction(event -> updateStage.close());

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(10));
            vbox.getChildren().addAll(
                villeLabel, villeField,
                rueLabel, rueField,
                numeroLabel, numeroField,
                codePostalLabel, codePostalField,
                saveButton, cancelButton
            );
            vbox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vbox, 500, 800);
            updateStage.setScene(scene);
            updateStage.show();
        } else {
            System.out.println("No Adresse selected for update.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucune adresse sélectionnée pour la mise à jour.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleDeleteAdresse(TableView<Adresse> tableView, AdresseDAOImpl adresseDAO) {
        Adresse selectedAdresse = tableView.getSelectionModel().getSelectedItem();
        if (selectedAdresse != null) {
            System.out.println("Supprimer une adresse: " + selectedAdresse.getId());
            adresseDAO.deleteAdresse(selectedAdresse.getId());
            tableView.getItems().remove(selectedAdresse);
        } else {
            System.out.println("No Adresse selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucune adresse sélectionnée pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleCreateLocation(TableView tableView) {
        Stage createStage = new Stage();
        createStage.setTitle("Créer une nouvelle location");

        Label idAdresseLabel = new Label("ID Adresse:");
        TextField idAdresseField = new TextField();

        Label appartementLabel = new Label("Appartement:");
        TextField appartementField = new TextField();

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(event -> {
            Location newLocation = new Location();
            newLocation.setIdAdresse(new Adresse(Integer.parseInt(idAdresseField.getText())));
            newLocation.setAppartement(Integer.parseInt(appartementField.getText()));

            LocationDAOImpl locationDAO = new LocationDAOImpl();
            locationDAO.createLocation(newLocation);

            createStage.close();

            tableView.getItems().clear();
            LocationDAOImpl locationDAO1 = new LocationDAOImpl();
            tableView.getItems().addAll(locationDAO1.getAllLocations());
        });

        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(event -> createStage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                idAdresseLabel, idAdresseField,
                appartementLabel, appartementField,
                saveButton, cancelButton
        );
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 800);
        createStage.setScene(scene);
        createStage.show();
    }

    private void handleUpdateLocation(TableView<Location> tableView) {
        Location selectedLocation = tableView.getSelectionModel().getSelectedItem();
        if (selectedLocation != null) {
            System.out.println("Modifier une location: " + selectedLocation.getId());

            Stage updateStage = new Stage();

            Label idAdresseLabel = new Label("ID Adresse:");
            TextField idAdresseField = new TextField();
            idAdresseField.setText(selectedLocation.getIdAdresse().getId().toString());

            Label appartementLabel = new Label("Appartement:");
            TextField appartementField = new TextField();
            appartementField.setText(selectedLocation.getAppartement().toString());

            Button saveButton = new Button("Enregistrer");
            saveButton.setOnAction(event -> {
                selectedLocation.setIdAdresse(new Adresse(Integer.parseInt(idAdresseField.getText())));
                selectedLocation.setAppartement(Integer.parseInt(appartementField.getText()));

                LocationDAOImpl locationDAO = new LocationDAOImpl();
                locationDAO.updateLocation(selectedLocation);

                updateStage.close();

                tableView.getItems().clear();
                LocationDAOImpl locationDAO1 = new LocationDAOImpl();
                tableView.getItems().addAll(locationDAO1.getAllLocations());
            });

            Button cancelButton = new Button("Annuler");
            cancelButton.setOnAction(event -> updateStage.close());

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(10));
            vbox.getChildren().addAll(
                idAdresseLabel, idAdresseField,
                appartementLabel, appartementField,
                saveButton, cancelButton
            );
            vbox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vbox, 500, 800);
            updateStage.setScene(scene);
            updateStage.show();
        } else {
            System.out.println("No Location selected for update.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucune location sélectionnée pour la mise à jour.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleDeleteLocation(TableView<Location> tableView, LocationDAOImpl locationDAO) {
        Location selectedLocation = tableView.getSelectionModel().getSelectedItem();
        if (selectedLocation != null) {
            System.out.println("Supprimer une location: " + selectedLocation.getId());
            locationDAO.deleteLocation(selectedLocation.getId());
            tableView.getItems().remove(selectedLocation);
        } else {
            System.out.println("No Location selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucune location sélectionnée pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleCreateProprietaire(TableView tableView) {
        Stage createStage = new Stage();
        createStage.setTitle("Créer un nouveau propriétaire");

        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();

        Label prenomLabel = new Label("Prénom:");
        TextField prenomField = new TextField();

        Label mailLabel = new Label("Mail:");
        TextField mailField = new TextField();

        Label telephoneLabel = new Label("Téléphone:");
        TextField telephoneField = new TextField();

        Label ribLabel = new Label("RIB:");
        TextField ribField = new TextField();

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(event -> {
            Personne newPersonne = new Personne();
            newPersonne.setNom(nomField.getText());
            newPersonne.setPrenom(prenomField.getText());
            newPersonne.setMail(mailField.getText());
            newPersonne.setTelephone(Integer.parseInt(telephoneField.getText()));
            newPersonne.setType(0);
            newPersonne.setRib(Integer.parseInt(ribField.getText()));

            PersonneDAOImpl personneDAO = new PersonneDAOImpl();
            personneDAO.createPersonne(newPersonne);

            createStage.close();

            tableView.getItems().clear();
            PersonneDAOImpl personneDAO1 = new PersonneDAOImpl();
            tableView.getItems().addAll(personneDAO1.getAllProprietaires());
        });

        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(event -> createStage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                nomLabel, nomField,
                prenomLabel, prenomField,
                mailLabel, mailField,
                telephoneLabel, telephoneField,
                ribLabel, ribField,
                saveButton, cancelButton
        );
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 800);
        createStage.setScene(scene);
        createStage.show();
    }

    private void handleUpdateProprietaire(TableView<Personne> tableView) {
        Personne selectedPersonne = tableView.getSelectionModel().getSelectedItem();
        if (selectedPersonne != null) {
            System.out.println("Modifier un propriétaire: " + selectedPersonne.getId());

            Stage updateStage = new Stage();

            Label nomLabel = new Label("Nom:");
            TextField nomField = new TextField();
            nomField.setText(selectedPersonne.getNom());

            Label prenomLabel = new Label("Prénom:");
            TextField prenomField = new TextField();
            prenomField.setText(selectedPersonne.getPrenom());

            Label mailLabel = new Label("Mail:");
            TextField mailField = new TextField();
            mailField.setText(selectedPersonne.getMail());

            Label telephoneLabel = new Label("Téléphone:");
            TextField telephoneField = new TextField();
            telephoneField.setText(selectedPersonne.getTelephone().toString());

            Label ribLabel = new Label("RIB:");
            TextField ribField = new TextField();
            ribField.setText(selectedPersonne.getRib().toString());

            Button saveButton = new Button("Enregistrer");
            saveButton.setOnAction(event -> {
                selectedPersonne.setNom(nomField.getText());
                selectedPersonne.setPrenom(prenomField.getText());
                selectedPersonne.setMail(mailField.getText());
                selectedPersonne.setTelephone(Integer.parseInt(telephoneField.getText()));
                selectedPersonne.setType(0);
                selectedPersonne.setRib(Integer.parseInt(ribField.getText()));

                PersonneDAOImpl personneDAO = new PersonneDAOImpl();
                personneDAO.updatePersonne(selectedPersonne);

                updateStage.close();

                tableView.getItems().clear();
                PersonneDAOImpl personneDAO1 = new PersonneDAOImpl();
                tableView.getItems().addAll(personneDAO1.getAllProprietaires());
            });

            Button cancelButton = new Button("Annuler");
            cancelButton.setOnAction(event -> updateStage.close());

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(10));
            vbox.getChildren().addAll(
                nomLabel, nomField,
                prenomLabel, prenomField,
                mailLabel, mailField,
                telephoneLabel, telephoneField,
                ribLabel, ribField,
                saveButton, cancelButton
            );
            vbox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vbox, 500, 800);
            updateStage.setScene(scene);
            updateStage.show();
        } else {
            System.out.println("No Propriétaire selected for update.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun propriétaire sélectionné pour la modification.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleDeleteProprietaire(TableView<Personne> tableView, PersonneDAOImpl personneDAO) {
        Personne selectedPersonne = tableView.getSelectionModel().getSelectedItem();
        if (selectedPersonne != null) {
            System.out.println("Supprimer un propriétaire: " + selectedPersonne.getId());
            personneDAO.deletePersonne(selectedPersonne.getId());
            tableView.getItems().remove(selectedPersonne);
        } else {
            System.out.println("No Propriétaire selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun propriétaire sélectionné pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleCreateLocataire(TableView tableView) {
        Stage createStage = new Stage();
        createStage.setTitle("Créer un nouveau locataire");

        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();

        Label prenomLabel = new Label("Prénom:");
        TextField prenomField = new TextField();

        Label mailLabel = new Label("Mail:");
        TextField mailField = new TextField();

        Label telephoneLabel = new Label("Téléphone:");
        TextField telephoneField = new TextField();

        Label ribLabel = new Label("RIB:");
        TextField ribField = new TextField();

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(event -> {
            Personne newPersonne = new Personne();
            newPersonne.setNom(nomField.getText());
            newPersonne.setPrenom(prenomField.getText());
            newPersonne.setMail(mailField.getText());
            newPersonne.setTelephone(Integer.parseInt(telephoneField.getText()));
            newPersonne.setType(1);
            newPersonne.setRib(Integer.parseInt(ribField.getText()));

            PersonneDAOImpl personneDAO = new PersonneDAOImpl();
            personneDAO.createPersonne(newPersonne);

            createStage.close();

            tableView.getItems().clear();
            PersonneDAOImpl personneDAO1 = new PersonneDAOImpl();
            tableView.getItems().addAll(personneDAO1.getAllLocataires());
        });

        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(event -> createStage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                nomLabel, nomField,
                prenomLabel, prenomField,
                mailLabel, mailField,
                telephoneLabel, telephoneField,
                ribLabel, ribField,
                saveButton, cancelButton
        );
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 800);
        createStage.setScene(scene);
        createStage.show();
    }

    private void handleUpdateLocataire(TableView<Personne> tableView) {
        Personne selectedPersonne = tableView.getSelectionModel().getSelectedItem();
        if (selectedPersonne != null) {
            System.out.println("Modifier un locataire: " + selectedPersonne.getId());

            Stage updateStage = new Stage();

            Label nomLabel = new Label("Nom:");
            TextField nomField = new TextField();
            nomField.setText(selectedPersonne.getNom());

            Label prenomLabel = new Label("Prénom:");
            TextField prenomField = new TextField();
            prenomField.setText(selectedPersonne.getPrenom());

            Label mailLabel = new Label("Mail:");
            TextField mailField = new TextField();
            mailField.setText(selectedPersonne.getMail());

            Label telephoneLabel = new Label("Téléphone:");
            TextField telephoneField = new TextField();
            telephoneField.setText(selectedPersonne.getTelephone().toString());

            Label ribLabel = new Label("RIB:");
            TextField ribField = new TextField();
            ribField.setText(selectedPersonne.getRib().toString());

            Button saveButton = new Button("Enregistrer");
            saveButton.setOnAction(event -> {
                selectedPersonne.setNom(nomField.getText());
                selectedPersonne.setPrenom(prenomField.getText());
                selectedPersonne.setMail(mailField.getText());
                selectedPersonne.setTelephone(Integer.parseInt(telephoneField.getText()));
                selectedPersonne.setType(1);
                selectedPersonne.setRib(Integer.parseInt(ribField.getText()));

                PersonneDAOImpl personneDAO = new PersonneDAOImpl();
                personneDAO.updatePersonne(selectedPersonne);

                updateStage.close();

                tableView.getItems().clear();
                PersonneDAOImpl personneDAO1 = new PersonneDAOImpl();
                tableView.getItems().addAll(personneDAO1.getAllLocataires());
            });

            Button cancelButton = new Button("Annuler");
            cancelButton.setOnAction(event -> updateStage.close());

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(10));
            vbox.getChildren().addAll(
                nomLabel, nomField,
                prenomLabel, prenomField,
                mailLabel, mailField,
                telephoneLabel, telephoneField,
                ribLabel, ribField,
                saveButton, cancelButton
            );
            vbox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vbox, 500, 800);
            updateStage.setScene(scene);
            updateStage.show();
        } else {
            System.out.println("No Locataire selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun locataire sélectionné pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleDeleteLocataire(TableView<Personne> tableView, PersonneDAOImpl personneDAO) {
        Personne selectedPersonne = tableView.getSelectionModel().getSelectedItem();
        if (selectedPersonne != null) {
            System.out.println("Supprimer un locataire: " + selectedPersonne.getId());
            personneDAO.deletePersonne(selectedPersonne.getId());
            tableView.getItems().remove(selectedPersonne);
        } else {
            System.out.println("No Locataire selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun locataire sélectionné pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleCreateEtatdeslieux(TableView tableView) {
        Stage createStage = new Stage();
        createStage.setTitle("Créer un nouvel état des lieux");

        Label commentaireLabel = new Label("Commentaire:");
        TextField commentaireField = new TextField();

        Button saveButton = new Button("Enregistrer");
        saveButton.setOnAction(event -> {
            Etatdeslieux newEtatdeslieux = new Etatdeslieux();
            newEtatdeslieux.setCommentaire(commentaireField.getText());

            EtatdeslieuxDAOImpl etatdeslieuxDAO = new EtatdeslieuxDAOImpl();
            etatdeslieuxDAO.createEtatdeslieux(newEtatdeslieux);

            createStage.close();

            tableView.getItems().clear();
            EtatdeslieuxDAOImpl etatdeslieuxDAO1 = new EtatdeslieuxDAOImpl();
            tableView.getItems().addAll(etatdeslieuxDAO1.getAllEtatdeslieux());
        });

        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(event -> createStage.close());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                commentaireLabel, commentaireField,
                saveButton, cancelButton
        );
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 800);
        createStage.setScene(scene);
        createStage.show();
    }

    private void handleUpdateEtatdeslieux(TableView<Etatdeslieux> tableView) {
        Etatdeslieux selectedEtatdeslieux = tableView.getSelectionModel().getSelectedItem();
        if (selectedEtatdeslieux != null) {
            System.out.println("Modifier un état des lieux: " + selectedEtatdeslieux.getId());

            Stage updateStage = new Stage();

            Label commentaireLabel = new Label("Commentaire:");
            TextField commentaireField = new TextField();
            commentaireField.setText(selectedEtatdeslieux.getCommentaire());

            Button saveButton = new Button("Enregistrer");
            saveButton.setOnAction(event -> {
                selectedEtatdeslieux.setCommentaire(commentaireField.getText());

                EtatdeslieuxDAOImpl etatdeslieuxDAO = new EtatdeslieuxDAOImpl();
                etatdeslieuxDAO.updateEtatdeslieux(selectedEtatdeslieux);

                updateStage.close();

                tableView.getItems().clear();
                EtatdeslieuxDAOImpl etatdeslieuxDAO1 = new EtatdeslieuxDAOImpl();
                tableView.getItems().addAll(etatdeslieuxDAO1.getAllEtatdeslieux());
            });

            Button cancelButton = new Button("Annuler");
            cancelButton.setOnAction(event -> updateStage.close());

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(10));
            vbox.getChildren().addAll(
                commentaireLabel, commentaireField,
                saveButton, cancelButton
            );
            vbox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vbox, 500, 800);
            updateStage.setScene(scene);
            updateStage.show();
        } else {
            System.out.println("No Etat des lieux selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun état des lieux sélectionné pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void handleDeleteEtatdeslieux(TableView<Etatdeslieux> tableView, EtatdeslieuxDAOImpl etatdeslieuxDAO) {
        Etatdeslieux selectedEtatdeslieux = tableView.getSelectionModel().getSelectedItem();
        if (selectedEtatdeslieux != null) {
            System.out.println("Supprimer un état des lieux: " + selectedEtatdeslieux.getId());
            etatdeslieuxDAO.deleteEtatdeslieux(selectedEtatdeslieux.getId());
            tableView.getItems().remove(selectedEtatdeslieux);
        } else {
            System.out.println("No Etat des lieux selected for deletion.");

            Stage errorStage = new Stage();

            Label errorLabel = new Label("Aucun état des lieux sélectionné pour la suppression.");
            errorLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold;");

            Button errorButton = new Button("OK");
            errorButton.setOnAction(event -> errorStage.close());

            VBox errorVBox = new VBox(10);
            errorVBox.setPadding(new Insets(10));
            errorVBox.getChildren().addAll(errorLabel, errorButton);
            errorVBox.setAlignment(Pos.CENTER);

            Scene errorScene = new Scene(errorVBox, 500, 200);
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    private void changeTabel(Label a, TableView b, VBox c, HBox d) {
        c.getChildren().clear();
        c.getChildren().addAll(a, b, d);
    }
}
