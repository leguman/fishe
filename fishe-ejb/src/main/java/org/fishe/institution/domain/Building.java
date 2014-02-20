package org.fishe.institution.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.fishe.domain.Identified;

/**
 * @author leymouna
 */
@Entity
@Table(name="building")
public class Building implements Serializable, Identified<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="organization")
    private Organization organization;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Building)) {
            return false;
        }
        Building other = (Building) object;
        
        return (this.id != null || other.id == null)
                && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return this.name;
    }
}