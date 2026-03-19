package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.i5;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c4 {

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ mh b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        a(ViewGroup viewGroup, mh mhVar, String str, int i) {
            this.a = viewGroup;
            this.b = mhVar;
            this.c = str;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            int measuredWidth = this.a.getMeasuredWidth();
            int measuredHeight = this.b.r().getMeasuredHeight();
            int measuredWidth2 = this.b.r().getMeasuredWidth();
            int measuredHeight2 = this.b.r().getMeasuredHeight();
            if (measuredWidth > measuredWidth2 || measuredHeight > measuredHeight2) {
                c4.b(this.a, this.c, this.d);
            }
        }
    }

    public static void a(ViewGroup viewGroup, String str, mh mhVar) throws JSONException {
        a(viewGroup, str, mhVar, false);
    }

    /* compiled from: A */
    class b implements i5.c {
        final /* synthetic */ ImageView a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ long c;

        b(ImageView imageView, ViewGroup viewGroup, long j) {
            this.a = imageView;
            this.b = viewGroup;
            this.c = j;
        }

        @Override // com.qq.e.comm.plugin.i5.c
        public void a(ko koVar) {
            c4.b(this.a, koVar.b(), this.b, this.c);
        }
    }

    public static void a(ViewGroup viewGroup, String str, mh mhVar, boolean z) throws JSONException {
        a(viewGroup, str, mhVar, Color.parseColor("#88444444"), z);
    }

    public static void a(ViewGroup viewGroup, String str, mh mhVar, int i, boolean z) throws JSONException {
        if (a() || viewGroup == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        View viewFindViewWithTag = viewGroup.findViewWithTag("blurImage");
        View viewFindViewWithTag2 = viewGroup.findViewWithTag("blurBG");
        if (viewFindViewWithTag != null && viewFindViewWithTag2 != null) {
            viewFindViewWithTag.setVisibility(0);
            viewFindViewWithTag2.setVisibility(0);
        } else if (z) {
            b(viewGroup, str, i);
        } else {
            if (mhVar == null) {
                return;
            }
            viewGroup.postDelayed(new a(viewGroup, mhVar, str, i), 50L);
        }
    }

    private static boolean a() {
        return r1.d().f().a("videoBGBlur", 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ImageView imageView, Bitmap bitmap, ViewGroup viewGroup, long j) {
        if (bitmap == null || bitmap.isRecycled() || viewGroup == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup.addView(imageView, 0);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        wt wtVar = new wt(2030019);
        wtVar.b(jCurrentTimeMillis);
        b10.a(wtVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ViewGroup viewGroup, String str, int i) throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setTag("blurImage");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = new ImageView(viewGroup.getContext());
        imageView2.setTag("blurBG");
        imageView2.setLayoutParams(layoutParams);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setBackgroundColor(i);
        viewGroup.addView(imageView2, 0);
        i5.a(str, 3.0f, new b(imageView, viewGroup, jCurrentTimeMillis));
    }
}
