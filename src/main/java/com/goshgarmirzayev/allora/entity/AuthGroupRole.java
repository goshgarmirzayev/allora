/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goshgarmirzayev.allora.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "auth_group_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthGroupRole.findAll", query = "SELECT a FROM AuthGroupRole a")
    , @NamedQuery(name = "AuthGroupRole.findById", query = "SELECT a FROM AuthGroupRole a WHERE a.id = :id")
    , @NamedQuery(name = "AuthGroupRole.findByInsertDateTime", query = "SELECT a FROM AuthGroupRole a WHERE a.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "AuthGroupRole.findByLastUpdateDateTime", query = "SELECT a FROM AuthGroupRole a WHERE a.lastUpdateDateTime = :lastUpdateDateTime")})
public class AuthGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private AuthGroup groupId;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private AuthRole roleId;

    public AuthGroupRole() {
    }

    public AuthGroupRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public AuthGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(AuthGroup groupId) {
        this.groupId = groupId;
    }

    public AuthRole getRoleId() {
        return roleId;
    }

    public void setRoleId(AuthRole roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthGroupRole)) {
            return false;
        }
        AuthGroupRole other = (AuthGroupRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goshgarmirzayev.lastrebound.entity.AuthGroupRole[ id=" + id + " ]";
    }
    
}
