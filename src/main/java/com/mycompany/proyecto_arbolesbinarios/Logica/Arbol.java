/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_arbolesbinarios.Logica;

import javax.persistence.*;

@Entity
@Table(name = "arbol")
@NamedQueries({
        @NamedQuery(name = "Arbol.findAll", query = "SELECT a FROM Arbol a")
})
public class Arbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Dato", nullable = false)
    private int dato;

    @Column(name = "estado", nullable = false)
    private short estado;

    // Constructores, getters y setters, hashCode, equals, toString...
}