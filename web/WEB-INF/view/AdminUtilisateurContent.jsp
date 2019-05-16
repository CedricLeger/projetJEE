<%-- 
    Document   : AdminUtilisateurContent
    Created on : 15 mai 2019, 22:24:38
    Author     : Sayoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Hello World!</h1>
<section>

    <p>Les utilisateurs</p>

    <c:forEach var="nom" items="${requestScope['retObjUtilisateur']}" varStatus="count" >
        <form>
            <fieldset>
                <legend></legend>
                <input type="text" name="id_utilisateur" value="<c:out value="${nom.id_utilisateur}"/>" >
                <input type="text" name="email" value="<c:out value="${nom.mail}"/>">
                <input type="text" name="pseudo" value="<c:out value="${nom.pseudo}"/>" >

                <!-- boutons -->
                <button name="btn" type="submit" value="Supprimer" formmethod="post" formaction="AdminUtilisateur"> Supprimer </button>
                <button name="btn" type="submit" value="Desactiver" formmethod="post" formaction="AdminUtilisateur"> Desactiver </button>
                <button name="btn" type="submit" value="Admin" formmethod="post" formaction="AdminUtilisateur"> Admin </button>

            </fieldset>
        </form>

    </c:forEach>