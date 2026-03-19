package com.bykv.vk.openvk.component.video.d.d;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bykv.vk.openvk.component.video.d.d.d.b;
import com.bykv.vk.openvk.component.video.d.d.d.hc;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends MediaDataSource {
    public static final ConcurrentHashMap<String, d> d = new ConcurrentHashMap<>();
    private long b = -2147483648L;
    private final Context c;
    private final b hc;
    private final c u;

    public d(Context context, c cVar) {
        this.c = context;
        this.u = cVar;
        this.hc = new hc(context, cVar);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.hc.d(j, bArr, i, i2);
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.b == -2147483648L) {
            if (this.c == null || TextUtils.isEmpty(this.u.cb())) {
                return -1L;
            }
            this.b = this.hc.c();
            com.bykv.vk.openvk.component.video.api.an.b.d("SdkMediaDataSource", "getSize: " + this.b);
        }
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.an.b.d("SdkMediaDataSource", "close: ", this.u.cb());
        b bVar = this.hc;
        if (bVar != null) {
            bVar.b();
        }
        d.remove(this.u.w());
    }

    public c d() {
        return this.u;
    }

    public static d d(Context context, c cVar) {
        d dVar = new d(context, cVar);
        d.put(cVar.w(), dVar);
        return dVar;
    }
}
