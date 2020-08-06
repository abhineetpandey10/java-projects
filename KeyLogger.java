import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.*;
class KeyLogger
{
    public static void main(String[] args)
    {
        JFrame frame=new JFrame("KeyLogger");
        frame.setLayout(new GridLayout(3,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label=new JLabel("Press any key to view its name in the window");
        //Font newFont=new Font("Arial",500,Font.BOLD);
        //label.setFont(newFont);
        frame.add(label,BorderLayout.NORTH);
        final JTextArea t=new JTextArea("Key Name: ");
        t.setEditable(false);
        frame.add(t);
        KeyListener k=new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                String s=KeyEvent.getKeyText(e.getKeyCode());
                t.setText(s);
            }
        };
        t.addKeyListener(k);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}