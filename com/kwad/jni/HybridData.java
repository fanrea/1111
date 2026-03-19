package com.kwad.jni;

import com.kwad.jni.DestructorThread;
import com.kwad.tachikoma.TkOfflineCompoImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class HybridData {
    private Destructor mDestructor = new Destructor(this);

    static {
        try {
            System.loadLibrary(TkOfflineCompoImpl.SO_FB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void resetNative() {
        this.mDestructor.destruct();
    }

    public boolean isValid() {
        return this.mDestructor.mNativePointer != 0;
    }

    public static class Destructor extends DestructorThread.Destructor {
        private long mNativePointer;

        static native void deleteNative(long j);

        Destructor(Object obj) {
            super(obj);
        }

        @Override // com.kwad.jni.DestructorThread.Destructor
        protected final void destruct() {
            deleteNative(this.mNativePointer);
            this.mNativePointer = 0L;
        }
    }
}
