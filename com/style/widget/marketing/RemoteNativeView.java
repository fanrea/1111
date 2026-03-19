package com.style.widget.marketing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.a.d;
import com.style.widget.a.b;
import com.style.widget.a.c;
import com.style.widget.d.a;
import com.style.widget.e.z;
import com.style.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemoteNativeView extends RelativeLayout {
    private static final String TAG = "RemoteNativeView";
    private j mBaseView;
    private Context mContext;
    private d mResponse;

    public RemoteNativeView(Context context) {
        this(context, null);
    }

    public RemoteNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemoteNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public void setAdResponse(Object obj) {
        this.mResponse = new d(obj);
        optViewStyle();
        if (this.mBaseView != null) {
            this.mBaseView.a(this.mResponse);
        }
        handleCloudConfig();
        initChildClickEvent();
    }

    private void initChildClickEvent() {
        if (this.mBaseView == null || this.mResponse == null) {
            return;
        }
        if (this.mBaseView.aZ != null) {
            this.mBaseView.aZ.setOnClickListener(new View.OnClickListener() { // from class: com.style.widget.marketing.RemoteNativeView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RemoteNativeView.this.mResponse.handleClick(view);
                }
            });
        }
        if (this.mBaseView.ba != null) {
            this.mBaseView.ba.setOnClickListener(new View.OnClickListener() { // from class: com.style.widget.marketing.RemoteNativeView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RemoteNativeView.this.mResponse.handleClick(view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleCloudConfig() {
        if (this.mBaseView == null || this.mResponse == null) {
            return;
        }
        boolean z = this.mBaseView.L;
        int iM = this.mResponse.m();
        if (iM != 2) {
            this.mBaseView.L = iM == 1;
            if (this.mBaseView.as != null) {
                this.mBaseView.as.c(this.mBaseView.L);
                this.mBaseView.as.h(this.mBaseView.M);
            }
            z = iM;
        }
        if (!z) {
            this.mBaseView.setOnClickListener(new View.OnClickListener() { // from class: com.style.widget.marketing.RemoteNativeView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RemoteNativeView.this.mResponse.handleClick(view, RemoteNativeView.this.mBaseView.M);
                }
            });
        } else {
            this.mBaseView.setOnClickListener(new View.OnClickListener() { // from class: com.style.widget.marketing.RemoteNativeView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
    }

    public void changeLayoutParams(Object obj) {
        if (this.mBaseView != null) {
            this.mBaseView.a(obj);
            this.mBaseView.a(this.mResponse);
        }
        handleCloudConfig();
    }

    private void optViewStyle() {
        if (this.mResponse == null) {
            return;
        }
        switch (this.mResponse.getStyleType()) {
            case 28:
                this.mBaseView = new b(this.mContext, this.mResponse);
                break;
            case 29:
                this.mBaseView = new com.style.widget.a.d(this.mContext, this.mResponse);
                break;
            case 30:
                this.mBaseView = new c(this.mContext, this.mResponse);
                break;
            case 33:
                this.mBaseView = new a(this.mContext, this.mResponse);
                break;
            case 34:
                this.mBaseView = new com.style.widget.d.b(this.mContext, this.mResponse);
                break;
            case 35:
                this.mBaseView = new com.style.widget.c.c(this.mContext, this.mResponse);
                break;
            case 36:
                this.mBaseView = new com.style.widget.c.b(this.mContext, this.mResponse);
                break;
            case 37:
                this.mBaseView = new z(this.mContext, this.mResponse);
                break;
        }
        if (this.mBaseView != null) {
            addView(this.mBaseView);
        }
    }

    public int getAdContainerWidth() {
        if (this.mBaseView != null) {
            return this.mBaseView.I;
        }
        return 0;
    }

    public int getAdContainerHeight() {
        if (this.mBaseView != null) {
            return this.mBaseView.J;
        }
        return 0;
    }

    public RelativeLayout getAdView() {
        return this.mBaseView;
    }

    private void sendTypeLog() {
    }
}
