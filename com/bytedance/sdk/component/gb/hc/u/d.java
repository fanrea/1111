package com.bytedance.sdk.component.gb.hc.u;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.d.an;
import com.bytedance.sdk.component.gb.d.gb;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.gb.hc.b.b;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.gb.d.d.d<com.bytedance.sdk.component.gb.d.hc> {
    private static final SimpleDateFormat hc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private u c;
    private final String b = "x-pglcypher";
    private final boolean d = hc();

    private String hc(int i) {
        return i >= 4 ? MediaTypeUtils.APPLICATION_OCTET_STREAM : "application/octet-stream;tt-data=a";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u d() {
        if (this.c == null) {
            this.c = com.bytedance.sdk.component.gb.hc.d.b("csj").b();
        }
        return this.c;
    }

    public static byte[] hc(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    private static boolean hc() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.d.d
    public com.bytedance.sdk.component.gb.hc.hc.b.hc d(List<com.bytedance.sdk.component.gb.d.hc> list) throws JSONException {
        gb gbVarMq;
        com.bytedance.sdk.component.gb.hc.hc.b.hc hcVarD;
        String strAn;
        c cVarC = d().c();
        Object[] objArr = null;
        byte b = 0;
        byte b2 = 0;
        if (cVarC != null) {
            try {
                if (cVarC.c() && (gbVarMq = cVarC.mq()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str = "1streqid";
                    String strAn2 = "2ndreqid";
                    String str2 = "";
                    int i = 0;
                    for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
                        try {
                            if (TextUtils.equals("show", com.bytedance.sdk.component.gb.hc.b.d.d(hcVar, d()))) {
                                String strD = com.bytedance.sdk.component.gb.hc.b.d.d(hcVar.h(), this.c);
                                if (i == 0) {
                                    strAn = com.bytedance.sdk.component.gb.hc.b.d.an(hcVar, this.c);
                                } else {
                                    strAn2 = com.bytedance.sdk.component.gb.hc.b.d.an(hcVar, this.c);
                                    strAn = strAn2;
                                }
                                str2 = strD;
                                str = strAn;
                                i = 1;
                            }
                            arrayList.add(hcVar);
                        } catch (Throwable th) {
                            th = th;
                            i = i;
                            try {
                                b.b("NetApiImpl", "uploadEvent error" + th.getMessage(), d());
                                return new com.bytedance.sdk.component.gb.hc.hc.b.hc(false, 509, th.getMessage(), false, "error");
                            } finally {
                                if (i != 0 && 0 != 0) {
                                    int length = objArr.length;
                                }
                            }
                        }
                    }
                    int iTc = gbVarMq.tc();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectD = gbVarMq.d(hc(arrayList), this.d);
                    byte[] bArrD = gbVarMq.d(jSONObjectD, iTc);
                    if (bArrD == null) {
                        JSONObject jSONObjectD2 = gbVarMq.d(jSONObjectD);
                        bArrD = hc(jSONObjectD2);
                        hcVarD = d(bArrD, c(jSONObjectD2), MediaTypeUtils.APPLICATION_JSON);
                    } else {
                        hcVarD = d(bArrD, d(iTc), hc(iTc));
                    }
                    if (i != 0) {
                        int length2 = bArrD != null ? bArrD.length : 0;
                        if (hcVarD != null) {
                            com.bytedance.sdk.component.gb.hc.b.d.d(hcVarD.d, hcVarD.hc, hcVarD.b, str + "|" + strAn2, length2, str2);
                        }
                    }
                    return hcVarD;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public List<com.bytedance.sdk.component.gb.d.hc> hc(List<com.bytedance.sdk.component.gb.d.hc> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectH = hcVar.h();
                String strOptString = jSONObjectH.optString("label");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectH.optString(NotificationCompat.CATEGORY_EVENT);
                }
                jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, strOptString);
                long jOptLong = jSONObjectH.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", hc.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObjectH.has("params") && jSONObjectH.has(NotificationCompat.CATEGORY_EVENT)) {
                    jSONObject2 = jSONObjectH.optJSONObject("params");
                } else {
                    Iterator<String> itKeys = jSONObjectH.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, jSONObjectH.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.bytedance.sdk.component.gb.hc.c.d.d dVar = new com.bytedance.sdk.component.gb.hc.c.d.d(hcVar.b(), jSONObject);
                dVar.d(hcVar.c());
                dVar.hc(hcVar.u());
                arrayList.add(dVar);
            } catch (Exception e) {
                b.b(e.getMessage(), d());
            }
        }
        return arrayList;
    }

    private Map<String, String> d(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put("Content-Encoding", "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put("Content-Type", hc(i));
        return map;
    }

    private Map<String, String> c(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", MediaTypeUtils.APPLICATION_JSON);
        if (an(jSONObject)) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private com.bytedance.sdk.component.gb.hc.hc.b.hc d(byte[] bArr, Map<String, String> map, String str) {
        int iU;
        boolean zB;
        boolean z;
        String str2;
        try {
            c cVarC = d().c();
            gb gbVarMq = cVarC.mq();
            an anVarU = gbVarMq.u();
            anVarU.d(gbVarMq.an());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    anVarU.d(entry.getKey(), entry.getValue());
                }
            }
            anVarU.d(str, bArr);
            anVarU.d("User-Agent", cVarC.u());
            com.bytedance.sdk.component.gb.d.d.u uVarD = anVarU.d();
            if (uVarD == null) {
                return new com.bytedance.sdk.component.gb.hc.hc.b.hc(false, 510, "RSP IS NULL", false, "error");
            }
            boolean z2 = false;
            if (uVarD == null || !uVarD.d() || TextUtils.isEmpty(uVarD.hc())) {
                iU = 0;
                zB = false;
            } else {
                JSONObject jSONObject = new JSONObject(uVarD.hc());
                zB = b(jSONObject);
                iU = u(jSONObject);
            }
            int iB = uVarD.b();
            String str3 = uVarD.u() != null ? uVarD.u().get("x-tt-logid") : "error";
            boolean z3 = !zB && iB == 200;
            String strC = uVarD.c();
            if (strC == null || TextUtils.isEmpty(strC)) {
                strC = "DEFAULT OK";
            }
            if (iU != 0) {
                str2 = "RSP FAIL";
                z = true;
            } else {
                z2 = zB;
                iU = iB;
                z = z3;
                str2 = strC;
            }
            hc(bArr, map, str);
            return new com.bytedance.sdk.component.gb.hc.hc.b.hc(z2, iU, str2, z, str3);
        } catch (Throwable th) {
            b.b("NetApiImpl", "uploadEvent error" + th.getMessage(), d());
            return new com.bytedance.sdk.component.gb.hc.hc.b.hc(false, 511, th.getMessage(), false, "error");
        }
    }

    private void hc(byte[] bArr, Map<String, String> map, String str) {
        u uVarD;
        c cVarC;
        gb gbVarMq;
        if (bArr == null || bArr.length == 0 || (uVarD = d()) == null || (cVarC = uVarD.c()) == null || (gbVarMq = cVarC.mq()) == null || !gbVarMq.d()) {
            return;
        }
        an anVarU = gbVarMq.u();
        anVarU.d(gbVarMq.hc());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                anVarU.d(entry.getKey(), entry.getValue());
            }
        }
        anVarU.d(str, bArr);
        anVarU.d("User-Agent", cVarC.u());
        anVarU.d(new com.bytedance.sdk.component.gb.d.d.b() { // from class: com.bytedance.sdk.component.gb.hc.u.d.1
            @Override // com.bytedance.sdk.component.gb.d.d.b
            public void d(com.bytedance.sdk.component.gb.d.d.c cVar, com.bytedance.sdk.component.gb.d.d.u uVar) {
                if (uVar == null || !uVar.d()) {
                    d.this.d();
                } else {
                    uVar.hc();
                    d.this.d();
                }
            }

            @Override // com.bytedance.sdk.component.gb.d.d.b
            public void d(com.bytedance.sdk.component.gb.d.d.c cVar, IOException iOException) {
                iOException.getMessage();
                d.this.d();
            }
        });
    }

    public boolean b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString(cm.V).equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static PublicKey b() throws Exception {
        return KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    private boolean d(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(b().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    private int u(JSONObject jSONObject) {
        int iIndexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf(Config.replace)) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            String strSubstring2 = strOptString.substring(iIndexOf + 1);
            JSONObject jSONObjectTt = d().c().mq().tt();
            if (d((jSONObjectTt != null ? jSONObjectTt.optString(com.baidu.mobads.upgrade.remote.gray.c.l) : "") + Config.replace + strSubstring, strSubstring2)) {
                return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300 ? 513 : 0;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.gb.d.d.d
    public com.bytedance.sdk.component.gb.hc.hc.b.hc d(JSONObject jSONObject) {
        gb gbVarMq;
        int i;
        boolean z;
        String str;
        boolean z2;
        int i2;
        com.bytedance.sdk.component.gb.d.d.u uVarD;
        int i3;
        c cVarC = d().c();
        if (cVarC == null || !cVarC.c() || jSONObject == null || jSONObject.length() <= 0 || (gbVarMq = cVarC.mq()) == null) {
            return null;
        }
        an anVarU = gbVarMq.u();
        anVarU.d(gbVarMq.h());
        int iTc = gbVarMq.tc();
        byte[] bArrHc = gbVarMq.hc(jSONObject, iTc);
        if (bArrHc == null) {
            anVarU.hc(gbVarMq.d(jSONObject).toString());
        } else {
            anVarU.d(hc(iTc), bArrHc);
            anVarU.d("x-pglcypher", String.valueOf(iTc));
        }
        anVarU.d("User-Agent", cVarC.u());
        String strC = "error unknown";
        int iB = 0;
        try {
            uVarD = anVarU.d();
        } catch (Throwable unused) {
            i = 0;
            z = false;
        }
        if (uVarD == null) {
            return new com.bytedance.sdk.component.gb.hc.hc.b.hc(false, 0, "error unknown", false, "ignore");
        }
        z = true;
        if (!uVarD.d() || TextUtils.isEmpty(uVarD.hc())) {
            i3 = 0;
            z = false;
        } else {
            JSONObject jSONObject2 = new JSONObject(uVarD.hc());
            int iOptInt = jSONObject2.optInt("code", -1);
            strC = jSONObject2.optString("data", "");
            i3 = iOptInt == 20000 ? 1 : 0;
            if (iOptInt != 60005) {
                z = false;
            }
        }
        try {
            iB = uVarD.b();
            if (!uVarD.d()) {
                strC = uVarD.c();
            }
            str = strC;
            i2 = iB;
            z2 = i3;
        } catch (Throwable unused2) {
            i = iB;
            iB = i3;
            str = strC;
            z2 = iB;
            i2 = i;
            return new com.bytedance.sdk.component.gb.hc.hc.b.hc(z2, i2, str, z, "ignore");
        }
        return new com.bytedance.sdk.component.gb.hc.hc.b.hc(z2, i2, str, z, "ignore");
    }

    private boolean an(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }
}
