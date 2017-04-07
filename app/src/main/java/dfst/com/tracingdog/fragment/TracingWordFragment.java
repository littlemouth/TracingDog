package dfst.com.tracingdog.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dfst.core.annotation.AView;
import com.dfst.core.base.InjectCore;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.widget.DogLoadingView;

/**
 * Created by yanfei on 2016-10-25.
 */
public class TracingWordFragment extends TabFragment {
    @AView
    private DogLoadingView loading;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tracing_world, null);
        InjectCore.inject(this, root);
        // 得到一个动画图片
        AnimationDrawable background = (AnimationDrawable) loading
                .getBackground();
        // 开始播放
        background.start();
        return root;
    }
}
