/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goshgarmirzayev.lastrebound.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "auth_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthRole.findAll", query = "SELECT a FROM AuthRole a")
    , @NamedQuery(name = "AuthRole.findById", query = "SELECT a FROM AuthRole a WHERE a.id = :id")
    , @NamedQuery(name = "AuthRole.findByInsertDateTime", query = "SELECT a FROM AuthRole a WHERE a.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "AuthRole.findByLastUpdateTime", query = "SELECT a FROM AuthRole a WHERE a.lastUpdateTime = :lastUpdateTime")
    , @NamedQuery(name = "AuthRole.findByName", query = "SELECT a FROM AuthRole a WHERE a.name = :name")})
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "roleId")
    private List<AuthGroupRole> authGroupRoleList;

    public AuthRole() {
    }

    public AuthRole(Integer id) {
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<AuthGroupRole> getAuthGroupRoleList() {
        return authGroupRoleList;
    }

    public void setAuthGroupRoleList(List<AuthGroupRole> authGroupRoleList) {
        this.authGroupRoleList = authGroupRoleList;
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
        if (!(object instanceof AuthRole)) {
            return false;
        }
        AuthRole other = (AuthRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goshgarmirzayev.lastrebound.entity.AuthRole[ id=" + id + " ]";
    }
    
}
