package find_your_bmi;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField age,height,weight,bmi,ideal,health,fat;
    
    @FXML
    private RadioButton male,female;
    
    public void calculator(ActionEvent event){
        
        //Inputs
        String gender = null;
        if (male.isSelected())
            gender = "male";
        else if (female.isSelected())
            gender = "female";
        
        int a = Integer.parseInt(age.getText());
        double w = Double.parseDouble(weight.getText());
        double h = Double.parseDouble(height.getText());
        //end
        
        //BMI
        double result = w / ( h * h );
        
        DecimalFormat df = new DecimalFormat ("#.00");
        
        bmi.setText(String.valueOf(df.format(result)));
        //end
        
        //ideal
        double weightMin = Math.round ((18.5*h)*10.0)/10.0;
        double weightMax = Math.round ((25*h)*10.0)/10.0;
    
        String idealweight = (weightMin+ "  To  " +weightMax);
        
        ideal.setText(idealweight);
        //end
        
        //fat
        double bodyFat;
     
        if(gender.equals("male")){
            bodyFat = Math.round(((1.39*result)+(.16*a)-(10.34*1)-9)*10.0)/10.0;
        }
        else{
            bodyFat =  Math.round(((1.39*result)+(.16*a)-(10.34*0)-9)*10.0)/10.0;
        }
        
        fat.setText(String.valueOf(bodyFat + " % "+ "Body Fat"));
        //end
        
        //health
        String op = new String();
        
        if (result<=16)
            op = "Very Severely Underweight";
        else if (result>16&&result<=17)
            op =("Severely Underweight");
        else if (result>17&&result<=18.5)
            op= ("Underweight");
        else if (result>18.5&&result<=25)
            op = ("Normal");
        else if (result>25&&result<=30)
            op = ("Overweight");
        else if (result>30&&result<=35)
            op = ("Obese Calss I");
        else if (result>35&&result<=40)
           op=("Obese Calss II");
        else if (result>40)
            op = "Obese Calss III";
        
        health.setText(op);
        //end
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
