import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
public class Temp_Converter extends JFrame implements ItemListener
{
    static TextField tf1=new TextField(10);
    static TextField tf2=new TextField(10);
    static JComboBox c1,c2;
   static String s[]={"Celsius","Fahrenhiet","Kelvin"};
    double result;
  public static void main(String[]args)
  {
      JFrame jf=new JFrame();
       jf.setSize(600,400);
      JPanel p=new JPanel();
    Temp_Converter t=new Temp_Converter();
    c1=new JComboBox(s);
    c2=new JComboBox(s);
    c1.addItemListener(t);
    c2.addItemListener(t);
    p.add(tf1);
    p.add(c1);
    p.add(tf2);
    p.add(c2);
    jf.add(p);
    jf.show();
  }
  public void itemStateChanged(ItemEvent ie)
  {
      double x;
      String s1,s2;
      s1=(String)c1.getSelectedItem();
      s2=(String)c2.getSelectedItem();
      if(s1==s2)
      {
          tf2.setText(tf1.getText());
      }
      else if(s1=="Celsius")
      {
          if(s2=="Fahrenhiet")
          {
              x=Double.parseDouble(tf1.getText());
              result=(double)x*(double)9.0/5.0+32;
              tf2.setText(""+result);
          }
          if(s2=="Kelvin")
          {
              x=Double.parseDouble(tf1.getText());
              result=(double)x+273.15;
              tf2.setText(""+result);
          }
      }
      else if(s1=="Fahrenhiet")
      {
          if(s2=="Celsius")
          {
              x=Double.parseDouble(tf1.getText());
              result=(double)(x-32)*5.0/9.0;
              tf2.setText(""+result);
          }
          if(s2=="Kelvin")
          {
              x=Double.parseDouble(tf1.getText());
              result=(double)(x-32)*5.0/9.0+273.15;
              tf2.setText(""+result);
          }
      }
      else if(s1=="Kelvin")   
      {
          if(s2=="Celsius")
      {
       x=Double.parseDouble(tf1.getText());
       result=(double)x-273.15;
       tf2.setText(""+result);
      }
         if(s2=="Fahrenhiet")
         {
             x=Double.parseDouble(tf1.getText());
             result=((double)x-273.15)*(double)9.0/5.0+32;
             tf2.setText(""+result);
         }
      }
      else
      {
          tf2.setText("");
      }
  }
}