package dfst.com.trackingdog.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import dfst.com.tracingdog.fragment.TracingDogsFragment;
import dfst.com.tracingdog.fragment.TracingListFragment;
import dfst.com.tracingdog.fragment.TracingSelfFragment;
import dfst.com.tracingdog.fragment.TracingWordFragment;
import dfst.com.trackingdog.R;
import dfst.com.ui.widget.TabView;

public class MainActivity extends FragmentActivity {

    private TabView tabView;
    private TextView pageLabelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabView = (TabView) findViewById(R.id.main_activity_tabview);
        int[] checkedIcons = {R.mipmap.home_checked, R.mipmap.recents_checked, R.mipmap.keypad_checked, R.mipmap.self_checked};
        int[] unCheckedIcons = {R.mipmap.home_unchecked, R.mipmap.recents_unchecked, R.mipmap.keypad_unchecked, R.mipmap.self_unchecked};
        final String[] labels = {"追踪", "追友", "圈子", "我的"};

        TabView.Options options = new TabView.Options();
        options.pages = new Fragment[]{new TracingListFragment(), new TracingDogsFragment(), new TracingWordFragment(), new TracingSelfFragment()};
        options.checkedIcons = checkedIcons;
        options.unCheckedIcons = unCheckedIcons;
        options.labels = labels;
        options.checkedLabelColor = ContextCompat.getColor(this, R.color.common_bg_green);
        options.unCheckedLabelColor = Color.GRAY;
        options.defaultPosition = 0;
        tabView.init(options);

        tabView.setTabDeviderHeight(0.5f);
        tabView.setTabBackgroundColor(ContextCompat.getColor(this, R.color.gray_f5f5f5));

        tabView.setOnSelectChangedListener(new TabView.OnSelectChangedListener() {
            @Override
            public void onSelectedChanged(int position) {
                pageLabelTextView.setText(labels[position]);
            }
        });

        pageLabelTextView = (TextView) findViewById(R.id.main_title_label_textview);
        pageLabelTextView.setText(labels[0]);
    }
}
