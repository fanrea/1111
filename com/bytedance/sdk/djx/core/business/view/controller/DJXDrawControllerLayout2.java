package com.bytedance.sdk.djx.core.business.view.controller;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.alipay.sdk.m.p0.b;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout;
import com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout;
import com.bytedance.sdk.djx.core.business.view.like.DJXLikeButton;
import com.bytedance.sdk.djx.core.business.view.like.OnLikeListener;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.ev.BEDramaFavorAction;
import com.bytedance.sdk.djx.model.ev.BEDramaLikeAction;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DJXDrawControllerLayout2.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001JB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u00100\u001a\u000201J\b\u00102\u001a\u000201H\u0014J\b\u00103\u001a\u000201H\u0014J\b\u00104\u001a\u000201H\u0016J\b\u00105\u001a\u000201H\u0014J\b\u00106\u001a\u000201H\u0002J\u0006\u00107\u001a\u000201J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u001bH\u0002J\u0010\u0010:\u001a\u0002012\u0006\u00109\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010*J\b\u0010=\u001a\u00020\bH\u0014J\u000e\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u001bJ\u000e\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\u001bJ\u0010\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020\u001bH\u0002J\u0010\u0010D\u001a\u0002012\u0006\u0010C\u001a\u00020\u001bH\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\b\u0010H\u001a\u000201H\u0002J\u0006\u0010I\u001a\u000201R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR&\u0010\"\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/view/controller/DJXDrawControllerLayout2;", "Lcom/bytedance/sdk/djx/core/business/base/BaseLifecycleLayout;", "Lcom/bytedance/sdk/djx/core/business/view/controller/DJXDrawControllerParam;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnFavor", "Lcom/bytedance/sdk/djx/core/business/view/like/DJXLikeButton;", "btnLike", "busListener", "Lcom/bytedance/sdk/djx/utils/bus/IBusListener;", "dramaDetail", "Lcom/bytedance/sdk/djx/model/DramaDetail;", "getDramaDetail", "()Lcom/bytedance/sdk/djx/model/DramaDetail;", "setDramaDetail", "(Lcom/bytedance/sdk/djx/model/DramaDetail;)V", b.d, "favorCount", "getFavorCount", "()I", "setFavorCount", "(I)V", "", "isFavor", "()Z", "setFavor", "(Z)V", "isLiked", "setLiked", "likeCount", "getLikeCount", "setLikeCount", "mCanShowLikeAnim", "mIsSpeedPlaying", "mLikeAnimLayout", "Lcom/bytedance/sdk/djx/core/business/view/like/DJXLikeAnimLayout;", "mListener", "Lcom/bytedance/sdk/djx/core/business/view/controller/OnControllerClickListener;", "mLongClickSpeedPlayEnable", "tvFavor", "Landroid/widget/TextView;", "tvLike", "tvSpeed", "clickLike", "", "initData", "initView", "onDestroy", "processLogic", "release", "reset", "sendFavorActionEvent", "state", "sendLikeActionEvent", "setClickListener", "listener", "setLayoutId", "setLikeAnimVisible", "visible", "setLongClickSpeedPlayEnable", "enable", "toggleFavorButton", "isChecked", "toggleLikeButton", "updateFavorButton", "updateFavorText", "updateLikeButton", "updateLikeNum", "updateUI", "Companion", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXDrawControllerLayout2 extends BaseLifecycleLayout<DJXDrawControllerParam> {
    public static final String TAG = "DJXDrawControllerLayout2";
    public Map<Integer, View> _$_findViewCache;
    private DJXLikeButton btnFavor;
    private DJXLikeButton btnLike;
    private final IBusListener busListener;
    private DramaDetail dramaDetail;
    private int favorCount;
    private boolean isFavor;
    private boolean isLiked;
    private int likeCount;
    private boolean mCanShowLikeAnim;
    private boolean mIsSpeedPlaying;
    private DJXLikeAnimLayout mLikeAnimLayout;
    private OnControllerClickListener mListener;
    private boolean mLongClickSpeedPlayEnable;
    private TextView tvFavor;
    private TextView tvLike;
    private TextView tvSpeed;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DJXDrawControllerLayout2(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DJXDrawControllerLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        if (viewFindViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    protected void initData() {
    }

    public /* synthetic */ DJXDrawControllerLayout2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DJXDrawControllerLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.busListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$$ExternalSyntheticLambda0
            public final void onBusEvent(BusEvent busEvent) {
                DJXDrawControllerLayout2.m360busListener$lambda0(this.f$0, busEvent);
            }
        };
        this.mCanShowLikeAnim = true;
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: busListener$lambda-0, reason: not valid java name */
    public static final void m360busListener$lambda0(DJXDrawControllerLayout2 dJXDrawControllerLayout2, BusEvent busEvent) {
        Drama drama;
        Drama drama2;
        Intrinsics.checkNotNullParameter(dJXDrawControllerLayout2, "this$0");
        boolean z = false;
        if (busEvent instanceof BEDramaLikeAction) {
            DramaDetail dramaDetail = dJXDrawControllerLayout2.dramaDetail;
            if ((dramaDetail == null || (drama2 = dramaDetail.getDrama()) == null || drama2.id != ((BEDramaLikeAction) busEvent).getDramaId()) ? false : true) {
                DramaDetail dramaDetail2 = dJXDrawControllerLayout2.dramaDetail;
                if (dramaDetail2 != null && dramaDetail2.getIndex() == ((BEDramaLikeAction) busEvent).getDramaIndex()) {
                    z = true;
                }
                if (z) {
                    BEDramaLikeAction bEDramaLikeAction = (BEDramaLikeAction) busEvent;
                    if (dJXDrawControllerLayout2.isLiked() != bEDramaLikeAction.isLiked()) {
                        dJXDrawControllerLayout2.setLiked(bEDramaLikeAction.isLiked());
                        dJXDrawControllerLayout2.setLikeCount(bEDramaLikeAction.isLiked() ? dJXDrawControllerLayout2.getLikeCount() + 1 : dJXDrawControllerLayout2.getLikeCount() - 1);
                        dJXDrawControllerLayout2.updateLikeButton();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (busEvent instanceof BEDramaFavorAction) {
            DramaDetail dramaDetail3 = dJXDrawControllerLayout2.dramaDetail;
            if (dramaDetail3 != null && (drama = dramaDetail3.getDrama()) != null && drama.id == ((BEDramaFavorAction) busEvent).getDramaId()) {
                z = true;
            }
            if (z) {
                BEDramaFavorAction bEDramaFavorAction = (BEDramaFavorAction) busEvent;
                if (dJXDrawControllerLayout2.isFavor() != bEDramaFavorAction.isFavor()) {
                    dJXDrawControllerLayout2.setFavor(bEDramaFavorAction.isFavor());
                    dJXDrawControllerLayout2.setFavorCount(bEDramaFavorAction.isFavor() ? dJXDrawControllerLayout2.getFavorCount() + 1 : dJXDrawControllerLayout2.getFavorCount() - 1);
                    dJXDrawControllerLayout2.updateFavorButton();
                }
            }
        }
    }

    public final DramaDetail getDramaDetail() {
        return this.dramaDetail;
    }

    public final void setDramaDetail(DramaDetail dramaDetail) {
        this.dramaDetail = dramaDetail;
    }

    private final int getLikeCount() {
        DramaDetail dramaDetail = this.dramaDetail;
        Integer numValueOf = dramaDetail == null ? null : Integer.valueOf(dramaDetail.getLikeCount());
        return numValueOf == null ? this.likeCount : numValueOf.intValue();
    }

    private final synchronized void setLikeCount(int i) {
        DramaDetail dramaDetail = this.dramaDetail;
        if (dramaDetail == null) {
            dramaDetail = null;
        } else {
            dramaDetail.setLikeCount(i);
        }
        if (dramaDetail == null) {
            DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this;
            this.likeCount = i;
        }
    }

    private final boolean isLiked() {
        DramaDetail dramaDetail = this.dramaDetail;
        Boolean boolValueOf = dramaDetail == null ? null : Boolean.valueOf(dramaDetail.isLiked());
        return boolValueOf == null ? this.isLiked : boolValueOf.booleanValue();
    }

    private final synchronized void setLiked(boolean z) {
        DramaDetail dramaDetail = this.dramaDetail;
        if (dramaDetail == null) {
            dramaDetail = null;
        } else {
            dramaDetail.setIsLiked(z);
        }
        if (dramaDetail == null) {
            DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this;
            this.isLiked = z;
        }
    }

    private final int getFavorCount() {
        Drama drama;
        DramaDetail dramaDetail = this.dramaDetail;
        Integer numValueOf = null;
        if (dramaDetail != null && (drama = dramaDetail.getDrama()) != null) {
            numValueOf = Integer.valueOf(drama.favoriteCount);
        }
        return numValueOf == null ? this.favorCount : numValueOf.intValue();
    }

    private final synchronized void setFavorCount(int i) {
        Drama drama;
        DramaDetail dramaDetail = this.dramaDetail;
        Drama drama2 = null;
        if (dramaDetail != null && (drama = dramaDetail.getDrama()) != null) {
            drama.favoriteCount = i;
            drama2 = drama;
        }
        if (drama2 == null) {
            DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this;
            this.favorCount = i;
        }
    }

    private final boolean isFavor() {
        Drama drama;
        DramaDetail dramaDetail = this.dramaDetail;
        Boolean boolValueOf = null;
        if (dramaDetail != null && (drama = dramaDetail.getDrama()) != null) {
            boolValueOf = Boolean.valueOf(drama.isFavor);
        }
        return boolValueOf == null ? this.isFavor : boolValueOf.booleanValue();
    }

    private final synchronized void setFavor(boolean z) {
        Drama drama;
        DramaDetail dramaDetail = this.dramaDetail;
        Drama drama2 = null;
        if (dramaDetail != null && (drama = dramaDetail.getDrama()) != null) {
            drama.isFavor = z;
            drama2 = drama;
        }
        if (drama2 == null) {
            DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this;
            this.isFavor = z;
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    protected int setLayoutId() {
        return R.layout.djx_view_controller_layout2;
    }

    public final void setClickListener(OnControllerClickListener listener) {
        this.mListener = listener;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    protected void initView() {
        this.tvFavor = (TextView) findView(R.id.djx_tv_draw_favor);
        this.mLikeAnimLayout = (DJXLikeAnimLayout) findView(R.id.djx_draw_item_like_anim_layout);
        DJXLikeButton dJXLikeButton = (DJXLikeButton) findView(R.id.djx_btn_draw_favor);
        dJXLikeButton.setAnimColor(Color.parseColor("#FACE15"));
        dJXLikeButton.setOnLikeListener(new OnLikeListener() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$initView$1$1
            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public boolean onIntercept(DJXLikeButton likeButton) {
                Intrinsics.checkNotNullParameter(likeButton, "likeButton");
                return false;
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void liked(DJXLikeButton likeButton) {
                final Drama drama;
                Intrinsics.checkNotNullParameter(likeButton, "likeButton");
                this.this$0.toggleFavorButton(true);
                DramaDetail dramaDetail = this.this$0.getDramaDetail();
                if (dramaDetail == null || (drama = dramaDetail.getDrama()) == null) {
                    return;
                }
                final DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this.this$0;
                ApiManager.postFavorDrama(drama.id, 1, true, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$initView$1$1$liked$1$1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(DramaActionRsp data) {
                        dJXDrawControllerLayout2.sendFavorActionEvent(true);
                        LG.i(DJXDrawControllerLayout2.TAG, Intrinsics.stringPlus("User favor drama success, id=", Long.valueOf(drama.id)));
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError error, DramaActionRsp data) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        dJXDrawControllerLayout2.toggleFavorButton(false);
                        LG.i(DJXDrawControllerLayout2.TAG, Intrinsics.stringPlus("User favor drama failure, id=", Long.valueOf(drama.id)));
                        ToastUtil.show(InnerManager.getContext(), "网络异常，请稍后重试");
                    }
                });
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void unLiked(DJXLikeButton likeButton) {
                final Drama drama;
                Intrinsics.checkNotNullParameter(likeButton, "likeButton");
                this.this$0.toggleFavorButton(false);
                DramaDetail dramaDetail = this.this$0.getDramaDetail();
                if (dramaDetail == null || (drama = dramaDetail.getDrama()) == null) {
                    return;
                }
                final DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this.this$0;
                ApiManager.postFavorDrama(drama.id, 1, false, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$initView$1$1$unLiked$1$1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(DramaActionRsp data) {
                        dJXDrawControllerLayout2.sendFavorActionEvent(false);
                        LG.i(DJXDrawControllerLayout2.TAG, Intrinsics.stringPlus("User cancel favor drama success, id=", Long.valueOf(drama.id)));
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError error, DramaActionRsp data) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        dJXDrawControllerLayout2.toggleFavorButton(true);
                        LG.i(DJXDrawControllerLayout2.TAG, Intrinsics.stringPlus("User cancel favor drama failure, id=", Long.valueOf(drama.id)));
                        ToastUtil.show(InnerManager.getContext(), "网络异常，请稍后重试");
                    }
                });
            }
        });
        this.btnFavor = dJXLikeButton;
        this.tvLike = (TextView) findView(R.id.djx_tv_draw_like_num);
        DJXLikeButton dJXLikeButton2 = (DJXLikeButton) findView(R.id.djx_btn_draw_like);
        dJXLikeButton2.setAnimColor(Color.parseColor("#FC3B65"));
        dJXLikeButton2.setOnLikeListener(new OnLikeListener() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$initView$2$1
            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public boolean onIntercept(DJXLikeButton likeButton) {
                Intrinsics.checkNotNullParameter(likeButton, "likeButton");
                return false;
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void liked(DJXLikeButton likeButton) {
                Intrinsics.checkNotNullParameter(likeButton, "likeButton");
                this.this$0.toggleLikeButton(true);
                final DramaDetail dramaDetail = this.this$0.getDramaDetail();
                if (dramaDetail == null) {
                    return;
                }
                final DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this.this$0;
                final Drama drama = dramaDetail.getDrama();
                if (drama == null) {
                    return;
                }
                ApiManager.postLikeDrama(drama.id, dramaDetail.getIndex(), true, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$initView$2$1$liked$1$1$1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(DramaActionRsp data) {
                        dJXDrawControllerLayout2.sendLikeActionEvent(true);
                        LG.i(DJXDrawControllerLayout2.TAG, "User like drama success, id=" + drama.id + ", index=" + dramaDetail.getIndex());
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError error, DramaActionRsp data) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        dJXDrawControllerLayout2.toggleLikeButton(false);
                        LG.i(DJXDrawControllerLayout2.TAG, "User like drama failure, id=" + drama.id + ", index=" + dramaDetail.getIndex());
                        ToastUtil.show(InnerManager.getContext(), "网络异常，请稍后重试");
                    }
                });
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void unLiked(DJXLikeButton likeButton) {
                Intrinsics.checkNotNullParameter(likeButton, "likeButton");
                this.this$0.toggleLikeButton(false);
                final DramaDetail dramaDetail = this.this$0.getDramaDetail();
                if (dramaDetail == null) {
                    return;
                }
                final DJXDrawControllerLayout2 dJXDrawControllerLayout2 = this.this$0;
                final Drama drama = dramaDetail.getDrama();
                if (drama == null) {
                    return;
                }
                ApiManager.postLikeDrama(drama.id, dramaDetail.getIndex(), false, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2$initView$2$1$unLiked$1$1$1
                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiSuccess(DramaActionRsp data) {
                        dJXDrawControllerLayout2.sendLikeActionEvent(false);
                        LG.i(DJXDrawControllerLayout2.TAG, "User cancel like drama success, id=" + drama.id + ", index=" + dramaDetail.getIndex());
                    }

                    @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                    public void onApiFailure(DJXError error, DramaActionRsp data) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        dJXDrawControllerLayout2.toggleLikeButton(true);
                        LG.i(DJXDrawControllerLayout2.TAG, "User cancel like drama failure, id=" + drama.id + ", index=" + dramaDetail.getIndex());
                        ToastUtil.show(InnerManager.getContext(), "网络异常，请稍后重试");
                    }
                });
            }
        });
        this.btnLike = dJXLikeButton2;
        DJXLikeAnimLayout dJXLikeAnimLayout = this.mLikeAnimLayout;
        if (dJXLikeAnimLayout == null) {
            return;
        }
        dJXLikeAnimLayout.setListener(new DJXLikeAnimLayout.LikeAnimListener() { // from class: com.bytedance.sdk.djx.core.business.view.controller.DJXDrawControllerLayout2.initView.3
            @Override // com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.LikeAnimListener
            public void onSingleTab() {
                if (DJXDrawControllerLayout2.this.mIsSpeedPlaying) {
                    OnControllerClickListener onControllerClickListener = DJXDrawControllerLayout2.this.mListener;
                    if (onControllerClickListener != null) {
                        onControllerClickListener.stopLongClick();
                    }
                    DJXDrawControllerLayout2.this.mIsSpeedPlaying = false;
                    return;
                }
                OnControllerClickListener onControllerClickListener2 = DJXDrawControllerLayout2.this.mListener;
                if (onControllerClickListener2 == null) {
                    return;
                }
                onControllerClickListener2.onSingleTab();
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.LikeAnimListener
            public void onDoubleTab() {
                if (DJXDrawControllerLayout2.this.mCanShowLikeAnim) {
                    DJXDrawControllerLayout2.this.clickLike();
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.LikeAnimListener
            public void onLongClick() {
                if (DJXDrawControllerLayout2.this.mLongClickSpeedPlayEnable) {
                    OnControllerClickListener onControllerClickListener = DJXDrawControllerLayout2.this.mListener;
                    if (onControllerClickListener != null) {
                        onControllerClickListener.startLongClick();
                    }
                    DJXDrawControllerLayout2.this.mIsSpeedPlaying = true;
                }
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.LikeAnimListener
            public void onLongClickCancel() {
                if (DJXDrawControllerLayout2.this.mIsSpeedPlaying) {
                    OnControllerClickListener onControllerClickListener = DJXDrawControllerLayout2.this.mListener;
                    if (onControllerClickListener != null) {
                        onControllerClickListener.stopLongClick();
                    }
                    DJXDrawControllerLayout2.this.mIsSpeedPlaying = false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout
    protected void processLogic() {
        updateLikeButton();
        updateFavorButton();
        DJXDrawControllerParam widgetParam = getWidgetParam();
        boolean z = false;
        if (widgetParam != null && widgetParam.getHideLikeBtn()) {
            ((Group) findView(R.id.djx_group_draw_like)).setVisibility(8);
        }
        DJXDrawControllerParam widgetParam2 = getWidgetParam();
        if (widgetParam2 != null && widgetParam2.getHideFavorBtn()) {
            z = true;
        }
        if (z) {
            ((Group) findView(R.id.djx_group_draw_favor)).setVisibility(8);
        }
        DJXBus.getInstance().addListener(this.busListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleLikeButton(boolean isChecked) {
        int likeCount = getLikeCount();
        setLikeCount(isChecked ? likeCount + 1 : likeCount - 1);
        setLiked(isChecked);
        updateLikeButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleFavorButton(boolean isChecked) {
        int favorCount = getFavorCount();
        setFavorCount(isChecked ? favorCount + 1 : favorCount - 1);
        setFavor(isChecked);
        updateFavorButton();
    }

    private final void updateLikeButton() {
        DJXLikeButton dJXLikeButton = this.btnLike;
        if (dJXLikeButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLike");
            dJXLikeButton = null;
        }
        dJXLikeButton.setLiked(isLiked());
        updateLikeNum();
    }

    private final void updateFavorButton() {
        DJXLikeButton dJXLikeButton = this.btnFavor;
        if (dJXLikeButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFavor");
            dJXLikeButton = null;
        }
        dJXLikeButton.setLiked(isFavor());
        updateFavorText();
    }

    private final void updateLikeNum() {
        TextView textView = this.tvLike;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLike");
            textView = null;
        }
        textView.setText(ToolUtils.likeCountConvert(getLikeCount(), 2));
    }

    private final void updateFavorText() {
        TextView textView = this.tvFavor;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFavor");
            textView = null;
        }
        textView.setText(isFavor() ? R.string.djx_drama_is_favor_text : R.string.djx_drama_favor_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendLikeActionEvent(boolean state) {
        Drama drama;
        DramaDetail dramaDetail = this.dramaDetail;
        if (dramaDetail == null || (drama = dramaDetail.getDrama()) == null) {
            return;
        }
        DJXBus.getInstance().sendEvent(new BEDramaLikeAction(drama.id, dramaDetail.getIndex(), state));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendFavorActionEvent(boolean state) {
        Drama drama;
        DramaDetail dramaDetail = this.dramaDetail;
        if (dramaDetail == null || (drama = dramaDetail.getDrama()) == null) {
            return;
        }
        DJXBus.getInstance().sendEvent(new BEDramaFavorAction(drama.id, state));
    }

    @Override // com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout, com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    public void onDestroy() {
        super.onDestroy();
        release();
    }

    private final void release() {
        DJXBus.getInstance().removeListener(this.busListener);
        DJXLikeButton dJXLikeButton = this.btnLike;
        DJXLikeButton dJXLikeButton2 = null;
        if (dJXLikeButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLike");
            dJXLikeButton = null;
        }
        dJXLikeButton.release();
        DJXLikeButton dJXLikeButton3 = this.btnFavor;
        if (dJXLikeButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFavor");
        } else {
            dJXLikeButton2 = dJXLikeButton3;
        }
        dJXLikeButton2.release();
    }

    public final void reset() {
        this.dramaDetail = null;
        updateUI();
    }

    public final void updateUI() {
        updateLikeButton();
        updateFavorButton();
    }

    public final void clickLike() {
        if (isLiked()) {
            return;
        }
        DJXLikeButton dJXLikeButton = this.btnLike;
        if (dJXLikeButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLike");
            dJXLikeButton = null;
        }
        dJXLikeButton.clickBtn();
    }

    public final void setLikeAnimVisible(boolean visible) {
        DJXLikeAnimLayout dJXLikeAnimLayout = this.mLikeAnimLayout;
        if (dJXLikeAnimLayout != null) {
            dJXLikeAnimLayout.setCanShowLikeAnim(visible);
        }
        this.mCanShowLikeAnim = visible;
    }

    public final void setLongClickSpeedPlayEnable(boolean enable) {
        this.mLongClickSpeedPlayEnable = enable;
    }
}
