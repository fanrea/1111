package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hp {
    public static boolean a = true;
    private static Context b = r1.d().a();

    private static Bitmap a(Context context, int i) {
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static Bitmap a(Context context) {
        return a(context, a("gdt_ic_express_play"));
    }

    public static void a(boolean z) {
        a = z;
    }

    public static int a(String str) {
        return b.getResources().getIdentifier(str, "drawable", b.getPackageName());
    }
}
