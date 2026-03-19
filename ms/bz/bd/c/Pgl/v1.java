package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.lang.reflect.Method;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class v1 {
    private Object b;
    private Method c;
    private final Context d;
    private Class hc;

    public v1(Context context) throws ClassNotFoundException {
        this.d = context;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "51c5bf", new byte[]{39, 60, 29, 15, 92, 127, com.sigmob.sdk.archives.tar.e.J, 2, 61, 108, 32, 125, 25, 69, 19, com.sigmob.sdk.archives.tar.e.R, 59, 0, 62, 43, 13, com.sigmob.sdk.archives.tar.e.O, 32, com.sigmob.sdk.archives.tar.e.Q, 82, com.sigmob.sdk.archives.tar.e.T, Utf8.REPLACEMENT_BYTE, 20, com.sigmob.sdk.archives.tar.e.O, 119, 13, 62, 0, 77}));
            this.hc = cls;
            this.b = cls.newInstance();
        } catch (Exception unused) {
        }
        try {
            this.c = this.hc.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "551efe", new byte[]{35, com.sigmob.sdk.archives.tar.e.J, 86, 62, com.sigmob.sdk.archives.tar.e.R, 91, 18}), Context.class);
        } catch (Exception unused2) {
        }
    }

    public final String d() {
        Context context = this.d;
        Method method = this.c;
        Object obj = this.b;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
