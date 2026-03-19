package aegon.chrome.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SecureRandomInitializer {
    private static final int NUM_RANDOM_BYTES = 16;

    public static void initialize(SecureRandom secureRandom) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
        try {
            byte[] bArr = new byte[16];
            if (fileInputStream.read(bArr) != 16) {
                throw new IOException("Failed to get enough random data.");
            }
            secureRandom.setSeed(bArr);
            fileInputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
