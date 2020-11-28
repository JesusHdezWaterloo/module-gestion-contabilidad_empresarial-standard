/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain.facade;

import com.jhw.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DocNombreUI extends EntityDomainObjectValidated {

    @NotEmpty(message = "#msg.module.contabilidad.validation.info_operacion_documento_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.operacion_documento_largo#")
    private String documento;

    @NotEmpty(message = "#msg.module.contabilidad.validation.info_operacion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.info_operacion_nombre_largo#")
    private String nombre;


    public DocNombreUI() {
    }

    public DocNombreUI(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
        validate();
    }

    public DocNombreUI(InfoOperacionContableDomain info) {
        this.nombre = info.getNombre();
        this.documento = info.getDocumento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
