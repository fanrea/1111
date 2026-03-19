package com.fendasz.moku.planet.common;

import android.webkit.JavascriptInterface;
import com.alipay.sdk.m.x.d;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.ThreadUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuJsObject {
    private static final String TAG = "MokuJsObject";
    private OnMokuJsListener onMokuJsListener;

    public interface OnMokuJsListener {
        String allExistPackageList();

        String appCplUrl();

        String appListExist(String str);

        String appTheme();

        void appealUnblockBack(boolean z);

        void arbitrament(int i, String str);

        void arbitrationSuccess(String str);

        String basicParameterModel();

        void choiceVideo();

        void clickImage(String str, boolean z);

        void clickImageLong(String str, boolean z);

        void closePage();

        void copyText(String str);

        void customerService();

        void deleteArbitrationImage(int i);

        void easyCollectionDetial(String str);

        String getDeviceInfo();

        Boolean isAppExist(String str);

        boolean isDian();

        void openAlbum(int i);

        void openAlipayMiniProgram(String str);

        void openApp(String str);

        void openBrowser(String str);

        void openUrl(String str);

        void openWechatMiniProgram(String str);

        void refrehToken();

        void refreshData();

        void requestFastApp(String str);

        String sdkInfo();

        void setBottomVisibility(Boolean bool);

        void setTitleText(String str);

        void showScreenImage(String str);

        void submitArbitration(String str);

        void submitReset(int i, String str, int i2);

        void submitTask(String str);

        Integer taskApplyRecordState();

        Integer taskSubmitRecordId();

        String token();

        void uninstallApp(String str);

        void uploadDeviceInfo(String str);
    }

    public OnMokuJsListener getOnMokuJsListener() {
        return this.onMokuJsListener;
    }

    public void setOnMokuJsListener(OnMokuJsListener onMokuJsListener) {
        this.onMokuJsListener = onMokuJsListener;
    }

    @JavascriptInterface
    public String appTheme() {
        LogUtils.logD(TAG, "appTheme==>");
        return this.onMokuJsListener.appTheme();
    }

    @JavascriptInterface
    @Deprecated
    public String appToken() {
        LogUtils.logD(TAG, "appToken");
        return this.onMokuJsListener.token();
    }

    @JavascriptInterface
    public void refreshToken() {
        LogUtils.logD(TAG, "refreshToken");
        this.onMokuJsListener.refrehToken();
    }

    @JavascriptInterface
    public String appCplUrl() {
        return this.onMokuJsListener.appCplUrl();
    }

    @JavascriptInterface
    public String sdkInfo() {
        LogUtils.logD(TAG, d.D);
        return this.onMokuJsListener.sdkInfo();
    }

    @JavascriptInterface
    public String basicParameterModel() {
        return this.onMokuJsListener.basicParameterModel();
    }

    @JavascriptInterface
    public void refreshData() {
        LogUtils.logD(TAG, "refreshData");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObject.1
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObject.this.onMokuJsListener.refreshData();
            }
        });
    }

    @JavascriptInterface
    public void openBrowser(String str) {
        this.onMokuJsListener.openBrowser(str);
    }

    @JavascriptInterface
    public void copyText(String str) {
        LogUtils.logD(TAG, "copyText_TEXT=>" + str);
        this.onMokuJsListener.copyText(str);
    }

    @JavascriptInterface
    public void showScreenImage(String str) {
        LogUtils.logD(TAG, "showScreenImage_URL=>" + str);
        this.onMokuJsListener.showScreenImage(str);
    }

    @JavascriptInterface
    public void openApp(String str) {
        LogUtils.logD(TAG, "openApp_packageName=>");
        this.onMokuJsListener.openApp(str);
    }

    @JavascriptInterface
    public void openUrl(String str) {
        LogUtils.logD(TAG, "openUrl==>" + str);
        this.onMokuJsListener.openUrl(str);
    }

    @JavascriptInterface
    public void onImageClick(String str, boolean z) {
        LogUtils.logD(TAG, "onImageClick_url=>" + str + ",isMiniProgrammer=>" + z);
        this.onMokuJsListener.clickImage(str, z);
    }

    @JavascriptInterface
    public void onImageLongClick(String str, boolean z) {
        LogUtils.logD(TAG, "onImageLongClick_url=>" + str + ",isMiniProgrammer=>" + z);
        this.onMokuJsListener.clickImageLong(str, z);
    }

    @JavascriptInterface
    public void openAlbum(int i) {
        LogUtils.logD(TAG, "openAlbum");
        this.onMokuJsListener.openAlbum(i);
    }

    @JavascriptInterface
    public void submitTask(String str) {
        LogUtils.logD(TAG, "submitTask==>" + str);
        this.onMokuJsListener.submitTask(str);
    }

    @JavascriptInterface
    public void customerService() {
        LogUtils.logD(TAG, "customerService");
        this.onMokuJsListener.customerService();
    }

    @JavascriptInterface
    public void submitReset(int i, String str, int i2) {
        LogUtils.logD(TAG, "submitReset,taskDataId==>" + i + "，gateType==>" + str + ",taskType==>" + i2);
        this.onMokuJsListener.submitReset(i, str, i2);
    }

    @JavascriptInterface
    public int taskApplyRecordState() {
        Integer numTaskApplyRecordState = this.onMokuJsListener.taskApplyRecordState();
        LogUtils.logD(TAG, "taskApplyRecordState==>" + numTaskApplyRecordState);
        return numTaskApplyRecordState.intValue();
    }

    @JavascriptInterface
    public int taskSubmitRecordId() {
        int iIntValue = this.onMokuJsListener.taskSubmitRecordId().intValue();
        LogUtils.logD(TAG, "taskSubmitRecordId==>" + iIntValue);
        return iIntValue;
    }

    @JavascriptInterface
    public void arbitrationSuccess(String str) {
        LogUtils.logD(TAG, "arbitrationSuccess_message==>" + str);
        this.onMokuJsListener.arbitrationSuccess(str);
    }

    @JavascriptInterface
    public void submitArbitrationTask(String str) {
        LogUtils.logD(TAG, "submitArbitrationTask_data=>" + str);
        this.onMokuJsListener.submitArbitration(str);
    }

    @JavascriptInterface
    public void deleteArbitrationImage(int i) {
        LogUtils.logD(TAG, "deleteArbitrationImage_index=>" + i);
        this.onMokuJsListener.deleteArbitrationImage(i);
    }

    @JavascriptInterface
    public void arbitrament(int i, String str) {
        LogUtils.logD(TAG, "arbitrament_submitRecordId=>" + i + ",arbitramentReason=>" + str);
        this.onMokuJsListener.arbitrament(i, str);
    }

    @JavascriptInterface
    public void setTitle(String str) {
        LogUtils.logD(TAG, "setTitle=>" + str);
        this.onMokuJsListener.setTitleText(str);
    }

    @JavascriptInterface
    public void openWechatMiniProgram(String str) {
        LogUtils.logD(TAG, "openWechatMiniProgram_URL=>" + str);
        this.onMokuJsListener.openWechatMiniProgram(str);
    }

    @JavascriptInterface
    public void openAlipayMiniProgram(String str) {
        LogUtils.logD(TAG, "openAlipayMiniProgram_URL=>" + str);
        this.onMokuJsListener.openAlipayMiniProgram(str);
    }

    @JavascriptInterface
    public void requestFastApp(String str) {
        LogUtils.logD(TAG, "openFastApp_URL=>" + str);
        this.onMokuJsListener.requestFastApp(str);
    }

    @JavascriptInterface
    public void setBottomVisibility(boolean z) {
        LogUtils.logD(TAG, "setBottomVisibility=>" + z);
        this.onMokuJsListener.setBottomVisibility(Boolean.valueOf(z));
    }

    @JavascriptInterface
    public void closePage() {
        LogUtils.logD(TAG, "closePage==>");
        this.onMokuJsListener.closePage();
    }

    @JavascriptInterface
    public Boolean isAppExist(String str) {
        LogUtils.logD(TAG, "isAppExist=>" + str);
        return this.onMokuJsListener.isAppExist(str);
    }

    @JavascriptInterface
    public String appListExist(String str) {
        LogUtils.logD(TAG, "appListExist==>" + str);
        return this.onMokuJsListener.appListExist(str);
    }

    @JavascriptInterface
    public String allExistPackageList() {
        String strAllExistPackageList = this.onMokuJsListener.allExistPackageList();
        LogUtils.logD(TAG, "allExistPackageList==>" + strAllExistPackageList);
        return strAllExistPackageList;
    }

    @JavascriptInterface
    public void uninstallApp(String str) {
        LogUtils.logD(TAG, "uninstallApp==>" + str);
        this.onMokuJsListener.uninstallApp(str);
    }

    @JavascriptInterface
    public void choiceVideo() {
        LogUtils.logD(TAG, "choiceVideo=>");
        this.onMokuJsListener.choiceVideo();
    }

    @JavascriptInterface
    public void appealUnblockBack(boolean z) {
        LogUtils.logD(TAG, "appealUnblockBack=>" + z);
        this.onMokuJsListener.appealUnblockBack(z);
    }

    @JavascriptInterface
    public void easyCollectionDetial(String str) {
        LogUtils.logD(TAG, "easyCollectionDetial=>" + str);
        this.onMokuJsListener.easyCollectionDetial(str);
    }

    @JavascriptInterface
    public void uploadDeviceInfo(String str) {
        LogUtils.logD(TAG, "uploadDeviceInfo=>" + str);
        this.onMokuJsListener.uploadDeviceInfo(str);
    }

    @JavascriptInterface
    public String getDeviceInfo() {
        String deviceInfo = this.onMokuJsListener.getDeviceInfo();
        LogUtils.logD(TAG, "device info=>" + deviceInfo);
        return deviceInfo;
    }
}
