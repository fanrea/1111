package com.dhylive.app.ad.info;

import android.app.Activity;
import kotlin.Metadata;

/* compiled from: InterstitialAd.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0016\u0010\u0003\u001a\u00028\u0000X\u0084\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/dhylive/app/ad/info/InterstitialAd;", "AD", "", "adInfo", "(Ljava/lang/Object;)V", "getAdInfo", "()Ljava/lang/Object;", "Ljava/lang/Object;", "<set-?>", "", "isShow", "()Z", "setShow", "(Z)V", "showAd", "", "activity", "Landroid/app/Activity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class InterstitialAd<AD> {
    private final AD adInfo;
    private boolean isShow;

    public abstract void showAd(Activity activity);

    public InterstitialAd(AD ad) {
        this.adInfo = ad;
    }

    protected final AD getAdInfo() {
        return this.adInfo;
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    protected final void setShow(boolean z) {
        this.isShow = z;
    }
}
