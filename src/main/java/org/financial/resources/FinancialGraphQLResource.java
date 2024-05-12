package org.financial.resources;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.graphql.*;
import org.financial.domain.StockMarketAction;
import org.financial.request.StockMarketActionRequest;
import org.financial.services.FinancialService;

import java.util.List;

@GraphQLApi
public class FinancialGraphQLResource {


    @Inject
    private FinancialService financialService;

    @Mutation("createStock")
    @Description("Create a record of stock by symbol")
    public Uni<StockMarketAction> createStock(@Name("request") StockMarketActionRequest request) {
        return financialService.createStockMarketActionReactiveFromRepository(request);
    }

    @Query("getStock")
    @Description("Get all stock in database")
    public Uni<List<StockMarketAction>> getStockMarketActionsReactiveRepository() {
        return financialService.findAllFromRepository();
    }


    @Query("getStockBySymbol")
    @Description("Get all stock in database by symbol")
    public Uni<List<StockMarketAction>> getStockBySymbol(@Name("symbol") String symbol) {
        return financialService.findBySymbol(symbol);
    }




}
