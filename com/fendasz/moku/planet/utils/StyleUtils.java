package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StyleUtils {
    public static int getColor(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getResources().getColor(i, null);
        }
        return context.getResources().getColor(i);
    }

    public static Drawable getRoundedCornerFillDrawable(int i, int i2) {
        float f = i;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStrokeCap(Paint.Cap.ROUND);
        shapeDrawable.getPaint().setStrokeJoin(Paint.Join.ROUND);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        return shapeDrawable;
    }

    public static Drawable getRoundedCornerStrokeDrawable(int i, int i2, int i3, int i4, int i5) {
        return new BitmapDrawable((Resources) null, getBitMap(i3, i4, i, i5, i2));
    }

    public static Bitmap getBitMap(int i, int i2, int i3, int i4, int i5) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        draw(new Canvas(bitmapCreateBitmap), i, i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }

    public static void draw(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        int i6 = i4 / 2;
        Paint paint = new Paint(1);
        paint.setStrokeWidth(i4);
        paint.setColor(i5);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        float f = i6;
        int i7 = i3 * 2;
        float f2 = i6 + i7;
        path.addArc(new RectF(f, f, f2, f2), 180.0f, 90.0f);
        int i8 = i - i6;
        path.lineTo(i8 - i3, f);
        float f3 = i8 - i7;
        float f4 = i8;
        path.addArc(new RectF(f3, f, f4, f2), 270.0f, 90.0f);
        path.lineTo(f4, i2 - i3);
        int i9 = i2 - i6;
        float f5 = i9 - i7;
        float f6 = i9;
        path.addArc(new RectF(f3, f5, f4, f6), 0.0f, 90.0f);
        float f7 = i6 + i3;
        path.lineTo(f7, f6);
        path.addArc(new RectF(f, f5, f2, f6), 90.0f, 90.0f);
        path.lineTo(f, f7);
        canvas.drawPath(path, paint);
    }

    public static TextView getTextView(Context context, int i, int i2, CharSequence charSequence) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(PhoneScreenUtils.getInstance().getScale(context, i)));
        textView.setTextColor(getColor(context, i2));
        textView.setText(charSequence);
        return textView;
    }

    public static void setGradientDrawable(View view, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setColor(i2);
        view.setBackground(gradientDrawable);
    }
}
