<%-- 
    Document   : detalhes
    Created on : 26/01/2017, 00:10:36
    Author     : Edu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>${tituloOperacao}</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            <p id="ok">${ok}</p>
            
            <form action="cadastro" method="POST">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <h4 style="text-transform: uppercase;"><u>${tituloOperacao}</u></h4>
                            <h5>${paciente}</h5>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <label for="descricaoFinanceiro">Descrição</label>
                            <input type="hidden" name="idFinanceiro" id="idFinanceiro" value="${financeiro.idFinanceiro}"/>
                            <input type="hidden" name="statusFinanceiro" id="statusFinanceiro" value="true"/>
                            <input type="hidden" name="valorFinanceiro" id="valorFinanceiro" value="${financeiro.valorFinanceiro}"/>
                            <input type="hidden" name="tipoFinanceiro" id="tipoFinanceiro" value="${financeiro.tipoFinanceiro}"/>
                            <input type="hidden" name="tituloFinanceiro" id="tituloFinanceiro" value="${financeiro.tituloFinanceiro}"/>
                            <input type="hidden" name="vencimentoFinanceiroStr" id="vencimentoFinanceiroStr" value="${financeiro.vencimentoFinanceiroStr}"/>
                            <input type="hidden" name="idPaciente" id="idPaciente" value="${financeiro.paciente.idPaciente}"/>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <textarea style="resize: none;width:40%;height:264px;" name="descricaoFinanceiro" class="form-control" readonly="readonly">${financeiro.descricaoFinanceiro}</textarea>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6">
                        <div class="form-group">
                            <p for="valorFinanceiro"><b>Valor Total R$ </b>${financeiro.valorFinanceiro}</p>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-lg-6 col-md-6">
                        <div class="form-group">
                            <p for="vencimentoFinanceiro"><b>Vencimento</b> ${financeiro.vencimentoFinanceiroStr}</p>
                        </div>
                    </div>
                </div>
                
                
                <div class="row">
                    <div class="col-xs-5 col-sm-5 col-lg-5 col-md-5">
                        <div class="form-group">
                            <p for="vencimentoFinanceiro"><b>Forma de Pagamento</b> ${financeiro.formaPagamento.tituloFormaPagamento}</p>
                            
                            <c:if test="${tituloOperacao != 'Detalhes'}">
                                <select name="idFormaPagamento" id="idFormaPagamento" class="form-control">
                                    <c:forEach items="${listaFormaPagamento}" var="formaPagamento">
                                        <option value="${formaPagamento.idFormaPagamento}">${formaPagamento.tituloFormaPagamento}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <a href="javascript:history.back()" id="btnVoltar" class="btn btn-primary btn-sm">Voltar</a>
                            <c:if test="${tituloOperacao != 'Detalhes'}">
                                <input type="submit" value="${tituloOperacao}" id="submit" class="btn btn-primary btn-sm"/>                            
                                <a href="deletar-${financeiro.idFinanceiro}" id="submit" class="btn btn-danger btn-sm">Excluir</a>
                            </c:if>
                        </div>
                    </div>
                </div>                      
                        
            </form>
                
        </div>
    </body>
</html>
