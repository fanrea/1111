package com.bytedance.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class EventBus extends Thread implements Handler.Callback {
    private static final int EMIT_EVENT_MSG = 1;
    public static AbsSingleton<EventBus> global = new AbsSingleton<EventBus>() { // from class: com.bytedance.applog.log.EventBus.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public EventBus create(Object... objArr) {
            return new EventBus();
        }
    };
    private Handler eventHandler;
    private final Map<String, List<Subscription>> subscriptionMap = new ConcurrentHashMap();

    public interface DataFetcher {
        Object fetch();
    }

    public interface Subscription {
        void sub(Object obj);
    }

    public EventBus() {
        start();
    }

    private static class MessageEvent {
        Object data;
        String event;

        MessageEvent(String str, Object obj) {
            this.event = str;
            this.data = obj;
        }
    }

    public void emit(String str, Object obj) {
        if (TextUtils.isEmpty(str) || !this.subscriptionMap.containsKey(str)) {
            return;
        }
        emit(new MessageEvent(str, obj));
    }

    public void emit(String str, DataFetcher dataFetcher) {
        if (TextUtils.isEmpty(str) || !this.subscriptionMap.containsKey(str) || dataFetcher == null) {
            return;
        }
        emit(new MessageEvent(str, dataFetcher.fetch()));
    }

    public synchronized void listen(String str, Subscription subscription) {
        List<Subscription> arrayList = this.subscriptionMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(subscription);
        this.subscriptionMap.put(str, arrayList);
    }

    public synchronized void remove(String str, Subscription subscription) {
        List<Subscription> list = this.subscriptionMap.get(str);
        if (list != null && list.contains(subscription)) {
            list.remove(subscription);
            if (list.size() == 0) {
                this.subscriptionMap.remove(str);
            } else {
                this.subscriptionMap.put(str, list);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.eventHandler = new Handler(this);
        Looper.loop();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            emitEvent((MessageEvent) message.obj);
        }
        return true;
    }

    private void emit(MessageEvent messageEvent) {
        Handler handler = this.eventHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1, messageEvent));
        } else {
            emitEvent(messageEvent);
        }
    }

    private void emitEvent(MessageEvent messageEvent) {
        List<Subscription> list = this.subscriptionMap.get(messageEvent.event);
        if (list == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        byte[] bArr = null;
        try {
            if ("applog_event_upload_eid".equals(messageEvent.event) && (messageEvent.data instanceof JSONObject) && ((JSONObject) messageEvent.data).has("$$EVENT_LOCAL_IDS")) {
                Object objOpt = ((JSONObject) messageEvent.data).opt("$$EVENT_LOCAL_IDS");
                if (objOpt instanceof Collection) {
                    hashSet.addAll((Collection) objOpt);
                }
            } else if ("applog_do_request_end".equals(messageEvent.event) && (messageEvent.data instanceof JSONObject) && ((JSONObject) messageEvent.data).has("responseByte")) {
                Object objOpt2 = ((JSONObject) messageEvent.data).opt("responseByte");
                if (objOpt2 instanceof byte[]) {
                    bArr = (byte[]) ((byte[]) objOpt2).clone();
                }
            }
            for (Subscription subscription : list) {
                if (messageEvent.data instanceof JSONObject) {
                    try {
                        JSONObject jSONObject = new JSONObject(messageEvent.data.toString());
                        if (!hashSet.isEmpty()) {
                            jSONObject.put("$$EVENT_LOCAL_IDS", hashSet);
                        }
                        if (bArr != null) {
                            jSONObject.put("responseByte", bArr);
                        }
                        subscription.sub(jSONObject);
                    } catch (JSONException unused) {
                        subscription.sub(messageEvent.data);
                    }
                } else {
                    subscription.sub(messageEvent.data);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
