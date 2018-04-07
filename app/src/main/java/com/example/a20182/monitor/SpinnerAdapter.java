package com.example.a20182.monitor;

import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.ContentValues.TAG;


public class SpinnerAdapter extends BaseAdapter {
    private int[] mList;
    private Context mContext;
    private LayoutInflater inflater;
    public static int flags_position = -1;
    public static boolean flags_auto = false;
    public static boolean flags_timer = false;

    public SpinnerAdapter(Context pContext, int[] pList) {
        this.mContext = pContext;
        this.mList = pList;
        inflater = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
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
            convertView = inflater.inflate(R.layout.spinner_item, null);
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_tool);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageResource(mList[position]);

        final ImageView iv = convertView.findViewById(R.id.iv_tool);
        iv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (position){
                    case 0:
                        flags_position = 0;
                        break;
                    case 1:
                        flags_position = 1;
                        iv.setImageResource(R.drawable.renew_press);
                        break;
                    case 2:
                        flags_auto = !flags_auto;
                        if(!flags_auto) {
                            iv.setImageResource(R.drawable.auto);
                        }else
                        {
                            iv.setImageResource(R.drawable.auto_press);
                        }
                        break;
                    case 3:
                        flags_timer = !flags_timer;
                        if(!flags_timer) {
                            iv.setImageResource(R.drawable.timer);
                        }else
                        {
                            iv.setImageResource(R.drawable.timer_press);
                        }
                        break;
                }
            }
        });
        return convertView;
    }
    class ViewHolder {
        ImageView icon;
    }
}
