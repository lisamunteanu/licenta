package csubbcluj.lisamunteanu.exportservice.controller;

import csubbcluj.lisamunteanu.exportservice.clients.OrderClient;
import csubbcluj.lisamunteanu.exportservice.data.OrderEntryExportData;
import csubbcluj.lisamunteanu.exportservice.data.OrderExportData;
import csubbcluj.lisamunteanu.exportservice.service.ExportService;
import csubbcluj.lisamunteanu.exportservice.utils.ScheduledWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(
        origins = {"*"}
)
@RestController
public class ExportController {
    @Autowired
    ExportService exportService;

    private OrderClient orderClient;

    public ExportController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @GetMapping("/orders")
    public List<OrderExportData> getAllOrders() {
        return orderClient.getAllOrders();
    }

    @GetMapping("/orders/order-entries")
    public List<OrderEntryExportData> getAllOrderEntries() {
        return orderClient.getAllOrderEntries();
    }

    @Scheduled(cron = " 0 0 12 * * Mon-Fri")
    public void exportToCSV() {
        List<OrderExportData> allOrders = this.getAllOrders();
        try {
            exportService.exportAllOrdersToCSV(allOrders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/orders-export")
    public HttpStatus exportOrdersToCSV() {
        List<OrderExportData> allOrders = this.getAllOrders();
        try {
            exportService.exportAllOrdersToCSV(allOrders);
            return HttpStatus.OK;
        } catch (IOException e) {
           return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping("/order-entries-export")
    public HttpStatus exportOrderEntriesToCSV(){
        List<OrderEntryExportData> allOrderEntries = this.getAllOrderEntries();
        try{
            exportService.exportAllOrderEntriesToCSV(allOrderEntries);
            return HttpStatus.OK;
        }
        catch (IOException e){
            return HttpStatus.BAD_REQUEST;
        }
    }
}
