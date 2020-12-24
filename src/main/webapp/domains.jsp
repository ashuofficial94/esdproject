<%--
  Created by IntelliJ IDEA.
  User: ashutosh
  Date: 23/12/20
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.project.service.DomainsService" %>
<%@ page import="com.project.bean.Domains" %>
<%
    DomainsService domainsService = new DomainsService();
    List<Domains> domains = domainsService.getDomains();
    Map<String, List<Domains>> programs = new HashMap<String, List<Domains>>();

    for(Domains domain: domains) {
        if(!programs.containsKey(domain.getProgram())) {
            programs.put(domain.getProgram(), new ArrayList<Domains>());
        }
        programs.get(domain.getProgram()).add(domain);
    }
%>

<div id="accordion">
    <% for(String program: programs.keySet()) { %>
    <%
        String program_id = program.replaceAll("[\\.\\)\\(]", "_");
    %>
    <div class="card">
        <div class="card-header">
            <div class="row">
                <h3 class="col-10">
                    <%=program%>
                </h3>
                <button class="btn btn-light col-2" data-toggle="collapse" data-target="#<%=program_id%>" aria-expanded="true">
                    +
                </button>
            </div>
        </div>
        <div id="<%=program_id%>" class="collapse">
            <div class="card-body">
                <% for(Domains domain: programs.get(program)) { %>
                <a href="#">
                    <%=domain.getBatch()%>
                </a><br/>
                <% } %>
            </div>
        </div>
    </div>
    <% } %>
</div>
