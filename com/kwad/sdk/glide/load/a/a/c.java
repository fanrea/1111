package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.a.g;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements com.kwad.sdk.glide.load.a.d<InputStream> {
    private InputStream bJw;
    private final Uri bRW;
    private final e bRX;

    @Override // com.kwad.sdk.glide.load.a.d
    public final void cancel() {
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.kwad.sdk.glide.c.cv(context).afe().afj(), dVar, com.kwad.sdk.glide.c.cv(context).afa(), context.getContentResolver()));
    }

    private c(Uri uri, e eVar) {
        this.bRW = uri;
        this.bRX = eVar;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void a(Priority priority, d.a<? super InputStream> aVar) {
        try {
            InputStream inputStreamAfZ = afZ();
            this.bJw = inputStreamAfZ;
            aVar.x(inputStreamAfZ);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.g(e);
        }
    }

    private InputStream afZ() throws FileNotFoundException {
        InputStream inputStreamG = this.bRX.g(this.bRW);
        int iF = inputStreamG != null ? this.bRX.f(this.bRW) : -1;
        return iF != -1 ? new g(inputStreamG, iF) : inputStreamG;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final void afU() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.bJw);
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final Class<InputStream> afT() {
        return InputStream.class;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    public final DataSource afV() {
        return DataSource.LOCAL;
    }

    static class b implements d {
        private static final String[] bRY = {"_data"};
        private final ContentResolver bRU;

        b(ContentResolver contentResolver) {
            this.bRU = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public final Cursor e(Uri uri) {
            return this.bRU.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, bRY, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class a implements d {
        private static final String[] bRY = {"_data"};
        private final ContentResolver bRU;

        a(ContentResolver contentResolver) {
            this.bRU = contentResolver;
        }

        @Override // com.kwad.sdk.glide.load.a.a.d
        public final Cursor e(Uri uri) {
            return this.bRU.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, bRY, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }
}
