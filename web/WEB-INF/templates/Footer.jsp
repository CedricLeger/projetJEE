<%--
    Document   : footer.jsp
    Created on : 9 mai 2019, 13:34:47
    Author     : Herbert Caffarel <herbert.caffarel@cicef.pro>
--%>

<c:if test="${param.footer != null}">
    <jsp:include page="/WEB-INF/view/${param.footer}.jsp" />
</c:if>

<%-- Vérification de la présence d'un objet utilisateur en session --%>
<c:choose>
    <c:when test="${!empty sessionScope.userSession}">
        <p class="success">Vous êtes connecté(e) avec l'adresse : ${sessionScope.userSession.email}</p>
    </c:when>
    <c:otherwise>
        <p>Vous n'êtes pas connecté(e)</p>
    </c:otherwise>
</c:choose>
