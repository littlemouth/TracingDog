package dfst.com.tracingdog.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Random;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.widget.HeadView;

/**
 * Created by yanfei on 2016-11-22.
 */
public class RecordAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> data;
    private Bitmap bitmap;
    private Random random = new Random();

    public RecordAdapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.head);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_record_list, null);
            holder = new ViewHolder();
            holder.headView = (HeadView) convertView.findViewById(R.id.record_listview_item_headview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bitmap[] bitmaps = new Bitmap[random.nextInt(9) + 1];
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i] = bitmap;
        }
        holder.headView.refresh(bitmaps);
        return convertView;
    }

    private class ViewHolder {
        HeadView headView;
    }
}
