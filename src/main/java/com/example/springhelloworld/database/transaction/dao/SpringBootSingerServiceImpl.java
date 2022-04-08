package com.example.springhelloworld.database.transaction.dao;

import java.util.List;

import com.example.springhelloworld.database.transaction.entities.Singer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("springBootSingerService")
@Transactional
public class SpringBootSingerServiceImpl implements SingerService {
    private SingerRepository singerRepository;
    private JmsTemplate jmsTemplate;

    public SpringBootSingerServiceImpl(SingerRepository singerRepository, 
    JmsTemplate jmsTemplate) {
        this.singerRepository = singerRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public List<Singer> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long countAll() {
        return singerRepository.countAll();
    }

    @Override
    public Singer save(Singer singer) {
        singerRepository.save(singer);
        jmsTemplate.convertAndSend("singers", "Just saved:" + singer);
        return singer;
    }
}