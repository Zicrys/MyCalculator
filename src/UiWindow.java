import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UiWindow extends JFrame {
    JTextField field1,field2;
    JButton add,sub,mul,div,eq;//'+','-','*','/','='
    JLabel res,prev;//result,previous actions
    JLabel infoTestLabel;//лейбл для тестов
    JRadioButton programmer, classic;
    JComboBox<String> theme;
    ButtonGroup groupRadioButtons = new ButtonGroup();//для добавления рк в группу


    UiWindow(){
        setTitle("MyCalculator");
        setBounds(200,200,400,450);
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
        container.add(field1 = new JTextField(25));
        container.add(field2 = new JTextField(25));
        container.add(res = createLabel());

        container.add(programmer=new JRadioButton("programmer"));
        container.add(classic=new JRadioButton("classic"));
        container.add(infoTestLabel = new JLabel(""));
        groupRadioButtons.add(programmer);//добавить в группу, чтобы можно было выбрать только одну рк
        groupRadioButtons.add(classic);

        container.add(theme = new JComboBox<String>(new String[]{"dark","light"}));

        //Слушатель выбора элемента
        programmer.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                JRadioButton item = (JRadioButton) e.getItem();
                if(item.isSelected()){
                    infoTestLabel.setText(item.getText());
                }
            }
        });

        classic.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                JRadioButton item = (JRadioButton) e.getItem();
                if(item.isSelected()){
                    infoTestLabel.setText(item.getText());
                }
            }
        });

        container.add(add = createButton("+"));

        //Слушатель событий нажатия
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
