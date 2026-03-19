package com.dhylive.app.m_vm.login;

import com.bytedance.applog.game.GameReportHelper;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.dhylive.app.data.login.LoginData;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.net.BaseManager;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.BaseRespKt;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.net.NetworkApi;
import com.dhylive.app.utils.LiveEventConst;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: LoginManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006J\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/dhylive/app/m_vm/login/LoginManager;", "Lcom/dhylive/app/net/BaseManager;", "()V", "loginService", "Lcom/dhylive/app/m_vm/login/LoginService;", "bindAgent", "Lkotlinx/coroutines/flow/Flow;", "Lcom/dhylive/app/net/BaseResp;", "", "param", "Lcom/dhylive/app/net/HashMapNonNull;", "bindWechat", "Lcom/dhylive/app/data/login/LoginData;", IFunc.IVK_GET_USER_INFO, "Lcom/dhylive/app/data/user/UserData;", "login", GameReportHelper.REGISTER, "resetPwd", "sendVerificationCode", "phone", "", LiveEventConst.WX_LOGIN, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LoginManager extends BaseManager {
    private final LoginService loginService = (LoginService) NetworkApi.INSTANCE.create(LoginService.class);

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$sendVerificationCode$1", f = "LoginManager.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$sendVerificationCode$1, reason: invalid class name and case insensitive filesystem */
    static final class C09031 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ String $phone;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09031(String str, Continuation<? super C09031> continuation) {
            super(1, continuation);
            this.$phone = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C09031(this.$phone, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.sendVerificationCode(this.$phone, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return BaseRespKt.convertEmpty((BaseResp) obj);
        }
    }

    public final Flow<BaseResp<Object>> sendVerificationCode(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        return request(new C09031(phone, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/login/LoginData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$login$1", f = "LoginManager.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$login$1, reason: invalid class name and case insensitive filesystem */
    static final class C09001 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends LoginData>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09001(HashMapNonNull hashMapNonNull, Continuation<? super C09001> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C09001(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<LoginData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.login(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<LoginData>> login(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09001(param, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/login/LoginData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$wxLogin$1", f = "LoginManager.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$wxLogin$1, reason: invalid class name and case insensitive filesystem */
    static final class C09041 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends LoginData>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09041(HashMapNonNull hashMapNonNull, Continuation<? super C09041> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C09041(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<LoginData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.wxLogin(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<LoginData>> wxLogin(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09041(param, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/login/LoginData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$bindWechat$1", f = "LoginManager.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$bindWechat$1, reason: invalid class name and case insensitive filesystem */
    static final class C08981 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends LoginData>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08981(HashMapNonNull hashMapNonNull, Continuation<? super C08981> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C08981(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<LoginData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.bindWechat(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<LoginData>> bindWechat(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C08981(param, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$resetPwd$1", f = "LoginManager.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$resetPwd$1, reason: invalid class name and case insensitive filesystem */
    static final class C09021 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09021(HashMapNonNull hashMapNonNull, Continuation<? super C09021> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C09021(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.resetPwd(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return BaseRespKt.convertEmpty((BaseResp) obj);
        }
    }

    public final Flow<BaseResp<Object>> resetPwd(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09021(param, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$register$1", f = "LoginManager.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$register$1, reason: invalid class name and case insensitive filesystem */
    static final class C09011 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09011(HashMapNonNull hashMapNonNull, Continuation<? super C09011> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C09011(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.register(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return BaseRespKt.convertEmpty((BaseResp) obj);
        }
    }

    public final Flow<BaseResp<Object>> register(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new C09011(param, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", "Lcom/dhylive/app/data/user/UserData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$getUserInfo$1", f = "LoginManager.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$getUserInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C08991 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends UserData>>, Object> {
        int label;

        C08991(Continuation<? super C08991> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new C08991(continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<UserData>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.getUserInfo((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final Flow<BaseResp<UserData>> getUserInfo() {
        return request(new C08991(null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/dhylive/app/net/BaseResp;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.dhylive.app.m_vm.login.LoginManager$bindAgent$1", f = "LoginManager.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dhylive.app.m_vm.login.LoginManager$bindAgent$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super BaseResp<? extends Object>>, Object> {
        final /* synthetic */ HashMapNonNull $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HashMapNonNull hashMapNonNull, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$param = hashMapNonNull;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginManager.this.new AnonymousClass1(this.$param, continuation);
        }

        public final Object invoke(Continuation<? super BaseResp<? extends Object>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = LoginManager.this.loginService.bindAgent(this.$param, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return BaseRespKt.convertEmpty((BaseResp) obj);
        }
    }

    public final Flow<BaseResp<Object>> bindAgent(HashMapNonNull param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return request(new AnonymousClass1(param, null));
    }
}
