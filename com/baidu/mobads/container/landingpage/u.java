package com.baidu.mobads.container.landingpage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.cl;
import com.bytedance.applog.util.WebViewJsUtil;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u extends WebViewClient {
    final /* synthetic */ App2Activity.d a;
    final /* synthetic */ App2Activity b;

    u(App2Activity app2Activity, App2Activity.d dVar) {
        this.b = app2Activity;
        this.a = dVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            try {
                if (!WebViewJsUtil.EMPTY_PAGE.equals(str)) {
                    if (this.b.isQuickAppUrl(str)) {
                        this.b.sendQuickAppLog(this.b.mAppContext, str);
                        return true;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.startsWith(com.alipay.sdk.m.l.a.r)) {
                            this.b.mAPO = true;
                        } else {
                            App2Activity.access$2608(this.b);
                        }
                    }
                    if (str != null && str.contains("nfs://adinteract?")) {
                        return true;
                    }
                    if (str != null && str.startsWith("bdmobadsapp://v1/utils/lp?")) {
                        this.b.updateLpState("backHouseFinish");
                        this.b.closeCause = "clickHouse";
                        this.b.exit();
                        return false;
                    }
                    WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult != null && hitTestResult.getType() == 0) {
                        this.a.a = true;
                    }
                    if (this.b.mTmpExtraInfo != null && App2Activity.LP_STYLE_VR.equals(this.b.mTmpExtraInfo.D)) {
                        return false;
                    }
                    if (!TextUtils.isEmpty(str) && this.b.mOpenBundleForbid) {
                        HashMap map = new HashMap();
                        URL url = new URL(str);
                        if (str.startsWith(com.alipay.sdk.m.l.a.r) && !url.getHost().contains(".baidu.")) {
                            this.b.isReLoadURL = true;
                            String str2 = "";
                            if (this.b.mBundleSetBD) {
                                str2 = "com.baidu.searchbox";
                            }
                            map.put("x-requested-with", str2);
                            App2Activity.access$3308(this.b);
                            if (TextUtils.isEmpty(this.b.mForbidHost)) {
                                this.b.mForbidHost = url.getHost();
                            }
                            this.b.curWebview.loadUrl(str, map);
                            return true;
                        }
                    }
                    return this.b.broswer(webView, str, null, null);
                }
            } catch (Exception e) {
                this.b.mAdLogger.a(App2Activity.TAG, e.getMessage());
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.b.curWebview != null && str != null) {
            this.b.curWebview.a = str;
        }
        if (this.b.mOpenBundleForbid && TextUtils.isEmpty(this.b.finishUrl)) {
            this.b.finishUrl = str;
        }
        this.a.b = str;
        this.a.c = false;
        if (!this.a.a) {
            a(str);
        }
        if (!this.b.isRecordPageStart) {
            this.b.stateEvent(com.baidu.mobads.container.components.h.b.j);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.b.mWebViewLoadTime == 0) {
            this.b.mWebViewLoadTime = System.currentTimeMillis() - this.b.mWebLoadStartTime;
        }
        if (!this.a.a && this.a.b.equals(str)) {
            if (this.b.mLploadtime == -1) {
                this.b.mLploadtime = (int) (System.currentTimeMillis() - this.b.mEnterLpTimestamp);
            }
            if (!this.a.c) {
                this.a.c = true;
                a(this.a.b, 0);
                this.b.stateEvent(com.baidu.mobads.container.components.h.a.EVENT_LP_PAGE_FINISH);
            }
        }
        this.a.a = false;
        this.a.b = "";
        if (this.b.mPageFinishedListener != null) {
            this.b.mPageFinishedListener.a(webView);
        }
        super.onPageFinished(webView, str);
        if (this.b.needInjectJSWhenPageFinished()) {
            this.b.executeJavaScript("javascript:(function(){window.baidu={};window.baidu.mobads={};window.baidu.mobads.Sdk={isIOS:false};var Sdk=window.baidu.mobads.Sdk;Sdk.isIOS=(/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());var mob=window.baidu.mobads;mob.Act={LP:1,DL:2,MAP:4,SMS:8,MAIL:16,PHONE:32,VIDEO:64,RM:128,NA:256,APO:512};var win=window;win.MobadsSdk=win.MobadsSdk||{};var MobadsSdk=win.MobadsSdk;var send3rdLog=function(isShowLog,ad){if(!ad||!ad.mon){return}var url;for(var i=0;i<ad.mon.length;++i){url=isShowLog?ad.mon[i].s:ad.mon[i].c;if(!url){continue}new Image().src=url}};Sdk.setActionUrl=function(url,inapp,act,title,close){var opt={};if(\"[object Object]\"===Object.prototype.toString.call(url)){opt=url;url=opt.url;inapp=opt.inapp;act=opt.act;title=opt.title;close=opt.close}opt.url=url||\"\";opt.inapp=inapp||false;opt.act=act||1;opt.title=title||\"\";opt.close=close||false;opt.logurl=opt.logurl||\"\";opt.weibo=opt.weibo||\"\";opt.map=opt.map||\"\";opt.search=opt.search||\"\";opt.sms=opt.sms||\"\";opt.at=opt.at||1;opt.tid=opt.tid||\"\";opt.erciqueren=true;if(MobadsSdk.setActionUrl){var DUMP_PAR=opt.inapp;MobadsSdk.setActionUrl(JSON.stringify(opt),DUMP_PAR)}};Sdk.sendClickLog=function(logurl){new Image().src=logurl};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){setTimeout(function(){MobadsSdk.onAdPlayEnd()},300)}};Sdk.open=function(url,options){var option={url:url,inapp:true,act:mob.Act.LP};Sdk.setActionUrl(option);send3rdLog(false,options)};Sdk.startDownload=function(url,options){var ad={};ad=options||{};ad.tit=options&&options.tit||options.appname||\"应用\";var mobadsJumpUrl=url;if(/^itms-services:\\/\\// .test(url)){Sdk.setActionUrl(url,false,mob.Act.DL,ad.tit,true);return}if(Sdk.isIOS){var tid=options&&options.pinfo&&options.pinfo.tid;if(tid){Sdk.sendClickLog(mobadsJumpUrl)}Sdk.setActionUrl({url:url,tid:tid||\"\",inapp:true,act:mob.Act.DL});return}var mon=options&&options.mon||[];var id=options&&options.id||1;var pk=options&&options.pk||\"\";var qk=options&&options.qk||\"\";var exp2=options&&options.exp2||{};var wi=options&&options.wi?true:false;var title=ad.tit;var jsonpar={url:mobadsJumpUrl,act:mob.Act.DL,inapp:true,close:true,adid:id,originUrl:mobadsJumpUrl,dlTunnel:3,autoOpen:true,popNotif:true,canCancel:true,canDelete:5,mon:mon,pk:pk,qk:qk,adid:id,title:ad.tit};Sdk.setActionUrl(jsonpar);if(MobadsSdk.sendActivate){MobadsSdk.sendActivate(JSON.stringify(jsonpar));}send3rdLog(false,options);};Sdk.openScheme=function(url,options){var ad={};ad=options||{};ad.tit=options &&options.tit||\"应用\";var pk=options&&options.pk||\"\";var option={url:url,inapp:true,act:ad.act,title:ad.tit,close:true,pk:pk};Sdk.setActionUrl(option);send3rdLog(false,options);};Sdk.handleClick=function(options){var ad=options||{};var Act=mob.Act;if(Act.LP==ad.act){Sdk.open(ad.curl,ad)}else if(Act.DL==ad.act){Sdk.startDownload(ad.curl,ad)}else if(Act.APO==ad.act){new Image().src=ad.curl;Sdk.openScheme(ad.apo,ad);}};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){MobadsSdk.onAdPlayEnd();}};Sdk.f=function(){if(arguments.length===0){return '';}else if(arguments.length===1){return arguments[0];}var res=arguments[0];for(var i=1;i<arguments.length;++i){var re=new RegExp('\\\\{'+(i-1)+'\\\\}','g');res=res.replace(re,arguments[i]);}return res;};Sdk.randomInt=function(min,max){return Math.floor(Math.random()*(max-min+1)+min);};Sdk.isFunction=function(source){return '[object Function]'===Object.prototype.toString.call(source);};Sdk.natFireEvent=function(token,res){res=res||'';if(token!==''&&Sdk.__events&&Sdk.__events[token]&&Sdk.isFunction(Sdk.__events[token])){Sdk.__events[token](res);if(Sdk.__events[token]&&!Sdk.__events[token].multi){delete Sdk.__events[token];}}};Sdk.natRegEv=function(eventHandler,eventType){eventType=eventType||'';Sdk.__events=Sdk.__events||{};var token=Sdk.f('_{0}_{1}_{2}',eventType,new Date().getTime(),Sdk.randomInt(0,4294967296));Sdk.__events[token]=eventHandler;return token;};Sdk.isInstalled=function(pk,onready){var token=Sdk.natRegEv(onready);if(MobadsSdk.isInstalled){MobadsSdk.isInstalled(token,pk);}else{Sdk.natFireEvent(token,'false');}};Sdk.getDownloadStatus=function(callback,pkg){var token=Sdk.natRegEv(callback);if(MobadsSdk.getDownloadStatus){MobadsSdk.getDownloadStatus(token,pkg);}};Sdk.pauseDownload=function(pkg){if(MobadsSdk.pauseDownload){MobadsSdk.pauseDownload(pkg);}};window.MobadsSdk=window.MobadsSdk||{};window.MobadsSdk.pauseDownload=function(pkg){window.location='mobadssdk://pauseDownload?pkg='+pkg;};window.MobadsSdk.getDownloadStatus=function(token,pkg){window.location='mobadssdk://getDownloadStatus?token='+token+'&pkg='+pkg;};window.MobadsSdk.setActionUrl=function(jsonPar,inapp){window.location='mobadssdk://setActionUrl?json='+jsonPar;};})();");
            this.b.executeJavaScript("javascript:(function(){window.mobadsSdk&&window.mobadsSdk.pageFinishedCallback&&window.mobadsSdk.pageFinishedCallback();})()");
        }
        if (!this.b.isRecordPageFinish) {
            this.b.stateEvent(com.baidu.mobads.container.components.h.b.l);
        }
    }

    private void a(String str) {
        try {
            if (this.a.d) {
                this.b.mLandingPageTrackingInfo.a = str;
                if (this.b.mLandingPageTrackingInfo.P == 0) {
                    this.b.mLandingPageTrackingInfo.P = System.currentTimeMillis();
                    this.b.mTrackingParams.put("pageStart", Long.valueOf(this.b.mLandingPageTrackingInfo.P));
                }
                this.b.mLandingPageTrackingInfo.o = App2Activity.access$4708(this.b);
                if (this.b.curWebview != null) {
                    this.b.mLandingPageTrackingInfo.q = this.b.curWebview.getContentHeight();
                    this.b.mLandingPageTrackingInfo.F = this.b.curWebview.getProgress();
                }
                this.b.mLandingPageTrackingInfo.J = System.currentTimeMillis() - this.b.mEnterLpTimestamp;
                this.b.mLandingPageTrackingInfo.L = this.b.e75;
                this.b.mLandingPageTrackingInfo.N = this.b.from;
                this.a.d = false;
                this.b.stateEvent(com.baidu.mobads.container.components.h.a.EVENT_LP_PAGE_START);
                return;
            }
            this.b.mAdLogger.a(App2Activity.TAG, "App2Activity - not send 37");
        } catch (Exception e) {
            this.b.mAdLogger.a(App2Activity.TAG, e.getMessage());
        }
    }

    private void a(String str, int i) {
        try {
            this.b.mLandingPageTrackingInfo.a = str;
            if (this.b.mLandingPageTrackingInfo.Q == 0) {
                this.b.mLandingPageTrackingInfo.Q = System.currentTimeMillis();
                this.b.mTrackingParams.put("pageFinish", Long.valueOf(this.b.mLandingPageTrackingInfo.P));
            }
            this.b.mLandingPageTrackingInfo.o = App2Activity.access$4708(this.b);
            this.b.mLandingPageTrackingInfo.L = this.b.e75;
            this.b.mLandingPageTrackingInfo.N = this.b.from;
            if (this.b.curWebview != null) {
                this.b.mLandingPageTrackingInfo.q = this.b.curWebview.getContentHeight();
                this.b.mLandingPageTrackingInfo.F = this.b.curWebview.getProgress();
            }
            this.b.mLandingPageTrackingInfo.J = System.currentTimeMillis() - this.b.mEnterLpTimestamp;
            this.a.d = true;
        } catch (Exception e) {
            this.b.mAdLogger.a(App2Activity.TAG, e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        try {
            if (!this.a.c && !str.equals(this.a.b) && !this.a.a) {
                this.a.c = true;
                if (this.b.mLploadtime == -1) {
                    this.b.mLploadtime = (int) (System.currentTimeMillis() - this.b.mEnterLpTimestamp);
                }
                a(this.a.b, 0);
            }
            WebView.HitTestResult hitTestResult = webView.getHitTestResult();
            if (hitTestResult != null && hitTestResult.getType() > 0 && b(str)) {
                this.b.broswer(webView, str, new v(this), null);
            }
        } catch (Exception e) {
            this.b.mAdLogger.a(App2Activity.TAG, e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponseA;
        try {
            String string = webResourceRequest.getUrl().toString();
            if (!TextUtils.isEmpty(string) && this.b.isQuickAppUrl(string)) {
                this.b.sendQuickAppLog(this.b.mAppContext, string);
                return new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream("快应用调起，已被拦截".getBytes()));
            }
            WebResourceResponse webResourceResponseA2 = com.baidu.mobads.container.y.j.a(this.b.mAppContext).a(this.b.curWebview.a, string);
            if (webResourceResponseA2 == null) {
                if (!this.b.mOpenBundleForbid || (webResourceResponseA = cl.a(this.b.mAppContext, webResourceRequest)) == null) {
                    return null;
                }
                return webResourceResponseA;
            }
            App2Activity.access$4908(this.b);
            return webResourceResponseA2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if (!com.baidu.mobads.container.r.c.a(sslErrorHandler)) {
                sslErrorHandler.cancel();
            }
            if (this.b.isLuLandingPage && this.b.mLandingPageTrackingInfo.E == -1) {
                this.b.mLandingPageTrackingInfo.E = System.currentTimeMillis() - this.b.mEnterLpTimestamp;
            }
        } catch (Throwable th) {
            this.b.mAdLogger.a(th.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (com.baidu.mobads.container.util.x.a(this.b.mAppContext).a() < 26) {
            return false;
        }
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.destroy();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return (str.startsWith("blob:") || com.baidu.mobads.container.ax.h(str) || com.baidu.mobads.container.ax.g(str)) ? false : true;
    }
}
