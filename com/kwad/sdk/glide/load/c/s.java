package com.kwad.sdk.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.kwad.sdk.glide.load.c.n;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class s<Data> implements n<Integer, Data> {
    private final n<Uri, Data> bWS;
    private final Resources resources;

    @Override // com.kwad.sdk.glide.load.c.n
    public final /* bridge */ /* synthetic */ boolean E(Integer num) {
        return true;
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.resources = resources;
        this.bWS = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.load.c.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Integer num, int i, int i2, com.kwad.sdk.glide.load.f fVar) {
        Uri uriJ = j(num);
        if (uriJ == null) {
            return null;
        }
        return this.bWS.b(uriJ, i, i2, fVar);
    }

    private Uri j(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + this.resources.getResourceTypeName(num.intValue()) + '/' + this.resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            return null;
        }
    }

    public static class c implements o<Integer, InputStream> {
        private final Resources resources;

        public c(Resources resources) {
            this.resources = resources;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Integer, InputStream> a(r rVar) {
            return new s(this.resources, rVar.a(Uri.class, InputStream.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {
        private final Resources resources;

        public b(Resources resources) {
            this.resources = resources;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.resources, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static final class a implements o<Integer, AssetFileDescriptor> {
        private final Resources resources;

        public a(Resources resources) {
            this.resources = resources;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.resources, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class d implements o<Integer, Uri> {
        private final Resources resources;

        public d(Resources resources) {
            this.resources = resources;
        }

        @Override // com.kwad.sdk.glide.load.c.o
        public final n<Integer, Uri> a(r rVar) {
            return new s(this.resources, v.ahH());
        }
    }
}
