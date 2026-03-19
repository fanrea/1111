package com.sigmob.sdk.base.common;

import android.content.Context;
import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ai extends Toast {
    public ai(Context context) {
        super(context);
    }

    public static Toast a(Context context, CharSequence text, int duration) {
        Toast toastMakeText = Toast.makeText(context, text, duration);
        toastMakeText.setGravity(17, 0, 0);
        return toastMakeText;
    }
}
