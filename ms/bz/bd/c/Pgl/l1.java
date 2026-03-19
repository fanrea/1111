package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class l1 {
    private static l1 d;
    private ArrayList b = new ArrayList();
    private Context hc;

    private l1(Context context) {
        this.hc = null;
        this.hc = context;
    }

    public static l1 d(Context context) {
        if (d == null) {
            synchronized (l1.class) {
                if (d == null) {
                    d = new l1(context);
                }
            }
        }
        return d;
    }

    public final int b() {
        Intent intentRegisterReceiver = this.hc.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "034497", new byte[]{32, Utf8.REPLACEMENT_BYTE, 67, 82, 9, 41, com.sigmob.sdk.archives.tar.e.O, 92, 108, 106, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.L, 73, 84, 72, 33, com.sigmob.sdk.archives.tar.e.H, 6, 108, 107, 47, 127, 101, 97, com.sigmob.sdk.archives.tar.e.J, 20, 22, 32, 92, 91, 2, 25, 102, 110, 33, 5, 23})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9faad", new byte[]{99, com.sigmob.sdk.archives.tar.e.O, 0, 18, 89, 118, 101}), -1);
    }

    public final void c() {
        char c;
        int i;
        int iB;
        int iD;
        try {
            c = pble.d() != null ? (char) 1 : (char) 0;
        } catch (Throwable unused) {
            c = 65535;
        }
        if (c != 1) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bc673e", new byte[]{112, 105, 64, 64, 7, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.T, 71, 115, 100, 123, 67, 68, 87, 24, 119, 115, 91, 84, 115, 114, 117, 80, 80, Utf8.REPLACEMENT_BYTE, 102, 115, 75, 105, 96, com.sigmob.sdk.archives.tar.e.f789K, 104, 75, 3, 14, 115, 98, 73, 96, 117, 124, 116, 75, 71});
            return;
        }
        try {
            synchronized (this) {
                iB = b();
                iD = d();
            }
            i = (iB * 10000) + iD;
        } catch (Exception unused2) {
            i = -10001;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            return;
        }
        this.b.add(numValueOf);
        try {
            int size = this.b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.b.subList(size - 10, size));
                this.b.clear();
                this.b = arrayList;
            }
        } catch (Throwable unused3) {
        }
    }

    public final int d() {
        if (this.hc.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6668b", new byte[]{118, 58, 65, 80, 8, 124, 97, 89, 110, 104, 99, com.sigmob.sdk.archives.tar.e.I, 75, 86, 73, 116, 102, 3, 110, 105, 121, 122, com.sigmob.sdk.archives.tar.e.T, 99, com.sigmob.sdk.archives.tar.e.f789K, 65, 64, 37, 94, 89, 84, 28, 100, 108, 32, 80, 65}))) == null) {
            return -1;
        }
        return Math.round(((r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "34228b", new byte[]{46, com.sigmob.sdk.archives.tar.e.f789K, 87, 67, 11}), -1) / r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cb09c5", new byte[]{97, 99, 66, 65, 89}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final int hc() {
        Intent intentRegisterReceiver = this.hc.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "809a2d", new byte[]{40, 60, 78, 7, 2, 122, Utf8.REPLACEMENT_BYTE, 95, 97, Utf8.REPLACEMENT_BYTE, 61, com.sigmob.sdk.archives.tar.e.O, 68, 1, 67, 114, 56, 5, 97, 62, 39, 124, 104, com.sigmob.sdk.archives.tar.e.L, 57, 71, 30, 35, 81, 14, 10, 26, 107, 59, 42, 86, 31})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88c189", new byte[]{58, 46, 17, 81, 18, 61}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public final synchronized int[] u() {
        int size = this.b.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.b.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.b;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List listSubList = arrayList.subList(i, size);
            int[] iArr = new int[listSubList.size()];
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                iArr[i2] = ((Integer) listSubList.get(i2)).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }
}
