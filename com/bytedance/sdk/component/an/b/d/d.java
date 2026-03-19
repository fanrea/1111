package com.bytedance.sdk.component.an.b.d;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.an.hc, Cloneable {
    private static volatile com.bytedance.sdk.component.an.hc h;
    private File an;
    private int b;
    private boolean c;
    private long d;
    private int hc;
    private boolean u;

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(6)
    public boolean an() {
        return true;
    }

    public d(int i, long j, File file) {
        this(i, 0, j, i != 0, j != 0, file);
    }

    public d(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.d = j;
        this.hc = i;
        this.b = i2;
        this.c = z;
        this.u = z2;
        this.an = file;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(1)
    public long d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(2)
    public int hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(3)
    public boolean b() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(4)
    public boolean c() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(5)
    public File u() {
        return this.an;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(8)
    public boolean h() {
        return this.b > 0;
    }

    @Override // com.bytedance.sdk.component.an.hc
    @ATSMethod(7)
    public int gb() {
        return this.b;
    }

    public static void d(Context context, com.bytedance.sdk.component.an.hc hcVar) {
        if (hcVar != null) {
            h = hcVar;
        } else {
            h = d(new File(com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context), "image"));
        }
    }

    public static com.bytedance.sdk.component.an.hc d(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (h == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            jMin = Math.min(tc() / 16, 31457280L);
        } else {
            iMin = Math.min(h.hc() / 2, 10485760);
            jMin = Math.min(h.d() / 2, 31457280L);
        }
        return new d(Math.max(iMin, 5242880), Math.max(jMin, Config.FULL_TRACE_LOG_LIMIT), file);
    }

    public static com.bytedance.sdk.component.an.hc tt() {
        return h;
    }

    private static long tc() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }
}
