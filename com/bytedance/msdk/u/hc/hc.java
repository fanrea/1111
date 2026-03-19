package com.bytedance.msdk.u.hc;

import android.os.SystemClock;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.util.cm;
import com.bytedance.msdk.d.u.b;
import com.bytedance.msdk.gb.e;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.v;
import com.bytedance.msdk.gb.zw;
import com.bytedance.msdk.u.u;
import com.bytedance.sdk.component.panglearmor.tt;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d<com.bytedance.msdk.u.d> {
    public static volatile boolean d = false;
    private static volatile boolean hc = true;
    private int b = 0;
    private int c = 0;

    @Override // com.bytedance.msdk.u.hc.d
    public boolean d() {
        return !com.bytedance.msdk.core.hc.hc().hc() && tt.hc();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.u.u d(java.lang.String r4, byte[] r5, boolean r6) {
        /*
            r3 = this;
            com.bytedance.msdk.c.hc r0 = com.bytedance.msdk.c.hc.d()
            com.bytedance.sdk.component.tt.d r0 = r0.hc()
            com.bytedance.sdk.component.tt.hc.u r0 = r0.hc()
            r0.d(r4)
            com.bytedance.msdk.core.d r4 = com.bytedance.msdk.core.d.mk()
            java.lang.String r4 = r4.gb()
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L29
            java.lang.String r1 = "X-Tt-Env"
            r0.hc(r1, r4)
            java.lang.String r4 = "x-use-ppe"
            java.lang.String r1 = "1"
            r0.hc(r4, r1)
        L29:
            if (r6 == 0) goto L3c
            java.lang.String r4 = "x-pglcypher"
            java.lang.String r6 = "4"
            r0.hc(r4, r6)
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "union_sdk_encode"
            r0.hc(r4, r6)
            java.lang.String r4 = "application/octet-stream"
            goto L3e
        L3c:
            java.lang.String r4 = "application/octet-stream;tt-data=a"
        L3e:
            java.lang.String r6 = com.bytedance.msdk.hc.hc.d
            java.lang.String r1 = "User-Agent"
            r0.hc(r1, r6)
            r0.d(r4, r5)
            com.bytedance.sdk.component.tt.hc r4 = r0.d()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L9b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L61
            java.lang.String r1 = r4.c()     // Catch: org.json.JSONException -> L61
            r0.<init>(r1)     // Catch: org.json.JSONException -> L61
            boolean r0 = r3.d(r0)     // Catch: org.json.JSONException -> L61
            if (r0 == 0) goto L9b
            r0 = r5
            goto L9c
        L61:
            r0 = move-exception
            int r1 = r3.c
            int r2 = r1 + 1
            r3.c = r2
            r2 = 20
            if (r1 >= r2) goto L80
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "exception: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "doUploadApplogAdEvent"
            d(r2, r1)
        L80:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ignore:"
            r1.<init>(r2)
            java.lang.String r2 = r0.toString()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "uploadEvent"
            com.bytedance.msdk.d.u.b.c(r2, r1)
            com.bytedance.sdk.component.utils.mq.d(r0)
        L9b:
            r0 = r6
        L9c:
            if (r4 == 0) goto La3
            int r1 = r4.d()
            goto La4
        La3:
            r1 = r6
        La4:
            if (r0 != 0) goto Lad
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto Lad
            java.lang.String r4 = "server say not success"
            goto Ld6
        Lad:
            if (r4 == 0) goto Ld3
            java.lang.String r5 = r4.hc()
            if (r0 != 0) goto Ld1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r5 = r2.append(r5)
            java.lang.String r2 = "::"
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r4 = r4.c()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            goto Ld5
        Ld1:
            r4 = r5
            goto Ld5
        Ld3:
            java.lang.String r4 = "error unknown"
        Ld5:
            r5 = r6
        Ld6:
            com.bytedance.msdk.u.u r6 = new com.bytedance.msdk.u.u
            r6.<init>(r0, r1, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.u.hc.hc.d(java.lang.String, byte[], boolean):com.bytedance.msdk.u.u");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.u.u d(java.lang.String r5, byte[] r6) {
        /*
            r4 = this;
            com.bytedance.msdk.c.hc r0 = com.bytedance.msdk.c.hc.d()
            com.bytedance.sdk.component.tt.d r0 = r0.hc()
            com.bytedance.sdk.component.tt.hc.u r0 = r0.hc()
            r0.d(r5)
            com.bytedance.msdk.core.d r5 = com.bytedance.msdk.core.d.mk()
            java.lang.String r5 = r5.gb()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L29
            java.lang.String r1 = "X-Tt-Env"
            r0.hc(r1, r5)
            java.lang.String r5 = "x-use-ppe"
            java.lang.String r1 = "1"
            r0.hc(r5, r1)
        L29:
            java.lang.String r5 = com.bytedance.msdk.hc.hc.d
            java.lang.String r1 = "User-Agent"
            r0.hc(r1, r5)
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r1 = "union_sdk_encode"
            r0.hc(r5, r1)
            java.lang.String r5 = "application/json; charset=utf-8"
            r0.d(r5, r6)
            com.bytedance.sdk.component.tt.hc r5 = r0.d()
            r6 = 1
            r0 = 0
            if (r5 == 0) goto L8f
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L55
            java.lang.String r2 = r5.c()     // Catch: org.json.JSONException -> L55
            r1.<init>(r2)     // Catch: org.json.JSONException -> L55
            boolean r1 = r4.d(r1)     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L8f
            r1 = r6
            goto L90
        L55:
            r1 = move-exception
            int r2 = r4.c
            int r3 = r2 + 1
            r4.c = r3
            r3 = 20
            if (r2 >= r3) goto L74
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "exception: "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "doUploadApplogAdEventV3"
            d(r3, r2)
        L74:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "ignore:"
            r2.<init>(r3)
            java.lang.String r3 = r1.toString()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "uploadEvent"
            com.bytedance.msdk.d.u.b.c(r3, r2)
            com.bytedance.sdk.component.utils.mq.d(r1)
        L8f:
            r1 = r0
        L90:
            if (r5 == 0) goto L97
            int r2 = r5.d()
            goto L98
        L97:
            r2 = r0
        L98:
            if (r1 != 0) goto La1
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto La1
            java.lang.String r5 = "server say not success"
            goto Lca
        La1:
            if (r5 == 0) goto Lc7
            java.lang.String r6 = r5.hc()
            if (r1 != 0) goto Lc5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r6 = r3.append(r6)
            java.lang.String r3 = "::"
            java.lang.StringBuilder r6 = r6.append(r3)
            java.lang.String r5 = r5.c()
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            goto Lc9
        Lc5:
            r5 = r6
            goto Lc9
        Lc7:
            java.lang.String r5 = "error unknown"
        Lc9:
            r6 = r0
        Lca:
            com.bytedance.msdk.u.u r0 = new com.bytedance.msdk.u.u
            r0.<init>(r1, r2, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.u.hc.hc.d(java.lang.String, byte[]):com.bytedance.msdk.u.u");
    }

    @Override // com.bytedance.msdk.u.hc.d
    public u d(List<com.bytedance.msdk.u.d> list) {
        u uVarD;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (list == null) {
            return null;
        }
        boolean z = true;
        try {
            if (list.isEmpty()) {
                return null;
            }
            b.hc("TTMediationSDK", "--==-- v3: " + list.size());
            boolean zD = d();
            byte[] bArrD = d(list, zD);
            if (bArrD != null && bArrD.length > 0) {
                uVarD = d(com.bytedance.msdk.core.b.hc(), bArrD, zD);
            } else {
                uVarD = d(com.bytedance.msdk.core.b.hc(), c(list));
            }
            if (list.size() < com.bytedance.msdk.core.hc.hc().he()) {
                z = false;
            }
            zw.d(uVarD.d, list.size(), d(z), SystemClock.elapsedRealtime() - jElapsedRealtime, uVarD.hc + "::" + uVarD.b);
            return uVarD;
        } catch (Throwable th) {
            int i = this.b;
            this.b = i + 1;
            if (i < 20) {
                d("uploadEvent", "exception: " + th.toString());
            }
            b.c("ReportNetApiImpl", "uploadEvent error:");
            mq.d(th);
            zw.d(false, 0, d(z), SystemClock.elapsedRealtime() - jElapsedRealtime, "-1::" + th);
            return new u(false, 509, "service_busy", false);
        }
    }

    private String d(boolean z) {
        if (hc) {
            hc = false;
            return "1";
        }
        if (!d) {
            return z ? "3" : "2";
        }
        d = false;
        return "4";
    }

    private byte[] hc(List<com.bytedance.msdk.u.d> list) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObjectB = b(list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(jSONObjectB.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        d("buildAdEventV3BodyRaw", "exception: " + e.toString());
                        mq.d(e);
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
                                mq.d(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                mq.d(e4);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private JSONObject b(List<com.bytedance.msdk.u.d> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", np.s());
            jSONObject.put("client_ip", np.de());
            jSONObject.put("header", v.hc());
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.msdk.u.d> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().hc);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException e) {
            d("getAdEventV3Json", "exception: " + e.toString());
            mq.d(e);
        }
        return jSONObject;
    }

    private byte[] d(List<com.bytedance.msdk.u.d> list, boolean z) throws Throwable {
        byte[] bArrD;
        byte[] bArrHc = hc(list);
        if (bArrHc == null) {
            d("buildAdEventV3Body", "zipData is null");
        } else if (bArrHc.length <= 0) {
            d("buildAdEventV3Body", "zipData len 0");
        }
        if (z) {
            bArrD = tt.d().d(bArrHc);
        } else {
            bArrD = d(bArrHc, bArrHc.length);
        }
        if (bArrD == null) {
            d("buildAdEventV3Body", "data is null");
        } else if (bArrD.length <= 0) {
            d("buildAdEventV3Body", "data len 0");
        }
        return bArrD;
    }

    private byte[] c(List<com.bytedance.msdk.u.d> list) {
        try {
            return d(com.bytedance.msdk.gb.b.d(b(list)).toString());
        } catch (Throwable th) {
            d("buildAdEventV3Body2", "exception: " + th.toString());
            mq.d(th);
            return null;
        }
    }

    private byte[] d(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    private byte[] d(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return e.d(bArr, i);
                }
            } catch (Throwable th) {
                d("encrypt", "exception: " + th.toString());
                mq.d(th);
                return null;
            }
        }
        d("encrypt", "inputData is " + (bArr == null ? ILogConst.CACHE_PLAY_REASON_NULL : "0"));
        return null;
    }

    public static void d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(j.s, Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("v3_Id", str);
            jSONObject.putOpt("v3_err_msg", str2);
            zw.d(jSONObject);
        } catch (Throwable unused) {
        }
    }

    private boolean d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("code") != 20000) {
                    return "success".equals(jSONObject.optString(cm.V));
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
