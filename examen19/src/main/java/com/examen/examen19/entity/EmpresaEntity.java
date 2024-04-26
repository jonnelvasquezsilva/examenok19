package com.examen.examen19.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "empresa")
@Getter
@Setter


public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="razon_social")
    private String razonSocial;
    @Column(name="tipo_documento")
    private String tipoDocumento;
    @Column(name="numero_documento")
    private String numeroDocumento;
    private String condicion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    @Column(name="es_agente_retencion")
    private Boolean esAgenteRetencion;
    private Integer estado;
    private String usua_crea;
    private LocalDateTime date_create;
    private String usua_modif;
    private LocalDateTime date_modif;
    private String usua_delet;
    private LocalDateTime date_delet;

}
