package com.example.a20182.monitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private Application curset = MainActivity.AppList.get(Select.curPosition);
    private String [] data={"Game Level","Video Level","Music Level","Tools Level"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView appName = (TextView)findViewById(R.id.tv_appName);
        appName.setText(curset.getName()+"  Settings");
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                    //Settings.this,android.R.layout.simple_list_item_1, data);
        //ListView listView=(ListView) findViewById(R.id.lv_classify);
        //listView.setAdapter(adapter);
    }

    public void btnConfirm(View view){
        EditText H_Text = findViewById(R.id.et_limit_h);
        EditText M_Text = findViewById(R.id.et_limit_m);
        EditText S_Text = findViewById(R.id.et_limit_s);
        EditText TipsText = findViewById(R.id.et_content);

        int h = (H_Text.getText().toString().equals(""))?0:Integer.parseInt(H_Text.getText().toString());
        int m = (M_Text.getText().toString().equals(""))?0:Integer.parseInt(M_Text.getText().toString());
        int s = (S_Text.getText().toString().equals(""))?0:Integer.parseInt(S_Text.getText().toString());

        int maxtime = Integer.parseInt(H_Text.getText().toString()) * 3600 +
                Integer.parseInt(M_Text.getText().toString()) * 60 +
                Integer.parseInt(S_Text.getText().toString());

        if(m>=60 || s>=60 || maxtime==0)Toast.makeText(getApplicationContext(), "Unapt-Input!", Toast.LENGTH_SHORT).show();
        else {
            MainActivity.AppList.get(Select.curPosition).setSelected(true);
            MainActivity.AppList.get(Select.curPosition).setLimiTime(maxtime);
            MainActivity.AppList.get(Select.curPosition).setTips(TipsText.getText().toString());
            MainActivity.AppList.get(Select.curPosition).setRuntime(0);

            startActivity(new Intent(Settings.this, MainActivity.class));
        }
    }
}
