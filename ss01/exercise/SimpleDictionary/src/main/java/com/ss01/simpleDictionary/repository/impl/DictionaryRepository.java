package com.ss01.simpleDictionary.repository.impl;

import com.ss01.simpleDictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("Multiplication","Phép nhân");
        dictionary.put("Operation","Thao tác");
        dictionary.put("Process","Xử lý");
        dictionary.put("Binary","Nhị phân, thuộc về nhị phân");
        dictionary.put("Command","Ra lệnh, lệnh (trong máy tính)");
        dictionary.put("Mainframe computer","Máy tính lớn");
        dictionary.put("Centerpiece","Mảnh trung tâm");
        dictionary.put("Analyst","Nhà phân tích");
        dictionary.put("Network","Mạng");
        dictionary.put("Invention","Phát minh");
    }
    @Override
    public Map<String, String> getAll() {
        return dictionary;
    }

    @Override
    public String findByWord(String word) {
        return dictionary.get(word);
    }
}
