import javax.swing.*;
import java.awt.*;
//ky aplikacion ben konvertimin e dollareve ne pjese me te vogla si quarter,dimes,nickels dhe pennies
// rezultatin e shfaq ne kater Bare te cilat jane te vendosura ne nje korniz
public class MakeChange extends JPanel {
    private int quarter, dimes, nickels, pennies;    // kemi caktuar variablat e fushes
    private int y_height;
    private int x, x1;
    private int y, y1;
    private int width; // width cakton gjersin e bareve
    private String emertimi1 = "";
    private String emertimi2 = "";
    private String emertimi3 = "";
    private String emertimi4 = "";
    private Color c1, c2, c3, c4;
    private String Titulli = "";
    private String label = "";
    JFrame a;
    //  MakeChange konstrukton dritaren
    public MakeChange() {
        x1 = 1024;
        y1 = 720;
        width = 50;
        a = new JFrame();
        a.getContentPane().add(this);
        a.setSize(x1, y1);
        a.setVisible(true);

    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0, 0, x1, y1);   //ngjyros nje drejtkendesh me ngjyre te bardh sa eshte madhesia e kornizes
        g.setColor(Color.black);
        g.fillRect(x + 5, y - quarter, width - 5, quarter);   // ngjyros Baret me ngjyre te zeze
        g.fillRect(x + 5 + 55, y - dimes, width - 5, dimes);
        g.fillRect(x + 5 + 110, y - nickels, width - 5, nickels);
        g.fillRect(x + 5 + 165, y - pennies, width - 5, pennies);
        g.setColor(c1);
        g.fillRect(x, y - quarter, width - 5, quarter - 5);   //mbush Baret me ngjyre
        g.setColor(c2);
        g.fillRect(x + 55, y - dimes, width - 5, dimes - 5);
        g.setColor(c3);
        g.fillRect(x + 110, y - nickels, width - 5, nickels - 5);
        g.setColor(c4);
        g.fillRect(x + 165, y - pennies, width - 5, pennies - 5);
        g.setColor(Color.black);
        g.drawRect(x, y - quarter, width - 5, quarter - 5);    // vizaton kornizen e Bar-ev
        g.drawRect(x + 55, y - dimes, width - 5, dimes - 5);
        g.drawRect(x + 110, y - nickels, width - 5, nickels - 5);
        g.drawRect(x + 165, y - pennies, width - 5, pennies - 5);
        g.drawString(emertimi1, x + 5, y + 30);     // emertimi i Bar-ev ne pjesen e poshtme te tyre
        g.drawString(emertimi2, x + 60, y + 30);
        g.drawString(emertimi3, x + 115, y + 30);
        g.drawString(emertimi4, x + 170, y + 30);
        g.drawString("0", x - 10, y - 5);     //  cakton vleren minimale te Bar-ev
        g.drawString(label, x - 20, y - y_height);  // cakton vleren maksimale te Bar-ev
        g.drawLine(x, y - 5, x + (6 * width + 10), y - 5);

    }

    public void setTitle(String title) {   // kjo metode i vendos titullin kornizes duke perdorur variablen e fushes JFrame
        a.setTitle(title);
    }

    public void setAxes(int x_pos, int y_pos, String label, int y_height) {   // inicializon variablat e fushes x,y te cilat i peerdorim tek metoda paintComponent
        x = x_pos;
        y = y_pos;
        this.y_height = y_height;
        this.label = label;
    }

    public void setBar1(String label, int height, Color c) {  //inicializon variablat e fushes si dhe cakton njyren emrin dhe lartesin e barit te pare
        this.emertimi1 = label;
        quarter = height;
        c1 = c;
    }

    public void setBar2(String label, int height, Color c) {  //te njejtin veprim si metoda paraprake
        emertimi2 = label;
        dimes = height;
        c2 = c;
    }

    public void setBar3(String label, int height, Color c) {
        emertimi3 = label;
        nickels = height;
        c3 = c;
    }

    public void setBar4(String label, int height, Color c) {
        emertimi4 = label;
        pennies = height;
        c4 = c;
        this.repaint();
    }

    public static void main(String[] a) {
        MakeChange e = new MakeChange();
        String s = JOptionPane.showInputDialog("Shkruaj sasin e dollareve ");  //me hyrje interaktive marrim vleren e dollareve
        int dollars = new Integer(s);
        String s1 = JOptionPane.showInputDialog("Shkruaj sasin e centeve ");  //me hyrje interaktive marrim vleren e centeve
        int cents = new Integer(s1);
        int money = (dollars * 100) + cents;  //vleren e pergjithshme te parave e kemi kthyer ne cent
        int quarter = money / 25;   //nga variabla money kemi gjet vlerat e imeta te parave
        money = money % 25;
        int dimes = money / 10;
        money = money % 10;
        int nickles = money / 5;
        money = money % 5;
        int pennies = money;
        int max =  Math.max(Math.max(quarter,dimes),Math.max(nickles,pennies));  //vlera maksimale e bareve

        int scale_factor = 10;    // nje koeficient per rritjen e pikseleve per arsye qe baret te jene me te dukshme
        e.setTitle("MakeChange");
        e.setAxes(400, 550, "" + max, max * scale_factor);  //invokimi i metodave perkatese
        e.setBar1("quarter", quarter * scale_factor, Color.red);
        e.setBar2("dimes", dimes * scale_factor, Color.blue);
        e.setBar3("nickels", nickles * scale_factor, Color.orange);
        e.setBar4("pennies", pennies * scale_factor, Color.green);
    }
}

