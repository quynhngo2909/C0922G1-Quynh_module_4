package com.ss01.simpleDictionary.service.impl;

import com.ss01.simpleDictionary.repository.IDictionaryRepository;
import com.ss01.simpleDictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository dictionaryRepository;

    @Override
    public Map<String, String> getAll() {
        return dictionaryRepository.getAll();
    }

    @Override
    public String findByWord(String word) {
        return dictionaryRepository.findByWord(word);
    }
}
