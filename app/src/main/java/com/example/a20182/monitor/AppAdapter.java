package com.example.a20182.monitor;

/**
 * Created by 20182 on 2018/3/30.
 */

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class AppAdapter extends BaseAdapter {
    private List<Application> apps;
    private LayoutInflater inflater;

    public AppAdapter(Context context, List<Application> infos) {
        this.apps = infos;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return apps.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.monitor_item, null);
<<<<<<< HEAD
            holder.icon = convertView.findViewById(R.id.app_image);
            holder.name = convertView.findViewById(R.id.app_name);
            holder.runtime = convertView.findViewById(R.id.app_time);
            holder.maxtime = convertView.findViewById(R.id.app_maxtime);
||||||| merged common ancestors
            holder.icon = (ImageView) convertView.findViewById(R.id.app_image);
            holder.name = (TextView) convertView.findViewById(R.id.app_name);
            holder.runtime = (TextView) convertView.findViewById(R.id.app_time);
=======
            holder.icon = (ImageView) convertView.findViewById(R.id.app_image);
            holder.name = (TextView) convertView.findViewById(R.id.app_name);
            holder.runtime = (TextView) convertView.findViewById(R.id.app_time);
            holder.maxtime = (TextView) convertView.findViewById(R.id.app_maxtime);
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageDrawable(apps.get(position).getIcon());
        holder.name.setText(apps.get(position).getName());
<<<<<<< HEAD
        holder.runtime.setText("    run:" + toTime(apps.get(position).getRuntime()));
        holder.maxtime.setText("  max:" + toTime(apps.get(position).getLimiTime()));

        Button btn = convertView.findViewById(R.id.btn_del);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < MainActivity.AppList.size(); i++) {
                    if (MainActivity.AppList.get(i).getName().equals(apps.get(position).getName())) {
                        MainActivity.AppList.get(i).setSelected(false);
                        MainActivity.AppList.get(i).setIsRun(false);
                        MainActivity.AppList.get(i).setRuntime(0);
                        MainActivity.AppList.get(i).setLimiTime(0);

                        MainActivity.flags_refresh = true;
                        WindowChangeDetectingService.position = -1;
                    }
                }

            }
        });
||||||| merged common ancestors
        holder.runtime.setText("    runtime:"+String.valueOf(formatter.format(apps.get(position).getRuntime()*1000)));
        //holder.runtime.setBase(SystemClock.elapsedRealtime()-apps.get(position).getRuntime()*1000);
=======
        holder.runtime.setText("    run:" + toTime(apps.get(position).getRuntime()));
        holder.maxtime.setText("  max:" + toTime(apps.get(position).getLimiTime()));

        Button btn=convertView.findViewById(R.id.btn_del);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                for(int i=0;i<MainActivity.AppList.size();i++) {
                    if(MainActivity.AppList.get(i).getName().equals(apps.get(position).getName())){
                        MainActivity.AppList.get(i).setSelected(false);
                        MainActivity.AppList.get(i).setIsRun(false);
                        MainActivity.AppList.get(i).setRuntime(0);
                        MainActivity.AppList.get(i).setLimiTime(0);

                        MainActivity.flags_refresh = true;
                        WindowChangeDetectingService.position = -1;
                    }
                }
            }
        });
>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4

        return convertView;
    }

<<<<<<< HEAD
    private String toTime(int seconds) {

        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = (seconds % 3600) % 60;

        String startDateStr = String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);

        return startDateStr;
    }

||||||| merged common ancestors
=======
    private String toTime(int seconds) {

        int h = seconds/3600;
        int m = (seconds%3600)/60;
        int s = (seconds%3600)%60;

        String startDateStr = String.format("%02d",h)+ ":" + String.format("%02d",m) + ":" + String.format("%02d",s);

        return startDateStr;
    }

>>>>>>> ed7c5d6e212519d079f653b9d91edc549bd514c4
    class ViewHolder {
        ImageView icon;
        TextView name;
        TextView runtime;
        TextView maxtime;
    }
}
