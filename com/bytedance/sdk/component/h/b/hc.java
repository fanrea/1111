package com.bytedance.sdk.component.h.b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements com.bytedance.sdk.component.h.d, com.bytedance.sdk.component.h.hc {
    private final boolean b;
    private com.bytedance.sdk.component.c.d.d d;
    private final com.bytedance.sdk.component.c.d.d hc;

    public hc(com.bytedance.sdk.component.c.d.d dVar, boolean z) {
        this.d = dVar;
        this.hc = dVar;
        this.b = z;
    }

    private void d(String str) {
        int i;
        com.bytedance.sdk.component.c.c cVar;
        com.bytedance.sdk.component.c.d.d dVarD;
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable unused) {
            }
        }
        if (i == 0) {
            this.d = null;
            return;
        }
        com.bytedance.sdk.component.c.d.d dVar = this.d;
        if ((dVar != null && dVar.d() == i) || (cVar = (com.bytedance.sdk.component.c.c) AutoService.d(com.bytedance.sdk.component.c.c.class)) == null || (dVarD = cVar.d(i)) == null) {
            return;
        }
        this.d = dVarD;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0142 A[Catch: all -> 0x0152, TRY_LEAVE, TryCatch #3 {all -> 0x0152, blocks: (B:13:0x0031, B:15:0x003a, B:16:0x0041, B:17:0x004e, B:19:0x0054, B:21:0x0060, B:23:0x0066, B:25:0x006a, B:26:0x0072, B:28:0x0076, B:29:0x007c, B:67:0x00f0, B:69:0x00f6, B:70:0x010a, B:72:0x0110, B:73:0x011a, B:74:0x011e, B:75:0x012a, B:76:0x0136, B:77:0x0142, B:42:0x00a8, B:45:0x00b2, B:48:0x00bc, B:51:0x00c6, B:54:0x00d0, B:57:0x00da), top: B:111:0x0031 }] */
    @Override // com.bytedance.sdk.component.h.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> d(java.io.File r17) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.h.b.hc.d(java.io.File):java.util.Map");
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(".")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>("s", str);
    }

    @Override // com.bytedance.sdk.component.h.hc
    public void d(Map<String, Object> map, File file) throws Throwable {
        FileWriter fileWriter;
        Throwable th;
        String strConcat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    strConcat = "ss.".concat(String.valueOf(key));
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    strConcat = "b.".concat(String.valueOf(key));
                } else if (entry.getValue() instanceof Integer) {
                    strConcat = "i.".concat(String.valueOf(key));
                } else if (entry.getValue() instanceof Long) {
                    strConcat = "l.".concat(String.valueOf(key));
                } else if ((entry.getValue() instanceof Float) || (entry.getValue() instanceof Double)) {
                    strConcat = "f.".concat(String.valueOf(key));
                } else {
                    strConcat = "s.".concat(String.valueOf(key));
                }
                String strValueOf = String.valueOf(value);
                if (this.b) {
                    strConcat = this.hc.d(strConcat);
                }
                com.bytedance.sdk.component.c.d.d dVar = this.hc;
                if (dVar != null) {
                    strValueOf = dVar.d(String.valueOf(strValueOf));
                }
                properties.put(strConcat, strValueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th2) {
            fileWriter = null;
            th = th2;
        }
        try {
            com.bytedance.sdk.component.c.d.d dVar2 = this.hc;
            properties.put(".i.tt_ect", dVar2 != null ? String.valueOf(dVar2.d()) : "0");
            properties.store(fileWriter, (String) null);
            fileWriter.flush();
            try {
                fileWriter.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }
}
