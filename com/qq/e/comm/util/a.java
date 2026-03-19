package com.qq.e.comm.util;

import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static final Map<String, Boolean> a = new HashMap();

    private static String a(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append("#").append(str);
        for (Class cls2 : clsArr) {
            sb.append(Config.replace).append(cls2.getName());
        }
        return sb.toString();
    }

    private static boolean b(Class cls, String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        String strA = a(cls, str, clsArr);
        Map<String, Boolean> map = a;
        Boolean bool = map.get(strA);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(strA, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            a.put(strA, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return b(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return b(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
