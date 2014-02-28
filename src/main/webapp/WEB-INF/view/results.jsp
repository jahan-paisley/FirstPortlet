<%@ page contentType="text/plain" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<portlet:defineObjects />

<c:forEach var="toDo" items="${portletSessionScope['toDos']}">
<c:out value="${toDo.title}" />,<c:out value="${toDo.due}" />,<c:out value="${toDo.description}" />
</c:forEach>