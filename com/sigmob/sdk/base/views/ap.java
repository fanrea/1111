package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ap extends RelativeLayout {
    private ImageView a;
    private int b;

    public ap(final Context context) {
        super(context);
        this.b = Dips.dipsToIntPixels(22.0f, context);
        int iDipsToIntPixels = Dips.dipsToIntPixels(15.0f, context);
        int i = this.b / 2;
        b(iDipsToIntPixels);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setStroke(1, -1);
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setAlpha(102);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams);
    }

    private void b(int width) {
        this.a = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, width);
        layoutParams.addRule(13);
        this.a.setImageBitmap(s.CLOSE_NEW.a());
        this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setImageAlpha(204);
        addView(this.a, layoutParams);
    }

    private void b(final String imageUrl) {
        com.sigmob.sdk.base.common.g.a().getBitmap(imageUrl, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.ap.1
            public void onBitmapLoadFailed() {
            }

            public void onBitmapLoaded(Bitmap bitmap) {
                if (bitmap == null) {
                    SigmobLog.d(String.format("%s returned null bitmap", imageUrl));
                } else {
                    ap.this.a.setImageBitmap(bitmap);
                }
            }
        });
    }

    public void a(final int resId) {
        this.a.setImageResource(resId);
    }

    public void a(final Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }

    public void a(BaseAdUnit adUnit) {
        ImageView imageView;
        s sVar;
        if (adUnit == null || adUnit.getEndcardCloseImage() != 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            setBackground(gradientDrawable);
            int i = this.b;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(13);
            this.a.setLayoutParams(layoutParams);
            imageView = this.a;
            sVar = s.CLOSE_OLD;
        } else {
            imageView = this.a;
            sVar = s.CLOSE_NEW;
        }
        imageView.setImageBitmap(sVar.a());
    }

    public void a(final String imageUrl) {
        String lowerCase = imageUrl.toLowerCase();
        if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://")) {
            b(imageUrl);
        } else if (lowerCase.startsWith(UriUtils.FILE_PREFIX)) {
            try {
                this.a.setImageURI(Uri.fromFile(new File(imageUrl)));
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
    }
}
