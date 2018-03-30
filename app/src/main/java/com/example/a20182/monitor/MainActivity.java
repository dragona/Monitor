package com.example.a20182.monitor;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private AppAdapter mAdapter;
    private List<Application> mApps;
    public static List<Application> AppList = new ArrayList<Application>();
/*
    Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            });
        }
    };
*/
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_monitor);
        mListView.setOnItemClickListener(this);
        if(AppList.isEmpty()){loadAppInfomation(this);}
        mApps = getSelectList(AppList);
        mAdapter = new AppAdapter(this, mApps);
        mListView.setAdapter(mAdapter);

        //timer.schedule(task,100,1000);
    }

    private void loadAppInfomation(Context context) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        Collections.sort(infos, new ResolveInfo.DisplayNameComparator(pm));
        if(infos != null) {
            AppList.clear();
            for(int i=0; i<infos.size(); i++) {
                Application app = new Application();
                ResolveInfo info = infos.get(i);
                app.setName(info.loadLabel(pm).toString());
                app.setIcon(info.loadIcon(pm));
                app.setRuntime(0);
                app.setSelected(false);
                AppList.add(app);
            }
        }
    }

    private List<Application> getSelectList(List<Application> AppList) {
        List<Application> selectList = new ArrayList<Application>();
        for(int i=0;i<AppList.size();i++)
        {
            if(AppList.get(i).getSelected())
            {
                selectList.add(AppList.get(i));
            }
        }
        return selectList;
    }

    @Override
    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
        final int Position = position;
        //startActivity(new Intent(MainActivity.this, Settings.class));
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mApps.get(Position).setRuntime(mApps.get(Position).getRuntime()+1);
                    }
                });
            }
        };
        timer.schedule(task,100,1000);

    }

    public void btnAdd(View view){
        startActivity(new Intent(MainActivity.this, Select.class));
    }
}

