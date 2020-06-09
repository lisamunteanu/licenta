package csubbcluj.lisamunteanu.exportservice.clients;

import csubbcluj.lisamunteanu.exportservice.data.OrderEntryExportData;
import csubbcluj.lisamunteanu.exportservice.data.OrderExportData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {
    @GetMapping("/")
    List<OrderExportData> getAllOrders();

    @GetMapping("/order-entries")
    List<OrderEntryExportData> getAllOrderEntries();
}