package lkxssdk.e;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b implements lkxssdk.g0.a {
    public final /* synthetic */ ImageView a;

    public b(d dVar, ImageView imageView) {
        this.a = imageView;
    }

    @Override // lkxssdk.g0.a
    public void a(String str, View view, Bitmap bitmap) {
        if (bitmap != null) {
            this.a.setImageBitmap(bitmap);
        }
    }

    @Override // lkxssdk.g0.a
    public void a(String str, View view, String str2) {
    }
}
