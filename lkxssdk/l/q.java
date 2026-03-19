package lkxssdk.l;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class q {
    public String a;
    public BaseActivity b;
    public boolean c;
    public boolean d;
    public lkxssdk.k.a<String> e;
    public String f;

    public q(BaseActivity baseActivity) {
        this.b = baseActivity;
    }

    public static void a(q qVar, String str) {
        Bitmap.CompressFormat compressFormat;
        StringBuilder sbAppend;
        String str2;
        qVar.getClass();
        if (!Environment.getExternalStorageState().equals(com.component.c.c.a)) {
            lkxssdk.m0.b.a().a("请插入Sdcard，再进行保存", 1);
            qVar.a(1);
            return;
        }
        Bitmap bitmapDecodeByteArray = null;
        if (str.startsWith(com.alipay.sdk.m.l.a.r) || str.startsWith("//")) {
            lkxssdk.a.a.a(str, (View) null, new o(qVar, qVar.a() + ("xswa_" + System.currentTimeMillis()), str));
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length >= 2) {
            String str3 = strArrSplit[0];
            try {
                byte[] bArrDecode = Base64.decode(strArrSplit[1], 0);
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bitmapDecodeByteArray != null) {
                String str4 = "xswa_" + System.currentTimeMillis();
                if (str3.contains("png")) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                    sbAppend = new StringBuilder().append(str4);
                    str2 = PictureMimeType.PNG;
                } else {
                    compressFormat = Bitmap.CompressFormat.JPEG;
                    sbAppend = new StringBuilder().append(str4);
                    str2 = PictureMimeType.JPG;
                }
                String str5 = qVar.a() + sbAppend.append(str2).toString();
                if (!TextUtils.isEmpty(lkxssdk.a.a.a(str5, bitmapDecodeByteArray, compressFormat))) {
                    qVar.b.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(UriUtils.FILE_PREFIX + str5)));
                    lkxssdk.k.a<String> aVar = qVar.e;
                    if (aVar != null) {
                        aVar.b("{\"result\":1}");
                        return;
                    } else {
                        lkxssdk.m0.b.a().a("保存图片成功", 0);
                        return;
                    }
                }
            }
        }
        qVar.a(2);
    }

    public final String a() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory.toString() + "/DCIM/Camera/");
        String str = externalStorageDirectory.toString() + "/DCIM/Camera/";
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public final void a(int i) {
        lkxssdk.k.a<String> aVar = this.e;
        if (aVar != null) {
            aVar.b("{\"result\":0,\"errorCode\":" + i + com.alipay.sdk.m.u.i.d);
        } else {
            lkxssdk.m0.b.a().a("保存图片失败，请稍后重试", 0);
        }
    }
}
