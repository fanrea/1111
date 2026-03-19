package com.baidu.mobads.container.util.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q {
    public static boolean a() {
        try {
            String strB = DeviceUtils.getInstance().b();
            if (!TextUtils.isEmpty(strB)) {
                if (!strB.equalsIgnoreCase("xiaomi") && !strB.equalsIgnoreCase("redmi")) {
                    if (!strB.equalsIgnoreCase("blackshark")) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            z.a(context, "mi-start", "");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            if (cls != null) {
                Object objNewInstance = cls.newInstance();
                Method method = cls.getMethod("getOAID", Context.class);
                if (objNewInstance != null && method != null) {
                    String str = (String) method.invoke(objNewInstance, context);
                    if (TextUtils.isEmpty(str)) {
                        z.a(context, "mi-empty", "");
                    } else {
                        z.a(context, "mi-valid", str);
                        z.a(str);
                    }
                    if (!"xiaomi".equalsIgnoreCase(com.baidu.mobads.container.util.x.a(context).e()) && !"redmi".equalsIgnoreCase(com.baidu.mobads.container.util.x.a(context).e())) {
                        z.a(context, "mi");
                    }
                    return str;
                }
            }
        } catch (Throwable th) {
            z.a(context, "mi-error" + th.getMessage(), "");
        }
        return null;
    }
}
