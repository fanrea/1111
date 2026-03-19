package com.baidu.enan.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.enan.f.d;
import com.baidu.enan.f.e;
import com.baidu.mobstat.forbes.Config;
import java.net.URLEncoder;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends a {
    private String b;

    public c(Context context) {
        super(context);
        this.b = "";
        this.a = context;
    }

    private String a() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String strA = a(this.a);
        if (!TextUtils.isEmpty(strA)) {
            this.b = strA;
        }
        return this.b;
    }

    public static String a(String str, String str2, long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str).append(j).append(str2);
            return com.baidu.enan.b.c.a(sb.toString());
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return null;
        }
    }

    public static String a(Context context) {
        try {
            return new String(com.baidu.enan.b.b.c(Base64.decode(e.a, 0), "30212102dicudiab".getBytes()));
        } catch (Throwable th) {
            return "";
        }
    }

    private String a(String str, String str2) {
        String strA;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                strA = a("900300001", "70095dd399241e7fcfd78ce85b1fe3db", jCurrentTimeMillis);
            } catch (Throwable th) {
                com.baidu.enan.f.a.a(th);
                strA = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a()).append(str).append("/200").append("/900300001").append("/" + jCurrentTimeMillis).append("/" + strA).append("?skey=" + str2);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            com.baidu.enan.f.a.a(th2);
            return "";
        }
    }

    public int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        String strA = com.baidu.enan.f.c.a(this.a);
        try {
            byte[] bArrB = b();
            String strA2 = a(URLEncoder.encode(Base64.encodeToString(com.baidu.enan.b.b.d(bArrB, com.baidu.enan.b.c.a(strA).getBytes()), 0), "UTF-8"));
            if (!TextUtils.isEmpty(str)) {
                byte[] bArrA = a(bArrB, a(this.a, new JSONObject(str)));
                if (bArrA == null) {
                    return -1;
                }
                try {
                    String strA3 = a(strA2, bArrA);
                    if (TextUtils.isEmpty(strA3)) {
                        return -1;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(strA3);
                        jSONObject.optInt("request_id");
                        int iOptInt = jSONObject.optInt("error_code", 0);
                        jSONObject.optString("error_msg", "");
                        if (iOptInt == 0) {
                            com.baidu.enan.d.a.a(this.a).a(System.currentTimeMillis());
                        }
                        String strOptString = jSONObject.optString("data");
                        String strOptString2 = jSONObject.optString("skey");
                        try {
                            JSONObject jSONObject2 = new JSONObject(new String(com.baidu.enan.b.b.c(Base64.decode(strOptString.getBytes(), 0), com.baidu.enan.b.b.e(Base64.decode(strOptString2.getBytes(), 0), com.baidu.enan.b.c.a(strA).getBytes()))));
                            String strOptString3 = jSONObject2.optString("s1");
                            String strOptString4 = jSONObject2.optString(Config.SESSTION_TRACK_START_TIME);
                            String strOptString5 = jSONObject2.optString("s3");
                            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                                com.baidu.enan.a.a.a(this.a, strOptString3, strOptString4, strOptString5);
                            }
                            return 0;
                        } catch (Throwable th) {
                            com.baidu.enan.f.b.a(th);
                            return -1;
                        }
                    } catch (Throwable th2) {
                        com.baidu.enan.f.b.a(th2);
                        return -1;
                    }
                } catch (Throwable th3) {
                    com.baidu.enan.f.a.a(th3);
                }
            }
            return -1;
        } catch (Throwable th4) {
            return -1;
        }
    }

    public String a(String str) {
        return a("f/1/wm", str);
    }

    private byte[] a(byte[] bArr, String str) {
        byte[] bArrA = null;
        try {
            bArrA = d.a(str.getBytes("utf-8"));
            return com.baidu.enan.b.b.b(bArrA, bArr);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return bArrA;
        }
    }

    private static String a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("2", context.getPackageName());
            jSONObject2.put("4", com.baidu.enan.f.c.a(context));
            jSONObject2.put("5", "1072201");
            jSONObject2.put("6", String.valueOf(System.currentTimeMillis()));
            jSONObject2.put("14", com.baidu.enan.a.c.a());
            jSONObject2.put("module_section", new JSONArray().put(jSONObject));
            return jSONObject2.toString();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static byte[] b() {
        char[] cArr;
        try {
            cArr = new char[16];
        } catch (Throwable th) {
            th = th;
            cArr = null;
        }
        try {
            char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            for (int i = 0; i < 16; i++) {
                int iNextInt = new Random().nextInt(62);
                if (iNextInt >= 0 && iNextInt < charArray.length) {
                    cArr[i] = charArray[iNextInt];
                }
            }
        } catch (Throwable th2) {
            th = th2;
            com.baidu.enan.f.a.a(th);
            return new String(cArr).getBytes();
        }
        return new String(cArr).getBytes();
    }
}
