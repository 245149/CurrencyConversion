package edu.ib.CurrencyConversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button calculateBtn;
    EditText currencyInputValue;
    Spinner currencySpinner;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        currencyInputValue = (EditText) findViewById(R.id.currencyInputValue);

        currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencySpinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        currencySpinner.setAdapter(adapter);


    }

    public void calculateBtnOnClick(View view) {
        TextView currencyOutput = (TextView)findViewById(R.id.outputValueTV);;
        Kantor kantor = new Kantor(calculateBtn, currencyInputValue, currencySpinner, item);
        String ans = String.valueOf(kantor.returnPLN());
        currencyOutput.setText(ans);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
