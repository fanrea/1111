package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXInterceptLinearLayout extends LinearLayout {
    private static final String TAG = "DJXInterceptLayout";
    private float mDownY;
    private OnInterceptListener mOnInterceptListener;

    public interface OnInterceptListener {
        boolean needIntercept();
    }

    public DJXInterceptLinearLayout(Context context) {
        super(context);
    }

    public DJXInterceptLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJXInterceptLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onInterceptTouchEvent: "
            java.lang.StringBuilder r0 = r0.append(r1)
            int r2 = r7.getAction()
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "DJXInterceptLayout"
            android.util.Log.d(r2, r0)
            r7.getX()
            float r0 = r7.getY()
            int r0 = (int) r0
            int r7 = r7.getAction()
            r3 = 1
            r4 = 0
            if (r7 == 0) goto L4a
            if (r7 == r3) goto L31
            r5 = 2
            if (r7 == r5) goto L33
        L31:
            r7 = r4
            goto L4e
        L33:
            float r7 = (float) r0
            float r0 = r6.mDownY
            float r7 = r7 - r0
            android.content.Context r0 = r6.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 <= 0) goto L31
            r7 = r3
            goto L4e
        L4a:
            float r7 = (float) r0
            r6.mDownY = r7
            goto L31
        L4e:
            com.bytedance.sdk.djx.core.business.view.DJXInterceptLinearLayout$OnInterceptListener r0 = r6.mOnInterceptListener
            if (r0 == 0) goto L5d
            if (r7 == 0) goto L5b
            boolean r7 = r0.needIntercept()
            if (r7 == 0) goto L5b
            goto L5c
        L5b:
            r3 = r4
        L5c:
            r7 = r3
        L5d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.DJXInterceptLinearLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnInterceptListener(OnInterceptListener onInterceptListener) {
        this.mOnInterceptListener = onInterceptListener;
    }
}
