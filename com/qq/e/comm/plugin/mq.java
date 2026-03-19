package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.AdData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mq extends NativeExpressADView {
    public static final int j = yu.a(r1.d().a(), 56);
    public static final int m = yu.a(r1.d().a(), 76);
    public static final int n = yu.a(r1.d().a(), 33);
    public static final int o;
    public static final int p;
    public static final int q;
    private final List<NativeExpressADView> d;
    private final fi e;
    private final int f;
    private final f5 g;
    private NativeExpressADView.ViewBindStatusListener h;
    private int i;

    static {
        int iA = yu.a(r1.d().a(), 12);
        o = iA;
        p = iA + yu.a(r1.d().a(), 4);
        q = yu.a(r1.d().a(), 12);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return "";
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public AdData getBoundData() {
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return "";
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void negativeFeedback() {
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    @Deprecated
    public void setAdSize(ADSize aDSize) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
    }

    public mq(ADListener aDListener, List<dd> list, Context context, int i) throws JSONException {
        super(context);
        this.i = -1;
        this.d = new CopyOnWriteArrayList();
        this.f = i;
        ed edVarD = list.get(0).d();
        this.g = new f5().c(3).a(edVarD.k()).c(edVarD.y0());
        fi fiVar = new fi(context);
        this.e = fiVar;
        fiVar.setVerticalScrollBarEnabled(false);
        fiVar.setColumnWidth(j);
        int i2 = q;
        fiVar.setHorizontalSpacing(i2);
        fiVar.setVerticalSpacing(i2);
        a aVar = new a();
        fiVar.setAdapter((ListAdapter) aVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = p;
        addView(fiVar, layoutParams);
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n, o);
        layoutParams2.gravity = 85;
        addView(imageView, layoutParams2);
        q1.a(imageView, 2, false, false);
        cq cqVar = new cq(this, aDListener, aVar, list.size());
        for (dd ddVar : list) {
            ddVar.d().Q1();
            this.d.add(new jq(cqVar, ddVar, context, new ff(ddVar.d())));
        }
    }

    /* compiled from: A */
    class a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return mq.this.d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return mq.this.d.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return (View) mq.this.d.get(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return mq.this.f;
        }
    }

    static int a(int i) {
        int i2 = j;
        return ((i - i2) / (i2 + q)) + 1;
    }

    static int b(int i) {
        int i2 = i - p;
        int i3 = m;
        return ((i2 - i3) / (i3 + q)) + 1;
    }

    f5 p() {
        return this.g;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iA = a(View.MeasureSpec.getSize(i));
        this.e.setNumColumns(iA);
        if (this.d.size() >= iA) {
            this.e.setStretchMode(1);
        } else {
            this.e.setStretchMode(0);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void preloadVideo() {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().preloadVideo();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void render() {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().render();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void destroy() {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    int a() {
        return this.f;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        this.h = viewBindStatusListener;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        if (this.i == -1) {
            this.i = 0;
            Iterator<NativeExpressADView> it = this.d.iterator();
            while (it.hasNext()) {
                int ecpm = it.next().getECPM();
                if (ecpm != -1) {
                    this.i += ecpm;
                }
            }
        }
        return this.i;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().isValid()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().sendWinNotification(i);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().sendLossNotification(i, i2, str);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().setBidECPM(i);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().setNegativeFeedbackListener(negativeFeedbackListener);
        }
    }

    void a(NativeExpressADView nativeExpressADView) {
        this.d.remove(nativeExpressADView);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().sendWinNotification(map);
        }
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        Iterator<NativeExpressADView> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().sendLossNotification(map);
        }
    }
}
