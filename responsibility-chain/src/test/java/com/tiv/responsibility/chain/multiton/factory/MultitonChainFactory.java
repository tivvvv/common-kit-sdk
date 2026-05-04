package com.tiv.responsibility.chain.multiton.factory;

import com.tiv.responsibility.chain.multiton.BusinessResponsibilityChain;
import com.tiv.responsibility.chain.multiton.chain.MultitonChain1;
import com.tiv.responsibility.chain.multiton.chain.MultitonChain2;
import com.tiv.responsibility.chain.multiton.helper.ResponsibilityChainAssembler;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MultitonChainFactory {

    @Bean("demo1")
    public BusinessResponsibilityChain<String, DynamicContext, String> demo1(MultitonChain1 multitonChain1, MultitonChain2 multitonChain2) {
        ResponsibilityChainAssembler<String, DynamicContext, String> assembler = new ResponsibilityChainAssembler<>("demo1", multitonChain1, multitonChain2);
        return assembler.getResponsibilityChain();
    }

    @Bean("demo2")
    public BusinessResponsibilityChain<String, DynamicContext, String> demo2(MultitonChain2 multitonChain2) {
        ResponsibilityChainAssembler<String, DynamicContext, String> assembler = new ResponsibilityChainAssembler<>("demo2", multitonChain2);
        return assembler.getResponsibilityChain();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class DynamicContext extends com.tiv.responsibility.chain.multiton.helper.DynamicContext {
        private String word;
    }

}