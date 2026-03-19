package com.fendasz.moku.planet.helper;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.entity.UserDeviceInfo;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.source.ApiCreateObservable;
import com.fendasz.moku.planet.source.bean.AlipayConfigData;
import com.fendasz.moku.planet.source.bean.AppConfig;
import com.fendasz.moku.planet.source.bean.ApplicationData;
import com.fendasz.moku.planet.source.bean.BaiduConfigData;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.ClientGameTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.source.bean.ClientTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataRecord;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.CustomerServiceConfig;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.TaskDataStep;
import com.fendasz.moku.planet.source.bean.UploadVideoReponse;
import com.fendasz.moku.planet.source.bean.VideoConfig;
import com.fendasz.moku.planet.source.remote.TaskApiRemoteDataSource;
import com.fendasz.moku.planet.utils.BDUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.ThreadUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ApiDataHelper {
    private static String TAG = "ApiDataHelper";
    private static ApiDataHelper apiDataHelper;
    private static List<ClientDetailTaskData> popupTaskList;

    public static ApiDataHelper getInstance(Context context) throws MokuException {
        MokuHelper.verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        if (apiDataHelper == null) {
            synchronized (ApiDataHelper.class) {
                if (apiDataHelper == null) {
                    apiDataHelper = new ApiDataHelper();
                }
            }
        }
        return apiDataHelper;
    }

    public static ApiDataHelper getApiDataHelper() {
        if (apiDataHelper == null) {
            synchronized (ApiDataHelper.class) {
                if (apiDataHelper == null) {
                    apiDataHelper = new ApiDataHelper();
                }
            }
        }
        return apiDataHelper;
    }

    public void getTaskList(Context context, int i, int i2, ApiDataCallBack<ClientSampleTaskDataList> apiDataCallBack) {
        getPagedTaskList(context, i, i2, 0, apiDataCallBack);
    }

    public void getTaskList(Context context, int i, int i2, int i3, ApiDataCallBack<ClientSampleTaskDataList> apiDataCallBack) {
        getPagedTaskList(context, i, i2, i3, apiDataCallBack);
    }

    public void getRewardTaskList(Context context, ApiDataCallBack<List<ClientSampleTaskData>> apiDataCallBack) {
        rewardTaskList(context, apiDataCallBack);
    }

    public void getPagedTaskList(Context context, int i, int i2, int i3, ApiDataCallBack<ClientSampleTaskDataList> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getPagedTaskList(context, SystemUtils.getSimulatorCode(context), i, Integer.valueOf(i2), i3), new AnonymousClass1(context, apiDataCallBack));
    }

    /* renamed from: com.fendasz.moku.planet.helper.ApiDataHelper$1, reason: invalid class name */
    class AnonymousClass1 implements ApiDataCallBack<ClientSampleTaskDataList> {
        final /* synthetic */ ApiDataCallBack val$callBack;
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context, ApiDataCallBack apiDataCallBack) {
            this.val$context = context;
            this.val$callBack = apiDataCallBack;
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(final int i, final ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
            ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ClientSampleTaskDataList clientSampleTaskDataList2 = clientSampleTaskDataList;
                    if (clientSampleTaskDataList2 != null && clientSampleTaskDataList2.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                        List<ClientSampleTaskData> listFilterExistHpTask = ApiDataHelper.this.filterExistHpTask(AnonymousClass1.this.val$context, clientSampleTaskDataList.getList());
                        try {
                            listFilterExistHpTask = ApiDataHelper.this.filterExistTaskEver(AnonymousClass1.this.val$context, listFilterExistHpTask);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        clientSampleTaskDataList.setList(listFilterExistHpTask);
                    }
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass1.this.val$callBack != null) {
                                try {
                                    AnonymousClass1.this.val$callBack.success(i, clientSampleTaskDataList);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            ApiDataCallBack apiDataCallBack = this.val$callBack;
            if (apiDataCallBack != null) {
                try {
                    apiDataCallBack.error(i, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getPagedTaskList3(Context context, int i, int i2, int i3, int i4, List<Integer> list, Integer num, ApiDataCallBack<ClientSampleTaskDataList> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getPagedTaskListV3(context, SystemUtils.getSimulatorCode(context), i, Integer.valueOf(i2), i3, i4, list, num), new AnonymousClass2(context, apiDataCallBack));
    }

    /* renamed from: com.fendasz.moku.planet.helper.ApiDataHelper$2, reason: invalid class name */
    class AnonymousClass2 implements ApiDataCallBack<ClientSampleTaskDataList> {
        final /* synthetic */ ApiDataCallBack val$callBack;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context, ApiDataCallBack apiDataCallBack) {
            this.val$context = context;
            this.val$callBack = apiDataCallBack;
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(final int i, final ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
            ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ClientSampleTaskDataList clientSampleTaskDataList2 = clientSampleTaskDataList;
                    if (clientSampleTaskDataList2 != null && clientSampleTaskDataList2.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                        List<ClientSampleTaskData> listFilterExistHpTask = ApiDataHelper.this.filterExistHpTask(AnonymousClass2.this.val$context, clientSampleTaskDataList.getList());
                        try {
                            listFilterExistHpTask = ApiDataHelper.this.filterExistTaskEver(AnonymousClass2.this.val$context, listFilterExistHpTask);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        clientSampleTaskDataList.setList(listFilterExistHpTask);
                    }
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass2.this.val$callBack != null) {
                                try {
                                    AnonymousClass2.this.val$callBack.success(i, clientSampleTaskDataList);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            ApiDataCallBack apiDataCallBack = this.val$callBack;
            if (apiDataCallBack != null) {
                try {
                    apiDataCallBack.error(i, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void rewardTaskList(final Context context, final ApiDataCallBack<List<ClientSampleTaskData>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).rewardTaskList(context, SystemUtils.getSimulatorCode(context)), new ApiDataCallBack<List<ClientSampleTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.3
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientSampleTaskData> list) throws Exception {
                apiDataCallBack.success(i, ApiDataHelper.this.filterExistHpTask(context, list));
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void getCPLTaskList(Context context, int i, int i2, ApiDataCallBack<ClientSampleTaskDataList> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getCPLTaskList(context, SystemUtils.getSimulatorCode(context), i, Integer.valueOf(i2)), new AnonymousClass4(context, apiDataCallBack));
    }

    /* renamed from: com.fendasz.moku.planet.helper.ApiDataHelper$4, reason: invalid class name */
    class AnonymousClass4 implements ApiDataCallBack<ClientSampleTaskDataList> {
        final /* synthetic */ ApiDataCallBack val$callBack;
        final /* synthetic */ Context val$context;

        AnonymousClass4(Context context, ApiDataCallBack apiDataCallBack) {
            this.val$context = context;
            this.val$callBack = apiDataCallBack;
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(final int i, final ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
            ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.4.1
                @Override // java.lang.Runnable
                public void run() {
                    ClientSampleTaskDataList clientSampleTaskDataList2 = clientSampleTaskDataList;
                    if (clientSampleTaskDataList2 != null && clientSampleTaskDataList2.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                        List<ClientSampleTaskData> listFilterExistHpTask = ApiDataHelper.this.filterExistHpTask(AnonymousClass4.this.val$context, clientSampleTaskDataList.getList());
                        try {
                            listFilterExistHpTask = ApiDataHelper.this.filterExistTaskEver(AnonymousClass4.this.val$context, listFilterExistHpTask);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        clientSampleTaskDataList.setList(listFilterExistHpTask);
                    }
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass4.this.val$callBack != null) {
                                try {
                                    AnonymousClass4.this.val$callBack.success(i, clientSampleTaskDataList);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            ApiDataCallBack apiDataCallBack = this.val$callBack;
            if (apiDataCallBack != null) {
                try {
                    apiDataCallBack.error(i, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<ClientSampleTaskData> sortTask(List<ClientSampleTaskData> list) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ClientSampleTaskData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public Map<String, Object> sortTask(List<ClientSampleTaskData> list, boolean z, ClientSampleTaskData clientSampleTaskData, ClientSampleTaskData clientSampleTaskData2) {
        int i;
        int iIntValue;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && list.size() > 0) {
            int size = list.size();
            if (z) {
                i = 0;
                while (i < size) {
                    if (!list.get(i).isTopPosition()) {
                        i++;
                    } else if (list.get(i).getTopNum() == null) {
                        iIntValue = 0;
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        iIntValue = Math.toIntExact(list.get(i).getTopNum().longValue());
                    } else {
                        iIntValue = list.get(i).getTopNum().intValue();
                    }
                }
                i = -1;
                iIntValue = 0;
            } else {
                i = -1;
                iIntValue = 0;
            }
            if (i >= 0) {
                arrayList.addAll(list.subList(0, i));
            }
            if (z) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2).isTopPosition()) {
                        if (arrayList2.size() >= 2) {
                            break;
                        }
                        arrayList2.add(list.get(i2));
                    }
                }
                arrayList.addAll(arrayList2);
            }
            int size2 = iIntValue + i;
            if (i != -1 && size2 != -1) {
                if (size2 > list.size()) {
                    size2 = list.size();
                }
                while (i <= size2) {
                    linkedHashMap.put(Integer.valueOf(i), list.get(i).getTaskDataId());
                    arrayList3.add(Integer.valueOf(i));
                    i++;
                }
            }
            Iterator<ClientSampleTaskData> it = list.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                ClientSampleTaskData next = it.next();
                int iIntValue2 = next.getTaskDataId() == null ? 0 : next.getTaskDataId().intValue();
                boolean zContainsValue = linkedHashMap.containsValue(Integer.valueOf(iIntValue2));
                if (!zContainsValue) {
                    if (clientSampleTaskData != null && iIntValue2 == clientSampleTaskData.getTaskDataId().intValue()) {
                        zContainsValue = true;
                    }
                    if (clientSampleTaskData2 != null && iIntValue2 == clientSampleTaskData2.getTaskDataId().intValue()) {
                        zContainsValue = true;
                    }
                }
                if (zContainsValue) {
                    z2 = zContainsValue;
                } else {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if ((((ClientSampleTaskData) arrayList.get(i3)).getTaskDataId() == null ? 0 : ((ClientSampleTaskData) arrayList.get(i3)).getTaskDataId().intValue()) == iIntValue2) {
                            break;
                        }
                    }
                    z2 = zContainsValue;
                }
                if (!z2) {
                    arrayList.add(next);
                }
            }
            HashMap map = new HashMap();
            int size3 = arrayList2.size();
            LogUtils.logD(TAG, "topSize=>" + size3);
            if (size3 == 2) {
                HashMap map2 = new HashMap();
                map2.put("top1", (ClientSampleTaskData) arrayList2.get(0));
                map2.put("top2", (ClientSampleTaskData) arrayList2.get(1));
                map.put("topTask", map2);
            } else if (size3 == 1) {
                HashMap map3 = new HashMap();
                map3.put("top1", (ClientSampleTaskData) arrayList2.get(0));
                map.put("topTask", map3);
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ClientSampleTaskData clientSampleTaskData3 = (ClientSampleTaskData) it2.next();
                HashMap map4 = new HashMap();
                map4.put("taskDataId", String.valueOf(clientSampleTaskData3.getTaskDataId()));
                map4.put("showName", String.valueOf(clientSampleTaskData3.getShowName()));
                arrayList4.add(map4);
            }
            LogUtils.logD(TAG, "ClientSampleTaskData==>" + JSONObject.toJSONString(arrayList4));
            map.put("clientSampleTaskList", arrayList);
            return map;
        }
        HashMap map5 = new HashMap();
        map5.put("clientSampleTaskList", list);
        map5.put("topTask", null);
        return map5;
    }

    public void getTaskRecordList(Context context, List<Integer> list, final ApiDataCallBack<List<ClientSampleTaskDataRecord>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getTaskRecordList(context, list), new ApiDataCallBack<List<ClientSampleTaskDataRecord>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientSampleTaskDataRecord> list2) throws Exception {
                LogUtils.log(ApiDataHelper.TAG, "TaskRecordList size before filter is " + list2.size() + "");
                apiDataCallBack.success(i, list2);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void arbitramentRecordList(Context context, final ApiDataCallBack<List<ClientSampleTaskDataRecord>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).arbitramentRecordList(context), new ApiDataCallBack<List<ClientSampleTaskDataRecord>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientSampleTaskDataRecord> list) throws Exception {
                LogUtils.log(ApiDataHelper.TAG, "arbitrament record list size before filter is " + list.size() + "");
                apiDataCallBack.success(i, list);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void getTaskRecordDetail(Context context, Integer num, final ApiDataCallBack<ClientTaskDataRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getTaskRecordDetail(context, num), new ApiDataCallBack<ClientTaskDataRecord>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.7
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientTaskDataRecord clientTaskDataRecord) throws Exception {
                LogUtils.log(ApiDataHelper.TAG, JSON.toJSONString(clientTaskDataRecord));
                apiDataCallBack.success(i, clientTaskDataRecord);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void postPackages(Context context, final ApiDataCallBack<String> apiDataCallBack) {
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).postPackages(context, SystemUtils.isAdbEnabled(context), SystemUtils.isAccessibilityEnabled(context), SystemUtils.getAllInstalledPackageInfo(context)), new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, String str) throws Exception {
                apiDataCallBack.success(i, str);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.log(ApiDataHelper.TAG, "postPackages error " + str);
                apiDataCallBack.error(i, str);
            }
        });
    }

    private void getTaskList(final Context context, List<String> list, final ApiDataCallBack<List<ClientSampleTaskData>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getTaskList(context, list), new ApiDataCallBack<List<ClientSampleTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.9
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientSampleTaskData> list2) throws Exception {
                apiDataCallBack.success(i, ApiDataHelper.this.filterExistHpTask(context, list2));
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void getAppInfoList(Context context, String str, final ApiDataCallBack<List<String>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getAppInfoList(str), new ApiDataCallBack<List<String>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.10
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<String> list) throws Exception {
                apiDataCallBack.success(i, list);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                apiDataCallBack.error(i, str2);
            }
        });
    }

    public void getNetTime(Context context, final ApiDataCallBack<Long> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getNetTime(), new ApiDataCallBack<Long>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.11
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Long l) throws Exception {
                apiDataCallBack.success(i, l);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void getVideoConfig(Context context, final ApiDataCallBack<VideoConfig> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getVideoConfig(), new ApiDataCallBack<VideoConfig>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.12
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, VideoConfig videoConfig) throws Exception {
                apiDataCallBack.success(i, videoConfig);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void getCustomerServiceConfig(Context context, final ApiDataCallBack<CustomerServiceConfig> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getCustomerServiceConfig(), new ApiDataCallBack<CustomerServiceConfig>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.13
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, CustomerServiceConfig customerServiceConfig) throws Exception {
                apiDataCallBack.success(i, customerServiceConfig);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public List<ClientSampleTaskData> filterExistHpTask(final Context context, List<ClientSampleTaskData> list) {
        final ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        List<ClientSampleTaskData> list2 = (List) Observable.fromIterable(list).filter(new Predicate() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return ApiDataHelper.lambda$filterExistHpTask$0(arrayList, context, (ClientSampleTaskData) obj);
            }
        }).toList().toObservable().flatMap(new Function() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Observable.fromIterable((List) obj);
            }
        }).filter(new Predicate() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return ApiDataHelper.lambda$filterExistHpTask$1(arrayList, (ClientSampleTaskData) obj);
            }
        }).toList().blockingGet();
        LogUtils.log(TAG, "taskdata size after filter hp or cpa task is " + list2.size() + "");
        return list2;
    }

    static /* synthetic */ boolean lambda$filterExistHpTask$0(List list, Context context, ClientSampleTaskData clientSampleTaskData) throws Exception {
        if (Build.VERSION.SDK_INT < 23 && clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
            list.add(Integer.valueOf(clientSampleTaskData.getTaskId()));
            return false;
        }
        if (clientSampleTaskData.isHpOrCpaOrCplTask() && SystemUtils.isAppExist(context, clientSampleTaskData.getPackageName())) {
            if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
                if (clientSampleTaskData.getTaskStatus() != null && clientSampleTaskData.getTaskStatus().intValue() != 1) {
                    list.add(Integer.valueOf(clientSampleTaskData.getTaskId()));
                    if (clientSampleTaskData.isApplyRecordNullOrCanceled() && clientSampleTaskData.isNewTaskGroup()) {
                        return false;
                    }
                }
            } else {
                list.add(Integer.valueOf(clientSampleTaskData.getTaskId()));
                if (clientSampleTaskData.isApplyRecordNullOrCanceled() && clientSampleTaskData.isNewTaskGroup()) {
                    return false;
                }
            }
        }
        return true;
    }

    static /* synthetic */ boolean lambda$filterExistHpTask$1(List list, ClientSampleTaskData clientSampleTaskData) throws Exception {
        return (clientSampleTaskData.isHpOrCpaOrCplTask() && list.contains(Integer.valueOf(clientSampleTaskData.getTaskId())) && clientSampleTaskData.isApplyRecordNullOrCanceled() && clientSampleTaskData.isNewTaskGroup()) ? false : true;
    }

    public List<ClientSampleTaskData> filterExistTaskEver(final Context context, List<ClientSampleTaskData> list) {
        return (List) Observable.fromIterable(list).filter(new Predicate<ClientSampleTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.14
            @Override // io.reactivex.functions.Predicate
            public boolean test(ClientSampleTaskData clientSampleTaskData) throws Exception {
                Integer filterFlag;
                Boolean boolValueOf = Boolean.valueOf(clientSampleTaskData.isCheckUsage());
                LogUtils.logD(ApiDataHelper.TAG, "filterExistTaskEver_name:" + clientSampleTaskData.getShowName() + ",isCheckUsage:" + boolValueOf);
                if (boolValueOf.booleanValue()) {
                    try {
                        return !SystemUtils.isAppExistEver(context, clientSampleTaskData.getPackageName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }
                Integer monitorMethod = clientSampleTaskData.getMonitorMethod();
                if (monitorMethod == null || 2 != monitorMethod.intValue() || (filterFlag = clientSampleTaskData.getFilterFlag()) == null || 1 != filterFlag.intValue()) {
                    return true;
                }
                return SystemUtils.isAppExist(context, clientSampleTaskData.getTaskDataApplicationId());
            }
        }).toList().blockingGet();
    }

    public void postGateType(Context context, String str, Integer num, final ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).postGateType(context, str, num), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.15
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                apiDataCallBack.success(i, obj);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                apiDataCallBack.error(i, str2);
            }
        });
    }

    public void getTaskDetail(final Context context, Integer num, int i, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getTaskDetail(context, num, i), new ApiDataCallBack<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.16
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i2, ClientTaskData clientTaskData) throws Exception {
                clientTaskData.setTaskType(clientTaskData.getTaskData().getTaskType());
                apiDataCallBack.success(i2, ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i2, String str) throws Exception {
                apiDataCallBack.error(i2, str);
            }
        });
    }

    public void getGameTaskDetail(final Context context, Integer num, final ApiDataCallBack<ClientGameTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getGameTaskDetail(context, num), new ApiDataCallBack<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.17
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientTaskData clientTaskData) throws Exception {
                apiDataCallBack.success(i, ApiDataHelper.this.simplifyTaskGameData(context, clientTaskData));
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClientDetailTaskData simplifyTaskDetailData(Context context, ClientTaskData clientTaskData) {
        String key;
        List<String> applications;
        ClientDetailTaskData clientDetailTaskData = new ClientDetailTaskData();
        if (clientTaskData != null) {
            clientDetailTaskData.setTask(clientTaskData.getTask());
            clientDetailTaskData.setTaskData(clientTaskData.getTaskData());
            clientDetailTaskData.setListeningTimeConfig(clientTaskData.getListeningTimeConfig());
            clientDetailTaskData.setIcon(clientTaskData.getIcon());
            clientDetailTaskData.setShowName(clientTaskData.getShowName());
            clientDetailTaskData.setShowMoney(clientTaskData.getShowMoney());
            clientDetailTaskData.setClassify(clientTaskData.getClassify());
            clientDetailTaskData.setTaskDataId(clientTaskData.getTaskDataId());
            clientDetailTaskData.setSurplusNum(clientTaskData.getSurplusNum());
            clientDetailTaskData.setCybermoneyName(clientTaskData.getCybermoneyName());
            clientDetailTaskData.setTaskDataApplyRecord(clientTaskData.getTaskDataApplyRecord());
            clientDetailTaskData.setApkApplicationId(clientTaskData.getApkApplicationId());
            clientDetailTaskData.setApkApplicationId1(clientTaskData.getApkApplicationId1());
            clientDetailTaskData.setDesc(clientTaskData.getDesc());
            clientDetailTaskData.setTaskId(clientTaskData.getTaskId());
            clientDetailTaskData.setDetectUsage(clientTaskData.getDetectUsage());
            clientDetailTaskData.setTaskDataGroupId(clientTaskData.getTaskDataGroupId());
            clientDetailTaskData.setTaskType(clientTaskData.getTaskType());
            clientDetailTaskData.setEasyTaskType(clientTaskData.getEasyTaskType());
            clientDetailTaskData.setLocationStatus(clientTaskData.getLocationStatus());
            clientDetailTaskData.setTaskDataGroupIsNew(clientTaskData.getTaskDataGroupIsNew());
            clientDetailTaskData.setBrowseTime(clientTaskData.getBrowseTime());
            clientDetailTaskData.setCollectionDataId(clientTaskData.getCollectionDataId());
            clientDetailTaskData.setUrl(clientTaskData.getUrl());
            int suspendedSwitch = clientTaskData.getSuspendedSwitch();
            int i = 0;
            if (suspendedSwitch == null) {
                suspendedSwitch = 0;
            }
            clientDetailTaskData.setSuspendedSwitch(suspendedSwitch);
            clientDetailTaskData.setCpl(clientTaskData.getCpl());
            if (clientTaskData.getCpl() != null && clientTaskData.getCpl().booleanValue()) {
                clientDetailTaskData.setClassify(MokuConstants.TASK_TYPE_CPL);
            }
            if (clientTaskData.getClientGroupTaskDataList() != null && clientTaskData.getClientGroupTaskDataList().size() > 0) {
                clientDetailTaskData.setClientGroupTaskDataList(clientTaskData.getClientGroupTaskDataList());
            }
            clientDetailTaskData.setMonitorMethod(clientTaskData.getMonitorMethod());
            clientDetailTaskData.setRtaFlag(clientTaskData.getRtaFlag());
            clientDetailTaskData.setUrl(clientTaskData.getUrl());
            clientDetailTaskData.setTaskDataApplicationId(clientTaskData.getTaskDataApplicationId());
            clientDetailTaskData.setFilterFlag(clientTaskData.getFilterFlag());
            clientDetailTaskData.setCollectionDataName(clientTaskData.getCollectionDataName());
            if (clientTaskData.getEasyTaskType() != null && 3 == clientTaskData.getEasyTaskType().intValue()) {
                clientDetailTaskData.setKeyPoint(clientTaskData.getTaskDataKey());
            } else if (clientTaskData.getTask() != null && clientTaskData.getTaskData() != null) {
                if (!TextUtils.isEmpty(clientTaskData.getTaskData().getKey())) {
                    key = clientTaskData.getTaskData().getKey();
                } else {
                    key = !TextUtils.isEmpty(clientTaskData.getTask().getKey()) ? clientTaskData.getTask().getKey() : "";
                }
                clientDetailTaskData.setKeyPoint(key);
                if (clientTaskData.getTaskData().getTaskDataDetail() != null) {
                    String taskDataIconUrl = clientTaskData.getTaskData().getTaskDataDetail().getTaskDataIconUrl();
                    if (TextUtils.isEmpty(taskDataIconUrl)) {
                        taskDataIconUrl = clientTaskData.getIcon();
                    }
                    clientDetailTaskData.setIconUrl(taskDataIconUrl);
                    clientDetailTaskData.setKeyword(clientTaskData.getTaskData().getTaskDataDetail().getKeyword());
                    clientDetailTaskData.setRank(clientTaskData.getTaskData().getTaskDataDetail().getRank());
                    clientDetailTaskData.setCommentStar(clientTaskData.getTaskData().getTaskDataDetail().getCommentStar());
                    clientDetailTaskData.setCommentType(clientTaskData.getTaskData().getTaskDataDetail().getCommentType());
                    clientDetailTaskData.setCommentKeyword(clientTaskData.getTaskData().getTaskDataDetail().getCommentKeyword());
                    clientDetailTaskData.setIntegerListMap(clientTaskData.getTaskData().getTaskDataDetail().getIntegerListMap());
                    clientDetailTaskData.setFormList(clientTaskData.getTaskData().getTaskDataDetail().getFormList());
                    clientDetailTaskData.setListenerTime(clientTaskData.getTaskData().getTaskDataDetail().getListenerTime());
                    clientDetailTaskData.setIsCustomDesc(clientTaskData.getTaskData().getTaskDataDetail().getIsCustomDesc());
                    if (clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors() != null) {
                        clientDetailTaskData.setAppGalleryName(clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getName());
                        ApplicationData applicationData = clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationData();
                        if (applicationData != null && (applications = applicationData.getApplications()) != null) {
                            while (true) {
                                if (i >= applications.size()) {
                                    break;
                                }
                                String str = applications.get(i);
                                if (SystemUtils.isAppExist(context, str)) {
                                    LogUtils.log(TAG, "local appGallery " + str + " is exist");
                                    clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors().setApplicationId(str);
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return clientDetailTaskData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClientGameTaskData simplifyTaskGameData(Context context, ClientTaskData clientTaskData) {
        String key;
        List<String> applications;
        ClientGameTaskData clientGameTaskData = new ClientGameTaskData();
        if (clientTaskData != null) {
            clientGameTaskData.setTask(clientTaskData.getTask());
            clientGameTaskData.setTaskData(clientTaskData.getTaskData());
            clientGameTaskData.setListeningTimeConfig(clientTaskData.getListeningTimeConfig());
            clientGameTaskData.setIcon(clientTaskData.getIcon());
            clientGameTaskData.setShowName(clientTaskData.getShowName());
            clientGameTaskData.setShowMoney(clientTaskData.getShowMoney());
            clientGameTaskData.setClassify(clientTaskData.getClassify());
            clientGameTaskData.setTaskDataId(clientTaskData.getTaskDataId());
            clientGameTaskData.setSurplusNum(clientTaskData.getSurplusNum());
            clientGameTaskData.setLocationStatus(clientTaskData.getLocationStatus());
            clientGameTaskData.setCybermoneyName(clientTaskData.getCybermoneyName());
            clientGameTaskData.setTaskDataApplyRecord(clientTaskData.getTaskDataApplyRecord());
            clientGameTaskData.setApkApplicationId(clientTaskData.getApkApplicationId());
            clientGameTaskData.setApkApplicationId1(clientTaskData.getApkApplicationId1());
            clientGameTaskData.setDesc(clientTaskData.getDesc());
            clientGameTaskData.setTaskId(clientTaskData.getTaskId());
            clientGameTaskData.setDetectUsage(clientTaskData.getDetectUsage());
            clientGameTaskData.setTaskDataGroupId(clientTaskData.getTaskDataGroupId());
            clientGameTaskData.setEasyTaskType(clientTaskData.getEasyTaskType());
            clientGameTaskData.setBrowseTime(clientTaskData.getBrowseTime());
            clientGameTaskData.setCollectionDataId(clientTaskData.getCollectionDataId());
            clientGameTaskData.setUrl(clientTaskData.getUrl());
            clientGameTaskData.setTaskDataGroupIsNew(clientTaskData.getTaskDataGroupIsNew());
            int suspendedSwitch = clientTaskData.getSuspendedSwitch();
            int i = 0;
            if (suspendedSwitch == null) {
                suspendedSwitch = 0;
            }
            clientGameTaskData.setSuspendedSwitch(suspendedSwitch);
            clientGameTaskData.setCpl(clientTaskData.getCpl());
            clientGameTaskData.setCplTaskStatus(clientTaskData.getTaskData().getTaskStatus());
            clientGameTaskData.setCpl(clientTaskData.getCpl());
            clientGameTaskData.setTaskDataTag(clientTaskData.getTaskDataTag());
            if (clientTaskData.getClientGroupTaskDataList() != null && clientTaskData.getClientGroupTaskDataList().size() > 0) {
                clientGameTaskData.setClientGroupTaskDataList(clientTaskData.getClientGroupTaskDataList());
            }
            if (clientTaskData.getTask() != null && clientTaskData.getTaskData() != null) {
                if (!TextUtils.isEmpty(clientTaskData.getTaskData().getKey())) {
                    key = clientTaskData.getTaskData().getKey();
                } else {
                    key = !TextUtils.isEmpty(clientTaskData.getTask().getKey()) ? clientTaskData.getTask().getKey() : "";
                }
                clientGameTaskData.setKeyPoint(key);
                if (clientTaskData.getTaskData().getTaskDataDetail() != null) {
                    String taskDataIconUrl = clientTaskData.getTaskData().getTaskDataDetail().getTaskDataIconUrl();
                    if (TextUtils.isEmpty(taskDataIconUrl)) {
                        taskDataIconUrl = clientTaskData.getIcon();
                    }
                    clientGameTaskData.setIconUrl(taskDataIconUrl);
                    clientGameTaskData.setKeyword(clientTaskData.getTaskData().getTaskDataDetail().getKeyword());
                    clientGameTaskData.setRank(clientTaskData.getTaskData().getTaskDataDetail().getRank());
                    clientGameTaskData.setCommentStar(clientTaskData.getTaskData().getTaskDataDetail().getCommentStar());
                    clientGameTaskData.setCommentType(clientTaskData.getTaskData().getTaskDataDetail().getCommentType());
                    clientGameTaskData.setCommentKeyword(clientTaskData.getTaskData().getTaskDataDetail().getCommentKeyword());
                    clientGameTaskData.setIntegerListMap(clientTaskData.getTaskData().getTaskDataDetail().getIntegerListMap());
                    clientGameTaskData.setFormList(clientTaskData.getTaskData().getTaskDataDetail().getFormList());
                    clientGameTaskData.setListenerTime(clientTaskData.getTaskData().getTaskDataDetail().getListenerTime());
                    clientGameTaskData.setIsCustomDesc(clientTaskData.getTaskData().getTaskDataDetail().getIsCustomDesc());
                    if (clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors() != null) {
                        clientGameTaskData.setAppGalleryName(clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getName());
                        ApplicationData applicationData = clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors().getApplicationData();
                        if (applicationData != null && (applications = applicationData.getApplications()) != null) {
                            while (true) {
                                if (i >= applications.size()) {
                                    break;
                                }
                                String str = applications.get(i);
                                if (SystemUtils.isAppExist(context, str)) {
                                    LogUtils.log(TAG, "local appGallery " + str + " is exist");
                                    clientTaskData.getTaskData().getTaskDataDetail().getProductFlavors().setApplicationId(str);
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return clientGameTaskData;
    }

    public void applyTask(Context context, Integer num, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).applyTask(context, num), apiDataCallBack);
    }

    public void applyEasyTask(Context context, Integer num, Integer num2, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).applyEasyTask(context, num, num2), apiDataCallBack);
    }

    public void cancelTask(Context context, ClientDetailTaskData clientDetailTaskData, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (clientDetailTaskData.getTaskDataApplyRecord() == null) {
            try {
                apiDataCallBack.error(-1, "找不到申请记录");
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).cancelTask(context, clientDetailTaskData.getTaskDataId(), clientDetailTaskData.getTaskDataApplyRecord().getId()), apiDataCallBack);
    }

    public void cancelTask(Context context, Integer num, Integer num2, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).cancelTask(context, num, num2), apiDataCallBack);
    }

    public void cancelWithoutMonitor(Context context, Integer num, Integer num2, ApiDataCallBack<Object> apiDataCallBack) {
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).cancelWithoutMonitor(context, num, num2), apiDataCallBack);
    }

    private void submitTask(final Context context, final ClientDetailTaskData clientDetailTaskData, final List<File> list, final List<ClientTaskDataSubmitFormModel> list2, final String str, final String str2, final ApiDataCallBack<String> apiDataCallBack) {
        if (isNeedPostPackages(context, clientDetailTaskData.getTaskDataApplyRecord().getCheckTheState())) {
            postPackages(context, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.18
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, String str3) throws Exception {
                    ApiCreateObservable apiCreateObservable = ApiCreateObservable.getInstance();
                    Context context2 = context;
                    apiCreateObservable.createObservableWithNetTime(context2, TaskApiRemoteDataSource.getInstance(context2).submitTask(context, clientDetailTaskData.getTaskDataId(), list, list2, str, str2), apiDataCallBack);
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str3) throws Exception {
                    apiDataCallBack.error(i, str3);
                }
            });
        } else {
            ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).submitTask(context, clientDetailTaskData.getTaskDataId(), list, list2, str, str2), apiDataCallBack);
        }
    }

    public void submitAppealTask(Context context, Integer num, List<File> list, List<ClientTaskDataSubmitFormModel> list2, String str, ApiDataCallBack<String> apiDataCallBack) {
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).submitAppealTask(context, num, list, list2, str), apiDataCallBack);
    }

    public void arbitrament(Context context, int i, List<File> list, String str, ApiDataCallBack<String> apiDataCallBack) {
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).arbitrament(context, Integer.valueOf(i), list, str), apiDataCallBack);
    }

    private boolean isNeedPostPackages(Context context, Integer num) {
        boolean z = num != null && num.equals(TaskDataApplyRecord.VERIFY_PACKAGE);
        LogUtils.logD(TAG, "isNeedPostPackages==>" + z);
        return z;
    }

    public void submitTask(Context context, ClientDetailTaskData clientDetailTaskData, List<File> list, List<ClientTaskDataSubmitFormModel> list2, String str, ApiDataCallBack<String> apiDataCallBack) {
        boolean z;
        int i;
        int i2;
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        boolean z2 = false;
        if (clientDetailTaskData != null) {
            Map<Integer, List<TaskDataStep>> integerListMap = clientDetailTaskData.getIntegerListMap();
            if (integerListMap != null) {
                int i3 = 0;
                i = 0;
                while (i3 < integerListMap.size()) {
                    i3++;
                    List<TaskDataStep> list3 = integerListMap.get(Integer.valueOf(i3));
                    if (list3 != null && list3.size() > 0) {
                        for (int i4 = 0; i4 < list3.size(); i4++) {
                            TaskDataStep taskDataStep = list3.get(i4);
                            if (taskDataStep.isExamplePicStep() && taskDataStep.getTaskDataSampleScreenshotUrl() != null && !TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl().trim())) {
                                i++;
                            }
                        }
                    }
                }
            } else {
                i = 0;
            }
            List<String> formList = clientDetailTaskData.getFormList();
            if (formList != null) {
                i2 = 0;
                for (int i5 = 0; i5 < formList.size(); i5++) {
                    if (!TextUtils.isEmpty(formList.get(i5))) {
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            z = true;
        } else {
            z = false;
            i = 0;
            i2 = 0;
        }
        if (i > 0) {
            if (list == null || list.size() != i) {
                z = false;
                break;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6) == null) {
                    z = false;
                    break;
                }
            }
        }
        if (i2 <= 0) {
            z2 = z;
        } else if (list2 != null && list2.size() == i2) {
            for (int i7 = 0; i7 < list2.size(); i7++) {
                ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = list2.get(i7);
                if (clientTaskDataSubmitFormModel == null || TextUtils.isEmpty(clientTaskDataSubmitFormModel.getKey()) || TextUtils.isEmpty(clientTaskDataSubmitFormModel.getValue())) {
                    break;
                }
            }
            z2 = z;
        }
        if (z2) {
            submitTask(context, clientDetailTaskData, list, list2, null, str, apiDataCallBack);
            return;
        }
        try {
            apiDataCallBack.error(-1, "信息提交不完整");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void submitTask(Context context, ClientDetailTaskData clientDetailTaskData, String str, List<ClientTaskDataSubmitFormModel> list, String str2, ApiDataCallBack<String> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        submitTask(context, clientDetailTaskData, null, list, str, str2, apiDataCallBack);
    }

    public void getTaskDataStatus(Context context, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getTaskDataStatus(context), apiDataCallBack);
    }

    public void getTaskMyPartInList(Context context, ApiDataCallBack<List<ClientSampleTaskData>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getTaskMyPartInList(context), apiDataCallBack);
    }

    public void cplMyPartInList(Context context, ApiDataCallBack<List<ClientSampleTaskData>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).cplMyPartInList(context), apiDataCallBack);
    }

    public void isCanPopUpDialog(final Context context, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).isCanPopUpDialog(context), new ApiDataCallBack<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.19
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientTaskData clientTaskData) throws Exception {
                if (clientTaskData != null) {
                    apiDataCallBack.success(i, ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                } else {
                    apiDataCallBack.error(6001, "数据为空");
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void popupTaskList(final Context context, boolean z, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).popUpTaskList(context, z), new ApiDataCallBack<List<ClientTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.20
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientTaskData> list) throws Exception {
                if (list != null && list.size() > 0) {
                    if (ApiDataHelper.popupTaskList == null) {
                        List unused = ApiDataHelper.popupTaskList = new ArrayList(100);
                    } else {
                        ApiDataHelper.popupTaskList.clear();
                    }
                    for (ClientTaskData clientTaskData : list) {
                        ClientDetailTaskData clientDetailTaskDataSimplifyTaskDetailData = ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData);
                        Integer monitorMethod = clientTaskData.getMonitorMethod();
                        Integer filterFlag = clientTaskData.getFilterFlag();
                        if (monitorMethod != null && 2 == monitorMethod.intValue()) {
                            if (filterFlag == null || 1 != filterFlag.intValue()) {
                                ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                            } else if (SystemUtils.isAppExist(context, clientTaskData.getTaskDataApplicationId())) {
                                ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                            }
                        } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                            if (clientTaskData.getTaskDataApplyRecord() != null) {
                                if (ApiDataHelper.popupTaskList.size() > 0) {
                                    ApiDataHelper.popupTaskList.add(0, clientDetailTaskDataSimplifyTaskDetailData);
                                } else {
                                    ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                                }
                            } else if (clientTaskData.isCheckUsage()) {
                                if (!SystemUtils.isAppExistEver(context, clientTaskData.getPackageName())) {
                                    ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                                }
                            } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                                ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                            }
                        }
                    }
                    if (ApiDataHelper.popupTaskList != null && ApiDataHelper.popupTaskList.size() > 0) {
                        SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
                        apiDataCallBack.success(i, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(0));
                        return;
                    } else {
                        apiDataCallBack.error(6001, "数据为空");
                        return;
                    }
                }
                apiDataCallBack.error(6001, "数据为空");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void ptList3(final Context context, final ApiDataCallBack<List<ClientDetailTaskData>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).popUpTaskList(context, false), new ApiDataCallBack<List<ClientTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.21
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientTaskData> list) throws Exception {
                if (list == null || list.isEmpty()) {
                    apiDataCallBack.error(6001, "数据为空");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (ClientTaskData clientTaskData : list) {
                    Log.d(ApiDataHelper.TAG, "not check cpl,do next");
                    if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                        if (clientTaskData.isCheckUsage()) {
                            if (!SystemUtils.isAppExistEver(context, clientTaskData.getPackageName())) {
                                ClientDetailTaskData clientDetailTaskDataSimplifyTaskDetailData = ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData);
                                Boolean cpl = clientDetailTaskDataSimplifyTaskDetailData.getCpl();
                                if (cpl != null && cpl.booleanValue()) {
                                    arrayList2.add(clientDetailTaskDataSimplifyTaskDetailData);
                                } else {
                                    arrayList.add(clientDetailTaskDataSimplifyTaskDetailData);
                                }
                            }
                        } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                            ClientDetailTaskData clientDetailTaskDataSimplifyTaskDetailData2 = ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData);
                            Boolean cpl2 = clientDetailTaskDataSimplifyTaskDetailData2.getCpl();
                            if (cpl2 != null && cpl2.booleanValue()) {
                                arrayList2.add(clientDetailTaskDataSimplifyTaskDetailData2);
                            } else {
                                arrayList.add(clientDetailTaskDataSimplifyTaskDetailData2);
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    apiDataCallBack.success(i, arrayList);
                } else if (!arrayList2.isEmpty()) {
                    apiDataCallBack.success(i, arrayList2);
                } else {
                    apiDataCallBack.error(6001, "数据为空");
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void ptList2(final Context context, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).popUpTaskList(context, false), new ApiDataCallBack<List<ClientTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.22
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientTaskData> list) throws Exception {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            if (ApiDataHelper.popupTaskList == null) {
                                List unused = ApiDataHelper.popupTaskList = new ArrayList(100);
                            } else {
                                ApiDataHelper.popupTaskList.clear();
                            }
                            Collections.sort(list, new Comparator<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.22.1
                                @Override // java.util.Comparator
                                public int compare(ClientTaskData clientTaskData, ClientTaskData clientTaskData2) {
                                    if (clientTaskData.getClassify().equals("cpa") && !clientTaskData2.getClassify().equals("cpa")) {
                                        return -1;
                                    }
                                    if (clientTaskData.getClassify().equals("cpa") || !clientTaskData2.getClassify().equals("cpa")) {
                                        return Boolean.compare(clientTaskData2.getCpl().booleanValue(), clientTaskData.getCpl().booleanValue());
                                    }
                                    return 1;
                                }
                            });
                            for (ClientTaskData clientTaskData : list) {
                                Log.d(ApiDataHelper.TAG, "not check cpl,do next");
                                if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                                    if (clientTaskData.isCheckUsage()) {
                                        if (!SystemUtils.isAppExistEver(context, clientTaskData.getPackageName())) {
                                            ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                                        }
                                    } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                                        ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                                    }
                                }
                            }
                            if (ApiDataHelper.popupTaskList != null && ApiDataHelper.popupTaskList.size() > 0) {
                                SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
                                apiDataCallBack.success(i, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(0));
                                return;
                            } else {
                                apiDataCallBack.error(6001, "数据为空");
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(ApiDataHelper.TAG, "ptList2 error,msg:" + e2.getMessage());
                        apiDataCallBack.error(6001, "数据为空");
                        return;
                    }
                }
                apiDataCallBack.error(6001, "数据为空");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void changeTask(final Context context, final boolean z, boolean z2, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) throws Exception {
        int i;
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (z2) {
            i = SharedPreferencesUtils.getInstance(context).getInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
        } else {
            i = SharedPreferencesUtils.getInstance(context).getInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
        }
        final int i2 = i + 1;
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).popUpTaskList(context, z2), new ApiDataCallBack<List<ClientTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.23
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i3, List<ClientTaskData> list) throws Exception {
                if (ApiDataHelper.popupTaskList == null) {
                    List unused = ApiDataHelper.popupTaskList = new ArrayList(100);
                } else {
                    ApiDataHelper.popupTaskList.clear();
                }
                if (z) {
                    Collections.sort(list, new Comparator<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.23.1
                        @Override // java.util.Comparator
                        public int compare(ClientTaskData clientTaskData, ClientTaskData clientTaskData2) {
                            if (clientTaskData.getClassify().equals("cpa") && !clientTaskData2.getClassify().equals("cpa")) {
                                return -1;
                            }
                            if (clientTaskData.getClassify().equals("cpa") || !clientTaskData2.getClassify().equals("cpa")) {
                                return Boolean.compare(clientTaskData2.getCpl().booleanValue(), clientTaskData.getCpl().booleanValue());
                            }
                            return 1;
                        }
                    });
                }
                for (ClientTaskData clientTaskData : list) {
                    ClientDetailTaskData clientDetailTaskDataSimplifyTaskDetailData = ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData);
                    Integer monitorMethod = clientTaskData.getMonitorMethod();
                    Integer filterFlag = clientTaskData.getFilterFlag();
                    if (monitorMethod != null && 2 == monitorMethod.intValue()) {
                        if (filterFlag == null || 1 != filterFlag.intValue()) {
                            ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                        } else if (SystemUtils.isAppExist(context, clientTaskData.getTaskDataApplicationId())) {
                            ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                        }
                    } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                        if (clientTaskData.getTaskDataApplyRecord() != null) {
                            if (ApiDataHelper.popupTaskList.size() > 0) {
                                ApiDataHelper.popupTaskList.add(0, clientDetailTaskDataSimplifyTaskDetailData);
                            } else {
                                ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                            }
                        } else if (clientTaskData.isCheckUsage()) {
                            if (!SystemUtils.isAppExistEver(context, clientTaskData.getPackageName())) {
                                ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                            }
                        } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                            ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                        }
                    }
                }
                if (ApiDataHelper.popupTaskList != null && ApiDataHelper.popupTaskList.size() > 0) {
                    if (i2 < ApiDataHelper.popupTaskList.size()) {
                        if (ApiDataHelper.popupTaskList.size() == 1) {
                            SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", i2);
                            apiDataCallBack.success(1, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(i2));
                            return;
                        } else {
                            SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", i2);
                            apiDataCallBack.success(0, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(i2));
                            return;
                        }
                    }
                    if (ApiDataHelper.popupTaskList.size() == 1) {
                        SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
                        apiDataCallBack.success(1, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(0));
                        return;
                    } else {
                        SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
                        apiDataCallBack.success(0, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(0));
                        return;
                    }
                }
                apiDataCallBack.error(6001, "数据为空");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i3, String str) throws Exception {
                apiDataCallBack.error(6001, "数据为空");
            }
        });
    }

    public void clearPopupTask() {
        List<ClientDetailTaskData> list = popupTaskList;
        if (list == null || list.size() <= 0) {
            return;
        }
        popupTaskList.clear();
        popupTaskList = null;
    }

    public void removePopuTask(Context context) {
        int i = SharedPreferencesUtils.getInstance(context).getInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
        List<ClientDetailTaskData> list = popupTaskList;
        if (list != null && list.size() > i) {
            popupTaskList.remove(i);
        }
        int i2 = i + 1;
        if (i2 < popupTaskList.size()) {
            SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", i2);
        } else {
            SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
        }
    }

    public int getPopupTaskSize() {
        List<ClientDetailTaskData> list = popupTaskList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void getAppConfig(Context context, ApiDataCallBack<List<AppConfig>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getAppConfig(context), apiDataCallBack);
    }

    public void getItemConfig(Context context, ApiDataCallBack<List<ItemConfig>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getItemConfig(context), apiDataCallBack);
    }

    public void cpaLog(Context context, String str, Integer num, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).cpaLog(context, str, num), apiDataCallBack);
    }

    public void itemLog(Context context, String str, Integer num, int i, List<Integer> list, Integer num2, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).itemLog(context, str, num, i, list, num2), apiDataCallBack);
    }

    public void cplLog(Context context, Integer num, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).cplLog(context, num), apiDataCallBack);
    }

    public void uploadAliyunSession(Context context, String str, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).uploadAliyunToken(context, str), apiDataCallBack);
    }

    public void uploadDeviceInfo(final Context context, final ApiDataCallBack<Object> apiDataCallBack) throws NoSuchMethodException, SecurityException {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        final UserDeviceInfo userDeviceInfo = MokuConfigure.getInstance().getUserDeviceInfo(context);
        if (userDeviceInfo != null) {
            final BigDecimal longitude = userDeviceInfo.getLongitude();
            final BigDecimal latitude = userDeviceInfo.getLatitude();
            if (longitude != null && latitude != null && longitude.compareTo(BigDecimal.ZERO) > 0 && latitude.compareTo(BigDecimal.ZERO) > 0) {
                if (BDUtil.getInstance().isEnable(context)) {
                    Log.d(TAG, "bd location is able,do next");
                    Observable.create(new ObservableOnSubscribe<String>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.24
                        @Override // io.reactivex.ObservableOnSubscribe
                        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                            String strBdLocationWithSN = BDUtil.getInstance().bdLocationWithSN(context, longitude.toEngineeringString(), latitude.toEngineeringString());
                            Log.d(ApiDataHelper.TAG, "location:" + strBdLocationWithSN);
                            userDeviceInfo.setLongitudeAndLatitudeAddress(strBdLocationWithSN);
                            observableEmitter.onNext(strBdLocationWithSN);
                        }
                    }).subscribeOn(Schedulers.io()).subscribe(new Observer<String>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.25
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onSubscribe(Disposable disposable) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(String str) {
                            Log.d(ApiDataHelper.TAG, "get location from bd success,do next");
                            ApiDataHelper.this.doUploadDeviceInfo(context, apiDataCallBack);
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                            Log.e(ApiDataHelper.TAG, "get location from bd error,msg:" + th.getMessage());
                            ApiDataHelper.this.doUploadDeviceInfo(context, apiDataCallBack);
                        }
                    });
                    return;
                } else {
                    Log.d(TAG, "bd location diseable,do next");
                    doUploadDeviceInfo(context, apiDataCallBack);
                    return;
                }
            }
            Log.d(TAG, "no location,do next");
            doUploadDeviceInfo(context, apiDataCallBack);
            return;
        }
        doUploadDeviceInfo(context, apiDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUploadDeviceInfo(Context context, ApiDataCallBack<Object> apiDataCallBack) {
        Log.d(TAG, "do UploadDeviceInfo invoke");
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).uploadDeviceInfo(context), apiDataCallBack);
    }

    public void getUserType(Context context, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getUserType(context), apiDataCallBack);
    }

    public void alipayKey(Context context, ApiDataCallBack<AlipayConfigData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).alipayKey(context), apiDataCallBack);
    }

    public void getReSubmittedStatus(Context context, ApiDataCallBack<Integer> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getReSubmittedStatus(context), apiDataCallBack);
    }

    public void confirmReSubmitted(Context context, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).confirmReSubmitted(context), apiDataCallBack);
    }

    public void getSurplusCreditScore(Context context, ApiDataCallBack<Map<String, Object>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getSurplusCreditScore(context), apiDataCallBack);
    }

    public void readUserReported(Context context, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).readUserReported(context), apiDataCallBack);
    }

    public void getAppeal(Context context, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getAppeal(context), apiDataCallBack);
    }

    public void uploadVideo(Context context, File file, ApiDataCallBack<UploadVideoReponse> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).uploadVideo(context, file), apiDataCallBack);
    }

    public void easyCollection(Integer num, Context context, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).easyCollection(num, context), apiDataCallBack);
    }

    public void beginEasyCollection(Integer num, Context context, ApiDataCallBack<EasyCollectionEntity> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).beginEasyCollection(num, context), apiDataCallBack);
    }

    public void bdConfig(Context context, ApiDataCallBack<BaiduConfigData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).bdConfig(context), apiDataCallBack);
    }

    public void getDianTaskList(Context context, int i, int i2, int i3, Integer num, List<Integer> list, Integer num2, ApiDataCallBack<ClientSampleTaskDataList> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getDianTaskList(context, SystemUtils.getSimulatorCode(context), i, Integer.valueOf(i2), i3, num, list, num2), new AnonymousClass26(context, apiDataCallBack));
    }

    /* renamed from: com.fendasz.moku.planet.helper.ApiDataHelper$26, reason: invalid class name */
    class AnonymousClass26 implements ApiDataCallBack<ClientSampleTaskDataList> {
        final /* synthetic */ ApiDataCallBack val$callBack;
        final /* synthetic */ Context val$context;

        AnonymousClass26(Context context, ApiDataCallBack apiDataCallBack) {
            this.val$context = context;
            this.val$callBack = apiDataCallBack;
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void success(final int i, final ClientSampleTaskDataList clientSampleTaskDataList) throws Exception {
            ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.26.1
                @Override // java.lang.Runnable
                public void run() {
                    ClientSampleTaskDataList clientSampleTaskDataList2 = clientSampleTaskDataList;
                    if (clientSampleTaskDataList2 != null && clientSampleTaskDataList2.getList() != null && clientSampleTaskDataList.getList().size() > 0) {
                        List<ClientSampleTaskData> listFilterExistHpTask = ApiDataHelper.this.filterExistHpTask(AnonymousClass26.this.val$context, clientSampleTaskDataList.getList());
                        try {
                            listFilterExistHpTask = ApiDataHelper.this.filterExistTaskEver(AnonymousClass26.this.val$context, listFilterExistHpTask);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        clientSampleTaskDataList.setList(listFilterExistHpTask);
                    }
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.26.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass26.this.val$callBack != null) {
                                try {
                                    AnonymousClass26.this.val$callBack.success(i, clientSampleTaskDataList);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }

        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
        public void error(int i, String str) throws Exception {
            ApiDataCallBack apiDataCallBack = this.val$callBack;
            if (apiDataCallBack != null) {
                try {
                    apiDataCallBack.error(i, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getDianTaskDetail(final Context context, Integer num, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getDianTaskDetail(context, num), new ApiDataCallBack<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.27
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientTaskData clientTaskData) throws Exception {
                clientTaskData.setTaskType(clientTaskData.getTaskData().getTaskType());
                apiDataCallBack.success(i, ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void getDianTaskRecordList(Context context, List<Integer> list, final ApiDataCallBack<List<ClientSampleTaskDataRecord>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).getDianTaskRecordList(context, list), new ApiDataCallBack<List<ClientSampleTaskDataRecord>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.28
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientSampleTaskDataRecord> list2) throws Exception {
                LogUtils.log(ApiDataHelper.TAG, "TaskRecordList size before filter is " + list2.size() + "");
                apiDataCallBack.success(i, list2);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void dianPostGateType(Context context, String str, Integer num, final ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianPostGateType(context, str, num), new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.29
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                apiDataCallBack.success(i, obj);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                apiDataCallBack.error(i, str2);
            }
        });
    }

    public void dianApplyTask(Context context, Integer num, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianApplyTask(context, num), apiDataCallBack);
    }

    public void dianCancelTask(Context context, ClientDetailTaskData clientDetailTaskData, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (clientDetailTaskData.getTaskDataApplyRecord() == null) {
            try {
                apiDataCallBack.error(-1, "找不到申请记录");
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianCancelTask(context, clientDetailTaskData.getTaskDataId(), clientDetailTaskData.getTaskDataApplyRecord().getId()), apiDataCallBack);
    }

    public void dianCancelTask(Context context, Integer num, Integer num2, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianCancelTask(context, num, num2), apiDataCallBack);
    }

    public void dianSubmitTask(Context context, ClientDetailTaskData clientDetailTaskData, String str, List<ClientTaskDataSubmitFormModel> list, String str2, ApiDataCallBack<String> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        dianSubmitTask(context, clientDetailTaskData, null, list, str, str2, apiDataCallBack);
    }

    public void dianSubmitTask(Context context, ClientDetailTaskData clientDetailTaskData, List<File> list, List<ClientTaskDataSubmitFormModel> list2, String str, ApiDataCallBack<String> apiDataCallBack) {
        boolean z;
        int i;
        int i2;
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        boolean z2 = false;
        if (clientDetailTaskData != null) {
            Map<Integer, List<TaskDataStep>> integerListMap = clientDetailTaskData.getIntegerListMap();
            if (integerListMap != null) {
                int i3 = 0;
                i = 0;
                while (i3 < integerListMap.size()) {
                    i3++;
                    List<TaskDataStep> list3 = integerListMap.get(Integer.valueOf(i3));
                    if (list3 != null && list3.size() > 0) {
                        for (int i4 = 0; i4 < list3.size(); i4++) {
                            TaskDataStep taskDataStep = list3.get(i4);
                            if (taskDataStep.isExamplePicStep() && !TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl().trim())) {
                                i++;
                            }
                        }
                    }
                }
            } else {
                i = 0;
            }
            List<String> formList = clientDetailTaskData.getFormList();
            if (formList != null) {
                i2 = 0;
                for (int i5 = 0; i5 < formList.size(); i5++) {
                    if (!TextUtils.isEmpty(formList.get(i5))) {
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            z = true;
        } else {
            z = false;
            i = 0;
            i2 = 0;
        }
        if (i > 0) {
            if (list == null || list.size() != i) {
                z = false;
                break;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6) == null) {
                    z = false;
                    break;
                }
            }
        }
        if (i2 <= 0) {
            z2 = z;
        } else if (list2 != null && list2.size() == i2) {
            for (int i7 = 0; i7 < list2.size(); i7++) {
                ClientTaskDataSubmitFormModel clientTaskDataSubmitFormModel = list2.get(i7);
                if (clientTaskDataSubmitFormModel == null || TextUtils.isEmpty(clientTaskDataSubmitFormModel.getKey()) || TextUtils.isEmpty(clientTaskDataSubmitFormModel.getValue())) {
                    break;
                }
            }
            z2 = z;
        }
        if (z2) {
            dianSubmitTask(context, clientDetailTaskData, list, list2, null, str, apiDataCallBack);
            return;
        }
        try {
            apiDataCallBack.error(-1, "信息提交不完整");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void dianSubmitTask(final Context context, final ClientDetailTaskData clientDetailTaskData, final List<File> list, final List<ClientTaskDataSubmitFormModel> list2, final String str, final String str2, final ApiDataCallBack<String> apiDataCallBack) {
        if (isNeedPostPackages(context, clientDetailTaskData.getTaskDataApplyRecord().getCheckTheState())) {
            postPackages(context, new ApiDataCallBack<String>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.30
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i, String str3) throws Exception {
                    ApiCreateObservable apiCreateObservable = ApiCreateObservable.getInstance();
                    Context context2 = context;
                    apiCreateObservable.createObservableWithNetTime(context2, TaskApiRemoteDataSource.getInstance(context2).dianSubmitTask(context, clientDetailTaskData.getTaskDataId(), list, list2, str, str2), apiDataCallBack);
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i, String str3) throws Exception {
                    apiDataCallBack.error(i, str3);
                }
            });
        } else {
            ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianSubmitTask(context, clientDetailTaskData.getTaskDataId(), list, list2, str, str2), apiDataCallBack);
        }
    }

    public void dianCancelWithoutMonitor(Context context, Integer num, Integer num2, ApiDataCallBack<Object> apiDataCallBack) {
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianCancelWithoutMonitor(context, num, num2), apiDataCallBack);
    }

    public void dianGetTaskDataStatus(Context context, ApiDataCallBack<TaskDataApplyRecord> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianGetTaskDataStatus(context), apiDataCallBack);
    }

    public void dianCPLTaskDetail(final Context context, Integer num, final ApiDataCallBack<ClientGameTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianCPLTaskDetail(context, num), new ApiDataCallBack<ClientTaskData>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.31
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientTaskData clientTaskData) throws Exception {
                apiDataCallBack.success(i, ApiDataHelper.this.simplifyTaskGameData(context, clientTaskData));
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void dianMyPartInList(Context context, ApiDataCallBack<List<ClientSampleTaskData>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianMyPartInList(context), apiDataCallBack);
    }

    public void dianPopupTaskList(final Context context, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianPopUpTaskList(context), new ApiDataCallBack<List<ClientTaskData>>() { // from class: com.fendasz.moku.planet.helper.ApiDataHelper.32
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientTaskData> list) throws Exception {
                if (list != null && list.size() > 0) {
                    if (ApiDataHelper.popupTaskList == null) {
                        List unused = ApiDataHelper.popupTaskList = new ArrayList(100);
                    } else {
                        ApiDataHelper.popupTaskList.clear();
                    }
                    for (ClientTaskData clientTaskData : list) {
                        if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                            if (clientTaskData.getTaskDataApplyRecord() != null) {
                                ClientDetailTaskData clientDetailTaskDataSimplifyTaskDetailData = ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData);
                                if (ApiDataHelper.popupTaskList.size() > 0) {
                                    ApiDataHelper.popupTaskList.add(0, clientDetailTaskDataSimplifyTaskDetailData);
                                } else {
                                    ApiDataHelper.popupTaskList.add(clientDetailTaskDataSimplifyTaskDetailData);
                                }
                            } else if (clientTaskData.isCheckUsage()) {
                                if (!SystemUtils.isAppExistEver(context, clientTaskData.getPackageName())) {
                                    ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                                }
                            } else if (!SystemUtils.isAppExist(context, clientTaskData.getPackageName())) {
                                ApiDataHelper.popupTaskList.add(ApiDataHelper.this.simplifyTaskDetailData(context, clientTaskData));
                            }
                        }
                    }
                    if (ApiDataHelper.popupTaskList != null && ApiDataHelper.popupTaskList.size() > 0) {
                        SharedPreferencesUtils.getInstance(context).putInt("MOKU_PUPUP_TASK_SHOW_INDEX_KEY", 0);
                        apiDataCallBack.success(i, (ClientDetailTaskData) ApiDataHelper.popupTaskList.get(0));
                        return;
                    } else {
                        apiDataCallBack.error(6001, "数据为空");
                        return;
                    }
                }
                apiDataCallBack.error(6001, "数据为空");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public void dianGetItemConfig(Context context, ApiDataCallBack<List<ItemConfig>> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianGetItemConfig(context), apiDataCallBack);
    }

    public void dianCpaLog(Context context, String str, Integer num, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianCpaLog(context, str, num), apiDataCallBack);
    }

    public void dianCplLog(Context context, Integer num, ApiDataCallBack<Object> apiDataCallBack) {
        if (context == null) {
            try {
                apiDataCallBack.error(-200, "context is null");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ApiCreateObservable.getInstance().createObservableWithNetTime(context, TaskApiRemoteDataSource.getInstance(context).dianCplLog(context, num), apiDataCallBack);
    }

    public void closeDisposable() {
        ApiCreateObservable.getInstance().closeDisposable();
        apiDataHelper = null;
    }
}
