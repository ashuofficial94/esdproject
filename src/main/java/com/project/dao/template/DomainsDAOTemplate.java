package com.project.dao.template;

import com.project.bean.CourseDomain;
import com.project.bean.Domains;

import java.util.List;

public interface DomainsDAOTemplate {

    boolean addDomain(Domains domain);
    List<Domains> getDomains();
    List<CourseDomain> getCourses(Domains domain);
    Domains getDomain(Domains domain);
}
