package com.baidu.mobads.container.p;

import android.content.Context;
import com.baidu.ad.magic.flute.api.AdFluteManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    public long a(Context context) {
        try {
            return ((Long) AdFluteManager.getInstance(context).syncGetLastLaunchTimeInMillis("com.baidu.searchbox").second).longValue();
        } catch (Throwable th) {
            return -1L;
        }
    }

    public long a(int i) {
        try {
            Date date = b(4).parse(b(i).format(new Date(System.currentTimeMillis())));
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    private SimpleDateFormat b(int i) {
        String str;
        switch (i) {
            case 0:
                str = "yyyy-MM-dd 00:00:00";
                break;
            case 1:
                str = "yyyy-MM-dd HH:00:00";
                break;
            case 2:
                str = "yyyy-MM-dd HH:mm:00";
                break;
            default:
                str = "yyyy-MM-dd HH:mm:ss";
                break;
        }
        return new SimpleDateFormat(str, Locale.getDefault());
    }
}
