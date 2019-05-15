



<c:if test="${empty sessionScope.userSession}">
    <jsp:include page="/WEB-INF/templates/HeaderVisiteur.jsp" />
</c:if>

<c:if test="${!empty sessionScope.userSession}">
    <jsp:include page="/WEB-INF/templates/HeaderUtilisateur.jsp" />
</c:if>

