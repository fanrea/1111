package com.fendasz.moku.planet.source.remote;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.container.adrequest.g;
import com.fendasz.moku.diandian.entity.requestmodel.DianParameterModel;
import com.fendasz.moku.planet.common.network.result.ApiResult;
import com.fendasz.moku.planet.common.rxbus.RxBus;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.source.BaseApiRemoteDataSource;
import com.fendasz.moku.planet.source.bean.AlipayConfigData;
import com.fendasz.moku.planet.source.bean.AppConfig;
import com.fendasz.moku.planet.source.bean.BaiduConfigData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.source.bean.ClientTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataRecord;
import com.fendasz.moku.planet.source.bean.ClientTaskDataSubmitFormModel;
import com.fendasz.moku.planet.source.bean.ClientTaskRecordListInfo;
import com.fendasz.moku.planet.source.bean.CustomerServiceConfig;
import com.fendasz.moku.planet.source.bean.DianClientTaskRecordListInfo;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.UploadVideoReponse;
import com.fendasz.moku.planet.source.bean.VideoConfig;
import com.fendasz.moku.planet.source.remote.api.TaskApi;
import com.fendasz.moku.planet.source.requestmodel.AliyunTokenBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.CPLBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.DianCPLBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.TaskBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.UserDeviceBasicParameterModel;
import com.fendasz.moku.planet.utils.AesUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.Md5Utils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneInfoUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.system.entity.PackageInfoEntity;
import com.luck.picture.lib.config.SelectMimeType;
import com.sigmob.sdk.base.n;
import io.reactivex.Observable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskApiRemoteDataSource extends BaseApiRemoteDataSource<TaskApi> {
    public static final String TAG = "TaskApiRemoteDataSource";
    private static TaskApiRemoteDataSource instance;

    private TaskApiRemoteDataSource(Context context) {
        super(context, TaskApi.class);
    }

    public static TaskApiRemoteDataSource getInstance(Context context) {
        if (instance == null) {
            synchronized (TaskApiRemoteDataSource.class) {
                if (instance == null) {
                    instance = new TaskApiRemoteDataSource(context);
                }
            }
        }
        return instance;
    }

    public static void reSet() {
        instance = null;
    }

    private TaskBasicParameterModel getBasicParameterModel(Context context) {
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        String string = MokuConfigure.getInstance().getMokuOptions(context).getString(g.z, "");
        String string2 = MokuConfigure.getInstance().getMokuOptions(context).getString("oaid", "");
        if (!TextUtils.isEmpty(string)) {
            phoneInfo.setImei(string);
        } else {
            phoneInfo.setImei(string2);
        }
        phoneInfo.setOsv(String.valueOf(Build.VERSION.SDK_INT));
        TaskBasicParameterModel taskBasicParameterModel = new TaskBasicParameterModel();
        taskBasicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        taskBasicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        taskBasicParameterModel.setMokuOptions(MokuConfigure.getInstance().getMokuOptions(context));
        String strDecrypt = AesUtil.decrypt(taskBasicParameterModel.getData(), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret());
        taskBasicParameterModel.setImsi2(PhoneInfoUtils.getInstance().getImsi2(context));
        taskBasicParameterModel.setImei1(PhoneInfoUtils.getInstance().getPhoneImeiNum(context));
        taskBasicParameterModel.setMeid(PhoneInfoUtils.getInstance().getMeid(context));
        String str = TAG;
        LogUtils.log(str, "basicParameterModel.appId >> " + taskBasicParameterModel.getAppId());
        LogUtils.log(str, "basicParameterModel.data >> " + strDecrypt);
        String string3 = MokuConfigure.getInstance().getMokuOptions(context).getString("additionalData", null);
        if (string3 != null) {
            taskBasicParameterModel.setAdditionalData(string3);
        }
        phoneInfo.setSdkType("1");
        return taskBasicParameterModel;
    }

    private CPLBasicParameterModel getCPLBasicParameterModel(Context context) {
        String imei2;
        CPLBasicParameterModel cPLBasicParameterModel = new CPLBasicParameterModel();
        cPLBasicParameterModel.setFromAndroid(true);
        MokuConfigure.getInstance().getPhoneInfo(context).setSdkType("1");
        MokuConfigure.getInstance().getPhoneInfo(context).setImei1(PhoneInfoUtils.getInstance().getPhoneImeiNum(context));
        cPLBasicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        cPLBasicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        if (Build.VERSION.SDK_INT >= 21 && PermissionUtils.isGranted(context, "android.permission.READ_PHONE_STATE") && (imei2 = PhoneInfoUtils.getInstance().getImei2(context)) != null && !StringUtils.isEmpty(imei2)) {
            cPLBasicParameterModel.setImei2(imei2);
        }
        String strDecrypt = AesUtil.decrypt(cPLBasicParameterModel.getData(), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret());
        String str = TAG;
        LogUtils.log(str, "basicParameterModel.appId >> " + cPLBasicParameterModel.getAppId());
        LogUtils.log(str, "basicParameterModel.data >> " + strDecrypt);
        String string = MokuConfigure.getInstance().getMokuOptions(context).getString("additionalData", null);
        if (string != null) {
            cPLBasicParameterModel.setAdditionalData(string);
        }
        return cPLBasicParameterModel;
    }

    private AliyunTokenBasicParameterModel getAliyunBasicParameterModel(Context context, String str) {
        AliyunTokenBasicParameterModel aliyunTokenBasicParameterModel = new AliyunTokenBasicParameterModel();
        MokuConfigure.getInstance().getPhoneInfo(context).setSdkType("1");
        aliyunTokenBasicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        aliyunTokenBasicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        String strDecrypt = AesUtil.decrypt(aliyunTokenBasicParameterModel.getData(), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret());
        String str2 = TAG;
        LogUtils.log(str2, "basicParameterModel.appId >> " + aliyunTokenBasicParameterModel.getAppId());
        LogUtils.log(str2, "basicParameterModel.data >> " + strDecrypt);
        aliyunTokenBasicParameterModel.setDeviceToken(str);
        return aliyunTokenBasicParameterModel;
    }

    private UserDeviceBasicParameterModel getDeviceBasicParameterModel(Context context) throws NoSuchMethodException, SecurityException {
        UserDeviceBasicParameterModel userDeviceBasicParameterModel = new UserDeviceBasicParameterModel();
        userDeviceBasicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        userDeviceBasicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        String strDecrypt = AesUtil.decrypt(userDeviceBasicParameterModel.getData(), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret());
        String str = TAG;
        LogUtils.log(str, "basicParameterModel.appId >> " + userDeviceBasicParameterModel.getAppId());
        LogUtils.log(str, "basicParameterModel.data >> " + strDecrypt);
        MokuConfigure.getInstance().refreshSectionUserDeviceInfo(context);
        userDeviceBasicParameterModel.setUserDeviceInfo(MokuConfigure.getInstance().getUserDeviceInfo(context));
        return userDeviceBasicParameterModel;
    }

    public Observable<ApiResult<List<ClientSampleTaskData>>> getTaskList(Context context, List<String> list) {
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setTaskClassifyList(list);
        return getApi().getTaskList(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskData>>> getTaskList(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hp");
        arrayList.add("keyword");
        arrayList.add("comment");
        arrayList.add("cpa");
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setTaskClassifyList(arrayList);
        return getApi().getTaskList(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientSampleTaskDataList>> getCPLTaskList(Context context, int i, int i2, Integer num) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hp");
        arrayList.add("keyword");
        arrayList.add("comment");
        arrayList.add("cpa");
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setTaskClassifyList(arrayList);
        basicParameterModel.setPage(Integer.valueOf(i2));
        basicParameterModel.setPageSize(num);
        basicParameterModel.setSimulatorCode(Integer.valueOf(i));
        return getApi().getCPLTaskList(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskData>>> rewardTaskList(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hp");
        arrayList.add("keyword");
        arrayList.add("comment");
        arrayList.add("cpa");
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setTaskClassifyList(arrayList);
        basicParameterModel.setListType(1000);
        basicParameterModel.setSimulatorCode(Integer.valueOf(i));
        return getApi().rewardTaskList(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientSampleTaskDataList>> getPagedTaskList(Context context, int i, int i2, Integer num, int i3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hp");
        arrayList.add("keyword");
        arrayList.add("comment");
        arrayList.add("cpa");
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setTaskClassifyList(arrayList);
        basicParameterModel.setPage(Integer.valueOf(i2));
        basicParameterModel.setPageSize(num);
        basicParameterModel.setListType(Integer.valueOf(i3));
        basicParameterModel.setSimulatorCode(Integer.valueOf(i));
        return getApi().getPagedTaskList(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientSampleTaskDataList>> getPagedTaskListV3(Context context, int i, int i2, Integer num, int i3, int i4, List<Integer> list, Integer num2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hp");
        arrayList.add("keyword");
        arrayList.add("comment");
        arrayList.add("cpa");
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setTaskClassifyList(arrayList);
        basicParameterModel.setPage(Integer.valueOf(i2));
        basicParameterModel.setPageSize(num);
        basicParameterModel.setListType(Integer.valueOf(i3));
        basicParameterModel.setSimulatorCode(Integer.valueOf(i));
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        phoneInfo.setItemId(Integer.valueOf(i4));
        phoneInfo.setTagIdList(list);
        phoneInfo.setTagId(num2);
        basicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        basicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        return getApi().getPagedTaskList3(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskData>> getTaskDetail(Context context, Integer num, int i) {
        if (i == 1) {
            return getApi().getAppealTaskDetail(num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
        }
        return getApi().getTaskDetail(num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskData>> getGameTaskDetail(Context context, Integer num) {
        return getApi().getGameTaskDetail(num, getCPLBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> postGateType(Context context, String str, Integer num) {
        return getApi().postGateType(str, num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> applyTask(Context context, Integer num) {
        return getApi().applyTask(num, getCPLBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> applyEasyTask(Context context, Integer num, Integer num2) {
        return getApi().applyEasyTask(num, num2, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> cancelTask(Context context, Integer num, Integer num2) {
        return getApi().cancelTask(num, num2, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> cancelWithoutMonitor(Context context, Integer num, Integer num2) {
        return getApi().cancelWithoutMonitor(num, num2, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<String>> submitTask(Context context, Integer num, List<File> list, List<ClientTaskDataSubmitFormModel> list2, String str, String str2) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        phoneInfo.setSdkType("1");
        builder.addFormDataPart("appId", phoneInfo.getAppId());
        String jSONString = JSON.toJSONString(phoneInfo);
        LogUtils.logD(TAG, "phoneInfoData==>" + jSONString);
        builder.addFormDataPart("data", AesUtil.encrypt(jSONString, phoneInfo.getAppId() + phoneInfo.getAppSecret()));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.addFormDataPart("pics", Md5Utils.getMD5String(list.get(i).getName()) + list.get(i).getName().substring(list.get(i).getName().lastIndexOf(".")), RequestBody.create(MediaType.parse(SelectMimeType.SYSTEM_IMAGE), list.get(i)));
            }
        }
        if (list2 != null && list2.size() > 0) {
            builder.addFormDataPart("formList", JSON.toJSONString(list2));
        }
        if (!TextUtils.isEmpty(str)) {
            builder.addFormDataPart("answer", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.addFormDataPart("additionalData", str2);
        }
        builder.addFormDataPart("cutInType", String.valueOf(MokuConfigure.getInstance().getMokuOptions(context).getInteger("cutInType", 0)));
        return getApi().submitTask(num, builder.build()).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<String>> submitAppealTask(Context context, Integer num, List<File> list, List<ClientTaskDataSubmitFormModel> list2, String str) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("appId", MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        builder.addFormDataPart("data", AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.addFormDataPart("pics", Md5Utils.getMD5String(list.get(i).getName()) + list.get(i).getName().substring(list.get(i).getName().lastIndexOf(".")), RequestBody.create(MediaType.parse(SelectMimeType.SYSTEM_IMAGE), list.get(i)));
            }
        }
        if (list2 != null && list2.size() > 0) {
            builder.addFormDataPart("formList", JSON.toJSONString(list2));
        }
        if (!TextUtils.isEmpty(str)) {
            builder.addFormDataPart("appealReason", str);
        }
        return getApi().submitAppealTask(num, builder.build()).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<String>> arbitrament(Context context, Integer num, List<File> list, String str) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("appId", MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        builder.addFormDataPart("data", AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.addFormDataPart("pics", Md5Utils.getMD5String(list.get(i).getName()) + list.get(i).getName().substring(list.get(i).getName().lastIndexOf(".")), RequestBody.create(MediaType.parse(SelectMimeType.SYSTEM_IMAGE), list.get(i)));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            builder.addFormDataPart("arbitramentReason", str);
        }
        return getApi().arbitrament(num, builder.build()).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> getTaskDataStatus(Context context) {
        return getApi().getTaskDataStatus(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Long>> getNetTime() {
        LogUtils.log(TAG, "get net time");
        return getApi().getNetTime().compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<String>>> getAppInfoList(String str) {
        return getApi().getAppInfoList(str).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<VideoConfig>> getVideoConfig() {
        return getApi().getVideoConfig().compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<CustomerServiceConfig>> getCustomerServiceConfig() {
        return getApi().getCustomerServiceConfig().compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskDataRecord>>> getTaskRecordList(Context context, List<Integer> list) {
        ClientTaskRecordListInfo clientTaskRecordListInfo = (ClientTaskRecordListInfo) JSON.parseObject(JSON.toJSONString(getBasicParameterModel(context)), ClientTaskRecordListInfo.class);
        clientTaskRecordListInfo.setRecordStatusList(list);
        return getApi().getTaskRecordList(clientTaskRecordListInfo).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskDataRecord>>> arbitramentRecordList(Context context) {
        return getApi().arbitramentRecordList(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskDataRecord>> getTaskRecordDetail(Context context, Integer num) {
        return getApi().getTaskRecordDetail(num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<String>> postPackages(Context context, boolean z, boolean z2, List<PackageInfoEntity> list) {
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        basicParameterModel.setPackageInfos(list);
        basicParameterModel.setAdbEnabled(Boolean.valueOf(z));
        basicParameterModel.setAccessibilityEnabled(Boolean.valueOf(z2));
        return getApi().postPackages(basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskData>>> getTaskMyPartInList(Context context) {
        return getApi().getTaskMyPartInList(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskData>>> cplMyPartInList(Context context) {
        return getApi().cplMyPartInList(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<String> getDomainConfig() {
        return getApi().getDomainConfig().compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskData>> isCanPopUpDialog(Context context) {
        return getApi().isCanPopUpDialog(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientTaskData>>> popUpTaskList(Context context, boolean z) {
        if (z) {
            return getApi().dianPopUpList(getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
        }
        return getApi().popUpList(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskData>> changeTask(Context context) {
        return getApi().changeTask(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<AppConfig>>> getAppConfig(Context context) {
        return getApi().getAppConfig(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ItemConfig>>> getItemConfig(Context context) {
        return getApi().getItemConfig(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> cpaLog(Context context, String str, Integer num) {
        return getApi().cpaLog(str, num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> itemLog(Context context, String str, Integer num, int i, List<Integer> list, Integer num2) {
        TaskBasicParameterModel basicParameterModel = getBasicParameterModel(context);
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        phoneInfo.setItemId(Integer.valueOf(i));
        phoneInfo.setTagIdList(list);
        phoneInfo.setTagId(num2);
        basicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        basicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        return getApi().itemLog(str, Integer.valueOf(num == null ? 0 : num.intValue()), basicParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> cplLog(Context context, Integer num) {
        return getApi().cplOpenGame(num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> uploadDeviceInfo(Context context) throws NoSuchMethodException, SecurityException {
        return getApi().uploadUserDevice(getDeviceBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> uploadAliyunToken(Context context, String str) {
        return getApi().uploadAliyunToken(getAliyunBasicParameterModel(context, str)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> getUserType(Context context) {
        return getApi().getUserType(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<AlipayConfigData>> alipayKey(Context context) {
        return getApi().alipayKey(getDeviceBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Integer>> getReSubmittedStatus(Context context) {
        return getApi().getReSubmittedStatus(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> confirmReSubmitted(Context context) {
        return getApi().confirmReSubmitted(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Map<String, Object>>> getSurplusCreditScore(Context context) {
        return getApi().getSurplusCreditScore(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> readUserReported(Context context) {
        return getApi().readUserReported(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> getAppeal(Context context) {
        return getApi().getAppeal(getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<UploadVideoReponse>> uploadVideo(Context context, File file) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("appId", MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        String jSONString = JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context));
        Log.d(TAG, "phoneInfoData==>" + jSONString);
        builder.addFormDataPart("data", AesUtil.encrypt(jSONString, MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        if (file != null) {
            builder.addFormDataPart(n.z, Md5Utils.getMD5String(file.getName()) + file.getName().substring(file.getName().lastIndexOf(".")), RequestBody.create(MediaType.parse(SelectMimeType.SYSTEM_IMAGE), file));
        }
        return getApi().uploadVideo(builder.build()).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> easyCollection(Integer num, Context context) {
        return getApi().easyCollection(num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<EasyCollectionEntity>> beginEasyCollection(Integer num, Context context) {
        return getApi().beginEasyCollection(num, getBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<BaiduConfigData>> bdConfig(Context context) {
        return getApi().bdConfig().compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientSampleTaskDataList>> getDianTaskList(Context context, int i, int i2, Integer num, int i3, Integer num2, List<Integer> list, Integer num3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hp");
        arrayList.add("keyword");
        arrayList.add("comment");
        arrayList.add("cpa");
        DianParameterModel dianParameterModel = getDianParameterModel(context);
        dianParameterModel.setTaskClassifyList(arrayList);
        dianParameterModel.setPage(Integer.valueOf(i2));
        dianParameterModel.setPageSize(num);
        dianParameterModel.setListType(Integer.valueOf(i3));
        dianParameterModel.setSimulatorCode(Integer.valueOf(i));
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        phoneInfo.setItemId(num2);
        phoneInfo.setTagIdList(list);
        phoneInfo.setTagId(num3);
        phoneInfo.setListType(Integer.valueOf(i3));
        phoneInfo.setSdkType("2");
        phoneInfo.setPage(Integer.valueOf(i2));
        phoneInfo.setPageSize(num);
        dianParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        dianParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        phoneInfo.setListType(null);
        phoneInfo.setSdkType("1");
        phoneInfo.setPage(null);
        phoneInfo.setPageSize(null);
        return getApi().getDianTaskList(dianParameterModel).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskData>> getDianTaskDetail(Context context, Integer num) {
        return getApi().getDianTaskDetail(num, getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskDataRecord>>> getDianTaskRecordList(Context context, List<Integer> list) {
        DianClientTaskRecordListInfo dianClientTaskRecordListInfo = (DianClientTaskRecordListInfo) JSON.parseObject(JSON.toJSONString(getDianParameterModel(context)), DianClientTaskRecordListInfo.class);
        dianClientTaskRecordListInfo.setRecordStatusList(list);
        return getApi().getDianTaskRecordList(dianClientTaskRecordListInfo).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> dianPostGateType(Context context, String str, Integer num) {
        return getApi().dianPostGateType(str, num, getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> dianApplyTask(Context context, Integer num) {
        return getApi().dianApplyTask(num, getDianCPLBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> dianCancelTask(Context context, Integer num, Integer num2) {
        return getApi().dianCancelTask(num, num2, getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<String>> dianSubmitTask(Context context, Integer num, List<File> list, List<ClientTaskDataSubmitFormModel> list2, String str, String str2) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        phoneInfo.setSdkType("2");
        builder.addFormDataPart("appId", phoneInfo.getAppId());
        String jSONString = JSON.toJSONString(phoneInfo);
        Log.d(TAG, "phoneInfoData==>" + jSONString);
        builder.addFormDataPart("data", AesUtil.encrypt(jSONString, phoneInfo.getAppId() + phoneInfo.getAppSecret()));
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.addFormDataPart("pics", Md5Utils.getMD5String(list.get(i).getName()) + list.get(i).getName().substring(list.get(i).getName().lastIndexOf(".")), RequestBody.create(MediaType.parse(SelectMimeType.SYSTEM_IMAGE), list.get(i)));
            }
        }
        if (list2 != null && list2.size() > 0) {
            builder.addFormDataPart("formList", JSON.toJSONString(list2));
        }
        if (!TextUtils.isEmpty(str)) {
            builder.addFormDataPart("answer", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.addFormDataPart("additionalData", str2);
        }
        builder.addFormDataPart("cutInType", String.valueOf(MokuConfigure.getInstance().getMokuOptions(context).getInteger("cutInType", 0)));
        return getApi().dianSubmitTask(num, builder.build()).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> dianCancelWithoutMonitor(Context context, Integer num, Integer num2) {
        return getApi().dianCancelWithoutMonitor(num, num2, getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<TaskDataApplyRecord>> dianGetTaskDataStatus(Context context) {
        return getApi().dianGetTaskDataStatus(getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<ClientTaskData>> dianCPLTaskDetail(Context context, Integer num) {
        return getApi().dianCPLTaskDetail(num, getDianCPLBasicParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientSampleTaskData>>> dianMyPartInList(Context context) {
        return getApi().dianMyPartInList(getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ClientTaskData>>> dianPopUpTaskList(Context context) {
        return getApi().dianPopUpList(getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<List<ItemConfig>>> dianGetItemConfig(Context context) {
        return getApi().dianGetItemConfig(getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> dianCpaLog(Context context, String str, Integer num) {
        return getApi().dianCpaLog(str, num, getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    public Observable<ApiResult<Object>> dianCplLog(Context context, Integer num) {
        return getApi().dianCplOpenGame(num, getDianParameterModel(context)).compose(RxBus.ApplySchedulers());
    }

    private DianParameterModel getDianParameterModel(Context context) {
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        String string = MokuConfigure.getInstance().getMokuOptions(context).getString(g.z, "");
        String string2 = MokuConfigure.getInstance().getMokuOptions(context).getString("oaid", "");
        if (!TextUtils.isEmpty(string)) {
            phoneInfo.setImei(string);
        } else {
            phoneInfo.setImei(string2);
        }
        phoneInfo.setSdkType("2");
        DianParameterModel dianParameterModel = new DianParameterModel();
        dianParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(context).getAppId());
        dianParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(MokuConfigure.getInstance().getPhoneInfo(context)), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret()));
        dianParameterModel.setMokuOptions(MokuConfigure.getInstance().getMokuOptions(context));
        String strDecrypt = AesUtil.decrypt(dianParameterModel.getData(), MokuConfigure.getInstance().getPhoneInfo(context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(context).getAppSecret());
        dianParameterModel.setImsi2(PhoneInfoUtils.getInstance().getImsi2(context));
        dianParameterModel.setImei1(PhoneInfoUtils.getInstance().getPhoneImeiNum(context));
        dianParameterModel.setMeid(PhoneInfoUtils.getInstance().getMeid(context));
        String str = TAG;
        LogUtils.log(str, "basicParameterModel.appId >> " + dianParameterModel.getAppId());
        LogUtils.log(str, "basicParameterModel.data >> " + strDecrypt);
        String string3 = MokuConfigure.getInstance().getMokuOptions(context).getString("additionalData", null);
        if (string3 != null) {
            dianParameterModel.setAdditionalData(string3);
        }
        dianParameterModel.setSdkType("2");
        return dianParameterModel;
    }

    private DianCPLBasicParameterModel getDianCPLBasicParameterModel(Context context) {
        String imei2;
        DianCPLBasicParameterModel dianCPLBasicParameterModel = new DianCPLBasicParameterModel();
        dianCPLBasicParameterModel.setFromAndroid(true);
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(context);
        phoneInfo.setSdkType("2");
        String strEncrypt = AesUtil.encrypt(JSON.toJSONString(phoneInfo), phoneInfo.getAppId() + phoneInfo.getAppSecret());
        phoneInfo.setImei1(PhoneInfoUtils.getInstance().getPhoneImeiNum(context));
        dianCPLBasicParameterModel.setAppId(phoneInfo.getAppId());
        if (Build.VERSION.SDK_INT >= 21 && PermissionUtils.isGranted(context, "android.permission.READ_PHONE_STATE") && (imei2 = PhoneInfoUtils.getInstance().getImei2(context)) != null && !StringUtils.isEmpty(imei2)) {
            dianCPLBasicParameterModel.setImei2(imei2);
        }
        dianCPLBasicParameterModel.setData(strEncrypt);
        String string = MokuConfigure.getInstance().getMokuOptions(context).getString("additionalData", null);
        if (string != null) {
            dianCPLBasicParameterModel.setAdditionalData(string);
        }
        return dianCPLBasicParameterModel;
    }
}
