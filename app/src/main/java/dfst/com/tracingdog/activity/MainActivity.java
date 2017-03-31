package dfst.com.tracingdog.activity;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.dfst.core.annotation.AView;
import com.dfst.core.annotation.After;
import com.dfst.core.annotation.Layout;
import com.dfst.core.annotation.Resource;
import com.dfst.ui.widget.PageView;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.fragment.TracingDogsFragment;
import dfst.com.tracingdog.fragment.TracingRecordFragment;
import dfst.com.tracingdog.fragment.TracingSelfFragment;
import dfst.com.tracingdog.fragment.TracingWordFragment;

@Layout(R.layout.activity_main)
public class MainActivity extends BaseFragmentActivity {

    @AView(R.id.main_activity_tabview)
    private PageView pageView;
    @AView(R.id.main_title_label_textview)
    private TextView pageLabelTextView;

    @Resource
    private String page_trace, page_dogs, page_news, page_self;

    @After
    private void init() {
        int[] checkedIcons = {R.mipmap.trace_checked, R.mipmap.dogs_checked, R.mipmap.bone_checked, R.mipmap.self_checked};
        int[] unCheckedIcons = {R.mipmap.trace_unchecked, R.mipmap.dogs_unchecked, R.mipmap.bone_unchecked, R.mipmap.self_unchecked};
        final String[] labels = {page_trace, page_dogs, page_news, page_self};

        PageView.Options options = new PageView.Options();
        options.pages = new Fragment[]{new TracingRecordFragment(), new TracingDogsFragment(), new TracingWordFragment(), new TracingSelfFragment()};
        options.checkedIcons = checkedIcons;
        options.unCheckedIcons = unCheckedIcons;
        options.labels = labels;
        options.checkedLabelColor = ContextCompat.getColor(this, R.color.common_bg_green);
        options.unCheckedLabelColor = ContextCompat.getColor(this, R.color.unchecked_gray);
        options.defaultPosition = 0;
        pageView.init(options);

        pageView.setTabDeviderHeight(0.5f);
        pageView.setTabBackgroundColor(ContextCompat.getColor(this, R.color.gray_f5f5f5));

        pageView.setOnSelectChangedListener(new PageView.OnSelectChangedListener() {
            @Override
            public void onSelectedChanged(int position) {
                pageLabelTextView.setText(labels[position]);
            }
        });

        pageLabelTextView = (TextView) findViewById(R.id.main_title_label_textview);
        pageLabelTextView.setText(labels[0]);
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageView = (PageView) findViewById(R.id.main_activity_tabview);
        int[] checkedIcons = {R.mipmap.home_checked, R.mipmap.recents_checked, R.mipmap.keypad_checked, R.mipmap.self_checked};
        int[] unCheckedIcons = {R.mipmap.home_unchecked, R.mipmap.recents_unchecked, R.mipmap.keypad_unchecked, R.mipmap.self_unchecked};
        final String[] labels = {"追踪", "追友", "圈子", "我的"};

        PageView.Options options = new PageView.Options();
        options.pages = new Fragment[]{new TracingRecordFragment(), new TracingDogsFragment(), new TracingWordFragment(), new TracingSelfFragment()};
        options.checkedIcons = checkedIcons;
        options.unCheckedIcons = unCheckedIcons;
        options.labels = labels;
        options.checkedLabelColor = ContextCompat.getColor(this, R.color.common_bg_green);
        options.unCheckedLabelColor = Color.GRAY;
        options.defaultPosition = 0;
        pageView.init(options);

        pageView.setTabDeviderHeight(0.5f);
        pageView.setTabBackgroundColor(ContextCompat.getColor(this, R.color.gray_f5f5f5));

        pageView.setOnSelectChangedListener(new PageView.OnSelectChangedListener() {
            @Override
            public void onSelectedChanged(int position) {
                pageLabelTextView.setText(labels[position]);
            }
        });

        pageLabelTextView = (TextView) findViewById(R.id.main_title_label_textview);
        pageLabelTextView.setText(labels[0]);
    }*/
}
