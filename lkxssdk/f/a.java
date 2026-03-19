package lkxssdk.f;

import android.graphics.Bitmap;
import android.view.View;
import com.lingku.xuanshang.core.ui.imagepicker.preview.PicPreviewAcitvity;
import com.lingku.xuanshang.core.ui.imagepicker.preview.photoview.PhotoView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements lkxssdk.g0.a {
    public final /* synthetic */ PhotoView a;

    public a(PicPreviewAcitvity.b bVar, PhotoView photoView) {
        this.a = photoView;
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
