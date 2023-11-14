import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener
{
     static JFrame jf;
     static JButton add,sub,mul,div,mod,clear,eq;
     static JButton b[]=new JButton[10];
     static JTextField t=new JTextField(10);
     int num1,num2;
     double result;
     String op;
     public static void main(String[]args)
    {
         jf=new JFrame();
         jf.setSize(500,300);
         JPanel p=new JPanel();
         GridLayout g=new GridLayout(4,5);
         p.setSize(400,200);
         p.setLayout(g);
         add=new JButton("+");
         sub=new JButton("-");
         mul=new JButton("*");
         div=new JButton("/");
         mod=new JButton("%");
         eq=new JButton("=");
         clear=new JButton("clr");
         for(int i=0;i<=9;i++)
         {
             b[i]=new JButton(""+i);
         }
         Calculator c=new Calculator();
         add.addActionListener(c);
         sub.addActionListener(c);
         mul.addActionListener(c);
         div.addActionListener(c);
         mod.addActionListener(c);
         eq.addActionListener(c);
         clear.addActionListener(c);
         for(int i=0;i<=9;i++)
         {
             b[i].addActionListener(c);
         }
         p.add(t);
         for(int i=0;i<=9;i++)
         {
             p.add(b[i]);
         }
         p.add(add);
         p.add(sub);
         p.add(mul);
         p.add(div);
         p.add(mod);
         p.add(eq);
         p.add(clear);
         jf.add(p);
         setDefaultLookAndFeelDecorated(true);
         jf.show();
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        char ch=s.charAt(0);
        if(Character.isDigit(ch))
        {
            t.setText(t.getText()+s);
        }
        else
        {
            if(!s.equals("=") && !s.equals("clr"))
            {
                num1=Integer.parseInt(t.getText());
                op=s;
                t.setText("");
            }
            if(s.equals("clr"))
            {
                t.setText("");
            }
            if(s.equals("="))
            {
                num2=Integer.parseInt(t.getText());
                if(op.equals("+"))
                {
                    result=num1+num2;
                }
                else if(op.equals("-"))
                {
                    result=num1-num2;
                }
                else if(op.equals("*"))
                {
                    result=num1*num2;
                }
                else if(op.equals("/"))
                {
                    result=(double)num1/num2;
                }
                else if(op.equals("%"))
                {
                    result=num1%num2;
                }
                t.setText(""+result);
            }
        }
    }
}
