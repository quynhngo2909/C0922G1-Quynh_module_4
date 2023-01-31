package com.ss01.simpleDictionary.service;

import java.util.Map;

public interface IDictionaryService {
    Map<String, String> getAll();
    String findByWord(String word);
}
