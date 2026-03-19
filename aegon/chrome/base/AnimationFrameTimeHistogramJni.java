package aegon.chrome.base;

import K.S;
import aegon.chrome.base.AnimationFrameTimeHistogram;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class AnimationFrameTimeHistogramJni implements AnimationFrameTimeHistogram.Natives {
    public static final JniStaticTestMocker<AnimationFrameTimeHistogram.Natives> TEST_HOOKS = new JniStaticTestMocker<AnimationFrameTimeHistogram.Natives>() { // from class: aegon.chrome.base.AnimationFrameTimeHistogramJni.1
        @Override // aegon.chrome.base.JniStaticTestMocker
        public void setInstanceForTesting(AnimationFrameTimeHistogram.Natives natives) {
            AnimationFrameTimeHistogram.Natives unused = AnimationFrameTimeHistogramJni.testInstance = natives;
        }
    };
    private static AnimationFrameTimeHistogram.Natives testInstance;

    AnimationFrameTimeHistogramJni() {
    }

    @Override // aegon.chrome.base.AnimationFrameTimeHistogram.Natives
    public final void saveHistogram(String str, long[] jArr, int i) {
        S.M7xB0tc0(str, jArr, i);
    }

    public static AnimationFrameTimeHistogram.Natives get() {
        if (S.a) {
            AnimationFrameTimeHistogram.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (S.b) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.AnimationFrameTimeHistogram.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        return new AnimationFrameTimeHistogramJni();
    }
}
