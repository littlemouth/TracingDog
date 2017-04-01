package dfst.com.tracingdog.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;

import com.dfst.core.util.DensityUtil;

import dfst.com.tracingdog.R;

/**
 * Created by yanfei on 2017-04-01.
 */
public class LocationView extends View {
    private Context context;
    private Paint paint;
    private Bitmap bitmap;
    private int borderColor;
    private int borderWidth;

    public LocationView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public LocationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.default_head);
        borderColor = Color.WHITE;
        borderWidth = DensityUtil.dip2px(context, 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float sqrt32 = (float) Math.sqrt(3) / 2;
        float radius = getHeight() / (1.5f +   sqrt32);
        float centerX = getWidth() / 2f;
        float centerY = radius;
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawCircle(centerX, centerY, radius, paint);

        if (bitmap != null) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            bitmap = compress(bitmap, radius * 2, radius * 2);
            canvas.drawBitmap(bitmap, centerX - radius, 0, paint);
            paint.setXfermode(null);
        }

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(borderWidth);
        paint.setColor(Color.RED);
        canvas.drawCircle(centerX, centerY, radius - borderWidth * 0.5f, paint);

        Path path = new Path();
        path.moveTo(centerX - radius / 2, radius * (1 + sqrt32));
        path.lineTo(centerX, getHeight());
        path.lineTo(centerX + radius / 2, radius * (1 + sqrt32));
        RectF rectF = new RectF(centerX - radius + 1, 1, centerX + radius - 1, radius * 2 - 1);
        path.arcTo(rectF, 60, 60);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);

        canvas.restoreToCount(layerId);
    }

    public void setImageResource(int resId) {
        bitmap = BitmapFactory.decodeResource(getResources(), resId);
        invalidate();
    }

    public void setImageUri(Uri uri) {
    }

    public void setBorderColor(int color) {
        borderColor = color;
        invalidate();
    }

    public void setBorderWidth(int width) {
        borderWidth = width;
        invalidate();
    }

    private Bitmap compress(Bitmap bitmap, float width, float height) {
        // 获取这个图片的宽和高
        float originWidth = bitmap.getWidth();
        float originHeight = bitmap.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = width / originWidth;
        float scaleHeight = height / originHeight;
        float scale = scaleWidth > scaleHeight ? scaleHeight : scaleWidth;
        // 缩放图片动作
        matrix.postScale(scale, scale);
        Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, (int) originWidth,
                (int) originHeight, matrix, true);
        return result;
    }
}
