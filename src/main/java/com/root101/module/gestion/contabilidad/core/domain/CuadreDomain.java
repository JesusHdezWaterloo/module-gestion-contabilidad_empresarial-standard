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

import com.root101.clean.core.exceptions.ValidationException;
import com.root101.clean.core.utils.SortBy;
import com.root101.clean.core.utils.validation.ValidationMessage;
import com.root101.clean.core.utils.validation.ValidationResult;
import com.root101.module.gestion.contabilidad.utils.MonedaHandler;
import com.root101.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@SortBy(priority = {"liquidada"}, order = SortBy.ASCENDING)
public class CuadreDomain extends EntityDomainObjectValidated implements Comparable<CuadreDomain> {

    private static final long serialVersionUID = 1L;

    private Integer idCuadre;

    private boolean liquidada;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContableDomain operacionContableCuadreFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContableDomain operacionContableFk;

    public CuadreDomain() {
    }

    public CuadreDomain(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public CuadreDomain(boolean liquidada, OperacionContableDomain operacionContableCuadreFk, OperacionContableDomain operacionContableFk) {
        this.liquidada = liquidada;
        this.operacionContableCuadreFk = operacionContableCuadreFk;
        this.operacionContableFk = operacionContableFk;
        validate();
    }

    public InfoOperacionContableDomain info() {
        return operacionContableCuadreFk.getInfoOperacionContableFk();
    }

    public Integer getIdCuadre() {
        return idCuadre;
    }

    public void setIdCuadre(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public boolean getLiquidada() {
        return liquidada;
    }

    public void setLiquidada(boolean liquidada) {
        this.liquidada = liquidada;
    }

    public OperacionContableDomain getOperacionContableCuadreFk() {
        return operacionContableCuadreFk;
    }

    public void setOperacionContableCuadreFk(OperacionContableDomain operacionContableCuadreFk) {
        this.operacionContableCuadreFk = operacionContableCuadreFk;
    }

    public OperacionContableDomain getOperacionContableFk() {
        return operacionContableFk;
    }

    public void setOperacionContableFk(OperacionContableDomain operacionContableFk) {
        this.operacionContableFk = operacionContableFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuadre != null ? idCuadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuadreDomain)) {
            return false;
        }
        CuadreDomain other = (CuadreDomain) object;
        if ((this.idCuadre == null && other.idCuadre != null) || (this.idCuadre != null && !this.idCuadre.equals(other.idCuadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return operacionContableCuadreFk.toString();
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = super.validate();

        //debito-credito
        if (0 != getOperacionContableFk().getDebito().compareTo(MonedaHandler.venta(getOperacionContableCuadreFk().getCredito(), getOperacionContableCuadreFk().getCuentaFk().getMonedaFk(), getOperacionContableFk().getCuentaFk().getMonedaFk()))) {
            v.add(ValidationMessage.from("operacionContableFk", "Lo que se debita en la cuenta inicial no coincide con lo que se acredita en el cuadre."));
        }
        if (0 != getOperacionContableFk().getCredito().compareTo(MonedaHandler.venta(getOperacionContableCuadreFk().getDebito(), getOperacionContableCuadreFk().getCuentaFk().getMonedaFk(), getOperacionContableFk().getCuentaFk().getMonedaFk()))) {
            v.add(ValidationMessage.from("operacionContableFk", "Lo que se acredita en la cuenta inicial no coincide con lo que se debita en el cuadre."));
        }
        //liquidable
        if (!getOperacionContableCuadreFk().getCuentaFk().getTipoCuentaFk().isLiquidable()) {
            v.add(ValidationMessage.from("operacionContableCuadreFk", "No se puede hacer un cuadre contra una cuenta que no sea liquidable."));
        }
        return v.throwException();
    }

    @Override
    public int compareTo(CuadreDomain o) {
        return -1 * info().getFecha().compareTo(o.info().getFecha());
    }

}
