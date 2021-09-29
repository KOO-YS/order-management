package com.manage;

public enum Shipment {

    ORDER("주문"), ACCEPTED("주문 확인"),
    SHIPPED("발송 시작"), IN_SORTING_CENTER("물류센터 상품 인수"),
    OUT_FOR_DELIVERY("최종 배송지로 발송"), DELIVERED("배달 완료");

    String kor;
    Shipment(String kor) {
        this.kor = kor;
    }

    public enum Transition {

    }

}
