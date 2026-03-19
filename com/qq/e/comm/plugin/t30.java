package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t30 {
    private static final Map<Object, cm> a = new ConcurrentHashMap(20);

    private static uh b(String str) {
        if (str == null) {
            return null;
        }
        Map<Object, cm> map = a;
        cm cmVar = map.get(str);
        if (cmVar instanceof uh) {
            return (uh) cmVar;
        }
        uh uhVar = new uh(str);
        map.put(str, uhVar);
        return uhVar;
    }

    public static ob b(Object obj) {
        Map<Object, cm> map = a;
        cm cmVarD = map.get(obj);
        if (cmVarD instanceof ob) {
            return (ob) cmVarD;
        }
        if (cmVarD != null) {
            return null;
        }
        if (obj instanceof String) {
            cmVarD = d((String) obj);
        } else if (obj instanceof JSONArray) {
            cmVarD = d(obj.toString());
        }
        if (cmVarD != null) {
            map.put(obj, cmVarD);
        }
        return (ob) cmVarD;
    }

    private static cm d(String str) {
        if (!a(str)) {
            return null;
        }
        List<String> listC = c(str);
        if (listC.isEmpty()) {
            return null;
        }
        if (listC.size() == 1) {
            return e(str);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            cm cmVarE = e(it.next());
            if (cmVarE == null) {
                return null;
            }
            arrayList.add(cmVarE);
        }
        return new f7(arrayList, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.qq.e.comm.plugin.cm e(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.t30.e(java.lang.String):com.qq.e.comm.plugin.cm");
    }

    private static List<String> c(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '$' && (i2 = i3 + 1) < length && str.charAt(i2) == '{' && !z) {
                int iIndexOf = str.indexOf(125, i3 + 2);
                if (iIndexOf != -1) {
                    if (sb.length() > 0) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    arrayList.add(str.substring(i3, iIndexOf + 1));
                    i3 = iIndexOf;
                } else {
                    sb.append(cCharAt);
                }
            } else if (cCharAt == ';' && (i = i3 + 1) < length && str.charAt(i) == '{') {
                if (sb.length() > 0) {
                    arrayList.add(str.substring(i5, i3));
                    sb.setLength(0);
                }
                sb.append(cCharAt);
                i5 = i3;
                z = true;
            } else if (cCharAt == '{' && z) {
                i4++;
                sb.append(cCharAt);
            } else if (cCharAt == '}' && z && i4 > 1) {
                i4--;
                sb.append(cCharAt);
            } else if (cCharAt == '}' && z && i4 == 1) {
                i4--;
                sb.append(cCharAt);
                if (sb.length() > 0) {
                    arrayList.add(str.substring(i5, i3 + 1));
                    sb.setLength(0);
                }
                z = false;
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public static f10 c(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            return new js();
        }
        if (!(obj instanceof String) && !(obj instanceof Number)) {
            return new f10(obj);
        }
        Map<Object, cm> map = a;
        cm cmVar = map.get(obj);
        if (cmVar instanceof f10) {
            return (f10) cmVar;
        }
        f10 f10Var = new f10(obj);
        map.put(obj, f10Var);
        return f10Var;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("${") || str.contains(";{");
    }

    public static cm a(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            return null;
        }
        Map<Object, cm> map = a;
        cm f10Var = map.get(obj);
        if (f10Var != null) {
            return f10Var.a();
        }
        if (obj instanceof String) {
            f10Var = d((String) obj);
        }
        if (obj instanceof JSONArray) {
            f10Var = d(obj.toString());
        }
        if (f10Var == null) {
            f10Var = new f10(obj);
        }
        map.put(obj, f10Var);
        return f10Var;
    }
}
