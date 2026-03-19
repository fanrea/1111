package com.ss.texturerender.vsync;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.ss.texturerender.TextureRenderLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VsyncHelper implements Choreographer.FrameCallback, Handler.Callback, IVsyncHelper {
    public static final float DEFAULT_REFRESH_RATE = 60.0f;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final String TAG = "VsyncHelper";
    private Choreographer choreographer;
    private ArrayList<IVsyncCallback> mCallbackList;
    private boolean mEnable;
    private int mTexType;
    private Handler mainHandler;
    private volatile long vsyncDurationNs;
    private final WindowManager windowManager;

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void update() {
    }

    public VsyncHelper(Context context, int i) {
        this.mTexType = -1;
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.mainHandler = handler;
        handler.post(new Runnable() { // from class: com.ss.texturerender.vsync.VsyncHelper.1
            @Override // java.lang.Runnable
            public void run() {
                VsyncHelper.this.choreographer = Choreographer.getInstance();
            }
        });
        this.mCallbackList = new ArrayList<>();
        if (context != null) {
            this.windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        } else {
            this.windowManager = null;
        }
        updateDefaultDisplayRefreshRateParams();
        this.mEnable = true;
        this.mTexType = i;
        TextureRenderLog.i(i, TAG, "new VsyncHelper");
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void addObserver(IVsyncCallback iVsyncCallback) {
        TextureRenderLog.i(this.mTexType, TAG, "addObserver");
        if (iVsyncCallback == null) {
            return;
        }
        Message messageObtainMessage = this.mainHandler.obtainMessage(29);
        messageObtainMessage.obj = iVsyncCallback;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void removeObserver(IVsyncCallback iVsyncCallback) {
        TextureRenderLog.i(this.mTexType, TAG, "removeObserver");
        if (iVsyncCallback == null) {
            return;
        }
        Message messageObtainMessage = this.mainHandler.obtainMessage(30);
        messageObtainMessage.obj = iVsyncCallback;
        messageObtainMessage.sendToTarget();
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.mCallbackList.size() <= 0 || !this.mEnable) {
            return;
        }
        Iterator<IVsyncCallback> it = this.mCallbackList.iterator();
        while (it.hasNext()) {
            it.next().notifyVsync();
        }
        this.choreographer.postFrameCallback(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 29:
                addObserverInternal(message);
            case 28:
                return true;
            case 30:
                removeObserverInternal(message);
                return true;
            default:
                return false;
        }
    }

    private void addObserverInternal(Message message) {
        Choreographer choreographer;
        if (this.mCallbackList.contains((IVsyncCallback) message.obj)) {
            return;
        }
        this.mCallbackList.add((IVsyncCallback) message.obj);
        if (this.mCallbackList.size() != 1 || (choreographer = this.choreographer) == null) {
            return;
        }
        choreographer.postFrameCallback(this);
    }

    private void removeObserverInternal(Message message) {
        Choreographer choreographer;
        this.mCallbackList.remove(message.obj);
        if (this.mCallbackList.size() != 0 || (choreographer = this.choreographer) == null) {
            return;
        }
        choreographer.removeFrameCallback(this);
    }

    public static class VsyncCallback implements IVsyncCallback {
        public Handler mHandler;

        public VsyncCallback(Handler handler) {
            this.mHandler = handler;
        }

        @Override // com.ss.texturerender.vsync.IVsyncCallback
        public void notifyVsync() {
            this.mHandler.sendEmptyMessage(28);
        }
    }

    private void updateDefaultDisplayRefreshRateParams() {
        WindowManager windowManager = this.windowManager;
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            this.vsyncDurationNs = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        } else {
            this.vsyncDurationNs = 16666667L;
        }
        TextureRenderLog.i(this.mTexType, TAG, "vsyncDurationNs:" + this.vsyncDurationNs + "defaultDisplay:" + defaultDisplay);
    }

    public long getVsyncDurationNs() {
        return this.vsyncDurationNs;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public boolean isWorking() {
        return this.mCallbackList.size() > 0 && this.mEnable;
    }
}
