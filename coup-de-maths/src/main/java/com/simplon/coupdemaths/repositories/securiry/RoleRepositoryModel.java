package com.simplon.coupdemaths.repositories.securiry;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name= "role")
public class RoleRepositoryModel implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

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

    @Override
    public String getAuthority(){
        return name;
    }

}
//Remarque : Ce qui marque un role, c'est cette ligne : implements GrantedAuthority
