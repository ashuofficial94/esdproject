package com.project.dao;

import com.project.bean.Employees;
import com.project.dao.template.EmployeesDAOTemplate;
import com.project.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeesDAO implements EmployeesDAOTemplate {

    @Override
    public Employees emailVerify(Employees employee) {

        try(Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from Employees where email=:email");
            query.setParameter("email", employee.getEmail());

            for(final Object fetch: query.list()) {
                Employees result =  (Employees) fetch;
                if(result.getDepartment().getName().equals("admin"))
                    return result;
            }
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }

        return null;
    }

}
