package com.kwad.sdk.core.b.a;

import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kn implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.n) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.n) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong(com.alipay.sdk.m.t.a.k);
        nVar.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.OY = jSONObject.optLong(com.baidu.mobads.container.adrequest.g.ag);
        nVar.bEK = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.QX = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(nVar.QX)) {
            nVar.QX = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.bEL = jSONObject.optJSONObject("extra");
        nVar.bEM = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong("position");
        nVar.bEN = jSONObject.optLong("serverPosition");
        nVar.bEO = jSONObject.optLong("photoDuration");
        nVar.bEP = jSONObject.optLong("effectivePlayDuration");
        nVar.adZ = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.bEQ = jSONObject.optLong("intervalDuration");
        nVar.bER = jSONObject.optLong("allIntervalDuration");
        nVar.bES = jSONObject.optLong("flowSdk");
        nVar.bET = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.bws = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        nVar.urlPackage = new URLPackage();
        nVar.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        nVar.bEU = new URLPackage();
        nVar.bEU.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.bEV = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(nVar.bEV)) {
            nVar.bEV = "";
        }
        nVar.bEW = jSONObject.optJSONArray("appInstalled");
        nVar.bEX = jSONObject.optJSONArray("appUninstalled");
        nVar.bEY = new n.a();
        nVar.bEY.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.bEZ = jSONObject.optInt("playerType");
        nVar.bFa = jSONObject.optInt("uiType");
        nVar.bFb = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.afw = jSONObject.optInt("refreshType");
        nVar.bFc = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.bFd = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(nVar.bFd)) {
            nVar.bFd = "";
        }
        nVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.bFg = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(nVar.bFg)) {
            nVar.bFg = "";
        }
        nVar.bFh = jSONObject.optJSONObject("appExt");
        nVar.bFi = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.bFj = jSONObject.optInt("speedLimitStatus");
        nVar.bFk = jSONObject.optInt("speedLimitThreshold");
        nVar.bFl = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.bFn = jSONObject.optJSONArray("sdkPlatform");
        nVar.bFo = jSONObject.optBoolean("isKsUnion");
        nVar.bFp = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(nVar.bFp)) {
            nVar.bFp = "";
        }
        nVar.bFq = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.bFs = jSONObject.optLong("frameRenderTime");
        nVar.bFt = jSONObject.optInt("playerEnterAction");
        nVar.bFu = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(nVar.bFu)) {
            nVar.bFu = "";
        }
        nVar.bFv = jSONObject.optLong("requestTotalTime");
        nVar.bFw = jSONObject.optLong("requestResponseTime");
        nVar.bFx = jSONObject.optLong("requestParseDataTime");
        nVar.bFy = jSONObject.optLong("requestCallbackTime");
        nVar.bFz = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(nVar.bFz)) {
            nVar.bFz = "";
        }
        nVar.Yt = jSONObject.optString("pageName");
        if (JSONObject.NULL.toString().equals(nVar.Yt)) {
            nVar.Yt = "";
        }
        nVar.YB = jSONObject.optLong("pageCreateTime");
        nVar.YC = jSONObject.optLong("pageResumeTime");
        nVar.bFA = jSONObject.optInt("trackUrlType");
        nVar.bFB = jSONObject.optJSONArray("trackUrlList");
        nVar.YA = jSONObject.optLong("pageLaunchTime");
        nVar.bFE = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.bFF = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(nVar.bFF)) {
            nVar.bFF = "";
        }
        nVar.bFG = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(nVar.bFG)) {
            nVar.bFG = "";
        }
        nVar.bFH = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(nVar.bFH)) {
            nVar.bFH = "";
        }
        nVar.bFI = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(nVar.bFI)) {
            nVar.bFI = "";
        }
        nVar.bFJ = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(nVar.bFJ)) {
            nVar.bFJ = "";
        }
        nVar.bFK = jSONObject.optInt("adBizType");
        nVar.bFL = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(nVar.bFL)) {
            nVar.bFL = "";
        }
        nVar.bFM = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(nVar.bFM)) {
            nVar.bFM = "";
        }
        nVar.trace = jSONObject.optString(Config.TRACE_PART);
        if (JSONObject.NULL.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.bFN = jSONObject.optInt("filterCode");
        nVar.bFO = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString("sdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.bFP = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.bFP)) {
            nVar.bFP = "";
        }
        nVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkApiVersion)) {
            nVar.sdkApiVersion = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.bFQ = jSONObject.optLong("appUseDuration");
        nVar.bFR = jSONObject.optLong("appStartType");
        nVar.bBn = jSONObject.optLong("sequenceNumber");
        nVar.OV = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(nVar.OV)) {
            nVar.OV = "";
        }
        nVar.OW = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(nVar.OW)) {
            nVar.OW = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nVar.timestamp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.t.a.k, nVar.timestamp);
        }
        if (nVar.sessionId != null && !nVar.sessionId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        if (nVar.OY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.ag, nVar.OY);
        }
        if (nVar.bEK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listId", nVar.bEK);
        }
        if (nVar.actionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", nVar.actionType);
        }
        if (nVar.QX != null && !nVar.QX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", nVar.QX);
        }
        if (nVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", nVar.llsid);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extra", nVar.bEL);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "impAdExtra", nVar.bEM);
        if (nVar.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", nVar.posId);
        }
        if (nVar.contentType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentType", nVar.contentType);
        }
        if (nVar.realShowType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realShowType", nVar.realShowType);
        }
        if (nVar.photoId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", nVar.photoId);
        }
        if (nVar.position != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "position", nVar.position);
        }
        if (nVar.bEN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPosition", nVar.bEN);
        }
        if (nVar.bEO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoDuration", nVar.bEO);
        }
        if (nVar.bEP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "effectivePlayDuration", nVar.bEP);
        }
        if (nVar.adZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", nVar.adZ);
        }
        if (nVar.blockDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockDuration", nVar.blockDuration);
        }
        if (nVar.bEQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "intervalDuration", nVar.bEQ);
        }
        if (nVar.bER != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "allIntervalDuration", nVar.bER);
        }
        if (nVar.bES != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "flowSdk", nVar.bES);
        }
        if (nVar.bET != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTimes", nVar.bET);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        if (nVar.bws != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", nVar.bws);
        }
        if (nVar.entryPageSource != null && !nVar.entryPageSource.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.aa.a(jSONObject, "referURLPackage", nVar.bEU);
        if (nVar.authorId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, nVar.authorId);
        }
        if (nVar.bEV != null && !nVar.bEV.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSize", nVar.bEV);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appInstalled", nVar.bEW);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appUninstalled", nVar.bEX);
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExt", nVar.bEY);
        if (nVar.bEZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerType", nVar.bEZ);
        }
        if (nVar.bFa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uiType", nVar.bFa);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "isLeftSlipStatus", nVar.bFb);
        if (nVar.afw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", nVar.afw);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "photoResponseType", nVar.bFc);
        if (nVar.bFd != null && !nVar.bFd.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failUrl", nVar.bFd);
        }
        if (nVar.errorMsg != null && !nVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorMsg", nVar.errorMsg);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", nVar.errorCode);
        if (nVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", nVar.creativeId);
        }
        if (nVar.bFg != null && !nVar.bFg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheFailedReason", nVar.bFg);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appExt", nVar.bFh);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appRunningInfoList", nVar.bFi);
        if (nVar.downloadDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadDuration", nVar.downloadDuration);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "pageType", nVar.pageType);
        if (nVar.bFj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitStatus", nVar.bFj);
        }
        if (nVar.bFk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitThreshold", nVar.bFk);
        }
        if (nVar.bFl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentRealDownloadSpeed", nVar.bFl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkPlatform", nVar.bFn);
        if (nVar.bFo) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isKsUnion", nVar.bFo);
        }
        if (nVar.bFp != null && !nVar.bFp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackMethodName", nVar.bFp);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "viewModeType", nVar.bFq);
        if (nVar.clickTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickTime", nVar.clickTime);
        }
        if (nVar.bFs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "frameRenderTime", nVar.bFs);
        }
        if (nVar.bFt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerEnterAction", nVar.bFt);
        }
        if (nVar.bFu != null && !nVar.bFu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestUrl", nVar.bFu);
        }
        if (nVar.bFv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestTotalTime", nVar.bFv);
        }
        if (nVar.bFw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestResponseTime", nVar.bFw);
        }
        if (nVar.bFx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestParseDataTime", nVar.bFx);
        }
        if (nVar.bFy != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestCallbackTime", nVar.bFy);
        }
        if (nVar.bFz != null && !nVar.bFz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestFailReason", nVar.bFz);
        }
        if (nVar.Yt != null && !nVar.Yt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageName", nVar.Yt);
        }
        if (nVar.YB != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageCreateTime", nVar.YB);
        }
        if (nVar.YC != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageResumeTime", nVar.YC);
        }
        if (nVar.bFA != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlType", nVar.bFA);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlList", nVar.bFB);
        if (nVar.YA != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageLaunchTime", nVar.YA);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appAuthorityInfoList", nVar.bFE);
        if (nVar.bFF != null && !nVar.bFF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", nVar.bFF);
        }
        if (nVar.bFG != null && !nVar.bFG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsVersion", nVar.bFG);
        }
        if (nVar.bFH != null && !nVar.bFH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsFileName", nVar.bFH);
        }
        if (nVar.bFI != null && !nVar.bFI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsErrorMsg", nVar.bFI);
        }
        if (nVar.bFJ != null && !nVar.bFJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsConfig", nVar.bFJ);
        }
        if (nVar.bFK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adBizType", nVar.bFK);
        }
        if (nVar.bFL != null && !nVar.bFL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customKey", nVar.bFL);
        }
        if (nVar.bFM != null && !nVar.bFM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customValue", nVar.bFM);
        }
        if (nVar.trace != null && !nVar.trace.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Config.TRACE_PART, nVar.trace);
        }
        if (nVar.bFN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "filterCode", nVar.bFN);
        }
        if (nVar.bFO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersionCode", nVar.bFO);
        }
        if (nVar.sdkVersion != null && !nVar.sdkVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersion", nVar.sdkVersion);
        }
        if (nVar.bFP != null && !nVar.bFP.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSdkVersion", nVar.bFP);
        }
        if (nVar.sdkApiVersion != null && !nVar.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", nVar.sdkApiVersion);
        }
        if (nVar.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", nVar.sdkType);
        }
        if (nVar.bFQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appUseDuration", nVar.bFQ);
        }
        if (nVar.bFR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStartType", nVar.bFR);
        }
        if (nVar.bBn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sequenceNumber", nVar.bBn);
        }
        if (nVar.OV != null && !nVar.OV.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appColdStart", nVar.OV);
        }
        if (nVar.OW != null && !nVar.OW.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStart", nVar.OW);
        }
        return jSONObject;
    }
}
