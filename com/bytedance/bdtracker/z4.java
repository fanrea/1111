package com.bytedance.bdtracker;

import android.os.SystemProperties;
import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class z4 {
    public static volatile Object b;
    public final List<String> a = Collections.singletonList("SystemPropertiesProxy");

    public final Object a() {
        if (b == null) {
            synchronized (z4.class) {
                if (b == null) {
                    try {
                        b = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return b;
    }

    public String a(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            LoggerImpl.global().error(this.a, "Get key:{} value failed", th, str);
            try {
                Object objA = a();
                return (String) objA.getClass().getMethod("get", String.class).invoke(objA, str);
            } catch (Throwable th2) {
                LoggerImpl.global().error(this.a, "Get key:{} value by reflection failed", th2, str);
                return "";
            }
        }
    }
}
