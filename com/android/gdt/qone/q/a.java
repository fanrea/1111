package com.android.gdt.qone.q;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.u.i;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a {
    public final ArrayList a = new ArrayList();

    public static String a(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "double":
                return "D";
            case "int":
                return "I";
            case "byte":
                return "B";
            case "char":
                return "C";
            case "long":
                return "J";
            case "boolean":
                return "Z";
            case "float":
                return "F";
            case "short":
                return ExifInterface.LATITUDE_SOUTH;
            default:
                return "L" + str.replace('.', '/') + i.b;
        }
    }

    public final void a(String str, Class cls, Method method) {
        int length;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return;
        }
        String strReplace = canonicalName.replace('.', '/');
        String name = method.getName();
        StringBuilder sb = new StringBuilder();
        try {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (Build.VERSION.SDK_INT >= 26) {
                length = a$$ExternalSyntheticBackport0.m(method);
            } else {
                length = parameterTypes.length;
            }
            sb.append("(");
            for (int i = 0; i < length; i++) {
                sb.append(a(parameterTypes[i].getName()));
            }
            sb.append(")");
            sb.append(a(method.getReturnType().getName()));
        } catch (Exception unused) {
        }
        this.a.add(new String[]{strReplace, name, sb.toString(), str});
    }

    public final void a(String str, Class cls) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods.length == 0) {
                return;
            }
            for (Method method : declaredMethods) {
                if (((b) method.getAnnotation(b.class)) != null) {
                    a(str, cls, method);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }
}
