package com.liu.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author liulei
 * @Description 消息发送接口
 * @create 2017/10/31 14:12
 */
@Component
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
