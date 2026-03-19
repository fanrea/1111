package com.ss.texturerender.vsync;

import android.os.Handler;
import android.os.Looper;
import com.ss.texturerender.TextureRenderLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LocalVsyncHelper implements IVsyncHelper {
    private static String TAG = "TR_VsyncHelperFactory";
    private boolean mEnable;
    private long mPostDelayedMS;
    private int mTexType;
    Runnable mRunnable = new Runnable() { // from class: com.ss.texturerender.vsync.LocalVsyncHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (LocalVsyncHelper.this.mCallbackList == null || LocalVsyncHelper.this.mCallbackList.size() <= 0 || !LocalVsyncHelper.this.mEnable) {
                return;
            }
            Iterator it = LocalVsyncHelper.this.mCallbackList.iterator();
            while (it.hasNext()) {
                ((IVsyncCallback) it.next()).notifyVsync();
            }
            LocalVsyncHelper.this.mMainHandler.postDelayed(this, LocalVsyncHelper.this.mPostDelayedMS);
        }
    };
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private ArrayList<IVsyncCallback> mCallbackList = new ArrayList<>();

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void update() {
    }

    public LocalVsyncHelper(int i, float f) {
        this.mTexType = -1;
        this.mPostDelayedMS = (long) (1000.0f / f);
        this.mTexType = i;
        TextureRenderLog.d(i, TAG, "new LocalVsyncHelper,fps:" + f);
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void addObserver(IVsyncCallback iVsyncCallback) {
        ArrayList<IVsyncCallback> arrayList = this.mCallbackList;
        if (arrayList == null || arrayList.contains(iVsyncCallback)) {
            return;
        }
        this.mCallbackList.add(iVsyncCallback);
        if (this.mCallbackList.size() == 1) {
            this.mMainHandler.post(this.mRunnable);
        }
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void removeObserver(IVsyncCallback iVsyncCallback) {
        ArrayList<IVsyncCallback> arrayList = this.mCallbackList;
        if (arrayList != null) {
            arrayList.remove(iVsyncCallback);
        }
        if (this.mCallbackList.size() == 0) {
            this.mMainHandler.removeCallbacks(this.mRunnable);
        }
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public boolean isWorking() {
        return this.mCallbackList.size() > 0 && this.mEnable;
    }
}
