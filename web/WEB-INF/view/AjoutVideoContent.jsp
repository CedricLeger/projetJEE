<%-- 
    Document   : AjoutVideoContent
    Created on : 14 mai 2019, 12:24:37
    Author     : Leger Cédric 
--%>

<section>
    <form method="post" action="AjoutVideo">
        <fieldset>
            <legend>Ajout de video</legend>
            <p>Ici vous ajoutez vos videos</p>
            <label for="lien">Lien<span class="mandatory">*</label>
            <input type="text" id="lien" name="lien" value="<c:out value="${requestScope.video.lien_video}"/>" size="20" maxlength="20" />
            <span class="error">${requestScope.form.errors.lien}</span>
            <br/>
            <label for="titre">Titre video <span class="mandatory">*</span></label>
            <input type="titre" id="titre" name="titre" value="<c:out value="${requestScope.video.titre_video}"/>" size="20" maxlength="60" />
            <span class="error">${requestScope.form.errors.titre}</span>
            <br />
            <label for="description">description <span class="mandatory">*</span></label>
            <input type="description" id="description" name="description" value="<c:out value="${requestScope.video.description_video}"/>" size="20" maxlength="20" />
            <span class="error">${requestScope.form.errors.description}</span>
            <br />
            <input type="submit" value="Envoyer" class="noLabel" />
            <p>Les champs marqués d'un <span class="mandatory">*</span> sont obligatoires.</p>
            <p class="${(empty requestScope.form.errors) ? 'success' : 'error'}">${requestScope.form.result}</p>
            <p class="error">${requestScope.form.errors.errorMessage}</p>
        </fieldset>
    </form>
</section>
