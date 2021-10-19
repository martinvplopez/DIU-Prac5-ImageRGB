package com.mycompany.practica5diu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LienzoImg extends JPanel {
    private BufferedImage imagen=null;
    private BufferedImage imagen2=null;
    private BufferedImage logo=null;
    private int x,y;
    
    public LienzoImg(){
        try {
            imagen = ImageIO.read(new URL("https://m.media-amazon.com/images/I/71P17wt++yL._AC_UX425_.jpg"));
            logo=ImageIO.read(new File("logo.png"));
            imagen2=imagen;
            x=imagen.getWidth()-logo.getWidth();
            y=0;
        } catch (IOException ex) {
            Logger.getLogger(LienzoImg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(imagen2, 0, 0, null);
        g.drawImage(logo, x, y, null);
    }
    
    public void changeRGB(boolean R,boolean G,boolean B){
        imagen2=UtilsPractica5.seleccionarComponentes(imagen, R, G, B);
    }
    public void posLogo(String pos){
       switch (pos){
            case "Right-Up":
                x=imagen.getWidth()-logo.getWidth();
                y=0;
                break;
            case "Left-Up":
                x=0;
                y=0;
                break;
            case "Left-Down":
                x=0;
                y=imagen.getHeight()-logo.getHeight();
                break;
            case "Right-Down":
                x=imagen.getWidth()-logo.getWidth();
                y=imagen.getHeight()-logo.getHeight();;
                break;
                     
       }
    }
}
