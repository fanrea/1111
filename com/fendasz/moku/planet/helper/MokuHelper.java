package com.fendasz.moku.planet.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.container.adrequest.g;
import com.dhylive.app.utils.JumpParam;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.diandian.model.main.MokuDianMainActivity;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.entity.TaskDetail;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.ui.activity.AppealUnblockActivity;
import com.fendasz.moku.planet.ui.activity.EasyCollectionDetailActivity;
import com.fendasz.moku.planet.ui.activity.GameTaskDetailActivity;
import com.fendasz.moku.planet.ui.activity.MokuMainActivity;
import com.fendasz.moku.planet.ui.activity.RewardTaskDetailActivity;
import com.fendasz.moku.planet.ui.activity.TaskDetailActivity;
import com.fendasz.moku.planet.ui.dialog.TaskDialog;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.ThreadUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuHelper {
    private static String TAG = "MokuHelper";

    public static void requestPermissions(Activity activity) {
        LogUtils.log(TAG, "requestPermissions");
        PermissionUtils.requestMultiPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"}, new PermissionUtils.PermissionInterface() { // from class: com.fendasz.moku.planet.helper.MokuHelper.1
            @Override // com.fendasz.moku.planet.utils.PermissionUtils.PermissionInterface
            public void onPermissionGranted(int i) {
            }

            @Override // com.fendasz.moku.planet.utils.PermissionUtils.PermissionInterface
            public void onShouldShowRationale(String[] strArr) {
            }
        });
    }

    public static void startSdk(Context context, MokuOptions mokuOptions) throws MokuException {
        LogUtils.log(TAG, "startSdk");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_PHONE_STATE")) {
            throwException(context, "MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION);
            return;
        }
        verifyMokuOptions(context, mokuOptions);
        MokuConfigure.getInstance().setMokuOptions(context, mokuOptions);
        int integer = mokuOptions.getInteger("cutInType", 0);
        if (integer == -1) {
            startMokuMainActivity(context);
        } else if (integer == 0) {
            startMokuMainActivity(context);
        } else {
            if (integer != 3) {
                return;
            }
            startMokuDianActivity(context);
        }
    }

    public static void toMiniProgram(final Context context, final String str, final ClientSampleTaskData clientSampleTaskData) throws MokuException {
        LogUtils.log(TAG, "toMiniProgram");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().applyEasyTask(context, clientSampleTaskData.getTaskDataId(), clientSampleTaskData.getRecordId(), new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.2
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                WechatHelper.getInstance().toMiniProgram(str, clientSampleTaskData.getUrl(), context);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                LogUtils.log(MokuHelper.TAG, "toMiniProgram error >> " + i + " " + str2);
                Toast.makeText(context, str2 + i, 0).show();
            }
        });
    }

    public static void toMiniProgram(final Context context, final String str, Integer num, Integer num2, final String str2) throws MokuException {
        LogUtils.log(TAG, "toMiniProgram");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().applyEasyTask(context, num, num2, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.3
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                WechatHelper.getInstance().toMiniProgram(str, str2, context);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str3) throws Exception {
                LogUtils.log(MokuHelper.TAG, "toMiniProgram error >> " + i + " " + str3);
                Toast.makeText(context, str3 + i, 0).show();
            }
        });
    }

    public static void atformapiartapp(final Context context, Integer num, final String str) throws MokuException {
        LogUtils.logD(TAG, "atformapiartapp");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().applyEasyTask(context, num, -2, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.4
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                AlipayHelper.getInstance().atformapiartapp(context, str);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str2) throws Exception {
                LogUtils.log(MokuHelper.TAG, "toMiniProgram error >> " + i + " " + str2);
                Toast.makeText(context, "申请失败:" + str2, 0).show();
            }
        });
    }

    public static void atformapiartapp(final Context context, final ClientSampleTaskData clientSampleTaskData) throws MokuException {
        LogUtils.logD(TAG, "atformapiartapp");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().applyEasyTask(context, clientSampleTaskData.getTaskDataId(), -2, new ApiDataCallBack<TaskDataApplyRecord>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, TaskDataApplyRecord taskDataApplyRecord) throws Exception {
                AlipayHelper.getInstance().atformapiartapp(context, clientSampleTaskData.getUrl());
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.log(MokuHelper.TAG, "toMiniProgram error >> " + i + " " + str);
                Toast.makeText(context, "申请失败:" + str, 0).show();
            }
        });
    }

    public static void ptDialog2(final Context context, final ApiDataCallBack<ClientDetailTaskData> apiDataCallBack, final Consumer<TaskDialog> consumer) throws MokuException {
        LogUtils.log(TAG, "getMokuTaskDialog");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().ptList2(context, new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientDetailTaskData clientDetailTaskData) throws Exception {
                TaskDialog taskDialogBuild = new TaskDialog.Builder(context).setCancelable(false).setTaskDetailData(clientDetailTaskData).build();
                apiDataCallBack.success(i, clientDetailTaskData);
                consumer.accept(taskDialogBuild);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public static void ptDialog3(Context context, final ApiDataCallBack<List<ClientDetailTaskData>> apiDataCallBack) throws MokuException {
        LogUtils.log(TAG, "getMokuTaskDialog");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().ptList3(context, new ApiDataCallBack<List<ClientDetailTaskData>>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.7
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientDetailTaskData> list) throws Exception {
                apiDataCallBack.success(i, list);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                apiDataCallBack.error(i, str);
            }
        });
    }

    public static void getMokuTaskDialog(final Context context, final Consumer<TaskDialog> consumer) throws MokuException {
        LogUtils.log(TAG, "getMokuTaskDialog");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().popupTaskList(context, false, new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientDetailTaskData clientDetailTaskData) throws Exception {
                if (clientDetailTaskData != null) {
                    consumer.accept(new TaskDialog.Builder(context).setCancelable(false).setTaskDetailData(clientDetailTaskData).build());
                } else if (MokuConfigure.getInstance().getMokuOptions(context).getInteger("cutInType", 0) == 1) {
                    MokuHelper.startMokuMainActivity(context);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.log(MokuHelper.TAG, "getMokuTaskDialog error >> " + i + " " + str);
                if (i == 6001 || i == 6002) {
                    if (MokuConfigure.getInstance().getMokuOptions(context).getInteger("cutInType", 0) == 1) {
                        MokuHelper.startMokuMainActivity(context);
                        return;
                    }
                    return;
                }
                Toast.makeText(context, str + i, 0).show();
            }
        });
    }

    public static void dianGetMokuTaskDialog(final Context context, final Consumer<TaskDialog> consumer) throws MokuException {
        LogUtils.log(TAG, "getMokuTaskDialog");
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        ApiDataHelper.getApiDataHelper().dianPopupTaskList(context, new ApiDataCallBack<ClientDetailTaskData>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.9
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, ClientDetailTaskData clientDetailTaskData) throws Exception {
                if (clientDetailTaskData != null) {
                    LogUtils.logD(MokuHelper.TAG, "getMokuTaskDialog success");
                    consumer.accept(new TaskDialog.Builder(context).setCancelable(false).setTaskDetailData(clientDetailTaskData).build());
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.log(MokuHelper.TAG, "getMokuTaskDialog error >> " + i + " " + str);
                if (i == 6001 || i == 6002) {
                    return;
                }
                Toast.makeText(context, str + i, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startMokuMainActivity(Context context) throws MokuException {
        LogUtils.log(TAG, "startMokuMainActivity");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_PHONE_STATE")) {
            throwException(context, "MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION);
        }
        Intent intent = new Intent(context, (Class<?>) MokuMainActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private static void startMokuDianActivity(Context context) throws MokuException {
        LogUtils.log(TAG, "startMokuDianActivity");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_PHONE_STATE")) {
            throwException(context, "MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(context, (Class<?>) MokuDianMainActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
        LogUtils.logD(TAG, "startMokuDianActivity_used time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Deprecated
    public static void startMokuDetailActivity(Context context, int i, int i2) throws MokuException {
        Intent intent;
        LogUtils.log(TAG, "startMokuDetailActivity");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        if (i == 0) {
            intent = new Intent(context, (Class<?>) TaskDetailActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) RewardTaskDetailActivity.class);
        }
        intent.addFlags(268435456);
        intent.putExtra("taskDataId", i2);
        context.startActivity(intent);
    }

    @Deprecated
    public static void startMokuCPLDetailActivity(Context context, int i, String str) throws MokuException {
        LogUtils.log(TAG, "startMokuDetailActivity");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        Intent intent = new Intent(context, (Class<?>) GameTaskDetailActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("taskDataId", i);
        if (str != null && !StringUtils.isEmpty(str)) {
            intent.putExtra("additionalData", str);
        }
        context.startActivity(intent);
    }

    @Deprecated
    public static void startMokuCPLDetailActivity(Context context, int i, String str, String str2) throws MokuException {
        LogUtils.log(TAG, "startMokuDetailActivity");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        Intent intent = new Intent(context, (Class<?>) GameTaskDetailActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("taskDataId", i);
        if (str != null && !StringUtils.isEmpty(str)) {
            intent.putExtra("additionalData", str);
        }
        if (str2 != null && !StringUtils.isEmpty(str2)) {
            intent.putExtra("diamondAppData", str2);
        }
        context.startActivity(intent);
    }

    @Deprecated
    public static void startMokuDetailActivity(Context context, int i, int i2, String str) throws MokuException {
        Intent intent;
        if (str == null || StringUtils.isEmpty(str)) {
            if (context == null) {
                throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
                return;
            } else {
                startMokuDetailActivity(context, i, i2);
                return;
            }
        }
        LogUtils.log(TAG, "startMokuDetailActivity");
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        if (i == 0) {
            intent = new Intent(context, (Class<?>) TaskDetailActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) RewardTaskDetailActivity.class);
        }
        intent.addFlags(268435456);
        intent.putExtra("taskDataId", i2);
        intent.putExtra("additionalData", str);
        context.startActivity(intent);
    }

    public static void startMokuDetailActivity(final Context context, TaskDetail taskDetail) throws MokuException {
        Intent intent;
        if (context == null) {
            throwException(context, "content not allow null", MokuConstants.MOKU_CONTEXT_EXCEPTION);
            return;
        }
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        Integer taskDataId = taskDetail.getTaskDataId();
        if (taskDataId == null) {
            throwException(context, "MOKU_TASK_DATA_ID_EXCEPTION", MokuConstants.MOKU_TASK_ID_EXCEPTION);
            return;
        }
        Integer surplusNum = taskDetail.getSurplusNum();
        if (surplusNum == null) {
            surplusNum = 0;
        }
        if (surplusNum.intValue() > 0 || taskDetail.getApplyRecordStatus() == null || taskDetail.getApplyRecordStatus().equals(MokuConstants.STATUS_OF_APPLYING) || taskDetail.getApplyRecordStatus().equals(MokuConstants.STATUS_OF_OVERTIME)) {
            if (taskDetail.getEasy().booleanValue()) {
                Integer easyTaskType = taskDetail.getEasyTaskType();
                if (easyTaskType != null && 3 == easyTaskType.intValue()) {
                    final TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener = taskDetail.getOnEasyTaskClickListener();
                    if (onEasyTaskClickListener != null) {
                        onEasyTaskClickListener.onLoading();
                    }
                    ApiDataHelper.getApiDataHelper().beginEasyCollection(taskDetail.getCollectionDataId(), context, new ApiDataCallBack<EasyCollectionEntity>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.10
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i, EasyCollectionEntity easyCollectionEntity) throws Exception {
                            TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener2 = onEasyTaskClickListener;
                            if (onEasyTaskClickListener2 != null) {
                                onEasyTaskClickListener2.onDismissLoading();
                            }
                            Intent intent2 = new Intent(context, (Class<?>) EasyCollectionDetailActivity.class);
                            intent2.putExtra("taskInfo", JSON.toJSONString(easyCollectionEntity));
                            context.startActivity(intent2);
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i, String str) throws Exception {
                            Toast.makeText(context, str + i, 1).show();
                            TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener2 = onEasyTaskClickListener;
                            if (onEasyTaskClickListener2 != null) {
                                onEasyTaskClickListener2.onDismissLoading();
                            }
                        }
                    });
                    return;
                }
                LogUtils.logE(TAG, "easyTaskType is error,easyTaskType=>" + easyTaskType);
                return;
            }
            if (taskDetail.getCpl() != null && taskDetail.getCpl().booleanValue()) {
                intent = new Intent(context, (Class<?>) GameTaskDetailActivity.class);
            } else if (taskDetail.getTaskType() != null && taskDetail.getTaskType().intValue() == 1) {
                intent = new Intent(context, (Class<?>) RewardTaskDetailActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TaskDetailActivity.class);
            }
            intent.putExtra("taskDataId", taskDataId);
            String gateType = taskDetail.getGateType();
            if (!TextUtils.isEmpty(gateType)) {
                intent.putExtra("gateType", gateType);
            }
            if (!StringUtils.isEmpty(taskDetail.getAdditionalData())) {
                intent.putExtra("additionalData", taskDetail.getAdditionalData());
            }
            intent.putExtra("operationType", 100);
            context.startActivity(intent);
        }
    }

    public static void openDianDetail(final Context context, TaskDetail taskDetail) throws MokuException {
        Intent intent;
        if (context == null) {
            throwException(context, "content not allow null", MokuConstants.MOKU_CONTEXT_EXCEPTION);
            return;
        }
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        Integer taskDataId = taskDetail.getTaskDataId();
        if (taskDataId == null) {
            throwException(context, "MOKU_TASK_DATA_ID_EXCEPTION", MokuConstants.MOKU_TASK_ID_EXCEPTION);
            return;
        }
        Integer surplusNum = taskDetail.getSurplusNum();
        if (surplusNum == null) {
            surplusNum = 0;
        }
        if (surplusNum.intValue() > 0 || taskDetail.getApplyRecordStatus() == null || taskDetail.getApplyRecordStatus().equals(MokuConstants.STATUS_OF_APPLYING) || taskDetail.getApplyRecordStatus().equals(MokuConstants.STATUS_OF_OVERTIME)) {
            if (taskDetail.getEasy().booleanValue()) {
                Integer easyTaskType = taskDetail.getEasyTaskType();
                if (easyTaskType != null && 3 == easyTaskType.intValue()) {
                    final TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener = taskDetail.getOnEasyTaskClickListener();
                    if (onEasyTaskClickListener != null) {
                        onEasyTaskClickListener.onLoading();
                    }
                    ApiDataHelper.getApiDataHelper().beginEasyCollection(taskDetail.getCollectionDataId(), context, new ApiDataCallBack<EasyCollectionEntity>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.11
                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void success(int i, EasyCollectionEntity easyCollectionEntity) throws Exception {
                            TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener2 = onEasyTaskClickListener;
                            if (onEasyTaskClickListener2 != null) {
                                onEasyTaskClickListener2.onDismissLoading();
                            }
                            Intent intent2 = new Intent(context, (Class<?>) EasyCollectionDetailActivity.class);
                            intent2.putExtra("taskInfo", JSON.toJSONString(easyCollectionEntity));
                            context.startActivity(intent2);
                        }

                        @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                        public void error(int i, String str) throws Exception {
                            Toast.makeText(context, str + i, 1).show();
                            TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener2 = onEasyTaskClickListener;
                            if (onEasyTaskClickListener2 != null) {
                                onEasyTaskClickListener2.onDismissLoading();
                            }
                        }
                    });
                    return;
                }
                LogUtils.logE(TAG, "easyTaskType is error,easyTaskType=>" + easyTaskType);
                return;
            }
            if (taskDetail.getCpl() != null && taskDetail.getCpl().booleanValue()) {
                intent = new Intent(context, (Class<?>) GameTaskDetailActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) DianCpaDetailActivity.class);
            }
            intent.putExtra("taskDataId", taskDataId);
            String gateType = taskDetail.getGateType();
            if (!TextUtils.isEmpty(gateType)) {
                intent.putExtra("gateType", gateType);
            }
            if (!StringUtils.isEmpty(taskDetail.getAdditionalData())) {
                intent.putExtra("additionalData", taskDetail.getAdditionalData());
            }
            intent.putExtra("operationType", 100);
            context.startActivity(intent);
        }
    }

    public static void openEasyTaskDetail(final Context context, Integer num, final TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener) throws MokuException {
        if (context == null) {
            throwException(context, "content not allow null", MokuConstants.MOKU_CONTEXT_EXCEPTION);
            return;
        }
        if (num == null) {
            throwException(context, "taskDataId or url is not aloow null", MokuConstants.MOKU_CONTEXT_EXCEPTION);
            return;
        }
        if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
            return;
        }
        verifyMokuOptions(context, MokuConfigure.getInstance().getMokuOptions(context));
        if (onEasyTaskClickListener != null) {
            onEasyTaskClickListener.onLoading();
        }
        ApiDataHelper.getApiDataHelper().beginEasyCollection(num, context, new ApiDataCallBack<EasyCollectionEntity>() { // from class: com.fendasz.moku.planet.helper.MokuHelper.12
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, EasyCollectionEntity easyCollectionEntity) throws Exception {
                TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener2 = onEasyTaskClickListener;
                if (onEasyTaskClickListener2 != null) {
                    onEasyTaskClickListener2.onDismissLoading();
                }
                Intent intent = new Intent(context, (Class<?>) EasyCollectionDetailActivity.class);
                intent.putExtra("taskInfo", JSON.toJSONString(easyCollectionEntity));
                context.startActivity(intent);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                Toast.makeText(context, str + i, 1).show();
                TaskDetail.OnEasyTaskClickListener onEasyTaskClickListener2 = onEasyTaskClickListener;
                if (onEasyTaskClickListener2 != null) {
                    onEasyTaskClickListener2.onDismissLoading();
                }
            }
        });
    }

    public static void openAppeal(Context context) throws MokuException {
        if (context == null) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
        } else if (!PermissionUtils.isGranted(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            throwException(context, "MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION", MokuConstants.MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION);
        } else {
            context.startActivity(new Intent(context, (Class<?>) AppealUnblockActivity.class));
        }
    }

    static void verifyMokuOptions(Context context, MokuOptions mokuOptions) throws MokuException {
        if (context == null) {
            throwException(null, "MOKU_CONTEXT_EXCEPTION", MokuConstants.MOKU_CONTEXT_EXCEPTION);
            return;
        }
        if (mokuOptions == null) {
            throwException(null, "MOKU_OPTION_EXCEPTION", MokuConstants.MOKU_OPTION_EXCEPTION);
            return;
        }
        if (TextUtils.isEmpty(mokuOptions.getString(JumpParam.USER_ID, ""))) {
            throwException(context, "MOKU_USERID_EXCEPTION", MokuConstants.MOKU_USERID_EXCEPTION);
        }
        String string = mokuOptions.getString("appId", "");
        String string2 = mokuOptions.getString("appSecret", "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            throwException(context, "MOKU_APP_EXCEPTION", MokuConstants.MOKU_APP_EXCEPTION);
        }
        String string3 = mokuOptions.getString("oaid", "");
        String string4 = mokuOptions.getString(g.z, "");
        if (TextUtils.isEmpty(string3) && TextUtils.isEmpty(string4)) {
            throwException(context, "MOKU_IMEI_EXCEPTION", MokuConstants.MOKU_IMEI_EXCEPTION);
        }
    }

    private static void throwException(final Context context, final String str, final String str2) throws MokuException {
        LogUtils.log(TAG, str + ":" + str2);
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.helper.MokuHelper.13
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 != null) {
                    Toast.makeText(context2, str + ":" + str2, 1).show();
                }
            }
        });
        throw new MokuException(str + ":" + str2);
    }
}
