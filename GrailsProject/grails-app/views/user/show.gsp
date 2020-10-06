<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-user" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
%{--<f:display bean="user" />--}%

    <fieldset class="form">
        %{--<g:textField name="username" id="username" value="${this.user.username}"/>--}%
        <div class="row">
            <div class="form-group col-md-3">
                <label for="username">Username:</label>
                <input type="text" id="username" value="${this.user.username}">

                <div class="valid-feedback">Valid.</div>

                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <div class="form-group">
                <label for="enabled">Enabled:</label>
                <input type="checkbox" id="enabled" value="${this.user.enabled}">

                <div class="valid-feedback">Valid.</div>

                <div class="invalid-feedback">Check this checkbox to continue.</div>
            </div>

            <div class="row col-md-4">
                <div class="form-group">
                    <label for="accountExpired">Enabled:</label>
                    <input type="checkbox" id="accountExpired" value="${this.user.accountExpired}">

                    <div class="valid-feedback">Valid.</div>

                    <div class="invalid-feedback">Check this checkbox to continue.</div>
                </div>

                <div class="form-group">
                    <label for="accountLocked">Enabled:</label>
                    <input type="checkbox" id="accountLocked" value="${this.user.accountLocked}">

                    <div class="valid-feedback">Valid.</div>

                    <div class="invalid-feedback">Check this checkbox to continue.</div>
                </div>
            </div>

        </div>
        %{--<f:all bean="user"/>--}%
        <div class="row ">
            <div class="form-group col-md-4">

                <g:form resource="${this.user}" method="DELETE">
                    <fieldset class="buttons">
                        <g:link class="edit" action="edit" resource="${this.user}"><g:message
                                code="default.button.edit.label"
                                default="Edit"/></g:link>
                        <input class="delete" type="submit"
                               value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                               onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
                    </fieldset>
                </g:form>
            </div>
        </div>
    </fieldset>

</div>
</body>
</html>
