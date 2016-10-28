package dfst.com.tracingdog.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dfst.com.trackingdog.R;

/**
 * Created by yanfei on 2016-10-25.
 */
public class TracingDogsFragment extends TabFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tracing_dogs, null);
    }
}
