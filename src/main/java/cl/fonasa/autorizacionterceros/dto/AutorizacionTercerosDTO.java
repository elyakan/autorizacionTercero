package cl.fonasa.autorizacionterceros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author cacuna_ext
 * 11-01-2023
 */
@Data
@AllArgsConstructor
public class AutorizacionTercerosDTO   {

    private Long id;
    private String runTercero;
    private String runBeneficiario;
    private String runEjecutivo;
    private String nombreEjecutivo;
    private String idUsuario;
    private String idRol;



    private String codigoDireccionZonal;
    private String codigoRegion;
    private String codigoComuna;
    private String codigoSucursal;
    private String idEstado;
    private Date fechaTrans;

    private Date fechaInicio;

    private Date fechaTermino;
    private String idTipoParentesco;
    private String nombreTercero;
    private String primerApTercero;
    private String segundoApTercero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRunTercero() {
        return runTercero;
    }

    public void setRunTercero(String runTercero) {
        this.runTercero = runTercero;
    }

    public String getRunBeneficiario() {
        return runBeneficiario;
    }

    public void setRunBeneficiario(String runBeneficiario) {
        this.runBeneficiario = runBeneficiario;
    }

    public String getRunEjecutivo() {
        return runEjecutivo;
    }

    public void setRunEjecutivo(String runEjecutivo) {
        this.runEjecutivo = runEjecutivo;
    }

    public Date getFechaTrans() {
        return fechaTrans;
    }

    public void setFechaTrans(Date fechaTrans) {
        this.fechaTrans = fechaTrans;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }


    public String getNombreTercero() {
        return nombreTercero;
    }

    public void setNombreTercero(String nombreTercero) {
        this.nombreTercero = nombreTercero;
    }

    public String getPrimerApTercero() {
        return primerApTercero;
    }

    public void setPrimerApTercero(String primerApTercero) {
        this.primerApTercero = primerApTercero;
    }

    public String getSegundoApTercero() {
        return segundoApTercero;
    }

    public void setSegundoApTercero(String segundoApTercero) {
        this.segundoApTercero = segundoApTercero;
    }

    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    public void setNombreEjecutivo(String nombreEjecutivo) {
        this.nombreEjecutivo = nombreEjecutivo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoDireccionZonal() {
        return codigoDireccionZonal;
    }

    public void setCodigoDireccionZonal(String codigoDireccionZonal) {
        this.codigoDireccionZonal = codigoDireccionZonal;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public String getCodigoComuna() {
        return codigoComuna;
    }

    public void setCodigoComuna(String codigoComuna) {
        this.codigoComuna = codigoComuna;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getIdTipoParentesco() {
        return idTipoParentesco;
    }

    public void setIdTipoParentesco(String idTipoParentesco) {
        this.idTipoParentesco = idTipoParentesco;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
}
