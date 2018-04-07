package com.example.a20182.monitor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ImageView;
||||||| merged common ancestors
import android.widget.AdapterView;
=======
import android.view.accessibility.AccessibilityManager;
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
import android.widget.ListView;
<<<<<<< HEAD
import android.provider.Settings;
||||||| merged common ancestors
=======
import android.widget.Spinner;
import android.provider.Settings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    private ListView mListView;
    private AppAdapter mAdapter;
<<<<<<< HEAD
    public static List<Application> mApps;
||||||| merged common ancestors
    private List<Application> mApps;
=======
    private int[] mToolicon = {R.drawable.add,R.drawable.renew,R.drawable.auto,R.drawable.timer};
    public static List<Application> mApps;
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    public static List<Application> AppList = new ArrayList<Application>();
    public static boolean flags_auto = false;
    public static boolean flags_timer = false;
    public static boolean flags_refresh = false;

<<<<<<< HEAD
    Timer timer0 = new Timer();
    final TimerTask task0 = new TimerTask() {
||||||| merged common ancestors
    Timer timer1=new Timer();
    final TimerTask task1 = new TimerTask() {
=======
    public static List<StoreInfo> pStoreInfo = new ArrayList<StoreInfo>();

    public static boolean flags_refresh = false;

    private Spinner spinner;
    private SpinnerAdapter SpAdapter;


    Timer timer0=new Timer();
    final TimerTask task0 = new TimerTask() {
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mListView.setAdapter(mAdapter);
<<<<<<< HEAD
                    if (flags_refresh) {
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        flags_refresh = false;
                    }
||||||| merged common ancestors
=======
                    if(flags_refresh) {
                        startActivity(new Intent(MainActivity.this, MainActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                        flags_refresh = false;
                    }

                    switch (SpinnerAdapter.flags_position){
                        case 0:
                            startActivity(new Intent(MainActivity.this, Select.class));
                            SpinnerAdapter.flags_position = -1;
                            break;
                        case 1:
                            for(int i=0;i<mApps.size();i++) {
                                mApps.get(i).setRuntime(0);
                                mApps.get(i).setIsRun(false);
                            }
                            mListView.setAdapter(mAdapter);
                            SpinnerAdapter.flags_position = -1;
                            break;
                    }

                    if(!AppList.isEmpty())storageData();
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
                }
            });
        }
    };

<<<<<<< HEAD
    public static boolean isStartAccessibilityService(Context context, String name) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> serviceInfos = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        for (AccessibilityServiceInfo info : serviceInfos) {
            ;
            if (info.getId().contains(name)) {
                return true;
            }
        }
        return false;
    }

||||||| merged common ancestors
=======
    public static boolean isStartAccessibilityService(Context context, String name){
        AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> serviceInfos = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        for (AccessibilityServiceInfo info : serviceInfos)
        {
            if (info.getId().contains(name)) {
                return true;
            }
        } return false;
    }

>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        if (!isStartAccessibilityService(this, "monitor")) {
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
        }

        mListView =  findViewById(R.id.lv_monitor);
        mListView.setOnItemClickListener(this);
        if (AppList.isEmpty()) {
            loadAppInfomation(this);
||||||| merged common ancestors
        mListView = (ListView) findViewById(R.id.lv_monitor);
        mListView.setOnItemClickListener(this);
        if (AppList.isEmpty()) {
            loadAppInfomation(this);
=======
        if(!isStartAccessibilityService(this,"monitor")&&AppList.isEmpty())
        {
             Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
             startActivity(intent);
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
        }

        mListView = findViewById(R.id.lv_monitor);

        if(AppList.isEmpty()) loadAppInfomation(this);

        readData();
        if(!pStoreInfo.isEmpty()) AppList = infoToApp(pStoreInfo);

        mApps = getSelectList(AppList);
        mAdapter = new AppAdapter(this, mApps);
<<<<<<< HEAD
        timer0.schedule(task0, 0, 1000);

||||||| merged common ancestors
        timer1.schedule(task1,0,1000);
=======
        timer0.schedule(task0,0,1000);

        spinner = findViewById(R.id.sp_tool);
        SpAdapter=new SpinnerAdapter(this, mToolicon);
        spinner.setAdapter(SpAdapter);
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    }

    private void loadAppInfomation(Context context) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
        Collections.sort(infos, new ResolveInfo.DisplayNameComparator(pm));
        if (infos != null) {
            AppList.clear();
<<<<<<< HEAD
            for (int i = 0; i < infos.size(); i++) {
                Application app = new Application();
||||||| merged common ancestors
            for(int i=0; i<infos.size(); i++) {
                Application app = new Application();
=======
            for(int i=0; i<infos.size(); i++) {
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
                ResolveInfo info = infos.get(i);
<<<<<<< HEAD
                app.setName(info.loadLabel(pm).toString());
                app.setIcon(info.loadIcon(pm));
                app.setIntent(new ComponentName(info.activityInfo.packageName, info.activityInfo.name));
                app.setRuntime(0);
                app.setSelected(false);
||||||| merged common ancestors
                app.setName(info.loadLabel(pm).toString());
                app.setIcon(info.loadIcon(pm));
                app.setRuntime(0);
                app.setSelected(false);
=======
                Application app = new Application(info.loadLabel(pm).toString(),info.loadIcon(pm),
                        new ComponentName(info.activityInfo.packageName, info.activityInfo.name),
                        false,0,0,"",false);
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
                AppList.add(app);
            }
        }
    }

    private List<Application> getSelectList(List<Application> AppList) {
        List<Application> selectList = new ArrayList<Application>();
        for (int i = 0; i < AppList.size(); i++) {
            if (AppList.get(i).getSelected()) {
                selectList.add(AppList.get(i));
            }
        }
        return selectList;
    }

<<<<<<< HEAD
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    public void btnAdd(View view) {
        startActivity(new Intent(MainActivity.this, Select.class));
    }
||||||| merged common ancestors
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
        timer.schedule(task,0,1000);
=======
    private List<StoreInfo> appToInfo(List<Application> AppList){
        pStoreInfo.clear();
        for(int i=0;i<AppList.size();i++)
        {
            StoreInfo info = new StoreInfo(AppList.get(i).getName(),
                    AppList.get(i).getIsRun(),
                    AppList.get(i).getRuntime(),
                    AppList.get(i).getLimiTime(),
                    AppList.get(i).getTips(),
                    AppList.get(i).getSelected());
            pStoreInfo.add(info);
        }
        return pStoreInfo;
    }

    private List<Application> infoToApp(List<StoreInfo> StoreInfo){
        for(int i=0;i<AppList.size();i++)
        {
            AppList.get(i).setIsRun(StoreInfo.get(i).getIsRun());
            AppList.get(i).setRuntime(StoreInfo.get(i).getRuntime());
            AppList.get(i).setLimiTime(StoreInfo.get(i).getLimiTime());
            AppList.get(i).setTips(StoreInfo.get(i).getTips());
            AppList.get(i).setSelected(StoreInfo.get(i).getSelected());
        }
        return AppList;
    }

    public void storageData(){
        FileOutputStream fos = null;
        pStoreInfo = appToInfo(AppList);
        try {
            fos=openFileOutput("application.txt", Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String jsonstr = gson.toJson(pStoreInfo);
            fos.write(jsonstr.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        FileInputStream fis=null;
        try {
            Gson gson = new Gson();
            fis=openFileInput("application.txt");
            byte[] outByte=new byte[fis.available()];
            fis.read(outByte);
            if(!new String(outByte).equals("[]")&&!new String(outByte).equals("")){
                pStoreInfo = gson.fromJson(new String(outByte), new TypeToken<List<StoreInfo>>(){}.getType());
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4

<<<<<<< HEAD
    public void btnRenew(View view) {
        for (int i = 0; i < mApps.size(); i++) {
            mApps.get(i).setRuntime(0);
            mApps.get(i).setIsRun(false);
        }
        mListView.setAdapter(mAdapter);
||||||| merged common ancestors
=======
    public void btnSpinner(View view){
        spinner.performClick();
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    }

<<<<<<< HEAD
    public void btnAuto(View view) {
        flags_auto = !flags_auto;
        ImageView iv_Auto = findViewById(R.id.iv_auto);
        if (!flags_auto) {
            iv_Auto.setImageResource(R.drawable.auto);
        } else {
            iv_Auto.setImageResource(R.drawable.auto_press);
        }
    }
||||||| merged common ancestors
=======
    @Override
    public void onDestroy(){
        super.onDestroy();

        storageData();
    }
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4

<<<<<<< HEAD
    public void btnTimer(View view) {
        flags_timer = !flags_timer;
        ImageView iv_Auto = findViewById(R.id.iv_timer);
        if (!flags_timer) {
            iv_Auto.setImageResource(R.drawable.timer);
        } else {
            iv_Auto.setImageResource(R.drawable.timer_press);
        }
||||||| merged common ancestors
    public void btnAdd(View view){
        startActivity(new Intent(MainActivity.this, Select.class));
=======
    @Override
    public void finish() {
        super.finish();
        if(isTaskRoot()){
            storageData();
        }
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    }
}

