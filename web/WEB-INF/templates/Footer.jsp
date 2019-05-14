<%--
    Document   : footer.jsp
    Created on : 9 mai 2019, 13:34:47
    Author     : Herbert Caffarel <herbert.caffarel@cicef.pro>
--%>

<c:if test="${param.footer != null}">
    <jsp:include page="/WEB-INF/view/${param.footer}.jsp" />
</c:if>

<%-- V�rification de la pr�sence d'un objet utilisateur en session --%>
<c:choose>
    <c:when test="${!empty sessionScope.sessionUtilisateur}">
        <p class="success">Vous �tes connect�(e) avec l'adresse :${sessionScope.sessionUtilisateur.mail}</p>
    </c:when>
    <c:otherwise>
        <p>Vous n'�tes pas connect�(e)</p>
    </c:otherwise>
</c:choose>
