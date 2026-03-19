package com.kwad.components.ct.f;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    public static int parseColor(String str) {
        return Color.parseColor(str);
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getResources().getDrawable(i);
    }

    public static void r(View view, int i) {
        if (view != null) {
            view.setBackgroundDrawable(getDrawable(view.getContext(), i));
        }
    }

    public static void c(View view, String str) {
        if (view != null) {
            view.setBackgroundColor(parseColor(str));
        }
    }

    public static void a(TextView textView, String str) {
        if (textView != null) {
            textView.setTextColor(parseColor(str));
        }
    }

    public static void a(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(textView.getContext().getResources().getColorStateList(i));
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setImageDrawable(getDrawable(imageView.getContext(), i));
        }
    }
}
