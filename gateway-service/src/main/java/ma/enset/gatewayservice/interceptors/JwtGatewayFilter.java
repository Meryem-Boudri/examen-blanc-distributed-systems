package ma.enset.gatewayservice.interceptors;

import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
/*
@Component
public class JwtGatewayFilter implements GatewayFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtGatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authorizationHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        logger.info("Forwarding Authorization Header: {}", authorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            exchange = exchange.mutate()
                    .request(builder -> builder.header(HttpHeaders.AUTHORIZATION, authorizationHeader))
                    .build();
        }

        return chain.filter(exchange);
    }


}*/
