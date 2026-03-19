package com.kwai.video.ksvodplayerkit.prefetcher;

import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final /* synthetic */ class KSPrefetcher$$Lambda$1 implements Comparator {
    private static final KSPrefetcher$$Lambda$1 instance = new KSPrefetcher$$Lambda$1();

    private KSPrefetcher$$Lambda$1() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return KSPrefetcher.lambda$checkRunningTaskLimit$0((BasePrefetchModel) obj, (BasePrefetchModel) obj2);
    }
}
