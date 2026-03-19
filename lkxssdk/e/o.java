package lkxssdk.e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.lingku.xuanshang.core.ui.imagepicker.PickerActivity;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import lkxssdk.e.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class o implements v.c {
    public final /* synthetic */ PickerActivity a;

    public o(PickerActivity pickerActivity) {
        this.a = pickerActivity;
    }

    @Override // lkxssdk.e.v.c
    public void a() {
        PickerActivity pickerActivity = this.a;
        int i = PickerActivity.d;
        pickerActivity.getClass();
        if (i.b().l) {
            x xVarJ = pickerActivity.j();
            Context applicationContext = xVarJ.a.getApplicationContext();
            File file = new File(xVarJ.a.getApplicationContext().getExternalFilesDir("XSWFile").getAbsolutePath() + File.separator + "temp");
            if (!file.exists()) {
                file.mkdirs();
            }
            xVarJ.c = x.a(applicationContext, new File(file, "pic_" + System.currentTimeMillis() + PictureMimeType.JPG));
            Intent intent = new Intent();
            intent.addFlags(1);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", xVarJ.c);
            if (xVarJ.a.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
                ((PickerActivity.g) xVarJ.b).a("很抱歉，无法打开相机");
                return;
            } else {
                xVarJ.a.startActivityForResult(intent, 1000001);
                return;
            }
        }
        int i2 = i.b().k;
        if (i2 == 3) {
            i2 = 0;
        }
        x xVarJ2 = pickerActivity.j();
        int i3 = i.b().j;
        Context applicationContext2 = xVarJ2.a.getApplicationContext();
        File file2 = new File(xVarJ2.a.getApplicationContext().getExternalFilesDir("XSWFile").getAbsolutePath() + File.separator + "temp");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        xVarJ2.c = x.a(applicationContext2, new File(file2, "video_" + System.currentTimeMillis() + ".mp4"));
        Intent intent2 = new Intent();
        if (Build.VERSION.SDK_INT >= 24) {
            intent2.addFlags(1);
        }
        intent2.setAction("android.media.action.VIDEO_CAPTURE");
        intent2.putExtra("output", xVarJ2.c);
        intent2.putExtra("android.intent.extra.videoQuality", (i2 == 0 || i2 == 1) ? i2 : 1);
        if (i3 > 0) {
            intent2.putExtra("android.intent.extra.durationLimit", i3);
        }
        if (xVarJ2.a.getPackageManager().queryIntentActivities(intent2, 65536).isEmpty()) {
            ((PickerActivity.g) xVarJ2.b).a("很抱歉，无法打开相机");
        } else {
            xVarJ2.a.startActivityForResult(intent2, 1000002);
        }
    }
}
