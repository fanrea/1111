package com.bytedance.common.utility.concurrent;

import android.os.AsyncTask;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AsyncTaskUtils {
    static final BaseImpl IMPL;

    private static class BaseImpl {
        private BaseImpl() {
        }

        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    private static class HoneyCombImpl extends BaseImpl {
        private HoneyCombImpl() {
            super();
        }

        @Override // com.bytedance.common.utility.concurrent.AsyncTaskUtils.BaseImpl
        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(TTExecutors.getNormalExecutor(), tArr);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneyCombImpl();
        } else {
            IMPL = new BaseImpl();
        }
    }

    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        IMPL.executeAsyncTask(asyncTask, tArr);
    }
}
