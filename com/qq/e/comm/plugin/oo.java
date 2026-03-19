package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class oo extends RelativeLayout {
    public oo(Context context) {
        this(context, null);
    }

    private void b() throws JSONException {
        setLayerType(1, null);
        setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        String strC = r1.d().f().c("endcardLoadingUrl");
        if (TextUtils.isEmpty(strC)) {
            strC = "https://qzs.qq.com/union/res/union_cdn/page/images/loading_2x.gif";
        }
        xh xhVar = new xh(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(128, 128);
        layoutParams2.addRule(13);
        xhVar.setId(2131755010);
        mm.a().a(strC, xhVar);
        addView(xhVar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setId(2131755011);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2131755010);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = yu.a(getContext(), 16);
        textView.setLayoutParams(layoutParams3);
        textView.setText("正在加载游戏");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        addView(textView);
        TextView textView2 = new TextView(getContext());
        textView2.setId(2131755012);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2131755011);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = yu.a(getContext(), 8);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("即将开启试玩");
        textView2.setTextColor(-1);
        textView2.setTextSize(16.0f);
        addView(textView2);
        setVisibility(8);
    }

    public oo(Context context, AttributeSet attributeSet) throws JSONException {
        super(context, attributeSet);
        b();
    }

    public void a() {
        clearAnimation();
        setVisibility(8);
    }
}
