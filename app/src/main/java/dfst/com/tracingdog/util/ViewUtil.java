package dfst.com.tracingdog.util;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import dfst.com.tracingdog.R;
import dfst.com.tracingdog.widget.LocationView;

/**
 * Created by yanfei on 2017-04-01.
 */
public class ViewUtil {
    public static View getLocationView(Context context, Uri imageUri) {
        View view = View.inflate(context, R.layout.layout_locationview, null);
        LocationView locationView = (LocationView) view.findViewById(R.id.locationView);
        return view;
    }
}
