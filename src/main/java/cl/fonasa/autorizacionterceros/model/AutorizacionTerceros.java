package cl.fonasa.autorizacionterceros.model;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TBLAUTORIZACIONTERCEROS", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class AutorizacionTerceros implements Serializable{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="RUN_TERCERO", nullable = false, length = 20)
    private String runTercero;

    @Column(name="RUN_BENEFICIARIO", nullable = false, length = 20)
    private String runBeneficiario;
    @Column(name="RUN_EJECUTIVO", nullable = false, length = 20)
    private String runEjecutivo;

    @Column(name="NOMBRE_EJECUTIVO", nullable = false, length = 70)
    private String nombreEjecutivo;
    @Column(name="ID_USUARIO", nullable = false, length = 20)
    private String idUsuario;

    @Column(name="ID_ROL", nullable = false, length = 40)
    private String idRol;

    @Column(name="CODIGO_DIRECCION_ZONAL", nullable = false, length = 20)
    private String codigoDireccionZonal;
    @Column(name="CODIGO_REGION", nullable = false, length = 20)
    private String codigoRegion;
    @Column(name="CODIGO_COMUNA", nullable = false, length = 20)
    private String codigoComuna;
    @Column(name="CODIGO_SUCURSAL", nullable = false, length = 20)
    private String codigoSucursal;
    @Column(name="ID_ESTADO", nullable = false, length = 1)
    private String idEstado;
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_TRANS", nullable = false)
    private Date fechaTrans;
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_INICIO", nullable = false)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_TERMINO", nullable = true)
    private Date fechaTermino;
    @Column(name="ID_TIPO_PARENTESCO", nullable = false, length = 20)
    private String idTipoParentesco;

    @Column(name="NOMBRE_TERCERO", nullable = false, length = 50)
    private String nombreTercero;
    @Column(name="PRIMER_AP_TERCERO", nullable = false, length = 50)
    private String primerApTercero;
    @Column(name="SEGUNDO_AP_TERCERO", nullable = false, length = 50)
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

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
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
}
