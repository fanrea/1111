package com.bytedance.d.hc.gb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static void d(File file, String str, boolean z) throws Throwable {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            an.d(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            an.d(fileOutputStream2);
            throw th;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean d(File file) {
        return file.exists() && file.delete();
    }

    public static String d(String str, String str2) throws Throwable {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        an.d(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    an.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String hc(String str) throws IOException {
        return d(str, null);
    }

    public static com.bytedance.d.hc.b.b b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(hc(str));
            com.bytedance.d.hc.b.b bVar = new com.bytedance.d.hc.b.b();
            bVar.d(jSONObject.optString("url"));
            bVar.d(jSONObject.optJSONObject("body"));
            bVar.hc(jSONObject.optString("dump_file"));
            bVar.d(jSONObject.optBoolean("encrypt", false));
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return d(file, str, str2, jSONObject, null, z);
    }

    public static String d(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) throws Throwable {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            d(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.mq.d(e2);
        }
        return file2.getAbsolutePath();
    }

    public static void d(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append(" ");
            if (str == null) {
                str = ILogConst.CACHE_PLAY_REASON_NULL;
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(" ");
            if (str2 == null) {
                str2 = ILogConst.CACHE_PLAY_REASON_NULL;
            }
            d(gb.hc(context), sbAppend2.append(str2).append("\n").toString(), true);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
