package com.esc.micro.kiwi.core.model.common.manager;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Manager entity.
 *
 * @param <K> the type parameter
 * @param <E> the type parameter
 */
public abstract class ManagerEntity<K extends Serializable & Comparable<K>, E extends ManagerEntity<K, ?>>
    implements Serializable, Comparable<E> {

  private static final long serialVersionUID = 18912738L;

  /**
   * Gets id.
   *
   * @return the id
   */
  public abstract K getId();

  /**
   * Sets id.
   *
   * @param id the id
   */
  public abstract void setId(K id);

  /**
   * Is new boolean.
   *
   * @return the boolean
   */
  public boolean isNew() {
    return Objects.isNull(getId());
  }

  @Override
  public boolean equals(Object object) {
    if (Objects.isNull(object))
      return false;

    if (object == this)
      return true;

    ManagerEntity<K, E> entity = (ManagerEntity<K, E>) object;
    K id = getId();

    if (Objects.isNull(id))
      return false;

    return id.equals(entity.getId());
  }

  @Override
  public int hashCode() {
    int hash = 7;

    K id = getId();
    hash = 31 * hash + ((id == null) ? 0 : id.hashCode());

    return hash;
  }

  public int compareTo(E o) {
    if (this == o) {
      return 0;
    }
    return this
        .getId()
        .compareTo(o.getId());
  }

  @Override
  public String toString() {
    return "ManagerEntity{}";
  }
}
