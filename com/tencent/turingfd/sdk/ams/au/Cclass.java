package com.tencent.turingfd.sdk.ams.au;

import android.util.Base64;
import com.alipay.sdk.m.u.i;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.class, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cclass {
    public static final String a = Cfinally.a(Cfinally.S0);
    public static final String b = Cfinally.a(Cfinally.O0);
    public static final String c = Cfinally.a(Cfinally.P0);
    public static final String d = Cfinally.a(Cfinally.Q0);
    public static final /* synthetic */ boolean e = true;

    public static String a(Certificate certificate) throws Exception {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN CERTIFICATE-----");
        bufferedWriter.write("\n");
        byte[] bArrEncode = Base64.encode(certificate.getEncoded(), 2);
        char[] cArr = new char[64];
        for (int i = 0; i < bArrEncode.length; i += 64) {
            int i2 = 0;
            while (i2 != 64) {
                int i3 = i + i2;
                if (i3 >= bArrEncode.length) {
                    break;
                }
                cArr[i2] = (char) bArrEncode[i3];
                i2++;
            }
            bufferedWriter.write(cArr, 0, i2);
            bufferedWriter.write("\n");
        }
        bufferedWriter.write("-----END CERTIFICATE-----");
        bufferedWriter.write("\n");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    public static void a(X509Certificate x509Certificate, Cumquat cumquat) throws Exception {
        byte[] extensionValue = x509Certificate.getExtensionValue(a);
        if (extensionValue != null && extensionValue.length != 0) {
            try {
                byte b2 = "{".getBytes()[0];
                byte b3 = i.d.getBytes()[0];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < extensionValue.length; i3++) {
                    byte b4 = extensionValue[i3];
                    if (b4 == b2) {
                        i = i3;
                    } else if (b4 == b3) {
                        i2 = i3;
                    }
                }
                if (i <= 0 || i >= i2) {
                    return;
                }
                if (!e && extensionValue[i - 1] != (i2 - i) + 1) {
                    throw new AssertionError();
                }
                int i4 = (i2 - i) + 1;
                byte[] bArr = new byte[i4];
                System.arraycopy(extensionValue, i, bArr, 0, i4);
                JSONObject jSONObject = new JSONObject(new String(bArr));
                cumquat.c = jSONObject.getString(c);
                cumquat.b = jSONObject.getInt(d);
                cumquat.a = jSONObject.getLong(b);
                return;
            } catch (Exception e2) {
                StringBuilder sbA = Bennet.a("C");
                sbA.append(e2.getStackTrace());
                throw new Exception(sbA.toString());
            }
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }
}
