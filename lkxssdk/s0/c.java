package lkxssdk.s0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class c extends BitmapDrawable implements d {
    public b a;

    public c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // lkxssdk.s0.d
    public b getMemCacheKey() {
        return this.a;
    }

    @Override // lkxssdk.s0.d
    public void setMemCacheKey(b bVar) {
        this.a = bVar;
    }
}
