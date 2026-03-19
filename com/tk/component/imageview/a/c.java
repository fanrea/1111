package com.tk.component.imageview.a;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tk.component.imageview.model.TKCDNUrl;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface c {

    public interface a {
        void a(BitmapDrawable bitmapDrawable);
    }

    void a(ImageView imageView, String str, Drawable drawable, int i, a aVar);

    void a(ImageView imageView, String str, String str2, String str3, int i, int i2, int i3, a aVar);

    void a(ImageView imageView, List<TKCDNUrl> list, int i, int i2, int i3, a aVar);

    void a(ImageView imageView, List<TKCDNUrl> list, int i, int i2, Drawable drawable, int i3, a aVar);

    void a(ImageView imageView, List<TKCDNUrl> list, String str, String str2, int i, int i2, int i3);

    void a(String str, ImageView imageView, int i, a aVar);
}
