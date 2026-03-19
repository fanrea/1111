package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.baidu.mobstat.forbes.Config;
import com.sigmob.sdk.base.mta.PointType;
import com.tencent.turingfd.sdk.ams.au.Gooseberry;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Kiwifruit {
    public static final String b;
    public final Handler a;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Kiwifruit$do, reason: invalid class name */
    public class Cdo implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Map b;

        public Cdo(Kiwifruit kiwifruit, Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Kiwifruit.a(this.a, (Map<String, String>) this.b);
        }
    }

    static {
        StringBuilder sbA = Bennet.a("turingfd_conf_");
        sbA.append(Casaba.a);
        sbA.append(Config.replace);
        sbA.append("au");
        b = sbA.toString();
    }

    public Kiwifruit(Handler handler) {
        this.a = handler;
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int i = Date.a;
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i3])) << 4));
            }
            return Date.a(Cstatic.a(bArr, Cstatic.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public Gooseberry a(Context context) {
        long jLongValue;
        try {
            String strB = b(context, PointType.ANTI_SPAM);
            if (TextUtils.isEmpty(strB)) {
                return Gooseberry.a(1);
            }
            try {
                jLongValue = Long.valueOf(b(context, PointType.ANTI_SPAM_TOUCH)).longValue();
            } catch (Throwable unused) {
                jLongValue = 0;
            }
            String strB2 = b(context, "104");
            String strB3 = b(context, "105");
            String strB4 = b(context, "106");
            String strB5 = b(context, "110");
            Gooseberry.Cdo cdo = new Gooseberry.Cdo(0);
            cdo.b = jLongValue;
            cdo.a = strB;
            cdo.d = strB2;
            cdo.e = strB3;
            cdo.f = strB4;
            cdo.g = strB5;
            return new Gooseberry(cdo);
        } catch (Throwable unused2) {
            return Gooseberry.a(1);
        }
    }

    public void c(Context context, long j) {
        a(context, "503", "" + j, true);
    }

    public void b(Context context, long j) {
        HashMap map = new HashMap();
        map.put("902", "" + j);
        a(context, map);
    }

    public void a(Context context, long j) {
        if (j >= LocationRequestCompat.PASSIVE_INTERVAL) {
            j = Long.MAX_VALUE;
        }
        a(context, PointType.GDPR_CONSENT, "" + j, true);
    }

    public Hydra<Long> a(Context context, int i) throws NumberFormatException {
        System.currentTimeMillis();
        Hydra<Long> hydra = new Hydra<>(i);
        for (String str : b(context, PointType.SIGMOB_CRASH).split(Config.replace)) {
            try {
                Long lValueOf = Long.valueOf(str);
                lValueOf.longValue();
                hydra.a(lValueOf);
            } catch (NumberFormatException unused) {
            }
        }
        return hydra;
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        try {
            sharedPreferences = context.getSharedPreferences(b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                editorEdit.putString(str, Date.a(Cstatic.b(map.get(str).getBytes(), Cstatic.a())));
            } catch (Throwable unused2) {
            }
        }
        try {
            editorEdit.commit();
        } catch (Throwable unused3) {
        }
    }

    public final void a(Context context, String str, String str2, boolean z) {
        HashMap map = new HashMap();
        map.put(str, str2);
        a(context, map, z);
    }

    public final void a(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put(str, str2);
        a(context, (Map<String, String>) map, false);
    }

    public final void a(Context context, Map<String, String> map, boolean z) {
        if (z) {
            a(context, map);
        } else {
            this.a.post(new Cdo(this, context, map));
        }
    }

    public final long a(Context context, String str) {
        try {
            return Long.valueOf(b(context, str)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
