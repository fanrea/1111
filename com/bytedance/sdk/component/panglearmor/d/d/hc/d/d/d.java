package com.bytedance.sdk.component.panglearmor.d.d.hc.d.d;

import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.d.hc.hc;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static List<com.bytedance.sdk.component.panglearmor.d.hc.d> d(hc hcVar, com.bytedance.sdk.component.panglearmor.d.d.b.hc hcVar2) throws Exception {
        return d(com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d(hcVar, hcVar2, 1896449818).d);
    }

    public static List<com.bytedance.sdk.component.panglearmor.d.hc.d> d(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferD = com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d(byteBuffer);
            if (!byteBufferD.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferD.hasRemaining()) {
                try {
                    arrayList.add(hc(com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d(byteBufferD)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }

    @DungeonFlag
    private static com.bytedance.sdk.component.panglearmor.d.hc.d hc(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferD = com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d(byteBuffer);
        byteBufferD.get(new byte[byteBufferD.remaining()]);
        byteBufferD.flip();
        byteBufferD.position(0);
        com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d(byteBufferD);
        byte[] bArrHc = com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.hc(com.bytedance.sdk.component.panglearmor.d.d.hc.d.d.d(byteBufferD));
        try {
            return new com.bytedance.sdk.component.panglearmor.d.hc.d(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrHc))).getSubjectDN()), bArrHc);
        } catch (Exception unused) {
            return null;
        }
    }
}
