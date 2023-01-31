package com.ss01.simpleDictionary.repository;

import java.util.Map;

public interface IDictionaryRepository {
    Map<String, String> getAll();
    String findByWord(String word);
}
