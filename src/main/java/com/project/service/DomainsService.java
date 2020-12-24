package com.project.service;

import com.project.bean.CourseDomain;
import com.project.bean.Domains;
import com.project.dao.DomainsDAO;

import java.util.List;

public class DomainsService {
    DomainsDAO domainsDAO = new DomainsDAO();

    public boolean addDomain(Domains domain) { return domainsDAO.addDomain(domain); }
    public List<Domains> getDomains() { return domainsDAO.getDomains(); }
    public List<CourseDomain> getCourses(Domains domain) {return domainsDAO.getCourses(domain); }
}
