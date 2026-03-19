package com.duoyou.task.openapi;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.duoyou.task.pro.a.c;
import com.duoyou.task.pro.g.h;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class DyAdApi implements IDyAdApi {
    private static IDyAdApi dyAdApi;

    private DyAdApi() {
    }

    public static IDyAdApi getDyAdApi() {
        if (dyAdApi == null) {
            dyAdApi = new DyAdApi();
        }
        return dyAdApi;
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi init(Context context, String str, String str2, String str3) {
        return h.i().init(context, str, str2, str3);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi init(Context context, String str, String str2, String str3, boolean z) {
        return h.i().init(context, str, str2, str3, z);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setUserId(String str) {
        return h.i().setUserId(str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void jumpAdList(Context context, String str, int i) {
        h.i().jumpAdList(context, str, i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void jumpAdList(Context context, int i) {
        h.i().jumpAdList(context, i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void jumpAdDetail(Context context, String str, String str2) {
        h.i().jumpAdDetail(context, str, str2);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void jumpAdDetail(Context context, String str, String str2, Map<String, String> map) {
        h.i().jumpAdDetail(context, str, str2, map);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void jumpMine(Context context, String str) {
        h.i().jumpMine(context, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void startWebViewActivity(Context context, String str) {
        h.i().startWebViewActivity(context, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public c getAdListFragment(String str, int i) {
        return h.i().getAdListFragment(str, i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public c getAdListFragment(int i) {
        return h.i().getAdListFragment(i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setTitleBarColor(int i) {
        return h.i().setTitleBarColor(i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setTitle(String str) {
        return h.i().setTitle(str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public String getSdkVersion() {
        h.i().getSdkVersion();
        return "3.7.5";
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setTitleBarColor(int i, int i2, boolean z) {
        return h.i().setTitleBarColor(i, i2, z);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setRightText(String str, View.OnClickListener onClickListener) {
        return h.i().setRightText(str, onClickListener);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi putOAID(Context context, String str) {
        return h.i().putOAID(context, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setOAID(String str) {
        return h.i().setOAID(str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setSplashPortraitImageResource(int i) {
        return h.i().setSplashPortraitImageResource(i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setSplashLandscapeImageResource(int i) {
        return h.i().setSplashLandscapeImageResource(i);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setIsLikeLittleProgram(boolean z) {
        return h.i().setIsLikeLittleProgram(z);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi getTaskList(String str, TaskListParams taskListParams, OnHttpCallback onHttpCallback) {
        return h.i().getTaskList(str, taskListParams, onHttpCallback);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi changeTaskDetailHost(String str) {
        return h.i().changeTaskDetailHost(str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void launchLittleProgram(Activity activity, String str, String str2) {
        h.i().launchLittleProgram(activity, str, str2);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void setOnNeedLoginCallback(OnNeedLoginCallback onNeedLoginCallback) {
        h.i().setOnNeedLoginCallback(onNeedLoginCallback);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi addWebViewJavascriptInterface(WebViewObject webViewObject, String str) {
        return h.i().addWebViewJavascriptInterface(webViewObject, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setExtra(String str) {
        return h.i().setExtra(str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void setOnPayInterceptorCallback(OnPayInterceptorCallback onPayInterceptorCallback) {
        h.i().setOnPayInterceptorCallback(onPayInterceptorCallback);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void download(Context context, String str, String str2, OnDownloadListener onDownloadListener) {
        h.i().download(context, str, str2, onDownloadListener);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public void startApp(Context context, String str) {
        h.i().startApp(context, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public int checkAppInstalled(Context context, String str) {
        return h.i().checkAppInstalled(context, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setInstallNotStart(boolean z) {
        return h.i().setInstallNotStart(z);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi jumpCPAList(Context context, String str) {
        return h.i().jumpCPAList(context, str);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setDebug(boolean z) {
        return h.i().setDebug(z);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setCommonCallback(OnCommonCallback onCommonCallback) {
        return h.i().setCommonCallback(onCommonCallback);
    }

    @Override // com.duoyou.task.openapi.IDyAdApi
    public IDyAdApi setParamsMap(Map<String, String> map) {
        return h.i().setParamsMap(map);
    }
}
