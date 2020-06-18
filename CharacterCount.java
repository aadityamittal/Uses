import javax.swing.*;  
import java.awt.event.*;  
public class CharacterCount extends JFrame implements ActionListener{  
    JLabel label1,lable2;  
    JTextArea textarea;  
    JButton button;    
    CharacterCount(){  
        super("Charter and Word Counter");  
        label1=new JLabel("");  
        label1.setBounds(50,50,100,20);  
        lable2=new JLabel("");  
        lable2.setBounds(50,70,100,20);  
        textarea=new JTextArea();  
        JScrollPane scrollpane=new JScrollPane(textarea);
        scrollpane.setBounds(50,90,600,500);  
        button=new JButton("Count");  
        button.setBounds(50,620,100,20);  
        button.addActionListener(this);  
        add(label1);
        add(lable2);
        add(scrollpane);
        add(button);
        setSize(800,800);  
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
    }  
    public void actionPerformed(ActionEvent e){  
        if(e.getSource()==button){  
        String character=textarea.getText();  
        label1.setText("Characters:-"+character.length());  
        String words[]=character.split("\\s");  
        lable2.setText("Words:-"+words.length);  
        }
    }  
public static void main(String[] args) {  
    new CharacterCount();  
	}
}  