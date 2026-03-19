package com.kwad.sdk.service.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface i {
    void load(Context context, ImageView imageView, Object obj, int i, int i2);

    void load(ImageView imageView, Object obj);

    void load(ImageView imageView, Object obj, AdTemplate adTemplate);

    void load(KsFragment ksFragment, String str, ImageView imageView, Drawable drawable, Drawable drawable2);

    void load(KsFragment ksFragment, String str, ImageView imageView, Drawable drawable, Drawable drawable2, float f);
}
