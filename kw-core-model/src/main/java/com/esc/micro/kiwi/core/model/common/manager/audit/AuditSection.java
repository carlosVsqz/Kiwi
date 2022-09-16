package com.esc.micro.kiwi.core.model.common.manager.audit;

import com.esc.micro.kiwi.core.model.common.utils.CloneUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


/**
 * The type Audit section.
 */
@Embeddable
public class AuditSection implements Serializable {

  private static final long serialVersionUID = 1L;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_AT")
  private Date createAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "UPDATE_AT")
  private Date updateAt;

  @Column(name = "UPDT_ID", length = 60)
  private String modifiedBy;

  /**
   * Instantiates a new Audit section.
   */
  public AuditSection() {
  }

  /**
   * Gets create at.
   *
   * @return the create at
   */
  public Date getCreateAt() {
    return CloneUtils.clone(createAt);
  }

  /**
   * Sets create at.
   *
   * @param createAt the create at
   */
  public void setCreateAt(Date createAt) {
    this.createAt = CloneUtils.clone(createAt);
  }

  /**
   * Gets date modified.
   *
   * @return the date modified
   */
  public Date getDateModified() {
    return CloneUtils.clone(updateAt);
  }

  /**
   * Sets date modified.
   *
   * @param modifiedAt the modified at
   */
  public void setDateModified(Date modifiedAt) {
    this.updateAt = CloneUtils.clone(modifiedAt);
  }

  /**
   * Gets modified by.
   *
   * @return the modified by
   */
  public String getModifiedBy() {
    return modifiedBy;
  }

  /**
   * Sets modified by.
   *
   * @param modifiedBy the modified by
   */
  public void setModifiedBy(String modifiedBy) {
    if (!StringUtils.isBlank(modifiedBy)) {
      if (modifiedBy.length() > 20) {
        modifiedBy = modifiedBy.substring(0, 20);
      }
    }
    this.modifiedBy = modifiedBy;
  }
}
