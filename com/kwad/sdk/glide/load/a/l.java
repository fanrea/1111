package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class l<T> implements d<T> {
    private final ContentResolver bRU;
    private T data;
    private final Uri uri;

    protected abstract T b(Uri uri, ContentResolver contentResolver);

    @Override // com.kwad.sdk.glide.load.a.d
    public final void cancel() {
    }

    protected abstract void w(T t);

    public l(ContentResolver contentResolver, Uri uri) {
        this.bRU = contentResolver;
        this.uri = uri;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(Priority priority, d.a<? super T> aVar) {
        try {
            T tB = b(this.uri, this.bRU);
            this.data = tB;
            aVar.x(tB);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.g(e);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void afU() {
        T t = this.data;
        if (t != null) {
            try {
                w(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final DataSource afV() {
        return DataSource.LOCAL;
    }
}
