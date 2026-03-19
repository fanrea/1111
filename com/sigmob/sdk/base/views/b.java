package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends RelativeLayout {
    private static float d = 8.0f;
    private static final float e = 1.0f;
    private final int a;
    private ImageView b;
    private TextView c;

    public b(Context context, int type) {
        super(context);
        this.a = type;
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        imageView.setId(ClientMetadata.generateViewId());
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setTextColor(Color.parseColor("#B9B9B9"));
        this.c.setTextSize(1, 12.0f);
        int iDipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, context));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, context));
        this.c.setGravity(17);
        this.b.setScaleType(ImageView.ScaleType.FIT_START);
        this.b.setAdjustViewBounds(true);
        this.b.setMaxWidth(Dips.dipsToIntPixels(40.0f, context));
        this.b.setMinimumWidth(Dips.dipsToIntPixels(16.0f, context));
        if (type == 1) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(12);
            int i = iDipsToIntPixels * 2;
            layoutParams2.setMargins(iDipsToIntPixels, 0, 0, i);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, iDipsToIntPixels, i);
        } else {
            layoutParams.setMargins(iDipsToIntPixels, 0, 0, 0);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams2.addRule(1, this.b.getId());
            layoutParams2.addRule(8, this.b.getId());
        }
        this.b.setBackgroundColor(Color.alpha(0));
        addView(this.b, layoutParams);
        addView(this.c, layoutParams2);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b.setImageBitmap(bitmap);
    }

    public void a(String url) {
        com.sigmob.sdk.base.common.g.a().getBitmap(url, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.base.views.b.1
            public void onBitmapLoadFailed() {
            }

            public void onBitmapLoaded(Bitmap bitmap) {
                int iDipsToIntPixels = Dips.dipsToIntPixels(3.0f, b.this.getContext());
                if (bitmap == null) {
                    return;
                }
                if (b.this.a != 1 && bitmap.getWidth() > bitmap.getHeight() * 1.5f) {
                    ((RelativeLayout.LayoutParams) b.this.b.getLayoutParams()).setMargins((-iDipsToIntPixels) * (bitmap.getWidth() / bitmap.getHeight()), 0, 0, 0);
                }
                b.this.b.setImageBitmap(bitmap);
            }
        });
    }

    public void b(String adText) {
        try {
            this.c.setText(adText);
        } catch (Throwable th) {
            SigmobLog.e("showAdText error", th);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener listener) {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(listener);
    }
}
