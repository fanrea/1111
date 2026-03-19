package com.dhylive.app.base.fragment;

import androidx.databinding.ViewDataBinding;
import com.dhylive.app.base.BaseViewModel;
import com.dhylive.app.net.ErrorResp;
import com.dhylive.app.utils.ExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseVMFragment.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0007\u001a\u00028\u0001X¤\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/dhylive/app/base/fragment/BaseVMFragment;", "DB", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/dhylive/app/base/BaseViewModel;", "Lcom/dhylive/app/base/fragment/BaseFragment;", "()V", "viewModel", "getViewModel", "()Lcom/dhylive/app/base/BaseViewModel;", "initObserve", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseVMFragment<DB extends ViewDataBinding, VM extends BaseViewModel> extends BaseFragment<DB> {
    protected abstract VM getViewModel();

    @Override // com.dhylive.app.base.fragment.BaseFragment
    public void initObserve() {
        BaseVMFragment<DB, VM> baseVMFragment = this;
        getViewModel().getErrorLiveData().observe(baseVMFragment, new BaseVMFragment$sam$androidx_lifecycle_Observer$0(new Function1<ErrorResp<?>, Unit>(this) { // from class: com.dhylive.app.base.fragment.BaseVMFragment.initObserve.1
            final /* synthetic */ BaseVMFragment<DB, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ErrorResp<?>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ErrorResp<?> errorResp) {
                ExtensionKt.toastShort(this.this$0, errorResp.getMsg());
            }
        }));
        getViewModel().getFragmentLoadingLiveData().observe(baseVMFragment, new BaseVMFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>(this) { // from class: com.dhylive.app.base.fragment.BaseVMFragment.initObserve.2
            final /* synthetic */ BaseVMFragment<DB, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    BaseFragment.showLoadingDialog$default(this.this$0, null, 1, null);
                } else {
                    this.this$0.dismissLoadingDialog();
                }
            }
        }));
    }
}
