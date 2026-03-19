package com.bytedance.sdk.djx.core.business.base;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseViewModel extends ViewModel {
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected MutableLiveData<DataWrapper<UIEvent>> mUiData = new MutableLiveData<>();

    public enum NetworkResult {
        SUCCESS,
        FAILED
    }

    public enum UIEvent {
        SHOW_TOAST,
        SHOW_PROGRESS,
        DISMISS_PROGRESS,
        FINISH_ACTIVITY
    }

    public static class DataWrapper<T> {
        private T data;
        private Object extra;
        private NetworkResult result;
        public long parseDuration = 0;
        public int errCode = 0;
        public String errMsg = "";

        public DataWrapper(T t) {
            this.data = t;
        }

        public T getData() {
            return this.data;
        }

        public DataWrapper<T> setData(T t) {
            this.data = t;
            return this;
        }

        public DataWrapper<T> setExtra(Object obj) {
            this.extra = obj;
            return this;
        }

        public Object getExtra() {
            return this.extra;
        }

        public DataWrapper<T> setResult(NetworkResult networkResult) {
            this.result = networkResult;
            return this;
        }

        public NetworkResult getResult() {
            return this.result;
        }
    }

    public <T> void setValueInUIThread(final MutableLiveData<T> mutableLiveData, final T t) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.base.BaseViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                mutableLiveData.setValue(t);
            }
        });
    }
}
