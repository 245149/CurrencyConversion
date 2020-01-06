package edu.ib.CurrencyConversion;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Kantor extends Activity {

    Button calculateBtn;
    EditText currencyInputValue;
    Spinner currencySpinner;
    String item;

    public Kantor(Button calculateBtn, EditText currencyInputValue, Spinner currencySpinner, String item) {
        this.calculateBtn = calculateBtn;
        this.currencyInputValue = currencyInputValue;
        this.currencySpinner = currencySpinner;
        this.item = currencySpinner.getSelectedItem().toString();
    }

    public double returnPLN() {

        double convertedValue = 0;

        double currencyValue;
        currencyValue = Double.parseDouble(String.valueOf(currencyInputValue.getText()));

        //SPINNER

        if (item.equals("EUR")){
            convertedValue = (currencyValue*4.23)-returnCommission();
        } else if (item.equals("USD")){
            convertedValue = (currencyValue*3.78)-returnCommission();
        } else if (item.equals("CHF")){
            convertedValue = (currencyValue*3.90)-returnCommission();
        } else if (item.equals("GBP")){
            convertedValue = (currencyValue*4.98)-returnCommission();
        }

        return convertedValue;
    }

    public double returnCommission() {

        double commission = 0;

        double currencyValue;
        currencyValue = Double.parseDouble(String.valueOf(currencyInputValue.getText()));

        if (currencyValue<2e5){
            commission=currencyValue*0.2f;
        } else if (currencyValue>=2e5 && currencyValue<1e6) {
            commission=currencyValue*0.15f;
        } else if (currencyValue>=1e6 && currencyValue<3e6){
            commission=currencyValue*0.1f;
        } else if (currencyValue>=3e6 && currencyValue<10e6){
            commission=currencyValue*0.08f;
        }

        return commission;
    }

}
