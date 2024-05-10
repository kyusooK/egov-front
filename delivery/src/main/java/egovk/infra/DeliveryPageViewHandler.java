package egovk.infra;

import egovk.config.kafka.KafkaProcessor;
import egovk.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DeliveryPageRepository deliveryPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_CREATE_1(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;

            // view 객체 생성
            DeliveryPage deliveryPage = new DeliveryPage();
            // view 객체에 이벤트의 Value 를 set 함
            deliveryPage.setId(Long.valueOf(deliveryStarted.getOrderId()));
            deliveryPage.setOrderId(deliveryStarted.getOrderId());
            deliveryPage.setProductId(deliveryStarted.getProductId());
            deliveryPage.setProductName(deliveryStarted.getProductName());
            deliveryPage.setQty(deliveryStarted.getQty());
            // view 레파지 토리에 save
            deliveryPageRepository.save(deliveryPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_CREATE_2(
        @Payload OrderAccepted orderAccepted
    ) {
        try {
            if (!orderAccepted.validate()) return;

            // view 객체 생성
            DeliveryPage deliveryPage = new DeliveryPage();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            deliveryPageRepository.save(deliveryPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_1(
        @Payload OrderAccepted orderAccepted
    ) {
        try {
            if (!orderAccepted.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
