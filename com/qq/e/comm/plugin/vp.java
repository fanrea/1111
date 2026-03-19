package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.wp;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vp {
    public static LinearLayout a(Context context, String str, int i, int i2, boolean z) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setAlpha(127);
        float f = i >> 1;
        gradientDrawable.setCornerRadius(f);
        int iA = (int) yu.a(context, 1.5f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f);
        gradientDrawable2.setColor(0);
        gradientDrawable2.setStroke(iA, -1);
        gradientDrawable2.setAlpha(76);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
        layerDrawable.setLayerInset(0, iA, iA, iA, iA);
        linearLayout.setBackgroundDrawable(layerDrawable);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-1);
        textView.setTextSize(2, i2);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setText(str);
        linearLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2));
        if (z) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAACMAAAAhCAYAAABTERJSAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAUGVYSWZNTQAqAAAACAACARIAAwAAAAEAAQAAh2kABAAAAAEAAAAmAAAAAAADoAEAAwAAAAEAAQAAoAIABAAAAAEAAAAjoAMABAAAAAEAAAAhAAAAANChPtkAAAIwaVRYdFhNTDpjb20uYWRvYmUueG1wAAAAAAA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJYTVAgQ29yZSA2LjAuMCI+CiAgIDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+CiAgICAgIDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiCiAgICAgICAgICAgIHhtbG5zOmV4aWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vZXhpZi8xLjAvIgogICAgICAgICAgICB4bWxuczp0aWZmPSJodHRwOi8vbnMuYWRvYmUuY29tL3RpZmYvMS4wLyI+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj4zNTwvZXhpZjpQaXhlbFlEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOlBpeGVsWERpbWVuc2lvbj4zMzwvZXhpZjpQaXhlbFhEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOkNvbG9yU3BhY2U+MTwvZXhpZjpDb2xvclNwYWNlPgogICAgICAgICA8dGlmZjpPcmllbnRhdGlvbj4xPC90aWZmOk9yaWVudGF0aW9uPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KN1CXDgAAAQZJREFUWAntlTEOwjAMRVMWYESszNyAjZWBiYmdi/QsDGwMIBg5BQNnYOMCIFReJKpEVqiqpo0YbOmrjuU6v69VY0xEFEUxRJOIEe3ciokZeiAbRzRoZ3KDKWy+ty68uJBHGeo18FHeci+T73XB9RxrSMyst2TTEboiGdGE6jkQXbgYIzUkuLilEnIswpkSCnNxVSXkWIQzJRTm4qoVhHLXZUzMQenPqcyzLHvQsA00TQO1bkuQ2aA38uPJYt7tzmI6G/4yshKt3S7ViOSrRJSIJCDX+o38M5Elryf0i0/7Z7WEMHJAftizJspIzKl9817bi3zN6XzyaulSKPRRjnYo7emb4jE/Fej5smeLowoAAAAASUVORK5CYII="));
            int iA2 = yu.a(context, i2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams.leftMargin = yu.a(context, 6);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    public static String a(h4 h4Var) {
        l3 l3VarO;
        i3 i3VarB;
        if (h4Var == null || (l3VarO = h4Var.o()) == null || (i3VarB = l3VarO.b()) == null) {
            return null;
        }
        return String.format("应用名称：%s | 应用版本：%s | 开发者：%s | 适用年龄：%s | ", i3VarB.a(), i3VarB.j(), i3VarB.b(), i3VarB.i()) + String.format("%s > | %s > | %s > | %s >", "权限详情", "隐私协议", "功能介绍", "备案信息");
    }

    public static void a(h4 h4Var, wp.b bVar) {
        if (h4Var == null || h4Var.o() == null || h4Var.o().b() == null) {
            return;
        }
        Context contextA = r1.d().a();
        Intent intent = new Intent();
        intent.setClassName(contextA, wx.a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.MIIT_INFO_DISPLAY);
        intent.putExtra("appid", r1.d().b().a());
        intent.putExtra("objectId", h4Var.s0());
        ((k1) zm.a(h4Var.s0(), k1.class)).a(h4Var);
        intent.addFlags(268435456);
        contextA.startActivity(intent);
        if (bVar != null) {
            wp.b.l.put(h4Var.k0(), new WeakReference<>(bVar));
            bVar.d();
        }
    }

    public static void a(Context context, h4 h4Var, rs rsVar, int i) {
        if (h4Var == null || h4Var.o() == null || h4Var.o().b() == null) {
            return;
        }
        try {
            if (e3.b(h4Var) == 4) {
                new s8(context, h4Var, rsVar).show();
            } else {
                new sp(context, h4Var, rsVar, i).show();
            }
        } catch (Throwable unused) {
            if (rsVar != null) {
                rsVar.a(false);
            }
        }
    }
}
