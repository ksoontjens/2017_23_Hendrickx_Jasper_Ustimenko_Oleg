package hellotvxlet;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HContainer;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;



public class HelloTVXlet implements Xlet, HActionListener, HBackgroundImageListener, ResourceClient
// , UserEventListener

{
  HStaticText label2 ;
HScene scene;


HStaticText feedback;
String vraag[]={"Waar is Jasper Hendrickx geboren?", "Hoe groot is Jasper?", "Hoeveel broers of zussen heeft Jasper", "Waar is Oleg Ustimenko geboren?", "Hoe groot is Oleg?", "Hoeveel broers of zussen heeft Oleg" };
String ant[][]={{"St.-Job","Edegem","Sumy","Kiev"},{"1m83","2m","1m93","1m87"},{"0","1","2","onbekend"}, {"St.-Job","Edegem","Sumy","Kiev"},{"1m83","2m","1m93","1m87"},{"0","1","2","onbekend"} };
int corr_ant[]={2,4,3,3,1,1};
public UserEventRepository rep =new UserEventRepository("remove shit");
public EventManager manager=EventManager.getInstance();
public Timer t = new Timer();
public int i = 0;
int hvraag=0; // huidige vraag
int toestand=State.WACHTOPANT;
public TimerTask task = new TimerTask() {
public void run(){
    System.out.println("huidige toestand="+toestand+" i="+i);
    int vtoestand=toestand;
if (toestand==State.WACHTOPANT) //feedback tijd starten
{
    i=0;
    //vtoestand=State.FEEDBACKTIMERGESTART;
}
    if (toestand==State.FEEDBACKTIMERGESTART)
        if( i>=3)
    {
       
        feedback.setVisible(false);
        scene.repaint();
        hvraag++;
        System.out.println("hvraag="+hvraag);
        
        if (hvraag >=5) {
            scene.repaint();
            
            feedback.setTextContent("uw score is"+ score, HVisible.NORMAL_STATE);
            feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
            feedback.setBackground(Color.GREEN);
            scene.popToFront(feedback);

        }
        else {
        update_buttons();
        
        vtoestand=State.WACHTOPANT;
        }
    }
        else i++;

toestand=vtoestand;

}
};
HContainer cnt;
HStillImageBackgroundConfiguration hsbdc;


HTextButton antw11 = new HTextButton(ant[hvraag][0], 30,300,200,100);
HTextButton antw12 = new HTextButton(ant[hvraag][1], 230,300,200,100); //1tru
HTextButton antw13 = new HTextButton(ant[hvraag][2], 30,400,200,100); //2tru
HTextButton antw14 = new HTextButton(ant[hvraag][3], 230,400,200,100);


public int score = 0;
public String scoreString = "" + score;

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
public void update_buttons()
{
    System.out.println("updating buttons... hvraag="+hvraag);
    label2.setTextContent(vraag[hvraag], HVisible.NORMAL_STATE);
     antw11.setTextContent(ant[hvraag][0], HVisible.NORMAL_STATE);
antw12.setTextContent(ant[hvraag][1], HVisible.NORMAL_STATE);
     antw13.setTextContent(ant[hvraag][2], HVisible.NORMAL_STATE);
antw14.setTextContent(ant[hvraag][3], HVisible.NORMAL_STATE);
scene.repaint();
}

public void initXlet(XletContext context) {
        try {

            HScreen hs = HScreen.getDefaultHScreen();
            HBackgroundDevice hbgd = hs.getDefaultHBackgroundDevice();

            hbgd.reserveDevice(this);

            HBackgroundConfigTemplate hbgdct = new HBackgroundConfigTemplate();
            hbgdct.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);


            hsbdc = (HStillImageBackgroundConfiguration) hbgd.getBestConfiguration(hbgdct);

            try {

                hbgd.setBackgroundConfiguration(hsbdc);

                //pizza uitpakken in die plek u kno
            }

            catch (Exception ex) {

                ex.printStackTrace();
            }

            HBackgroundImage img = new HBackgroundImage("bromans.jpg");
            img.load(this);
            hsbdc.displayImage(img);
            cnt = new HContainer(0, 0, 500, 500);

            scene = HSceneFactory.getInstance().getDefaultHScene();

            scene.add(cnt);
// rep.addAllArrowKeys();
// manager.addUserEventListener(this, rep);
            feedback = new HStaticText("feedback", 150, 200, 400, 50);
            feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
            feedback.setVisible(false);
            t.scheduleAtFixedRate(task, 1000, 1000);
            HStaticText label1 = new HStaticText("Kies een categorie", 30, 30, 400, 100);
            label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
            label1.setBackground(Color.LIGHT_GRAY);
            HTextButton button1 = new HTextButton("Jasper", 30, 300, 200, 100);
            HTextButton button2 = new HTextButton("Oleg", 230, 300, 200, 100);

            button1.setFocusTraversal(null, null, null, button2);
            button2.setFocusTraversal(null, null, button1, null);
            button1.setActionCommand("button1");
            button2.setActionCommand("button2");
            button1.addHActionListener(this);
            button2.addHActionListener(this);

            label2 = new HStaticText(vraag[hvraag], 30, 30, 400, 100);
            label2.setBackgroundMode(HVisible.BACKGROUND_FILL);
            label2.setBackground(Color.LIGHT_GRAY);


            antw11.setFocusTraversal(null, antw13, null, antw12);
            antw12.setFocusTraversal(null, antw14, antw11, null);
            antw13.setFocusTraversal(antw11, null, null, antw14);
            antw14.setFocusTraversal(antw12, null, antw13, null);



            antw11.setActionCommand("antw11");
            antw12.setActionCommand("antw12");
            antw13.setActionCommand("antw13");
            antw14.setActionCommand("antw14");

            antw11.addHActionListener(this);
            antw12.addHActionListener(this);
            antw13.addHActionListener(this);
            antw14.addHActionListener(this);


            cnt.add(label2);
            cnt.add(antw11);
            cnt.add(antw12);
            cnt.add(antw13);
            cnt.add(antw14);

            antw11.requestFocus();

            scene.add(feedback);
            scene.validate();
            button1.requestFocus();

            scene.setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (HPermissionDeniedException ex) {
            ex.printStackTrace();
        } catch (HConfigurationException ex) {
            ex.printStackTrace();
        }
  
}



public void startXlet() {



}






public void pauseXlet() {
  
}

public void destroyXlet(boolean unconditional) {
 
}

public void actionPerformed(ActionEvent arg0) {
    System.out.println(arg0.getActionCommand());
      
if (toestand!=State.WACHTOPANT) return; // doe niks dan
    
    feedback.setVisible(true);
        scene.repaint();
toestand=State.FEEDBACKTIMERGESTART;
        //cnt2.validate();

        System.out.println(arg0.getActionCommand());
        
        String corrstr="antw1"+String.valueOf(corr_ant[hvraag]);
        System.out.println("corrstr="+corrstr);
        if (arg0.getActionCommand().equals(corrstr))  //jasper
            {
        //hstatictext toevoegen met goed + toevoegen aan scene + scene repaint
        //scene.removeAll();
        
        score +=10;
        
        System.out.println(score);
        

        feedback.setTextContent("Juist! score:" + score, HVisible.NORMAL_STATE);
        feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
        feedback.setBackground(Color.GREEN);

        scene.popToFront(feedback);
        
      
           // scene.removeAll();
            scene.repaint();
    }
        else

                   {
        //hstatictext toevoegen met goed + toevoegen aan scene + scene repaint
        //scene.removeAll();
        
        score -=10;
        
        System.out.println(score);
        

        feedback.setTextContent("Fout! score:" + score, HVisible.NORMAL_STATE);
        feedback.setBackgroundMode(HVisible.BACKGROUND_FILL);
        feedback.setBackground(Color.RED);

        scene.popToFront(feedback);
        
      
           // scene.removeAll();
            scene.repaint();
    }
}

    public void imageLoaded(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}









