package com.kwad.sdk.glide.load.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b<T> implements d<T> {
    private final String bRF;
    private final AssetManager bmM;
    private T data;

    protected abstract T c(AssetManager assetManager, String str);

    @Override // com.kwad.sdk.glide.load.a.d
    public final void cancel() {
    }

    protected abstract void w(T t);

    public b(AssetManager assetManager, String str) {
        this.bmM = assetManager;
        this.bRF = str;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(Priority priority, d.a<? super T> aVar) {
        try {
            T tC = c(this.bmM, this.bRF);
            this.data = tC;
            aVar.x(tC);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.g(e);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void afU() {
        T t = this.data;
        if (t == null) {
            return;
        }
        try {
            w(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final DataSource afV() {
        return DataSource.LOCAL;
    }
}
