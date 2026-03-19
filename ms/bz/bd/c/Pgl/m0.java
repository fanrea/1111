package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import java.util.HashMap;
import java.util.Map;
import ms.bz.bd.c.Pgl.n0;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class m0 implements n0.pgla {
    private final pblu b;
    private final long d;
    private final Context hc;

    m0(pblu pbluVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.b = pbluVar;
        this.hc = context.getApplicationContext();
        this.d = j;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final Map<String, String> getFeatureHash(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            long j = this.d;
            int i = pbly.d;
            String[] strArr = (String[]) com.volcengine.mobsecBiz.matrix.pgla.a(33554438, 0, j, str, bArr);
            if (strArr != null && strArr.length % 2 == 0) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    String str2 = strArr[i2];
                    String str3 = strArr[i2 + 1];
                    if (str2 != null && str3 != null) {
                        map.put(str2, str3);
                    }
                }
            }
        }
        return map;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final String getToken() {
        long j = this.d;
        if (j == -1) {
            return "";
        }
        int i = pbly.d;
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(33554439, 0, j, (String) null, (Object) null);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void report(String str) {
        if (this.d == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.d;
        Context context = this.hc;
        int i = pbly.d;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setBDDeviceID(String str) {
        this.b.d = str;
        long j = this.d;
        if (j != -1) {
            Context context = this.hc;
            int i = pbly.d;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554437, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setCollectMode(int i) {
        long j = this.d;
        if (j != -1) {
            int i2 = pbly.d;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554441, i, j, (String) null, (Object) null);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setDeviceID(String str) {
        this.b.c = str;
        long j = this.d;
        if (j != -1) {
            Context context = this.hc;
            int i = pbly.d;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j, str, context);
        }
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public final void setInstallID(String str) {
        this.b.e = str;
        long j = this.d;
        if (j != -1) {
            Context context = this.hc;
            int i = pbly.d;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554435, 0, j, str, context);
        }
    }
}
