package dfst.com.tracingdog.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.adapter.RecordAdapter;

/**
 * Created by yanfei on 2016-10-25.
 */
public class TracingRecordFragment extends TabFragment {
    private ListView listView;
    private RecordAdapter adapter;
    private ArrayList<String> data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tracing_record, null);
        createData();
        listView = (ListView) root.findViewById(R.id.record_listview);
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

    /*private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }*/
}
