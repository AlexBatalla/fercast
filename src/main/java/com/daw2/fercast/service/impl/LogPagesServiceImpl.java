package com.daw2.fercast.service.impl;

import com.daw2.fercast.model.entity.LogPage;
import com.daw2.fercast.model.repository.LogPagesRepository;
import com.daw2.fercast.service.LogPagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogPagesServiceImpl implements LogPagesService {

    @Autowired
    private LogPagesRepository repo;

    public void save(LogPage log) {repo.save(log);}

}