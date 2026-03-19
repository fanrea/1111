package com.bytedance.sdk.djx.core.api.log;

import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.api.rsp.FeedRsp;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NetLog {
    public static void feedStart(FeedReqParams feedReqParams, Map<String, Object> map) {
        if (feedReqParams == null) {
            return;
        }
        BLogAgent.build(feedReqParams.mCategory, ILogConst.E_NET_FEED_START, map).putString("category", feedReqParams.mCategory).putString("ac", NetworkUtils.getNetworkTypeString(InnerManager.getContext())).send();
    }

    public static void feedResultFail(FeedReqParams feedReqParams, long j, String str, int i, String str2, Throwable th, Map<String, Object> map) {
        if (feedReqParams == null) {
            return;
        }
        String string = null;
        if (th != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            } catch (Throwable unused) {
            }
        }
        BLogAgent.build(feedReqParams.mCategory, ILogConst.E_NET_FEED_RESULT_FAIL, map).putString("category", feedReqParams.mCategory).putString("ac", NetworkUtils.getNetworkTypeString(InnerManager.getContext())).putLong("cost_time", j).putString(g.o, str).putInt("err_code", i).putString("err_msg", str2).putString("err_extra", string).send();
    }

    public static void feedResultSuccess(FeedReqParams feedReqParams, long j, String str, FeedRsp feedRsp, Map<String, Object> map) {
        int adMode;
        int i;
        if (feedReqParams == null) {
            return;
        }
        int size = 0;
        if (feedRsp != null) {
            adMode = feedRsp.getExtra().getAdMode();
            if (adMode == 1) {
                if (feedRsp.getData() == null || feedRsp.getData().isEmpty()) {
                    i = 0;
                } else {
                    Iterator<Feed> it = feedRsp.getData().iterator();
                    i = 0;
                    while (it.hasNext()) {
                        if (it.next().isType4Ad()) {
                            i++;
                        } else {
                            size++;
                        }
                    }
                }
            } else {
                i = 0;
                size = feedRsp.getData() == null ? 0 : feedRsp.getData().size();
            }
        } else {
            adMode = 0;
            i = 0;
        }
        BLogAgent.build(feedReqParams.mCategory, ILogConst.E_NET_FEED_RESULT_SUCCESS, map).putString("category", feedReqParams.mCategory).putString("ac", NetworkUtils.getNetworkTypeString(InnerManager.getContext())).putLong("cost_time", j).putString(g.o, str).putInt("size", size).putInt("ad_size", i).putInt("ad_mode", adMode).putInt("is_refresh", !FeedReqParams.REQ_TYPE_LOAD_MORE.equals(feedReqParams.mReqType) ? 1 : 0).send();
    }
}
