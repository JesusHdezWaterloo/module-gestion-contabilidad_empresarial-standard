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

    public static final String CONTABILIDAD_GENERAL_PATH = "/contabilidad";
    public static final String SEARCH_TEXT = "search";

    //-----------------------CUADRE-----------------------\\
    public static final String CUADRE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/cuadre";

    public static final String CUADRE_FIND_ALL_PENDING_PATH = "/find_all_pending";
    public static final RequestMethod CUADRE_FIND_ALL_PENDING_METHOD = RequestMethod.GET;

    public static final String CUADRE_FIND_ALL_LIQUIDADAS_PATH = "/find_all_liquidadas";
    public static final RequestMethod CUADRE_FIND_ALL_LIQUIDADAS_METHOD = RequestMethod.GET;

    public static final String LIQUIDADA = "liquidada";
    public static final String CUADRE_FIND_BY_LIQUIDADA_PATH = "/find_by_liquidada/{" + LIQUIDADA + "}";
    public static final RequestMethod CUADRE_FIND_BY_LIQUIDADA_METHOD = RequestMethod.GET;

    //-----------------------CUENTA BANCARIA-----------------------\\
    public static final String CUENTA_BANCARIA_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/cuenta_bancaria";

    public static final String CUENTA_BANCARIA_FIND_ALL_CUENTAS_PATH = "/find_all_cuentas";
    public static final RequestMethod CUENTA_BANCARIA_FIND_ALL_CUENTAS_METHOD = RequestMethod.GET;

    public static final String MONEDA = "moneda";
    public static final String CUENTA_BANCARIA_FIND_DEFAULT_PATH = "/find_default/{" + MONEDA + "}";
    public static final RequestMethod CUENTA_BANCARIA_FIND_DEFAULT_METHOD = RequestMethod.GET;

    public static final String CUENTA_BANCARIA_FIND_ALL_SEARCH_PATH = "/find_all/{" + SEARCH_TEXT + "}";
    public static final RequestMethod CUENTA_BANCARIA_FIND_ALL_SEARCH_METHOD = RequestMethod.GET;

    //-----------------------CUENTA CONTABLE-----------------------\\
    public static final String CUENTA_CONTABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/cuenta_contable";

    public static final String CUENTA_CONTABLE_FIND_ALL_CUENTAS_PATH = "/find_all_cuentas";
    public static final RequestMethod CUENTA_CONTABLE_FIND_ALL_CUENTAS_METHOD = RequestMethod.GET;

    public static final String TIPO_CUENTA = "tipo_cuenta";
    public static final String CUENTA_CONTABLE_FIND_ALL_PATH = "/find_all_cuentas/{" + TIPO_CUENTA + "}";
    public static final RequestMethod CUENTA_CONTABLE_FIND_ALL_METHOD = RequestMethod.GET;

    public static final String CUENTA_CONTABLE_FIND_ALL_SEARCH_PATH = "/find_all/{" + SEARCH_TEXT + "}";
    public static final RequestMethod CUENTA_CONTABLE_FIND_ALL_SEARCH_METHOD = RequestMethod.GET;

    //-----------------------DEFAULT PAGABLE-----------------------\\
    public static final String DEFAULT_PAGABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/default_pagable";

    //-----------------------FORMA PAGO-----------------------\\
    public static final String FORMA_PAGO_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/forma_pago";

    //-----------------------INFO OP CONTABLE-----------------------\\
    public static final String INFO_OP_CONTABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/info_op_contable";

    //-----------------------LIQUIDACION-----------------------\\
    public static final String LIQUIDACION_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/liquidacion";
    
    public static final String CUENTA = "cuenta";
    public static final String LIQUIDACION_FIND_ALL_PATH = "/find_all_liq/{" + CUENTA + "}";
    public static final RequestMethod LIQUIDACION_FIND_ALL_METHOD = RequestMethod.GET;

    public static final String CUADRE = "cuadre";
    public static final String LIQUIDACION_GET_PATH = "/get/{" + CUADRE + "}";
    public static final RequestMethod LIQUIDACION_GET_METHOD = RequestMethod.GET;
}
