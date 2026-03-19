package com.fendasz.moku.planet.source;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.network.result.ApiResult;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Error;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.source.remote.TaskApiRemoteDataSource;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApiCreateObservable {
    private static String TAG = "ApiCreateObservable";
    private static ApiCreateObservable apiCreateObservable;
    private static ArrayList<Disposable> mDisposables;

    private ApiCreateObservable() {
        LogUtils.log(TAG, "get a new ApiCreateObservableInstance");
    }

    public static ApiCreateObservable getInstance() {
        ApiCreateObservable apiCreateObservable2;
        synchronized (ApiCreateObservable.class) {
            if (mDisposables == null) {
                mDisposables = new ArrayList<>();
            }
            if (apiCreateObservable == null) {
                apiCreateObservable = new ApiCreateObservable();
            }
            apiCreateObservable2 = apiCreateObservable;
        }
        return apiCreateObservable2;
    }

    public <T> void createObservable(Context context, Observable<T> observable, final ApiDataCallBack<T> apiDataCallBack) {
        Disposable disposableSubscribe = observable.subscribe(new Consumer() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ApiCreateObservable.lambda$createObservable$0(apiDataCallBack, obj);
            }
        }, new Consumer() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ApiCreateObservable.lambda$createObservable$1(apiDataCallBack, (Throwable) obj);
            }
        });
        ArrayList<Disposable> arrayList = mDisposables;
        if (arrayList != null) {
            arrayList.add(disposableSubscribe);
        }
    }

    static /* synthetic */ void lambda$createObservable$0(ApiDataCallBack apiDataCallBack, Object obj) throws Exception {
        if (obj != null) {
            LogUtils.log(TAG, JSON.toJSONString(obj));
            apiDataCallBack.success(0, obj);
        } else {
            LogUtils.log(TAG, "data is null");
            apiDataCallBack.error(-1, "数据为空");
        }
    }

    static /* synthetic */ void lambda$createObservable$1(ApiDataCallBack apiDataCallBack, Throwable th) throws Exception {
        th.printStackTrace();
        LogUtils.log(TAG, "get request error throwable >> " + th.getMessage());
        apiDataCallBack.error(-1, th.getMessage());
    }

    public <T> void createApiResultObservable(final Context context, Observable<ApiResult<T>> observable, final ApiDataCallBack<T> apiDataCallBack) {
        Disposable disposableSubscribe = observable.subscribe(new Consumer() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ApiCreateObservable.lambda$createApiResultObservable$2(context, apiDataCallBack, (ApiResult) obj);
            }
        }, new Consumer() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ApiCreateObservable.lambda$createApiResultObservable$3(apiDataCallBack, (Throwable) obj);
            }
        });
        ArrayList<Disposable> arrayList = mDisposables;
        if (arrayList != null) {
            arrayList.add(disposableSubscribe);
        }
    }

    static /* synthetic */ void lambda$createApiResultObservable$2(Context context, ApiDataCallBack apiDataCallBack, ApiResult apiResult) throws Exception {
        if (apiResult != null) {
            if (apiResult.getResult() == 0) {
                SharedPreferencesUtils.getInstance(context).putLong("mokuTime", DateUtils.getDate(apiResult.getTime(), "yyyy-MM-dd HH:mm:ss").getTime());
                LogUtils.log(TAG, "get request success " + apiResult.getMessage());
                LogUtils.log(TAG, JSON.toJSONString(apiResult));
                apiDataCallBack.success(apiResult.getResult(), apiResult.getData());
                return;
            }
            LogUtils.log(TAG, "get request error " + apiResult.getResult() + ":" + apiResult.getMessage());
            apiDataCallBack.error(apiResult.getResult(), TextUtils.isEmpty(apiResult.getMessage()) ? "网络异常" : apiResult.getMessage());
            return;
        }
        LogUtils.log(TAG, "data is null");
        apiDataCallBack.error(-1, "数据为空");
    }

    static /* synthetic */ void lambda$createApiResultObservable$3(ApiDataCallBack apiDataCallBack, Throwable th) throws Exception {
        th.printStackTrace();
        LogUtils.log(TAG, "get request error throwable >> " + th.getMessage());
        apiDataCallBack.error(-1, th.getMessage());
    }

    public <T> void createObservableWithNetTime(final Context context, final Observable<ApiResult<T>> observable, final ApiDataCallBack<T> apiDataCallBack) {
        getNetTime(context, new Success<Long>() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable.1
            @Override // com.fendasz.moku.planet.interf.Success
            public void success(Integer num, Long l) {
                if (l == null) {
                    LogUtils.log(ApiCreateObservable.TAG, "get time request error");
                    try {
                        apiDataCallBack.error(-1, "获取网络时间失败");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                ApiCreateObservable.this.createApiResultObservable(context, observable, apiDataCallBack);
            }
        }, new Error() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable.2
            @Override // com.fendasz.moku.planet.interf.Error
            public void error(Integer num, String str) {
                try {
                    apiDataCallBack.error(num.intValue(), str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private <T> void getNetTime(final Context context, final Success<Long> success, final Error error) {
        Disposable disposableSubscribe = TaskApiRemoteDataSource.getInstance(context).getNetTime().subscribe(new Consumer() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ApiCreateObservable.lambda$getNetTime$4(context, success, error, (ApiResult) obj);
            }
        }, new Consumer() { // from class: com.fendasz.moku.planet.source.ApiCreateObservable$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                ApiCreateObservable.lambda$getNetTime$5(error, context, (Throwable) obj);
            }
        });
        ArrayList<Disposable> arrayList = mDisposables;
        if (arrayList != null) {
            arrayList.add(disposableSubscribe);
        }
    }

    static /* synthetic */ void lambda$getNetTime$4(Context context, Success success, Error error, ApiResult apiResult) throws Exception {
        if (apiResult != null) {
            if (apiResult.getResult() == 0) {
                LogUtils.log(TAG, "get time success!");
                MokuConfigure.getInstance().getPhoneInfo(context).setNetTime((Long) apiResult.getData());
                if (success != null) {
                    success.success(0, (Long) apiResult.getData());
                    return;
                }
                return;
            }
            LogUtils.log(TAG, "get time error!");
            if (error != null) {
                error.error(Integer.valueOf(apiResult.getResult()), apiResult.getMessage());
                return;
            }
            return;
        }
        LogUtils.log(TAG, "get time is null");
        if (error != null) {
            error.error(-1, "get time is null");
        }
    }

    static /* synthetic */ void lambda$getNetTime$5(Error error, Context context, Throwable th) throws Exception {
        String message = th.getMessage();
        LogUtils.log(TAG, "get time request error throwable >> " + message);
        if (message != null && message.toLowerCase().contains("failed to connect to")) {
            if (error != null) {
                error.error(-201, context.getString(R.string.moku_net_tip_time_out));
            }
        } else if (message == null || !message.toLowerCase().contains("unable to resolve host")) {
            if (error != null) {
                error.error(-1, message);
            }
        } else if (error != null) {
            error.error(-202, context.getString(R.string.moku_net_tip_time_out));
        }
    }

    public void closeDisposable() {
        LogUtils.log(TAG, "reset apiCreateObservableInstance");
        synchronized (ApiCreateObservable.class) {
            if (mDisposables != null) {
                for (int i = 0; i < mDisposables.size(); i++) {
                    if (mDisposables.get(i) != null && !mDisposables.get(i).isDisposed()) {
                        mDisposables.get(i).dispose();
                        LogUtils.log(TAG, "CloseDisposable " + i);
                    }
                }
                mDisposables.clear();
            }
            mDisposables = null;
            apiCreateObservable = null;
        }
        LogUtils.log(TAG, "end CloseDisposable");
    }
}
