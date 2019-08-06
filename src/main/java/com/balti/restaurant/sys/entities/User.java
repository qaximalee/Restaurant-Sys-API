package com.balti.restaurant.sys.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    @NotBlank
    private String firstName;
    
    @Column
    @NotBlank
    private String lastName;
    
    @Column
    @NotBlank
    private String email;
    
    @Column
    @CreationTimestamp
    private Date createdAt;
    
    @Column
    @NotBlank
    private String createdBy;
    
    @Column
    @UpdateTimestamp
    private Date updatedAt;
    
    @Column
    @NotBlank
    private String updatedBy;
  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
        return id;
    }
  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
        this.id = id;
    }
  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
        return firstName;
    }
  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
        return lastName;
    }
  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
        this.lastName = lastName;
    }
  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
        return email;
    }
  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
        this.email = email;
    }
  /**
   * Gets created at.
   *
   * @return the created at
   */
  public Date getCreatedAt() {
        return createdAt;
    }
  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
  /**
   * Gets created by.
   *
   * @return the created by
   */
  public String getCreatedBy() {
        return createdBy;
    }
  /**
   * Sets created by.
   *
   * @param createdBy the created by
   */
  public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
  /**
   * Gets updated at.
   *
   * @return the updated at
   */
  public Date getUpdatedAt() {
        return updatedAt;
    }
  /**
   * Sets updated at.
   *
   * @param updatedAt the updated at
   */
  public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
  /**
   * Gets updated by.
   *
   * @return the updated by
   */
  public String getUpdatedBy() {
        return updatedBy;
    }
  /**
   * Sets updated by.
   *
   * @param updatedBy the updated by
   */
  public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}