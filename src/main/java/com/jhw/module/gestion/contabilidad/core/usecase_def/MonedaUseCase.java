package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;

public interface MonedaUseCase extends CRUDUseCase<MonedaDomain> {

    public MonedaDomain findMonedaBase() throws Exception;

}
