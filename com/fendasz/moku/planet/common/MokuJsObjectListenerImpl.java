package com.fendasz.moku.planet.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.BuildConfig;
import com.fendasz.moku.planet.common.MokuJsObject;
import com.fendasz.moku.planet.common.network.CompanyNetworkManager;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.entity.TokenInfo;
import com.fendasz.moku.planet.helper.AlipayHelper;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.helper.WechatHelper;
import com.fendasz.moku.planet.source.requestmodel.DianCPLBasicParameterModel;
import com.fendasz.moku.planet.utils.AesUtil;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.PhoneInfoUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import com.fendasz.moku.planet.utils.system.entity.PackageInfoEntity;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.google.gson.Gson;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class MokuJsObjectListenerImpl implements MokuJsObject.OnMokuJsListener {
    private static final String TAG = "MokuJsObjectListenerImpl";
    private Context context;
    private WebView webView;

    private void openFastApp(String str) {
    }

    protected void bottomVisibility(boolean z) {
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public boolean isDian() {
        return false;
    }

    protected void onImageClick(String str, boolean z) {
    }

    protected void onImageLongClick(String str, boolean z) {
    }

    protected void openEasyCollectionDetail(String str) {
    }

    protected void openPhoneAlbum(int i) {
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void openUrl(String str) {
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void refreshData() {
    }

    protected void resubmit(int i, String str, int i2) {
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String sdkInfo() {
        return BuildConfig.VERSION_NAME;
    }

    protected void selectVideo() {
    }

    protected void showArbitrationMessage(String str) {
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void showScreenImage(String str) {
    }

    protected void submitTaskData(String str) {
    }

    protected String taskDataId() {
        return null;
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public Integer taskSubmitRecordId() {
        return null;
    }

    protected void toCustomerService() {
    }

    protected void unblockResult(boolean z) {
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void uploadDeviceInfo(String str) {
    }

    public MokuJsObjectListenerImpl() {
    }

    public MokuJsObjectListenerImpl(WebView webView) {
        this.webView = webView;
    }

    public MokuJsObjectListenerImpl(Context context) {
        this.context = context;
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String appTheme() {
        LogUtils.logD(TAG, "appTheme==>");
        return JSON.toJSONString(MokuConfigure.getInstance().getMokuOptions(this.context));
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String appCplUrl() {
        String baseDomain = CompanyNetworkManager.getBaseDomain(this.context);
        LogUtils.logD(TAG, baseDomain);
        return baseDomain;
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String token() {
        String str = TAG;
        LogUtils.logD(str, "appToken");
        TokenInfo tokenInfo = new TokenInfo();
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(this.context);
        boolean zIsDian = isDian();
        LogUtils.logD(str, "token_isDian:" + zIsDian);
        if (zIsDian) {
            phoneInfo.setSdkType("2");
        } else {
            phoneInfo.setSdkType("1");
        }
        tokenInfo.setAppId(phoneInfo.getAppId());
        tokenInfo.setDeviceId(phoneInfo.getDeviceId());
        tokenInfo.setSdkAppUserId(phoneInfo.getSdkAppUserId());
        tokenInfo.setTime(phoneInfo.getNetTime().longValue());
        String strEncrypt = AesUtil.encrypt(JSON.toJSONString(tokenInfo), MokuConfigure.getInstance().getPhoneInfo(this.context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(this.context).getAppSecret());
        LogUtils.log(str, "token >> " + strEncrypt);
        return strEncrypt;
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void refrehToken() {
        LogUtils.logD(TAG, "refresh token");
        ApiDataHelper.getApiDataHelper().getNetTime(this.context, new ApiDataCallBack<Long>() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.1
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Long l) throws Exception {
                TokenInfo tokenInfo = new TokenInfo();
                PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(MokuJsObjectListenerImpl.this.context);
                boolean zIsDian = MokuJsObjectListenerImpl.this.isDian();
                LogUtils.logD(MokuJsObjectListenerImpl.TAG, "token_isDian:" + zIsDian);
                if (zIsDian) {
                    phoneInfo.setSdkType("2");
                } else {
                    phoneInfo.setSdkType("1");
                }
                tokenInfo.setAppId(phoneInfo.getAppId());
                tokenInfo.setDeviceId(phoneInfo.getDeviceId());
                tokenInfo.setSdkAppUserId(phoneInfo.getSdkAppUserId());
                tokenInfo.setTime(phoneInfo.getNetTime().longValue());
                String strEncrypt = AesUtil.encrypt(JSON.toJSONString(tokenInfo), MokuConfigure.getInstance().getPhoneInfo(MokuJsObjectListenerImpl.this.context).getAppId() + MokuConfigure.getInstance().getPhoneInfo(MokuJsObjectListenerImpl.this.context).getAppSecret());
                LogUtils.log(MokuJsObjectListenerImpl.TAG, "token >> " + strEncrypt);
                MokuJsObjectListenerImpl.this.notifyH5Token(i, strEncrypt);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                MokuJsObjectListenerImpl.this.notifyH5Token(i, null);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String basicParameterModel() {
        String imei2;
        DianCPLBasicParameterModel dianCPLBasicParameterModel = new DianCPLBasicParameterModel();
        dianCPLBasicParameterModel.setFromAndroid(false);
        PhoneInfo phoneInfo = MokuConfigure.getInstance().getPhoneInfo(this.context);
        boolean zIsDian = isDian();
        String str = TAG;
        LogUtils.logD(str, "token_isDian:" + zIsDian);
        if (zIsDian) {
            phoneInfo.setSdkType("2");
        } else {
            phoneInfo.setSdkType("1");
        }
        if (Build.VERSION.SDK_INT >= 21 && PermissionUtils.isGranted(this.context, "android.permission.READ_PHONE_STATE") && (imei2 = PhoneInfoUtils.getInstance().getImei2(this.context)) != null && !StringUtils.isEmpty(imei2)) {
            dianCPLBasicParameterModel.setImei2(imei2);
        }
        dianCPLBasicParameterModel.setAppId(MokuConfigure.getInstance().getPhoneInfo(this.context).getAppId());
        dianCPLBasicParameterModel.setData(AesUtil.encrypt(JSON.toJSONString(phoneInfo), phoneInfo.getAppId() + phoneInfo.getAppSecret()));
        dianCPLBasicParameterModel.setMokuOptions(MokuConfigure.getInstance().getMokuOptions(this.context));
        String data = dianCPLBasicParameterModel.getData();
        LogUtils.log(str, "basicParameterModel.modelData >> " + data);
        String strDecrypt = AesUtil.decrypt(data, phoneInfo.getAppId() + phoneInfo.getAppSecret());
        LogUtils.log(str, "basicParameterModel.appId >> " + dianCPLBasicParameterModel.getAppId());
        LogUtils.log(str, "basicParameterModel.data >> " + strDecrypt);
        String string = MokuConfigure.getInstance().getMokuOptions(this.context).getString("additionalData", null);
        if (string != null) {
            dianCPLBasicParameterModel.setAdditionalData(string);
        }
        HashMap map = new HashMap();
        map.put("taskDataId", taskDataId());
        map.put("basicParameter", dianCPLBasicParameterModel);
        return new Gson().toJson(map);
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void openBrowser(String str) {
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void copyText(String str) {
        SystemUtils.copyToClipboard(this.context, str, str);
        Toast.makeText(this.context, "复制成功", 0).show();
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void openApp(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        final String str2 = null;
        Iterator it = JSON.parseArray(str, String.class).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            if (SystemUtils.isAppExist(this.context, str3)) {
                str2 = str3;
                break;
            }
        }
        if (str2 != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    SystemUtils.openPackage(MokuJsObjectListenerImpl.this.context, str2);
                }
            });
        }
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void clickImage(final String str, final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.onImageClick(str, z);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void clickImageLong(final String str, final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.onImageLongClick(str, z);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void openAlbum(final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.openPhoneAlbum(i);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void submitTask(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.submitTaskData(str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void customerService() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.toCustomerService();
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void submitReset(final int i, final String str, final int i2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.resubmit(i, str, i2);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void arbitrationSuccess(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.9
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(MokuJsObjectListenerImpl.this.context, str, 0).show();
                MokuJsObjectListenerImpl.this.showArbitrationMessage(str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void submitArbitration(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.10
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.submitArbitrationTask(str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void arbitrament(final int i, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.11
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.submitArbitrament(i, str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void setTitleText(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.12
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.setTitle(str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void setBottomVisibility(final Boolean bool) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.13
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.bottomVisibility(bool.booleanValue());
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void closePage() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.14
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.logD(MokuJsObjectListenerImpl.TAG, "closePage==>");
                MokuJsObjectListenerImpl.this.webviewFinish();
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void choiceVideo() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.15
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.logD(MokuJsObjectListenerImpl.TAG, "selectVideo==>");
                MokuJsObjectListenerImpl.this.selectVideo();
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void appealUnblockBack(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.16
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.logD(MokuJsObjectListenerImpl.TAG, "appealUnblockBack==>" + z);
                MokuJsObjectListenerImpl.this.unblockResult(z);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void deleteArbitrationImage(int i) {
        LogUtils.logD(TAG, "deleteArbitrationImage_index=>" + i);
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void openAlipayMiniProgram(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.17
            @Override // java.lang.Runnable
            public void run() {
                AlipayHelper.getInstance().atformapiartapp(MokuJsObjectListenerImpl.this.context, str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void openWechatMiniProgram(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.18
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
                WechatHelper.getInstance().toMiniProgram(MokuConfigure.getInstance().getMokuOptions(MokuJsObjectListenerImpl.this.context).getString("wxAppId", ""), str, MokuJsObjectListenerImpl.this.context);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void requestFastApp(final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.19
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                MokuJsObjectListenerImpl.this.context.startActivity(intent);
            }
        });
    }

    public void finish() {
        this.context = null;
        if (this.webView != null) {
            LogUtils.logD(TAG, "ready to finish,remove webview views and destroy it,make it null");
            this.webView.removeAllViews();
            this.webView.destroy();
            this.webView = null;
        }
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public Integer taskApplyRecordState() {
        return -5;
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public Boolean isAppExist(String str) {
        return appIsExist(str);
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String appListExist(String str) {
        return existPackageList(str);
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String allExistPackageList() {
        return allInstalledPackageInfo();
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void uninstallApp(String str) {
        uninstallPackage(str);
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public void easyCollectionDetial(final String str) {
        LogUtils.logD(TAG, "easyCollectionDetial=>" + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl.20
            @Override // java.lang.Runnable
            public void run() {
                MokuJsObjectListenerImpl.this.openEasyCollectionDetail(str);
            }
        });
    }

    @Override // com.fendasz.moku.planet.common.MokuJsObject.OnMokuJsListener
    public String getDeviceInfo() throws NoSuchMethodException, SecurityException {
        MokuConfigure.getInstance().refreshSectionUserDeviceInfo(this.context);
        return JSON.toJSONString(MokuConfigure.getInstance().getUserDeviceInfo(this.context));
    }

    protected void submitArbitrationTask(String str) {
        LogUtils.logD(TAG, "submitArbitrationTask_data=>" + str);
    }

    protected void submitArbitrament(int i, String str) {
        LogUtils.logD(TAG, "submitArbitrament=>" + str);
    }

    protected void setTitle(String str) {
        LogUtils.logD(TAG, "setTitle=>" + str);
    }

    protected void notifyH5Token(int i, String str) {
        LogUtils.logD(TAG, "notifyH5Token_code=>" + i + ",token=>" + str);
        if (this.webView != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.webView.evaluateJavascript("javascript:androidToken(" + i + ",'" + str + "')", new ValueCallback() { // from class: com.fendasz.moku.planet.common.MokuJsObjectListenerImpl$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        LogUtils.logD(MokuJsObjectListenerImpl.TAG, (String) obj);
                    }
                });
            } else {
                this.webView.loadUrl("javascript:androidToken(" + i + ",'" + str + "')");
            }
        }
    }

    protected void webviewFinish() {
        LogUtils.logD(TAG, "webviewFinish");
    }

    protected Boolean appIsExist(String str) {
        return Boolean.valueOf(SystemUtils.isAppExist(this.context, str));
    }

    protected String existPackageList(String str) {
        ArrayList<String> arrayList;
        List<PackageInfoEntity> allInstalledPackageInfo;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(jSONArray.optString(i));
                } catch (JSONException unused) {
                    Log.e(TAG, "package list to json array is error");
                    if (arrayList != null) {
                    }
                    return null;
                }
            }
        } catch (JSONException unused2) {
            arrayList = null;
        }
        if (arrayList != null || arrayList.isEmpty() || (allInstalledPackageInfo = SystemUtils.getAllInstalledPackageInfo(this.context)) == null || allInstalledPackageInfo.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            if (str2 != null && !StringUtils.isEmpty(str2)) {
                Iterator<PackageInfoEntity> it = allInstalledPackageInfo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        PackageInfoEntity next = it.next();
                        if (str2.equals(next.getPackageName())) {
                            arrayList2.add(next.getPackageName());
                            break;
                        }
                    }
                }
            }
        }
        return new JSONArray((Collection) arrayList2).toString();
    }

    protected String allInstalledPackageInfo() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        List<PackageInfoEntity> allInstalledPackageInfo = SystemUtils.getAllInstalledPackageInfo(this.context);
        if (allInstalledPackageInfo == null || allInstalledPackageInfo.size() <= 0) {
            return null;
        }
        try {
            Object objInvoke = Class.forName("com.alibaba.fastjson.JSONArray").getMethod("toJSON", Object.class).invoke(null, allInstalledPackageInfo);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("com.google.gson.Gson");
            Object objInvoke2 = cls.getMethod("toJson", Object.class).invoke(cls.newInstance(), allInstalledPackageInfo);
            if (objInvoke2 != null) {
                return objInvoke2.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return new JSONArray((Collection) allInstalledPackageInfo).toString();
    }

    protected void uninstallPackage(String str) {
        SystemUtils.uninstallApp(this.context, str);
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }
}
