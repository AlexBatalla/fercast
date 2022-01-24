package com.daw2.fercast.service;


import com.daw2.fercast.model.entity.LogPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogPagesService {
    void save(LogPage log);
}
