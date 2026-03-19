package com.baidu.enan.e.a.c;

import android.util.Base64;
import com.baidu.enan.f.b;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static final String[] a = {"L3N5c3RlbS94YmluL3N1", "L3N5c3RlbS9iaW4vc3U", "L3N5c3RlbS94YmluLy5zdQ==", "L3N5c3RlbS9iaW4vLnN1", "L3N5c3RlbS9iaW4vLnN1dg==", "L3N5c3RlbS94YmluLy5zdXY=", "L3N5c3RlbS94YmluL2Jkc3U=", "L3N5c3RlbS9iaW4vYmRzdQ==", "L3N5c3RlbS94YmluL2F1", "L3N5c3RlbS9iaW4vYXU=", "L3N5c3RlbS94YmluL2t1LnN1ZA==", "L3N5c3RlbS9iaW4va3Uuc3Vk", "L3N5c3RlbS9iaW4vLnJncw==", "L3N5c3RlbS94YmluLy5yZ3M=", "L3NiaW4vc3U="};

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            return b();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return jSONObject;
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 0;
            int i2 = 0;
            for (String str : a) {
                if (new File(new String(Base64.decode(str, 0))).exists()) {
                    jSONObject.put(Integer.toString(i2), "1");
                } else {
                    jSONObject.put(Integer.toString(i2), "0");
                }
                i2++;
            }
            try {
                File file = new File(new String(Base64.decode("L3NiaW5fb3JpZw==", 0)));
                if (file.exists() && file.isDirectory()) {
                    jSONObject.put(Integer.toString(i2), "0");
                    String[] list = file.list();
                    int length = list.length;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (list[i].startsWith("su")) {
                            jSONObject.put(Integer.toString(i2), "1");
                            break;
                        }
                        i++;
                    }
                } else {
                    jSONObject.put(Integer.toString(i2), "0");
                }
            } catch (Throwable th) {
                b.a(th);
            }
        } catch (Throwable th2) {
            b.a(th2);
        }
        return jSONObject;
    }
}
