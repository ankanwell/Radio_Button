//mini radio button project
package ApplicationPack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class SubPanel extends JPanel implements ActionListener //Orange Panel
{
    private JLabel          lblPict;
    private JRadioButton    rbtnJim,rbtnEric,rbtnElvis,rbtnBob,rbtnJimi;
    private ButtonGroup     btngrpMusic;
    private ImageIcon       imgJim,imgEric,imgElvis,imgBob,imgJimi;
    
    private JLabel makeLabel()
    {
        JLabel temp = new JLabel();
        temp.setBounds(240,20,240,180);
        temp.setOpaque(true);
        temp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        super.add(temp);
        return temp;
    }
    private JRadioButton makeRadioButton(String cap,int x,int y,int w,int h)
    {
        JRadioButton temp = new JRadioButton(cap);
        temp.setFont(new Font("Courier New", 1, 18));
        temp.setBounds(x,y,w,h);
        temp.setOpaque(false);
        temp.addActionListener(this);
        btngrpMusic.add(temp);
        super.add(temp);
        return temp;
    }
    private ImageIcon makeImageIcon(String picfile)
    {
        ImageIcon temp = null;
        try
        {
            File imgpath = new File(picfile);
            BufferedImage bimg = ImageIO.read(imgpath);
            Image scaled = bimg.getScaledInstance(240,180,Image.SCALE_SMOOTH);
            temp = new ImageIcon(scaled);
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return temp;
    }
    public SubPanel()
    {
        try
        {
            imgJim   = makeImageIcon("p0.jpg");
            imgEric  = makeImageIcon("p1.jpg");
            imgElvis = makeImageIcon("p2.jpg");
            imgBob   = makeImageIcon("p3.jpg");
            imgJimi  = makeImageIcon("p4.jpg");
            
            lblPict  = makeLabel();
            lblPict.setIcon(imgJim);
            
            btngrpMusic = new ButtonGroup();
            rbtnJim  = makeRadioButton("Jim Morrison",  20, 20,200,30);
            rbtnJim.setSelected(true);
            rbtnEric = makeRadioButton("Eric Clapton",  20, 60,200,30);
            rbtnElvis= makeRadioButton("Elvis Presley", 20,100,200,30);
            rbtnBob  = makeRadioButton("Bob Dylan",     20,140,200,30);
            rbtnJimi = makeRadioButton("Jimi Hendrix",  20,180,200,30);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object ob = e.getSource();
        if(ob==rbtnJim)
            lblPict.setIcon(imgJim);
        else if(ob==rbtnEric)
            lblPict.setIcon(imgEric);
        else if(ob==rbtnElvis)
            lblPict.setIcon(imgElvis);
        else if(ob==rbtnBob)
            lblPict.setIcon(imgBob);
        else if(ob==rbtnJimi)
            lblPict.setIcon(imgJimi);
    }
}
class MainPanel extends JPanel  //Yellow Panel
{
    private JLabel   lblCaption;
    private SubPanel subpanel;
    private JLabel makeLabel(String cap)
    {
        Border brd = BorderFactory.createLineBorder(Color.BLUE, 3);
        JLabel temp = new JLabel(cap);
        temp.setBounds(50,10,500,45);
        temp.setFont(new Font("Verdana", 1, 25));
        temp.setHorizontalAlignment(JLabel.CENTER);
        temp.setOpaque(true);
        temp.setBackground(Color.RED);
        temp.setForeground(Color.WHITE);
        temp.setBorder(brd);
        super.add(temp);
        return temp;
    }
    public MainPanel()
    {
        Border br1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border br2 = BorderFactory.createLineBorder(Color.BLUE, 3);
        Border br3 = BorderFactory.createTitledBorder(br2, "Select a Stalwart", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Georgia", 1, 14));
        Border br4 = BorderFactory.createCompoundBorder(br1, br3);
        
        lblCaption = makeLabel("Identification of Music Maestros");
        subpanel = new SubPanel();
        subpanel.setBackground(Color.ORANGE);
        subpanel.setLayout(new BorderLayout());
        subpanel.setBorder(br4);
        subpanel.setBounds(50,70,500,220);
        super.add(subpanel);
    }
}
class MainFrame extends JFrame
{
    private MainPanel mainpanel;
    public MainFrame()
    {
        mainpanel = new MainPanel();
        mainpanel.setBackground(Color.YELLOW);
        mainpanel.setLayout(new BorderLayout());
        super.add(mainpanel);
    }
}
public class MainClass
{
    public static void main(String[] args)
    {
        JFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,350);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Music Maestro");
        frame.setResizable(false);
    }
}