package com.ss05.service;

import com.ss05.model.Producer;

import java.util.List;

public interface IProducerService extends  IGeneralService<Producer>{
    List<String> getProducers();
}
