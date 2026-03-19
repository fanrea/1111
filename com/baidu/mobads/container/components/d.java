package com.baidu.mobads.container.components;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends TextView {
    public d(Context context) {
        super(context);
        setBackgroundColor(-2146497529);
        setGravity(17);
        setTextColor(Color.rgb(254, 211, 73));
        setTextSize(12.0f);
    }

    public void a(int i, int i2) {
        setText("" + (i2 - i));
    }
}
