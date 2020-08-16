/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goshgarmirzayev.lastrebound.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "add_on")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddOn.findAll", query = "SELECT a FROM AddOn a")
    , @NamedQuery(name = "AddOn.findById", query = "SELECT a FROM AddOn a WHERE a.id = :id")
    , @NamedQuery(name = "AddOn.findByPrice", query = "SELECT a FROM AddOn a WHERE a.price = :price")
    , @NamedQuery(name = "AddOn.findByWidth", query = "SELECT a FROM AddOn a WHERE a.width = :width")
    , @NamedQuery(name = "AddOn.findByHeight", query = "SELECT a FROM AddOn a WHERE a.height = :height")})
public class AddOn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "width")
    private int width;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private int height;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addOnId")
    private List<AddOnProduct> addOnProductList;

    public AddOn() {
    }

    public AddOn(Integer id) {
        this.id = id;
    }

    public AddOn(Integer id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @XmlTransient
    public List<AddOnProduct> getAddOnProductList() {
        return addOnProductList;
    }

    public void setAddOnProductList(List<AddOnProduct> addOnProductList) {
        this.addOnProductList = addOnProductList;
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
        if (!(object instanceof AddOn)) {
            return false;
        }
        AddOn other = (AddOn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goshgarmirzayev.lastrebound.entity.AddOn[ id=" + id + " ]";
    }
    
}
