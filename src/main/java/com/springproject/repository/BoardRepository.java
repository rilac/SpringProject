package com.springproject.repository;

import com.springproject.domain.Board;
import com.springproject.domain.Members;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    @Autowired
    private final EntityManager em;

    @Transactional
    public void save(Board board){
        em.persist(board);
    }


    public List<Board> findListByID(String userid){
        return em.createQuery("select b from Board b where b.member.userid=:userid", Board.class).setParameter("userid", userid).getResultList();
    }

    public Members findByID(String userid){
        return em.createQuery("select m from Members m where m.userid=:userid", Members.class).setParameter("userid", userid).getSingleResult();
    }
}
