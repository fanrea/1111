package ms.bz.bd.c.Pgl;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class pblx extends pbly.pgla {
    protected static void d(BufferedInputStream bufferedInputStream) throws IOException {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b250a5", new byte[]{126, com.sigmob.sdk.archives.tar.e.f789K, 121, 71, 87});
            }
        }
    }

    protected static void d(DataOutputStream dataOutputStream) throws IOException {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "983f9c", new byte[]{37, 57, 127, 17, 9});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!d1.d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "939559", new byte[]{41, Utf8.REPLACEMENT_BYTE, 78, com.sigmob.sdk.archives.tar.e.Q, 5, 39, 62, 92, com.sigmob.sdk.archives.tar.e.R, 96, 58, 60, 67, 82, 25, 39, com.sigmob.sdk.archives.tar.e.M, 28, 38, com.sigmob.sdk.archives.tar.e.P, 6, 5, 111, 115, 36, 11, 14}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return d(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return d(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return hc(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.d(i, i2, j, str, obj);
        }
    }

    public abstract Object[] d(String str, String str2, String str3);

    public abstract Object[] d(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] hc(String str, String str2, String str3);
}
