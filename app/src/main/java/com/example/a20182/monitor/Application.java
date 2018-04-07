package com.example.a20182.monitor;

import android.content.ComponentName;
import android.graphics.drawable.Drawable;

/**
 * Created by 20182 on 2018/3/30.
 */

public class Application {
    private String name;
    private Drawable icon;
<<<<<<< HEAD
    private ComponentName intent;
    private boolean isRun = false;
    private int runtime;
    private int limitime = 0;
    private String tips = "";
||||||| merged common ancestors
    private long runtime;
=======
    private ComponentName intent;
    private boolean isRun;
    private int runtime;
    private int limitime;
    private String tips;
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    private boolean isSelected;

    //无参构造函数
    public Application() {
    }

    //有参构造函数
<<<<<<< HEAD
    public Application(String name, Drawable icon, ComponentName intent, int runtime, boolean isSelected) {
        this.name = name;
        this.icon = icon;
        this.intent = intent;
        this.runtime = runtime;
        this.isSelected = isSelected;
||||||| merged common ancestors
    public Application(String name,Drawable icon,long runtime,boolean isSelected){
        this.name=name;
        this.icon=icon;
        this.runtime=runtime;
        this.isSelected=isSelected;
=======
    public Application(String name,Drawable icon,ComponentName intent,boolean isRun,
                       int runtime,int limitime,String tips,boolean isSelected){
        this.name = name;
        this.icon = icon;
        this.intent = intent;
        this.isRun = isRun;
        this.runtime = runtime;
        this.limitime = limitime;
        this.tips = tips;
        this.isSelected = isSelected;
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

<<<<<<< HEAD
    public ComponentName getIntent() {
        return intent;
    }

    public void setIntent(ComponentName intent) {
        this.intent = intent;
    }

    public int getLimiTime() {
        return limitime;
    }

    public void setLimiTime(int limitime) {
        this.limitime = limitime;
    }

    public int getRuntime() {
||||||| merged common ancestors
    public long getRuntime() {
=======
    public ComponentName getIntent () {
        return intent;
    }

    public void setIntent (ComponentName intent) {
        this.intent = intent;
    }

    public int getLimiTime() {
        return limitime;
    }

    public void setLimiTime(int limitime) {
        this.limitime = limitime;
    }

    public int getRuntime() {
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean getIsRun() {
        return isRun;
    }

    public void setIsRun(boolean isRun) {
        this.isRun = isRun;
    }
}
