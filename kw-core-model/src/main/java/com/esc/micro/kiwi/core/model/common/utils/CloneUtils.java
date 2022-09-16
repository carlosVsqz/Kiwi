package com.esc.micro.kiwi.core.model.common.utils;

import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The type Clone utils.
 */
@NoArgsConstructor
public class CloneUtils {

  /**
   * Clone date.
   *
   * @param date the date
   * @return the date
   */
  public static Date clone(Date date) {
    if (date != null) {
      return (Date) date.clone();
    }
    return null;
  }

}
