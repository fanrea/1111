package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.c.mk;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.jh;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.gb += 6;
        if (this.mq.hv()) {
            this.e = new AnimationText(context, this.mq.h(), this.mq.u(), 1, this.mq.gb());
            ((AnimationText) this.e).setMaxLines(1);
        } else {
            this.e = new TextView(context);
            ((TextView) this.e).setIncludeFontPadding(false);
        }
        this.e.setTag(Integer.valueOf(getClickArea()));
        addView(this.e, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() throws NumberFormatException {
        int i;
        super.gb();
        if (TextUtils.isEmpty(getText())) {
            this.e.setVisibility(4);
            return true;
        }
        if (this.mq.hv()) {
            mk();
            return true;
        }
        ((TextView) this.e).setText(this.mq.an());
        if (Build.VERSION.SDK_INT >= 17) {
            ((TextView) this.e).setTextDirection(5);
            this.e.setTextAlignment(this.mq.gb());
        }
        ((TextView) this.e).setTextColor(this.mq.h());
        ((TextView) this.e).setTextSize(this.mq.u());
        if (!this.mq.de()) {
            ((TextView) this.e).setMaxLines(1);
            ((TextView) this.e).setGravity(17);
            ((TextView) this.e).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iV = this.mq.v();
            if (iV > 0) {
                ((TextView) this.e).setLines(iV);
                ((TextView) this.e).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.uo != null && this.uo.tc() != null) {
            if (com.bytedance.sdk.component.adexpress.c.d() && tt() && (TextUtils.equals(this.uo.tc().getType(), "text_star") || TextUtils.equals(this.uo.tc().getType(), "score-count") || TextUtils.equals(this.uo.tc().getType(), "score-count-type-1") || TextUtils.equals(this.uo.tc().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (TextUtils.equals(this.uo.tc().getType(), "score-count") || TextUtils.equals(this.uo.tc().getType(), "score-count-type-2")) {
                try {
                    try {
                        i = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i = -1;
                }
                if (i < 0) {
                    if (com.bytedance.sdk.component.adexpress.c.d()) {
                        setVisibility(8);
                        return true;
                    }
                    this.e.setVisibility(0);
                }
                if (TextUtils.equals(this.uo.tc().getType(), "score-count-type-2")) {
                    ((TextView) this.e).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                    ((TextView) this.e).setGravity(17);
                    return true;
                }
                d((TextView) this.e, i, getContext(), "tt_comment_num");
            } else if (TextUtils.equals(this.uo.tc().getType(), "text_star")) {
                double d = -1.0d;
                try {
                    d = Double.parseDouble(getText());
                } catch (Exception e) {
                    mq.c("DynamicStarView applyNativeStyle", e.toString());
                }
                if (d < 0.0d || d > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.c.d()) {
                        setVisibility(8);
                        return true;
                    }
                    this.e.setVisibility(0);
                }
                ((TextView) this.e).setIncludeFontPadding(false);
                ((TextView) this.e).setText(String.format("%.1f", Double.valueOf(d)));
            } else if (TextUtils.equals("privacy-detail", this.uo.tc().getType())) {
                ((TextView) this.e).setText("功能 | 权限 | 隐私");
            } else if (TextUtils.equals(this.uo.tc().getType(), "development-name")) {
                ((TextView) this.e).setText(jh.d(com.bytedance.sdk.component.adexpress.c.getContext(), "tt_text_privacy_development") + getText());
            } else if (TextUtils.equals(this.uo.tc().getType(), "app-version")) {
                ((TextView) this.e).setText(jh.d(com.bytedance.sdk.component.adexpress.c.getContext(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.e).setText(getText());
            }
            if (Build.VERSION.SDK_INT >= 17) {
                this.e.setTextAlignment(this.mq.gb());
                ((TextView) this.e).setGravity(this.mq.tt());
            }
            if (com.bytedance.sdk.component.adexpress.c.d()) {
                tc();
            }
        }
        return true;
    }

    private boolean tt() {
        return (this.k == null || this.k.getRenderRequest() == null || this.k.getRenderRequest().uo() == 4) ? false : true;
    }

    private void tc() {
        int iD;
        if (TextUtils.equals(this.uo.tc().getType(), n.l) || TextUtils.equals(this.uo.tc().getType(), "title") || TextUtils.equals(this.uo.tc().getType(), "text_star")) {
            int[] iArrHc = mk.hc(this.mq.an(), this.mq.u(), true);
            int iD2 = (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), this.mq.hc());
            int iD3 = (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), this.mq.b());
            int iD4 = (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), this.mq.c());
            int iD5 = (int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), this.mq.d());
            int iMin = Math.min(iD2, iD5);
            if (TextUtils.equals(this.uo.tc().getType(), n.l) && (iD = ((this.gb - ((int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), this.mq.u()))) - iD2) - iD5) > 1 && iD <= iMin * 2) {
                int i = iD / 2;
                this.e.setPadding(iD3, iD2 - i, iD4, iD5 - (iD - i));
                return;
            }
            int i2 = (((iArrHc[1] + iD2) + iD5) - this.gb) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.e.setPadding(iD3, iD2 - i3, iD4, iD5 - (i2 - i3));
            } else if (i2 > iD2 + iD5) {
                final int i4 = (i2 - iD2) - iD5;
                this.e.setPadding(iD3, 0, iD4, 0);
                if (i4 <= ((int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), 1.0f)) + 1) {
                    ((TextView) this.e).setTextSize(this.mq.u() - 1.0f);
                } else if (i4 <= (((int) com.bytedance.sdk.component.adexpress.c.gb.d(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.e).setTextSize(this.mq.u() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.e.getLayoutParams();
                                layoutParams.height = DynamicTextView.this.gb + i4;
                                DynamicTextView.this.e.setLayoutParams(layoutParams);
                                DynamicTextView.this.e.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) DynamicTextView.this.e.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) DynamicTextView.this.e.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iD2 > iD5) {
                this.e.setPadding(iD3, iD2 - (i2 - iMin), iD4, iD5 - iMin);
            } else {
                this.e.setPadding(iD3, iD2 - iMin, iD4, iD5 - (i2 - iMin));
            }
        }
        if (!TextUtils.equals(this.uo.tc().getType(), "fillButton") || Build.VERSION.SDK_INT < 17) {
            return;
        }
        this.e.setTextAlignment(2);
        ((TextView) this.e).setGravity(17);
    }

    public String getText() {
        String strAn = this.mq.an();
        if (TextUtils.isEmpty(strAn)) {
            if (!com.bytedance.sdk.component.adexpress.c.d() && TextUtils.equals(this.uo.tc().getType(), "text_star")) {
                strAn = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.c.d() && TextUtils.equals(this.uo.tc().getType(), "score-count")) {
                strAn = "6870";
            }
        }
        return (TextUtils.equals(this.uo.tc().getType(), "title") || TextUtils.equals(this.uo.tc().getType(), "subtitle")) ? strAn.replace("\n", "") : strAn;
    }

    public void d(TextView textView, int i, Context context, String str) {
        textView.setText("(" + String.format(jh.d(context, str), Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void mk() {
        if (this.e instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            } catch (JSONException e) {
                mq.d(e);
                arrayList.add(text);
            }
            ((AnimationText) this.e).setMaxLines(1);
            ((AnimationText) this.e).setTextColor(this.mq.h());
            ((AnimationText) this.e).setTextSize(this.mq.u());
            ((AnimationText) this.e).setAnimationText(arrayList);
            ((AnimationText) this.e).setAnimationType(this.mq.dc());
            ((AnimationText) this.e).setAnimationDuration(this.mq.bc() * 1000);
            ((AnimationText) this.e).d();
        }
    }
}
