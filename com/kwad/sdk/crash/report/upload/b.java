package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.pandora.common.Constants;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static void a(File file, String str, String str2, Map<String, String> map, a aVar) throws Throwable {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String string = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.aaw().ad("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + string);
                httpURLConnection.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.ii(file.getPath()), 2));
                httpURLConnection.setRequestProperty("file-type", "." + w.getExtension(file.getName()));
                httpURLConnection.setRequestProperty("origin-name", name);
                httpURLConnection.setRequestProperty(com.sigmob.sdk.base.e.b, "did=" + str);
                httpURLConnection.connect();
                outputStream = httpURLConnection.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), string));
                    }
                    bytes = ("\r\n--" + string + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(string);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                } catch (Exception e) {
                    e = e;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            outputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = dataInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    outputStream.write(bArr, 0, i2);
                }
            }
            outputStream.write("\r\n".getBytes());
            outputStream.write(bytes);
            outputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.bCq = responseCode;
            if (responseCode == 200) {
                cVar.bCs = h.inputStream2String(httpURLConnection.getInputStream());
                try {
                    int iOptInt = new JSONObject(cVar.bCs).optInt("result", -1);
                    if (iOptInt == 1) {
                        aVar.aeB();
                    } else {
                        e eVar = e.bOU;
                        new StringBuilder("result is ").append(iOptInt);
                        aVar.aeA();
                    }
                } catch (JSONException unused) {
                    e eVar2 = e.bOV;
                    e eVar3 = e.bOV;
                    aVar.aeA();
                }
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.bCs);
            } else {
                e eVar4 = e.bOT;
                new StringBuilder().append(e.bOT.Ox()).append(responseCode);
                aVar.aeA();
                com.kwad.sdk.core.network.idc.a.aaw().a(str3, cVar.code == 0 ? -1 : cVar.code, (Throwable) null);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
        } catch (Exception e4) {
            e = e4;
            httpURLConnection2 = httpURLConnection;
            try {
                e eVar5 = e.bOT;
                e.getCause();
                aVar.aeA();
                com.kwad.sdk.core.network.idc.a aVarAaw = com.kwad.sdk.core.network.idc.a.aaw();
                if (cVar.code != 0) {
                    i = cVar.code;
                }
                aVarAaw.a(str3, i, e);
                com.kwad.sdk.core.d.c.printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            } catch (Throwable th4) {
                th = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection2 = httpURLConnection;
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap map = new HashMap();
        if (fVar == null) {
            return map;
        }
        if (!TextUtils.isEmpty(fVar.bPd)) {
            map.put("uploadToken", fVar.bPd);
        }
        if (!TextUtils.isEmpty(fVar.bPa)) {
            map.put("sys", fVar.bPa);
        }
        if (!TextUtils.isEmpty(fVar.bOZ)) {
            map.put(Constants.APPLog.DEVICE_ID, fVar.bOZ);
        }
        if (!TextUtils.isEmpty(fVar.bOY)) {
            map.put(com.baidu.mobads.container.components.h.b.e.a, fVar.bOY);
        }
        if (!TextUtils.isEmpty(fVar.bNM)) {
            map.put("appver", fVar.bNM);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            map.put("taskId", fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.mToken)) {
            map.put(NetworkDefine.PARAM_TOKEN, fVar.mToken);
        }
        if (!TextUtils.isEmpty(fVar.aCf)) {
            map.put(Config.CUSTOM_USER_ID, fVar.aCf);
        }
        if (!TextUtils.isEmpty(fVar.bPb)) {
            map.put("extraInfo", fVar.bPb);
        }
        return map;
    }

    public static void a(File file, f fVar, a aVar) throws Throwable {
        a(file, fVar.bOZ, fVar.mToken, a(fVar), aVar);
    }
}
