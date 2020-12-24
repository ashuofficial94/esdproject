<%@ page import="com.project.bean.Domains" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.service.DomainsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="text-center"> <h2> Search Domain </h2> </div>
<div id="domain_search">
    <form id="search_domain">
        <div class="form-group row">
            <label class="form-control col-2" style="background-color: transparent">Program: </label>
            <select id="domains" class="form-control col-8">
                <%
                    DomainsService domainsService = new DomainsService();
                    List<Domains> domainsList = domainsService.getDomains();
                    for(Domains domain: domainsList) {
                %>
                <option value="<%=domain.getProgram()+"-"+domain.getBatch()%>">
                    <%=domain.getProgram()+"-"+domain.getBatch()%>
                </option>
                <% } %>
            </select>
            <button id="select_button" class="btn btn-sm btn-success form-control col-2" type="submit">Select</button>
        </div>
    </form>
</div>
<div id="course_search">
    <form id="search_course">
        <div class="form-group row">
            <label class="form-control col-2" style="background-color: transparent">Course: </label>
            <select id="courses" class="form-control col-8" disabled></select>
            <button id="search_button" class="btn btn-success btn-sm form-control col-2" type="submit" disabled> Search </button>
        </div>
    </form>
</div>
