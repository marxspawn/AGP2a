package application;

/**
 * <center>
 * 	<h1>
 * 		<b> 
 * 		Advanced Java Programming <br>
 * 		Final Project<br>
 * 		Group 1:<br>
 * 		</b>
 * 	</h1>
 * </center>				
 * 			
 * @authors		Kevin Andrews,<br>
 *				Tyler Sanders,<br>
 * 				Raymond Anderson<br>			
 * @date		31 March 2018<br>
 * Course:		COP-2805C<br>
 * 				Advanced Java Programming<br>
 * Professor:	Stendel<br>
 * 
 * <blockquote>
 * 	This is a group project, so all team members must work together 
 * 	to create a single program, which only one of your team will submit.
 * </blockquote>
 * 
 * <p>
 * 	<b>
 * 		Instructions:
 * 	</b>
 * </p>
 * 
 * <p>
 * 	<ul>
 * 		<b>
 * 			1. Design and implement a Java system <br>
 * 			based on the following criteria and information:
 * 		</b>
 * 		<li>
 * 			Must track multiple kinds of objects, for example
 * 		</li>
 * 		<li>
 * 			People, e.g., customers, employees, students, instructors, etc.
 * 		</li>
 * 		<li>
 * 			Products including IDs, descriptions, inventory, etc.
 * 		</li>
 * 		<li>
 * 			Courses, etc.
 * 		</li>
 * 		<li>
 * 			Services, etc.
 * 		</li>
 * 	</ul>
 * </p>
 * 
 * <p>
 * 	<p>
 * 		Must follow a three-tier application model 
 * 		or software architecture,<br>
 * 		i.e., consist of the following three layers
 * 	</p>
 * 
 * 	<b>User Interface,</b> 
 * 		<blockquote>
 * 			which must be accomplished using JavaFX, i.e., 
 * 			all information gathered from the user or displayed 
 * 			to the user must be done via JavaFX panes, etc.
 * 		</blockquote>
 * 	
 * 	<b>logic,</b> 
 * 		<blockquote> 
 * 			consist of objects, lists, etc. where the data is temporarily 
 * 			munipulated in RAM and separates the user interface from the database.
 * 		</blockquote>
 * 	
 * 	<b>Database,</b> 
 * 		<blockquote>
 * 			the data is permanently stored must use polymorphism, 
 * 			e.g., a list of different types of people.
 * 		</blockquote></p>
 * 
 * <p>
 * 	Must implement CRUD, that is:
 * 	<ul>
 * 		<li>
 * 			Create, i.e., add new data, e.g., via an object/record to a list.
 * 		</li>
 * 		<li>
 * 			Retrieve, i.e., retrieve and display information from a record.
 * 		</li>
 * 		<li>
 * 			Update, i.e., change an existing record.
 * 		</li>
 * 		<li>
 * 			Delete, i.e., appropriately remove a record from a list;
 * 		</li> 
 * 		<li>
 * 			Must demonstrate searching for and displaying one and many records,<br> 
 * 			and sorting the data appropriately.
 * 		</li>
 * 	</ul>
 * 	keep in mind, you may need to archive the information or delete other related information to maintain integrity.
 * </p>
 * 
 * <p>
 * 	Thoroughly test your system using a variety of data and on different systems. 
 * 	Your system should work whether data exist in the database or not. 
 * 	In other words, the system should be able to create the initial database,
 * 	if one does not already exist, and then, go from there.
 * </p>
 * 
 * <p>
 * 	Export your entire project via Eclipse including the database. 
 * 	At this point, you should test it by importing it into Eclispe via a different system. 
 * 	Create instructions for accomplishing this; in other words, when the professor imports your project at home, 
 * 	there should be no issues.
 * </p>
 * 
 * <p>
 * 	<ul>
 * 		<li>
 * 			Zip up everything into a single ZIP file.
 * 		</li>
 * 		<li>
 * 			Have only one member of your team submit the ZIP file via this assignment.
 * 		</li>
 * 		<li>
 * 			Verify your submission.
 * 		</li>
 * 		<li>
 * 			Complete AGP2b - Final Project individually, i.e., <br>
 * 				each person must submit a completed Group Evaluation form.
 * 		</li>
 * 		<li>
 * 			Prepare to demonstrate your application during class.
 * 		</li>
 * 	</ul>
 * </p>
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	ArrayList<Sales> sales = new ArrayList<Sales>();
	ArrayList<Customers> customers = new ArrayList<Customers>();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Food> product = new ArrayList<Food>();
	ArrayList<Services> services = new ArrayList<Services>();
	ArrayList<Integer> index = new ArrayList<Integer>();
	ArrayList<String> productList = new ArrayList<String>();
	ArrayList<Double> priceList = new ArrayList<Double>();
	ListView<Food> productTable = new ListView<Food>();
	ObservableList<Food> customerOrder = FXCollections.observableArrayList(product);	
	ListView<Sales> taxTable = new ListView<>();
	ObservableList<Sales> taxOrder = FXCollections.observableArrayList(sales);
		
	Food burger = new Food("Burger", "0001-3241-ADF9", 1000, 5, 2, "gluten");
	Food hotDog = new Food("Hot Dog", "0001-9841-ADG2", 500, 3, 1, "gluten");
	Drink cokeS = new Drink("Coke\n(S)", "0002-9841-JKFN", 2, .3, "S");
	Drink cokeM = new Drink("Coke\n(M)", "0002-9841-JKFN", 2.5, .35, "M");
	Drink cokeL = new Drink("Coke\n(L)", "0002-9841-JKFN", 3, .4, "L");
	Drink teaS = new Drink("Tea\n(S)", "0002-9841-LJNC", 2, .1, "S");
	Drink teaM = new Drink("Tea\n(M)", "0002-9841-LJNC", 2.5, .15, "M");
	Drink teaL = new Drink("Tea\n(L)", "0002-9841-LJNC", 3, .2, "L");
	Drink lemonadeS = new Drink("Lemonade\n(S)", "0002-9841-WOUE", 2.5, .5, "S");
	Drink lemonadeM = new Drink("Lemonade\n(M)", "0002-9841-WOUE", 3, .55, "M");
	Drink lemonadeL = new Drink("Lemonade\n(L)", "0002-9841-WOUE", 3.5, .6, "L");
	Snack pieBlueberry = new Snack("Blueberry\nPie", "0003-9841-IFGG", 4, 1, false, false, false);
	Snack iceCream = new Snack("Ice Cream", "0003-9841-LEKF", 4, 1, false, true, false);	
	Snack tapioca = new Snack("Tapioca", "0003-9841-KMJB", 4, 1, false, false, true);

	Food brgr = new Food("Burger	", 5.00);
	Food htDg = new Food("Hot Dog	", 3.00);
	Food ckSm = new Food("Coke (sm)", 2.00);
	Food ckMd = new Food("Coke (M)", 2.50);
	Food ckLg = new Food("Coke (L)", 3.00);
	Food tSm = new Food("Tea (S)	", 2.00);
	Food tMd = new Food("Tea (M)	", 2.50);
	Food tLg = new Food("Tea (L)	", 3.00);
	Food lmnS = new Food("Lemonade (S)",2.50);
	Food lmnM = new Food("Lemonade (M)", 3.00);
	Food lmnL = new Food("Lemonade (L)", 3.50);
	Food bbPie = new Food("Blueberry Pie", 4.00);
	Food iceC = new Food("Ice Cream", 4.00);
	Food tapPud = new Food("Tapioca	", 4.00);
	
	
	Button burgerB = new Button(burger.getName());
	Button hotDogB = new Button(hotDog.getName());
	Button cokeSB = new Button(cokeS.getName());
	Button cokeMB = new Button(cokeM.getName());
	Button cokeLB = new Button(cokeL.getName());
	Button teaSB = new Button(teaS.getName());
	Button teaMB = new Button(teaM.getName());
	Button teaLB = new Button(teaL.getName());
	Button lemonadeSB = new Button(lemonadeS.getName());
	Button lemonadeMB = new Button(lemonadeM.getName());
	Button lemonadeLB = new Button(lemonadeL.getName());
	Button pieBlueberryB = new Button(pieBlueberry.getName());
	Button iceCreamB = new Button(iceCream.getName());
	Button tapiocaB = new Button(tapioca.getName());
	Button managerMenuB = new Button("Manager\nMenu");
	Button submitB = new Button("Submit");
	Button cancelB = new Button("Cancel");
	Button removeB = new Button("Remove\nItems");
	Button addB = new Button("Add\nItems");
	
	@Override
	public void start(Stage primaryStage) {

		
		try {
			// Product index guide:
			// burger - 0; hotdog - 1; cokeS - 2; cokeM - 3; cokeL - 4; teaS - 5; teaM - 6;
			// teaL - 7; lemonadeS - 8; lemonadeM - 9; lemonadeL - 10; pieBlueberry - 11;
			// iceCream - 12; tapioca - 13;
				products.add(burger);
				products.add(hotDog);
				products.add(cokeS);
				products.add(cokeM);
				products.add(cokeL);
				products.add(teaS);
				products.add(teaM);
				products.add(teaL);
				products.add(lemonadeS);
				products.add(lemonadeM);
				products.add(lemonadeL);
				products.add(pieBlueberry);
				products.add(iceCream);
				products.add(tapioca);
				
			// Add the tags to style with the application.css file
				burgerB.setId("button");
				hotDogB.setId("button");
				cokeSB.setId("button");
				cokeMB.setId("button");
				cokeLB.setId("button");
				teaSB.setId("button");
				teaMB.setId("button");
				teaLB.setId("button");
				lemonadeSB.setId("button");
				lemonadeMB.setId("button");
				lemonadeLB.setId("button");
				pieBlueberryB.setId("button");
				tapiocaB.setId("button");
				iceCreamB.setId("button");
				managerMenuB.setId("button");
				submitB.setId("button");
				cancelB.setId("button");
				removeB.setId("button");
				addB.setId("button");
			
			// create necessary labels and text fields
			Label nameLabel = new Label("Enter Name:  ");
			TextField nameField = new TextField();
			Label phoneLabel = new Label("Enter Phone:  ");
			TextField phoneField = new TextField();
			Label callLabel = new Label("Call?");
			Label subLabel = new Label("SUBTOTAL: ");
			Label taxLabel = new Label("TAX: ");
			Label totalLabel = new Label("Total: ");
			
			// Add the tags to style with the application.css file
				nameField.setId("textField");
				nameLabel.setId("text");
				phoneLabel.setId("text");
				phoneField.setId("textField");
				callLabel.setId("text");
			
			// Add
			VBox taxBoxTotal = new VBox(10, subLabel, taxLabel, totalLabel);
			CheckBox callAsk = new CheckBox("Yes");
				callAsk.setId("text");
				callAsk.setSelected(true);

			// Add Nodes
			BorderPane menu = new BorderPane();
				menu.setPadding(new Insets(40));
			VBox food = new VBox(10, burgerB, hotDogB);
			VBox drinkSoda = new VBox(10, cokeSB, cokeMB, cokeLB);
			VBox drinkTea = new VBox(10, teaSB, teaMB, teaLB);
			VBox drinkLemonade = new VBox(10, lemonadeSB, lemonadeMB, lemonadeLB);
			VBox snacks = new VBox(10, pieBlueberryB, iceCreamB, tapiocaB);
			HBox menuButtons = new HBox(10, submitB, managerMenuB, cancelB);
			HBox left = new HBox(10, food, drinkSoda, drinkTea, drinkLemonade, snacks);
			VBox center = new VBox(20, addB, removeB);
			HBox top = new HBox(20, nameLabel, nameField, phoneLabel, phoneField, callLabel, callAsk);
			
			// Add event to buttons
			addB.setOnAction(e -> add_BTN());			
			removeB.setOnAction(e -> remove_BTN());

			managerMenuB.setOnAction(event -> {
				// Add Panes
				Button doneButton = new Button("Done");
					doneButton.setId("button");
				Button viewSalesButton = new Button("Sales");
					viewSalesButton.setId("button");
				Button viewCustomersButton = new Button("Customers");
					viewCustomersButton.setId("button");
				Button viewProductsButton = new Button("Products");
					viewProductsButton.setId("button");
				HBox managerMenu = new HBox(20, viewSalesButton, viewCustomersButton, viewProductsButton, doneButton);

				// Add Stage
				final Stage results = new Stage();

				// Add Stage Properties
					results.initOwner(primaryStage);
					results.setTitle("Manager Menu");
					managerMenu.setAlignment(Pos.CENTER);
				VBox listMenu = new VBox(10, managerMenu);
					listMenu.setPadding(new Insets(20));
					managerMenu.setPadding(new Insets(10, 20, 10, 20));

				Scene resultsScene = new Scene(listMenu, 600, 250);
					resultsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
					results.setScene(resultsScene);
					results.show();

				viewProductsButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						
						// Add Nodes
						Button done = new Button("Done");
						VBox productList = new VBox(10, done);
							productList.setId("popWindow");
							productList.setPadding(new Insets(10, 20, 10, 20));
							done.setId("button2");
						for (int i = 0; i < products.size(); i++) {
							productList.getChildren().add(new Text(products.get(i).getName()));
						}
						// Stage
						final Stage results = new Stage();

						// Stage Properties
							results.initOwner(primaryStage);
							results.setTitle("Products");

						
						
						Scene resultsScene = new Scene(productList, 300, 640);
							resultsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							results.sizeToScene();
							results.setScene(resultsScene);
							results.show();

							done.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								results.close();
							}
						});
					}
				});

				viewCustomersButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						// Nodes
						Label editLabel = new Label("Enter customer number to change: ");
							editLabel.setId("text");
						TextField editCustomer = new TextField();
							editCustomer.setId("textField");
						Button deleteCustomer = new Button("Delete");
							deleteCustomer.setId("button2");
						Button clearNoName = new Button("Delete Blank Names");
							clearNoName.setId("button2");
						Button clearNoNumber = new Button("Delete Blank Number");
							clearNoNumber.setId("button2");
						Button sort = new Button("Sort by name");
							sort.setId("button2");
						TextField textUpdate = new TextField();
							textUpdate.setId("textField2");
							textUpdate.setEditable(false);

						Button editName = new Button("Change name to:");
							editName.setId("button2");
						TextField nameField = new TextField();
							nameField.setId("textField");
						Button editNumber = new Button("Change number to:");
							editNumber.setId("button2");
						TextField numberField = new TextField();
							numberField.setId("textField");

						Button finishedButton = new Button("Done");
							finishedButton.setId("button2");

						VBox nameSide = new VBox(15);
						VBox numberSide = new VBox(15);
						VBox callSide = new VBox(15);
						HBox editLine = new HBox(15, editName, nameField, editNumber, numberField);
						HBox sideInfo = new HBox(15, nameSide, numberSide, callSide);
						HBox deleteLine1 = new HBox(15, editLabel, editCustomer);
						HBox deleteLine2 = new HBox(15, deleteCustomer, clearNoName, clearNoNumber, sort);
						VBox deleteLine = new VBox(15, deleteLine1, deleteLine2);
						ScrollPane infoScroll = new ScrollPane(sideInfo);
							infoScroll.setPrefHeight(350);
						VBox customerPane = new VBox(20, infoScroll, textUpdate, deleteLine, editLine, finishedButton);
						customerPane.setPadding(new Insets(20, 40, 20, 40));

						for (int i = 0; i < customers.size(); i++) {
							nameSide.getChildren()
									.add(new Text(Integer.toString(i) + ".)  " + customers.get(i).getName()));
							numberSide.getChildren().add(new Text(customers.get(i).getPhoneNumber()));
							callSide.getChildren()
									.add(new Text("Call? " + Boolean.toString(customers.get(i).isCall())));
						}

						

						// Stage
						final Stage results = new Stage();
						

						// Stage Properties
						results.initOwner(primaryStage);
						results.setTitle("Customers");

						
						Scene resultsScene = new Scene(customerPane, 1300, 700);
						resultsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						results.sizeToScene();
						results.setScene(resultsScene);
						results.show();

						deleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editCustomer.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < customers.size()) {
									customers.remove(index);
									textUpdate.setText("Customer " + index + " removed successfully! Updating List...");

									nameSide.getChildren().clear();
									numberSide.getChildren().clear();
									callSide.getChildren().clear();
									for (int i = 0; i < customers.size(); i++) {
										nameSide.getChildren().add(
												new Text(Integer.toString(i) + ".)  " + customers.get(i).getName()));
										numberSide.getChildren().add(new Text(customers.get(i).getPhoneNumber()));
										callSide.getChildren()
												.add(new Text("Call? " + Boolean.toString(customers.get(i).isCall())));
									}

								} else {
									textUpdate.setText("Bad value entered.");
								}
								editCustomer.clear();
							}
						});

						clearNoName.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								String index = "";
								for (int i = (customers.size() - 1); i >= 0; i--) {
									if (customers.get(i).getName().equals("Name Not Entered")
											|| customers.get(i).getName().equals("Entered incorrectly")) {
										index = (index + i + " ");
										customers.remove(i);
									}
								}
								if (index.equals("")) {
									textUpdate.setText("No customers removed from list.");
								} else {
									textUpdate
											.setText("Customer(s) " + index + "removed successfully! Updating List...");
									nameSide.getChildren().clear();
									numberSide.getChildren().clear();
									callSide.getChildren().clear();
									for (int i = 0; i < customers.size(); i++) {
										nameSide.getChildren().add(
												new Text(Integer.toString(i) + ".)  " + customers.get(i).getName()));
										numberSide.getChildren().add(new Text(customers.get(i).getPhoneNumber()));
										callSide.getChildren()
												.add(new Text("Call? " + Boolean.toString(customers.get(i).isCall())));
									}
								}
							}
						});

						clearNoNumber.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {

								String index = "";
								for (int i = (customers.size() - 1); i >= 0; i--) {
									if (customers.get(i).getPhoneNumber().equals("Name Not Entered")
											|| customers.get(i).getPhoneNumber().equals("Entered incorrectly")) {
										index = (index + i + " ");
										customers.remove(i);
									}
								}
								if (index.equals("")) {
									textUpdate.setText("No customers removed from list.");
								} else {
									textUpdate
											.setText("Customer(s) " + index + "removed successfully! Updating List...");
									nameSide.getChildren().clear();
									numberSide.getChildren().clear();
									callSide.getChildren().clear();
									for (int i = 0; i < customers.size(); i++) {
										nameSide.getChildren().add(
												new Text(Integer.toString(i) + ".)  " + customers.get(i).getName()));
										numberSide.getChildren().add(new Text(customers.get(i).getPhoneNumber()));
										callSide.getChildren()
												.add(new Text("Call? " + Boolean.toString(customers.get(i).isCall())));
									}
								}
							}
						});

						sort.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								customers.sort(null);
								textUpdate.setText("Order updated! Updating list...");
								nameSide.getChildren().clear();
								numberSide.getChildren().clear();
								callSide.getChildren().clear();
								for (int i = 0; i < customers.size(); i++) {
									nameSide.getChildren()
											.add(new Text(Integer.toString(i) + ".)  " + customers.get(i).getName()));
									numberSide.getChildren().add(new Text(customers.get(i).getPhoneNumber()));
									callSide.getChildren()
											.add(new Text("Call? " + Boolean.toString(customers.get(i).isCall())));
								}
							}
						});

						editName.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editCustomer.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < customers.size()) {
									String name = nameField.getText();
									nameField.clear();
									name.trim();
									boolean word = true;
									for (int i = 0; i < name.length() && word == true; i++) {
										if (Character.isDigit(name.charAt(i))) {
											word = false;
										}
									}
									if (word && !name.isEmpty()) {
										customers.get(index).setName(name);
										textUpdate.setText("Record updated successfully! Updating list...");
										nameSide.getChildren().clear();
										numberSide.getChildren().clear();
										callSide.getChildren().clear();
										for (int i = 0; i < customers.size(); i++) {
											nameSide.getChildren().add(new Text(
													Integer.toString(i) + ".)  " + customers.get(i).getName()));
											numberSide.getChildren().add(new Text(customers.get(i).getPhoneNumber()));
											callSide.getChildren().add(
													new Text("Call? " + Boolean.toString(customers.get(i).isCall())));
										}
									} else {
										textUpdate.setText("Text entered incorrectly. Letters only.");
									}
								}
								editCustomer.clear();
							}
						});

						editNumber.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editCustomer.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < customers.size()) {
									String phoneNumber = numberField.getText();
									numberField.clear();
									boolean number = true;
									for (int i = 0; i < phoneNumber.length() && number == true; i++) {
										if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(i) == '-') {
											number = false;
										}
									}
									if ((phoneNumber.length() == 10 || phoneNumber.length() == 12) && number == true) {
										if (phoneNumber.length() == 12) {
											customers.get(index).setPhoneNumber((phoneNumber.substring(0, 2)
													+ phoneNumber.substring(4, 6) + phoneNumber.substring(8, 11)));
											textUpdate.setText("Record updated successfully! Updating list...");
											nameSide.getChildren().clear();
											numberSide.getChildren().clear();
											callSide.getChildren().clear();
											for (int i = 0; i < customers.size(); i++) {
												nameSide.getChildren().add(new Text(
														Integer.toString(i) + ".)  " + customers.get(i).getName()));
												numberSide.getChildren()
														.add(new Text(customers.get(i).getPhoneNumber()));
												callSide.getChildren().add(new Text(
														"Call? " + Boolean.toString(customers.get(i).isCall())));
											}
										} else if (phoneNumber.length() == 10) {
											customers.get(index).setPhoneNumber(phoneNumber);
											textUpdate.setText("Record updated successfully! Updating list...");
											nameSide.getChildren().clear();
											numberSide.getChildren().clear();
											callSide.getChildren().clear();
											for (int i = 0; i < customers.size(); i++) {
												nameSide.getChildren().add(new Text(
														Integer.toString(i) + ".)  " + customers.get(i).getName()));
												numberSide.getChildren()
														.add(new Text(customers.get(i).getPhoneNumber()));
												callSide.getChildren().add(new Text(
														"Call? " + Boolean.toString(customers.get(i).isCall())));
											}
										}
									} else {
										textUpdate.setText(
												"Phone number entered incorrectly.  Use XXXXXXXXXX or XXX-XXX-XXXX format.");
										customers.get(index).setPhoneNumber("Entered incorrectly");
									}

								} else {
									textUpdate.setText("Text entered incorrectly. Letters only.");
								}
								editCustomer.clear();
							}
						});

						finishedButton.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								results.close();
							}
						});
					}
				});

				viewSalesButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						// Nodes
						Label editLabel = new Label("Enter customer's index number to change:");
							editLabel.setId("text");
						TextField editSales = new TextField();
							editSales.setId("textField");
						Button deleteSales = new Button("Delete");
							deleteSales.setId("button2");
						Button clearBlankSales = new Button("Delete Blank Sales	");
							clearBlankSales.setId("button2");
						Button sort = new Button("Sort by time	");
							sort.setId("button2");
						TextField textUpdate = new TextField();
							textUpdate.setId("textField2");
							textUpdate.setEditable(false);

						Button editTotal = new Button("Change total to:	");
							editTotal.setId("button2");
						TextField totalField = new TextField();
							totalField.setId("textField");	
						Button editFood = new Button("Change food sold to:	");
							editFood.setId("button2");
						TextField foodField = new TextField();
							foodField.setId("textField");
						
						Button editDrink = new Button("Change drink sold to:	");
							editDrink.setId("button2");
						TextField drinkField = new TextField();
							drinkField.setId("textField");
						Button editSnack = new Button("Change snack sold to:	");
							editSnack.setId("button2");
						TextField snackField = new TextField();
							snackField.setId("textField");

						Button finishedButton = new Button("Done");
							finishedButton.setId("button2");

						HBox customerIndex = new HBox(15, editLabel, editSales);
						HBox deleteLine = new HBox(15, deleteSales, clearBlankSales, sort);
						VBox topSection = new VBox(15, customerIndex, deleteLine);
						VBox timestampSide = new VBox(15);
						VBox subtotalSide = new VBox(15);
						VBox taxSide = new VBox(15);
						VBox totalSide = new VBox(15);
						VBox paymentSide = new VBox(15);
						VBox foodSoldSide = new VBox(15);
						VBox drinkSoldSide = new VBox(15);
						VBox snackSoldSide = new VBox(15);
						HBox sideInfo = new HBox(15, timestampSide, subtotalSide, taxSide, totalSide, paymentSide,
													foodSoldSide, drinkSoldSide, snackSoldSide);
						ScrollPane infoScroll = new ScrollPane(sideInfo);
							infoScroll.setPrefHeight(350);
						HBox editLine1 = new HBox(15, editTotal, totalField, editFood, foodField);
						HBox editLine2 = new HBox(15, editDrink, drinkField, editSnack, snackField);
						VBox editLine = new VBox(15, topSection, editLine1, editLine2);
						VBox customerPane = new VBox(15, infoScroll, textUpdate, editLine, finishedButton);
						

						for (int i = 0; i < sales.size(); i++) {
							timestampSide.getChildren()
									.add(new Text(Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
							subtotalSide.getChildren().add(new Text(Double.toString(sales.get(i).getSubtotal())));
							taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
							totalSide.getChildren().add(new Text(Double.toString(sales.get(i).getTotal())));
							paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
							foodSoldSide.getChildren().add(new Text(Integer.toString(sales.get(i).getFoodSold())));
							drinkSoldSide.getChildren().add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
							snackSoldSide.getChildren().add(new Text(Integer.toString(sales.get(i).getSnackSold())));
						}

							infoScroll.setPadding(new Insets(10));
							infoScroll.setMaxHeight(300);
							customerPane.getChildren().addAll();
							customerPane.setPadding(new Insets(20));
						// Stage
						final Stage results = new Stage();

						// Stage Properties
							results.initOwner(primaryStage);
							results.setTitle("Customers");

						Scene resultsScene = new Scene(customerPane, 1400, 700);
							resultsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							results.setScene(resultsScene);
							results.show();
							
						deleteSales.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editSales.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < customers.size()) {
									sales.remove(index);
									textUpdate.setText("Sale " + index + " removed successfully! Updating List...");

									timestampSide.getChildren().clear();
									subtotalSide.getChildren().clear();
									taxSide.getChildren().clear();
									totalSide.getChildren().clear();
									paymentSide.getChildren().clear();
									foodSoldSide.getChildren().clear();
									drinkSoldSide.getChildren().clear();
									snackSoldSide.getChildren().clear();
									for (int i = 0; i < sales.size(); i++) {
										timestampSide.getChildren().add(
												new Text(Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
										subtotalSide.getChildren()
												.add(new Text(Double.toString(sales.get(i).getSubtotal())));
										taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
										totalSide.getChildren().add(new Text(Double.toString(sales.get(i).getTotal())));
										paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
										foodSoldSide.getChildren()
												.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
										drinkSoldSide.getChildren()
												.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
										snackSoldSide.getChildren()
												.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
									}

								} else {
									textUpdate.setText("Bad value entered.");
								}
								editSales.clear();
							}
						});

						clearBlankSales.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								String index = "";
								for (int i = (sales.size() - 1); i >= 0; i--) {
									if (sales.get(i).getTotal() == 0) {
										index = (index + i + " ");
										sales.remove(i);
									}
								}
								if (index.equals("")) {
									textUpdate.setText("No sales removed from list.");
								} else {
									textUpdate.setText("Sale(s) " + index + "removed successfully! Updating List...");
									timestampSide.getChildren().clear();
									subtotalSide.getChildren().clear();
									taxSide.getChildren().clear();
									totalSide.getChildren().clear();
									paymentSide.getChildren().clear();
									foodSoldSide.getChildren().clear();
									drinkSoldSide.getChildren().clear();
									snackSoldSide.getChildren().clear();
									for (int i = 0; i < sales.size(); i++) {
										timestampSide.getChildren().add(
												new Text(Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
										subtotalSide.getChildren()
												.add(new Text(Double.toString(sales.get(i).getSubtotal())));
										taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
										totalSide.getChildren().add(new Text(Double.toString(sales.get(i).getTotal())));
										paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
										foodSoldSide.getChildren()
												.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
										drinkSoldSide.getChildren()
												.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
										snackSoldSide.getChildren()
												.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
									}
								}
							}
						});

						sort.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								sales.sort(null);
								textUpdate.setText("Order updated! Updating list...");
								timestampSide.getChildren().clear();
								subtotalSide.getChildren().clear();
								taxSide.getChildren().clear();
								totalSide.getChildren().clear();
								paymentSide.getChildren().clear();
								foodSoldSide.getChildren().clear();
								drinkSoldSide.getChildren().clear();
								snackSoldSide.getChildren().clear();
								for (int i = 0; i < sales.size(); i++) {
									timestampSide.getChildren()
											.add(new Text(Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
									subtotalSide.getChildren()
											.add(new Text(Double.toString(sales.get(i).getSubtotal())));
									taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
									totalSide.getChildren().add(new Text(Double.toString(sales.get(i).getTotal())));
									paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
									foodSoldSide.getChildren()
											.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
									drinkSoldSide.getChildren()
											.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
									snackSoldSide.getChildren()
											.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
								}
							}
						});

						editTotal.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editSales.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < sales.size()) {
									String total = totalField.getText();
									totalField.clear();
									total.trim();
									boolean number = true;
									for (int i = 0; i < total.length() && number == true; i++) {
										if (Character.isAlphabetic(total.charAt(i))) {
											number = false;
										}
									}
									if (number && !total.isEmpty()) {
										try {
											sales.get(index).setTotal(Double.parseDouble(total));
										} catch (NumberFormatException e) {
											textUpdate.setText(
													"Error: sale not updated. Please check entered information.");
										}
										textUpdate.setText("Record updated successfully! Updating list...");
										timestampSide.getChildren().clear();
										subtotalSide.getChildren().clear();
										taxSide.getChildren().clear();
										totalSide.getChildren().clear();
										paymentSide.getChildren().clear();
										foodSoldSide.getChildren().clear();
										drinkSoldSide.getChildren().clear();
										snackSoldSide.getChildren().clear();
										for (int i = 0; i < sales.size(); i++) {
											timestampSide.getChildren().add(new Text(
													Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
											subtotalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getSubtotal())));
											taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
											totalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getTotal())));
											paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
											foodSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
											drinkSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
											snackSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
										}
									} else {
										textUpdate.setText("Text entered incorrectly. Letters only.");
									}
								}
								editSales.clear();
							}
						});

						editFood.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editSales.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < sales.size()) {
									String total = foodField.getText();
									foodField.clear();
									total.trim();
									boolean number = true;
									for (int i = 0; i < total.length() && number == true; i++) {
										if (Character.isAlphabetic(total.charAt(i))) {
											number = false;
										}
									}
									if (number && !total.isEmpty()) {
										try {
											sales.get(index).setFoodSold(Integer.parseInt(total));
										} catch (NumberFormatException e) {
											textUpdate.setText(
													"Error: sale not updated. Please check entered information.");
										}
										textUpdate.setText("Record updated successfully! Updating list...");
										timestampSide.getChildren().clear();
										subtotalSide.getChildren().clear();
										taxSide.getChildren().clear();
										totalSide.getChildren().clear();
										paymentSide.getChildren().clear();
										foodSoldSide.getChildren().clear();
										drinkSoldSide.getChildren().clear();
										snackSoldSide.getChildren().clear();
										for (int i = 0; i < sales.size(); i++) {
											timestampSide.getChildren().add(new Text(
													Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
											subtotalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getSubtotal())));
											taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
											totalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getTotal())));
											paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
											foodSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
											drinkSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
											snackSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
										}
									} else {
										textUpdate.setText("Text entered incorrectly. Numbers only.");
									}
								}
								editSales.clear();
							}
						});

						editDrink.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editSales.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < sales.size()) {
									String total = drinkField.getText();
									drinkField.clear();
									total.trim();
									boolean number = true;
									for (int i = 0; i < total.length() && number == true; i++) {
										if (Character.isAlphabetic(total.charAt(i))) {
											number = false;
										}
									}
									if (number && !total.isEmpty()) {
										try {
											sales.get(index).setDrinkSold(Integer.parseInt(total));
										} catch (NumberFormatException e) {
											textUpdate.setText(
													"Error: sale not updated. Please check entered information.");
										}
										textUpdate.setText("Record updated successfully! Updating list...");
										timestampSide.getChildren().clear();
										subtotalSide.getChildren().clear();
										taxSide.getChildren().clear();
										totalSide.getChildren().clear();
										paymentSide.getChildren().clear();
										foodSoldSide.getChildren().clear();
										drinkSoldSide.getChildren().clear();
										snackSoldSide.getChildren().clear();
										for (int i = 0; i < sales.size(); i++) {
											timestampSide.getChildren().add(new Text(
													Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
											subtotalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getSubtotal())));
											taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
											totalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getTotal())));
											paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
											foodSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
											drinkSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
											snackSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
										}
									} else {
										textUpdate.setText("Text entered incorrectly. Numbers only.");
									}
								}
								editSales.clear();
							}
						});

						editSnack.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								int index = -1;
								try {
									index = Integer.parseInt(editSales.getText());
								} catch (NumberFormatException e) {
									textUpdate.setText("Bad information entered by user.");
								}
								if (index >= 0 && index < sales.size()) {
									String total = snackField.getText();
									snackField.clear();
									total.trim();
									boolean number = true;
									for (int i = 0; i < total.length() && number == true; i++) {
										if (Character.isAlphabetic(total.charAt(i))) {
											number = false;
										}
									}
									if (number && !total.isEmpty()) {
										try {
											sales.get(index).setSnackSold(Integer.parseInt(total));
										} catch (NumberFormatException e) {
											textUpdate.setText(
													"Error: sale not updated. Please check entered information.");
										}
										textUpdate.setText("Record updated successfully! Updating list...");
										timestampSide.getChildren().clear();
										subtotalSide.getChildren().clear();
										taxSide.getChildren().clear();
										totalSide.getChildren().clear();
										paymentSide.getChildren().clear();
										foodSoldSide.getChildren().clear();
										drinkSoldSide.getChildren().clear();
										snackSoldSide.getChildren().clear();
										for (int i = 0; i < sales.size(); i++) {
											timestampSide.getChildren().add(new Text(
													Integer.toString(i) + ".)  " + sales.get(i).getTimestamp()));
											subtotalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getSubtotal())));
											taxSide.getChildren().add(new Text(Double.toString(sales.get(i).getTax())));
											totalSide.getChildren()
													.add(new Text(Double.toString(sales.get(i).getTotal())));
											paymentSide.getChildren().add(new Text(sales.get(i).getPayment()));
											foodSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getFoodSold())));
											drinkSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getDrinkSold())));
											snackSoldSide.getChildren()
													.add(new Text(Integer.toString(sales.get(i).getSnackSold())));
										}
									} else {
										textUpdate.setText("Text entered incorrectly. Numbers only.");
									}
								}
								editSales.clear();
							}
						});

						finishedButton.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								results.close();
							}
						});
					}
				});

				doneButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						results.close();
					}
				});
			});

			submitB.setOnAction(event -> {
				Customers customer = new Customers(nameField.getText(), phoneField.getText(), callAsk.isSelected());
					customers.add(customer);
					nameField.clear();
					phoneField.clear();
					callAsk.setSelected(true);
				

				// Panes
				Button one = new Button("$1");
					one.setId("button");
				Button five = new Button("$5");
					five.setId("button");
				Button ten = new Button("$10");
					ten.setId("button");
				Button twenty = new Button("$20");
					twenty.setId("button");
				Button fifty = new Button("$50");
					fifty.setId("button");
				Button hundred = new Button("$100");
					hundred.setId("button");
				Button cash = new Button("CASH");
					cash.setId("button");
				Button credit = new Button("CREDIT");
					credit.setId("button");
				Button finalCancel = new Button("CANCEL");
					finalCancel.setId("button");
				TextField total = new TextField();
					total.setId("textField2");
				TextField change = new TextField("Change");
					change.setId("textField2");

				HBox cashButtons1 = new HBox(10, one, five, ten);
				HBox cashButtons2 = new HBox(10, twenty, fifty, hundred);
				HBox cashButtons3 = new HBox(10, cash, credit);
				VBox cashButtons = new VBox(10, cashButtons1, cashButtons2);
				VBox paymentOptions = new VBox(10, cashButtons, cashButtons3);
				VBox moneyInfo = new VBox(10, total, change);
				BorderPane submitMenu = new BorderPane();
					submitMenu.setPadding(new Insets(20));
					paymentOptions.setPadding(new Insets(20));
					moneyInfo.setPadding(new Insets(20));;

				// Pane Properties
					submitMenu.setTop(paymentOptions);
					submitMenu.setCenter(moneyInfo);
					submitMenu.setBottom(finalCancel);

				// Stage
				final Stage results = new Stage();

				
				// Stage Properties
					results.initOwner(primaryStage);
					results.setTitle("Total");

				Scene resultsScene = new Scene(submitMenu, 600, 600);
					resultsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					results.sizeToScene();
					results.setScene(resultsScene);
					results.show();

				// Button actions
				one.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						if (sale.getTotal() < 1) {
							sales.add(sale);
							double change1 = (1 - sale.getTotal());
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Insufficient funds");
						}
					}
				});
				five.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						if (sale.getTotal() < 5) {
							sales.add(sale);
							double change1 = (5 - sale.getTotal());
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Insufficient funds");
						}
					}
				});
				ten.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						if (sale.getTotal() < 10) {
							sales.add(sale);
							double change1 = (10 - sale.getTotal());
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Insufficient funds");
						}
					}
				});
				twenty.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						if (sale.getTotal() < 20) {
							sales.add(sale);
							double change1 = (20 - sale.getTotal());
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Insufficient funds");
						}
					}
				});
				fifty.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						if (sale.getTotal() < 50) {
							sales.add(sale);
							double change1 = (50 - sale.getTotal());
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Insufficient funds");
						}
					}
				});
				hundred.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						if (sale.getTotal() < 100) {
							sales.add(sale);
							double change1 = (100 - sale.getTotal());
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Insufficient funds");
						}
					}
				});
				cash.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Cash");
						sales.add(sale);
						change.setText("$0.00");
						PauseTransition delay = new PauseTransition(Duration.seconds(3));
						delay.setOnFinished(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								results.close();
							}
						});
						customerOrder.clear();
						index.clear();
						productList.clear();
						priceList.clear();
						delay.play();
					}
				});
				credit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Sales sale = createSale(index, products, "Credit");
						// This is where you would create a method to send the total to the
						// credit card reading hardware, and have the card reader return a
						// true or false on whether the payment went through. For the sake of
						// example I will just leave a true boolean because I do not have the
						// hardware set up.
						boolean paymentSuccessful = true;
						if (paymentSuccessful) {
							sales.add(sale);
							double change1 = (0);
							change.setText("$" + Double.toString(change1));
							PauseTransition delay = new PauseTransition(Duration.seconds(3));
							delay.setOnFinished(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									results.close();
								}
							});
							customerOrder.clear();
							index.clear();
							productList.clear();
							priceList.clear();
							delay.play();
						} else {
							change.setText("Payment unsuccessful");
						}
					}
				});
				finalCancel.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						results.close();
						index.clear();
						productList.clear();
						priceList.clear();
					}
				});

			});
			cancelB.setOnAction(event -> {
				index.clear();
				customerOrder.clear();
				productList.clear();
				priceList.clear();
				nameField.clear();
				phoneField.clear();
			});

	
				productTable.setItems(customerOrder);
				productTable.setMinHeight(400);
				taxTable.setItems(taxOrder);
			HBox bottom = new HBox(menuButtons);
			HBox right1 = new HBox(5, taxBoxTotal, taxTable);
				right1.setId("text");
			VBox right = new VBox(5, productTable, right1);
				right.setPrefWidth(450);
				right.setId("text");
				top.setPadding(new Insets(20));
				left.setPadding(new Insets(20));
				center.setPadding(new Insets(20));
				right.setPadding(new Insets(20));
				bottom.setPadding(new Insets(20));
			
				right.setId("order");
				right.setPadding(new Insets(10, 20, 10, 20));
				top.setAlignment(Pos.CENTER);
				left.setAlignment(Pos.CENTER);

				menu.setTop(top);
				menu.setLeft(left);
				menu.setCenter(center);
				menu.setRight(right);
				menu.setBottom(bottom);
				menu.setPadding(new Insets(10, 10, 10, 10));
				primaryStage.setFullScreen(true);
				primaryStage.setResizable(false);
			Scene scene = new Scene(menu, 1400, 700);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Stage
				primaryStage.setTitle("Point of Sale");
				primaryStage.setScene(scene);

			// primaryStage.setFullScreen(true);
			// Show
					primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// The add items button functions
	public void add_BTN() {
		burgerB.setOnAction(event -> {			
			index.add(0);
			productList.add("Burger");
			priceList.add(burger.getCost());
			customerOrder.add(brgr); 

		});
		hotDogB.setOnAction(event -> {
			index.add(1);
			productList.add("Hot Dog");
			priceList.add(hotDog.getCost());
			customerOrder.add(htDg);
		});
		cokeSB.setOnAction(event -> {
			index.add(2);
			productList.add("Coke(S)");
			priceList.add(cokeS.getCost());
			customerOrder.add(ckSm);
		});
		cokeMB.setOnAction(event -> {
			index.add(3);
			productList.add("Coke(M)");
			priceList.add(cokeM.getCost());
		    customerOrder.add(ckMd);
		});
		cokeLB.setOnAction(event -> {
			index.add(4);
			productList.add("Coke(L)");
			priceList.add(cokeL.getCost());
			customerOrder.add(ckLg);
		});
		teaSB.setOnAction(event -> {
			index.add(5);
			productList.add("Tea(S)");
			priceList.add(teaS.getCost());
			customerOrder.add(tSm);
		});
		teaMB.setOnAction(event -> {
			index.add(6);
			productList.add("Tea(M)");
			priceList.add(teaM.getCost());
			customerOrder.add(tMd);
		});
		teaLB.setOnAction(event -> {
			index.add(7);
			productList.add("Tea(L)");
			priceList.add(teaL.getCost());
			customerOrder.add(tLg);
		});
		lemonadeSB.setOnAction(event -> {
			index.add(8);
			productList.add("Lemonade(S)");
			priceList.add(lemonadeS.getCost());
			customerOrder.add(lmnS);
		});
		lemonadeMB.setOnAction(event -> {
			index.add(9);
			productList.add("Lemonade(M)");
			priceList.add(lemonadeM.getCost());
			customerOrder.add(lmnM);
		});
		lemonadeLB.setOnAction(event -> {
			index.add(10);
			productList.add("Lemonade(L)");
			priceList.add(lemonadeL.getCost());
			customerOrder.add(lmnL);
		});			
		pieBlueberryB.setOnAction(event -> {
			index.add(11);
			productList.add("Blueberry Pie");
			priceList.add(pieBlueberry.getCost());
			customerOrder.add(bbPie);
		});
		iceCreamB.setOnAction(event -> {
			index.add(12);
			productList.add("Ice Cream");
			priceList.add(iceCream.getCost());
			customerOrder.add(iceC);
		});
		tapiocaB.setOnAction(event -> {
			index.add(13);
			productList.add("Tapioca");
			priceList.add(tapioca.getCost());
			customerOrder.add(tapPud);
		});
	}

	// The remove Items button functions
	public void remove_BTN() {
		burgerB.setOnAction(event -> {
			index.remove(0);
			customerOrder.remove(brgr);
		});
		hotDogB.setOnAction(event -> {
			index.remove(1);
			customerOrder.remove(htDg);
		});
		cokeSB.setOnAction(event -> {
			index.remove(2);
			customerOrder.remove(ckSm);
		});				
		cokeMB.setOnAction(event -> {
			index.remove(3);
		    customerOrder.remove(ckMd);
		});
			cokeLB.setOnAction(event -> {
			index.remove(4);
			customerOrder.remove(ckLg);
		});				
		teaSB.setOnAction(event -> {
			index.remove(5);
			customerOrder.remove(tSm);
		});				
		teaMB.setOnAction(event -> {
			index.remove(6);
			customerOrder.remove(tMd);
		});
		teaLB.setOnAction(event -> {
			index.remove(7);
			customerOrder.remove(tLg);
		});				
		lemonadeSB.setOnAction(event -> {
			index.remove(8);
			customerOrder.remove(lmnS);
		});			
		lemonadeMB.setOnAction(event -> {
			index.remove(9);
			customerOrder.remove(lmnM);
		});
		lemonadeLB.setOnAction(event -> {
			index.remove(10);
			customerOrder.remove(lmnL);
		});
		pieBlueberryB.setOnAction(event -> {
			index.remove(11);
			customerOrder.remove(bbPie);
		});
		iceCreamB.setOnAction(event -> {
			index.remove(12);
			customerOrder.remove(iceC);
		});
		tapiocaB.setOnAction(event -> {
			index.remove(13);
			customerOrder.remove(tapPud);
		});
	}

	public static Sales createSale(ArrayList<Integer> index, ArrayList<Product> products, String payment) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		double subtotal = 0;
		double tax = 0;
		double total = 0;
		int foodSold = 0;
		int drinkSold = 0;
		int snackSold = 0;

		for (int i = 0; i < index.size(); i++) {
			subtotal += products.get(index.get(i)).getCost();
			if (index.get(i) == 0 || index.get(i) == 1) {
				foodSold += 1;
			} else if (index.get(i) >= 2 && index.get(i) <= 10) {
				drinkSold += 1;
			} else if (index.get(i) >= 11 && index.get(i) <= 13) {
				snackSold += 1;
			}
		}

		tax = (subtotal * 0.065);
		double roundedTax = Math.round(tax * 100.0) / 100.0;
		total = (subtotal + roundedTax);

		Sales sale = new Sales(dateFormat.format(date), subtotal, roundedTax, total, payment, foodSold, drinkSold,
				snackSold);
		return sale;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
