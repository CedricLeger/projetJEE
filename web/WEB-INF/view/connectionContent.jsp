<%-- 
    Document   : connectionContent
    Created on : 13 mai 2019, 14:59:48
    Author     : Leger Cédric 
--%>
<section>
    <form method="post" action="connection">
        <fieldset>
            <legend>Connexion</legend>
            <p>Vous pouvez vous connecter via ce formulaire.</p>
            <label for="email">Adresse email <span class="requis">*</span></label>
            <input type="email" id="email" name="email" value="<c:out value="${requestScope.user.email}" />" size="20" maxlength="60" />
            <span class="error">${requestScope.form.errors['email']}</span>
            <br /><label for="password">Mot de passe <span class="requis">*</span></label>
            <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
            <span class="error">${requestScope.form.errors['password']}</span>
            <br /><input type="submit" value="Connexion" class="noLabel" />
            <p class="${empty requestScope.form.errors ? 'success' : 'error'}">${requestScope.form.result}</p>
            <p class="error">${requestScope.form.errors.errorMessage}</p>
        </fieldset>
    </form>
</section>