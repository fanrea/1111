package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.component.utils.mq;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pbln {
    public static void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                mq.d(e);
            }
        }
    }
}
