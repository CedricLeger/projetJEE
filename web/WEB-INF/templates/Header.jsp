



<c:if test="${empty sessionScope.sessionUtilisateur}">
    <jsp:include page="/WEB-INF/templates/HeaderVisiteur.jsp" />
</c:if>

<c:if test="${!empty sessionScope.sessionUtilisateur}">
    <jsp:include page="/WEB-INF/templates/HeaderUtilisateur.jsp" />
</c:if>

