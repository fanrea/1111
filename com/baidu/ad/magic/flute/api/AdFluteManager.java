package com.baidu.ad.magic.flute.api;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.baidu.ad.magic.flute.a.a.d;
import com.baidu.ad.magic.flute.a.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class AdFluteManager {
    private static final boolean a = false;
    private static final String b = "Flute";
    private static volatile AdFluteManager c;
    private Context d;

    private AdFluteManager(Context context) {
        this.d = context.getApplicationContext();
    }

    private m a(String str) {
        return new d(this.d).a(str);
    }

    public static synchronized AdFluteManager getInstance(Context context) {
        if (c == null) {
            synchronized (AdFluteManager.class) {
                if (c == null) {
                    c = new AdFluteManager(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    public void asyncGetLastLaunchTimeInMillis(String str, OnGetIdResultCallback onGetIdResultCallback) {
        asyncGetLastLaunchTimeInMillis(str, onGetIdResultCallback, Looper.getMainLooper());
    }

    public void asyncGetLastLaunchTimeInMillis(String str, OnGetIdResultCallback onGetIdResultCallback, Looper looper) {
        a aVar = new a(onGetIdResultCallback, looper);
        m mVarA = a(str);
        if (mVarA.a()) {
            try {
                aVar.a(Long.valueOf(com.baidu.ad.magic.flute.d.a.a(mVarA.a)), null);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
        aVar.a(mVarA.b, mVarA.c, null);
    }

    public Pair syncGetLastLaunchTimeInMillis(String str) {
        m mVarA = a(str);
        long jA = -1;
        if (!mVarA.a()) {
            return new Pair(Integer.valueOf(mVarA.b), -1L);
        }
        try {
            jA = com.baidu.ad.magic.flute.d.a.a(mVarA.a);
            return new Pair(0, Long.valueOf(jA));
        } catch (IllegalArgumentException e) {
            return new Pair(-108, Long.valueOf(jA));
        }
    }
}
