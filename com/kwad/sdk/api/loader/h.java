package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.just.agentweb.AgentWebPermissions;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class h {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ab bss;
    private int currentNum;
    private String mCurrentUrl;
    private final String mUrl;

    public interface a {
        void a(a.b bVar);
    }

    h(ab abVar) {
        this.bss = abVar;
        String strWb = abVar.Wb();
        this.mUrl = strWb;
        this.mCurrentUrl = strWb;
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> mapBuildHeader = buildHeader();
            String strI = i(mapBuildHeader);
            HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(this.mCurrentUrl);
            setConnectionHeader(httpURLConnectionCreateUrlConnection, mapBuildHeader);
            httpURLConnectionCreateUrlConnection.connect();
            new DataOutputStream(httpURLConnectionCreateUrlConnection.getOutputStream()).write(strI.getBytes());
            int responseCode = httpURLConnectionCreateUrlConnection.getResponseCode();
            if (responseCode == 200) {
                String strInputStream2String = inputStream2String(httpURLConnectionCreateUrlConnection.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(strInputStream2String);
                String strOptString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(strOptString) && !ILogConst.CACHE_PLAY_REASON_NULL.equals(strOptString)) {
                    jSONObject.put("data", new JSONObject(this.bss.Wc().getRD(strOptString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else if (responseCode / 100 == 3) {
                if (this.currentNum < 21) {
                    this.mCurrentUrl = httpURLConnectionCreateUrlConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                    this.currentNum++;
                    a(aVar);
                }
            } else {
                throw new RuntimeException("response code = " + responseCode);
            }
            if (httpURLConnectionCreateUrlConnection != null) {
                try {
                    httpURLConnectionCreateUrlConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x004c */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String inputStream2String(java.io.InputStream r5) throws java.lang.Throwable {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L31
        La:
            int r3 = r5.read(r0)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L4b
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L4b
            goto La
        L16:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L4b
            if (r5 == 0) goto L24
            r5.close()     // Catch: java.io.IOException -> L20
            goto L24
        L20:
            r5 = move-exception
            r5.printStackTrace()
        L24:
            r2.close()     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r5 = move-exception
            r5.printStackTrace()
        L2c:
            return r0
        L2d:
            r0 = move-exception
            goto L33
        L2f:
            r0 = move-exception
            goto L4d
        L31:
            r0 = move-exception
            r2 = r1
        L33:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L40
            r5.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r5 = move-exception
            r5.printStackTrace()
        L40:
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.io.IOException -> L46
            goto L4a
        L46:
            r5 = move-exception
            r5.printStackTrace()
        L4a:
            return r1
        L4b:
            r0 = move-exception
            r1 = r2
        L4d:
            if (r5 == 0) goto L57
            r5.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r5 = move-exception
            r5.printStackTrace()
        L57:
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r5 = move-exception
            r5.printStackTrace()
        L61:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.h.inputStream2String(java.io.InputStream):java.lang.String");
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private String i(Map<String, String> map) {
        String strBj = i.bj(this.bss.getContext());
        if (TextUtils.isEmpty(strBj)) {
            strBj = this.bss.Wc().getSDKVersion();
        }
        int sDKVersionCode = this.bss.Wc().getSDKVersionCode();
        JSONObject appInfo = this.bss.Wc().getAppInfo();
        JSONObject deviceInfo = this.bss.Wc().getDeviceInfo();
        JSONObject networkInfo = this.bss.Wc().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        n.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        n.putValue(jSONObject, "sdkApiVersionCode", BuildConfig.VERSION_CODE);
        n.putValue(jSONObject, "sdkVersion", strBj);
        n.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        n.putValue(jSONObject, "sdkType", 2);
        n.putValue(jSONObject, "appInfo", appInfo);
        n.putValue(jSONObject, "deviceInfo", deviceInfo);
        n.putValue(jSONObject, "networkInfo", networkInfo);
        n.putValue(jSONObject, "sdkAbi", ac.PV());
        String string = jSONObject.toString();
        this.bss.Wc().addHp(map);
        JSONObject jSONObject2 = new JSONObject();
        n.putValue(jSONObject2, Config.INPUT_DEF_VERSION, BuildConfig.VERSION_NAME);
        n.putValue(jSONObject2, "appId", appInfo.optString("appId"));
        n.putValue(jSONObject2, cm.V, this.bss.Wc().getRM(string));
        this.bss.Wc().sR(this.mUrl, map, jSONObject2.toString());
        return jSONObject2.toString();
    }

    private static Map<String, String> buildHeader() {
        HashMap map = new HashMap();
        map.put("Accept-Language", "zh-CN");
        map.put("Connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "application/json; charset=UTF-8");
        map.put("User-Agent", RequestParamsUtils.getUserAgent());
        return map;
    }

    private static HttpURLConnection createUrlConnection(String str) throws ProtocolException, NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }
}
