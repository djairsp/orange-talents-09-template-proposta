package com.zup.proposta.util.beanvalidation;

import com.zup.proposta.exception.UnprocessableEntityException;
import org.springframework.validation.BindException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;
    private BindException bindingResult;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

       Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
       query.setParameter("value", value);
       List<?> list = query.getResultList();
       //Assert.state(list.size() <=1, "Foi encontrado mais de um "+klass+" com o atributo " + domainAttribute +" = "+ value);
       if((list.size() >= 1)){
           String text = "Foi encontrado mais de um "+klass+" com o atributo " + domainAttribute +" = "+ value;
           throw new UnprocessableEntityException(text);
       }

       return list.isEmpty();
    }
}
