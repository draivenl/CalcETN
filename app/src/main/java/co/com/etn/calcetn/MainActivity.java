package co.com.etn.calcetn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.edtNumber1);
        number2 = (EditText) findViewById(R.id.edtNumber2);

    }

    public void sum(View view){
        int total = getIntEdtValue(number1) + getIntEdtValue(number2);
        showResult(total, "str_result_sum");
    }
    public void subtract(View view){
        int total = getIntEdtValue(number1) - getIntEdtValue(number2);
        showResult(total, "str_result_subtract");
    }
    public void multiply(View view){
        int total = getIntEdtValue(number1) * getIntEdtValue(number2);
        showResult(total, "str_result_multiply");
    }
    public void divide(View view){
        try {
            int total = getIntEdtValue(number1) / getIntEdtValue(number2);
            showResult(total, "str_result_divide");
        } catch (Exception e) {
            showError(getResources().getString(R.string.str_error_divide));
        }
    }

    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    private void showResult(int result, String str_result_sum){
        int id = getResources().getIdentifier(str_result_sum, "string", getPackageName());

        Toast.makeText(this, getString(id) + ": " + result, Toast.LENGTH_SHORT).show();
    }

    private int getIntEdtValue(EditText edt){
        return Integer.valueOf(edt.getText().toString());
    }



}
