import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiWindow extends JFrame {
    JTextField field1,field2;
    JButton add,sub,mul,div,eq;//'+','-','*','/','='
    JLabel res,prev;//result,previous actions

    UiWindow(){
        setTitle("MyCalculator");
        setBounds(200,200,400,450);
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
        container.add(field1 = new JTextField(25));
        container.add(field2 = new JTextField(25));
        container.add(res = createLabel());

        container.add(add = createButton("+"));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==add){
                    res.setText(String.valueOf(Double.parseDouble(field1.getText())+Double.parseDouble(field2.getText())));
                }
            }
        });

        container.add(sub = createButton("-"));
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==sub){
                    res.setText(String.valueOf(Double.parseDouble(field1.getText())-Double.parseDouble(field2.getText())));
                }
            }
        });

        container.add(mul = createButton("*"));
        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==mul){
                    res.setText(String.valueOf(Double.parseDouble(field1.getText())*Double.parseDouble(field2.getText())));
                }
            }
        });

        container.add(div = createButton("/"));
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==div){
                    res.setText(String.valueOf(Double.parseDouble(field1.getText())/Double.parseDouble(field2.getText())));
                }
            }
        });

        container.add(eq = createButton("="));
        eq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==eq) {

                }
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    JButton createButton(String text){
        JButton jbutton = new JButton(text);
        jbutton.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
        return jbutton;
    }

    JLabel createLabel(){
        JLabel jlabel = new JLabel("");
        jlabel.setFont(new Font(Font.MONOSPACED,Font.BOLD,19));
        jlabel.setForeground(new Color(34,177,76));
        return  jlabel;
    }

}
