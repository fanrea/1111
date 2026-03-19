package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt {
    public static int d(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.tr().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName());
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int d(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int hc(String str) {
        return d(com.ss.android.socialbase.downloader.downloader.b.tr(), str);
    }

    public static int b(String str) {
        try {
            return d(str, com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName());
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int d(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.tr().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int c(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.tr().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName());
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int u(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.tr().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName());
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int an(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.tr().getResources().getIdentifier(str, TypedValues.Custom.S_COLOR, com.ss.android.socialbase.downloader.downloader.b.tr().getPackageName());
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    public static int hc(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.b.tr().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }
}
