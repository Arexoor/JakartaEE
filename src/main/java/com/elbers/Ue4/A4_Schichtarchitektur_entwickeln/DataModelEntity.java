package com.elbers.Ue4.A4_Schichtarchitektur_entwickeln;

import jakarta.persistence.*;

@Entity
@Table(name = "DataModel", schema = "JPA_example")
public class DataModelEntity{
    @Basic
    @Column(name = "red", nullable = true)
    private Integer m_redValue;
    @Basic
    @Column(name = "green", nullable = true)
    private Integer m_greenValue;
    @Basic
    @Column(name = "blue", nullable = true)
    private Integer m_blueValue;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public Integer getM_redValue() {
        return m_redValue;
    }

    public void setM_redValue(Integer m_redValue) {
        this.m_redValue = m_redValue;
    }

    public Integer getM_greenValue() {
        return m_greenValue;
    }

    public void setM_greenValue(Integer m_greenValue) {
        this.m_greenValue = m_greenValue;
    }

    public Integer getM_blueValue() {
        return m_blueValue;
    }

    public void setM_blueValue(Integer m_blueValue) {
        this.m_blueValue = m_blueValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataModelEntity that = (DataModelEntity) o;

        if (id != that.id) return false;
        if (m_redValue != null ? !m_redValue.equals(that.m_redValue) : that.m_redValue != null) return false;
        if (m_greenValue != null ? !m_greenValue.equals(that.m_greenValue) : that.m_greenValue != null) return false;
        if (m_blueValue != null ? !m_blueValue.equals(that.m_blueValue) : that.m_blueValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = m_redValue != null ? m_redValue.hashCode() : 0;
        result = 31 * result + (m_greenValue != null ? m_greenValue.hashCode() : 0);
        result = 31 * result + (m_blueValue != null ? m_blueValue.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
