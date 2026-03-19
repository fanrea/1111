package com.pandora.ttlicense2.loader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.pandora.ttlicense2.utils.Asserts;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Loader implements Cancelable {
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_LOADING = 1;
    private boolean mCanceling;
    private final List<LoadTask<?>> mEnqueuedTasks = new LinkedList();
    private ThreadPoolExecutor mExecutor;
    private final Looper mLooper;
    private int mState;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T loadable, String reason);

        void onLoadComplete(T loadable);

        void onLoadError(T loadable, IOException e);

        void onLoadProgressChanged(T loadable, float progress);

        void onLoadStart(T loadable);
    }

    public static class CallbackAdapter<T extends Loadable> implements Callback<T> {
        @Override // com.pandora.ttlicense2.loader.Loader.Callback
        public void onLoadCanceled(T loadable, String reason) {
        }

        @Override // com.pandora.ttlicense2.loader.Loader.Callback
        public void onLoadComplete(T loadable) {
        }

        @Override // com.pandora.ttlicense2.loader.Loader.Callback
        public void onLoadError(T loadable, IOException e) {
        }

        @Override // com.pandora.ttlicense2.loader.Loader.Callback
        public void onLoadProgressChanged(T loadable, float progress) {
        }

        @Override // com.pandora.ttlicense2.loader.Loader.Callback
        public void onLoadStart(T loadable) {
        }
    }

    public interface Loadable extends Cancelable {
        void load(ProgressNotifier notifier) throws InterruptedException, IOException;
    }

    private interface OnLoadTaskListener<T extends Loadable> {
        void onTaskFinish(LoadTask<T> task);

        void onTaskStart(LoadTask<T> task);
    }

    public interface ProgressNotifier {
        void notifyProgressChanged(float progress);
    }

    public Loader(Looper looper, ThreadPoolExecutor executor) {
        this.mLooper = looper;
        this.mExecutor = executor;
    }

    public final <T extends Loadable> void startLoad(final T loadable, final Callback<T> callback) {
        Asserts.checkThread(this.mLooper);
        Asserts.checkState(this.mState, 0, 1);
        Asserts.checkState(!this.mCanceling, "can't enqueue while canceling!");
        new LoadTask(this.mLooper, this.mExecutor, loadable, callback, new OnLoadTaskListener<T>() { // from class: com.pandora.ttlicense2.loader.Loader.1
            @Override // com.pandora.ttlicense2.loader.Loader.OnLoadTaskListener
            public void onTaskStart(LoadTask<T> task) {
                Asserts.checkThread(Loader.this.mLooper);
                Loader.this.mEnqueuedTasks.add(task);
                syncState();
            }

            @Override // com.pandora.ttlicense2.loader.Loader.OnLoadTaskListener
            public void onTaskFinish(LoadTask<T> task) {
                Asserts.checkThread(Loader.this.mLooper);
                Asserts.checkState(task.isDone());
                Loader.this.mEnqueuedTasks.remove(task);
                syncState();
            }

            private void syncState() {
                if (Loader.this.mEnqueuedTasks.isEmpty()) {
                    if (Loader.this.mCanceling) {
                        Loader.this.mState = 3;
                        Loader.this.finish();
                        return;
                    } else {
                        Loader.this.mState = 0;
                        return;
                    }
                }
                if (Loader.this.mCanceling) {
                    return;
                }
                Loader.this.mState = 1;
            }
        }).start();
    }

    public Looper looper() {
        Asserts.checkThread(this.mLooper);
        return this.mLooper;
    }

    public final boolean isIDLE() {
        Asserts.checkThread(this.mLooper);
        return this.mState == 0;
    }

    public final boolean isLoading() {
        Asserts.checkThread(this.mLooper);
        return this.mState == 1;
    }

    public boolean isFree() {
        Asserts.checkThread(this.mLooper);
        int i = this.mState;
        return (i == 0 || i == 1) && this.mExecutor.getMaximumPoolSize() > this.mEnqueuedTasks.size();
    }

    public boolean isCanceling() {
        Asserts.checkThread(this.mLooper);
        return this.mCanceling;
    }

    @Override // com.pandora.ttlicense2.loader.Cancelable
    public final void cancel(boolean notify, boolean interrupt, String reason) {
        Asserts.checkThread(this.mLooper);
        int i = this.mState;
        if (i == 0) {
            ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdown();
            }
            this.mState = 3;
            finish();
            return;
        }
        if (i != 1 || this.mCanceling) {
            return;
        }
        this.mCanceling = true;
        Iterator<LoadTask<?>> it = this.mEnqueuedTasks.iterator();
        while (it.hasNext()) {
            it.next().cancel(notify, interrupt, reason);
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.mExecutor;
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor2.shutdown();
        }
    }

    @Override // com.pandora.ttlicense2.loader.Cancelable
    public final boolean isCanceled() {
        return this.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.mExecutor = null;
    }

    private static class LoadTask<T extends Loadable> extends Handler implements Runnable, Cancelable {
        private static final int MSG_CANCEL = 5;
        private static final int MSG_COMPLETE = 1;
        private static final int MSG_FATAL_ERROR = 4;
        private static final int MSG_IO_EXCEPTION = 2;
        private static final int MSG_PROGRESS = 0;
        private static final int MSG_UNEXPECTED_EXCEPTION = 3;
        private static final int STATE_CANCELED = 4;
        private static final int STATE_COMPLETED = 2;
        private static final int STATE_ERROR = 3;
        private static final int STATE_IDLE = 0;
        private static final int STATE_STARTED = 1;
        private Callback<T> mCallback;
        private String mCancelReason;
        private volatile boolean mCanceling;
        private ExecutorService mExecutor;
        private volatile Thread mExecutorThread;
        private OnLoadTaskListener<T> mListener;
        private T mLoadable;
        private boolean mNotify;
        private int mState;

        LoadTask(Looper looper, ExecutorService executor, T loadable, Callback<T> callback, OnLoadTaskListener<T> listener) {
            super(looper);
            this.mNotify = true;
            this.mExecutor = executor;
            this.mLoadable = loadable;
            this.mCallback = callback;
            this.mListener = listener;
        }

        private void setState(int state) {
            Asserts.checkThread(getLooper());
            this.mState = state;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Asserts.checkState(this.mState, 0, 1);
            if (this.mCanceling && this.mState == 1 && msg.what != 0) {
                fireCanceledEvent();
                return;
            }
            int i = msg.what;
            if (i == 0) {
                fireProgressEvent(((Float) msg.obj).floatValue());
                return;
            }
            if (i == 1) {
                fireCompleteEvent();
                return;
            }
            if (i == 2) {
                fireErrorEvent((IOException) msg.obj);
                return;
            }
            if (i == 3) {
                fireErrorEvent(new IOException((Throwable) msg.obj));
            } else {
                if (i == 4) {
                    throw ((Error) msg.obj);
                }
                if (i != 5) {
                    return;
                }
                fireCanceledEvent();
            }
        }

        private void fireStartEvent() {
            Callback<T> callback;
            Asserts.checkThread(getLooper());
            Asserts.checkState(this.mState, 0);
            setState(1);
            OnLoadTaskListener<T> onLoadTaskListener = this.mListener;
            if (onLoadTaskListener != null) {
                onLoadTaskListener.onTaskStart(this);
            }
            if (!this.mNotify || (callback = this.mCallback) == null) {
                return;
            }
            callback.onLoadStart(this.mLoadable);
        }

        private void fireProgressEvent(float progress) {
            Callback<T> callback;
            Asserts.checkThread(getLooper());
            Asserts.checkState(this.mState, 1);
            if (!this.mNotify || (callback = this.mCallback) == null) {
                return;
            }
            callback.onLoadProgressChanged(this.mLoadable, progress);
        }

        private void fireCompleteEvent() {
            Asserts.checkThread(getLooper());
            Asserts.checkState(this.mState, 1);
            setState(2);
            Callback<T> callback = this.mCallback;
            T t = this.mLoadable;
            finish();
            if (!this.mNotify || callback == null) {
                return;
            }
            callback.onLoadComplete(t);
        }

        private void fireErrorEvent(IOException e) {
            Asserts.checkThread(getLooper());
            Asserts.checkState(this.mState, 1);
            setState(3);
            Callback<T> callback = this.mCallback;
            T t = this.mLoadable;
            finish();
            if (!this.mNotify || callback == null) {
                return;
            }
            callback.onLoadError(t, e);
        }

        private void fireCanceledEvent() {
            Asserts.checkThread(getLooper());
            Asserts.checkState(this.mState, 1);
            setState(4);
            Callback<T> callback = this.mCallback;
            T t = this.mLoadable;
            finish();
            if (!this.mNotify || callback == null) {
                return;
            }
            callback.onLoadCanceled(t, this.mCancelReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            Asserts.checkThread(getLooper());
            Asserts.checkState(this.mState, 0);
            this.mExecutor.execute(this);
            fireStartEvent();
        }

        @Override // com.pandora.ttlicense2.loader.Cancelable
        public void cancel(boolean notify, boolean interrupt, String reason) {
            Asserts.checkThread(getLooper());
            this.mCanceling = true;
            this.mNotify = notify;
            this.mCancelReason = reason;
            T t = this.mLoadable;
            if (t != null) {
                t.cancel(notify, interrupt, reason);
            }
            Thread thread = this.mExecutorThread;
            if (thread == null || !interrupt) {
                return;
            }
            thread.interrupt();
        }

        @Override // com.pandora.ttlicense2.loader.Cancelable
        public boolean isCanceled() {
            Asserts.checkThread(getLooper());
            return this.mState == 4;
        }

        boolean isDone() {
            Asserts.checkThread(getLooper());
            int i = this.mState;
            return i == 2 || i == 3 || i == 4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCanceling) {
                sendEmptyMessage(5);
                return;
            }
            this.mExecutorThread = Thread.currentThread();
            try {
                this.mLoadable.load(new ProgressNotifier() { // from class: com.pandora.ttlicense2.loader.Loader.LoadTask.1
                    @Override // com.pandora.ttlicense2.loader.Loader.ProgressNotifier
                    public void notifyProgressChanged(float progress) {
                        if (LoadTask.this.mCanceling || LoadTask.this.mState != 1) {
                            return;
                        }
                        LoadTask.this.removeMessages(0);
                        LoadTask.this.obtainMessage(0, Float.valueOf(progress)).sendToTarget();
                    }
                });
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.mLoadable.isCanceled()) {
                    obtainMessage(5).sendToTarget();
                } else {
                    obtainMessage(2, e).sendToTarget();
                }
            } catch (InterruptedException unused) {
                Asserts.checkState(this.mCanceling);
                obtainMessage(5).sendToTarget();
            } catch (OutOfMemoryError e2) {
                e = e2;
                obtainMessage(3, e).sendToTarget();
            } catch (Error e3) {
                obtainMessage(4, e3).sendToTarget();
                throw e3;
            } catch (RuntimeException e4) {
                e = e4;
                obtainMessage(3, e).sendToTarget();
            }
        }

        private void finish() {
            Asserts.checkThread(getLooper());
            removeCallbacksAndMessages(null);
            this.mCallback = null;
            OnLoadTaskListener<T> onLoadTaskListener = this.mListener;
            if (onLoadTaskListener != null) {
                onLoadTaskListener.onTaskFinish(this);
                this.mListener = null;
            }
            this.mExecutor = null;
            this.mLoadable = null;
            this.mExecutorThread = null;
        }
    }
}
