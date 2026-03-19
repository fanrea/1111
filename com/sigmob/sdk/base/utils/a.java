package com.sigmob.sdk.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private int a;
    private final View b;
    private final ViewGroup.LayoutParams c;

    private a(View content) {
        this.b = content;
        content.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.utils.a$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.a();
            }
        });
        this.c = content.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iB = b();
        if (iB == this.a) {
            return;
        }
        this.c.height = iB;
        this.b.requestLayout();
        this.a = iB;
    }

    public static void a(View content) {
        new a(content);
    }

    public static boolean a(Context context) throws ClassNotFoundException {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = false;
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (!"1".equals(str)) {
                z = "0".equals(str) ? true : z2;
            }
            return z;
        } catch (Exception e) {
            Log.w("AndroidBug5497Workaround", e);
            return z2;
        }
    }

    private int b() {
        Rect rect = new Rect();
        this.b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }
}
