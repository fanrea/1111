package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import com.sigmob.sdk.base.views.gif.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements a.InterfaceC0730a {
    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0730a
    public Bitmap a(int width, int height, Bitmap.Config config) {
        return Bitmap.createBitmap(width, height, config);
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0730a
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0730a
    public void a(byte[] bytes) {
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0730a
    public void a(int[] array) {
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0730a
    public byte[] a(int size) {
        return new byte[size];
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0730a
    public int[] b(int size) {
        return new int[size];
    }
}
