package com.esc.micro.kiwi.core.model.common.manager.listener;

import com.esc.micro.kiwi.core.model.common.manager.audit.AuditSection;
import com.esc.micro.kiwi.core.model.common.manager.audit.Auditable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * The type Audit listener.
 */
public class AuditListener {

  /**
   * On save.
   *
   * @param o the o
   */
  @PrePersist
  public void onSave(Object o) {
    audit(o);
  }

  /**
   * On update.
   *
   * @param o the o
   */
  @PreUpdate
  public void onUpdate(Object o) {
    audit(o);
  }

  private void audit(Object o) {
    if (o instanceof Auditable) {
      Auditable audit = (Auditable) o;
      AuditSection auditSection = audit.getAuditSection();

      auditSection.setDateModified(new Date());
      if (auditSection.getCreateAt() == null) {
        auditSection.setCreateAt(new Date());
      }
      audit.setAuditSection(auditSection);
    }
  }

}
