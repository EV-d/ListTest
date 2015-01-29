package net.ssp.listtest;

/**
 * Created by user on 8/15/14.
 */
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {

    ArrayList<DataList> myList = new ArrayList<DataList>();
    LayoutInflater inflater;
    Context context;


    public MyBaseAdapter(Context context, ArrayList<DataList> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);        // only context can also be used
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public DataList getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.listitem, null);
            mViewHolder = new MyViewHolder();
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        mViewHolder.tvTitle = detail(convertView, R.id.StuffTitle, myList.get(position).getTitle());
        mViewHolder.tvDesc  = detail(convertView, R.id.StuffName,  myList.get(position).getStuffName());
        mViewHolder.tvStatus = detail(convertView, R.id.StuffStatus,  myList.get(position).getStuffStatus());
        mViewHolder.ivIcon  = detail(convertView, R.id.StuffImg,  myList.get(position).getImgResId());

        mViewHolder.ivConnection=detail(convertView, R.id.onlineOroffline,  myList.get(position).isConnection());
        return convertView;
    }

    // or you can try better way
    private TextView detail(View v, int resId, String text) {
        TextView tv = (TextView) v.findViewById(resId);
        tv.setText(text);
        return tv;
    }


    private ImageView detail(View v, int resId, int icon) {
        ImageView iv = (ImageView) v.findViewById(resId);
        iv.setImageResource(icon); //

        return iv;
    }
    private ImageView detail(View v, int resId, boolean connection) {

        ImageView iv = (ImageView) v.findViewById(resId);
       if(connection) {
           iv.setImageResource(R.drawable.online); //
       }
        else
           iv.setImageResource(R.drawable.offline);
        return iv;
    }


    private class MyViewHolder {
        TextView tvTitle, tvDesc,tvStatus;
        ImageView ivIcon,ivConnection;
    }

}
