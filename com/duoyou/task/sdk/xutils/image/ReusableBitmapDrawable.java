package com.duoyou.task.sdk.xutils.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ReusableBitmapDrawable extends BitmapDrawable implements ReusableDrawable {
    private MemCacheKey key;

    public ReusableBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // com.duoyou.task.sdk.xutils.image.ReusableDrawable
    public MemCacheKey getMemCacheKey() {
        return this.key;
    }

    @Override // com.duoyou.task.sdk.xutils.image.ReusableDrawable
    public void setMemCacheKey(MemCacheKey memCacheKey) {
        this.key = memCacheKey;
    }
}
