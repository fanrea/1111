package com.dhylive.app.m_vm.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.applog.game.GameReportHelper;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.dhylive.app.data.login.LoginData;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.utils.LiveEventConst;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020 J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\b¨\u0006+"}, d2 = {"Lcom/dhylive/app/m_vm/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bindAgentData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/dhylive/app/net/BaseResp;", "", "getBindAgentData", "()Landroidx/lifecycle/MutableLiveData;", "loginManager", "Lcom/dhylive/app/m_vm/login/LoginManager;", "getLoginManager", "()Lcom/dhylive/app/m_vm/login/LoginManager;", "loginManager$delegate", "Lkotlin/Lazy;", "loginResult", "Lcom/dhylive/app/data/login/LoginData;", "getLoginResult", "registerLiveData", "getRegisterLiveData", "resetPasswordResult", "getResetPasswordResult", "userInfoLiveData", "Lcom/dhylive/app/data/user/UserData;", "getUserInfoLiveData", "verificationCodeResponse", "getVerificationCodeResponse", "wechatBindingResult", "getWechatBindingResult", "bindAgent", "", "inviteCode", "", "bindWechat", "param", "Lcom/dhylive/app/net/HashMapNonNull;", IFunc.IVK_GET_USER_INFO, "login", GameReportHelper.REGISTER, "resetPwd", "sendVerificationCode", "phone", LiveEventConst.WX_LOGIN, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LoginViewModel extends ViewModel {

    /* renamed from: loginManager$delegate, reason: from kotlin metadata */
    private final Lazy loginManager = LazyKt.lazy(new Function0<LoginManager>() { // from class: com.dhylive.app.m_vm.login.LoginViewModel$loginManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LoginManager m372invoke() {
            return new LoginManager();
        }
    });
    private final MutableLiveData<BaseResp<Object>> verificationCodeResponse = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<LoginData>> loginResult = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<LoginData>> wechatBindingResult = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Object>> resetPasswordResult = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Object>> registerLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<UserData>> userInfoLiveData = new MutableLiveData<>();
    private final MutableLiveData<BaseResp<Object>> bindAgentData = new MutableLiveData<>();

    public final LoginManager getLoginManager() {
        return (LoginManager) this.loginManager.getValue();
    }

    public final MutableLiveData<BaseResp<Object>> getVerificationCodeResponse() {
        return this.verificationCodeResponse;
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$sendVerificationCode$1", f = "LoginViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$sendVerificationCode$1, reason: invalid class name and case insensitive filesystem */
    static final class C09101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $phone;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09101(String str, Continuation<? super C09101> continuation) {
            super(2, continuation);
            this.$phone = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09101(this.$phone, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().sendVerificationCode(this.$phone), new C03311(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$sendVerificationCode$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$sendVerificationCode$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03311 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03311(LoginViewModel loginViewModel, Continuation<? super C03311> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03311 = new C03311(this.this$0, continuation);
                c03311.L$0 = obj;
                return c03311;
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
                this.this$0.getVerificationCodeResponse().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void sendVerificationCode(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09101(phone, null), 3, null);
    }

    public final MutableLiveData<BaseResp<LoginData>> getLoginResult() {
        return this.loginResult;
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$login$1", f = "LoginViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$login$1, reason: invalid class name and case insensitive filesystem */
    static final class C09071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09071(HashMapNonNull hashMapNonNull, Continuation<? super C09071> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09071(this.$param, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().login(this.$param), new C03281(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/login/LoginData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$login$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$login$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03281 extends SuspendLambda implements Function2<BaseResp<? extends LoginData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03281(LoginViewModel loginViewModel, Continuation<? super C03281> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03281 = new C03281(this.this$0, continuation);
                c03281.L$0 = obj;
                return c03281;
            }

            public final Object invoke(BaseResp<LoginData> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getLoginResult().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void login(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        param.put((HashMapNonNull) "agent_code", "");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09071(param, null), 3, null);
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$wxLogin$1", f = "LoginViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$wxLogin$1, reason: invalid class name and case insensitive filesystem */
    static final class C09111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09111(HashMapNonNull hashMapNonNull, Continuation<? super C09111> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09111(this.$param, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().wxLogin(this.$param), new C03321(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/login/LoginData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$wxLogin$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$wxLogin$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03321 extends SuspendLambda implements Function2<BaseResp<? extends LoginData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03321(LoginViewModel loginViewModel, Continuation<? super C03321> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03321 = new C03321(this.this$0, continuation);
                c03321.L$0 = obj;
                return c03321;
            }

            public final Object invoke(BaseResp<LoginData> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getLoginResult().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void wxLogin(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        param.put((HashMapNonNull) "agent_code", "");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09111(param, null), 3, null);
    }

    public final MutableLiveData<BaseResp<LoginData>> getWechatBindingResult() {
        return this.wechatBindingResult;
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$bindWechat$1", f = "LoginViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$bindWechat$1, reason: invalid class name and case insensitive filesystem */
    static final class C09051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09051(HashMapNonNull hashMapNonNull, Continuation<? super C09051> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09051(this.$param, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().bindWechat(this.$param), new C03261(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/login/LoginData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$bindWechat$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$bindWechat$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03261 extends SuspendLambda implements Function2<BaseResp<? extends LoginData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03261(LoginViewModel loginViewModel, Continuation<? super C03261> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03261 = new C03261(this.this$0, continuation);
                c03261.L$0 = obj;
                return c03261;
            }

            public final Object invoke(BaseResp<LoginData> baseResp, Continuation<? super Unit> continuation) {
                return create(baseResp, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.getWechatBindingResult().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void bindWechat(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09051(param, null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getResetPasswordResult() {
        return this.resetPasswordResult;
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$resetPwd$1", f = "LoginViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$resetPwd$1, reason: invalid class name and case insensitive filesystem */
    static final class C09091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09091(HashMapNonNull hashMapNonNull, Continuation<? super C09091> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09091(this.$param, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().resetPwd(this.$param), new C03301(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$resetPwd$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$resetPwd$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03301 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03301(LoginViewModel loginViewModel, Continuation<? super C03301> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03301 = new C03301(this.this$0, continuation);
                c03301.L$0 = obj;
                return c03301;
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
                this.this$0.getResetPasswordResult().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void resetPwd(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09091(param, null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getRegisterLiveData() {
        return this.registerLiveData;
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$register$1", f = "LoginViewModel.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$register$1, reason: invalid class name and case insensitive filesystem */
    static final class C09081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09081(HashMapNonNull hashMapNonNull, Continuation<? super C09081> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09081(this.$param, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().register(this.$param), new C03291(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$register$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$register$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03291 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03291(LoginViewModel loginViewModel, Continuation<? super C03291> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03291 = new C03291(this.this$0, continuation);
                c03291.L$0 = obj;
                return c03291;
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
                this.this$0.getRegisterLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void register(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        param.put((HashMapNonNull) "agent_code", "");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09081(param, null), 3, null);
    }

    public final MutableLiveData<BaseResp<UserData>> getUserInfoLiveData() {
        return this.userInfoLiveData;
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$getUserInfo$1", f = "LoginViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$getUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C09061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09061(Continuation<? super C09061> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new C09061(continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().getUserInfo(), new C03271(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/user/UserData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$getUserInfo$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$getUserInfo$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03271 extends SuspendLambda implements Function2<BaseResp<? extends UserData>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03271(LoginViewModel loginViewModel, Continuation<? super C03271> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03271 = new C03271(this.this$0, continuation);
                c03271.L$0 = obj;
                return c03271;
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
                this.this$0.getUserInfoLiveData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getUserInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09061(null), 3, null);
    }

    public final MutableLiveData<BaseResp<Object>> getBindAgentData() {
        return this.bindAgentData;
    }

    public final void bindAgent(String inviteCode) {
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        HashMapNonNull hashMapNonNull = new HashMapNonNull();
        hashMapNonNull.put((HashMapNonNull) "invite_code", inviteCode);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(hashMapNonNull, null), 3, null);
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$bindAgent$1", f = "LoginViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$bindAgent$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HashMapNonNull hashMapNonNull, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginViewModel.this.new AnonymousClass1(this.$param, continuation);
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
                if (FlowKt.collectLatest(LoginViewModel.this.getLoginManager().bindAgent(this.$param), new C03251(LoginViewModel.this, null), (Continuation) this) == coroutine_suspended) {
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

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "response", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginViewModel$bindAgent$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dhylive.app.m_vm.login.LoginViewModel$bindAgent$1$1, reason: invalid class name and collision with other inner class name */
        static final class C03251 extends SuspendLambda implements Function2<BaseResp<? extends Object>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LoginViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03251(LoginViewModel loginViewModel, Continuation<? super C03251> continuation) {
                super(2, continuation);
                this.this$0 = loginViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c03251 = new C03251(this.this$0, continuation);
                c03251.L$0 = obj;
                return c03251;
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
                this.this$0.getBindAgentData().setValue((BaseResp) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }
}
