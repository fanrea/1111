package com.bytedance.msdk.gb;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.cm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class fs {
    private static String b = null;
    private static String c = "ToolUtils";
    private static String d;
    private static String hc;

    public static synchronized String d() {
        if (TextUtils.isEmpty(d) && com.bytedance.msdk.core.hc.getContext() != null) {
            try {
                d = com.bytedance.msdk.core.hc.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.msdk.d.u.b.c(c, "ToolUtils getPackageName throws exception :" + th);
            }
        }
        return d;
    }

    public static synchronized String hc() {
        if (TextUtils.isEmpty(hc) && com.bytedance.msdk.core.hc.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.msdk.core.hc.getContext().getPackageManager().getPackageInfo(d(), 0);
                hc = String.valueOf(packageInfo.versionCode);
                b = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.msdk.d.u.b.c(c, "ToolUtils getVersionCode throws exception :" + th);
            }
        }
        return hc;
    }

    public static synchronized String b() {
        if (TextUtils.isEmpty(b) && com.bytedance.msdk.core.hc.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.msdk.core.hc.getContext().getPackageManager().getPackageInfo(d(), 0);
                hc = String.valueOf(packageInfo.versionCode);
                b = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.msdk.d.u.b.c(c, "ToolUtils getVersionName throws exception :" + th);
            }
        }
        return b;
    }

    public static String c() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(i.b);
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            strConcat = strConcat.substring(0, i).concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + i.b).concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return d.hc(str.substring(17), b(str.substring(1, 17)));
    }

    private static String b(String str) {
        String strD = d.d(str);
        if (str != null) {
            return strD;
        }
        String strD2 = hc.d();
        return strD2.concat(strD2).substring(8, 24);
    }

    public static String u() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return uo.d(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d(com.bytedance.sdk.component.tt.hc hcVar) {
        if (hcVar == null || !com.bytedance.sdk.component.tt.c.d.d(hcVar.b())) {
            return (hcVar == null || hcVar.c() == null || hcVar.c().startsWith("{") || hcVar.c().endsWith(i.d)) ? false : true;
        }
        return true;
    }

    public static String d(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    String strHc = com.bytedance.sdk.openadsdk.core.fs.mq.hc(com.bytedance.sdk.component.panglearmor.tt.d().hc(bArr));
                    if (TextUtils.isEmpty(strHc)) {
                        return null;
                    }
                    return strHc;
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return null;
    }

    public static byte[] hc(String str) {
        return com.bytedance.sdk.component.panglearmor.tt.d().d(c(str));
    }

    private static byte[] c(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.bytedance.sdk.component.utils.mq.d(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                com.bytedance.sdk.component.utils.mq.d(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            com.bytedance.sdk.component.utils.mq.d(e4);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static JSONObject d(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strD = d.d();
                String str = "2" + strD + d.d(jSONObject.toString(), d.d(strD));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put(cm.V, str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put(cm.V, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put(cm.V, jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }
}
