package com.project.dao;

import com.project.bean.CourseDomain;
import com.project.bean.Courses;
import com.project.bean.Domains;
import com.project.dao.template.DomainsDAOTemplate;
import com.project.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DomainsDAO implements DomainsDAOTemplate {
    @Override
    public boolean addDomain(Domains domain) {
        try(Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(domain);
            transaction.commit();
            return true;
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Domains> getDomains() {
        Session session = SessionUtil.getSession();
        List<Domains> domains = new ArrayList<Domains>();

        try {
            for (final Object domain: session.createQuery("from Domains").list()) {
                domains.add((Domains) domain);
            }
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return domains;
    }

    @Override
    public List<CourseDomain> getCourses(Domains domain) {

        try(Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Domains where program=:program and batch=:batch");
            query.setParameter("program", domain.getProgram());
            query.setParameter("batch", domain.getBatch());

            for(final Object fetch: query.list()) {
                domain = (Domains) fetch;
            }

            List<CourseDomain> courseDomains = domain.getCourseDomainList();

            if(courseDomains.size() > 0)
                return courseDomains;

            return new ArrayList<CourseDomain>();
        }

        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Domains getDomain(Domains domain) {

        try(Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Domains where program =: program and batch =: batch");
            query.setParameter("program", domain.getProgram());
            query.setParameter("batch", domain.getBatch());

            for(final Object fetch: query.list()) {
                return (Domains)fetch;
            }
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }

        return null;
    }
}
