package com.bytedance.msdk.u;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.component.utils.mq;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static volatile gb d;
    private Cipher b;
    private Key hc;

    private gb() {
        try {
            this.hc = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.hc.hc().q(), 0)));
            this.b = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public static gb d() {
        if (d == null) {
            synchronized (gb.class) {
                if (d == null) {
                    d = new gb();
                }
            }
        }
        return d;
    }

    public String d(byte[] bArr) throws Exception {
        byte[] bArrDoFinal;
        if (bArr == null) {
            return null;
        }
        if (this.b == null) {
            this.hc = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.hc.hc().q(), 0)));
            this.b = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        this.b.init(1, this.hc);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    bArrDoFinal = this.b.doFinal(bArr, i, 117);
                } else {
                    bArrDoFinal = this.b.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public String d(com.bytedance.msdk.hc.b bVar) throws JSONException {
        if (bVar == null || "pangle".equals(bVar.nw())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bVar.nk())) {
                jSONObject.putOpt("t", bVar.nk());
            }
            if (!TextUtils.isEmpty(bVar.om())) {
                jSONObject.putOpt("d", bVar.om());
            }
            jSONObject.putOpt("e", String.valueOf(bVar.kb()));
            if (!TextUtils.isEmpty(bVar.qy())) {
                jSONObject.putOpt(a.u, bVar.qy());
            }
            if (!TextUtils.isEmpty(bVar.nf())) {
                jSONObject.putOpt("aun", bVar.nf());
            }
        } catch (JSONException e) {
            mq.d(e);
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        try {
            return d(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            mq.d(e2);
            return null;
        }
    }
}
