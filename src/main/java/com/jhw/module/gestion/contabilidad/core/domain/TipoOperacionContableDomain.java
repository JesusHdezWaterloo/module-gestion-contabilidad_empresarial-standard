/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain;

import com.clean.core.exceptions.ValidationException;
import com.clean.core.utils.SortBy;
import com.clean.core.utils.validation.ValidationMessage;
import com.clean.core.utils.validation.ValidationResult;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreOperacion"})
public class TipoOperacionContableDomain extends EntityDomainObjectValidated {

    private Integer idTipoOperacion;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_operacion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_operacion_nombre_largo#")
    private String nombreOperacion;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.tipo_operacion_cuenta#")
    private TipoCuentaDomain tipoCuentaCuadreDefectoFk;

    @NotNull(message = "#msg.module.contabilidad.validation.tipo_operacion_cuenta_cuadre#")
    private TipoCuentaDomain tipoCuentaDefectoFk;

    public TipoOperacionContableDomain() {
    }

    public TipoOperacionContableDomain(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public TipoOperacionContableDomain(String nombreOperacion, String descripcion, TipoCuentaDomain tipoCuentaCuadreDefectoFk, TipoCuentaDomain tipoCuentaDefectoFk) {
        this.nombreOperacion = nombreOperacion;
        this.descripcion = descripcion;
        this.tipoCuentaCuadreDefectoFk = tipoCuentaCuadreDefectoFk;
        this.tipoCuentaDefectoFk = tipoCuentaDefectoFk;
        validate();
    }

    public Integer getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuentaDomain getTipoCuentaCuadreDefectoFk() {
        return tipoCuentaCuadreDefectoFk;
    }

    public void setTipoCuentaCuadreDefectoFk(TipoCuentaDomain tipoCuentaCuadreDefectoFk) {
        this.tipoCuentaCuadreDefectoFk = tipoCuentaCuadreDefectoFk;
    }

    public TipoCuentaDomain getTipoCuentaDefectoFk() {
        return tipoCuentaDefectoFk;
    }

    public void setTipoCuentaDefectoFk(TipoCuentaDomain tipoCuentaDefectoFk) {
        this.tipoCuentaDefectoFk = tipoCuentaDefectoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOperacion != null ? idTipoOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOperacionContableDomain)) {
            return false;
        }
        TipoOperacionContableDomain other = (TipoOperacionContableDomain) object;
        if ((this.idTipoOperacion == null && other.idTipoOperacion != null) || (this.idTipoOperacion != null && !this.idTipoOperacion.equals(other.idTipoOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreOperacion;
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = super.validate();

        //liquidable
        if (!getTipoCuentaCuadreDefectoFk().isLiquidable()) {
            v.add(ValidationMessage.from("operacionContableCuadreFk", "No se puede hacer un cuadre contra una cuenta que no sea liquidable."));
        }
        return v.throwException();
    }
}
