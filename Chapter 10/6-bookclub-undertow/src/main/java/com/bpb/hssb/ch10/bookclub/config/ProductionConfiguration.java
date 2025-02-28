package com.bpb.hssb.ch10.bookclub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bpb.hssb.ch10.bookclub.domain.ProductionRevision;
import com.bpb.hssb.ch10.bookclub.domain.ServiceInfo;

@Configuration
@Profile("production")
public class ProductionConfiguration {

    @Value("${bookclub.service.info.environment}")
    private String environment;

    @Value("${bookclub.service.info.version}")
    private String version;

    @Value("${bookclub.service.info.revision}")
    private String revision;

    @Bean
    ProductionRevision productionRevision() {
        return new ProductionRevision(revision);
    }

    @Bean
    public ServiceInfo serviceInfo(ProductionRevision productionRevision) {
        String versionStr = version + "-" + productionRevision.getRevision();
        return new ServiceInfo(environment, versionStr);
    }
}
