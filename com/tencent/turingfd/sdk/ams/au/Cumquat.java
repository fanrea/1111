package com.tencent.turingfd.sdk.ams.au;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cumquat {
    public static final String e = Cfinally.a(Cfinally.N0);
    public static final String f = Cfinally.a(Cfinally.O0);
    public static final String g = Cfinally.a(Cfinally.P0);
    public static final String h = Cfinally.a(Cfinally.Q0);
    public static final String i = Cfinally.a(Cfinally.R0);
    public long a;
    public int b;
    public String c;
    public ArrayList<String> d;

    public Cumquat(String str, String str2) throws JSONException {
        this.a = -1L;
        this.b = -1;
        this.c = "";
        this.d = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str3 = i;
            if (!jSONObject.has(str3)) {
                this.a = jSONObject.optLong(f);
                this.b = jSONObject.optInt(h);
                this.c = jSONObject.optString(g);
                jSONObject.optString(e);
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str3);
            jSONArrayOptJSONArray.length();
            this.d = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                this.d.add(jSONArrayOptJSONArray.getString(i2));
            }
            a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.d.get(0).getBytes())));
            jSONObject.put(g, this.c);
            jSONObject.put(h, this.b);
            jSONObject.put(f, this.a);
            jSONObject.toString();
        } catch (Exception unused) {
        }
    }

    public final void a(X509Certificate x509Certificate) {
        try {
            Cclass.a(x509Certificate, this);
        } catch (Exception unused) {
        }
    }

    public Cumquat(Certificate[] certificateArr) throws JSONException {
        this.a = -1L;
        this.b = -1;
        this.c = "";
        this.d = null;
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                    Certificate certificate = certificateArr[i2];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String strA = Cclass.a(certificate);
                    if (i2 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.put(strA);
                    arrayList.add(strA);
                }
                this.d = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(i, jSONArray);
                jSONObject.put(g, this.c);
                jSONObject.put(h, this.b);
                jSONObject.put(f, this.a);
                jSONObject.toString();
            } catch (Exception unused) {
            }
        }
    }
}
