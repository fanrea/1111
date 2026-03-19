package com.alliance.ssp.ad.d0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.deviceinfolib.DeviceInfoManager;
import com.alliance.ssp.ad.manager.SensitiveInfoManager;
import com.alliance.ssp.ad.o0.i;
import com.alliance.ssp.ad.o0.l;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.dhylive.app.utils.JumpParam;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SAAllianceAdConsoleMessageManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public HashMap<String, Object> a = null;
    public JSONObject b = new JSONObject();
    public static HashMap<String, Integer> c = new HashMap<>();
    public static long d = 0;
    public static long e = 0;
    public static long f = 0;
    public static long g = 0;
    public static long h = 0;
    public static long i = 0;
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q = "";
    public static String r = "";
    public static String s = "";
    public static String t = "";
    public static String u = "";
    public static String v = "0";
    public static String w = "";
    public static String x = "";
    public static String y = "";
    public static String z = "";
    public static String A = "";
    public static String B = "";
    public static String C = "";

    /* compiled from: SAAllianceAdConsoleMessageManager.java */
    public class a implements Runnable {
        public final /* synthetic */ String[] a;

        public a(f fVar, String[] strArr) {
            this.a = strArr;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, IOException {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://jp.ad.gameley.com/stat/ikanstat/adnlog").openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setReadTimeout(3000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cipher", this.a[0]);
                jSONObject.put("encryptParams", this.a[1]);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();
                bufferedOutputStream.close();
                httpURLConnection.getResponseCode();
                int i = l.a;
                httpURLConnection.disconnect();
            } catch (Exception e) {
                e.getMessage();
                f.a(e);
                int i2 = l.a;
            }
        }
    }

    public static f b() {
        return new f();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(4:(1:4)(16:(1:9)|10|42|11|(1:13)|14|(1:20)|(1:23)|24|38|25|(1:27)|28|40|32|44)|40|32|44)|8|10|42|11|(0)|14|(2:18|20)|(1:23)|24|38|25|(0)|28|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:0|2|(1:4)(16:(1:9)|10|42|11|(1:13)|14|(1:20)|(1:23)|24|38|25|(1:27)|28|40|32|44)|8|10|42|11|(0)|14|(2:18|20)|(1:23)|24|38|25|(0)|28|40|32|44|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
    
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(r0, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 001: ")), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[Catch: Exception -> 0x0092, TryCatch #2 {Exception -> 0x0092, blocks: (B:11:0x0035, B:13:0x0039, B:14:0x0040, B:18:0x004e, B:20:0x0054, B:23:0x0060, B:24:0x0069, B:28:0x007f), top: B:42:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074 A[Catch: Exception -> 0x007f, TRY_LEAVE, TryCatch #0 {Exception -> 0x007f, blocks: (B:25:0x0070, B:27:0x0074), top: B:38:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r15, int r16, java.lang.String r17, java.lang.String r18) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            r14 = this;
            r7 = r14
            r0 = r15
            r8 = r16
            r9 = r18
            java.lang.String r10 = ""
            long r1 = java.lang.System.currentTimeMillis()
            r11 = 1
            r12 = 2
            if (r8 != 0) goto L13
            com.alliance.ssp.ad.d0.f.d = r1
            goto L18
        L13:
            if (r8 == r11) goto L1b
            if (r8 != r12) goto L18
            goto L1b
        L18:
            r3 = 0
            goto L22
        L1b:
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = com.alliance.ssp.ad.d0.f.d
            long r3 = r3 - r5
        L22:
            java.lang.String r5 = java.lang.String.valueOf(r1)
            java.lang.String r6 = java.lang.String.valueOf(r3)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r5
            r5 = r6
            r6 = r13
            r1.a(r2, r3, r4, r5, r6)
            org.json.JSONObject r1 = r7.b     // Catch: java.lang.Exception -> L92
            if (r1 != 0) goto L40
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L92
            r1.<init>()     // Catch: java.lang.Exception -> L92
            r7.b = r1     // Catch: java.lang.Exception -> L92
        L40:
            org.json.JSONObject r1 = r7.b     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = "stage"
            r1.put(r2, r11)     // Catch: java.lang.Exception -> L92
            if (r0 != 0) goto L5c
            if (r8 != r12) goto L5c
            if (r9 == 0) goto L5c
            boolean r1 = r18.isEmpty()     // Catch: java.lang.Exception -> L92
            if (r1 != 0) goto L5c
            org.json.JSONObject r1 = r7.b     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = "sdkecode"
            r1.put(r2, r9)     // Catch: java.lang.Exception -> L92
        L5c:
            if (r0 != r12) goto L69
            if (r8 != 0) goto L69
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r7.a     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "installedapplist"
            r2 = r17
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L92
        L69:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L92
            r0.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "initParams"
            com.alliance.ssp.ad.api.SAAllianceAdInitParams r2 = com.alliance.ssp.ad.manager.SensitiveInfoManager.t     // Catch: java.lang.Exception -> L7f
            if (r2 == 0) goto L7f
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L7f
            r2.<init>()     // Catch: java.lang.Exception -> L7f
            com.alliance.ssp.ad.api.SAAllianceAdInitParams r3 = com.alliance.ssp.ad.manager.SensitiveInfoManager.t     // Catch: java.lang.Exception -> L7f
            java.lang.String r10 = r2.toJson(r3)     // Catch: java.lang.Exception -> L7f
        L7f:
            r0.put(r1, r10)     // Catch: java.lang.Exception -> L92
            r1 = 0
            r14.a(r0, r1)     // Catch: java.lang.Exception -> L92
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r7.a     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = "ext"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L92
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L92
            goto Laa
        L92:
            r0 = move-exception
            r13 = r0
            com.alliance.ssp.ad.d0.f r8 = new com.alliance.ssp.ad.d0.f
            r8.<init>()
            java.lang.String r0 = "SAAllianceAdConsoleMessageManager 001: "
            java.lang.StringBuilder r0 = com.alliance.ssp.ad.a.b.a(r0)
            java.lang.String r12 = com.alliance.ssp.ad.a.a.a(r13, r0)
            r9 = 0
            r10 = 0
            java.lang.String r11 = "004"
            r8.a(r9, r10, r11, r12, r13)
        Laa:
            r14.a()     // Catch: java.lang.Exception -> Lae
            goto Lc6
        Lae:
            r0 = move-exception
            r5 = r0
            com.alliance.ssp.ad.d0.f r0 = new com.alliance.ssp.ad.d0.f
            r0.<init>()
            java.lang.String r1 = "SAAllianceAdConsoleMessageManager 002: "
            java.lang.StringBuilder r1 = com.alliance.ssp.ad.a.b.a(r1)
            java.lang.String r4 = com.alliance.ssp.ad.a.a.a(r5, r1)
            r1 = 0
            r2 = 0
            java.lang.String r3 = "004"
            r0.a(r1, r2, r3, r4, r5)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.d0.f.a(int, int, java.lang.String, java.lang.String):void");
    }

    public static String b(Context context) {
        String property;
        String str = l;
        if (str != null && !str.isEmpty()) {
            return l;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                property = WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
                property = System.getProperty("http.agent");
            }
        } else {
            property = System.getProperty("http.agent");
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = property.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        l = property;
        return stringBuffer.toString();
    }

    public void a(int i2, int i3, Integer num, String str, int i4) throws JSONException, PackageManager.NameNotFoundException, IOException {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (i2 == 0 && i3 == 0) {
            e = jCurrentTimeMillis2;
            jCurrentTimeMillis = 0;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis() - e;
        }
        a(i2, i3, String.valueOf(jCurrentTimeMillis2), String.valueOf(jCurrentTimeMillis), (SAAllianceAdData) null);
        try {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put("stage", 2);
            JSONObject jSONObject = new JSONObject();
            if ((i2 == 1 && i3 == 0) || (i2 == 1 && i3 == 1)) {
                if (str != null && !str.isEmpty()) {
                    jSONObject.put("applist", str);
                }
                if (num != null) {
                    jSONObject.put("pkgGetOpen", num);
                }
            } else if (i2 == 1 && i3 == 2) {
                jSONObject.put("responseCode", i4);
            }
            a(jSONObject, (String) null);
            this.a.put("ext", jSONObject.toString());
        } catch (Exception e2) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 030: ")), e2);
        }
        try {
            a();
        } catch (Exception e3) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 031: ")), e3);
        }
    }

    public void a(int i2, int i3, SAAllianceAdData sAAllianceAdData, String str, String str2, String str3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(i2, i3, sAAllianceAdData, str, str2, str3, "", -1, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(4:(1:(16:(1:12)(1:(1:16))|13|18|73|19|(1:21)|22|23|(1:28)|(3:31|(1:38)(1:37)|39)|40|(5:42|43|(3:48|(1:53)(1:52)|54)(1:47)|(3:57|(1:59)|60)|61)|62|71|66|75)(1:10))(2:5|(1:7))|71|66|75)|17|18|73|19|(0)|22|23|(5:28|(2:31|(3:33|38|39)(0))|40|(0)|62)(5:28|(0)|40|(0)|62)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01aa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ab, code lost:
    
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(r0, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 005: ")), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[Catch: Exception -> 0x01aa, TryCatch #1 {Exception -> 0x01aa, blocks: (B:19:0x004f, B:21:0x0053, B:22:0x005a, B:28:0x007a, B:31:0x0093, B:33:0x009a, B:35:0x00a0, B:37:0x00aa, B:39:0x00b1, B:38:0x00af, B:40:0x00b4, B:42:0x00bb, B:45:0x0155, B:47:0x015b, B:61:0x018e, B:57:0x0179, B:59:0x0184, B:60:0x0188, B:48:0x0161, B:50:0x0165, B:52:0x016b, B:54:0x0172, B:62:0x019b), top: B:73:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: Exception -> 0x01aa, TryCatch #1 {Exception -> 0x01aa, blocks: (B:19:0x004f, B:21:0x0053, B:22:0x005a, B:28:0x007a, B:31:0x0093, B:33:0x009a, B:35:0x00a0, B:37:0x00aa, B:39:0x00b1, B:38:0x00af, B:40:0x00b4, B:42:0x00bb, B:45:0x0155, B:47:0x015b, B:61:0x018e, B:57:0x0179, B:59:0x0184, B:60:0x0188, B:48:0x0161, B:50:0x0165, B:52:0x016b, B:54:0x0172, B:62:0x019b), top: B:73:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: Exception -> 0x01aa, TRY_LEAVE, TryCatch #1 {Exception -> 0x01aa, blocks: (B:19:0x004f, B:21:0x0053, B:22:0x005a, B:28:0x007a, B:31:0x0093, B:33:0x009a, B:35:0x00a0, B:37:0x00aa, B:39:0x00b1, B:38:0x00af, B:40:0x00b4, B:42:0x00bb, B:45:0x0155, B:47:0x015b, B:61:0x018e, B:57:0x0179, B:59:0x0184, B:60:0x0188, B:48:0x0161, B:50:0x0165, B:52:0x016b, B:54:0x0172, B:62:0x019b), top: B:73:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r14, int r15, com.alliance.ssp.ad.bean.SAAllianceAdData r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, com.alliance.ssp.ad.api.SAAllianceAdParams r22) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.d0.f.a(int, int, com.alliance.ssp.ad.bean.SAAllianceAdData, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.alliance.ssp.ad.api.SAAllianceAdParams):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(4:(2:6|(13:10|(1:(1:17))(1:13)|14|19|53|20|(1:22)|23|(6:25|26|(3:31|(1:36)(1:35)|37)(1:30)|38|(1:40)|41)|42|51|46|55)(1:9))(1:5)|51|46|55)|18|19|53|20|(0)|23|(0)|42|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01a3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01a4, code lost:
    
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(r0, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 007: ")), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[Catch: Exception -> 0x01a3, TryCatch #1 {Exception -> 0x01a3, blocks: (B:20:0x004b, B:22:0x004f, B:23:0x0056, B:25:0x00b2, B:28:0x0150, B:30:0x0156, B:38:0x0170, B:40:0x017b, B:41:0x017f, B:31:0x015c, B:33:0x0160, B:35:0x0166, B:37:0x016d, B:42:0x0194), top: B:53:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2 A[Catch: Exception -> 0x01a3, TRY_LEAVE, TryCatch #1 {Exception -> 0x01a3, blocks: (B:20:0x004b, B:22:0x004f, B:23:0x0056, B:25:0x00b2, B:28:0x0150, B:30:0x0156, B:38:0x0170, B:40:0x017b, B:41:0x017f, B:31:0x015c, B:33:0x0160, B:35:0x0166, B:37:0x016d, B:42:0x0194), top: B:53:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r14, int r15, com.alliance.ssp.ad.bean.SAAllianceAdData r16, java.lang.String r17, int r18, java.lang.String r19, java.lang.String r20) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.d0.f.a(int, int, com.alliance.ssp.ad.bean.SAAllianceAdData, java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    public void a(int i2, int i3, SAAllianceAdData sAAllianceAdData, String str, float f2, int i4, int i5, int i6) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(i2, i3, String.valueOf(System.currentTimeMillis()), String.valueOf(0L), sAAllianceAdData);
        try {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put("stage", 6);
            this.a.put("crequestid", str);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                this.a.put("sposid", sAAllianceAdData.getSposid());
                this.a.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                this.a.put("sposprice", sAAllianceAdData.getAdtype());
                this.a.put("adtesting", sAAllianceAdData.getIstesting());
                this.a.put("payload", sAAllianceAdData.getPayload());
                this.a.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                this.a.put("aecpm", a(sAAllianceAdData.getPrice()));
                Material material = sAAllianceAdData.getMaterial();
                if (material != null) {
                    this.a.put("ldptype", Integer.valueOf(material.getLdptype()));
                    this.a.put("deeplink", material.getDeeplink());
                    this.a.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, material.getDesc());
                    this.a.put("ldp", material.getLdp());
                    String str2 = "";
                    this.a.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                    String videourl = material.getVideourl();
                    List<String> imgurl = material.getImgurl();
                    if (videourl != null && !TextUtils.isEmpty(videourl)) {
                        this.a.put("murl", videourl);
                    } else {
                        HashMap<String, Object> map = this.a;
                        if (imgurl != null && !imgurl.isEmpty()) {
                            str2 = imgurl.get(0);
                        }
                        map.put("murl", str2);
                    }
                }
                this.a.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                a(jSONObject, sAAllianceAdData);
                jSONObject.put("bidding_ecmp", f2);
                jSONObject.put("bidding_currency", i4);
                jSONObject.put("bidding_type", i5);
                if (i3 == 2) {
                    jSONObject.put("bidding_reason", i6);
                }
            }
            a(jSONObject, str);
            this.a.put("ext", jSONObject.toString());
        } catch (Exception e2) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 005: ")), e2);
        }
        try {
            a();
        } catch (Exception e3) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 006: ")), e3);
        }
    }

    public void a(int i2, int i3, SAAllianceAdData sAAllianceAdData, String str) throws JSONException, PackageManager.NameNotFoundException, IOException {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (i2 == 0) {
            h = jCurrentTimeMillis2;
            jCurrentTimeMillis = 0;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis() - h;
        }
        a(i2, i3, String.valueOf(jCurrentTimeMillis2), String.valueOf(jCurrentTimeMillis), sAAllianceAdData);
        try {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put("stage", 7);
            this.a.put("crequestid", str);
            JSONObject jSONObject = new JSONObject();
            if (sAAllianceAdData != null) {
                this.a.put("sposprice", sAAllianceAdData.getAdtype());
                this.a.put("adtesting", sAAllianceAdData.getIstesting());
                this.a.put("payload", sAAllianceAdData.getPayload());
                this.a.put("sposid", sAAllianceAdData.getSposid());
                this.a.put("spostype", Integer.valueOf(sAAllianceAdData.getSpostype()));
                this.a.put("restype", Integer.valueOf(sAAllianceAdData.getRestype()));
                this.a.put("aecpm", a(sAAllianceAdData.getPrice()));
                Material material = sAAllianceAdData.getMaterial();
                if (material != null) {
                    this.a.put("ldptype", Integer.valueOf(material.getLdptype()));
                    this.a.put("deeplink", material.getDeeplink());
                    this.a.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, material.getDesc());
                    this.a.put("ldp", material.getLdp());
                    String videourl = material.getVideourl();
                    List<String> imgurl = material.getImgurl();
                    if (videourl != null && !TextUtils.isEmpty(videourl)) {
                        this.a.put("murl", videourl);
                    } else {
                        this.a.put("murl", (imgurl == null || imgurl.isEmpty()) ? "" : imgurl.get(0));
                    }
                    this.a.put("tempid", material.getTempid() != null ? material.getTempid() : "");
                } else {
                    int i4 = l.a;
                }
                this.a.put("loadtype", Integer.valueOf(sAAllianceAdData.getLoadtype()));
                a(jSONObject, sAAllianceAdData);
            } else {
                int i5 = l.a;
            }
            a(jSONObject, str);
            this.a.put("ext", jSONObject.toString());
        } catch (Exception e2) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 011: ")), e2);
        }
        try {
            a();
        } catch (Exception e3) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e3, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 012: ")), e3);
        }
    }

    public final String a(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return "" + (Float.parseFloat(str) / 100.0f);
            } catch (Exception unused) {
                int i2 = l.a;
            }
        }
        return "0";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(4:(12:(0)(1:8)|10|106|11|(1:13)|14|(1:17)|18|(3:20|(9:22|23|(3:28|(1:33)(1:32)|34)(1:27)|35|36|(1:(2:60|(1:(3:98|77|(2:79|(1:81))))(4:104|63|(1:69)|70))(1:(2:102|55)))(4:108|39|(1:45)|46)|85|(1:87)|88)|89)|100|93|110)(1:5)|100|93|110)|9|10|106|11|(0)|14|(1:17)|18|(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02d4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02d5, code lost:
    
        new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(r0, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 013: ")), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[Catch: Exception -> 0x02d4, TryCatch #4 {Exception -> 0x02d4, blocks: (B:11:0x003e, B:13:0x0042, B:14:0x0049, B:17:0x0057, B:18:0x006a, B:20:0x0078, B:22:0x00dc, B:25:0x011a, B:27:0x0120, B:35:0x013a, B:85:0x02a4, B:87:0x02af, B:88:0x02b3, B:49:0x01d4, B:58:0x01e8, B:73:0x0275, B:84:0x02a1, B:28:0x0126, B:30:0x012a, B:32:0x0130, B:34:0x0137, B:89:0x02b6, B:77:0x027d, B:79:0x0284, B:81:0x0295, B:55:0x01e0, B:63:0x01f3, B:65:0x01fc, B:67:0x0202, B:69:0x020c, B:70:0x026c, B:39:0x0151, B:41:0x015a, B:43:0x0160, B:45:0x016a, B:46:0x01ca), top: B:106:0x003e, inners: #0, #2, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078 A[Catch: Exception -> 0x02d4, TryCatch #4 {Exception -> 0x02d4, blocks: (B:11:0x003e, B:13:0x0042, B:14:0x0049, B:17:0x0057, B:18:0x006a, B:20:0x0078, B:22:0x00dc, B:25:0x011a, B:27:0x0120, B:35:0x013a, B:85:0x02a4, B:87:0x02af, B:88:0x02b3, B:49:0x01d4, B:58:0x01e8, B:73:0x0275, B:84:0x02a1, B:28:0x0126, B:30:0x012a, B:32:0x0130, B:34:0x0137, B:89:0x02b6, B:77:0x027d, B:79:0x0284, B:81:0x0295, B:55:0x01e0, B:63:0x01f3, B:65:0x01fc, B:67:0x0202, B:69:0x020c, B:70:0x026c, B:39:0x0151, B:41:0x015a, B:43:0x0160, B:45:0x016a, B:46:0x01ca), top: B:106:0x003e, inners: #0, #2, #3, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r17, int r18, com.alliance.ssp.ad.bean.SAAllianceAdData r19, java.lang.String r20, java.lang.String r21, int r22) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.d0.f.a(int, int, com.alliance.ssp.ad.bean.SAAllianceAdData, java.lang.String, java.lang.String, int):void");
    }

    public void a(int i2, int i3, String str, String str2, Exception exc) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(i2, i3, String.valueOf(System.currentTimeMillis()), "", (SAAllianceAdData) null);
        try {
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put("stage", 10);
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, (String) null);
            this.a.put("ext", jSONObject.toString());
        } catch (Exception e2) {
            e2.getMessage();
            a(e2);
            int i4 = l.a;
        }
        try {
            this.b.put("sdkecode", str);
            if (exc != null) {
                this.b.put("errmsg", str2 + "\nstackTrace info =\n" + a(exc));
            } else {
                this.b.put("errmsg", str2);
            }
            a();
        } catch (Exception e3) {
            e3.getMessage();
            a(e3);
            int i5 = l.a;
        }
    }

    public final void a(JSONObject jSONObject, SAAllianceAdData sAAllianceAdData) throws JSONException, IOException {
        try {
            jSONObject.put("tagName", sAAllianceAdData.getTagName());
            jSONObject.put("tagVer", sAAllianceAdData.getTagVer());
            jSONObject.put("tagCode", sAAllianceAdData.getTagCode());
            if (sAAllianceAdData.getInteraction() != null) {
                jSONObject.put("clickArea", sAAllianceAdData.getInteraction().clickArea);
            }
            if (sAAllianceAdData.getParentCrequestid() != null && !sAAllianceAdData.getParentCrequestid().isEmpty()) {
                jSONObject.put("parentCrequestid", sAAllianceAdData.getParentCrequestid());
            }
            if (sAAllianceAdData.getSpostype() == 6 && sAAllianceAdData.getMaterial() != null) {
                jSONObject.put("rewardVerifyDuration", sAAllianceAdData.getMaterial().getDuration());
            }
            if (sAAllianceAdData.getValidExposeTime() != 0.0f) {
                jSONObject.put("validExposeTime", sAAllianceAdData.getValidExposeTime());
            }
        } catch (Exception e2) {
            e2.getMessage();
            a(e2);
            int i2 = l.a;
        }
    }

    public final void a(JSONObject jSONObject, String str) throws JSONException, IOException {
        HashMap<String, Integer> map;
        try {
            jSONObject.put("enablePersonalized", SensitiveInfoManager.p ? "0" : "1");
            if (str == null || (map = c) == null || !map.containsKey(str)) {
                return;
            }
            Integer num = c.get(str);
            jSONObject.put("tolerateTimeout", String.valueOf(num != null ? num.intValue() : 0));
        } catch (Exception e2) {
            e2.getMessage();
            a(e2);
            int i2 = l.a;
        }
    }

    public final void a(int i2, int i3, String str, String str2, SAAllianceAdData sAAllianceAdData) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        if (this.b == null) {
            this.b = new JSONObject();
        }
        try {
            Context contextA = b.b().a();
            if (contextA != null && SAAllianceAdParams.Screen_Width == 0) {
                DisplayMetrics displayMetrics = contextA.getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                SAAllianceAdParams.Screen_Width = i4;
                SAAllianceAdParams.Screen_Height = i5;
            }
            try {
                this.b.put("status", i2);
                this.b.put("ecode", i3);
            } catch (JSONException e2) {
                e2.getMessage();
                a(e2);
                int i6 = l.a;
            }
            this.a.put("oaid", SensitiveInfoManager.g());
            SAAllianceAdParams.__LEMON__IMEI__VALUE = SensitiveInfoManager.c();
            SAAllianceAdParams.__LEMON__ANDROIDID__VALUE = SensitiveInfoManager.a();
            String str3 = SensitiveInfoManager.f;
            int i7 = l.a;
            SAAllianceAdParams.__LEMON__MAC__VALUE = str3;
            this.a.put("carrier", SensitiveInfoManager.b());
            double[] dArrE = SensitiveInfoManager.e();
            if (dArrE != null && dArrE.length >= 2) {
                this.a.put("geo", dArrE[0] + "," + dArrE[1]);
                SAAllianceAdParams.__LEMON__GPS_LAT__VALUE = "" + dArrE[0];
                SAAllianceAdParams.__LEMON__GPS_LON__VALUE = "" + dArrE[1];
            }
            this.a.put("connectiontype", Integer.valueOf(SensitiveInfoManager.i));
            this.a.put("ip", SensitiveInfoManager.g);
            this.a.put("ipv6", SensitiveInfoManager.h);
            this.a.put(com.baidu.mobads.container.adrequest.g.z, SAAllianceAdParams.__LEMON__IMEI__VALUE);
            this.a.put("androidid", SAAllianceAdParams.__LEMON__ANDROIDID__VALUE);
            this.a.put(com.baidu.mobads.container.adrequest.g.w, SAAllianceAdParams.__LEMON__MAC__VALUE);
            this.a.put("cookieid", i.e(contextA));
            this.a.put("onetime", i.i(contextA));
            this.a.put("isnew", Integer.valueOf(i.l(contextA)));
            this.a.put("make", i.b());
            this.a.put("brand", i.a());
            this.a.put("model", i.d());
            this.a.put("platform", 2);
            this.a.put("os", "Android");
            this.a.put("osv", i.e());
            this.a.put("ua", b(contextA));
            this.a.put("resolution", i.j(contextA));
            this.a.put("ltime", m);
            this.a.put("lgid", i.c());
            this.a.put("ver", i.c(contextA));
            this.a.put("sdkver", i.f());
            this.a.put("gid", i.d(contextA));
            this.a.put("cgid", "0");
            this.a.put("apppackage", i.a(contextA));
            this.a.put("appid", i.a);
            this.a.put("itime", str);
            this.a.put("dtime", str2);
            this.a.put("sysid", "5");
            this.a.put("idfa", "");
            this.a.put("idfastatus", "0");
            this.a.put("birthtime", x);
            this.a.put("countrycode", DeviceInfoManager.a(contextA));
            this.a.put("secondsfromgmt", DeviceInfoManager.a());
            this.a.put("hwmodel", Build.HARDWARE);
            this.a.put("fulllanguage", DeviceInfoManager.c(contextA));
            this.a.put("adHeight", y);
            this.a.put("adWidth", z);
            this.a.put("count", A);
            this.a.put("appstoreversion", i.b(contextA));
            this.a.put("bootmark", b.c);
            this.a.put("boottime", k);
            this.a.put("dpi", s);
            this.a.put("ppi", u);
            this.a.put("density", t);
            this.a.put("devicename", i.f(contextA));
            this.a.put("devicetype", a(contextA));
            this.a.put("disk", p);
            if (contextA != null) {
                try {
                    PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                    if (packageInfo != null) {
                        this.a.put("hmsversion", packageInfo.versionName);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    this.a.put("hmsversion", "");
                }
            }
            this.a.put("installTime", n);
            this.a.put("language", o);
            this.a.put("memory", q);
            this.a.put("orientation", v);
            this.a.put("osupdatetime", w);
            this.a.put("startuptime", j);
            this.a.put("timezone", r);
            this.a.put("updatemark", b.d);
            this.a.put("hmsCoreVer", i.h(contextA));
            this.a.put("hmsAGVerCode", i.g(contextA));
            this.a.put(JumpParam.USER_ID, (sAAllianceAdData == null || sAAllianceAdData.getUserId() == null || sAAllianceAdData.getUserId().isEmpty()) ? B : sAAllianceAdData.getUserId());
        } catch (Exception e3) {
            e3.getMessage();
            a(e3);
            int i8 = l.a;
        }
    }

    public static String a(Exception exc) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        exc.printStackTrace(new PrintStream(byteArrayOutputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        String str = null;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str = str + line + "\n";
            } catch (IOException e2) {
                e2.getMessage();
                int i2 = l.a;
            }
        }
        bufferedReader.close();
        return str;
    }

    public final void a(int i2, int i3, int i4, Map<String, Object> map) {
        String str = "state : " + i2 + " " + i3 + " " + i4 + "\nreportParams : \n";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            str = str + com.alliance.ssp.ad.a.b.a("  | ").append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n").toString();
        }
        int i5 = l.a;
    }

    public final void a() throws JSONException, IOException {
        HashMap<String, Object> map = this.a;
        if (map != null && !map.isEmpty()) {
            this.a.put(com.alipay.sdk.m.p0.b.d, this.b.toString());
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.a.entrySet()) {
                if (entry.getValue() != null) {
                    if (sb.length() > 0) {
                        sb.append(com.alipay.sdk.m.s.a.n);
                    }
                    String strTrim = entry.getValue().toString().trim();
                    try {
                        strTrim = URLEncoder.encode(strTrim, "utf-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.getMessage();
                        a(e2);
                        int i2 = l.a;
                    }
                    sb.append(entry.getKey().trim()).append("=").append(strTrim);
                }
            }
            try {
                if (this.b.has("sdkecode")) {
                    new StringBuilder().append("").append(this.b.get("sdkecode"));
                }
                if (this.b.has("errmsg")) {
                    new StringBuilder().append("").append(this.b.get("errmsg"));
                }
                a(this.b.getInt("stage"), this.b.getInt("status"), this.b.getInt("ecode"), this.a);
                Objects.toString(this.a.get("crequestid"));
                this.b.getInt("stage");
                this.b.getInt("status");
                this.b.getInt("ecode");
                Objects.toString(this.a.get("dtime"));
                int i3 = l.a;
            } catch (JSONException e3) {
                e3.getMessage();
                a(e3);
                int i4 = l.a;
            }
            HashMap<String, Object> map2 = this.a;
            if (map2 != null) {
                map2.clear();
            }
            if (this.b != null) {
                this.b = null;
            }
            String[] strArrB = com.alliance.ssp.ad.o.e.b(sb.toString());
            if (strArrB.length == 2) {
                new Thread(new a(this, strArrB)).start();
                return;
            }
            return;
        }
        int i5 = l.a;
    }

    public static String a(Context context) {
        String str = C;
        if (str != null && !str.isEmpty()) {
            return C;
        }
        String strB = b(context);
        if (strB != null && !strB.isEmpty()) {
            if (strB.contains("Windows")) {
                C = "2";
                return "2";
            }
            if (strB.contains("TV")) {
                C = "3";
                return "3";
            }
            if (strB.contains("Mobile")) {
                C = "4";
                return "4";
            }
            if (strB.contains("Tablet") || strB.contains("PlayBook")) {
                C = "5";
                return "5";
            }
        }
        C = "4";
        return "4";
    }
}
