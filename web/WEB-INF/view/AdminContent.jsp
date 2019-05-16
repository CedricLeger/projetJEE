<%-- 
    Document   : AdminContent
    Created on : 15 mai 2019, 13:38:58
    Author     : Sayoy
--%>

<h1>Hello World!</h1>
<section>

    <p>Les vidéos en ligne</p>

    <c:forEach var="nom" items="${requestScope['retobj']}" varStatus="count" >
        <form>
            <fieldset>
                <legend><c:out value="${nom.titre_video}" /></legend>
                <input type="text" name="id_video" value="<c:out value="${nom.id_video}"/>" >
                <input type="text" name="titre" value="<c:out value="${nom.titre_video}"/>">
                <input type="text" name="lien" value="<c:out value="${nom.lien_video}"/>" >

                <!-- boutons -->
                <button name="btn" type="submit" value="Supprimer" formmethod="post" formaction="Admin"> Supprimer </button>
                <button name="btn" type="submit" value="Desactiver" formmethod="post" formaction="Admin"> Desactiver </button>
            </fieldset>
        </form>

    </c:forEach>


    <!-- <iframe width="560" height="315" src="https://www.youtube.com/embed/ThCbl10-1pA"
    frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->

<h1>Hello Le World!</h1>
<section>

    <p>Les commentaires signalés</p>

    <c:forEach var="nom" items="${requestScope['reportComment']}" varStatus="count" >
        <form>
            <fieldset>
                <legend> </legend>
                <input type="text" name="id_comment" value="<c:out value="${nom.id_comment}"/>" > <br>
                <input type="text" name="text_comment" value="<c:out value="${nom.text_comment}"/>" >
                <!-- boutons --> <br>
                <button name="btn" type="submit" value="Conserver" formmethod="post" formaction="Admin"> Conserver </button>
                <button name="btn" type="submit" value="Suppr" formmethod="post" formaction="Admin"> Supprimer </button>
            </fieldset>
        </form>

    </c:forEach>


</section>
