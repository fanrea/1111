package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.qq.e.comm.plugin.i5;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c8 {
    public static void a(Object obj, ImageView imageView, Bitmap bitmap, int i, JSONArray jSONArray) {
        if (bitmap == null || i == 0 || jSONArray == null || i != 1) {
            return;
        }
        a(obj, bitmap, imageView, jSONArray);
    }

    /* compiled from: A */
    class a implements i5.c {
        final /* synthetic */ ImageView a;

        a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.qq.e.comm.plugin.i5.c
        public void a(ko koVar) {
            this.a.setImageBitmap(koVar.b());
        }
    }

    private static void a(Object obj, Bitmap bitmap, ImageView imageView, JSONArray jSONArray) {
        float fOptDouble = (float) jSONArray.optDouble(0);
        if (fOptDouble <= 0.0f) {
            return;
        }
        if (fOptDouble > 25.0f) {
            fOptDouble = 25.0f;
        }
        i5.a(obj, bitmap, fOptDouble, new a(imageView));
    }
}
