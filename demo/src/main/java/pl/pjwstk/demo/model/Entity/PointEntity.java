package pl.pjwstk.demo.model.Entity;

import javax.persistence.*;

@Entity
@Table(name = "point", schema = "route", catalog = "")
public class PointEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpoint")
    private int idpoint;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "stnumber")
    private String stnumber;
    @Basic
    @Column(name = "driver_fk")
    private Integer driverFk;

    public PointEntity(){};

    public PointEntity(int idpoint,String city, String street, String stnumber, Integer driverFk) {
        this.idpoint = idpoint;
        this.city = city;
        this.street = street;
        this.stnumber = stnumber;
        this.driverFk = driverFk;
    }

    public int getIdpoint() {
        return idpoint;
    }

    public void setIdpoint(int idpoint) {
        this.idpoint = idpoint;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStnumber() {
        return stnumber;
    }

    public void setStnumber(String stnumber) {
        this.stnumber = stnumber;
    }

    public Integer getDriverFk() {
        return driverFk;
    }

    public void setDriverFk(Integer driverFk) {
        this.driverFk = driverFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointEntity that = (PointEntity) o;

        if (idpoint != that.idpoint) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (stnumber != null ? !stnumber.equals(that.stnumber) : that.stnumber != null) return false;
        if (driverFk != null ? !driverFk.equals(that.driverFk) : that.driverFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpoint;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (stnumber != null ? stnumber.hashCode() : 0);
        result = 31 * result + (driverFk != null ? driverFk.hashCode() : 0);
        return result;
    }
}
