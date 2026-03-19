package com.bytedance.sdk.djx.core.vod.thumb;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.ThumbM;
import com.bytedance.sdk.djx.model.ev.BEThumbCome;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThumbTask {
    private static final String TAG = "ThumbTask";
    private boolean mCanceled = false;
    private final DramaDetail mDramaDetail;
    private final List<ThumbM> mThumbs;

    public ThumbTask(List<ThumbM> list, DramaDetail dramaDetail) {
        this.mThumbs = list;
        this.mDramaDetail = dramaDetail;
    }

    public void handleThumb(final long j, final long j2) {
        List<ThumbM> list;
        final ThumbM thumbM;
        if (this.mCanceled || (list = this.mThumbs) == null || list.isEmpty() || (thumbM = this.mThumbs.get(0)) == null) {
            return;
        }
        TTExecutor.get().executeDefaultTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.vod.thumb.ThumbTask.1
            public void run() {
                Bitmap thumbBitmap;
                if (ThumbTask.this.mCanceled || (thumbBitmap = ThumbDownloadHandler.inst().getThumbBitmap(ThumbTask.this.mDramaDetail, thumbM, j, j2)) == null) {
                    return;
                }
                ThumbTask.this.cutThumb(thumbBitmap, thumbM, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cutThumb(Bitmap bitmap, ThumbM thumbM, long j, long j2) {
        if (this.mCanceled || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iMin = Math.min(Float.valueOf((j / 1000.0f) / (thumbM.interval != 0.0f ? thumbM.interval : 1.0f)).intValue(), thumbM.total - 1);
            Rect rect = new Rect();
            rect.left = (iMin % thumbM.xLen) * thumbM.width;
            rect.top = ((iMin / thumbM.yLen) % thumbM.yLen) * thumbM.height;
            rect.right = rect.left + thumbM.width;
            rect.bottom = rect.top + thumbM.height;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), (Matrix) null, true);
            ThumbLog.cut(this.mDramaDetail, thumbM, System.currentTimeMillis() - jCurrentTimeMillis);
            if (!this.mCanceled) {
                DramaDetail dramaDetail = this.mDramaDetail;
                if (dramaDetail == null || dramaDetail.getDrama() == null) {
                    return;
                }
                new BEThumbCome(this.mDramaDetail.getDrama().id, this.mDramaDetail.getIndex(), bitmapCreateBitmap).send();
                return;
            }
            if (bitmapCreateBitmap.isRecycled()) {
                return;
            }
            bitmapCreateBitmap.recycle();
        } catch (Exception unused) {
        }
    }

    public void cancel() {
        this.mCanceled = true;
    }
}
