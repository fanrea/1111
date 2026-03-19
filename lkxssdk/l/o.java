package lkxssdk.l;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.luck.picture.lib.config.PictureMimeType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class o implements lkxssdk.g0.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ q c;

    public o(q qVar, String str, String str2) {
        this.c = qVar;
        this.a = str;
        this.b = str2;
    }

    @Override // lkxssdk.g0.a
    public void a(String str, View view, Bitmap bitmap) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        String str2;
        Bitmap.CompressFormat compressFormat;
        String str3 = this.a;
        if (this.b.toLowerCase().contains(PictureMimeType.PNG)) {
            str2 = str3 + PictureMimeType.PNG;
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            str2 = str3 + PictureMimeType.JPG;
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if (TextUtils.isEmpty(lkxssdk.a.a.a(str2, bitmap, compressFormat))) {
            this.c.a(2);
            return;
        }
        this.c.b.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(UriUtils.FILE_PREFIX + str2)));
        lkxssdk.k.a<String> aVar = this.c.e;
        if (aVar != null) {
            aVar.b("{\"result\":1}");
        } else {
            lkxssdk.m0.b.a().a("保存图片成功", 0);
        }
    }

    @Override // lkxssdk.g0.a
    public void a(String str, View view, String str2) {
        this.c.a(2);
    }
}
