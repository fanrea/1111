package com.bytedance.common.utility.android;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ClipboardCompat {
    private static final ClipboardImpl IMPL;

    interface ClipboardImpl {
        void setText(Context context, CharSequence charSequence, CharSequence charSequence2);
    }

    static class BaseClipboardImpl implements ClipboardImpl {
        BaseClipboardImpl() {
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(charSequence2);
        }
    }

    static class HoneycombClipboardImpl implements ClipboardImpl {
        HoneycombClipboardImpl() {
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
            ((android.content.ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombClipboardImpl();
        } else {
            IMPL = new BaseClipboardImpl();
        }
    }

    public static void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context == null || charSequence == null || charSequence2 == null) {
            return;
        }
        try {
            IMPL.setText(context, charSequence, charSequence2);
        } catch (Throwable unused) {
        }
    }
}
