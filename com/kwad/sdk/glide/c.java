package com.kwad.sdk.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.glide.a.k;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.a.k;
import com.kwad.sdk.glide.load.c.a;
import com.kwad.sdk.glide.load.c.a.a;
import com.kwad.sdk.glide.load.c.a.b;
import com.kwad.sdk.glide.load.c.a.c;
import com.kwad.sdk.glide.load.c.a.d;
import com.kwad.sdk.glide.load.c.a.e;
import com.kwad.sdk.glide.load.c.b;
import com.kwad.sdk.glide.load.c.d;
import com.kwad.sdk.glide.load.c.e;
import com.kwad.sdk.glide.load.c.f;
import com.kwad.sdk.glide.load.c.k;
import com.kwad.sdk.glide.load.c.s;
import com.kwad.sdk.glide.load.c.t;
import com.kwad.sdk.glide.load.c.u;
import com.kwad.sdk.glide.load.c.v;
import com.kwad.sdk.glide.load.c.w;
import com.kwad.sdk.glide.load.c.x;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.load.resource.a.a;
import com.kwad.sdk.glide.load.resource.bitmap.j;
import com.kwad.sdk.glide.load.resource.bitmap.n;
import com.kwad.sdk.glide.load.resource.bitmap.u;
import com.kwad.sdk.glide.load.resource.bitmap.w;
import com.kwad.sdk.glide.load.resource.bitmap.x;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements ComponentCallbacks2 {
    private static volatile c bPw;
    private final com.kwad.sdk.glide.load.engine.c.a bPA;
    private final e bPB;
    private final Registry bPC;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;
    private final k bPE;
    private final com.kwad.sdk.glide.a.d bPF;
    private final List<g> bPG = new ArrayList();
    private MemoryCategory bPH = MemoryCategory.NORMAL;
    private final i bPx;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    private final com.kwad.sdk.glide.load.engine.a.h bPz;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public static c cv(Context context) {
        if (bPw == null) {
            synchronized (c.class) {
                if (bPw == null) {
                    cw(context);
                }
            }
        }
        return bPw;
    }

    private static void cw(Context context) {
        a(context, new d());
    }

    private static void a(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        a aVarAeY = aeY();
        dVar.a(aVarAeY.aeX());
        c cVarCz = dVar.cz(applicationContext);
        aVarAeY.a(applicationContext, cVarCz, cVarCz.bPC);
        applicationContext.registerComponentCallbacks(cVarCz);
        bPw = cVarCz;
    }

    private static a aeY() {
        return new com.kwad.sdk.glide.webp.a();
    }

    c(Context context, i iVar, com.kwad.sdk.glide.load.engine.a.h hVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, k kVar, com.kwad.sdk.glide.a.d dVar, int i, com.kwad.sdk.glide.request.i iVar2, Map<Class<?>, h<?, ?>> map, List<com.kwad.sdk.glide.request.h<Object>> list, boolean z) {
        this.bPx = iVar;
        this.bPy = eVar;
        this.bPD = bVar;
        this.bPz = hVar;
        this.bPE = kVar;
        this.bPF = dVar;
        this.bPA = new com.kwad.sdk.glide.load.engine.c.a(hVar, eVar, (DecodeFormat) iVar2.agh().a(com.kwad.sdk.glide.load.resource.bitmap.k.bXr));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.bPC = registry;
        registry.a(new j());
        if (Build.VERSION.SDK_INT >= 27) {
            registry.a(new n());
        }
        List<ImageHeaderParser> listAfj = registry.afj();
        com.kwad.sdk.glide.load.resource.bitmap.k kVar2 = new com.kwad.sdk.glide.load.resource.bitmap.k(listAfj, resources.getDisplayMetrics(), eVar, bVar);
        com.kwad.sdk.glide.load.resource.d.a aVar = new com.kwad.sdk.glide.load.resource.d.a(context, listAfj, eVar, bVar);
        com.kwad.sdk.glide.load.g<ParcelFileDescriptor, Bitmap> gVarB = x.b(eVar);
        com.kwad.sdk.glide.load.resource.bitmap.f fVar = new com.kwad.sdk.glide.load.resource.bitmap.f(kVar2);
        u uVar = new u(kVar2, bVar);
        com.kwad.sdk.glide.load.resource.b.d dVar2 = new com.kwad.sdk.glide.load.resource.b.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.kwad.sdk.glide.load.resource.bitmap.c cVar2 = new com.kwad.sdk.glide.load.resource.bitmap.c(bVar);
        com.kwad.sdk.glide.load.resource.e.a aVar3 = new com.kwad.sdk.glide.load.resource.e.a();
        com.kwad.sdk.glide.load.resource.e.d dVar4 = new com.kwad.sdk.glide.load.resource.e.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new com.kwad.sdk.glide.load.c.c()).a(InputStream.class, new t(bVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, fVar).a(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, uVar).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, gVarB).a(com.bumptech.glide.Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, x.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.ahI()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new w()).a(Bitmap.class, (com.kwad.sdk.glide.load.h) cVar2).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, fVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, uVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, gVarB)).a(BitmapDrawable.class, (com.kwad.sdk.glide.load.h) new com.kwad.sdk.glide.load.resource.bitmap.b(eVar, cVar2)).a("Gif", InputStream.class, com.kwad.sdk.glide.load.resource.d.c.class, new com.kwad.sdk.glide.load.resource.d.j(listAfj, aVar, bVar)).a("Gif", ByteBuffer.class, com.kwad.sdk.glide.load.resource.d.c.class, aVar).a(com.kwad.sdk.glide.load.resource.d.c.class, (com.kwad.sdk.glide.load.h) new com.kwad.sdk.glide.load.resource.d.d()).a(com.kwad.sdk.glide.gifdecoder.a.class, com.kwad.sdk.glide.gifdecoder.a.class, v.a.ahI()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, com.kwad.sdk.glide.gifdecoder.a.class, Bitmap.class, new com.kwad.sdk.glide.load.resource.d.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new com.kwad.sdk.glide.load.resource.bitmap.s(dVar2, eVar)).a(new a.C0612a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.kwad.sdk.glide.load.resource.c.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.ahI()).a(new k.a(bVar)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar3).a(Integer.TYPE, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(Integer.TYPE, Uri.class, dVar3).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context)).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context)).a(com.kwad.sdk.glide.load.c.g.class, InputStream.class, new a.C0605a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.ahI()).a(Drawable.class, Drawable.class, v.a.ahI()).a(Drawable.class, Drawable.class, new com.kwad.sdk.glide.load.resource.b.e()).a(Bitmap.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.e.b(resources)).a(Bitmap.class, byte[].class, aVar3).a(Drawable.class, byte[].class, new com.kwad.sdk.glide.load.resource.e.c(eVar, aVar3, dVar4)).a(com.kwad.sdk.glide.load.resource.d.c.class, byte[].class, dVar4);
        this.bPB = new e(context, bVar, registry, new com.kwad.sdk.glide.request.a.f(), iVar2, map, list, iVar, z, i);
    }

    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e aeZ() {
        return this.bPy;
    }

    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b afa() {
        return this.bPD;
    }

    public final Context getContext() {
        return this.bPB.getBaseContext();
    }

    final com.kwad.sdk.glide.a.d afb() {
        return this.bPF;
    }

    final e afc() {
        return this.bPB;
    }

    public final void clearMemory() {
        com.kwad.sdk.glide.e.j.ajB();
        this.bPz.clearMemory();
        this.bPy.clearMemory();
        this.bPD.clearMemory();
    }

    private void fV(int i) {
        com.kwad.sdk.glide.e.j.ajB();
        this.bPz.fV(i);
        this.bPy.fV(i);
        this.bPD.fV(i);
    }

    public final com.kwad.sdk.glide.a.k afd() {
        return this.bPE;
    }

    private static com.kwad.sdk.glide.a.k cx(Context context) {
        ax.f(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return cv(context).afd();
    }

    @Deprecated
    public static g cy(Context context) {
        return cx(context).cC(context.getApplicationContext());
    }

    public static g h(KsFragment ksFragment) {
        return cx(ksFragment.getActivity()).i(ksFragment);
    }

    public final Registry afe() {
        return this.bPC;
    }

    final boolean a(com.kwad.sdk.glide.request.a.j<?> jVar) {
        synchronized (this.bPG) {
            Iterator<g> it = this.bPG.iterator();
            while (it.hasNext()) {
                if (it.next().e(jVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    final void a(g gVar) {
        synchronized (this.bPG) {
            if (this.bPG.contains(gVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.bPG.add(gVar);
        }
    }

    final void b(g gVar) {
        synchronized (this.bPG) {
            if (!this.bPG.contains(gVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.bPG.remove(gVar);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        fV(i);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }
}
