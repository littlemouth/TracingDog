package dfst.com.tracingdog.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import dfst.com.tracingdog.R;

/**
 * Created by yanfei on 2017-4-7.
 */
public class DogLoadingView extends ImageView {
    private AnimationDrawable loadingDrawable;
    public DogLoadingView(Context context) {
        super(context);
        init();
    }

    public DogLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackgroundResource(R.drawable.loading_dog);
        loadingDrawable = (AnimationDrawable) getBackground();
        setVisibility(GONE);
    }

    public void show() {
        if (loadingDrawable != null && !loadingDrawable.isRunning()) {
            loadingDrawable.start();
            setVisibility(VISIBLE);
        }
    }

    public void hide() {
        if (loadingDrawable != null && loadingDrawable.isRunning()) {
            loadingDrawable.stop();
            setVisibility(GONE);
        }
    }
}
