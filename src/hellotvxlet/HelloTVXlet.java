package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.havi.ui.HContainer;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {
HScene scene;

HContainer cnt1 = new HContainer(0,0,500,500);
HContainer cnt2 = new HContainer(0,0,500,500);
HContainer cnt3 = new HContainer(0,0,500,500);
HContainer cnt4 = new HContainer(0,0,500,500);
HContainer cnt5 = new HContainer(0,0,500,500);
HContainer cnt6 = new HContainer(0,0,500,500);
HContainer cnt7 = new HContainer(0,0,500,500);
HContainer cnt8 = new HContainer(0,0,500,500);
HContainer cnt9 = new HContainer(0,0,500,500);
HContainer cnt10 = new HContainer(0,0,500,500);
HContainer cnt11 = new HContainer(0,0,500,500);
HContainer cnt12 = new HContainer(0,0,500,500);
HContainer cnt13 = new HContainer(0,0,500,500);

HTextButton antw11 = new HTextButton("St.-Job", 30,300,200,100);
HTextButton antw12 = new HTextButton("Edegem", 230,300,200,100); //1tru
HTextButton antw13 = new HTextButton("Sumy", 30,400,200,100);  //2tru
HTextButton antw14 = new HTextButton("Kiev", 230,400,200,100);

HTextButton antw21 = new HTextButton("1m83", 30,300,200,100);
HTextButton antw22 = new HTextButton("2m", 230,300,200,100);
HTextButton antw23 = new HTextButton("1m93", 30,400,200,100);
HTextButton antw24 = new HTextButton("1m87", 230,400,200,100);  //tru

HTextButton antw31 = new HTextButton("0", 30,300,200,100); //2tru
HTextButton antw32 = new HTextButton("1", 230,300,200,100);
HTextButton antw33 = new HTextButton("2", 30,400,200,100);  //1tru
HTextButton antw34 = new HTextButton("onbekend", 230,400,200,100);

HTextButton antw41 = new HTextButton("inline hockey", 30,300,200,100);  //tru
HTextButton antw42 = new HTextButton("rugby", 230,300,200,100);
HTextButton antw43 = new HTextButton("voetbal", 30,400,200,100);
HTextButton antw44 = new HTextButton("zwerkbal", 230,400,200,100);

public int score = 0;

//jasper:
//
//1waar ben je geboren?
//
//2hoe groot is jasper? 1m87, 1m93, 2m, 1m83
//
//3hoeveel broers of zussen heeft jasper? 2; 1, 0, onbekend
//
//
//oleg:
//
//1waar ben je geboren?
//
//2welke sport heeft oleg gedaan ooit? roller hockey, rugby, voetbal, zwerkbal
//
//3hoeveel broers of zussen heeft oleg? 2; 1, 0, onbekend



    public void initXlet(XletContext context) {
      scene= HSceneFactory.getInstance().getDefaultHScene();
      scene.add(cnt1);
      
      HStaticText label1 = new HStaticText("Kies een categorie", 30,30,400,100);
      label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label1.setBackground(Color.LIGHT_GRAY);
      HTextButton button1 = new HTextButton("Jasper", 30,300,200,100);
      HTextButton button2 = new HTextButton("Oleg", 230,300,200,100);
      
      button1.setFocusTraversal(null, null, null, button2);
      button2.setFocusTraversal(null, null, button1, null);
      button1.setActionCommand("button1");
      button2.setActionCommand("button2");
      button1.addHActionListener(this);
      button2.addHActionListener(this);

      HStaticText label2 = new HStaticText("Waar is Jasper Hendrickx geboren?", 30,30,400,100);
      label2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label2.setBackground(Color.LIGHT_GRAY);
      
      HStaticText label3 = new HStaticText("Hoe groot is Jasper?", 30,30,400,100);
      label3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label3.setBackground(Color.LIGHT_GRAY);
      
      HStaticText label4 = new HStaticText("Hoeveel broers of zussen heeft Jasper?", 30,30,400,100);
      label4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label4.setBackground(Color.LIGHT_GRAY);
      
      HStaticText label5 = new HStaticText("Waar is Oleg Ustimenko geboren?", 30,30,400,100);
      label5.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label5.setBackground(Color.LIGHT_GRAY);
      
      HStaticText label6 = new HStaticText("Welke sport heeft Oleg gespeeld?", 30,30,400,100);
      label6.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label6.setBackground(Color.LIGHT_GRAY);
      
      HStaticText label7 = new HStaticText("Hoeveel broers of zussen heeft Oleg?", 30,30,400,100);
      label7.setBackgroundMode(HVisible.BACKGROUND_FILL);
      label7.setBackground(Color.LIGHT_GRAY);
      

      
      antw11.setFocusTraversal(null, antw13, null,  antw12);
      antw12.setFocusTraversal(null,antw14, antw11, null);
      antw13.setFocusTraversal(antw11, null, null, antw14);
      antw14.setFocusTraversal(antw12, null , antw13, null);
      
      antw11.setActionCommand("antw11");
      antw12.setActionCommand("antw12");
      antw13.setActionCommand("antw13");
      antw14.setActionCommand("antw14");
      
      antw11.addHActionListener(this);
      antw12.addHActionListener(this);
      antw13.addHActionListener(this);
      antw14.addHActionListener(this);
      
      antw21.setFocusTraversal(null, antw23, null,  antw22);
      antw22.setFocusTraversal(null,antw24, antw21, null);
      antw23.setFocusTraversal(antw21, null, null, antw24);
      antw24.setFocusTraversal(antw22, null , antw23, null);
      
      antw21.setActionCommand("antw21");
      antw22.setActionCommand("antw22");
      antw23.setActionCommand("antw23");
      antw24.setActionCommand("antw24");
      
      antw21.addHActionListener(this);
      antw22.addHActionListener(this);
      antw23.addHActionListener(this);
      antw24.addHActionListener(this);
      
      antw31.setFocusTraversal(null, antw33, null,  antw32);
      antw32.setFocusTraversal(null,antw34, antw31, null);
      antw33.setFocusTraversal(antw31, null, null, antw34);
      antw34.setFocusTraversal(antw32, null , antw33, null);
      
      antw31.setActionCommand("antw31");
      antw32.setActionCommand("antw32");
      antw33.setActionCommand("antw33");
      antw34.setActionCommand("antw34");
      
      antw31.addHActionListener(this);
      antw32.addHActionListener(this);
      antw33.addHActionListener(this);
      antw34.addHActionListener(this);
      
      antw41.setFocusTraversal(null, antw43, null,  antw42);
      antw42.setFocusTraversal(null,antw44, antw41, null);
      antw43.setFocusTraversal(antw41, null, null, antw44);
      antw44.setFocusTraversal(antw42, null , antw43, null);
      
      antw41.setActionCommand("antw41");
      antw42.setActionCommand("antw42");
      antw43.setActionCommand("antw43");
      antw44.setActionCommand("antw44");
      
      antw41.addHActionListener(this);
      antw42.addHActionListener(this);
      antw43.addHActionListener(this);
      antw44.addHActionListener(this);
//      
      
      cnt1.add(label1);
      cnt1.add(button1);
      cnt1.add(button2);
      
      cnt2.add(label2);
      cnt2.add(antw11);
      cnt2.add(antw12);
      cnt2.add(antw13);
      cnt2.add(antw14);
      
      cnt3.add(label3);
      cnt3.add(antw21);
      cnt3.add(antw22);
      cnt3.add(antw23);
      cnt3.add(antw24);
      
      cnt4.add(label4);
      cnt4.add(antw31);
      cnt4.add(antw32);
      cnt4.add(antw33);
      cnt4.add(antw34);
      
//     zelfde buttons in een container gaat niet http://stackoverflow.com/questions/4620601/cant-a-swing-component-be-added-to-multiple-containers
//      
//      cnt5.add(label5);
//      cnt5.add(antw11);
//      cnt5.add(antw12);
//      cnt5.add(antw13);
//      cnt5.add(antw14);
//      
      cnt6.add(label6);
      cnt6.add(antw41);
      cnt6.add(antw42);
      cnt6.add(antw43);
      cnt6.add(antw44);
//      
//      cnt7.add(label7);
//      cnt7.add(antw31);
//      cnt7.add(antw32);
//      cnt7.add(antw33);
//      cnt7.add(antw34);
      
      scene.validate();
      button1.requestFocus();
      
      scene.setVisible(true);
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent arg0) {
        System.out.println(arg0.getActionCommand());
       
            //hstatictext toevoegen met goed + toevoegen aan scene + scene repaint
//            HStaticText feedback= new HStaticText ("goed", 150, 200, 400, 50);
//            feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
//            feedback.setBackground(Color.GREEN);
//            scene.add(feedback);
//            scene.popToFront(feedback);
//            scene.repaint();
            
            scene.removeAll();
          
            cnt2.validate();
            scene.add(cnt2);

            scene.repaint();
            antw11.requestFocus();
           
            System.out.println(arg0.getActionCommand());
            if (arg0.getActionCommand().equals("antw12"))  //jasper
                {
            //hstatictext toevoegen met goed + toevoegen aan scene + scene repaint
            //scene.removeAll();
            HStaticText feedback= new HStaticText ("Juist! score +10", 150, 200, 400, 50);
            feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
            feedback.setBackground(Color.GREEN);
            scene.add(feedback);
            scene.popToFront(feedback);
            scene.repaint();
//            
            //dit fucking werkt ni
                }
            
            else {
            //scene.removeAll();
            //hstatictext toevoegen met slecht + toevoegen aan scene + scene repaint
            HStaticText feedback= new HStaticText ("fout! score-5", 150, 200, 400, 50);
            feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
            feedback.setBackground(Color.RED);
            scene.add(feedback);
            scene.popToFront(feedback);
            scene.repaint();
            
            scene.remove(cnt1);
            scene.repaint();
            }

        }
        
       
        
    }
