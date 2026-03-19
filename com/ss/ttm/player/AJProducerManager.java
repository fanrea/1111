package com.ss.ttm.player;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AJProducerManager {
    private static final int DEFAULT_MAX_CACHE_SIZE = 2;
    public static final int DEFAULT_MAX_IMAGE = 2;
    public static final int IMAGEREADER_STATUS = 1;
    public static final int IMAGEREADER_STATUS_CLOSE = 1;
    public static final int IMAGEREADER_STATUS_OPEN = 2;
    private static int MaxImages = 2;
    public static final int NATIVE_WINDOW_API_CPU = 2;
    public static final int NATIVE_WINDOW_API_EGL = 1;
    public static final int NATIVE_WINDOW_API_MEDIA = 3;
    public static final int NATIVE_WINDOW_API_NONE = 0;
    private static final String TAG = "AJProducerManager";
    private static HashMap<Long, ImageReaderListenerWrapper> mIRLWrapperMap = new HashMap<>();
    private static ArrayList<AJImageReaderProducer> mFreeIRProducerList = new ArrayList<>();
    private static ArrayList<AJImageReaderProducer> mUsingIRProducerList = new ArrayList<>();

    private static class ImageReaderListenerWrapper {
        public Handler handler;
        public ImageReader.OnImageAvailableListener listener;

        public ImageReaderListenerWrapper(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
            this.listener = onImageAvailableListener;
            this.handler = handler;
        }
    }

    public static void setMaxImages(int i) {
        if (i <= 0) {
            i = 2;
        }
        MaxImages = i;
    }

    public static synchronized void setOnImageAvailableListener(long j, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        AVLogger.d(TAG, "setOnImageAvailableListener,playerId:" + j + ",listener:" + onImageAvailableListener + ",handler:" + handler);
        if (j == 0) {
            return;
        }
        if (onImageAvailableListener == null) {
            mIRLWrapperMap.remove(Long.valueOf(j));
        } else {
            mIRLWrapperMap.put(Long.valueOf(j), new ImageReaderListenerWrapper(onImageAvailableListener, handler));
        }
        Iterator<AJImageReaderProducer> it = mUsingIRProducerList.iterator();
        while (it.hasNext()) {
            AJImageReaderProducer next = it.next();
            if (next.mUsingPlayerId == j) {
                next.setOnImageAvailableListener(onImageAvailableListener, handler);
            }
        }
    }

    public static synchronized Surface getAvailableSurface(long j, int i, int i2) {
        if (j == 0) {
            return null;
        }
        ImageReaderListenerWrapper imageReaderListenerWrapper = mIRLWrapperMap.get(Long.valueOf(j));
        if (imageReaderListenerWrapper == null) {
            AVLogger.w(TAG, "no listener,playerId:" + j);
            return null;
        }
        Iterator<AJImageReaderProducer> it = mUsingIRProducerList.iterator();
        while (it.hasNext()) {
            AJImageReaderProducer next = it.next();
            if (next.mUsingPlayerId == j && next.mApiType == i) {
                return next.getSurface();
            }
        }
        Iterator<AJImageReaderProducer> it2 = mFreeIRProducerList.iterator();
        while (it2.hasNext()) {
            AJImageReaderProducer next2 = it2.next();
            if ((i == 2 && next2.mApiType == 2) || (i != 2 && next2.mApiType != 2)) {
                it2.remove();
                next2.mUsingPlayerId = j;
                mUsingIRProducerList.add(next2);
                next2.setOnImageAvailableListener(imageReaderListenerWrapper.listener, imageReaderListenerWrapper.handler);
                return next2.getSurface();
            }
        }
        AJImageReaderProducer aJImageReaderProducer = new AJImageReaderProducer(j, MaxImages, i);
        mUsingIRProducerList.add(aJImageReaderProducer);
        aJImageReaderProducer.setOnImageAvailableListener(imageReaderListenerWrapper.listener, imageReaderListenerWrapper.handler);
        return aJImageReaderProducer.getSurface();
    }

    public static synchronized void releaseSurface(long j, int i) {
        Iterator<AJImageReaderProducer> it = mUsingIRProducerList.iterator();
        while (it.hasNext()) {
            AJImageReaderProducer next = it.next();
            if (next.mUsingPlayerId == j && next.mApiType == i) {
                it.remove();
                next.setOnImageAvailableListener(null, null);
                next.mUsingPlayerId = 0L;
                if (mFreeIRProducerList.size() >= 2) {
                    mFreeIRProducerList.remove(0).release();
                }
                mFreeIRProducerList.add(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyImageReaderStatus(ImageReader.OnImageAvailableListener onImageAvailableListener, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (onImageAvailableListener != null) {
            try {
                onImageAvailableListener.getClass().getDeclaredMethod("setIntOption", Integer.TYPE, Integer.TYPE).invoke(onImageAvailableListener, 1, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }
    }

    public static class AJImageReaderProducer {
        private int mApiType;
        private ImageReader mImageReader;
        private ImageReader.OnImageAvailableListener mListener;
        private long mUsingPlayerId;

        public AJImageReaderProducer(long j, int i, int i2) {
            this.mApiType = 0;
            this.mUsingPlayerId = 0L;
            if (Build.VERSION.SDK_INT >= 29) {
                this.mImageReader = ImageReader.newInstance(1, 1, 35, i <= 0 ? 2 : i, 304L);
            } else {
                this.mImageReader = ImageReader.newInstance(1, 1, 35, i <= 0 ? 2 : i);
            }
            this.mApiType = i2;
            this.mUsingPlayerId = j;
            AVLogger.d(AJProducerManager.TAG, "new:" + this);
        }

        public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.setOnImageAvailableListener(onImageAvailableListener, handler);
                AVLogger.d(AJProducerManager.TAG, "setOnImageAvailableListener:" + this + ",handler:" + handler);
                if (onImageAvailableListener != null) {
                    AJProducerManager.notifyImageReaderStatus(onImageAvailableListener, 2);
                } else {
                    AJProducerManager.notifyImageReaderStatus(this.mListener, 1);
                }
                this.mListener = onImageAvailableListener;
            }
        }

        public Surface getSurface() {
            ImageReader imageReader = this.mImageReader;
            if (imageReader == null) {
                return null;
            }
            return imageReader.getSurface();
        }

        public void release() {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.close();
                this.mImageReader = null;
            }
        }

        public String toString() {
            return "[" + super.toString() + ",pid:" + this.mUsingPlayerId + ",reader:" + this.mImageReader + "]";
        }
    }
}
