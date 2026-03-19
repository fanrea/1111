package com.sigmob.sdk.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageTypeUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.views.gif.e;
import com.sigmob.windad.WindAds;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends b {
    private final com.sigmob.sdk.base.views.gif.e b;
    private ImageView c;
    private float d;
    private boolean e;

    public c(Context context) {
        super(context);
        this.e = false;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.sigmob.sdk.base.views.gif.e eVar = new com.sigmob.sdk.base.views.gif.e(context);
        this.b = eVar;
        setBackgroundColor(-1);
        addView(eVar, layoutParams);
    }

    private void a(final Bitmap bitmap) {
        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.c$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Bitmap bitmap) {
        if (bitmap == null || this.c != null) {
            return;
        }
        com.sigmob.sdk.base.blurkit.a.a(getContext());
        this.c = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.setImageBitmap(com.sigmob.sdk.base.blurkit.a.a().a(bitmap, 25, 1.0f));
        addView(this.c, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap c(Bitmap bitmap) {
        if (!this.e) {
            this.e = true;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (height > 0 && width > 0) {
                if ((width * 1.0d) / height < this.d) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.c$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.e();
                        }
                    });
                } else {
                    a(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.sigmob.sdk.splash.b
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.sigmob.sdk.splash.b
    public boolean a(BaseAdUnit adUnit) {
        Bitmap bitmapDecodeFile;
        if (adUnit == null || adUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        String splashFilePath = adUnit.getSplashFilePath();
        String fileType = ImageTypeUtil.getFileType(splashFilePath);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        if (fileType.equals("gif")) {
            this.b.setBytes(FileUtil.readBytes(splashFilePath));
            this.b.setOnFrameAvailable(new e.c() { // from class: com.sigmob.sdk.splash.c$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.views.gif.e.c
                public final Bitmap onFrameAvailable(Bitmap bitmap) {
                    return this.f$0.c(bitmap);
                }
            });
            this.b.d();
        } else {
            if (!Arrays.asList("git", "jpeg", "jpg", "png", "bmp", "webp", "tif").contains(fileType) || (bitmapDecodeFile = BitmapFactory.decodeFile(splashFilePath)) == null) {
                return false;
            }
            this.b.setImageBitmap(bitmapDecodeFile);
            int width = bitmapDecodeFile.getWidth();
            int height = bitmapDecodeFile.getHeight();
            if (height > 0 && width > 0) {
                if ((width * 1.0d) / height < this.d) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.c$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.d();
                        }
                    });
                } else {
                    a(bitmapDecodeFile);
                }
            }
        }
        BaseBroadcastReceiver.a(getContext(), adUnit.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        return true;
    }

    @Override // com.sigmob.sdk.splash.b
    public void b() {
        super.b();
        com.sigmob.sdk.base.views.gif.e eVar = this.b;
        if (eVar == null) {
            return;
        }
        eVar.e();
    }

    @Override // com.sigmob.sdk.splash.b
    public void c() {
        super.c();
        com.sigmob.sdk.base.views.gif.e eVar = this.b;
        if (eVar == null) {
            return;
        }
        eVar.d();
    }

    @Override // com.sigmob.sdk.splash.b
    public /* bridge */ /* synthetic */ int getDuration() {
        return super.getDuration();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.sigmob.sdk.base.views.gif.e eVar = this.b;
        if (eVar != null) {
            eVar.clearAnimation();
        }
        if (this.c != null) {
            this.c = null;
        }
        removeAllViews();
    }

    @Override // com.sigmob.sdk.splash.b
    public void setAspectRatio(float aspectRatio) {
        this.d = aspectRatio;
    }
}
