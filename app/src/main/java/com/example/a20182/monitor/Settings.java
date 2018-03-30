package com.example.a20182.monitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private Application curset = MainActivity.AppList.get(Select.curPosition);
    private String [] data={"Game Level","Video Level","Music Level","Tools Level"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //创建适配器
        TextView appName = (TextView)findViewById(R.id.tv_appName);
        appName.setText(curset.getName()+"  Settings");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                Settings.this,android.R.layout.simple_list_item_1, data);
        ListView listView=(ListView) findViewById(R.id.lv_classify);
        listView.setAdapter(adapter);
    }

    public void btnConfirm(View view){
        MainActivity.AppList.get(Select.curPosition).setSelected(true);
        startActivity(new Intent(Settings.this, MainActivity.class));
    }
}
