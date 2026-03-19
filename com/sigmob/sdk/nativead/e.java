package com.sigmob.sdk.nativead;

import android.os.Bundle;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends com.sigmob.sdk.base.common.w {
    private NativeAdBroadcastReceiver c;

    interface a extends n.b, n.c {
        void c();

        void d();

        void e();
    }

    protected e(n.b customEventInterstitialListener) {
        super(customEventInterstitialListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        File adPrivacyTemplateFile = this.b.getAdPrivacyTemplateFile();
        if (adPrivacyTemplateFile == null || adPrivacyTemplateFile.exists()) {
            return;
        }
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.url = this.b.getadPrivacy().privacy_template_url;
        downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
        downloadItem.type = DownloadItem.FileType.OTHER;
        FileDownloader fileDownloaderA = com.sigmob.sdk.base.common.q.a();
        if (fileDownloaderA == null) {
            return;
        }
        fileDownloaderA.add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.nativead.e.1
            public void downloadProgress(DownloadItem item, long totalSize, long readSize) {
            }

            public void onCancel(DownloadItem item) {
            }

            public void onErrorResponse(DownloadItem item) {
            }

            public void onSuccess(DownloadItem item) {
            }
        });
    }

    private static boolean a(MaterialMeta material) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.w
    protected void a(n.b customEventInterstitialListener) {
        ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.sigmob.sdk.nativead.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.w
    public void a(BaseAdUnit baseAdUnit, Bundle option) {
        super.a(baseAdUnit, option);
        if (this.c == null && (this.a instanceof a)) {
            NativeAdBroadcastReceiver nativeAdBroadcastReceiver = new NativeAdBroadcastReceiver((a) this.a, baseAdUnit.getUuid());
            this.c = nativeAdBroadcastReceiver;
            nativeAdBroadcastReceiver.a(nativeAdBroadcastReceiver);
        }
        AdActivity.a(com.sigmob.sdk.b.e(), AdActivity.class, baseAdUnit.getUuid(), option, BaseAdActivity.e);
    }

    @Override // com.sigmob.sdk.base.common.w
    protected boolean a(BaseAdUnit adUnit) {
        if (adUnit.getMaterial() == null) {
            return false;
        }
        return a(adUnit.getMaterial());
    }

    @Override // com.sigmob.sdk.base.common.w
    public void b(BaseAdUnit baseAdUnit) {
        NativeAdBroadcastReceiver nativeAdBroadcastReceiver = this.c;
        if (nativeAdBroadcastReceiver != null) {
            nativeAdBroadcastReceiver.b(nativeAdBroadcastReceiver);
            this.c = null;
        }
        super.b(baseAdUnit);
    }
}
