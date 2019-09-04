/* Class: CS1302-03
 * Name: Ethan Nguyen, Joseph Nguyen, Alex Day
 * Project 2
 * Instructor: Monisha Verma
 * 
 */
package Project2;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Persona extends Application
{

	public static void main(String[] args) 
	{
		
		Application.launch(args);
	}
	
	 Image c1;
	 Image c2;
	 boolean pair;
	 Integer counter = 0;
	 int clickCount = 2;
	 ImageView backs = null; 
	 ImageView backs2 = null; 
	//arraylist for storing the face cards and back cards
	ArrayList<ImageView> cards1 = new ArrayList<>();
	ArrayList<ImageView> cards2 = new ArrayList<>();
	ArrayList<ImageView> back = new ArrayList<>();
	ImageView face2 = null;
	ImageView face1 = null;
	int i;
	ImageView id1;
	ImageView id2;
	
	Label num = new Label();
	@Override
	public void start(Stage primaryStage) 
	{
		try {
						
			//panes
			//gp is for cards and is the main view
			GridPane gp = new GridPane();
			//pane is the root pane where every pane is put onto
			BorderPane pane = new BorderPane();
			//gp2 is for the buttons "Quit", and the textfields "Score:", and "scoreNum" [DO NOT ALTER OR TOUCH!!]
			GridPane gp2 = new GridPane();
			
			//create labels
			Label score = new Label("Score: ");  
			score.setPadding(new Insets(5));
			
			num.setPadding(new Insets(15));
			num.setText(counter.toString());
			
			//creates two copies of every card --> assigns an id for each image AND resize the height and width --> add imageviews to ArrayList and shuffle list --> 
			//Set Action for when mouse is clicked on any of the imageviews
			for (int i = 1; i < 9; i++)
			{
				ImageView face1 = new ImageView(new Image("images/" + i + ".jpg"));				
				ImageView face2 = new ImageView();
								
				face2.setImage(face1.getImage());
				face1.setFitHeight(170);
				face1.setFitWidth(80);
				face2.setFitHeight(170);
				face2.setFitWidth(80);
				
				cards1.add(face1);
				cards1.add(face2);
				
				Collections.shuffle(cards1);
				Collections.shuffle(cards2);
				
				backs = new ImageView(new Image("images/Back.png"));
				backs2 = new ImageView(new Image("images/Back.png"));
				backs.setFitHeight(170);
				backs.setFitWidth(80);
				backs2.setFitHeight(170);
				backs2.setFitWidth(80);
				
				//backs.setImage(face1.getImage());
				//backs2.setImage(face1.getImage());
				
				back.add(backs);
				back.add(backs2);
						
			}		
				
			//displays face cards and back cards
			
			for (int i = 0; i < 4; i++)
			{
				
				gp.add(cards1.get(i), i, 0);
				gp.add(cards1.get(i + 4), i, 1);
				gp.add(cards1.get(i+8), i, 2);
				gp.add(cards1.get(i + 12), i, 3);
				
				
				
				gp.add(back.get(i), i, 0);
				gp.add(back.get(i + 4), i, 1);
				gp.add(back.get(i+8), i, 2);
				gp.add(back.get(i + 12), i, 3);
				
				
			}	
			
			
			
				//If click is not 0, will allow user to click 2 cards. if a card is clicked back card is flipped to show face card. 
				//Face card is assigned to card 1 and 2, depending on if whether card 1 or 2 is assigned a value.
				//click count is decresed every time a card is flipped.
				//once two cards is clicked compare() method will compare card 1 and 2.
					if (clickCount != 0)
					{
						back.get(0).setOnMouseClicked(e -> 
						{
							back.get(0).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(0).getImage();
								id1 = back.get(0);
								//System.out.println("c1 = " + c1);
								
							}
							else
							{
								c2 = cards1.get(0).getImage();
								id2 = back.get(0);
								//System.out.println("c2 = " + c2);
								
							}
							clickCount--;
							
							
							//System.out.println("clickCount = " + clickCount);
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
							
						});	
						back.get(1).setOnMouseClicked(e -> 
						{
							back.get(1).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(1).getImage();
								id1 = back.get(1);
								//System.out.println("c1 = " + c1);
								
							}
							else
							{
								c2 = cards1.get(1).getImage();
								id2 = back.get(1);
								//System.out.println("c2 = " + c2);
								
							}
							clickCount--;

							
							//System.out.println("clickCount = " + clickCount);
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});
						back.get(2).setOnMouseClicked(e -> 
						{
							back.get(2).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(2).getImage();
								id1 = back.get(2);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(2).getImage();
								id2 = back.get(2);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;

							
							//System.out.println("clickCount = " + clickCount);
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(3).setOnMouseClicked(e -> 
						{
							back.get(3).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(3).getImage();
								id1 = back.get(3);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(3).getImage();
								id2 = back.get(3);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});
						back.get(4).setOnMouseClicked(e -> 
						{
							back.get(4).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(4).getImage();
								id1 = back.get(4);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(4).getImage();
								id2 = back.get(4);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(5).setOnMouseClicked(e -> 
						{
							back.get(5).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(5).getImage();
								id1 = back.get(5);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(5).getImage();
								id2 = back.get(5);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
						});
						back.get(6).setOnMouseClicked(e -> 
						{
							back.get(6).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(6).getImage();
								id1 = back.get(6);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(6).getImage();
								id2 = back.get(6);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(7).setOnMouseClicked(e -> 
						{
							back.get(7).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(7).getImage();
								id1 = back.get(7);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(7).getImage();
								id2 = back.get(7);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
						});
						back.get(8).setOnMouseClicked(e -> 
						{
							back.get(8).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(8).getImage();
								id1 = back.get(8);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(8).getImage();
								id2 = back.get(8);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(9).setOnMouseClicked(e -> 
						{
							back.get(9).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(9).getImage();
								id1 = back.get(9);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(9).getImage();
								id2 = back.get(9);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
						});
						back.get(10).setOnMouseClicked(e -> 
						{
							back.get(10).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(10).getImage();
								id1 = back.get(10);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(10).getImage();
								id2 = back.get(10);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(11).setOnMouseClicked(e -> 
						{
							back.get(11).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(11).getImage();
								id1 = back.get(11);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(11).getImage();
								id2 = back.get(11);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
						});
						back.get(12).setOnMouseClicked(e -> 
						{
							back.get(12).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(12).getImage();
								id1 = back.get(12);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(12).getImage();
								id2 = back.get(12);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(13).setOnMouseClicked(e -> 
						{
							back.get(13).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(13).getImage();
								id1 = back.get(13);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(13).getImage();
								id2 = back.get(13);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
						});
						back.get(14).setOnMouseClicked(e -> 
						{
							back.get(14).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(14).getImage();
								id1 = back.get(14);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(14).getImage();
								id2 = back.get(14);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
							
						});	
						back.get(15).setOnMouseClicked(e -> 
						{
							back.get(15).toBack();
							if(c1 == null)
							{
								c1 = cards1.get(15).getImage();
								id1 = back.get(15);
								//System.out.println("c1 = " + c1);
							}
							else
							{
								c2 = cards1.get(15).getImage();
								id2 = back.get(15);
								
								//System.out.println("c2 = " + c2);
							}
							clickCount--;
							//System.out.println("clickCount = " + clickCount);

							
							if (clickCount == 0) 
							{
								
								compare(c1, c2);
								
								return;
							}
						});
					}
					else 
					{
						return;
					}
					
		
		//menu and main interface, DO NOT ALTER!! They work fine and should not be touched!
		//hbox
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		Button btQuit = new Button("Quit");
		hBox.getChildren().add(btQuit);	
		btQuit.setOnAction(e -> {primaryStage.close();});
		
		//create borderpane
		pane.setPadding(new Insets(10,10,10,10));
		pane.setCenter(gp);
		pane.setBottom(gp2);
		gp.setAlignment(Pos.CENTER);
		
		//create botton pane (with score and buttons)
		gp2.setAlignment(Pos.CENTER);
		gp2.add(score, 0,0);
		gp2.add(num, 1, 0);
		gp2.add(hBox, 2, 0);
		
		//create a scene and place it in the stage
		Scene scene = new Scene(pane, 600, 800);
		primaryStage.setTitle("Project 2: Card Game"); //stage name
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show(); //Display the stage.
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
			
	}
	//compares card 1 to card 2, then if they match reset value and keep up, else reset all variables and flip cards back
	//if pair 1+ to score
	 public void compare(Image c1, Image c2)
	 {
		 if (c1 != c2)
			{
				System.out.println("Not Pair");
				pair = false;				
				id1.toFront();				
				id1 = null;
				id2.toFront();
				id2 = null;
				this.c1 = null;
				this.c2 = null;
				clickCount = 2;		
				
				
			}
			else
			{
				System.out.println("Pair");
				counter++;
				System.out.println(counter);
				num.setText(counter.toString());
				pair = true;
				id1 = null;
				id2 = null;
				this.c1 = null;
				this.c2 = null;
				clickCount = 2;
			}
	 }
}
