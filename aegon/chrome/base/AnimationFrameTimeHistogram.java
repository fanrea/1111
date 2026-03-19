package aegon.chrome.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeAnimator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class AnimationFrameTimeHistogram {
    private static final int MAX_FRAME_TIME_NUM = 600;
    private static final String TAG = "AnimationFrameTimeHistogram";
    private final String mHistogramName;
    private final Recorder mRecorder = new Recorder();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    interface Natives {
        void saveHistogram(String str, long[] jArr, int i);
    }

    public static Animator.AnimatorListener getAnimatorRecorder(String str) {
        return new AnimatorListenerAdapter(str) { // from class: aegon.chrome.base.AnimationFrameTimeHistogram.1
            private final AnimationFrameTimeHistogram mAnimationFrameTimeHistogram;
            final /* synthetic */ String val$histogramName;

            {
                this.val$histogramName = str;
                this.mAnimationFrameTimeHistogram = new AnimationFrameTimeHistogram(str);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.mAnimationFrameTimeHistogram.startRecording();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.mAnimationFrameTimeHistogram.endRecording();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.mAnimationFrameTimeHistogram.endRecording();
            }
        };
    }

    public AnimationFrameTimeHistogram(String str) {
        this.mHistogramName = str;
    }

    public void startRecording() {
        this.mRecorder.startRecording();
    }

    public void endRecording() {
        if (this.mRecorder.endRecording()) {
            AnimationFrameTimeHistogramJni.get().saveHistogram(this.mHistogramName, this.mRecorder.getFrameTimesMs(), this.mRecorder.getFrameTimesCount());
        }
        this.mRecorder.cleanUp();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class Recorder implements TimeAnimator.TimeListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final TimeAnimator mAnimator;
        private int mFrameTimesCount;
        private long[] mFrameTimesMs;

        private Recorder() {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.mAnimator = timeAnimator;
            timeAnimator.setTimeListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startRecording() {
            this.mFrameTimesCount = 0;
            this.mFrameTimesMs = new long[600];
            this.mAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean endRecording() {
            boolean zIsStarted = this.mAnimator.isStarted();
            this.mAnimator.end();
            return zIsStarted;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long[] getFrameTimesMs() {
            return this.mFrameTimesMs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getFrameTimesCount() {
            return this.mFrameTimesCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanUp() {
            this.mFrameTimesMs = null;
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
            int i = this.mFrameTimesCount;
            long[] jArr = this.mFrameTimesMs;
            if (i == jArr.length) {
                this.mAnimator.end();
                cleanUp();
                android.util.Log.w(AnimationFrameTimeHistogram.TAG, "Animation frame time recording reached the maximum number. It's eitherthe animation took too long or recording end is not called.");
            } else if (j2 > 0) {
                this.mFrameTimesCount = i + 1;
                jArr[i] = j2;
            }
        }
    }
}
