package com.duoyou.task.openapi;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.duoyou.task.pro.a.c;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface IDyAdApi {
    IDyAdApi addWebViewJavascriptInterface(WebViewObject webViewObject, String str);

    IDyAdApi changeTaskDetailHost(String str);

    int checkAppInstalled(Context context, String str);

    void download(Context context, String str, String str2, OnDownloadListener onDownloadListener);

    c getAdListFragment(int i);

    c getAdListFragment(String str, int i);

    String getSdkVersion();

    IDyAdApi getTaskList(String str, TaskListParams taskListParams, OnHttpCallback onHttpCallback);

    IDyAdApi init(Context context, String str, String str2, String str3);

    IDyAdApi init(Context context, String str, String str2, String str3, boolean z);

    void jumpAdDetail(Context context, String str, String str2);

    void jumpAdDetail(Context context, String str, String str2, Map<String, String> map);

    void jumpAdList(Context context, int i);

    void jumpAdList(Context context, String str, int i);

    IDyAdApi jumpCPAList(Context context, String str);

    void jumpMine(Context context, String str);

    void launchLittleProgram(Activity activity, String str, String str2);

    IDyAdApi putOAID(Context context, String str);

    IDyAdApi setCommonCallback(OnCommonCallback onCommonCallback);

    IDyAdApi setDebug(boolean z);

    IDyAdApi setExtra(String str);

    IDyAdApi setInstallNotStart(boolean z);

    IDyAdApi setIsLikeLittleProgram(boolean z);

    IDyAdApi setOAID(String str);

    void setOnNeedLoginCallback(OnNeedLoginCallback onNeedLoginCallback);

    void setOnPayInterceptorCallback(OnPayInterceptorCallback onPayInterceptorCallback);

    IDyAdApi setParamsMap(Map<String, String> map);

    IDyAdApi setRightText(String str, View.OnClickListener onClickListener);

    IDyAdApi setSplashLandscapeImageResource(int i);

    IDyAdApi setSplashPortraitImageResource(int i);

    IDyAdApi setTitle(String str);

    IDyAdApi setTitleBarColor(int i);

    IDyAdApi setTitleBarColor(int i, int i2, boolean z);

    IDyAdApi setUserId(String str);

    void startApp(Context context, String str);

    void startWebViewActivity(Context context, String str);
}
