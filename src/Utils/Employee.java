package Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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
        try {
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
        } catch (Exception e) {
            return new ImageIcon("felix.png");
        }
    }


}
