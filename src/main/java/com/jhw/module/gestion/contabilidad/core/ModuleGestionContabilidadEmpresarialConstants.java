/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ModuleGestionContabilidadEmpresarialConstants {

    public static final String CUADRE_GENERAL_PATH = "/cuadre";
    
    public static final String CUADRE_FIND_ALL_PENDING_PATH = "/find_all_pending";
    public static final RequestMethod CUADRE_FIND_ALL_PENDING_METHOD = RequestMethod.GET;
    
    public static final String CUADRE_FIND_ALL_LIQUIDADAS_PATH = "/find_all_liquidadas";
    public static final RequestMethod CUADRE_FIND_ALL_LIQUIDADAS_METHOD = RequestMethod.GET;
    
    public static final String LIQUIDADA = "liquidada";
    public static final String CUADRE_FIND_BY_LIQUIDADA_PATH = "/find_by_liquidada/{" + LIQUIDADA + "}";
    public static final RequestMethod CUADRE_FIND_BY_LIQUIDADA_METHOD = RequestMethod.GET;

}
