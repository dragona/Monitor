package com.example.a20182.monitor;

import android.graphics.drawable.Drawable;

/**
 * Created by 20182 on 2018/3/30.
 */

public class Application {
    private String name;
    private Drawable icon;
    private long runtime;
    private boolean isSelected;
    //private int freq = 0;


    //无参构造函数
    public Application(){}

    //有参构造函数
    public Application(String name,Drawable icon,long runtime,boolean isSelected){
        this.name=name;
        this.icon=icon;
        this.runtime=runtime;
        this.isSelected=isSelected;
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

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
