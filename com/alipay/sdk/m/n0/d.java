package com.alipay.sdk.m.n0;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static d j;
    public Context a;
    public e c;
    public String d;
    public String e;
    public com.alipay.sdk.m.m0.a f;
    public com.alipay.sdk.m.m0.a g;
    public static final Object i = new Object();
    public static final String k = ".UTSystemConfig" + File.separator + "Global";
    public String b = null;
    public Pattern h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(Context context) {
        this.a = null;
        this.c = null;
        this.d = "xx_utdid_key";
        this.e = "xx_utdid_domain";
        this.f = null;
        this.g = null;
        this.a = context;
        this.g = new com.alipay.sdk.m.m0.a(context, k, "Alvin2", false, true);
        this.f = new com.alipay.sdk.m.m0.a(context, ".DataStorage", "ContextData", false, true);
        this.c = new e();
        this.d = String.format("K_%d", Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.d)));
        this.e = String.format("D_%d", Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.e)));
    }

    public static d a(Context context) {
        if (context != null && j == null) {
            synchronized (i) {
                if (j == null) {
                    d dVar = new d(context);
                    j = dVar;
                    dVar.d();
                }
            }
        }
        return j;
    }

    private void b(String str) {
        com.alipay.sdk.m.m0.a aVar;
        if (a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (aVar = this.g) == null) {
                return;
            }
            aVar.a("UTDID2", str);
            this.g.a();
        }
    }

    private void c(String str) {
        com.alipay.sdk.m.m0.a aVar;
        if (str == null || (aVar = this.f) == null || str.equals(aVar.a(this.d))) {
            return;
        }
        this.f.a(this.d, str);
        this.f.a();
    }

    private void d() {
        com.alipay.sdk.m.m0.a aVar = this.g;
        if (aVar != null) {
            if (com.alipay.sdk.m.l0.f.m293a(aVar.a("UTDID2"))) {
                String strA = this.g.a("UTDID");
                if (!com.alipay.sdk.m.l0.f.m293a(strA)) {
                    b(strA);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!com.alipay.sdk.m.l0.f.m293a(this.g.a("DID"))) {
                this.g.b("DID");
                z = true;
            }
            if (!com.alipay.sdk.m.l0.f.m293a(this.g.a("EI"))) {
                this.g.b("EI");
                z = true;
            }
            if (com.alipay.sdk.m.l0.f.m293a(this.g.a("SI"))) {
                z2 = z;
            } else {
                this.g.b("SI");
            }
            if (z2) {
                this.g.a();
            }
        }
    }

    private byte[] e() throws Exception {
        String strA;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrA = com.alipay.sdk.m.l0.c.a(iCurrentTimeMillis);
        byte[] bArrA2 = com.alipay.sdk.m.l0.c.a(iNextInt);
        byteArrayOutputStream.write(bArrA, 0, 4);
        byteArrayOutputStream.write(bArrA2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strA = com.alipay.sdk.m.l0.d.a(this.a);
        } catch (Exception unused) {
            strA = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(strA)), 0, 4);
        byteArrayOutputStream.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private String f() {
        com.alipay.sdk.m.m0.a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        String strA = aVar.a("UTDID2");
        if (com.alipay.sdk.m.l0.f.m293a(strA) || this.c.a(strA) == null) {
            return null;
        }
        return strA;
    }

    public synchronized String c() {
        String strF = f();
        if (a(strF)) {
            c(this.c.a(strF));
            this.b = strF;
            return strF;
        }
        String strA = this.f.a(this.d);
        if (!com.alipay.sdk.m.l0.f.m293a(strA)) {
            String strA2 = new f().a(strA);
            if (!a(strA2)) {
                strA2 = this.c.b(strA);
            }
            if (a(strA2) && !com.alipay.sdk.m.l0.f.m293a(strA2)) {
                this.b = strA2;
                b(strA2);
                return this.b;
            }
        }
        return null;
    }

    public synchronized String b() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        return a();
    }

    private boolean a(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String a() {
        String strC = c();
        this.b = strC;
        if (!TextUtils.isEmpty(strC)) {
            return this.b;
        }
        try {
            byte[] bArrE = e();
            if (bArrE != null) {
                String strC2 = com.alipay.sdk.m.l0.b.c(bArrE, 2);
                this.b = strC2;
                b(strC2);
                String strA = this.c.a(bArrE);
                if (strA != null) {
                    c(strA);
                }
                return this.b;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String a(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, com.sigmob.sdk.archives.tar.e.I, -30, 9, -39, 33, -80, -68, -78, -117, com.sigmob.sdk.archives.tar.e.M, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.alipay.sdk.m.l0.e.a(bArr2), mac.getAlgorithm()));
        return com.alipay.sdk.m.l0.b.c(mac.doFinal(bArr), 2);
    }
}
