package com.bytedance.sdk.djx.core.business.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2;
import com.bytedance.sdk.djx.core.business.view.like.DJXLikeButton;
import com.bytedance.sdk.djx.core.business.view.like.OnLikeListener;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawAdCommLayout extends FrameLayout {
    private View.OnClickListener mClickComment;
    private DrawAdapter2.OnClickDrawListener mClickDrawListener;
    private RelativeLayout mControlLayout;
    private DJXCircleImage mImgAvatar;
    private TextView mImgAvatarTag;
    private ImageView mImgShare;
    private ImageView mIvComment;
    private DJXLikeButton mLikeButton;
    private int mLikeCount;
    private DJXLiveCircleView mLiveCircleView;
    private LinearLayout mMarqueeLayout;
    private DJXMarqueeView mMarqueeView;
    private DJXMusicLayout mMusicLayout;
    private View.OnClickListener mOnClickShare;
    private Random mRandom;
    private TextView mTvComment;
    private TextView mTvLike;
    private TextView mTvShare;

    static /* synthetic */ int access$108(DJXDrawAdCommLayout dJXDrawAdCommLayout) {
        int i = dJXDrawAdCommLayout.mLikeCount;
        dJXDrawAdCommLayout.mLikeCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$110(DJXDrawAdCommLayout dJXDrawAdCommLayout) {
        int i = dJXDrawAdCommLayout.mLikeCount;
        dJXDrawAdCommLayout.mLikeCount = i - 1;
        return i;
    }

    public DJXDrawAdCommLayout(Context context) {
        super(context);
        this.mRandom = new Random();
        this.mLikeCount = 0;
        this.mClickComment = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtil.show(view.getContext(), view.getResources().getString(R.string.djx_str_no_comment_tip));
            }
        };
        this.mOnClickShare = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawAdCommLayout.this.mClickDrawListener != null) {
                    DJXDrawAdCommLayout.this.mClickDrawListener.onClickShare(view, null);
                }
            }
        };
        init(context);
    }

    public DJXDrawAdCommLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRandom = new Random();
        this.mLikeCount = 0;
        this.mClickComment = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtil.show(view.getContext(), view.getResources().getString(R.string.djx_str_no_comment_tip));
            }
        };
        this.mOnClickShare = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawAdCommLayout.this.mClickDrawListener != null) {
                    DJXDrawAdCommLayout.this.mClickDrawListener.onClickShare(view, null);
                }
            }
        };
        init(context);
    }

    public DJXDrawAdCommLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRandom = new Random();
        this.mLikeCount = 0;
        this.mClickComment = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtil.show(view.getContext(), view.getResources().getString(R.string.djx_str_no_comment_tip));
            }
        };
        this.mOnClickShare = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawAdCommLayout.this.mClickDrawListener != null) {
                    DJXDrawAdCommLayout.this.mClickDrawListener.onClickShare(view, null);
                }
            }
        };
        init(context);
    }

    public DJXDrawAdCommLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mRandom = new Random();
        this.mLikeCount = 0;
        this.mClickComment = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtil.show(view.getContext(), view.getResources().getString(R.string.djx_str_no_comment_tip));
            }
        };
        this.mOnClickShare = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawAdCommLayout.this.mClickDrawListener != null) {
                    DJXDrawAdCommLayout.this.mClickDrawListener.onClickShare(view, null);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.djx_view_draw_ad_comm_layout, this);
        this.mControlLayout = (RelativeLayout) findViewById(R.id.djx_draw_item_ad_comm_content_layout);
        this.mMusicLayout = (DJXMusicLayout) findViewById(R.id.djx_draw_item_ad_music_layout);
        this.mIvComment = (ImageView) findViewById(R.id.djx_draw_item_ad_comment_icon);
        this.mTvComment = (TextView) findViewById(R.id.djx_draw_item_ad_comment);
        this.mImgShare = (ImageView) findViewById(R.id.djx_draw_item_ad_share_icon);
        this.mTvShare = (TextView) findViewById(R.id.djx_draw_item_ad_share);
        this.mLikeButton = (DJXLikeButton) findViewById(R.id.djx_draw_item_ad_like_button);
        this.mTvLike = (TextView) findViewById(R.id.djx_draw_item_ad_like);
        this.mMarqueeView = (DJXMarqueeView) findViewById(R.id.djx_draw_item_ad_music_name);
        this.mMarqueeLayout = (LinearLayout) findViewById(R.id.djx_draw_item_ad_music_name_layout);
        this.mImgAvatar = (DJXCircleImage) findViewById(R.id.djx_draw_item_ad_avatar);
        this.mImgAvatarTag = (TextView) findViewById(R.id.djx_live_tag);
        this.mLiveCircleView = (DJXLiveCircleView) findViewById(R.id.djx_iv_live_circle);
        this.mIvComment.setOnClickListener(this.mClickComment);
        this.mTvComment.setOnClickListener(this.mClickComment);
        this.mTvLike.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawAdCommLayout.this.mLikeButton != null) {
                    DJXDrawAdCommLayout.this.mLikeButton.performClick();
                }
            }
        });
        this.mTvShare.setOnClickListener(this.mOnClickShare);
        this.mImgShare.setOnClickListener(this.mOnClickShare);
        this.mLikeButton.setOnLikeListener(new OnLikeListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawAdCommLayout.2
            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public boolean onIntercept(DJXLikeButton dJXLikeButton) {
                return false;
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void liked(DJXLikeButton dJXLikeButton) {
                DJXDrawAdCommLayout.access$108(DJXDrawAdCommLayout.this);
                DJXDrawAdCommLayout.this.updateLikeNum();
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void unLiked(DJXLikeButton dJXLikeButton) {
                DJXDrawAdCommLayout.access$110(DJXDrawAdCommLayout.this);
                DJXDrawAdCommLayout.this.updateLikeNum();
            }
        });
        updateBtnStatus();
    }

    public void setClickDrawListener(DrawAdapter2.OnClickDrawListener onClickDrawListener) {
        this.mClickDrawListener = onClickDrawListener;
    }

    public void refreshUI(int i) {
        updateBtnStatus();
        setBottomOffset(i, 0);
        this.mLikeCount = randomLikeNum();
        updateLikeNum();
        this.mLikeButton.setLiked(false);
        this.mTvShare.setText(R.string.djx_str_share_tag1);
    }

    public void start() {
        this.mMusicLayout.getIconView().setImageResource(R.drawable.djx_logo_pangle);
        this.mMusicLayout.start();
        this.mMarqueeView.setTextSize(SettingData.getInstance().getDrawMusicSize());
        this.mMarqueeView.setText("@穿山甲创作的原声");
        this.mMarqueeView.startMarquee();
    }

    public void release() {
        DJXMusicLayout dJXMusicLayout = this.mMusicLayout;
        if (dJXMusicLayout != null) {
            dJXMusicLayout.stop();
        }
        DJXMarqueeView dJXMarqueeView = this.mMarqueeView;
        if (dJXMarqueeView != null) {
            dJXMarqueeView.stopMarquee();
        }
    }

    private void updateBtnStatus() {
        boolean zIsEnableLike = SettingData.getInstance().isEnableLike();
        boolean zIsEnableShare = SettingData.getInstance().isEnableShare();
        boolean zIsEnableComment = SettingData.getInstance().isEnableComment();
        boolean zIsEnableMusicTurnTable = SettingData.getInstance().isEnableMusicTurnTable();
        if (zIsEnableLike) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mIvComment.getLayoutParams();
            marginLayoutParams.topMargin = UIUtil.dp2px(14.0f);
            this.mIvComment.setLayoutParams(marginLayoutParams);
            this.mTvLike.setVisibility(0);
            this.mLikeButton.setVisibility(0);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mIvComment.getLayoutParams();
            marginLayoutParams2.topMargin = 0;
            this.mIvComment.setLayoutParams(marginLayoutParams2);
            this.mTvLike.setVisibility(8);
            this.mLikeButton.setVisibility(8);
        }
        if (zIsEnableComment) {
            this.mTvComment.setVisibility(0);
            this.mIvComment.setVisibility(0);
        } else {
            this.mTvComment.setVisibility(8);
            this.mIvComment.setVisibility(8);
        }
        if (zIsEnableShare) {
            this.mTvShare.setVisibility(0);
            this.mImgShare.setVisibility(0);
        } else {
            this.mTvShare.setVisibility(8);
            this.mImgShare.setVisibility(8);
        }
        if (zIsEnableMusicTurnTable) {
            this.mMusicLayout.setVisibility(0);
            this.mMarqueeLayout.setVisibility(0);
        } else {
            this.mMusicLayout.setVisibility(8);
            this.mMarqueeLayout.setVisibility(8);
        }
    }

    public void setBottomOffset(int i, int i2) {
        int iDp2px = UIUtil.dp2px(i);
        if (iDp2px < 0) {
            iDp2px = 0;
        }
        int iMin = Math.min(iDp2px, UIUtil.getScreenHeight(InnerManager.getContext()) / 2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMarqueeLayout.getLayoutParams();
        marginLayoutParams.bottomMargin = (iMin - UIUtil.dp2px(8.0f)) + UIUtil.dp2px(i2);
        this.mMarqueeLayout.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mMusicLayout.getLayoutParams();
        marginLayoutParams2.bottomMargin = iMin;
        this.mMusicLayout.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLikeNum() {
        TextView textView = this.mTvLike;
        if (textView != null) {
            textView.setText(ToolUtils.likeCountConvert(this.mLikeCount, 2));
        }
    }

    public void setMarqueeVisible(boolean z) {
        if (this.mMarqueeLayout != null) {
            if (z && SettingData.getInstance().isEnableMusicTurnTable()) {
                this.mMarqueeLayout.setVisibility(0);
            } else {
                this.mMarqueeLayout.setVisibility(8);
            }
        }
    }

    public DJXCircleImage getAvatarView() {
        return this.mImgAvatar;
    }

    public ImageView getMusicImgView() {
        DJXMusicLayout dJXMusicLayout = this.mMusicLayout;
        if (dJXMusicLayout != null) {
            return dJXMusicLayout.getIconView();
        }
        return null;
    }

    public void startAvatarAnimation() {
        this.mImgAvatarTag.setVisibility(0);
        this.mLiveCircleView.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mImgAvatar, "scaleX", 1.05f, 0.9f).setDuration(500L);
        duration.setRepeatMode(2);
        duration.setRepeatCount(-1);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mImgAvatar, "scaleY", 1.05f, 0.9f).setDuration(500L);
        duration2.setRepeatMode(2);
        duration2.setRepeatCount(-1);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mLiveCircleView, "alpha", 0.5f, 1.0f).setDuration(500L);
        duration3.setRepeatMode(2);
        duration3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
    }

    private int randomLikeNum() {
        int iNextInt = this.mRandom.nextInt(100);
        if (iNextInt < 5) {
            return this.mRandom.nextInt(900001) + KSTubeParamInner.FREE_ALL;
        }
        if (iNextInt < 20) {
            return this.mRandom.nextInt(1001);
        }
        if (iNextInt < 40) {
            return this.mRandom.nextInt(90001) + 10000;
        }
        return this.mRandom.nextInt(9001) + 1000;
    }
}
