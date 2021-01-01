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
import com.root101.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@SortBy(priority = {"nombreFormaPago"})
public class FormaPagoDomain extends EntityDomainObjectValidated {

    private Integer idFormaPago;

    @NotEmpty(message = "#msg.module.contabilidad.validation.forma_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.forma_nombre_largo#")
    private String nombreFormaPago;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public FormaPagoDomain() {
    }

    public FormaPagoDomain(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public FormaPagoDomain(String nombreFormaPago, String descripcion) {
        this.nombreFormaPago = nombreFormaPago;
        this.descripcion = descripcion;
        validate();
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
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
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagoDomain)) {
            return false;
        }
        FormaPagoDomain other = (FormaPagoDomain) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreFormaPago;
    }

}
