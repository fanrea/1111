package okhttp3.internal.http2;

import java.io.IOException;
import okio.BufferedSource;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface k {
    public static final k Dk = new k() { // from class: okhttp3.internal.http2.k.1
        @Override // okhttp3.internal.http2.k
        public final boolean b(BufferedSource bufferedSource, int i) throws IOException {
            bufferedSource.skip(i);
            return true;
        }
    };

    boolean b(BufferedSource bufferedSource, int i);
}
