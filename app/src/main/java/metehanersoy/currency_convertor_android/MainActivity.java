package metehanersoy.currency_convertor_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainActivity extends AppCompatActivity {

    Double TL = 1.0;
    Double GBP = 0.0892;
    Double EUR = 0.1046;

    Double result;
    Double from_value;
    Double to_value;

    EditText amount;
    TextView final_result;
    RadioButton button3;
    RadioButton button2;
    RadioButton button;
    RadioButton button6;
    RadioButton button5;
    RadioButton button4;
    Button convert;

    RadioGroup group_from;
    RadioGroup group_to;

    RadioButton selectedRadioButton_from;
    RadioButton selectedRadioButton_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final_result = findViewById(R.id.textView6);
        amount = findViewById(R.id.editTextTextAmount);
        button3 = findViewById(R.id.radioButton3);
        button2 = findViewById(R.id.radioButton2);
        button = findViewById(R.id.radioButton);
        button6 = findViewById(R.id.radioButton5);
        button5 = findViewById(R.id.radioButton5);
        button4 = findViewById(R.id.radioButton4);
        convert = findViewById(R.id.button);
        group_from = findViewById(R.id.group_from);
        group_to = findViewById(R.id.group_to);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!amount.getText().toString().isEmpty()) {

                    try {
                        result = Double.parseDouble(amount.getText().toString());

                        int selectedRadioButtonId_from = group_from.getCheckedRadioButtonId();
                        int selectedRadioButtonId_to = group_to.getCheckedRadioButtonId();


                        if (selectedRadioButtonId_from != -1) {

                            selectedRadioButton_from = findViewById(selectedRadioButtonId_from);

                            if (selectedRadioButtonId_to != -1) {

                                selectedRadioButton_to = findViewById(selectedRadioButtonId_to);


                                if (selectedRadioButton_from.getText().toString().equals("Turkish (TL)")) {

                                    switch (selectedRadioButton_to.getText().toString()) {

                                        case "Turkish (TL)":
                                            result = result * TL / TL;
                                            break;


                                        case "Pound (GBP)":
                                            result = result * GBP / TL;
                                            break;

                                        case "Euro (EUR)":
                                            result = result * EUR / TL;
                                            break;
                                    }

                                    //Rounding result
                                    BigDecimal bd = new BigDecimal(result);
                                    bd = bd.round(new MathContext(3));
                                    result = bd.doubleValue();

                                    final_result.setText(Double.toString(result));

                                } else if (selectedRadioButton_from.getText().toString().equals("Pound (GBP)")) {

                                    switch (selectedRadioButton_to.getText().toString()) {

                                        case "Turkish (TL)":
                                            result = result * TL / GBP;
                                            break;


                                        case "Pound (GBP)":
                                            result = result * GBP / GBP;
                                            break;

                                        case "Euro (EUR)":
                                            result = result * EUR / GBP;
                                            break;
                                    }

                                    //Rounding result
                                    BigDecimal bd = new BigDecimal(result);
                                    bd = bd.round(new MathContext(3));
                                    result = bd.doubleValue();
                                    final_result.setText(Double.toString(result));
                                }
                                else if (selectedRadioButton_from.getText().toString().equals("Euro (EUR)")) {

                                    switch (selectedRadioButton_to.getText().toString()) {

                                        case "Turkish (TL)":
                                            result = result * TL / EUR;
                                            break;


                                        case "Pound (GBP)":
                                            result = result * GBP / EUR;
                                            break;

                                        case "Euro (EUR)":
                                            result = result * EUR / EUR;
                                            break;
                                    }

                                    //Rounding result
                                    BigDecimal bd = new BigDecimal(result);
                                    bd = bd.round(new MathContext(3));
                                    result = bd.doubleValue();
                                    final_result.setText(Double.toString(result));
                                }


                            } else {
                                Toast.makeText(MainActivity.this, "You must choose currency", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "You must choose currency", Toast.LENGTH_SHORT).show();
                        }


                    } catch (Exception e) {

                        Toast.makeText(MainActivity.this, "You must enter number", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(MainActivity.this, "You must enter number", Toast.LENGTH_SHORT).show();
                }

            }
        });

        group_from.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                final_result.setText("");
            }
        });


        amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final_result.setText("");
            }
        });




    }


}