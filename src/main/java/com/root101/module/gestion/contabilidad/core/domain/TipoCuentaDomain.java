/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.contabilidad.core.domain;

import com.root101.clean.core.utils.SortBy;
import com.root101.module.gestion.contabilidad.utils.Equivalent;
import com.root101.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@SortBy(priority = {"nombreTipoCuenta"})
public class TipoCuentaDomain extends EntityDomainObjectValidated implements Equivalent<TipoCuentaDomain> {

    private Integer idTipoCuenta;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_cuenta_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_cuenta_nombre_largo#")
    private String nombreTipoCuenta;

    private boolean debitoCredito;

    private boolean liquidable;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public TipoCuentaDomain() {
    }

    public TipoCuentaDomain(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public TipoCuentaDomain(String nombreTipoCuenta, boolean debitoCredito, boolean liquidable, String descripcion) {
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.debitoCredito = debitoCredito;
        this.liquidable = liquidable;
        this.descripcion = descripcion;
        validate();
    }

    @Override
    public boolean equivalent(TipoCuentaDomain other) {
        return this.liquidable == other.liquidable && debitoCredito == other.debitoCredito;
    }

    public boolean isLiquidable() {
        return liquidable;
    }

    public void setLiquidable(boolean liquidable) {
        this.liquidable = liquidable;
    }

    public Integer getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public boolean getDebitoCredito() {
        return debitoCredito;
    }

    public String debito_credito() {
        return getDebitoCredito() ? "DEBITO" : "CREDITO";
    }

    public String liquidable() {
        return isLiquidable() ? "SI" : "NO";
    }

    public void setDebitoCredito(boolean debitoCredito) {
        this.debitoCredito = debitoCredito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCuenta != null ? idTipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaDomain)) {
            return false;
        }
        TipoCuentaDomain other = (TipoCuentaDomain) object;
        if ((this.idTipoCuenta == null && other.idTipoCuenta != null) || (this.idTipoCuenta != null && !this.idTipoCuenta.equals(other.idTipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTipoCuenta;
    }

}
