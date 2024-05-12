package org.financial.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.financial.domain.StockMarketAction;

import java.util.List;

@ApplicationScoped
public class FinancialRepository implements PanacheRepositoryBase<StockMarketAction,Long> {

    public Uni<List<StockMarketAction>> findBySymbol(String symbol) {
        return list("symbol", symbol);
    }

}
