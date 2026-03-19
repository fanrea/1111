package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class x extends pbly.pgla {
    x() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object d(long j, String str, Object obj) throws Throwable {
        String string;
        try {
            WifiInfo connectionInfo = ((WifiManager) pblv.d().hc().getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4cf430", new byte[]{com.sigmob.sdk.archives.tar.e.J, 104, 19, 73}))).getConnectionInfo();
            Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(pbla.d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3c8e59", new byte[]{116, com.sigmob.sdk.archives.tar.e.N, 29, 68, 93, 122, 100, 27, 62, 101, 118, com.sigmob.sdk.archives.tar.e.H, 29, 69, 92, 122, com.sigmob.sdk.archives.tar.e.T, 16, Utf8.REPLACEMENT_BYTE, 96, 117, com.sigmob.sdk.archives.tar.e.J, 28, 66}))), new Class[0]);
            declaredMethod.setAccessible(true);
            string = Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue());
        } catch (Throwable unused) {
            string = null;
        }
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "646eb2", new byte[]{119}) : string.trim();
    }
}
