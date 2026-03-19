package com.dhylive.app.m_vm.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.mobstat.forbes.Config;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.dhylive.app.base.BaseViewModel;
import com.dhylive.app.data.mine.AdOrderEcpm;
import com.dhylive.app.data.mine.AdOrderInfo;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.data.mine.NovelInfo;
import com.dhylive.app.data.mine.VipLevelInfo;
import com.dhylive.app.data.mine.WithdrawData;
import com.dhylive.app.data.mine.WithdrawInfo;
import com.dhylive.app.data.mine.WithdrawSettingInfo;
import com.dhylive.app.data.mine.WxPayInfo;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.net.ListData;
import com.dhylive.app.utils.SPConfig;
import com.dhylive.app.utils.YiDunUtils;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: MainViewModel.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u00132\b\u0010E\u001a\u0004\u0018\u00010\u0013J\u000e\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020/J\u000e\u0010H\u001a\u00020C2\u0006\u0010G\u001a\u00020/J\u001a\u0010I\u001a\u00020C2\b\b\u0002\u0010J\u001a\u00020\u00132\b\b\u0002\u0010K\u001a\u00020\u0013J\u0016\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013J\u000e\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020\u0013J\u0006\u0010Q\u001a\u00020CJ\u000e\u0010\u0018\u001a\u00020C2\u0006\u0010D\u001a\u00020RJ\u0006\u0010\u001c\u001a\u00020CJ\u0006\u0010S\u001a\u00020CJ\u0006\u0010T\u001a\u00020CJ\u0006\u0010U\u001a\u00020CJ\u0006\u0010V\u001a\u00020CJ\u0006\u0010W\u001a\u00020CJ\u0006\u0010X\u001a\u00020CJ\u000e\u0010*\u001a\u00020C2\u0006\u0010Y\u001a\u00020\u0013J.\u0010Z\u001a\u00020C2\b\u0010P\u001a\u0004\u0018\u00010\u00132\b\u0010[\u001a\u0004\u0018\u00010\u00132\b\u0010\\\u001a\u0004\u0018\u00010\u00132\b\u0010]\u001a\u0004\u0018\u00010\u0013JN\u0010^\u001a\u00020C2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0013R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\bR\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\bR\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\bR\u001d\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\bR\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\bR#\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:090\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u001d\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\b¨\u0006e"}, d2 = {"Lcom/dhylive/app/m_vm/main/MainViewModel;", "Lcom/dhylive/app/base/BaseViewModel;", "()V", "adOrderEcpmLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/AdOrderEcpm;", "getAdOrderEcpmLiveData", "()Landroidx/lifecycle/MutableLiveData;", "adOrderInfoLiveData", "Lcom/dhylive/app/data/mine/AdOrderInfo;", "getAdOrderInfoLiveData", "appConfigLiveData", "Lcom/dhylive/app/data/mine/ConfigurationInfo;", "getAppConfigLiveData", "applyWithdrawLiveData", "", "getApplyWithdrawLiveData", "createAliPayOrder", "", "getCreateAliPayOrder", "createWxPayOrder", "Lcom/dhylive/app/data/mine/WxPayInfo;", "getCreateWxPayOrder", "getConvertMoney", "getGetConvertMoney", "setGetConvertMoney", "(Landroidx/lifecycle/MutableLiveData;)V", "getJumpLog", "getGetJumpLog", "mainManager", "Lcom/dhylive/app/m_vm/main/MainManager;", "getMainManager", "()Lcom/dhylive/app/m_vm/main/MainManager;", "mainManager$delegate", "Lkotlin/Lazy;", "mineFragmentUserInfoLiveData", "Lcom/dhylive/app/data/user/UserData;", "getMineFragmentUserInfoLiveData", "novelSettingLiveData", "Lcom/dhylive/app/data/mine/NovelInfo;", "getNovelSettingLiveData", "successWithDraw", "getSuccessWithDraw", "taskFragmentUserInfoLiveData", "getTaskFragmentUserInfoLiveData", "updateUserInfoLiveData", "Lcom/dhylive/app/net/HashMapNonNull;", "getUpdateUserInfoLiveData", "updateWithdrawSettingResult", "getUpdateWithdrawSettingResult", "userInfoLiveData", "getUserInfoLiveData", "vipLevelInfoLiveData", "Lcom/dhylive/app/data/mine/VipLevelInfo;", "getVipLevelInfoLiveData", "waitWithDrawLiveData", "Lcom/dhylive/app/net/ListData;", "Lcom/dhylive/app/data/mine/WithdrawData;", "getWaitWithDrawLiveData", "withdrawListLiveData", "Lcom/dhylive/app/data/mine/WithdrawInfo;", "getWithdrawListLiveData", "withdrawSettingLiveData", "Lcom/dhylive/app/data/mine/WithdrawSettingInfo;", "getWithdrawSettingLiveData", "applyWithdraw", "", "coin", "withdrawType", "bindAlipay", "param", "bindBankCard", "createAdOrder", "signType", "taskId", "createOrder", "payType", "levelId", "getAdOrderEcpm", "orderSn", "getAppConfig", "", "getNovel", IFunc.IVK_GET_USER_INFO, "getVipLevelList", "getWaitWithDraw", "getWithdrawList", "getWithdrawSetting", "id", "updateAdOrder", "sdkType", "sdkName", "oaid", "updateUserInfo", "nickname", "mobile", "newPwd", "oldPwd", "image", "sms_code", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MainViewModel extends BaseViewModel {

    /* renamed from: mainManager$delegate, reason: from kotlin metadata */
    private final Lazy mainManager = LazyKt.lazy(new Function0<MainManager>() { // from class: com.dhylive.app.m_vm.main.MainViewModel$mainManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MainManager m373invoke() {
            return new MainManager();
        }
    });
    private final MutableLiveData<BaseResp<UserData>> userInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<UserData>> taskFragmentUserInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<UserData>> mineFragmentUserInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<HashMapNonNull>> updateUserInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<ConfigurationInfo>> appConfigLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Object>> getJumpLog = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<NovelInfo>> novelSettingLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<WxPayInfo>> createWxPayOrder = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<String>> createAliPayOrder = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<WithdrawSettingInfo>> withdrawSettingLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Object>> updateWithdrawSettingResult = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<WithdrawInfo>> withdrawListLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Object>> applyWithdrawLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<AdOrderInfo>> adOrderInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<AdOrderEcpm>> adOrderEcpmLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<VipLevelInfo>> vipLevelInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<ListData<WithdrawData>>> waitWithDrawLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<String>> successWithDraw = new MutableLiveData<>();
    private MutableLiveData<BaseResp<Object>> getConvertMoney = new MutableLiveData<>();

    public final MainManager getMainManager() {
        return (MainManager) this.mainManager.getValue();
    }

    public final MutableLiveData<BaseResp<UserData>> getUserInfoLiveData() {
        return this.userInfoLiveData;
    }

    public final MutableLiveData<BaseResp<UserData>> getTaskFragmentUserInfoLiveData() {
        return this.taskFragmentUserInfoLiveData;
    }

    public final MutableLiveData<BaseResp<UserData>> getMineFragmentUserInfoLiveData() {
        return this.mineFragmentUserInfoLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getUserInfo$1", f = "MainViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C09391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09391(Continuation<? super C09391> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09391(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getUserInfo(), new C03431(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/user/UserData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getUserInfo$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getUserInfo$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03431 extends SuspendLambda implements Function2<BaseResp<? extends UserData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03431(MainViewModel mainViewModel, Continuation<? super C03431> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03431 = new C03431(this.this$0, continuation);
                c03431.L$0 = obj;
                return c03431;
            }

            public final Object invoke(BaseResp<UserData> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                BaseResp<UserData> baseResp = (BaseResp) this.L$0;
                this.this$0.getUserInfoLiveData().setValue(baseResp);
                this.this$0.getTaskFragmentUserInfoLiveData().setValue(baseResp);
                this.this$0.getMineFragmentUserInfoLiveData().setValue(baseResp);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getUserInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09391(null), 3, null);
    }

    public final MutableLiveData<BaseResp<HashMapNonNull>> getUpdateUserInfoLiveData() {
        return this.updateUserInfoLiveData;
    }

    public static /* synthetic */ void updateUserInfo$default(MainViewModel mainViewModel, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            str6 = null;
        }
        mainViewModel.updateUserInfo(str, str2, str3, str4, str5, str6);
    }

    public final void updateUserInfo(String nickname, String mobile, String newPwd, String oldPwd, String image, String sms_code) {
        HashMapNonNull hashMapNonNull = new HashMapNonNull();
        HashMapNonNull hashMapNonNull2 = hashMapNonNull;
        hashMapNonNull2.put((HashMapNonNull) "nickname", nickname);
        hashMapNonNull2.put((HashMapNonNull) "mobile", mobile);
        hashMapNonNull2.put((HashMapNonNull) "pwd", newPwd);
        hashMapNonNull2.put((HashMapNonNull) "pwd2", oldPwd);
        hashMapNonNull2.put((HashMapNonNull) "sms_code", sms_code);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09461(hashMapNonNull, image, null), 3, null);
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$updateUserInfo$1", f = "MainViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$updateUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C09461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $image;
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09461(HashMapNonNull hashMapNonNull, String str, Continuation<? super C09461> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
            this.$image = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09461(this.$param, this.$image, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/net/HashMapNonNull;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$updateUserInfo$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$updateUserInfo$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03501 extends SuspendLambda implements Function2<BaseResp<? extends HashMapNonNull>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03501(MainViewModel mainViewModel, Continuation<? super C03501> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03501 = new C03501(this.this$0, continuation);
                c03501.L$0 = obj;
                return c03501;
            }

            public final Object invoke(BaseResp<? extends HashMapNonNull> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getUpdateUserInfoLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().updateUserInfo(this.$param, this.$image), new C03501(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final MutableLiveData<BaseResp<ConfigurationInfo>> getAppConfigLiveData() {
        return this.appConfigLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getAppConfig$1", f = "MainViewModel.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getAppConfig$1, reason: invalid class name and case insensitive filesystem */
    static final class C09351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09351(Continuation<? super C09351> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09351(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMapNonNull hashMapNonNull = new HashMapNonNull();
                hashMapNonNull.put((HashMapNonNull) "app_version", (String) Boxing.boxInt(AppUtils.getAppVersionCode()));
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getConfiguration(hashMapNonNull), new C03391(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/ConfigurationInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getAppConfig$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getAppConfig$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03391 extends SuspendLambda implements Function2<BaseResp<? extends ConfigurationInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03391(MainViewModel mainViewModel, Continuation<? super C03391> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03391 = new C03391(this.this$0, continuation);
                c03391.L$0 = obj;
                return c03391;
            }

            public final Object invoke(BaseResp<ConfigurationInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getAppConfigLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getAppConfig() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09351(null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getGetJumpLog() {
        return this.getJumpLog;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getJumpLog$1", f = "MainViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getJumpLog$1, reason: invalid class name and case insensitive filesystem */
    static final class C09371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09371(Continuation<? super C09371> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09371(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getJumpLog$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getJumpLog$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03411 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03411(MainViewModel mainViewModel, Continuation<? super C03411> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03411 = new C03411(this.this$0, continuation);
                c03411.L$0 = obj;
                return c03411;
            }

            public final Object invoke(BaseResp<? extends Object> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getGetJumpLog().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getJumpLog(), new C03411(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getJumpLog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09371(null), 3, null);
    }

    public final MutableLiveData<BaseResp<NovelInfo>> getNovelSettingLiveData() {
        return this.novelSettingLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getNovel$1", f = "MainViewModel.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getNovel$1, reason: invalid class name and case insensitive filesystem */
    static final class C09381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09381(Continuation<? super C09381> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09381(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/NovelInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getNovel$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getNovel$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03421 extends SuspendLambda implements Function2<BaseResp<? extends NovelInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03421(MainViewModel mainViewModel, Continuation<? super C03421> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03421 = new C03421(this.this$0, continuation);
                c03421.L$0 = obj;
                return c03421;
            }

            public final Object invoke(BaseResp<NovelInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getNovelSettingLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getNovelSetting(), new C03421(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getNovel() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09381(null), 3, null);
    }

    public final MutableLiveData<BaseResp<WxPayInfo>> getCreateWxPayOrder() {
        return this.createWxPayOrder;
    }

    public final MutableLiveData<BaseResp<String>> getCreateAliPayOrder() {
        return this.createAliPayOrder;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$createOrder$1", f = "MainViewModel.kt", i = {}, l = {121, 125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$createOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $levelId;
        final /* synthetic */ String $payType;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09331(String str, String str2, MainViewModel mainViewModel, Continuation<? super C09331> continuation) {
            super(2, continuation);
            this.$payType = str;
            this.$levelId = str2;
            this.this$0 = mainViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09331(this.$payType, this.$levelId, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMapNonNull hashMapNonNull = new HashMapNonNull();
                HashMapNonNull hashMapNonNull2 = hashMapNonNull;
                hashMapNonNull2.put((HashMapNonNull) "pay_type", this.$payType);
                hashMapNonNull2.put((HashMapNonNull) "level_id", this.$levelId);
                if (Intrinsics.areEqual(this.$payType, "alipay")) {
                    this.label = 1;
                    if (FlowKt.collectLatest(this.this$0.getMainManager().createAliPayOrder(hashMapNonNull), new C03371(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    if (FlowKt.collectLatest(this.this$0.getMainManager().createWxPayOrder(hashMapNonNull), new AnonymousClass2(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$createOrder$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$createOrder$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03371 extends SuspendLambda implements Function2<BaseResp<? extends String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03371(MainViewModel mainViewModel, Continuation<? super C03371> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03371 = new C03371(this.this$0, continuation);
                c03371.L$0 = obj;
                return c03371;
            }

            public final Object invoke(BaseResp<String> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getCreateAliPayOrder().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/WxPayInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$createOrder$1$2", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$createOrder$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<BaseResp<? extends WxPayInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MainViewModel mainViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(BaseResp<WxPayInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getCreateWxPayOrder().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void createOrder(String payType, String levelId) {
        Intrinsics.checkNotNullParameter(payType, "payType");
        Intrinsics.checkNotNullParameter(levelId, "levelId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09331(payType, levelId, this, null), 3, null);
    }

    public final MutableLiveData<BaseResp<WithdrawSettingInfo>> getWithdrawSettingLiveData() {
        return this.withdrawSettingLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getWithdrawSetting$1", f = "MainViewModel.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getWithdrawSetting$1, reason: invalid class name and case insensitive filesystem */
    static final class C09431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09431(Continuation<? super C09431> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09431(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/WithdrawSettingInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getWithdrawSetting$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getWithdrawSetting$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03471 extends SuspendLambda implements Function2<BaseResp<? extends WithdrawSettingInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03471(MainViewModel mainViewModel, Continuation<? super C03471> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03471 = new C03471(this.this$0, continuation);
                c03471.L$0 = obj;
                return c03471;
            }

            public final Object invoke(BaseResp<WithdrawSettingInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getWithdrawSettingLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getWithdrawSetting(), new C03471(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getWithdrawSetting() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09431(null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getUpdateWithdrawSettingResult() {
        return this.updateWithdrawSettingResult;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$bindAlipay$1", f = "MainViewModel.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$bindAlipay$1, reason: invalid class name and case insensitive filesystem */
    static final class C09301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09301(HashMapNonNull hashMapNonNull, Continuation<? super C09301> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09301(this.$param, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$bindAlipay$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$bindAlipay$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03341 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03341(MainViewModel mainViewModel, Continuation<? super C03341> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03341 = new C03341(this.this$0, continuation);
                c03341.L$0 = obj;
                return c03341;
            }

            public final Object invoke(BaseResp<? extends Object> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getUpdateWithdrawSettingResult().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().bindAlipay(this.$param), new C03341(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void bindAlipay(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09301(param, null), 3, null);
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$bindBankCard$1", f = "MainViewModel.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$bindBankCard$1, reason: invalid class name and case insensitive filesystem */
    static final class C09311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09311(HashMapNonNull hashMapNonNull, Continuation<? super C09311> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09311(this.$param, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$bindBankCard$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$bindBankCard$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03351 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03351(MainViewModel mainViewModel, Continuation<? super C03351> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03351 = new C03351(this.this$0, continuation);
                c03351.L$0 = obj;
                return c03351;
            }

            public final Object invoke(BaseResp<? extends Object> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getUpdateWithdrawSettingResult().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().bindBankCard(this.$param), new C03351(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void bindBankCard(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09311(param, null), 3, null);
    }

    public final MutableLiveData<BaseResp<WithdrawInfo>> getWithdrawListLiveData() {
        return this.withdrawListLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getWithdrawList$1", f = "MainViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getWithdrawList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09421(Continuation<? super C09421> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09421(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/WithdrawInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getWithdrawList$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getWithdrawList$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03461 extends SuspendLambda implements Function2<BaseResp<? extends WithdrawInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03461(MainViewModel mainViewModel, Continuation<? super C03461> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03461 = new C03461(this.this$0, continuation);
                c03461.L$0 = obj;
                return c03461;
            }

            public final Object invoke(BaseResp<WithdrawInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getWithdrawListLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getWithdrawList(), new C03461(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getWithdrawList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09421(null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getApplyWithdrawLiveData() {
        return this.applyWithdrawLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$applyWithdraw$1", f = "MainViewModel.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$applyWithdraw$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $coin;
        final /* synthetic */ String $withdrawType;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, MainViewModel mainViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$coin = str;
            this.$withdrawType = str2;
            this.this$0 = mainViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$coin, this.$withdrawType, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMapNonNull hashMapNonNull = new HashMapNonNull();
                HashMapNonNull hashMapNonNull2 = hashMapNonNull;
                hashMapNonNull2.put((HashMapNonNull) "state", "1");
                hashMapNonNull2.put((HashMapNonNull) "coin", this.$coin);
                hashMapNonNull2.put((HashMapNonNull) "withdraw_type", this.$withdrawType);
                this.label = 1;
                if (FlowKt.collectLatest(this.this$0.getMainManager().applyWithdraw(hashMapNonNull), new C03331(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$applyWithdraw$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$applyWithdraw$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03331 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03331(MainViewModel mainViewModel, Continuation<? super C03331> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03331 = new C03331(this.this$0, continuation);
                c03331.L$0 = obj;
                return c03331;
            }

            public final Object invoke(BaseResp<? extends Object> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getApplyWithdrawLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void applyWithdraw(String coin, String withdrawType) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(coin, withdrawType, this, null), 3, null);
    }

    public final MutableLiveData<BaseResp<AdOrderInfo>> getAdOrderInfoLiveData() {
        return this.adOrderInfoLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$createAdOrder$1", f = "MainViewModel.kt", i = {}, l = {202, 211}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$createAdOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $signType;
        final /* synthetic */ String $taskId;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09321(String str, String str2, MainViewModel mainViewModel, Continuation<? super C09321> continuation) {
            super(2, continuation);
            this.$signType = str;
            this.$taskId = str2;
            this.this$0 = mainViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09321(this.$signType, this.$taskId, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = YiDunUtils.INSTANCE.getTokenSuspend((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            HashMapNonNull hashMapNonNull = new HashMapNonNull();
            HashMapNonNull hashMapNonNull2 = hashMapNonNull;
            hashMapNonNull2.put((HashMapNonNull) "pre_order_no", "");
            hashMapNonNull2.put((HashMapNonNull) "sign_type", this.$signType);
            hashMapNonNull2.put((HashMapNonNull) "type", "movie");
            hashMapNonNull2.put((HashMapNonNull) "app_type", (String) Boxing.boxInt(1));
            hashMapNonNull2.put((HashMapNonNull) "task_id", this.$taskId);
            hashMapNonNull2.put((HashMapNonNull) "yidun_token", (String) obj);
            hashMapNonNull2.put((HashMapNonNull) Config.INPUT_DEF_VERSION, (String) Boxing.boxInt(AppUtils.getAppVersionCode()));
            this.label = 2;
            if (FlowKt.collectLatest(this.this$0.getMainManager().createAdOrder(hashMapNonNull), new C03361(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/AdOrderInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$createAdOrder$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$createAdOrder$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03361 extends SuspendLambda implements Function2<BaseResp<? extends AdOrderInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03361(MainViewModel mainViewModel, Continuation<? super C03361> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03361 = new C03361(this.this$0, continuation);
                c03361.L$0 = obj;
                return c03361;
            }

            public final Object invoke(BaseResp<AdOrderInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getAdOrderInfoLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void createAdOrder$default(MainViewModel mainViewModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "0";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        mainViewModel.createAdOrder(str, str2);
    }

    public final void createAdOrder(String signType, String taskId) {
        Intrinsics.checkNotNullParameter(signType, "signType");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09321(signType, taskId, this, null), 3, null);
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$updateAdOrder$1", f = "MainViewModel.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$updateAdOrder$1, reason: invalid class name and case insensitive filesystem */
    static final class C09451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $oaid;
        final /* synthetic */ String $orderSn;
        final /* synthetic */ String $sdkName;
        final /* synthetic */ String $sdkType;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09451(String str, String str2, String str3, String str4, MainViewModel mainViewModel, Continuation<? super C09451> continuation) {
            super(2, continuation);
            this.$orderSn = str;
            this.$sdkType = str2;
            this.$sdkName = str3;
            this.$oaid = str4;
            this.this$0 = mainViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09451(this.$orderSn, this.$sdkType, this.$sdkName, this.$oaid, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMapNonNull hashMapNonNull = new HashMapNonNull();
                HashMapNonNull hashMapNonNull2 = hashMapNonNull;
                hashMapNonNull2.put((HashMapNonNull) "order_no", this.$orderSn);
                hashMapNonNull2.put((HashMapNonNull) "sdk_type", this.$sdkType);
                hashMapNonNull2.put((HashMapNonNull) Config.EVENT_SDK_NAME, this.$sdkName);
                hashMapNonNull2.put((HashMapNonNull) "oaid", this.$oaid);
                hashMapNonNull2.put((HashMapNonNull) "video_type", (String) Boxing.boxInt(1));
                this.label = 1;
                if (FlowKt.collectLatest(this.this$0.getMainManager().updateAdOrder(hashMapNonNull), new C03491(null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$updateAdOrder$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$updateAdOrder$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03491 extends SuspendLambda implements Function2<BaseResp<? extends String>, Continuation<? super Unit>, Object> {
            int label;

            C03491(Continuation<? super C03491> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03491(continuation);
            }

            public final Object invoke(BaseResp<String> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }
    }

    public final void updateAdOrder(String orderSn, String sdkType, String sdkName, String oaid) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09451(orderSn, sdkType, sdkName, oaid, this, null), 3, null);
    }

    public final MutableLiveData<BaseResp<AdOrderEcpm>> getAdOrderEcpmLiveData() {
        return this.adOrderEcpmLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getAdOrderEcpm$1", f = "MainViewModel.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getAdOrderEcpm$1, reason: invalid class name and case insensitive filesystem */
    static final class C09341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $orderSn;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09341(String str, MainViewModel mainViewModel, Continuation<? super C09341> continuation) {
            super(2, continuation);
            this.$orderSn = str;
            this.this$0 = mainViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09341(this.$orderSn, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMapNonNull hashMapNonNull = new HashMapNonNull();
                hashMapNonNull.put((HashMapNonNull) "order_no", this.$orderSn);
                this.label = 1;
                if (FlowKt.collectLatest(this.this$0.getMainManager().getAdOrderEcpm(hashMapNonNull), new C03381(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/AdOrderEcpm;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getAdOrderEcpm$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getAdOrderEcpm$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03381 extends SuspendLambda implements Function2<BaseResp<? extends AdOrderEcpm>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03381(MainViewModel mainViewModel, Continuation<? super C03381> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03381 = new C03381(this.this$0, continuation);
                c03381.L$0 = obj;
                return c03381;
            }

            public final Object invoke(BaseResp<AdOrderEcpm> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getAdOrderEcpmLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getAdOrderEcpm(String orderSn) {
        Intrinsics.checkNotNullParameter(orderSn, "orderSn");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09341(orderSn, this, null), 3, null);
    }

    public final MutableLiveData<BaseResp<VipLevelInfo>> getVipLevelInfoLiveData() {
        return this.vipLevelInfoLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getVipLevelList$1", f = "MainViewModel.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getVipLevelList$1, reason: invalid class name and case insensitive filesystem */
    static final class C09401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09401(Continuation<? super C09401> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09401(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/mine/VipLevelInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getVipLevelList$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getVipLevelList$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03441 extends SuspendLambda implements Function2<BaseResp<? extends VipLevelInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03441(MainViewModel mainViewModel, Continuation<? super C03441> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03441 = new C03441(this.this$0, continuation);
                c03441.L$0 = obj;
                return c03441;
            }

            public final Object invoke(BaseResp<VipLevelInfo> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getVipLevelInfoLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getVipLevelList(), new C03441(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getVipLevelList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09401(null), 3, null);
    }

    public final MutableLiveData<BaseResp<ListData<WithdrawData>>> getWaitWithDrawLiveData() {
        return this.waitWithDrawLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getWaitWithDraw$1", f = "MainViewModel.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getWaitWithDraw$1, reason: invalid class name and case insensitive filesystem */
    static final class C09411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09411(Continuation<? super C09411> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09411(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/net/ListData;", "Lcom/dhylive/app/data/mine/WithdrawData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getWaitWithDraw$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getWaitWithDraw$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03451 extends SuspendLambda implements Function2<BaseResp<? extends ListData<WithdrawData>>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03451(MainViewModel mainViewModel, Continuation<? super C03451> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03451 = new C03451(this.this$0, continuation);
                c03451.L$0 = obj;
                return c03451;
            }

            public final Object invoke(BaseResp<ListData<WithdrawData>> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getWaitWithDrawLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().getWaitWithDraw(), new C03451(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getWaitWithDraw() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09411(null), 3, null);
    }

    public final MutableLiveData<BaseResp<String>> getSuccessWithDraw() {
        return this.successWithDraw;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$successWithDraw$1", f = "MainViewModel.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$successWithDraw$1, reason: invalid class name and case insensitive filesystem */
    static final class C09441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09441(String str, Continuation<? super C09441> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C09441(this.$id, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$successWithDraw$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$successWithDraw$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03481 extends SuspendLambda implements Function2<BaseResp<? extends String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03481(MainViewModel mainViewModel, Continuation<? super C03481> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03481 = new C03481(this.this$0, continuation);
                c03481.L$0 = obj;
                return c03481;
            }

            public final Object invoke(BaseResp<String> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getSuccessWithDraw().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(MainViewModel.this.getMainManager().successWithDraw(this.$id), new C03481(MainViewModel.this, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void successWithDraw(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09441(id, null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getGetConvertMoney() {
        return this.getConvertMoney;
    }

    public final void setGetConvertMoney(MutableLiveData<BaseResp<Object>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.getConvertMoney = mutableLiveData;
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getConvertMoney$1", f = "MainViewModel.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getConvertMoney$1, reason: invalid class name and case insensitive filesystem */
    static final class C09361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $coin;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09361(int i, MainViewModel mainViewModel, Continuation<? super C09361> continuation) {
            super(2, continuation);
            this.$coin = i;
            this.this$0 = mainViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09361(this.$coin, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMapNonNull hashMapNonNull = new HashMapNonNull();
                HashMapNonNull hashMapNonNull2 = hashMapNonNull;
                hashMapNonNull2.put((HashMapNonNull) "coin", (String) Boxing.boxInt(this.$coin));
                hashMapNonNull2.put((HashMapNonNull) NetworkDefine.PARAM_TOKEN, SPUtils.getInstance().getString(SPConfig.KEY_TOKEN));
                hashMapNonNull2.put((HashMapNonNull) "device_type", "android");
                this.label = 1;
                if (FlowKt.collectLatest(this.this$0.getMainManager().getConvertMoney(hashMapNonNull), new C03401(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.main.MainViewModel$getConvertMoney$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.main.MainViewModel$getConvertMoney$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03401 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MainViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03401(MainViewModel mainViewModel, Continuation<? super C03401> continuation) {
                super(2, continuation);
                this.this$0 = mainViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03401 = new C03401(this.this$0, continuation);
                c03401.L$0 = obj;
                return c03401;
            }

            public final Object invoke(BaseResp<? extends Object> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getGetConvertMoney().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getConvertMoney(int coin) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09361(coin, this, null), 3, null);
    }
}
