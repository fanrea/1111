package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.SoftReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class vv {
    private static SoftReference<Toast> d;

    private static Toast d(Context context) {
        if (context == null) {
            SoftReference<Toast> softReference = d;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }
        SoftReference<Toast> softReference2 = new SoftReference<>(Toast.makeText(context.getApplicationContext(), "", 0));
        d = softReference2;
        return softReference2.get();
    }

    public static Toast d(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        toast.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(d(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(d(context, 20.0f), d(context, 12.0f), d(context, 20.0f), d(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void d(Context context, String str, int i) {
        hc(context, str, i, 80, 0, d(context, 40.0f));
    }

    public static void hc(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toastD = d(context);
        if (toastD != null) {
            toastD.setDuration(i);
            toastD.setGravity(i2, i3, i4);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(d(context, 10.0f));
            gradientDrawable.setColor(Color.parseColor("#CC161823"));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(d(context, 20.0f), d(context, 12.0f), d(context, 20.0f), d(context, 12.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setText(str);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            toastD.setView(linearLayout);
            toastD.show();
            return;
        }
        mq.d("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static int d(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
