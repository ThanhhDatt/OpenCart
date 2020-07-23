package com.opencart.Repository.DataJPA;

import com.opencart.Model.Order;
import com.opencart.Repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class JPAOrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Order> findOrderByID(int ID) {
        return null;
    }

    @Override
    public void save(Order order) {

    }
}
