package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class h1 {
    static String d;
    static String hc;

    public static synchronized String d(Context context) {
        TelephonyManager telephonyManager;
        String str = d;
        if (str != null) {
            return q1.d(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.d("6765744465766963654964")), new Class[0]);
        declaredMethod.setAccessible(true);
        d = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return q1.d(d);
    }

    public static synchronized String hc(Context context) {
        TelephonyManager telephonyManager;
        String str = d;
        if (str != null) {
            return q1.d(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.d("676574537562736372696265724964")), new Class[0]);
        declaredMethod.setAccessible(true);
        hc = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return q1.d(hc);
    }
}
