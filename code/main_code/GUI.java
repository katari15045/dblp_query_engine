/*

@author

Mayank Bhoria(2015054)
Saketh Katari(2015045)

*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI
{

	JFrame frame = new JFrame("AP Demo");

	JPanel panelCont = new JPanel();
	JPanel panelFirst = new JPanel();
	JPanel panelSecond = new JPanel();
	JPanel panelThird = new JPanel();
	JPanel panelFourth =new JPanel();

	private JLabel outLabel;


///////////////////////////////////////////////////////////////////////////////////////////////////
	JButton buttonSearch1 = new JButton("Switch to second panel/workspace");
	JButton buttonReset1 = new JButton("Switch to Third panel/workspace");


	JButton buttonSearch2 = new JButton("Switch to second panel/workspace");
	JButton buttonReset2 = new JButton("Switch to Third panel/workspace");


	JButton buttonSearch25 = new JButton("Switch to second panel/workspace");
	JButton buttonReset25 = new JButton("Switch to Third panel/workspace");


///////////////////////////////////////////////////////////////////////////////////////////////
	CardLayout cl = new CardLayout();
	JLabel label1 = new JLabel("DBLP ",JLabel.CENTER);
    JLabel label2 = new JLabel("Query Engine",JLabel.CENTER);
////////////////////////////////////////////////////////////////////////////////////////////////

	String[] choices = new String[] {"Select a Query","Query 1", "Query 2","Query 3","Menu"};
	String[] searchchoices = new String[] {"Select a Choice in your query","Find publications by a given author name", "Find publications by title tags","Menu"};


	JComboBox<String> cList1 = new JComboBox<>(choices);
	JComboBox<String> cList2 = new JComboBox<>(choices);
	JComboBox<String> cList4 = new JComboBox<>(choices);
	JComboBox<String> cList5 = new JComboBox<>(choices);


	JComboBox<String> cList3 = new JComboBox<>(choices);
	JComboBox<String> searchby = new JComboBox<>(searchchoices);
////////////////////////////////////////////////////////////////////////////////////////////////////////


	public GUI() 
	{
		frame.setSize(720 ,480);

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		frame.setUndecorated(true);
///////////////////////////////////////////////////////////////////////////////////////////

		panelCont.setLayout(cl);

///////////	//////////////Panel 1/////////////////////////////////////////////////////////

		panelFirst.setLayout(new GridLayout(7, 7));


		  JLabel headerLabel;
          JLabel statusLabel;
          JLabel controlPanel;

        headerLabel = new JLabel("", JLabel.CENTER); 

        statusLabel = new JLabel("",JLabel.CENTER);  

        controlPanel = new JLabel("",JLabel.CENTER);

      	panelFirst.add(controlPanel);

		panelFirst.add(label1);

        panelFirst.add(label2);

        label1.setFont(new Font("Serif", Font.PLAIN, 130));

        label2.setFont(new Font("Serif", Font.PLAIN, 80));

        panelFirst.setBackground(Color.ORANGE);

        panelFirst.add(headerLabel);

        panelFirst.add(statusLabel);

        /////////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////////////



        panelFirst.add(cList1);

        panelCont.add(panelFirst, "1");
///////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////panel 2///////////////////////////////////////////////////////////////////////////

	            panelSecond.setLayout(new BorderLayout());

  			    JPanel pan1 = new JPanel();

				pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));

				pan1.setBackground(Color.BLACK);

				///////////////////////////////////////////////////////////////////////
				Label space_filler2x= new Label("     ", Label.LEFT);

				 space_filler2x.setBackground(Color.BLACK);

				 pan1.add(space_filler2x);
                //////////////////////////////////////////////////////////////////////



				pan1.add(cList2);

				pan1.add(Box.createRigidArea(new Dimension(5,0)));

				////////////////////////////////////////////////////////////////////

				Label space_filler2y= new Label("     ", Label.LEFT);

				 space_filler2y.setBackground(Color.BLACK);

				 pan1.add(space_filler2y);
				 /////////////////////////////////////////////////////////////////////

				pan1.add(searchby);


				Label  namelabel= new Label("Author Name / Tags   : ", Label.LEFT);

				namelabel.setFont(new Font("Serif", Font.PLAIN, 12));

				namelabel.setForeground(Color.white);


				Label  yearlabel= new Label("Since Year   : ", Label.LEFT);

				yearlabel.setFont(new Font("Serif", Font.PLAIN, 12));

				yearlabel.setForeground(Color.white);



				Label  rangelabel1= new Label("Custom Range : ", Label.LEFT);

				rangelabel1.setFont(new Font("Serif", Font.PLAIN, 12));

				rangelabel1.setForeground(Color.white);


				//Label  rangelabel2= new Label("To year  :  ", Label.LEFT);

				//rangelabel2.setFont(new Font("Serif", Font.PLAIN, 12));

				//rangelabel2.setForeground(Color.white);



				 final TextField userText = new TextField(6);

				 final TextField yearText = new TextField(6);



///////////////////////////////////////////////////////////////////////////////////////////////////

				 JPanel panmini1=new JPanel();

				 panmini1.setLayout(new FlowLayout());

				 panmini1.setBackground(Color.BLACK);



				 final TextField range1Text = new TextField(6);

				 final TextField range2Text = new TextField(6);

				
//////////////////////////////////////////////////////////////////////////////////////////

				 pan1.add(namelabel);

				 pan1.add(userText);


				 ////action listener////////////////////

				 userText.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        System.out.println("Text=" + userText.getText());
			      }
			    });
				 ///////////////////////////////////////////


				 pan1.add(yearlabel);

				 pan1.add(yearText);


				  ////action listener////////////////////

				 yearText.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        System.out.println("Text=" + yearText.getText());
			      }
			    });
				 ///////////////////////////////////////////

				  pan1.add(rangelabel1);

				 panmini1.add(range1Text);
				 panmini1.add(range2Text);

				 pan1.add(panmini1);

				 ///////////////////////////////////////////
				 Label space_filler1= new Label("     ", Label.LEFT);

				 space_filler1.setBackground(Color.ORANGE);

				 pan1.add(space_filler1);

				 ///////////////////////////////////////////

				   ////action listener////////////////////

				 range1Text.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        System.out.println("Text=" + range1Text.getText());
			      }
			    });
				 ///////////////////////////////////////////



				 ////action listener////////////////////////////////////////////////////////////////

				 range2Text.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        System.out.println("Text=" + range2Text.getText());
			      }
			    });
				 ///////////////////////////////////////////////////////////////////////////////////////
				 JButton buttonSearch1 = new JButton("Search");

				 JButton buttonReset1 = new JButton("Reset");

				 //////////////////////////////////////////////////////////////////////////	/////////////

				 buttonSearch1.setSize(50, 50);
				 buttonReset1.setSize(50, 50);


				 JRadioButton r1=new JRadioButton("Sort by Year");  
				 JRadioButton r2=new JRadioButton("Sort by Relevance");  
				 ButtonGroup bg=new ButtonGroup(); 
				 bg.add(r1);bg.add(r2); 


				 /////////////////////////////////////////////////////

				 JPanel panmini_radio= new JPanel();

			//	 panmini_radio.setBackground(Color.BLACK);



				 panmini_radio.add(r1);
				 panmini_radio.add(r2); 

				 pan1.add(panmini_radio);

				 /////////////////////////////////////////////radio listener//////////////////////////////////////////

				


				    ActionListener sliceActionListener = new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				        AbstractButton aButton = (AbstractButton) actionEvent.getSource();
				        System.out.println("Selected: " + aButton.getText());
				      }
				    };




				r1.addActionListener(sliceActionListener);

    			r2.addActionListener(sliceActionListener);



    			//////////////////////////////////////////////////////////////////////////////////////////////////////

    			JPanel panmini1_2 =new JPanel();

    			

    			panmini1_2.setLayout(new FlowLayout());



				 panmini1_2.add(buttonSearch1);
				 panmini1_2.add(buttonReset1);




				 Label space_filler2= new Label("     ", Label.LEFT);

				 space_filler2.setBackground(Color.ORANGE);

				 pan1.add(space_filler2);





				 pan1.add(panmini1_2);
				 ////////////////////////////////////////No of results /////////////////////////////////////////////

					JLabel outdisplay1 =new JLabel();   //Print no of Results
					outdisplay1.setFont(new Font("Serif", Font.PLAIN, 12));
					outdisplay1.setForeground(Color.white);
					outdisplay1.setText("123");
					pan1.add(outdisplay1);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				 JPanel pan2 = new JPanel();

				 pan2.setBackground(Color.WHITE);

				 pan2.setLayout(new BorderLayout());

/////////////////////////( JTable Output  )///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				String data[][]={ {"101","Amit kamar Chouhan Vietnam Gaya and made some funny comments during last day.Hope to see him again in one of our future courses and not in DM as I don't want to fail","670000","1","1","1","1","1"  },   {"102","Jai","780000","1","1","1","1","1"  }, {"101","Sachin","700000","1","1","1","1","1"  }};  


                String column[]={"S.No", "Authors","Title","Pages","Year", "Volume", "Journal","Url"};  

			    JTable jt=new JTable(data,column);  

			    jt.setBounds(60,40,600,500);  
			          
			    JScrollPane sp=new JScrollPane(jt);  

		    	pan2.add(sp);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				JPanel pan3 = new JPanel();

				pan3.setBackground(Color.ORANGE);

				JLabel labela = new JLabel("DBLP ");
    			JLabel labelb = new JLabel("Query Engine");


		        labela.setFont(new Font("Serif", Font.PLAIN, 60));
		        labelb.setFont(new Font("Serif", Font.PLAIN, 20));

		        pan3.add(labela);
		        pan3.add(labelb);

				JPanel pan4 = new JPanel();

				pan4.setBackground(Color.ORANGE);

				pan4.setLayout(new FlowLayout());



//////////////////////(Previous and Next Buttons )//////////////////////////////////////////////////////////////


				JButton jb = new JButton("Previous");

				JButton jbn = new JButton("Next");

				pan4.add(jb);

				pan4.add(jbn);


				//////////////////////////////////( page counter = current page / total no of pages )/////////////////////

				JLabel pgcntr =new JLabel();


				pgcntr.setText("Current Page:"+"current page"+"/"+"Total no of pages");

				pan4.add(pgcntr);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				jb.setSize(50, 50);






				JPanel pan5 = new JPanel();

				pan5.setBackground(Color.BLACK);

				JLabel labelx = new JLabel("                                   ");

				pan5.add(labelx);





			
				panelSecond.add(pan1,BorderLayout.WEST);

				panelSecond.add(pan2,BorderLayout.CENTER);

				panelSecond.add(pan3,BorderLayout.NORTH);

				panelSecond.add(pan4,BorderLayout.SOUTH);

				panelSecond.add(pan5,BorderLayout.EAST);




				panelCont.add(panelSecond, "2");


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////Panel 3//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				panelThird.setLayout(new BorderLayout());

				JPanel panA = new JPanel();

				panA.setLayout(new BoxLayout(panA, BoxLayout.Y_AXIS));

				panA.setBackground(Color.BLACK);

				///////////////////////////////////////////////////////////////

				Label space_fillerA2= new Label("     ", Label.LEFT);

				 space_fillerA2.setBackground(Color.BLACK);

				 panA.add(space_fillerA2);

				////////////////////////////////////////////////////////////////


				panA.add(cList4);

				panA.add(Box.createRigidArea(new Dimension(5,0)));

				//////////////////////////////////////////////////////////////////////

				Label space_fillerA0= new Label("     ", Label.LEFT);

				 space_fillerA0.setBackground(Color.BLACK);

				 panA.add(space_fillerA0);


				////////////////////////////////////////////////////////////////////////

				Label  publabel= new Label("No. Of Publications: ", Label.LEFT);

				publabel.setFont(new Font("Serif", Font.PLAIN, 12));

				publabel.setForeground(Color.white);

				final TextField pubText = new TextField(6);

				panA.add(publabel);
				panA.add(pubText);

				///////////////////////////////////////////////////////////////////////////////////////

				 Label space_fillerA1= new Label("     ", Label.LEFT);

				 space_fillerA1.setBackground(Color.BLACK);

				 panA.add(space_fillerA1);


				///////////////////////////////////////////////////////////////////////////////////////


				 ////////////////////////////////////////No of results /////////////////////////////////////////////

					JLabel outdisplay2 =new JLabel();   //Print no of Results
					outdisplay2.setFont(new Font("Serif", Font.PLAIN, 12));
					outdisplay2.setForeground(Color.white);
					outdisplay2.setText("123");
					panA.add(outdisplay2);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

				  ////action listener////////////////////

				 pubText.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        System.out.println("Text=" + pubText.getText());
			      }
			    });
				 ///////////////////////////////////////////
				
				JPanel panB = new JPanel();


				panB.setBackground(Color.BLACK);

				panB.setLayout(new BorderLayout());



/////////////////////////( JTable Output  )///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				String data1[][]={ {"101","Amit kamar Chouhan Vietnam Gaya","670000","1","1","1","1","1"  },   {"102","Jai","780000","1","1","1","1","1"  }, {"101","Sachin","700000","1","1","1","1","1"  }};  


                String column1[]={"S.No", "Authors","Title","Pages","Year", "Volume", "Journal/Booktitle","Url"};  

			    JTable jt1=new JTable(data,column);  

			    jt1.setBounds(60,40,600,500);  
			          
			    JScrollPane sp1=new JScrollPane(jt1);  

		    	panB.add(sp1);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


				JPanel panC = new JPanel();

				panC.setBackground(Color.ORANGE);


				JLabel labelc = new JLabel("DBLP ");
    			JLabel labeld = new JLabel("Query Engine");


		        labelc.setFont(new Font("Serif", Font.PLAIN, 60));
		        labeld.setFont(new Font("Serif", Font.PLAIN, 20));

				panC.add(labelc);
		        panC.add(labeld);




				JPanel panD = new JPanel();

				panD.setBackground(Color.ORANGE);

				panD.setLayout(new FlowLayout());

//////////////////////(Previous and Next Buttons )//////////////////////////////////////////////////////////////

				JButton jb1 = new JButton("Previous");

				JButton jbn1 = new JButton("Next");

				panD.add(jb1);

				panD.add(jbn1);

//////////////////////////////////( page counter = current page / total no of pages )/////////////////////

				JLabel pgcntr1 =new JLabel();
				

				pgcntr1.setText("Current Page:"+"current page"+"/"+"Total no of pages");

				panD.add(pgcntr1);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////







				JPanel panF = new JPanel();

				panF.setBackground(Color.WHITE);

				panF.setLayout(new BorderLayout());




				JPanel panH = new JPanel();

				panH.setBackground(Color.BLACK);

				panH.setLayout(new BorderLayout());

				JLabel labelx1 = new JLabel("                                   ");

				panH.add(labelx1);





				/////////////////////////////////////////////////////////////

				buttonSearch2 = new JButton("Search");


				buttonReset2 =new JButton("Reset");

		


				/////////////////////////////////////////////////////////////////



				

				JLabel lb = new JLabel("");

				lb.setForeground(Color.BLACK);

				JLabel lb2 = new JLabel("");



				panF.add(lb,BorderLayout.NORTH);

				panF.add(lb2,BorderLayout.EAST);

				panF.setBackground(Color.BLACK);



				buttonSearch2.setSize(50, 50);

//////////////////////////////////////////////////////////////////////////////////////////////

				JPanel panmini2_1 = new JPanel();

				panmini2_1.setLayout(new FlowLayout());

				panmini2_1.add(buttonSearch2);

				panmini2_1.add(buttonReset2);

				panA.add(panmini2_1);
//////////////////////////////////////////////////////////////////////////////////////////////////



				panA.add(panF,BorderLayout.SOUTH);

				buttonSearch2.setSize(50, 50);



			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				panelThird.add(panA,BorderLayout.WEST);

				panelThird.add(panB,BorderLayout.CENTER);

				panelThird.add(panC,BorderLayout.NORTH);

				panelThird.add(panD,BorderLayout.SOUTH);

				panelThird.add(panH,BorderLayout.EAST);

				panelCont.add(panelThird, "3");




/////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////panel 4/////////////////////////////////////

				panelFourth.setLayout(new BorderLayout());

				JPanel panA1 = new JPanel();

				panA1.setLayout(new BoxLayout(panA1, BoxLayout.Y_AXIS));

				panA1.setBackground(Color.BLACK);

////////////////////////////////////////////////////////////////////////////////////

				 Label space_fillerAq= new Label("     ", Label.LEFT);

				 space_fillerAq.setBackground(Color.BLACK);

				 panA1.add(space_fillerAq);
////////////////////////////////////////////////////////////////////////////////////

				panA1.add(cList5);

				panA1.add(Box.createRigidArea(new Dimension(5,0)));



				Label  publabel5= new Label("Year  : ", Label.LEFT);

				publabel5.setFont(new Font("Serif", Font.PLAIN, 12));

				publabel5.setForeground(Color.white);

				final TextField pubText5 = new TextField(6);

				panA1.add(publabel5);
				panA1.add(pubText5);


				  ////action listener////////////////////


				 pubText5.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			        System.out.println("Text=" + pubText5.getText());
			      }
			    });
				 ///////////////////////////////////////////

				 //////////////Enter 5 authors //////////////////////

				 				 


				 				Label  atlabel1= new Label("1st Author:                      ", Label.LEFT);
				 				Label  atlabel2= new Label("2nd Author:", Label.LEFT);
				 				Label  atlabel3= new Label("3rd Author:", Label.LEFT);
				 				Label  atlabel4= new Label("4th Author:", Label.LEFT);
				 				Label  atlabel5= new Label("5th Author:", Label.LEFT);


								atlabel1.setFont(new Font("Serif", Font.PLAIN, 12));
					            atlabel1.setForeground(Color.white);

					            atlabel2.setFont(new Font("Serif", Font.PLAIN, 12));
					            atlabel2.setForeground(Color.white);

					            atlabel3.setFont(new Font("Serif", Font.PLAIN, 12));
					            atlabel3.setForeground(Color.white);

					            atlabel4.setFont(new Font("Serif", Font.PLAIN, 12));
					            atlabel4.setForeground(Color.white);

					            atlabel5.setFont(new Font("Serif", Font.PLAIN, 12));
					            atlabel5.setForeground(Color.white);


								final TextField nText1 = new TextField(6);
								final TextField nText2 = new TextField(6);
								final TextField nText3 = new TextField(6);
								final TextField nText4 = new TextField(6);
								final TextField nText5 = new TextField(6);

				//panA1.add(tlabel);

				panA1.add(atlabel1);//1
				panA1.add(nText1);

				panA1.add(atlabel2);//2
				panA1.add(nText2);

				panA1.add(atlabel3);//3
				panA1.add(nText3);

				panA1.add(atlabel4);//4
				panA1.add(nText4);

				panA1.add(atlabel5);//5
				panA1.add(nText5);


				 ////////////////////////////////////////No of results /////////////////////////////////////////////

					JLabel outdisplay3 =new JLabel();   //Print no of Results
					outdisplay3.setFont(new Font("Serif", Font.PLAIN, 12));
					outdisplay3.setForeground(Color.white);
					outdisplay3.setText("count is " +"123");
					panA1.add(outdisplay3);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////




				
				JPanel panB1 = new JPanel();


				panB1.setBackground(Color.BLACK);

				panB1.setLayout(new BorderLayout());


/////////////////////////( JTable Output  )///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				String data2[][]={ {"101","Amit kamar Chouhan Vietnam Gaya","670000","1","1","1","1","1"  },   {"102","Jai","780000","1","1","1","1","1"  }, {"101","Sachin","700000","1","1","1","1","1"  }};  


                String column2[]={"S.No", "Authors","Title","Pages","Year", "Volume", "Journal/Booktitle","Url"};  

			    JTable jt2=new JTable(data,column);  

			    jt2.setBounds(60,40,600,500);  
			          
			    JScrollPane sp2=new JScrollPane(jt2);  

		    	panB1.add(sp2);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


				JPanel panC1 = new JPanel();

				panC1.setBackground(Color.ORANGE);



				JLabel labelc1 = new JLabel("DBLP ");
    			JLabel labeld1 = new JLabel("Query Engine");


		        labelc1.setFont(new Font("Serif", Font.PLAIN, 60));
		        labeld1.setFont(new Font("Serif", Font.PLAIN, 20));

				panC1.add(labelc1);
		        panC1.add(labeld1);

				JPanel panD1 = new JPanel();

				panD1.setBackground(Color.ORANGE);

				panD1.setLayout(new FlowLayout());

//////////////////////(Previous and Next Buttons )//////////////////////////////////////////////////////////////

				JButton jb2 = new JButton("Previous");

				JButton jbn2 = new JButton("Next");

				panD1.add(jb2);

				panD1.add(jbn2);

				//////////////////////////////////( page counter = current page / total no of pages )/////////////////////

				JLabel pgcntr3 =new JLabel();
				

				pgcntr3.setText("Current Page:"+"current page"+"/"+"Total no of pages");

				panD1.add(pgcntr3);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////



				JPanel panF1 = new JPanel();

				panF1.setBackground(Color.WHITE);

				panF1.setLayout(new BorderLayout());


				JPanel panH1 = new JPanel();

				panH1.setBackground(Color.BLACK);

				panH1.setLayout(new BorderLayout());

				JLabel labelx2 = new JLabel("                                   ");

				panH1.add(labelx2);



				/////////////////////////////////////////////////////////////

				buttonSearch25 = new JButton("Search");


				buttonReset25 =new JButton("Reset");

		


				/////////////////////////////////////////////////////////////////



				

				JLabel lb1 = new JLabel("");

				lb1.setForeground(Color.BLACK);

				JLabel lb21 = new JLabel("");



				panF1.add(lb1,BorderLayout.NORTH);

				panF1.add(lb21,BorderLayout.EAST);

				panF1.setBackground(Color.BLACK);



				buttonSearch25.setSize(50, 50);

///////////////////////////////////////////////////////////////////////////////

				JPanel panmini3 =new JPanel();

				panmini3.setLayout(new FlowLayout() );



				panmini3.add(buttonSearch25);

				panmini3.add(buttonReset25);



				panA1.add(panmini3);
////////////////////////////////////////////////////////////////////////////
				panA1.add(panF1,BorderLayout.SOUTH);

				buttonSearch25.setSize(50, 50);
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				panelFourth.add(panA1,BorderLayout.WEST);

				panelFourth.add(panB1,BorderLayout.CENTER);

				panelFourth.add(panC1,BorderLayout.NORTH);

				panelFourth.add(panD1,BorderLayout.SOUTH);

				panelFourth.add(panH1,BorderLayout.EAST);

				panelCont.add(panelFourth, "4");



///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////( ACTION LISTENERs )//////////////////////////////////////////////////////////// 				
		cl.show(panelCont, "1");

		buttonSearch1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("button search 1 pressed ");


			}
		});
		
		buttonSearch2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {


			System.out.println("button search 2 pressed ");

			}
		});

		buttonReset1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("button reset 1 pressed ");

			}
		});

		buttonReset2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {


			System.out.println("button reset 2 pressed ");


			}
		});

			cl.show(panelCont, "1");

	
		buttonSearch25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {


			System.out.println("button search 2 pressed ");

			}
		});

		

		buttonReset25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {


			System.out.println("button reset 2 pressed ");


			}
		});



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		cList1.addActionListener(new ActionListener() {
           @Override
          public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();

		        String selectedChoice = (String) combo.getSelectedItem();
		 
		        if (selectedChoice.equals("Query 1")) 
		        {
		            cl.show(panelCont, "2");

		        } 
		        else if (selectedChoice.equals("Query 2"))
		        {
		            cl.show(panelCont, "3");
		        }
		         else if (selectedChoice.equals("Menu"))
		        {
		            cl.show(panelCont, "1");
		        }
		         else if(selectedChoice.equals("Query 3"))
		        {
		        	cl.show(panelCont,"4");
		        }



     		 }
  		 });



		cList2.addActionListener(new ActionListener() {
           @Override
          public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();

		        String selectedChoice = (String) combo.getSelectedItem();
		 
		        if (selectedChoice.equals("Query 1")) 
		        {
		            cl.show(panelCont, "2");

		        } 
		        else if (selectedChoice.equals("Query 2"))
		        {
		            cl.show(panelCont, "3");
		        }
		        else if (selectedChoice.equals("Menu"))
		        {
		            cl.show(panelCont, "1");
		        }
		         else if(selectedChoice.equals("Query 3"))
		        {
		        	cl.show(panelCont,"4");
		        }

     		 }
  		 });




		cList3.addActionListener(new ActionListener() {
           @Override
          public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();

		        String selectedChoice = (String) combo.getSelectedItem();
		 
		        if (selectedChoice.equals("Query 1")) 
		        {
		            cl.show(panelCont, "2");

		        } 
		        else if (selectedChoice.equals("Query 2"))
		        {
		            cl.show(panelCont, "3");
		        }
		        else if (selectedChoice.equals("Menu"))
		        {
		            cl.show(panelCont, "1");
		        }
		         else if(selectedChoice.equals("Query 3"))
		        {
		        	cl.show(panelCont,"4");
		        }

     		 }
  		 });




		cList4.addActionListener(new ActionListener() {
           @Override
          public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();

		        String selectedChoice = (String) combo.getSelectedItem();
		 
		        if (selectedChoice.equals("Query 1")) 
		        {
		            cl.show(panelCont, "2");

		        } 
		        else if (selectedChoice.equals("Query 2"))
		        {
		            cl.show(panelCont, "3");
		        }
		        else if (selectedChoice.equals("Menu"))
		        {
		            cl.show(panelCont, "1");
		        }
		         else if(selectedChoice.equals("Query 3"))
		        {
		        	cl.show(panelCont,"4");
		        }

     		 }
  		 });
				cList5.addActionListener(new ActionListener() {
           @Override
          public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();

		        String selectedChoice = (String) combo.getSelectedItem();
		 
		        if (selectedChoice.equals("Query 1")) 
		        {
		            cl.show(panelCont, "2");

		        } 
		        else if (selectedChoice.equals("Query 2"))
		        {
		            cl.show(panelCont, "3");
		        }
		        else if(selectedChoice.equals("Query 3"))
		        {
		        	cl.show(panelCont,"4");
		        }
		        else if (selectedChoice.equals("Menu"))
		        {
		            cl.show(panelCont, "1");
		        }

     		 }
  		 });



////////////////////////panel 2 buttons /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////(JAVA FRAMES)///////////////////////////////////////////////


		frame.add(panelCont);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frame.pack();

		frame.setVisible(true);
		
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});
	}

}
