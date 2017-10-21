package haruurara.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class TimeRegisterActivity extends AppCompatActivity {

    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_register);

        globals = (Globals)this.getApplication();

        Button TimeRegister_ok_button = (Button)findViewById(R.id.TimeRegister_ok_button);
        TimeRegister_ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("haruurara.android", "haruurara.android.RoundStartActivity");
                startActivity(intent);
                TimeRegisterActivity.this.finish();
            }
        });

        Button TimeRegister_back_button = (Button)findViewById(R.id.TimeRegister_back_button);
        TimeRegister_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("haruurara.android", "haruurara.android.UserResisterActivity");
                startActivity(intent);
                TimeRegisterActivity.this.finish();
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.time_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner)parent;
                String item = (String) spinner.getSelectedItem();
                globals.time = Integer.parseInt(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
