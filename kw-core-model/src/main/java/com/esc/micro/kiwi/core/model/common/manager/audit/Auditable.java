package com.esc.micro.kiwi.core.model.common.manager.audit;

/**
 * The interface Auditable.
 */
public interface Auditable {

  /**
   * Gets audit section.
   *
   * @return the audit section
   */
  AuditSection getAuditSection();

  /**
   * Sets audit section.
   *
   * @param audit the audit
   */
  void setAuditSection(AuditSection audit);
}
