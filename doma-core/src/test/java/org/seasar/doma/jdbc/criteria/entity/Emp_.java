package org.seasar.doma.jdbc.criteria.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.seasar.doma.jdbc.criteria.metamodel.DefaultPropertyMetamodel;
import org.seasar.doma.jdbc.criteria.metamodel.EntityMetamodel;
import org.seasar.doma.jdbc.criteria.metamodel.PropertyMetamodel;

public class Emp_ implements EntityMetamodel<Emp> {

  private final _Emp entityType = new _Emp();

  public final PropertyMetamodel<Integer> id =
      new DefaultPropertyMetamodel<>(Integer.class, entityType, "id");

  public final PropertyMetamodel<String> name =
      new DefaultPropertyMetamodel<>(String.class, entityType, "name");

  public final PropertyMetamodel<BigDecimal> salary =
      new DefaultPropertyMetamodel<>(BigDecimal.class, entityType, "salary");

  public final PropertyMetamodel<Integer> version =
      new DefaultPropertyMetamodel<>(Integer.class, entityType, "version");

  public _Emp asType() {
    return entityType;
  }

  @Override
  public List<PropertyMetamodel<?>> allPropertyMetamodels() {
    return Arrays.asList(id, name, salary, version);
  }
}
