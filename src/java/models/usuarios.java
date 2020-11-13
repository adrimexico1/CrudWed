package models;


import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author alsorc
 */
@Entity
@Table (name="usuarios")
public class usuarios {
    @Id
    @Column(name="clave")
    private int id;
    @Column(name="nombre")
    private String name;
    @Column(name="apellidos")
    private String lastName;
    @Column(name="direccion")
    private String direction;
    @Column(name="telefono")
    private String cellPhone;

    public usuarios() {
    }

    public usuarios(int id) {
        this.id = id;
    }
    

    public usuarios(int id, String name, String lastName, String direction, String cellPhone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.direction = direction;
        this.cellPhone = cellPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    
    @Override
    public String toString(){
        return this.getId() + " " + this.getName() + " " + this.getLastName() +
                " " + this.getDirection() + " " + this.getCellPhone();
    }
    
    
    
}
