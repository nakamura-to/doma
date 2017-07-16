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
package org.seasar.doma.internal.apt.processor.entity;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.seasar.doma.internal.jdbc.scalar.BasicScalar;
import org.seasar.doma.jdbc.entity.AbstractEntityDesc;
import org.seasar.doma.jdbc.entity.DefaultPropertyDesc;
import org.seasar.doma.jdbc.entity.EntityPropertyDesc;
import org.seasar.doma.jdbc.entity.GeneratedIdPropertyDesc;
import org.seasar.doma.jdbc.entity.NamingType;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;
import org.seasar.doma.jdbc.entity.Property;
import org.seasar.doma.jdbc.entity.VersionPropertyDesc;
import org.seasar.doma.wrapper.IntegerWrapper;

public class _ParentEntity extends AbstractEntityDesc<ParentEntity> {

    private final NamingType __namingType = NamingType.UPPER_CASE;

    public DefaultPropertyDesc<ParentEntity, Integer, Integer> $aaa = new DefaultPropertyDesc<>(
            ParentEntity.class, () -> new BasicScalar<>(new IntegerWrapper(), false), "aaa", "AAA",
            __namingType, true, true, false);

    public DefaultPropertyDesc<ParentEntity, Integer, Integer> $bbb = new DefaultPropertyDesc<>(
            ParentEntity.class, () -> new BasicScalar<>(new IntegerWrapper(), false), "bbb", "BBB",
            __namingType, true, true, false);

    private _ParentEntity() {
    }

    @Override
    public void saveCurrentStates(ParentEntity entity) {
    }

    @Override
    public String getCatalogName() {

        return null;
    }

    @Override
    public Class<ParentEntity> getEntityClass() {

        return null;
    }

    @Override
    public EntityPropertyDesc<ParentEntity, ?> getEntityPropertyDesc(String name) {

        return null;
    }

    @Override
    public List<EntityPropertyDesc<ParentEntity, ?>> getEntityPropertyDescs() {

        return null;
    }

    @Override
    public GeneratedIdPropertyDesc<ParentEntity, ?, ?> getGeneratedIdPropertyDesc() {

        return null;
    }

    @Override
    public String getName() {

        return null;
    }

    @Override
    public ParentEntity getOriginalStates(ParentEntity entity) {

        return null;
    }

    @Override
    public String getSchemaName() {

        return null;
    }

    @Override
    public String getTableName(BiFunction<NamingType, String, String> namingFunction) {

        return null;
    }

    @Override
    public VersionPropertyDesc<ParentEntity, ?, ?> getVersionPropertyDesc() {

        return null;
    }

    @Override
    public void preDelete(ParentEntity entity, PreDeleteContext<ParentEntity> context) {
    }

    @Override
    public void preInsert(ParentEntity entity, PreInsertContext<ParentEntity> context) {
    }

    @Override
    public void preUpdate(ParentEntity entity, PreUpdateContext<ParentEntity> context) {
    }

    @Override
    public void postDelete(ParentEntity entity, PostDeleteContext<ParentEntity> context) {
    }

    @Override
    public void postInsert(ParentEntity entity, PostInsertContext<ParentEntity> context) {
    }

    @Override
    public void postUpdate(ParentEntity entity, PostUpdateContext<ParentEntity> context) {
    }

    @Override
    public List<EntityPropertyDesc<ParentEntity, ?>> getIdPropertyDescs() {
        return null;
    }

    @Override
    public NamingType getNamingType() {
        return null;
    }

    public static _ParentEntity getSingletonInternal() {
        return null;
    }

    @Override
    public boolean isImmutable() {
        return false;
    }

    @Override
    public ParentEntity newEntity(Map<String, Property<ParentEntity, ?>> args) {
        return null;
    }

    @Override
    public boolean isQuoteRequired() {
        return false;
    }
}
