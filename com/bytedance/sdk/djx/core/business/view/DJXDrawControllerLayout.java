package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.djx.core.business.budrama.draw.DrawAdapter2;
import com.bytedance.sdk.djx.core.business.view.like.DJXLikeButton;
import com.bytedance.sdk.djx.core.business.view.like.OnLikeListener;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.net.ImageTag;
import com.bytedance.sdk.djx.net.img.Picasso;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawControllerLayout extends FrameLayout {
    private static final int DEFAULT_AVATAR_SOURCE = R.drawable.djx_head;
    private static final int DEFAULT_MUSIC_DISCS_SOURCE = -1;
    private static final boolean DEFAULT_MUSIC_TABLE_VISIBLE = false;
    private int mAvatarSrcRes;
    private IDrawAvatarClickListener mClickAvatarListener;
    private final View.OnClickListener mClickComment;
    private DrawAdapter2.OnClickDrawListener mClickDrawListener;
    private RelativeLayout mControlLayout;
    private Feed mFeed;
    private DJXCircleImage mImgAvatar;
    private ImageView mImgComment;
    private ImageView mImgShare;
    private DJXLikeButton mLikeButton;
    private int mLikeCount;
    private LinearLayout mMarqueeLayout;
    private DJXMarqueeView mMarqueeView;
    private int mMusicDiscsImgSrc;
    private DJXMusicLayout mMusicLayout;
    private String mMusicMarqueeText;
    private boolean mMusicTableVisible;
    private final View.OnClickListener mOnClickShare;
    private final Random mRandom;
    private TextView mTvComment;
    private TextView mTvLike;
    private TextView mTvShare;

    public interface IDrawAvatarClickListener {
        void onClick(View view, Feed feed);
    }

    static /* synthetic */ int access$008(DJXDrawControllerLayout dJXDrawControllerLayout) {
        int i = dJXDrawControllerLayout.mLikeCount;
        dJXDrawControllerLayout.mLikeCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(DJXDrawControllerLayout dJXDrawControllerLayout) {
        int i = dJXDrawControllerLayout.mLikeCount;
        dJXDrawControllerLayout.mLikeCount = i - 1;
        return i;
    }

    public DJXDrawControllerLayout(Context context) {
        this(context, null, 0);
    }

    public DJXDrawControllerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXDrawControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFeed = null;
        this.mRandom = new Random();
        this.mLikeCount = 0;
        this.mClickComment = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawControllerLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawControllerLayout.this.mClickDrawListener != null) {
                    DJXDrawControllerLayout.this.mClickDrawListener.onClickComment(view, DJXDrawControllerLayout.this.mFeed);
                }
            }
        };
        this.mOnClickShare = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawControllerLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawControllerLayout.this.mClickDrawListener != null) {
                    DJXDrawControllerLayout.this.mClickDrawListener.onClickShare(view, DJXDrawControllerLayout.this.mFeed);
                }
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXDrawControllerLayout, i, 0);
        this.mMusicTableVisible = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXDrawControllerLayout_djx_music_table_visible, false);
        this.mMusicDiscsImgSrc = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DJXDrawControllerLayout_djx_music_discs_img_src, -1);
        this.mAvatarSrcRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DJXDrawControllerLayout_djx_avatar_src, DEFAULT_AVATAR_SOURCE);
        this.mMusicMarqueeText = typedArrayObtainStyledAttributes.getString(R.styleable.DJXDrawControllerLayout_djx_music_marquee_text);
        typedArrayObtainStyledAttributes.recycle();
        init(context);
    }

    public void setClickDrawListener(DrawAdapter2.OnClickDrawListener onClickDrawListener) {
        this.mClickDrawListener = onClickDrawListener;
    }

    public void setClickAvatarListener(IDrawAvatarClickListener iDrawAvatarClickListener) {
        this.mClickAvatarListener = iDrawAvatarClickListener;
    }

    public void setMusicImg(int i) {
        DJXMusicLayout dJXMusicLayout = this.mMusicLayout;
        if (dJXMusicLayout != null) {
            dJXMusicLayout.getIconView().setImageResource(i);
            this.mMusicDiscsImgSrc = i;
        }
    }

    public void setMusicTableVisible(boolean z) {
        LinearLayout linearLayout = this.mMarqueeLayout;
        if (linearLayout == null || this.mMusicLayout == null) {
            return;
        }
        linearLayout.setVisibility((z && SettingData.getInstance().isEnableMusicTurnTable()) ? 0 : 8);
        this.mMusicLayout.setVisibility(z ? 0 : 4);
        this.mMusicTableVisible = z;
    }

    public void setMusicText(String str) {
        DJXMarqueeView dJXMarqueeView = this.mMarqueeView;
        if (dJXMarqueeView != null) {
            dJXMarqueeView.setText(str);
            this.mMusicMarqueeText = str;
        }
    }

    public void setAvatar(String str) {
        DJXCircleImage dJXCircleImage = this.mImgAvatar;
        if (dJXCircleImage != null) {
            Picasso.with(dJXCircleImage.getContext()).load(str).tag(ImageTag.TAG_DRAW_VIDEO).config(Bitmap.Config.RGB_565).resize(UIUtil.dp2px(24.5f), UIUtil.dp2px(24.5f)).placeholder(DEFAULT_AVATAR_SOURCE).noFade().into(this.mImgAvatar);
        }
    }

    public void setAvatar(int i) {
        DJXCircleImage dJXCircleImage = this.mImgAvatar;
        if (dJXCircleImage != null) {
            Picasso.with(dJXCircleImage.getContext()).load(i).tag(ImageTag.TAG_DRAW_VIDEO).config(Bitmap.Config.RGB_565).resize(UIUtil.dp2px(24.5f), UIUtil.dp2px(24.5f)).placeholder(DEFAULT_AVATAR_SOURCE).noFade().into(this.mImgAvatar);
            this.mAvatarSrcRes = i;
        }
    }

    public void setFeed(Feed feed) {
        this.mFeed = feed;
    }

    public void refreshUI() {
        updateBtnStatus();
        this.mLikeCount = randomLikeNum();
        updateLikeNum();
        this.mLikeButton.setLiked(false);
        this.mTvShare.setText(R.string.djx_str_share_tag1);
    }

    public void start() {
        if (this.mMusicLayout.isShown()) {
            this.mMusicLayout.start();
        }
        if (this.mMarqueeLayout.isShown()) {
            this.mMarqueeView.setTextSize(SettingData.getInstance().getDrawMusicSize());
            this.mMarqueeView.startMarquee();
        }
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

    private void init(Context context) {
        inflate(context, R.layout.djx_view_controller_layout, this);
        this.mControlLayout = (RelativeLayout) findViewById(R.id.djx_draw_item_control_layout);
        this.mMusicLayout = (DJXMusicLayout) findViewById(R.id.djx_draw_item_music_layout);
        this.mImgComment = (ImageView) findViewById(R.id.djx_draw_item_comment_icon);
        this.mTvComment = (TextView) findViewById(R.id.djx_draw_item_comment);
        this.mImgShare = (ImageView) findViewById(R.id.djx_draw_item_share_icon);
        this.mTvShare = (TextView) findViewById(R.id.djx_draw_item_share);
        this.mLikeButton = (DJXLikeButton) findViewById(R.id.djx_draw_item_like_button);
        this.mTvLike = (TextView) findViewById(R.id.djx_draw_item_like);
        this.mMarqueeView = (DJXMarqueeView) findViewById(R.id.djx_draw_item_music_name);
        this.mMarqueeLayout = (LinearLayout) findViewById(R.id.djx_draw_item_music_name_layout);
        this.mImgAvatar = (DJXCircleImage) findViewById(R.id.djx_draw_item_avatar);
        this.mTvComment.setOnClickListener(this.mClickComment);
        this.mImgComment.setOnClickListener(this.mClickComment);
        this.mTvShare.setOnClickListener(this.mOnClickShare);
        this.mImgShare.setOnClickListener(this.mOnClickShare);
        this.mLikeButton.setOnLikeListener(new OnLikeListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawControllerLayout.1
            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public boolean onIntercept(DJXLikeButton dJXLikeButton) {
                return false;
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void liked(DJXLikeButton dJXLikeButton) {
                DJXDrawControllerLayout.access$008(DJXDrawControllerLayout.this);
                DJXDrawControllerLayout.this.updateLikeNum();
            }

            @Override // com.bytedance.sdk.djx.core.business.view.like.OnLikeListener
            public void unLiked(DJXLikeButton dJXLikeButton) {
                DJXDrawControllerLayout.access$010(DJXDrawControllerLayout.this);
                DJXDrawControllerLayout.this.updateLikeNum();
            }
        });
        this.mTvLike.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawControllerLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDrawControllerLayout.this.mLikeButton != null) {
                    DJXDrawControllerLayout.this.mLikeButton.performClick();
                }
            }
        });
        setMusicImg(this.mMusicDiscsImgSrc);
        setMusicText(this.mMusicMarqueeText);
        setAvatar(this.mAvatarSrcRes);
        this.mImgAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawControllerLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXDrawControllerLayout.this.mClickAvatarListener.onClick(DJXDrawControllerLayout.this.mImgAvatar, DJXDrawControllerLayout.this.mFeed);
            }
        });
        updateBtnStatus();
    }

    private void updateBtnStatus() {
        boolean zIsEnableLike = SettingData.getInstance().isEnableLike();
        boolean zIsEnableShare = SettingData.getInstance().isEnableShare();
        boolean zIsEnableComment = SettingData.getInstance().isEnableComment();
        boolean z = SettingData.getInstance().isEnableMusicTurnTable() && this.mMusicTableVisible;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mImgComment.getLayoutParams();
        if (zIsEnableLike) {
            marginLayoutParams.topMargin = UIUtil.dp2px(14.0f);
            this.mImgComment.setLayoutParams(marginLayoutParams);
            this.mTvLike.setVisibility(0);
            this.mLikeButton.setVisibility(0);
        } else {
            marginLayoutParams.topMargin = 0;
            this.mImgComment.setLayoutParams(marginLayoutParams);
            this.mTvLike.setVisibility(8);
            this.mLikeButton.setVisibility(8);
        }
        if (zIsEnableComment) {
            this.mTvComment.setVisibility(0);
            this.mImgComment.setVisibility(0);
        } else {
            this.mTvComment.setVisibility(8);
            this.mImgComment.setVisibility(8);
        }
        if (zIsEnableShare) {
            this.mTvShare.setVisibility(0);
            this.mImgShare.setVisibility(0);
        } else {
            this.mTvShare.setVisibility(8);
            this.mImgShare.setVisibility(8);
        }
        setMusicTableVisible(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLikeNum() {
        TextView textView = this.mTvLike;
        if (textView != null) {
            textView.setText(ToolUtils.likeCountConvert(this.mLikeCount, 2));
        }
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
