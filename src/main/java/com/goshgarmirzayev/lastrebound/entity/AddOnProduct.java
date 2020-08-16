/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goshgarmirzayev.lastrebound.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "add_on_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddOnProduct.findAll", query = "SELECT a FROM AddOnProduct a")
    , @NamedQuery(name = "AddOnProduct.findById", query = "SELECT a FROM AddOnProduct a WHERE a.id = :id")})
public class AddOnProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "add_on_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AddOn addOnId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public AddOnProduct() {
    }

    public AddOnProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddOn getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(AddOn addOnId) {
        this.addOnId = addOnId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof AddOnProduct)) {
            return false;
        }
        AddOnProduct other = (AddOnProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goshgarmirzayev.lastrebound.entity.AddOnProduct[ id=" + id + " ]";
    }
    
}
