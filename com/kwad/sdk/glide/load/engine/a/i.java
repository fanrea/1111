package com.kwad.sdk.glide.load.engine.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i {
    private final int bVs;
    private final int bVt;
    private final int bVu;
    private final Context dR;

    interface c {
        int ahl();

        int ahm();
    }

    i(a aVar) {
        int i;
        this.dR = aVar.dR;
        if (a(aVar.bVw)) {
            i = aVar.bVC / 2;
        } else {
            i = aVar.bVC;
        }
        this.bVu = i;
        int iA = a(aVar.bVw, aVar.bVA, aVar.bVB);
        float fAhl = aVar.bVx.ahl() * aVar.bVx.ahm() * 4;
        int iRound = Math.round(aVar.bVz * fAhl);
        int iRound2 = Math.round(fAhl * aVar.bVy);
        int i2 = iA - i;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.bVt = iRound2;
            this.bVs = iRound;
        } else {
            float f = i2 / (aVar.bVz + aVar.bVy);
            this.bVt = Math.round(aVar.bVy * f);
            this.bVs = Math.round(f * aVar.bVz);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculation complete, Calculated memory cache size: " + gj(this.bVt) + ", pool size: " + gj(this.bVs) + ", byte array size: " + gj(i) + ", memory class limited? " + (i3 > iA) + ", max size: " + gj(iA) + ", memoryClass: " + aVar.bVw.getMemoryClass() + ", isLowMemoryDevice: " + a(aVar.bVw));
        }
    }

    public final int ahh() {
        return this.bVt;
    }

    public final int ahi() {
        return this.bVs;
    }

    public final int ahj() {
        return this.bVu;
    }

    private static int a(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    private String gj(int i) {
        return Formatter.formatFileSize(this.dR, i);
    }

    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public static final class a {
        static final int bVv;
        ActivityManager bVw;
        c bVx;
        float bVz;
        final Context dR;
        float bVy = 2.0f;
        float bVA = 0.4f;
        float bVB = 0.33f;
        int bVC = 4194304;

        static {
            bVv = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.bVz = bVv;
            this.dR = context;
            this.bVw = (ActivityManager) context.getSystemService("activity");
            this.bVx = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.bVw)) {
                return;
            }
            this.bVz = 0.0f;
        }

        public final i ahk() {
            return new i(this);
        }
    }

    static final class b implements c {
        private final DisplayMetrics bVD;

        b(DisplayMetrics displayMetrics) {
            this.bVD = displayMetrics;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public final int ahl() {
            return this.bVD.widthPixels;
        }

        @Override // com.kwad.sdk.glide.load.engine.a.i.c
        public final int ahm() {
            return this.bVD.heightPixels;
        }
    }
}
