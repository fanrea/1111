package com.baidu.mobads.container.annotation;

import com.alipay.sdk.m.u.i;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ExecuteFun {
    private String mClassName;
    private ConstructMinMethod mConstructMinMethod;
    private String mDescription;
    private String mExecuteFunName;
    private boolean mIsCanHandle;
    private boolean mIsHandleByCustom;
    private List<? extends VariableElement> mMemberArgs;
    private Set<Modifier> mModifiers;
    private String mPrefix;
    private String mQualifiedName;
    private TypeMirror mReturnType;

    public ConstructMinMethod getConstructMinMethod() {
        return this.mConstructMinMethod;
    }

    public Set<Modifier> getModifiers() {
        return this.mModifiers;
    }

    public void setModifiers(Set<Modifier> set) {
        this.mModifiers = set;
    }

    public List<? extends VariableElement> getMemberArgs() {
        return this.mMemberArgs;
    }

    public void setMemberArgs(List<? extends VariableElement> list) {
        this.mMemberArgs = list;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getExecuteFunName() {
        return this.mExecuteFunName;
    }

    public void setExecuteFunName(String str) {
        this.mExecuteFunName = str;
    }

    public void setConstructMinMethod(ConstructMinMethod constructMinMethod) {
        this.mConstructMinMethod = constructMinMethod;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    public String genJsonString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"prefix\"").append(":").append("\"").append(this.mPrefix).append("\"").append(",");
        sb.append("\"description\"").append(":").append("\"").append(this.mDescription).append("\"").append(",");
        sb.append("\"methodname\"").append(":").append("\"").append(this.mExecuteFunName).append("\"").append(",");
        sb.append("\"construct\"").append(":").append("[");
        List<? extends VariableElement> constructArgs = this.mConstructMinMethod != null ? this.mConstructMinMethod.getConstructArgs() : null;
        int i = 0;
        for (int i2 = 0; constructArgs != null && i2 < constructArgs.size(); i2++) {
            VariableElement variableElement = constructArgs.get(i2);
            String string = variableElement.getSimpleName().toString();
            String string2 = variableElement.asType().toString();
            sb.append("{");
            sb.append("\"pre_argname\"").append(":").append("\"").append(string).append("\"").append(",");
            sb.append("\"pre_argtype\"").append(":").append("\"").append(string2).append("\"");
            sb.append(i.d);
            if (i2 != constructArgs.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]").append(",");
        sb.append("\"args\"").append(":").append("[");
        for (int i3 = 0; this.mMemberArgs != null && i3 < this.mMemberArgs.size(); i3++) {
            VariableElement variableElement2 = this.mMemberArgs.get(i3);
            String string3 = variableElement2.getSimpleName().toString();
            String string4 = variableElement2.asType().toString();
            sb.append("{");
            sb.append("\"argname\"").append(":").append("\"").append(string3).append("\"").append(",");
            sb.append("\"argtype\"").append(":").append("\"").append(string4).append("\"");
            sb.append(i.d);
            if (i3 != this.mMemberArgs.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]").append(",");
        sb.append("\"returntype\"").append(":").append("\"").append(this.mReturnType.toString()).append("\"").append(",");
        sb.append("\"modifier\"").append(":").append("\"");
        Iterator<Modifier> it = this.mModifiers.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (i < this.mModifiers.size() - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append("\"").append(",");
        if (this.mConstructMinMethod != null && this.mConstructMinMethod.getSingletonMethodName() != null) {
            sb.append("\"singletonmethodname\"").append(":").append("\"").append(this.mConstructMinMethod.getSingletonMethodName()).append("\"").append(",");
        }
        sb.append("\"qualifiedname\"").append(":").append("\"").append(this.mQualifiedName).append("\"").append(",");
        sb.append("\"ishandlebycustom\"").append(":").append("\"").append(this.mIsHandleByCustom).append("\"").append(",");
        sb.append("\"iscanhandle\"").append(":").append(this.mIsCanHandle);
        sb.append(i.d);
        return sb.toString();
    }

    public void setReturnType(TypeMirror typeMirror) {
        this.mReturnType = typeMirror;
    }

    public void setQualifiedName(String str) {
        this.mQualifiedName = str;
    }

    public String getQualifiedName() {
        return this.mQualifiedName;
    }

    public boolean getIsHandler() {
        return this.mIsCanHandle;
    }

    public void setIsCanHandle(boolean z) {
        this.mIsCanHandle = z;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public void setClassName(String str) {
        this.mClassName = str;
    }

    public void setIsHandleByCustom(boolean z) {
        this.mIsHandleByCustom = z;
    }
}
