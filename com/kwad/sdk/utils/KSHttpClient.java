package com.kwad.sdk.utils;

import android.util.Log;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.sdk.live.audience.api.KSLiveRequest;
import com.kwad.sdk.request.BaseLiveRequest;
import com.kwad.sdk.request.BaseLiveResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSHttpClient {
    public String doHttpRequest1(final KSLiveRequest kSLiveRequest) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = {""};
        new OfflineCompoNetworking<BaseLiveRequest, BaseLiveResponse>() { // from class: com.kwad.sdk.utils.KSHttpClient.1
            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNetworking, com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
            public boolean isPostByJson() {
                return false;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNetworking
            public BaseLiveResponse createResponseData() {
                return new BaseLiveResponse();
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
            public BaseLiveRequest createRequest() {
                return new BaseLiveRequest(kSLiveRequest);
            }

            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNetworking
            public BaseLiveResponse parseData(String str) {
                strArr[0] = str;
                return (BaseLiveResponse) super.parseData(str);
            }
        }.request(new IOfflineCompoRequestListener<BaseLiveRequest, BaseLiveResponse>() { // from class: com.kwad.sdk.utils.KSHttpClient.2
            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public void onStartRequest(BaseLiveRequest baseLiveRequest) {
                Log.d("KSHttpClient", "doHttpRequest1 onStartRequest request:" + baseLiveRequest.getHeader());
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public void onSuccess(BaseLiveRequest baseLiveRequest, BaseLiveResponse baseLiveResponse) {
                Log.d("KSHttpClient", "doHttpRequest1 onSuccess request:" + baseLiveRequest.getHeader() + " response:" + baseLiveResponse.toJson());
                countDownLatch.countDown();
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public void onError(BaseLiveRequest baseLiveRequest, int i, String str) {
                Log.d("KSHttpClient", "doHttpRequest1 onError request:" + baseLiveRequest.getHeader() + " errorMsg:" + str);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArr[0];
    }

    public String doHttpRequest(KSLiveRequest kSLiveRequest) {
        ResponseBody responseBodyBody;
        try {
            Response responseExecute = new OkHttpClient().newCall(new Request.Builder().url(kSLiveRequest.mUrl).post(buildRequestBody(kSLiveRequest)).build()).execute();
            return (!responseExecute.isSuccessful() || (responseBodyBody = responseExecute.body()) == null) ? "" : responseBodyBody.string();
        } catch (IOException unused) {
            return "";
        }
    }

    private RequestBody buildRequestBody(KSLiveRequest kSLiveRequest) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : kSLiveRequest.mBodyParam.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : kSLiveRequest.mUrlParam.entrySet()) {
            if (entry2.getKey() != null && entry2.getValue() != null) {
                builder.add(entry2.getKey(), entry2.getValue());
            }
        }
        return builder.build();
    }
}
