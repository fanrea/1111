package com.kwad.sdk.glide.load.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k implements n<Uri, File> {
    private final Context dR;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ boolean E(Uri uri) {
        return j(uri);
    }

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* synthetic */ n.a<File> b(Uri uri, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        return i(uri);
    }

    public k(Context context) {
        this.dR = context;
    }

    private n.a<File> i(Uri uri) {
        return new n.a<>(new com.kwad.sdk.glide.d.b(uri), new b(this.dR, uri));
    }

    private static boolean j(Uri uri) {
        return com.kwad.sdk.glide.load.a.a.b.a(uri);
    }

    static class b implements com.kwad.sdk.glide.load.a.d<File> {
        private static final String[] bWx = {"_data"};
        private final Context dR;
        private final Uri uri;

        @Override // com.kwad.sdk.glide.load.a.d
        public final void afU() {
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void cancel() {
        }

        b(Context context, Uri uri) {
            this.dR = context;
            this.uri = uri;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final void a(Priority priority, d.a<? super File> aVar) {
            Cursor cursorQuery = this.dR.getContentResolver().query(this.uri, bWx, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                }
            }
            if (TextUtils.isEmpty(string)) {
                aVar.g(new FileNotFoundException("Failed to find file path for: " + this.uri));
            } else {
                aVar.x(new File(string));
            }
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final Class<File> afT() {
            return File.class;
        }

        @Override // com.kwad.sdk.glide.load.a.d
        public final DataSource afV() {
            return DataSource.LOCAL;
        }
    }

    public static final class a implements o<Uri, File> {
        private final Context dR;

        public a(Context context) {
            this.dR = context;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Uri, File> a(r rVar) {
            return new k(this.dR);
        }
    }
}
