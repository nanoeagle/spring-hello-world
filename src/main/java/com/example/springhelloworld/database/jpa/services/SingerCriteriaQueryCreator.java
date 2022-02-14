package com.example.springhelloworld.database.jpa.services;

import java.util.Map;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;

import com.example.springhelloworld.database.jpa.entities.*;

class SingerCriteriaQueryCreator {
    private CriteriaBuilder criteriaBuilder;
    private Map<String, ?> fields;
    private CriteriaQuery<Singer> criteriaQuery;

    SingerCriteriaQueryCreator(CriteriaBuilder criteriaBuilder, 
    Map<String, ?> fields) {
        this.criteriaBuilder = criteriaBuilder;
        this.fields = fields;
    }

    CriteriaQuery<Singer> getCriteriaQuery() {
        if (criteriaQuery == null) create();
        return criteriaQuery;
    }
    
    private void create() {
        criteriaQuery = criteriaBuilder.createQuery(Singer.class);
        Root<Singer> singerRoot = criteriaQuery.from(Singer.class);
        Expression<Boolean> criteria = createCriteriaFromFields(singerRoot);
        criteriaQuery.select(from(singerRoot)).distinct(true);
        criteriaQuery.where(criteria);
    }

    private Expression<Boolean> createCriteriaFromFields(Root<Singer> singerRoot) {
        Predicate criteria = criteriaBuilder.conjunction();
        Map<String, SingularAttribute<Singer, ?>> singerAttributes = createSingerAttributeMap();
        for (String fieldName : fields.keySet()) {
            Predicate predicate = criteriaBuilder.equal(
                singerRoot.get(singerAttributes.get(fieldName)), fields.get(fieldName));
            criteria = criteriaBuilder.and(criteria, predicate);
        }
        return criteria;
    }

    private Map<String, SingularAttribute<Singer, ?>> createSingerAttributeMap() {
        return Map.of("firstName", Singer_.firstName, "lastName", Singer_.lastName, 
            "birthDate", Singer_.birthDate);
    }

    private Root<Singer> from(Root<Singer> singerRoot) {
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);
        return singerRoot;
    }
}