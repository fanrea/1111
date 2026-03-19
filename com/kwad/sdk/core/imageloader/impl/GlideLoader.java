package com.kwad.sdk.core.imageloader.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.IImageLoader;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.c;
import com.kwad.sdk.glide.f;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.g;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.resource.bitmap.h;
import com.kwad.sdk.glide.load.resource.bitmap.i;
import com.kwad.sdk.glide.load.resource.bitmap.p;
import com.kwad.sdk.glide.load.resource.bitmap.t;
import com.kwad.sdk.glide.request.a;
import com.kwad.sdk.glide.request.a.b;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GlideLoader implements IImageLoader {
    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void pause() {
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void resume() {
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void setCacheSize(int i) {
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(ImageView imageView, Object obj) {
        f<Drawable> fVarCreateRequestBuilder = createRequestBuilder(imageView, obj);
        if (fVarCreateRequestBuilder == null) {
            return;
        }
        fVarCreateRequestBuilder.b(imageView);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(ImageView imageView, Object obj, ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener == null) {
            load(imageView, obj);
        }
        f<Drawable> fVarCreateRequestBuilder = createRequestBuilder(imageView, obj);
        if (fVarCreateRequestBuilder == null) {
            return;
        }
        a aVar = new a();
        fVarCreateRequestBuilder.b(aVar).b((f<Drawable>) new BaseDrawableImageViewTarget(imageView, obj.toString(), imageLoadingListener, aVar));
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(ImageView imageView, Object obj, AdTemplate adTemplate) {
        KSImageLoader.InnerImageLoadingListener innerImageLoadingListener = new KSImageLoader.InnerImageLoadingListener(adTemplate, null);
        f<Bitmap> fVarCreateRequestBuilder2 = createRequestBuilder2(imageView, obj);
        if (fVarCreateRequestBuilder2 == null) {
            return;
        }
        if (obj instanceof String) {
            fVarCreateRequestBuilder2.b((f<Bitmap>) new BaseBitmapImageViewTarget(imageView, (String) obj, innerImageLoadingListener));
        } else {
            fVarCreateRequestBuilder2.b((f<Bitmap>) new b(imageView));
        }
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(Context context, ImageView imageView, Object obj, int i, int i2) throws Resources.NotFoundException {
        f<Drawable> fVarCreateRequestBuilder = createRequestBuilder(imageView, obj);
        if (fVarCreateRequestBuilder == null) {
            return;
        }
        Drawable drawable = context.getResources().getDrawable(i2);
        fVarCreateRequestBuilder.d(drawable).f(context.getResources().getDrawable(i)).b(imageView);
    }

    private f<Drawable> createRequestBuilder(ImageView imageView, Object obj) {
        g gVarWith = with(imageView);
        if (gVarWith != null) {
            return loadModel(gVarWith.afr(), obj);
        }
        return null;
    }

    private f<Bitmap> createRequestBuilder2(ImageView imageView, Object obj) {
        g gVarWith = with(imageView);
        if (gVarWith != null) {
            return loadModel(gVarWith.afq(), obj);
        }
        return null;
    }

    private <T> f<T> loadModel(f<T> fVar, Object obj) {
        if (obj instanceof String) {
            return fVar.hh((String) obj);
        }
        if (obj instanceof byte[]) {
            return fVar.g((byte[]) obj);
        }
        return fVar.u(obj);
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(KsFragment ksFragment, String str, ImageView imageView, Drawable drawable, Drawable drawable2) {
        c.h(ksFragment).hh(str).d(drawable).f(drawable2).b(imageView);
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(KsFragment ksFragment, String str, ImageView imageView, Drawable drawable, Drawable drawable2, float f) {
        c.h(ksFragment).hh(str).d(drawable).f(drawable2).a(new com.kwad.sdk.glide.load.resource.bitmap.g(), new t(com.kwad.sdk.c.a.a.a(ksFragment.getContext(), f))).b(imageView);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        g gVarWith = with(imageView);
        if (gVarWith == null) {
            return;
        }
        if (displayImageOptionsCompat.isFrameSequence()) {
            f fVarI = gVarWith.i(FrameSequence.class);
            a aVar = new a();
            fVarI.b(aVar);
            into(fVarI, str, context, displayImageOptionsCompat, new FrameSequenceImageViewTarget(imageView, aVar, str, imageLoadingListener));
            return;
        }
        f<Bitmap> fVarAfq = gVarWith.afq();
        configOptions(fVarAfq, displayImageOptionsCompat, imageView);
        a aVar2 = new a();
        fVarAfq.b(aVar2);
        into(fVarAfq, str, context, displayImageOptionsCompat, new BaseBitmapImageViewTarget(imageView, str, imageLoadingListener, aVar2));
    }

    private <T> void into(f<T> fVar, String str, Context context, DisplayImageOptionsCompat displayImageOptionsCompat, j<T> jVar) {
        Resources resources = context.getResources();
        fVar.f(displayImageOptionsCompat.getImageOnFail(resources)).d(displayImageOptionsCompat.getImageOnLoading(resources)).e(displayImageOptionsCompat.getImageForEmptyUri(resources));
        fVar.hh(str).b((f<T>) jVar);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        load(c.cy(context), str, context, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(KsFragment ksFragment, Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        load(c.h(ksFragment), str, context, displayImageOptionsCompat, imageLoadingListener);
    }

    private void load(g gVar, String str, Context context, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (displayImageOptionsCompat.isFrameSequence()) {
            f fVarI = gVar.i(FrameSequence.class);
            a aVar = new a();
            fVarI.b(aVar);
            into(fVarI, str, context, displayImageOptionsCompat, new DecodeFrameSequenceTarget(str, imageLoadingListener, aVar));
            return;
        }
        f<Bitmap> fVarAfq = gVar.afq();
        configOptions(fVarAfq, displayImageOptionsCompat, null);
        a aVar2 = new a();
        fVarAfq.b(aVar2);
        into(fVarAfq, str, context, displayImageOptionsCompat, new DecodeBitmapTargedt(str, imageLoadingListener, aVar2));
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void clearMemory(Context context) {
        c.cv(context).clearMemory();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public File isImageExistOnDisk(String str) {
        try {
            return (File) ((com.kwad.sdk.glide.request.g) c.cy(ServiceProvider.getContext()).afs().hh(str).a(new com.kwad.sdk.glide.webp.a.a().cT(true)).afl()).get();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public Bitmap loadImageSync(String str) {
        try {
            return c.cy(ServiceProvider.getContext()).afq().hh(str).M(1080, 2340).get();
        } catch (Exception unused) {
            return null;
        }
    }

    private void configOptions(f<Bitmap> fVar, DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        if (imageView != null) {
            int i = AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
            if (i == 1) {
                arrayList.add(new com.kwad.sdk.glide.load.resource.bitmap.g());
            } else if (i == 2) {
                arrayList.add(new h());
            }
        }
        if (displayImageOptionsCompat.getBlurRadius() > 0) {
            arrayList.add(new BlurBitmapTransformation(displayImageOptionsCompat.getBlurRadius()));
        }
        if (displayImageOptionsCompat.getCornerRound() > 0) {
            arrayList.add(new t(displayImageOptionsCompat.getCornerRound()));
        } else if (displayImageOptionsCompat.isCircle()) {
            if (displayImageOptionsCompat.getStrokeWidth() > 0.0f) {
                arrayList.add(new p(displayImageOptionsCompat.getStrokeWidth(), displayImageOptionsCompat.getStrokeColor()));
            } else {
                arrayList.add(new i());
            }
        }
        if (!arrayList.isEmpty()) {
            fVar.a((com.kwad.sdk.glide.load.i<Bitmap>[]) arrayList.toArray(new com.kwad.sdk.glide.load.i[arrayList.size()]));
        }
        if (displayImageOptionsCompat.getDecodingOptions().inPreferredConfig == Bitmap.Config.RGB_565) {
            fVar.a(DecodeFormat.PREFER_RGB_565);
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.impl.GlideLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static g with(View view) {
        return c.cy(view.getContext());
    }
}
