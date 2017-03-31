package dfst.com.tracingdog.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dfst.core.annotation.AView;
import com.dfst.core.base.InjectCore;

import java.util.ArrayList;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.adapter.RecordAdapter;

/**
 * Created by yanfei on 2016-10-25.
 */
public class TracingRecordFragment extends TabFragment {
    @AView(R.id.record_listview)
    private ListView listView;
    private RecordAdapter adapter;
    private ArrayList<String> data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tracing_record, null);
        InjectCore.inject(this, root);
        createData();
        adapter = new RecordAdapter(data, getContext());
        listView.setAdapter(adapter);
        return root;
    }

    private void createData() {
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("item-" + i);
        }

    }
}
