
package Controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorValidarInputs {
  public void validarsololetras(JTextField campo){
      campo.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e){
          char c= e.getKeyChar();
          if (Character.isDigit(c)){
          e.consume();
          }
          
          }
      });
  }  
  
  public void validarsolonumeros(JTextField campo){
      campo.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e){
          char c= e.getKeyChar();
          if (!Character.isDigit(c)){
          e.consume();
          }
          
          }
      });
  }
  
  public boolean validaremail(JTextField campo){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(campo.getText());
        return matcher.matches();
  }
  
      
   public void limitarcaraceteres(JTextField campo,int cantidad){
      campo.addKeyListener(new KeyAdapter() {
          public void keyTyped(KeyEvent e){
          char c= e.getKeyChar();
          int tam=campo.getText().length();
          if (tam>=cantidad){
          e.consume();
          }
          
          }
      });
   }
}