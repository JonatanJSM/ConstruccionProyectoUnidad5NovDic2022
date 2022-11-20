package Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.stream.Stream;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String photo;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String photo){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String toString(){
        return("ID: " + id + ", FIRST_NAME: " +
                firstName + ", LAST_NAME: " + lastName +
                ", PHOTO: " + photo);
    }

    public boolean isNull(){
        return false;
    }

    public Object[] getEmployeeObjectArray(){
        JLabel jLabel = new JLabel();
        //File file = new File(photo);

        try {
            //BufferedImage bufferedImage = ImageIO.read(file);
            //ImageIcon imageIcon = new ImageIcon(bufferedImage);

            jLabel.setIcon(show(this.photo));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new Object[] {id, firstName, lastName,jLabel};
    }

    public ImageIcon show(String urlLocation) {
        Image image = null;

        try {
            URL url = new URL(urlLocation);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            conn.connect();
            InputStream urlStream = conn.getInputStream();
            image = ImageIO.read(urlStream);
            Image i = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            return new ImageIcon(i);
            //JFrame frame = new JFrame();
            //JLabel lblimage = new JLabel(new ImageIcon(image));
            //frame.getContentPane().add(lblimage, BorderLayout.CENTER);
            //frame.setSize(image.getWidth(null) + 50, image.getHeight(null) + 50);
            //frame.setVisible(true);

        } catch (Exception e) {
            //System.out.println("Something went wrong, sorry:" + e.toString());
            //e.printStackTrace();
            return new ImageIcon("felix.png");
        }
        //return null;
    }


}
