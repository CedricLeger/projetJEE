<%-- 
    Document   : AdminContent
    Created on : 15 mai 2019, 13:38:58
    Author     : Sayoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <section>
    
        <fieldset>
            <legend> Video en ligne</legend>
            <div>
                <c:forEach var="nom"  items="${requestScope['retObj']}">
 
		          <c:out value="${nom.titre_video}"/>
                          <c:out value="${nom.lien_video}"/>
		</c:forEach>
                <!-- ou -->
                <p>${requestScope.form.retObj}</p> 
                <p> <c:out value="${requestScope.video.retObj.titre_video}"/>  </p>
                <p> <c:out value="${requestScope.video.retObj.lien_video}"/></p>
                <!-- boutons -->
                <input type="button" value="Supprimer" class="noLabel" />
                <input type="button" value="Désactiver" class="noLabel" />
                <!-- <iframe width="560" height="315" src="https://www.youtube.com/embed/ThCbl10-1pA"
                frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
            </div>
                </fieldset>
                <fieldset>
            <legend> Commentaires signalés </legend>
            <div>
                <c:forEach var="nom"  items="${requestScope['reportComment']}">
 
		          <c:out value="${nom.text_comment}"/>
                          
		</c:forEach>
                <p> <c:out value="${requestScope.video.text_comment}"/> </p>
                <input type="button" value="Supprimer" class="noLabel" />
                <input type="button" value="Conserver" class="noLabel" />
            </div>
        </fieldset>
    
</section>
    </body>
</html>
