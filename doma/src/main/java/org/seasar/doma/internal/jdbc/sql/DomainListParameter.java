/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.seasar.doma.internal.jdbc.sql;

import static org.seasar.doma.internal.util.AssertionUtil.*;

import java.util.List;

import org.seasar.doma.internal.domain.DomainType;
import org.seasar.doma.internal.domain.DomainTypeFactory;

/**
 * @author taedium
 * 
 */
public class DomainListParameter<V, D> implements
        ListParameter<DomainType<V, D>> {

    protected final DomainTypeFactory<V, D> domainTypeFactory;

    protected final List<D> domains;

    protected DomainType<V, D> domainType;

    public DomainListParameter(DomainTypeFactory<V, D> domainTypeFactory,
            List<D> domains) {
        assertNotNull(domainTypeFactory, domains);
        this.domainTypeFactory = domainTypeFactory;
        this.domains = domains;
    }

    @Override
    public DomainType<V, D> getElementHolder() {
        domainType = domainTypeFactory.createDomainType();
        return domainType;
    }

    @Override
    public void add() {
        domains.add(domainType.getDomain());
    }

    @Override
    public <R, P, TH extends Throwable> R accept(
            CallableSqlParameterVisitor<R, P, TH> visitor, P p) throws TH {
        return visitor.visitDomainListParameter(this, p);
    }

}
