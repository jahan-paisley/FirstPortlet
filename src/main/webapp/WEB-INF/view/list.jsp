<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${msg ne null}">
	<div class="portlet-msg-success"><c:out value="${msg}" /></div>
</c:if>

<portlet:actionURL var="save" />
<portlet:resourceURL var="viewAsText" />

<form:form modelAttribute="toDo" action="${save}" method="POST">
	<fieldset>
		<legend>Add a TODO</legend>
		<div>
			<form:label path="title" cssStyle="display:block">Title:</form:label>
			<form:input path="title" />
			<form:errors path="title" cssClass="portlet-msg-error" />
		</div>
		<div>
			<form:label path="due" cssStyle="display:block">Due (MM/DD/YYYY):</form:label>
			<form:input path="due" />
			<form:errors path="due" cssClass="portlet-msg-error" />
		</div>
		<div>
			<form:label path="description" cssStyle="display:block">Description:</form:label>
			<form:textarea path="description" />
			<form:errors path="description" cssClass="portlet-msg-error" />
		</div>
		<div>
			<input type="submit" value="Save" />
		</div>
	</fieldset>
</form:form>
<a href="${viewAsText}" onclick="return !window.open(this.href);">View your TODOs as plain text.</a>