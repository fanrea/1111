package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.adsdk.lottie.jh;
import com.bytedance.adsdk.lottie.tt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends h {
    private LinearLayout gb;
    private final List<TextView> mk;
    private String mq;
    private final List<String> tc;
    private final LinearLayout.LayoutParams tt;

    public an(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, Context context) {
        List<tt.hc> listB;
        super(gbVar, gbVar2);
        this.tt = new LinearLayout.LayoutParams(-2, -2);
        this.tc = new ArrayList();
        this.mk = new ArrayList();
        if (this.h == null || (listB = this.h.b()) == null || listB.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.gb = linearLayout;
        int i = 0;
        linearLayout.setOrientation(0);
        hc(listB.get(0).tt);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.gb.addView(linearLayout2);
        List<String> listK = k();
        while (i < listB.size()) {
            tt.hc hcVar = listB.get(i);
            TextView textView = new TextView(context);
            d(textView, hcVar, (listK == null || i >= listK.size()) ? "" : listK.get(i));
            if (hcVar.gb != 0) {
                this.tt.bottomMargin = (int) (hcVar.gb * com.bytedance.adsdk.lottie.u.tt.d());
                linearLayout2.addView(textView, this.tt);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        d(this.gb, (int) (this.h.d() * fD), (int) (this.h.hc() * fD));
    }

    private void hc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gb.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals(j.d)) {
            this.gb.setGravity(3);
        } else if (str.equals(j.e)) {
            this.gb.setGravity(5);
        } else {
            this.gb.setGravity(17);
        }
    }

    private void d(TextView textView, tt.hc hcVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        if (!TextUtils.isEmpty(hcVar.b)) {
            textView.setTextColor(Color.parseColor(hcVar.b));
        } else if (!TextUtils.isEmpty(hcVar.c)) {
            textView.setTextColor(Color.parseColor(hcVar.c));
        }
        if (!TextUtils.isEmpty(hcVar.u)) {
            textView.setBackgroundColor(Color.parseColor(hcVar.u));
        }
        if (hcVar.h == 0) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, hcVar.an);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.h, com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        if (this.gb != null) {
            canvas.save();
            canvas.concat(matrix);
            d(i);
            b(gb());
            this.gb.draw(canvas);
            canvas.restore();
            return;
        }
        super.hc(canvas, matrix, i);
    }

    private void b(float f) {
        List<tt.hc> listB;
        if (this.h == null || (listB = this.h.b()) == null || listB.size() <= 0) {
            return;
        }
        this.gb.setOrientation(0);
        this.gb.setGravity(17);
        if (this.gb.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.gb.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.gb.removeAllViews();
        if (linearLayout.getChildCount() != listB.size()) {
            return;
        }
        List<String> listK = k();
        this.mk.clear();
        int i = 0;
        while (i < listB.size()) {
            tt.hc hcVar = listB.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.mk.add(textView);
            d(textView, hcVar, (listK == null || i >= listK.size()) ? "" : listK.get(i));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listB.size(); i2++) {
            tt.hc hcVar2 = listB.get(i2);
            TextView textView2 = this.mk.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            if (hcVar2.gb != 0) {
                this.tt.bottomMargin = (int) (hcVar2.gb * com.bytedance.adsdk.lottie.u.tt.d());
                linearLayout.addView(textView2, this.tt);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.gb.setAlpha(f);
        this.gb.addView(linearLayout);
        float fD = com.bytedance.adsdk.lottie.u.tt.d();
        d(this.gb, (int) (this.h.d() * fD), (int) (this.h.hc() * fD));
    }

    private List<String> k() {
        jh jhVarYi;
        List<tt.hc> listB;
        if (this.h == null || this.hc == null || (jhVarYi = this.hc.yi()) == null) {
            return null;
        }
        String strC = this.h.c();
        if ((!TextUtils.isEmpty(strC) || !TextUtils.isEmpty(this.mq)) && (listB = this.h.b()) != null) {
            String strD = this.mq;
            if (TextUtils.isEmpty(strD)) {
                strD = jhVarYi.d(strC);
            }
            if (!TextUtils.isEmpty(strD)) {
                int length = strD.length();
                this.tc.clear();
                for (int i = 0; i < listB.size(); i++) {
                    tt.hc hcVar = listB.get(i);
                    int iMax = hcVar.d;
                    int iMax2 = hcVar.hc;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.tc.add("");
                    } else {
                        if (listB.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.tc.add(strD.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.tc;
            }
        }
        return null;
    }

    private static void d(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void d(String str) {
        this.mq = str;
    }
}
