package com.sigmob.sdk.splash;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class f extends b {
    private final com.sigmob.sdk.base.views.c b;
    private final BaseAdUnit c;

    public f(Context context, BaseAdUnit adUnit) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.sigmob.sdk.base.views.c cVar = new com.sigmob.sdk.base.views.c(context);
        this.b = cVar;
        setBackgroundColor(-16777216);
        this.c = adUnit;
        addView(cVar, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MediaPlayer mediaPlayer) throws IllegalStateException {
        this.a = mediaPlayer.getDuration() / 1000;
        mediaPlayer.setVolume(0.0f, 0.0f);
        mediaPlayer.start();
        BaseBroadcastReceiver.a(getContext(), this.c.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        SigmobLog.i("video onPrepared");
    }

    @Override // com.sigmob.sdk.splash.b
    public void a() throws IllegalStateException {
        super.setVisibility(0);
        SigmobLog.i("video showAd");
        this.b.setVisibility(0);
        this.b.d();
    }

    @Override // com.sigmob.sdk.splash.b
    public boolean a(BaseAdUnit adUnit) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (adUnit == null || adUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        this.b.a(0, 0);
        this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.sigmob.sdk.splash.f$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                this.f$0.a(mediaPlayer);
            }
        });
        this.b.setVideoPath(adUnit.getSplashFilePath());
        return true;
    }

    @Override // com.sigmob.sdk.splash.b
    public void b() throws IllegalStateException {
        this.b.a();
    }

    @Override // com.sigmob.sdk.splash.b
    public void c() throws IllegalStateException {
        this.b.b();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility == 8) {
            try {
                if (this.b != null) {
                    SigmobLog.i("video GONE");
                    this.b.c();
                    removeAllViews();
                }
            } catch (Throwable th) {
                SigmobLog.e("set splash ad video content error: " + th.getMessage());
            }
        }
        super.setVisibility(visibility);
    }
}
