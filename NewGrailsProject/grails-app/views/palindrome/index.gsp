<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <title>Palindrome</title>
    </head>
    <body>

        <div id="list-book" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label"  /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            %{--<f:table collection="${bookList}" />

            <div class="pagination">
                <g:paginate total="${bookCount ?: 0}" />
            </div>--}%
        </div>
    </body>
</html>