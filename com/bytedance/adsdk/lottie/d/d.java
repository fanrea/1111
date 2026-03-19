package com.bytedance.adsdk.lottie.d;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.lottie.u.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public d() {
    }

    public d(int i) {
        super(i);
    }

    public d(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public d(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((gb.d(i, 0, 255) << 24) | (getColor() & 16777215));
        } else {
            super.setAlpha(gb.d(i, 0, 255));
        }
    }
}
