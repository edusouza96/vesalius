<%-- 
    Document   : cadastro
    Created on : 19/02/2017, 10:37:38
    Author     : Edu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"  pageEncoding="Iso-8859-1"%>
<!DOCTYPE html>
<html  lang="pt-br">
    <head>
        <link rel="shortcut icon" href="<c:url value="../resources/img/icone.png"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

        <meta charset="UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="<c:url value="../resources/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="../resources/js/jquery.maskedinput.js"/>"></script>
        <title>Cadastro</title>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            $(document).ready(function(){
                $("input#cpfPaciente").mask("999.999.999-99");
                document.getElementById("cidadePaciente").selectedIndex = document.getElementById("idCidade").value;
                        
                var inputDiabete = document.getElementById("diabetePaciente");
                if(inputDiabete.value != 'false'){
                   inputDiabete.checked = true;                    
                }
                
                var inputAids = document.getElementById("aidsPaciente");
                if(inputAids.value != 'false'){
                   inputAids.checked = true;                    
                }
                
                var inputHepatite = document.getElementById("hepatitePaciente");
                if(inputHepatite.value != 'false'){
                   inputHepatite.checked = true;                    
                }
                
                var inputFumante = document.getElementById("fumantePaciente");
                if(inputFumante.value != 'false'){
                   inputFumante.checked = true;                    
                }
                
                var inputGravidez = document.getElementById("gravidezPaciente");
                if(inputGravidez.value != 'false'){
                   inputGravidez.checked = true;                    
                }
                
                var inputAlergico = document.getElementById("alergicoPaciente");
                if(inputAlergico.value != 'false'){
                    inputAlergico.checked = true;
                }
            });
            function teste(foto){
                var fotoPaciente = document.getElementById("fotoPaciente").value;
                console.log(fotoPaciente);
            }
            function marcarCbx(idInput){
                var input = document.getElementById(idInput);
                if(input.checked){
                    input.value = 1;
                }else{
                    input.value = 0;
                }
            }
            function cadastroBasico(){
                var basico = document.getElementsByClassName('cadastro-basico');
                for(var i=0; i<basico.length; i++){
                    basico[i].style.display = 'block';
                }
                
                var completo = document.getElementsByClassName('cadastro-completo');
                for(var i=0; i<completo.length; i++){
                    completo[i].style.display = 'none';
                }
                
                var doenca = document.getElementsByClassName('cadastro-doenca');
                for(var i=0; i<doenca.length; i++){
                    doenca[i].style.display = 'none';
                }
            }
            function cadastroCompleto(){
                var basico = document.getElementsByClassName('cadastro-basico');
                for(var i=0; i<basico.length; i++){
                    basico[i].style.display = 'block';
                }
                
                var completo = document.getElementsByClassName('cadastro-completo');
                for(var i=0; i<completo.length; i++){
                    completo[i].style.display = 'block';
                }
                
                var doenca = document.getElementsByClassName('cadastro-doenca');
                for(var i=0; i<doenca.length; i++){
                    doenca[i].style.display = 'none';
                }
            }
            function cadastroDoenca(){
                var basico = document.getElementsByClassName('cadastro-basico');
                for(var i=0; i<basico.length; i++){
                    basico[i].style.display = 'none';
                }
                
                var completo = document.getElementsByClassName('cadastro-completo');
                for(var i=0; i<completo.length; i++){
                    completo[i].style.display = 'none';
                }
                
                var doenca = document.getElementsByClassName('cadastro-doenca');
                for(var i=0; i<doenca.length; i++){
                    doenca[i].style.display = 'block';
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            
            <form action="cadastro" method="POST" >
                <p id="ok">${ok}</p>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group menuPaciente">
                            <span class="menuPacienteSpan" onclick="cadastroBasico();">Cadastro Básico</span>
                            <span class="menuPacienteSpan" onclick="cadastroCompleto();">Cadastro Completa</span>
                            <span class="menuPacienteSpan" onclick="cadastroDoenca();">Cadastro de Saúde</span>
                        </div>
                    </div>
                </div>
                <div class="row cadastro-basico">
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group">
                            <label for="nomePaciente">Nome</label>
                            <input type="text" name="nomePaciente" id="nomePaciente" value="${paciente.nomePaciente}" class="form-control" required/>
                            <input type="hidden" name="idPaciente" id="idPaciente" value="${paciente.idPaciente}"/>
                        </div>
                        
                    </div>
                </div>
                        
                <div class="row cadastro-basico">
                    <div class="col-xs-12 col-sm-4 col-lg-2 col-md-4">
                        <div class="form-group">
                            <label for="nascimentoPaciente">Data de Nascimento</label>
                            <input type="date" name="nascimentoPaciente" id="nascimentoPaciente" value="${paciente.nascimentoPaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-12 col-sm-4 col-lg-2 col-md-4">
                        <div class="form-group">
                            <label for="inicioTratamentoPaciente">Inicio Tratamento</label>
                            <input type="date" name="inicioTratamentoPaciente" id="inicioTratamentoPaciente" value="${paciente.inicioTratamentoPaciente}" class="form-control"/>
                        </div>
                    </div>
                
                    <div class="col-xs-12 col-sm-4 col-lg-3 col-md-4">
                        <div class="form-group">
                            <label for="cpfPaciente">CPF</label>
                            <input type="text" name="cpfPaciente" id="cpfPaciente" value="${paciente.cpfPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-completo">
                    <div class="col-xs-8 col-sm-3 col-lg-2 col-md-3">
                        <div class="form-group" onclick="teste(0);">
                            <img src="<c:url value="../resources/img/${paciente.fotoPaciente}"/>" style="width: 80%;height: 150px;"/>
                        </div>
                    </div>  
                    <div class="col-xs-12 col-sm-9 col-lg-5 col-md-9">
                        <div class="form-group">
                            <label for="fotoPaciente">Foto</label>
                            <input type="file" name="fotoPaciente" id="fotoPaciente" value="${paciente.fotoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                
                <div class="row cadastro-completo">
                    <div class="col-xs-12 col-sm-12 col-lg-4 col-md-6">
                        <div class="form-group">
                            <label for="profissaoPaciente">Profissão</label>
                            <input type="text" name="profissaoPaciente" id="profissaoPaciente" value="${paciente.profissaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                
                    <div class="col-xs-12 col-sm-12 col-lg-3 col-md-6">
                        <div class="form-group">
                            <label for="indicacaoPaciente">Indicado Por</label>
                            <input type="text" name="indicacaoPaciente" id="indicacaoPaciente" value="${paciente.indicacaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-basico">
                    <div class="col-xs-12 col-sm-4 col-lg-2 col-md-4">
                        <div class="form-group">
                            <label for="telefonePaciente">Telefone</label>
                            <input type="tel" name="telefonePaciente" id="telefonePaciente" value="${paciente.telefonePaciente}" class="form-control" required/>
                        </div>
                    </div>
                        
                   <div class="col-xs-12 col-sm-4 col-lg-2 col-md-4">
                        <div class="form-group">
                            <label for="telefoneOpcionalPaciente">Telefone 2</label>
                            <input type="tel" name="telefoneOpcionalPaciente" id="telefoneOpcionalPaciente" value="${paciente.telefoneOpcionalPaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-12 col-sm-4 col-lg-2 col-md-4">
                        <div class="form-group">
                            <label for="whatsappPaciente">Whatsapp</label>
                            <input type="tel" name="whatsappPaciente" id="whatsappPaciente" value="${paciente.whatsappPaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                </div>
                
                <div class="row cadastro-completo">                    
                    <div class="col-xs-12 col-sm-12 col-lg-3 col-md-6">
                        <div class="form-group">
                            <label for="facebookPaciente">Facebook</label>
                            <input type="text" name="facebookPaciente" id="facebookPaciente" value="${paciente.facebookPaciente}" class="form-control"/>
                        </div>
                    </div>
                
                    <div class="col-xs-12 col-sm-12 col-lg-4 col-md-6">
                        <div class="form-group">
                            <label for="emailPaciente">E-mail</label>
                            <input type="email" name="emailPaciente" id="emailPaciente" value="${paciente.emailPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-completo">
                    <div class="col-xs-12 col-sm-12 col-lg-3 col-md-6">
                        <div class="form-group">
                            <label for="cidadePaciente">Cidade</label>
                            <input type="hidden" name="idCidade" id="idCidade" value="${paciente.cidadePaciente}"/>
                            <select name="cidadePaciente" id="cidadePaciente" class="form-control">
                                <option value>Selecione</option>
                                <option value="1">Canoas</option>
                                <option value="2">Gravataí</option>
                                <option value="3">Porto Alegre</option>
                                <option value="4">Viamão</option>
                            </select>
                        </div>
                    </div>
                        
                    <div class="col-xs-12 col-sm-12 col-lg-4 col-md-6">
                        <div class="form-group">
                            <label for="bairroPaciente">Bairro</label>
                            <input type="text" name="bairroPaciente" id="bairroPaciente" value="${paciente.bairroPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-completo">                    
                    <div class="col-xs-12 col-sm-12 col-lg-5 col-md-7">
                        <div class="form-group">
                            <label for="logradouroPaciente">Logradouro</label>
                            <input type="text" name="logradouroPaciente" id="logradouroPaciente" value="${paciente.logradouroPaciente}" class="form-control"/>
                        </div>
                    </div>
                    
                    <div class="col-xs-12 col-sm-12 col-lg-2 col-md-5">
                        <div class="form-group">
                            <label for="numeroPaciente">Nº</label>
                            <input type="text" name="numeroPaciente" id="numeroPaciente" value="${paciente.numeroPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-basico">
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group">
                            <label for="descricaoPaciente">Observações</label>
                            <textarea cols="10" rows="3" name="descricaoPaciente" id="descricaoPaciente" class="form-control">${paciente.descricaoPaciente}</textarea> 
                        </div>
                    </div>
                </div>
                      
                <div class="row cadastro-doenca">    
                    <div class="col-xs-3 col-sm-1 col-lg-1 col-md-1">
                        <div class="form-group">
                            <label for="diabetePaciente">Diabete</label>
                            <input onclick="marcarCbx('diabetePaciente');" type="checkbox" name="diabetePaciente" id="diabetePaciente" value="${paciente.diabetePaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-9 col-sm-10 col-lg-6 col-md-10">
                        <div class="form-group">
                            <label for="diabeteDescricaoPaciente">Descrição</label>
                            <input type="text" name="diabeteDescricaoPaciente" id="diabeteDescricaoPaciente" value="${paciente.diabeteDescricaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-doenca">    
                    <div class="col-xs-3 col-sm-1 col-lg-1 col-md-1">
                        <div class="form-group">
                            <label for="aidsPaciente">Aids</label>
                            <input type="checkbox" onclick="marcarCbx('aidsPaciente');" name="aidsPaciente" id="aidsPaciente" value="${paciente.aidsPaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-9 col-sm-10 col-lg-6 col-md-10">
                        <div class="form-group">
                            <label for="aidsDescricaoPaciente">Descrição</label>
                            <input type="text" name="aidsDescricaoPaciente" id="aidsDescricaoPaciente" value="${paciente.aidsDescricaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-doenca">    
                    <div class="col-xs-3 col-sm-1 col-lg-1 col-md-1">
                        <div class="form-group">
                            <label for="hepatitePaciente">Hepatite</label>
                            <input type="checkbox" onclick="marcarCbx('hepatitePaciente');" name="hepatitePaciente" id="hepatitePaciente" value="${paciente.hepatitePaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-9 col-sm-10 col-lg-6 col-md-10">
                        <div class="form-group">
                            <label for="hepatiteDescricaoPaciente">Descrição</label>
                            <input type="text" name="hepatiteDescricaoPaciente" id="hepatiteDescricaoPaciente" value="${paciente.hepatiteDescricaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-doenca">    
                    <div class="col-xs-3 col-sm-1 col-lg-1 col-md-1">
                        <div class="form-group">
                            <label for="fumantePaciente">Fumante</label>
                            <input type="checkbox" onclick="marcarCbx('fumantePaciente');" name="fumantePaciente" id="fumantePaciente" value="${paciente.fumantePaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-9 col-sm-10 col-lg-6 col-md-10">
                        <div class="form-group">
                            <label for="fumanteDescricaoPaciente">Descrição</label>
                            <input type="text" name="fumanteDescricaoPaciente" id="fumanteDescricaoPaciente" value="${paciente.fumanteDescricaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-doenca">    
                    <div class="col-xs-3 col-sm-1 col-lg-1 col-md-1">
                        <div class="form-group">
                            <label for="gravidezPaciente">Gravida</label>
                            <input type="checkbox" onclick="marcarCbx('gravidezPaciente');" name="gravidezPaciente" id="gravidezPaciente" value="${paciente.gravidezPaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-9 col-sm-10 col-lg-6 col-md-10">
                        <div class="form-group">
                            <label for="gravidezDescricaoPaciente">Descrição</label>
                            <input type="text" name="gravidezDescricaoPaciente" id="gravidezDescricaoPaciente" value="${paciente.gravidezDescricaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-doenca">    
                    <div class="col-xs-3 col-sm-1 col-lg-1 col-md-1">
                        <div class="form-group">
                            <label for="alergicoPaciente">Alergico</label>
                            <input type="checkbox" onclick="marcarCbx('alergicoPaciente');" name="alergicoPaciente" id="alergicoPaciente" value="${paciente.alergicoPaciente}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-9 col-sm-10 col-lg-6 col-md-10">
                        <div class="form-group">
                            <label for="alergicoDescricaoPaciente">Descrição</label>
                            <input type="text" name="alergicoDescricaoPaciente" id="alergicoDescricaoPaciente" value="${paciente.alergicoDescricaoPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row cadastro-doenca">    
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group">
                            <label for="outrasDoencasPaciente">Outras</label>
                            <input type="text" name="outrasDoencasPaciente" id="outrasDoencasPaciente" value="${paciente.outrasDoencasPaciente}" class="form-control"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <input type="submit" value="Salvar" id="submit" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
            </form>
                
        </div>
    </body>
</html>
