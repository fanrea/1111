package aegon.chrome.base.task;

import aegon.chrome.base.Log;
import aegon.chrome.base.ThreadUtils;
import aegon.chrome.base.TraceEvent;
import android.os.Binder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class AsyncTask<Result> {
    private static final String TAG = "AsyncTask";
    private final FutureTask<Result> mFuture;
    private final Callable<Result> mWorker;
    public static final Executor THREAD_POOL_EXECUTOR = AsyncTask$$Lambda$2.instance;
    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
    private static final StealRunnableHandler STEAL_RUNNABLE_HANDLER = new StealRunnableHandler();
    private volatile int mStatus = 0;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FINISHED = 2;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    protected abstract Result doInBackground();

    protected void onCancelled() {
    }

    protected abstract void onPostExecute(Result result);

    protected void onPreExecute() {
    }

    static /* synthetic */ void lambda$static$0(Runnable runnable) {
        PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK, runnable);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class StealRunnableHandler implements RejectedExecutionHandler {
        private StealRunnableHandler() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }

    public static void takeOverAndroidThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        threadPoolExecutor.setRejectedExecutionHandler(STEAL_RUNNABLE_HANDLER);
        threadPoolExecutor.shutdown();
    }

    public AsyncTask() {
        Callable<Result> callable = new Callable<Result>() { // from class: aegon.chrome.base.task.AsyncTask.1
            @Override // java.util.concurrent.Callable
            public Result call() {
                AsyncTask.this.mTaskInvoked.set(true);
                Result result = null;
                try {
                    result = (Result) AsyncTask.this.doInBackground();
                    Binder.flushPendingCommands();
                    return result;
                } finally {
                }
            }
        };
        this.mWorker = callable;
        this.mFuture = new NamedFutureTask(callable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        postResult(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(Result result) {
        if (this instanceof BackgroundOnlyAsyncTask) {
            this.mStatus = 2;
        } else {
            ThreadUtils.postOnUiThread(AsyncTask$$Lambda$1.lambdaFactory$(this, result));
        }
    }

    public final int getStatus() {
        return this.mStatus;
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    public final Result get() {
        if (getStatus() != 2 && ThreadUtils.runningOnUiThread()) {
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            TraceEvent traceEventScoped = TraceEvent.scoped((stackTrace.length > 1 ? stackTrace[1].getClassName() + '.' + stackTrace[1].getMethodName() + '.' : "") + "AsyncTask.get");
            try {
                Result result = this.mFuture.get();
                if (traceEventScoped == null) {
                    return result;
                }
                traceEventScoped.close();
                return result;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (traceEventScoped != null) {
                        try {
                            traceEventScoped.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        return this.mFuture.get();
    }

    private void executionPreamble() {
        if (this.mStatus != 0) {
            int i = this.mStatus;
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = 1;
        onPreExecute();
    }

    public final AsyncTask<Result> executeOnExecutor(Executor executor) {
        executionPreamble();
        executor.execute(this.mFuture);
        return this;
    }

    public final AsyncTask<Result> executeOnTaskRunner(TaskRunner taskRunner) {
        executionPreamble();
        taskRunner.postTask(this.mFuture);
        return this;
    }

    public final AsyncTask<Result> executeWithTaskTraits(TaskTraits taskTraits) {
        executionPreamble();
        PostTask.postTask(taskTraits, this.mFuture);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = 2;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class NamedFutureTask extends FutureTask<Result> {
        NamedFutureTask(Callable<Result> callable) {
            super(callable);
        }

        Class getBlamedClass() {
            return AsyncTask.this.getClass();
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                AsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                Log.w(AsyncTask.TAG, e.toString(), new Object[0]);
            } catch (CancellationException unused) {
                AsyncTask.this.postResultIfNotInvoked(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            }
        }
    }
}
