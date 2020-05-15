package org.seasar.doma.jdbc.criteria.context;

import java.util.Objects;
import java.util.function.Supplier;
import org.seasar.doma.internal.jdbc.scalar.Scalar;
import org.seasar.doma.internal.jdbc.scalar.Scalars;
import org.seasar.doma.internal.jdbc.sql.ScalarInParameter;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.InParameter;
import org.seasar.doma.jdbc.criteria.metamodel.PropertyMetamodel;

public interface Operand {

  <R> R accept(Visitor<R> visitor);

  class Param implements Operand {
    private final PropertyMetamodel<?> propertyMetamodel;
    private final Object value;

    public Param(PropertyMetamodel<?> propertyMetamodel, Object value) {
      this.propertyMetamodel = Objects.requireNonNull(propertyMetamodel);
      this.value = value;
    }

    public InParameter<?> createInParameter(Config config) {
      Class<?> clazz = propertyMetamodel.asClass();
      Supplier<Scalar<?, ?>> supplier = Scalars.wrap(value, clazz, false, config.getClassHelper());
      return new ScalarInParameter<>(supplier.get());
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visit(this);
    }
  }

  class Prop implements Operand {
    public final PropertyMetamodel<?> value;

    public Prop(PropertyMetamodel<?> value) {
      this.value = Objects.requireNonNull(value);
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visit(this);
    }
  }

  interface Visitor<R> {

    R visit(Param operand);

    R visit(Prop operand);
  }
}
