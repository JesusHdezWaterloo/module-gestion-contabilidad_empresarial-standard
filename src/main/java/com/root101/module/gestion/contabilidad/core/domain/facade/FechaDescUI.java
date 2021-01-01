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
package com.root101.module.gestion.contabilidad.core.domain.facade;

import com.root101.module.gestion.contabilidad.core.domain.FormaPagoDomain;
import com.root101.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.root101.utils.clean.EntityDomainObjectValidated;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class FechaDescUI extends EntityDomainObjectValidated {

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_fecha_null#")
    private LocalDate fecha;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_metodo_pago_null#")
    private FormaPagoDomain pago;

    public FechaDescUI() {
    }

    public FechaDescUI(LocalDate fecha, FormaPagoDomain pago, String descripcion) {
        this.fecha = fecha;
        this.pago = pago;
        this.descripcion = descripcion;
        validate();
    }

    public FechaDescUI(InfoOperacionContableDomain info) {
        this.fecha = info.getFecha();
        this.pago = info.getFormaPagoFk();
        this.descripcion = info.getDescripcion();
        validate();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public FormaPagoDomain getPago() {
        return pago;
    }

    public void setPago(FormaPagoDomain pago) {
        this.pago = pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
