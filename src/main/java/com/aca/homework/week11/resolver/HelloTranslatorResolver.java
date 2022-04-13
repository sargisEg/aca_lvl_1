package com.aca.homework.week11.resolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloTranslatorResolver {

    private final Map<LanguageType, HelloTranslator> translators = new HashMap<>();

    public HelloTranslatorResolver(List<HelloTranslator> translatorsList) {
        for (HelloTranslator helloTranslator : translatorsList) {
            translators.put(helloTranslator.type(), helloTranslator);
        }
    }

    public HelloTranslator resolve(LanguageType languageType) {
        return translators.get(languageType);
    }
}
