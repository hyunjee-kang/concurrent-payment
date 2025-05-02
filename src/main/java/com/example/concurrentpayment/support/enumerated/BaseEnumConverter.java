package com.example.concurrentpayment.support.enumerated;

import com.example.concurrentpayment.support.base.BaseEnum;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

// Enum ↔ DB 값 변환을 공통으로 처리하는 추상 클래스
public abstract class BaseEnumConverter<X extends Enum<X> & BaseEnum<Y>, Y> implements AttributeConverter<X, Y> {
    protected abstract X[] getValueList();

    @Override
    public Y convertToDatabaseColumn(X attribute) {
        return attribute.getValue();
    }

    @Override
    public X convertToEntityAttribute(Y dbData) {
        return Arrays.stream(getValueList())
                .filter(e -> e.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s", dbData)));
    }
}