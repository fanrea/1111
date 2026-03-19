package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.hc;
import java.io.File;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class q0 extends pbly.pgla {
    q0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(long j, String str, Object obj) throws Throwable {
        File file = new File(hc.d(pblv.d().hc()), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa7531", new byte[]{57, 110, 87, 69, 13, com.sigmob.sdk.archives.tar.e.J, 100}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
