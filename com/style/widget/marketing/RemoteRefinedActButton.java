package com.style.widget.marketing;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.a.d;
import com.baidu.mobads.container.b.c;
import com.baidu.mobads.container.k;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.nativecpu.a;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.j;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.h;
import com.style.widget.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemoteRefinedActButton extends LinearLayout {
    public static final int BUTTON_ANIM_STYLE_BOUNCE = 1;
    public static final int BUTTON_ANIM_STYLE_GRADIENT = 3;
    public static final int BUTTON_ANIM_STYLE_NONE = 0;
    public static final int BUTTON_ANIM_STYLE_SWIPE = 2;
    private boolean buttonRespondMoreClicks;
    protected u downloadButton;
    private AnimatorSet mAnimatorSet;
    protected int mButtonBackgroundColor;
    protected int mButtonDownloadingBgColor;
    protected int mButtonFontSizeSp;
    protected Typeface mButtonFontTypeFace;
    protected int mButtonTextColor;
    protected Context mContext;
    private boolean mIsDestoryAnimInit;
    public boolean mIsShowDialog;
    private AbstractData mResponse;

    public RemoteRefinedActButton(Context context) {
        this(context, null, 0);
    }

    public RemoteRefinedActButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemoteRefinedActButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mButtonFontSizeSp = 12;
        this.mButtonTextColor = Color.parseColor("#F5F5F5");
        this.mButtonBackgroundColor = Color.parseColor("#3388FF");
        this.mButtonDownloadingBgColor = Color.parseColor("#D7E6FF");
        this.mIsShowDialog = false;
        this.mIsDestoryAnimInit = false;
        this.buttonRespondMoreClicks = true;
        this.mContext = context;
    }

    public void setAdData(Object obj) {
        try {
            if (obj instanceof AbstractData) {
                this.mResponse = (AbstractData) obj;
            } else {
                this.mResponse = new d(obj);
            }
            initView(this.mContext);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void initView(Context context) {
        this.mContext = context;
        initACTButton();
        applyCloudControlConfig();
        if (this.downloadButton != null && this.mResponse != null) {
            this.downloadButton.d(this.buttonRespondMoreClicks);
            this.downloadButton.setOnClickListener(new View.OnClickListener() { // from class: com.style.widget.marketing.RemoteRefinedActButton.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RemoteRefinedActButton.this.mResponse instanceof a) {
                        RemoteRefinedActButton.this.mResponse.handleClick(view, false);
                    } else {
                        RemoteRefinedActButton.this.mResponse.handleClick(view);
                    }
                }
            });
        }
    }

    public void initACTButton() {
        if (this.mResponse != null && this.downloadButton == null) {
            setOrientation(0);
            this.downloadButton = new u(this.mContext);
            this.downloadButton.a(this.mResponse.getActionText(this.mContext));
            if (this.mResponse.isDownloadApp()) {
                this.downloadButton.b(this.mResponse.getAppPackage());
                c.a().a(this.mResponse.getAppPackage(), this.downloadButton);
            }
            this.downloadButton.c(ab.a(this.mContext, 3.0f));
            this.downloadButton.b(this.mButtonBackgroundColor);
            this.downloadButton.setBackgroundColor(this.mButtonDownloadingBgColor);
            this.downloadButton.d(this.mButtonTextColor);
            this.downloadButton.e(ab.c(this.mContext, this.mButtonFontSizeSp));
            if (this.mButtonFontTypeFace != null) {
                this.downloadButton.a(this.mButtonFontTypeFace);
            }
            addView(this.downloadButton, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private void applyCloudControlConfig() {
        if (this.mResponse != null && this.downloadButton != null) {
            setClipChildren(false);
            setClipToPadding(false);
            final int btnStyleType = this.mResponse.getBtnStyleType();
            final int[] btnStyleColors = this.mResponse.getBtnStyleColors();
            this.buttonRespondMoreClicks = this.mResponse.isButtonRespondMoreClicksInDownloadScene();
            cf.a(this.downloadButton, new cf.a() { // from class: com.style.widget.marketing.RemoteRefinedActButton.2
                @Override // com.baidu.mobads.container.util.cf.a
                public void safeRun() {
                    ViewParent parent;
                    if (btnStyleType == 1) {
                        if (RemoteRefinedActButton.this.mResponse instanceof a) {
                            parent = RemoteRefinedActButton.this;
                        } else {
                            parent = RemoteRefinedActButton.this.getParent();
                        }
                        if (parent instanceof View) {
                            RemoteRefinedActButton.this.mAnimatorSet = j.a((View) parent, 1000, 333, -1, 0.97f, 0.9f);
                            return;
                        }
                        return;
                    }
                    if (btnStyleType == 2) {
                        RemoteRefinedActButton.this.mAnimatorSet = j.a(RemoteRefinedActButton.this.downloadButton, 2000, 0, -1, -1, ab.a(RemoteRefinedActButton.this.mContext, 3.0f), a.EnumC0133a.PAINT);
                    } else if (btnStyleType == 3) {
                        RemoteRefinedActButton.this.mAnimatorSet = j.a(RemoteRefinedActButton.this.downloadButton, 2000, 0, -1, ab.a(RemoteRefinedActButton.this.mContext, 3.0f), btnStyleColors, a.EnumC0133a.PAINT);
                    }
                }
            });
            k baseAdContainer = this.mResponse.getBaseAdContainer();
            if (baseAdContainer != null) {
                by.a(baseAdContainer.getAdContainerContext(), this.mResponse, (com.baidu.mobads.container.adrequest.j) null, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsDestoryAnimInit) {
            return;
        }
        stopAnim();
    }

    public void stopAnim() {
        h.a(new Runnable() { // from class: com.style.widget.marketing.RemoteRefinedActButton.3
            @Override // java.lang.Runnable
            public void run() {
                if (RemoteRefinedActButton.this.mAnimatorSet != null) {
                    RemoteRefinedActButton.this.mAnimatorSet.cancel();
                    RemoteRefinedActButton.this.mAnimatorSet = null;
                }
            }
        });
    }

    public void setButtonFontTypeFace(Typeface typeface) {
        if (typeface != null) {
            this.mButtonFontTypeFace = typeface;
        }
    }

    public void setButtonFontSizeSp(int i) {
        if (i > 0) {
            this.mButtonFontSizeSp = i;
        }
    }

    public void setButtonTextColor(int i) {
        this.mButtonTextColor = i;
        if (this.downloadButton != null) {
            this.downloadButton.d(this.mButtonTextColor);
        }
    }

    public void setButtonBackgroundColor(int i) {
        this.mButtonBackgroundColor = i;
    }

    public void setIsShowDialog(boolean z) {
        this.mIsShowDialog = z;
    }

    public void onDownloadStateChange() {
        if (this.downloadButton != null) {
            this.downloadButton.a();
        }
    }

    public void setIsDestoryAnimInit(boolean z) {
        this.mIsDestoryAnimInit = z;
    }
}
