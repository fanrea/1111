package com.dhylive.app.base.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.R;
import com.dhylive.app.utils.ClickDelayUtils;
import com.noober.background.view.BLTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseTitleActivity.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0005J\u001a\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"2\b\b\u0002\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/dhylive/app/base/activity/BaseTitleActivity;", "DB", "Landroidx/databinding/ViewDataBinding;", "Lcom/dhylive/app/base/activity/BaseActivity;", "barType", "", "(I)V", "ivBack", "Landroid/widget/ImageView;", "ivRightBtnOne", "ivRightBtnTwo", "tvRightBtn", "Lcom/noober/background/view/BLTextView;", "tvTitle", "Landroid/widget/TextView;", "doBackBtn", "", "doIvRightBtnOneClick", "mRightBtn", "Landroid/view/View;", "doIvRightBtnTwoClick", "doTvRightBtnClick", "initTitle", "setBackDrawable", "drawable", "setBackVisible", "isShow", "", "setIvRightBtnOneVisible", "setIvRightBtnTwoVisible", "setTitleTextColor", TypedValues.Custom.S_COLOR, "setTitleVisible", "title", "", "setTvRightBtnVisible", "rightText", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseTitleActivity<DB extends ViewDataBinding> extends BaseActivity<DB> {
    private final int barType;
    private ImageView ivBack;
    private ImageView ivRightBtnOne;
    private ImageView ivRightBtnTwo;
    private BLTextView tvRightBtn;
    private TextView tvTitle;

    public BaseTitleActivity() {
        this(0, 1, null);
    }

    public void doIvRightBtnOneClick(View mRightBtn) {
        Intrinsics.checkNotNullParameter(mRightBtn, "mRightBtn");
    }

    public void doIvRightBtnTwoClick(View mRightBtn) {
        Intrinsics.checkNotNullParameter(mRightBtn, "mRightBtn");
    }

    public void doTvRightBtnClick(View mRightBtn) {
        Intrinsics.checkNotNullParameter(mRightBtn, "mRightBtn");
    }

    public /* synthetic */ BaseTitleActivity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BaseTitleActivity(int i) {
        super(i);
        this.barType = i;
    }

    @Override // com.dhylive.app.base.activity.BaseActivity
    public void initTitle() {
        super.initTitle();
        View viewFindViewById = findViewById(R.id.public_iv_back);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.ivBack = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.public_tv_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tvTitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.public_tv_right_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.tvRightBtn = (BLTextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.public_iv_right_btn_one);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.ivRightBtnOne = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.public_iv_right_btn_two);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.ivRightBtnTwo = (ImageView) viewFindViewById5;
        setBackVisible$default(this, false, 1, null);
    }

    public static /* synthetic */ void setTitleVisible$default(BaseTitleActivity baseTitleActivity, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitleVisible");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        baseTitleActivity.setTitleVisible(str, z);
    }

    public final void setTitleVisible(String title, boolean isShow) {
        TextView textView = this.tvTitle;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setVisibility(isShow ? 0 : 8);
        TextView textView2 = this.tvTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView2 = null;
        }
        textView2.getPaint().setFakeBoldText(true);
        TextView textView3 = this.tvTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView3 = null;
        }
        if (title != null) {
            String str2 = title;
            if (str2.length() == 0) {
                str2 = "";
            }
            str = str2;
        }
        textView3.setText(str);
    }

    public final void setTitleTextColor(int color) {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setTextColor(ContextCompat.getColor(this, color));
    }

    public static /* synthetic */ void setBackVisible$default(BaseTitleActivity baseTitleActivity, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBackVisible");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        baseTitleActivity.setBackVisible(z);
    }

    public final void setBackVisible(boolean isShow) {
        ImageView imageView = this.ivBack;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setVisibility(isShow ? 0 : 4);
        ClickDelayUtils clickDelayUtils = ClickDelayUtils.INSTANCE;
        ImageView imageView3 = this.ivBack;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        } else {
            imageView2 = imageView3;
        }
        ClickDelayUtils.doClickDelay$default(clickDelayUtils, imageView2, 0L, new Function1<View, Unit>(this) { // from class: com.dhylive.app.base.activity.BaseTitleActivity.setBackVisible.1
            final /* synthetic */ BaseTitleActivity<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                this.this$0.doBackBtn();
            }
        }, 1, null);
    }

    public final void setBackDrawable(int drawable) {
        ImageView imageView = this.ivBack;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView = null;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(this, drawable));
    }

    public void doBackBtn() {
        finish();
    }

    public static /* synthetic */ void setTvRightBtnVisible$default(BaseTitleActivity baseTitleActivity, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTvRightBtnVisible");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        baseTitleActivity.setTvRightBtnVisible(str, z);
    }

    public final void setTvRightBtnVisible(String rightText, boolean isShow) {
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        BLTextView bLTextView = this.tvRightBtn;
        BLTextView bLTextView2 = null;
        if (bLTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightBtn");
            bLTextView = null;
        }
        bLTextView.setVisibility(isShow ? 0 : 8);
        BLTextView bLTextView3 = this.tvRightBtn;
        if (bLTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightBtn");
            bLTextView3 = null;
        }
        String str = rightText;
        if (str.length() == 0) {
            str = "";
        }
        bLTextView3.setText(str);
        ClickDelayUtils clickDelayUtils = ClickDelayUtils.INSTANCE;
        BLTextView bLTextView4 = this.tvRightBtn;
        if (bLTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRightBtn");
        } else {
            bLTextView2 = bLTextView4;
        }
        ClickDelayUtils.doClickDelay$default(clickDelayUtils, bLTextView2, 0L, new Function1<View, Unit>(this) { // from class: com.dhylive.app.base.activity.BaseTitleActivity.setTvRightBtnVisible.2
            final /* synthetic */ BaseTitleActivity<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                this.this$0.doTvRightBtnClick(view);
            }
        }, 1, null);
    }

    public static /* synthetic */ void setIvRightBtnOneVisible$default(BaseTitleActivity baseTitleActivity, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIvRightBtnOneVisible");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        baseTitleActivity.setIvRightBtnOneVisible(i, z);
    }

    public final void setIvRightBtnOneVisible(int drawable, boolean isShow) {
        ImageView imageView = this.ivRightBtnOne;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRightBtnOne");
            imageView = null;
        }
        imageView.setVisibility(isShow ? 0 : 8);
        ImageView imageView3 = this.ivRightBtnOne;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRightBtnOne");
            imageView3 = null;
        }
        imageView3.setImageDrawable(ContextCompat.getDrawable(this, drawable));
        ClickDelayUtils clickDelayUtils = ClickDelayUtils.INSTANCE;
        ImageView imageView4 = this.ivRightBtnOne;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRightBtnOne");
        } else {
            imageView2 = imageView4;
        }
        ClickDelayUtils.doClickDelay$default(clickDelayUtils, imageView2, 0L, new Function1<View, Unit>(this) { // from class: com.dhylive.app.base.activity.BaseTitleActivity.setIvRightBtnOneVisible.1
            final /* synthetic */ BaseTitleActivity<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                this.this$0.doIvRightBtnOneClick(view);
            }
        }, 1, null);
    }

    public static /* synthetic */ void setIvRightBtnTwoVisible$default(BaseTitleActivity baseTitleActivity, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIvRightBtnTwoVisible");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        baseTitleActivity.setIvRightBtnTwoVisible(i, z);
    }

    public final void setIvRightBtnTwoVisible(int drawable, boolean isShow) {
        ImageView imageView = this.ivRightBtnTwo;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRightBtnTwo");
            imageView = null;
        }
        imageView.setVisibility(isShow ? 0 : 8);
        ImageView imageView3 = this.ivRightBtnTwo;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRightBtnTwo");
            imageView3 = null;
        }
        imageView3.setImageDrawable(ContextCompat.getDrawable(this, drawable));
        ClickDelayUtils clickDelayUtils = ClickDelayUtils.INSTANCE;
        ImageView imageView4 = this.ivRightBtnTwo;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRightBtnTwo");
        } else {
            imageView2 = imageView4;
        }
        ClickDelayUtils.doClickDelay$default(clickDelayUtils, imageView2, 0L, new Function1<View, Unit>(this) { // from class: com.dhylive.app.base.activity.BaseTitleActivity.setIvRightBtnTwoVisible.1
            final /* synthetic */ BaseTitleActivity<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                this.this$0.doIvRightBtnTwoClick(view);
            }
        }, 1, null);
    }
}
