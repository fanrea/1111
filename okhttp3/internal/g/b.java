package okhttp3.internal.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b {
    static void a(byte[] bArr, long j, byte[] bArr2, long j2) {
        int length = bArr2.length;
        int i = 0;
        while (i < j) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[(int) (j2 % length)]);
            i++;
            j2++;
        }
    }

    static String bJ(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        }
        if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        }
        return "Code " + i + " is reserved and may not be used.";
    }

    static void bK(int i) {
        String strBJ = bJ(i);
        if (strBJ != null) {
            throw new IllegalArgumentException(strBJ);
        }
    }
}
