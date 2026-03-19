package com.component.interfaces;

import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.i;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class RemoteDelegator<T> extends cn implements IAdInterListener, Delegator<T> {
    private static final String EVENT_INIT = "p_init";
    private static final String EVENT_SET_CLASS = "p_set_class";
    private static final Map<String, Class<?>> PROXY_CLASS_MAP = new HashMap();
    private static final String PROXY_EVENT_ARGS = "e_a";
    private static final String PROXY_EVENT_DISPATCHER = "e_d";
    private static final String PROXY_EVENT_NAME = "e_n";
    private static final String PROXY_EVENT_RETURN = "e_r";
    private static final String PROXY_EVENT_TAG = "e_t";
    private static final String PROXY_EVENT_TYPE = "p_e";
    public static final String TAG_FRAGMENT = "Fragment";
    public static final String TAG_FRAGMENT_V4 = "FragmentV4";
    public static final String TAG_RL_RECYCLER_VIEW = "RLRecyclerView";
    public static final String TAG_RV_ADAPTER = "RVAdapter";
    public static final String TAG_RV_VIEW_HOLDER = "RVViewHolder";
    public static final String TAG_VIEWPAGER2 = "ViewPager2";
    private Callback callback;
    private final Map<String, Class<?>[]> events;
    private final T instance;
    private String tag;

    public @interface ClassTag {
    }

    protected abstract T transformInstance(Object obj);

    public RemoteDelegator(String str, i iVar, Object... objArr) {
        checkClassSet(iVar);
        this.tag = str;
        this.events = new HashMap();
        this.instance = transformInstance(initProxyInstance(iVar, objArr));
    }

    protected void resetTag(String str) {
        this.tag = str;
    }

    public void addEvent(String str, Class<?>... clsArr) {
        this.events.put(str, clsArr);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static abstract class Callback {
        public abstract Object onResult(String str, Object[] objArr);

        /* JADX INFO: Access modifiers changed from: private */
        public Object callResult(String str, Object[] objArr) {
            try {
                return onResult(str, objArr);
            } catch (Throwable th) {
                bq.a().c(th.getMessage());
                return null;
            }
        }
    }

    @Override // com.component.interfaces.Delegator
    public T getInstance() {
        return this.instance;
    }

    private static void checkClassSet(i iVar) {
        if (iVar != null && PROXY_CLASS_MAP.isEmpty()) {
            HashMap map = new HashMap();
            map.put(PROXY_EVENT_NAME, EVENT_SET_CLASS);
            map.put(PROXY_EVENT_ARGS, PROXY_CLASS_MAP);
            iVar.dispatchEvent(new cm("p_e", (HashMap<String, Object>) map));
        }
    }

    public static boolean isInstanceOf(String str, Object obj) {
        Class<?> cls = PROXY_CLASS_MAP.get(str);
        if (cls != null && obj != null) {
            return cls.isInstance(obj);
        }
        return false;
    }

    public static Object getRemoteTarget(Object obj) {
        if (obj instanceof IOAdEvent) {
            return ((IOAdEvent) obj).getTarget();
        }
        return null;
    }

    public Object initProxyInstance(i iVar, Object... objArr) {
        HashMap map = new HashMap();
        map.put(PROXY_EVENT_TAG, this.tag);
        map.put(PROXY_EVENT_NAME, EVENT_INIT);
        map.put(PROXY_EVENT_ARGS, objArr);
        map.put(PROXY_EVENT_DISPATCHER, this);
        iVar.dispatchEvent(new cm("p_e", (HashMap<String, Object>) map));
        return map.get(PROXY_EVENT_RETURN);
    }

    @Override // com.component.interfaces.Delegator
    public Object dispatch(String str, Object... objArr) {
        if (validateMethodArgs(str, objArr)) {
            HashMap map = new HashMap();
            map.put(PROXY_EVENT_TAG, this.tag);
            map.put(PROXY_EVENT_NAME, str);
            map.put(PROXY_EVENT_ARGS, objArr);
            dispatchEvent(new cm("p_e", (HashMap<String, Object>) map));
            return map.get(PROXY_EVENT_RETURN);
        }
        return null;
    }

    public boolean validateMethodArgs(String str, Object... objArr) {
        return validateArgs(objArr, this.events.get(str));
    }

    public static boolean validateArgs(Object[] objArr, Class<?>... clsArr) {
        boolean z = objArr == null || objArr.length == 0;
        boolean z2 = clsArr == null || clsArr.length == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (objArr[i] != null && !clsArr[i].isInstance(objArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void createProdHandler(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void loadAd(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void showAd() {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public boolean isAdReady() {
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void setAdContainer(RelativeLayout relativeLayout) {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void destroyAd() {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(View view, String str) {
        this.callback.callResult(str, new Object[]{view});
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAdTaskProcess(String str) {
        this.callback.callResult(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAdTaskProcess(java.lang.String r3, java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L10
            java.lang.String r0 = "e_a"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L10
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L11
        L10:
            r0 = 0
        L11:
            com.component.interfaces.RemoteDelegator$Callback r1 = r2.callback
            java.lang.Object r3 = com.component.interfaces.RemoteDelegator.Callback.access$000(r1, r3, r0)
            if (r4 == 0) goto L1e
            java.lang.String r0 = "e_r"
            r4.put(r0, r3)
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.interfaces.RemoteDelegator.onAdTaskProcess(java.lang.String, java.util.Map):void");
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public View getAdContainerView() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.api.IAdInterListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }
}
