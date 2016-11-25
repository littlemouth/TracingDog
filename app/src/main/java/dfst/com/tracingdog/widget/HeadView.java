package dfst.com.tracingdog.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dfst.com.core.util.DensityUtil;
import dfst.com.core.util.ImageUtil;
import dfst.com.tracingdog.R;

/**
 * Created by yanfei on 2016-11-22.
 */
public class HeadView extends View {
    private Context mContext;
    private List<Bitmap> mBitmaps;

    private int length;
    private int divider;
    private int bitmapLength;
    private int bgColor;

    public HeadView(Context context, int length) {
        super(context);
        mContext = context;
        this.length = length;
        init();
    }

    public HeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(bgColor);
        if (mBitmaps.size() == 1) {
            canvas.drawColor(Color.WHITE);
            canvas.drawBitmap(mBitmaps.get(0), 0, 0, null);
        } else if (mBitmaps.size() == 2) {
            canvas.drawBitmap(mBitmaps.get(0), divider, length / 2 - bitmapLength / 2, null);
            canvas.drawBitmap(mBitmaps.get(1), divider * 2 + bitmapLength, length / 2 - bitmapLength / 2, null);
        } else if (mBitmaps.size() == 3) {
            canvas.drawBitmap(mBitmaps.get(0), length / 2 - bitmapLength / 2, divider, null);
            canvas.drawBitmap(mBitmaps.get(1), divider, divider * 2 + bitmapLength, null);
            canvas.drawBitmap(mBitmaps.get(2), divider * 2 + bitmapLength, divider * 2 + bitmapLength, null);
        } else if (mBitmaps.size() == 4) {
            canvas.drawBitmap(mBitmaps.get(0), divider, divider, null);
            canvas.drawBitmap(mBitmaps.get(1), divider * 2 + bitmapLength, divider, null);
            canvas.drawBitmap(mBitmaps.get(2), divider, divider * 2 + bitmapLength, null);
            canvas.drawBitmap(mBitmaps.get(3), divider * 2 + bitmapLength, divider * 2 + bitmapLength, null);
        } else if (mBitmaps.size() == 5) {
            canvas.drawBitmap(mBitmaps.get(0), length / 2 - bitmapLength - divider / 2, divider + bitmapLength / 2, null);
            canvas.drawBitmap(mBitmaps.get(1), length / 2 + divider / 2, divider + bitmapLength / 2, null);
            for (int column = 0; column < 3; column++) {
                canvas.drawBitmap(mBitmaps.get(column + 1), divider * (column + 1) + bitmapLength * column,
                        divider * 2 + bitmapLength + bitmapLength / 2, null);
            }
        } else if (mBitmaps.size() == 6) {
            for (int row = 0; row < 2; row++) {
                for (int column = 0; column < 3; column++) {
                    canvas.drawBitmap(mBitmaps.get(row * 3 + column), divider * (column + 1) + bitmapLength * column,
                            divider * (row + 1) + bitmapLength * row + bitmapLength / 2, null);
                }
            }
        } else if (mBitmaps.size() == 7) {
            canvas.drawBitmap(mBitmaps.get(0), length / 2 - bitmapLength / 2, divider, null);
            for (int row = 1; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    canvas.drawBitmap(mBitmaps.get((row - 1) * 3 + column + 1), divider * (column + 1) + bitmapLength * column,
                            divider * (row + 1) + bitmapLength * row, null);
                }
            }
        } else if (mBitmaps.size() == 8) {
            canvas.drawBitmap(mBitmaps.get(0), length / 2 - bitmapLength - divider / 2, divider, null);
            canvas.drawBitmap(mBitmaps.get(1), length / 2 + divider / 2, divider, null);
            for (int row = 1; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    canvas.drawBitmap(mBitmaps.get((row - 1) * 3 + column + 2), divider * (column + 1) + bitmapLength * column,
                            divider * (row + 1) + bitmapLength * row, null);
                }
            }
        } else if (mBitmaps.size() == 9) {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    canvas.drawBitmap(mBitmaps.get(row * 3 + column), divider * (column + 1) + bitmapLength * column,
                            divider * (row + 1) + bitmapLength * row, null);
                }
            }
        }
    }

    private void init() {
        mBitmaps = new ArrayList<>(9);
        divider = DensityUtil.dip2px(mContext, 2);
        bgColor = ContextCompat.getColor(mContext, R.color.gray_e5e5e5);
    }

    public void refresh(Bitmap... bitmaps) {
        if (length == 0) {
            ViewGroup.LayoutParams params = getLayoutParams();
            length = params.width;
        }

        if (bitmaps == null || bitmaps.length == 0) return;
        if (bitmaps.length == 1) {
            bitmapLength = length;
        } else if (bitmaps.length > 1 && bitmaps.length < 5) {
            bitmapLength = (length - divider * 3) / 2;
        } else {
            bitmapLength = (length - divider * 4) / 3;
        }

        mBitmaps.clear();
        for (Bitmap bitmap : bitmaps) {
            bitmap = ImageUtil.compressImage(bitmap, bitmapLength, bitmapLength);
            mBitmaps.add(bitmap);
        }
        postInvalidate();
    }

}
