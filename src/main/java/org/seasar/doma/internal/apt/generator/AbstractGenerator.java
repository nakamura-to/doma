/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.apt.generator;

import static org.seasar.doma.internal.util.AssertionUtil.assertNotNull;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Formatter;

import javax.annotation.processing.Generated;

import org.seasar.doma.internal.Artifact;
import org.seasar.doma.internal.apt.Context;
import org.seasar.doma.internal.apt.codespec.CodeSpec;
import org.seasar.doma.internal.apt.cttype.BasicCtType;

/**
 * @author taedium
 * 
 */
public abstract class AbstractGenerator implements Generator {

    private static final String INDENT_SPACE = "    ";

    protected final Context ctx;

    protected final CodeSpec codeSpec;

    protected final String packageName;

    protected final String simpleName;

    protected final String typeParamsName;

    private final Formatter formatter;

    private final StringBuilder indentBuffer = new StringBuilder();

    protected AbstractGenerator(Context ctx, CodeSpec codeSpec, Formatter formatter) {
        assertNotNull(ctx, codeSpec, formatter);
        this.ctx = ctx;
        this.codeSpec = codeSpec;
        this.packageName = codeSpec.getPackageName();
        this.simpleName = codeSpec.getSimpleName();
        this.typeParamsName = codeSpec.getTypeParamsName();
        this.formatter = formatter;
    }

    protected void printPackage() {
        if (!packageName.isEmpty()) {
            iprint("package %1$s;%n", packageName);
            iprint("%n");
        }
    }

    protected void printGenerated() {
        iprint("@%s(value = { \"%s\", \"%s\" }, date = \"%tFT%<tT.%<tL%<tz\")%n",
                Generated.class.getName(), Artifact.getName(), ctx.getOptions().getVersion(),
                ctx.getOptions().getDate());
    }

    protected void printValidateVersionStaticInitializer() {
        if (ctx.getOptions().getVersionValidation()) {
            iprint("static {%n");
            iprint("    %1$s.validateVersion(\"%2$s\");%n", Artifact.class.getName(),
                    ctx.getOptions().getVersion());
            iprint("}%n");
            print("%n");
        }
    }

    protected void iprint(String format, Object... args) {
        formatter.format(indentBuffer.toString());
        throwExceptionIfNecessary();
        formatter.format(format, args);
        throwExceptionIfNecessary();
    }

    protected void print(String format, Object... args) {
        formatter.format(format, args);
        throwExceptionIfNecessary();
    }

    protected void throwExceptionIfNecessary() {
        IOException ioException = formatter.ioException();
        if (ioException != null) {
            formatter.close();
            throw new UncheckedIOException(ioException);
        }
    }

    protected void indent() {
        indentBuffer.append(INDENT_SPACE);
    }

    protected void unindent() {
        if (indentBuffer.length() >= INDENT_SPACE.length()) {
            indentBuffer.setLength(indentBuffer.length() - INDENT_SPACE.length());
        }
    }

    protected String box(String name) {
        if (boolean.class.getName().equals(name)) {
            return Boolean.class.getName();
        }
        if (char.class.getName().equals(name)) {
            return Character.class.getName();
        }
        if (byte.class.getName().equals(name)) {
            return Byte.class.getName();
        }
        if (short.class.getName().equals(name)) {
            return Short.class.getName();
        }
        if (int.class.getName().equals(name)) {
            return Integer.class.getName();
        }
        if (long.class.getName().equals(name)) {
            return Long.class.getName();
        }
        if (float.class.getName().equals(name)) {
            return Float.class.getName();
        }
        if (double.class.getName().equals(name)) {
            return Double.class.getName();
        }
        return name;
    }

    protected String box(BasicCtType ctType) {
        return box(ctType.getTypeName());
    }

    protected String supply(BasicCtType ctType) {
        if (ctType.isEnum()) {
            return String.format("() -> new %1$s(%2$s.class)", ctType.getWrapperTypeName(),
                    ctType.getQualifiedName());
        }
        return String.format("%1$s::new", ctType.getWrapperTypeName());
    }

}
