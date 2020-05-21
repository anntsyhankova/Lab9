<%@ tag pageEncoding="UTF-8" %>
<%@taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Кнопка удаления показывается только если:
1) пользователь аутентифицирован (authUser!=null);
2) передано текущее объявление (ad!=null);
3) id автора объявленния и id аутентифицированного пользователя
совпадают --%>
<с:if test="${sessionScope.authUser!=null}">
    <div
            style="background-color: #ccc; border: 1px solid black; float: right; margin: 10px; margin-top: 20px; padding: 5px 0px; text-align: center; width: 150px;">
        <a href="<с:url value="/doDeleteAllAd.jsp"/>">Удалить всё</a>
    </div>
</с:if>
