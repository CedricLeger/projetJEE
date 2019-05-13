<%-- 
    Document   : inscriptionContent
    Created on : 13 mai 2019, 15:01:06
    Author     : Leger Cédric 
--%>
<section>
    <form method="post" action="inscription">
        <fieldset>
            <legend>Inscription</legend>
            <p>Vous pouvez vous inscrire via ce formulaire.</p>
            <label for="email">Adresse email <span class="mandatory">*</span></label>
            <input type="email" id="email" name="email" value="<c:out value="${requestScope.user.email}"/>" size="20" maxlength="60" />
            <span class="error">${requestScope.form.errors.email}</span>
            <br />
            <label for="password">Mot de passe <span class="mandatory">*</span></label>
            <input type="password" id="password" name="password" value="<c:out value="${requestScope.user.password}"/>" size="20" maxlength="20" />
            <span class="error">${requestScope.form.errors.password}</span>
            <br />
            <label for="confirm">Confirmation <span class="mandatory">*</span></label>
            <input type="password" id="confirm" name="confirm" value="" size="20" maxlength="20" />
            <span class="error">${requestScope.form.errors.confirm}</span>
            <br />
            <label for="username">Nom d'utilisateur</label>
            <input type="text" id="username" name="username" value="<c:out value="${requestScope.user.name}"/>" size="20" maxlength="20" />
            <span class="error">${requestScope.form.errors.username}</span>
            <br />
            <input type="submit" value="Inscription" class="noLabel" />
            <p>Les champs marqués d'un <span class="mandatory">*</span> sont obligatoires.</p>
            <p class="${(empty requestScope.form.errors) ? 'success' : 'error'}">${requestScope.form.result}</p>
            <p class="error">${requestScope.form.errors.errorMessage}</p>
        </fieldset>
    </form>
</section>
