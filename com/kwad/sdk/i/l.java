package com.kwad.sdk.i;

import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int cfV;

    public interface a {
        void onSuccess();
    }

    l() {
    }

    public static void a(List<k> list, a aVar) {
        if (cfV > 10) {
            j.ar("LogReportUtil", "request error");
            return;
        }
        g gVarAlz = h.alv().alz();
        Map<String, String> requestHeader = gVarAlz.getRequestHeader();
        JSONObject jSONObjectAlu = gVarAlz.alu();
        c.putValue(jSONObjectAlu, "actionList", list);
        c.putValue(jSONObjectAlu, com.alipay.sdk.m.t.a.k, System.currentTimeMillis());
        a(gVarAlz.alt(), requestHeader, a(requestHeader, jSONObjectAlu), aVar);
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.alv().alz().als()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static String c(Map<String, String> map, String str) {
        g gVarAlz = h.alv().alz();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, Config.INPUT_DEF_VERSION, gVarAlz.getSdkVersion());
        c.putValue(jSONObject, "appId", gVarAlz.getAppId());
        c.putValue(jSONObject, cm.V, com.kwad.sdk.i.a.ax(str));
        com.kwad.sdk.i.a.a(gVarAlz.alt(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) throws Throwable {
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        OutputStream outputStream = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
            closeable = null;
        } catch (Throwable th) {
            th = th;
            closeable = null;
        }
        try {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setUseCaches(false);
            setConnectionHeader(httpURLConnection, map);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String strInputStream2String = inputStream2String(httpURLConnection.getInputStream());
                new StringBuilder("request response: ").append(strInputStream2String);
                j.alG();
                if (!TextUtils.isEmpty(strInputStream2String)) {
                    int iOptInt = new JSONObject(strInputStream2String).optInt("result");
                    if (iOptInt == 1) {
                        cfV = 0;
                        aVar.onSuccess();
                    } else {
                        cfV++;
                        new StringBuilder("request fail result: ").append(iOptInt);
                        j.alG();
                    }
                } else {
                    cfV++;
                    j.alG();
                }
            } else {
                cfV++;
                new StringBuilder("request fail: ").append(responseCode);
                j.alG();
            }
            j.closeQuietly(httpURLConnection);
            j.closeQuietly(outputStream);
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            try {
                cfV++;
                j.alF();
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(closeable);
            } catch (Throwable th2) {
                th = th2;
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            closeable = null;
            j.closeQuietly(httpURLConnection2);
            j.closeQuietly(closeable);
            throw th;
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static String d(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String strA = a(bufferedReader);
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            return strA;
        } catch (Throwable th4) {
            th = th4;
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    private static String a(Reader reader) throws Throwable {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int i = reader.read(cArr);
                if (i != -1) {
                    stringWriter.write(cArr, 0, i);
                } else {
                    String string = stringWriter.toString();
                    j.closeQuietly(reader);
                    j.closeQuietly(stringWriter);
                    return string;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j.closeQuietly(reader);
            j.closeQuietly(stringWriter);
            throw th;
        }
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            try {
                return d(inputStream);
            } catch (IOException unused) {
                j.alF();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }
}
