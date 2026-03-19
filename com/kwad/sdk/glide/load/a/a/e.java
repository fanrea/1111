package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class e {
    private static final a bRZ = new a();
    private final List<ImageHeaderParser> bQG;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bQO;
    private final ContentResolver bRU;
    private final a bSa;
    private final d bSb;

    e(List<ImageHeaderParser> list, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, bRZ, dVar, bVar, contentResolver);
    }

    private e(List<ImageHeaderParser> list, a aVar, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this.bSa = aVar;
        this.bSb = dVar;
        this.bQO = bVar;
        this.bRU = contentResolver;
        this.bQG = list;
    }

    final int f(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.bRU.openInputStream(uri);
                return com.kwad.sdk.glide.load.b.b(this.bQG, inputStreamOpenInputStream, this.bQO);
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpenInputStream);
                return -1;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
        }
    }

    public final InputStream g(Uri uri) throws FileNotFoundException {
        String strH = h(uri);
        if (TextUtils.isEmpty(strH)) {
            return null;
        }
        File fileHj = a.hj(strH);
        if (!N(fileHj)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileHj);
        try {
            return this.bRU.openInputStream(uriFromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    private String h(Uri uri) {
        Cursor cursorE = this.bSb.e(uri);
        if (cursorE != null) {
            try {
                if (cursorE.moveToFirst()) {
                    return cursorE.getString(0);
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorE);
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorE);
        return null;
    }

    private boolean N(File file) {
        return a.exists(file) && 0 < a.M(file);
    }
}
