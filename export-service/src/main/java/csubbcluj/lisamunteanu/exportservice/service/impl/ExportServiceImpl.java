package csubbcluj.lisamunteanu.exportservice.service.impl;

import csubbcluj.lisamunteanu.exportservice.data.OrderEntryExportData;
import csubbcluj.lisamunteanu.exportservice.data.OrderExportData;
import csubbcluj.lisamunteanu.exportservice.service.ExportService;
import csubbcluj.lisamunteanu.exportservice.utils.ScheduledWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {
    @Override
    public void exportAllOrdersToCSV(List<OrderExportData> orderExportDataList) throws IOException {
        ScheduledWriter writer = this.prepareCsvWriting("C:\\Users\\lisam\\Desktop\\LICENTA\\exports\\orders\\");
        this.writeOrderHeader(writer);
        for (OrderExportData order : orderExportDataList) {
            if (isFromLast24Hours(order.getDate())) {
                this.writeOrder(order, writer);
            }
        }
        writer.getCsvWriter().close();
    }

    public Boolean isFromLast24Hours(LocalDateTime dateTime) {
        LocalDateTime comparisonDate = LocalDateTime.now().minusDays(1);
        if (dateTime.isAfter(LocalDateTime.now()) || dateTime.isBefore(comparisonDate)) {
            return false;
        }
        return true;
    }

    public void writeOrderHeader(ScheduledWriter scheduledWriter) {
        scheduledWriter.writeOrderHeader();
    }

    public void writeOrderEntryHeader(ScheduledWriter scheduledWriter) {
        scheduledWriter.writeOrderEntryHeadr();
    }

    public void writeOrder(OrderExportData order, ScheduledWriter scheduledWriter) {
        scheduledWriter.writeOrderLine(order);
    }

    public void writeOrderEntry(OrderEntryExportData orderEntry, ScheduledWriter scheduledWriter) {
        scheduledWriter.writeOrderEntryLine(orderEntry);
    }

    public ScheduledWriter prepareCsvWriting(String pathToCSV) {
        LocalDateTime date = LocalDateTime.now();
        String fileName = date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth() + "-" + date.getHour()
                + "-" + date.getMinute() + "-" + date.getSecond() + ".csv";
        ScheduledWriter csvWriter = new ScheduledWriter(pathToCSV + fileName);
        return csvWriter;
    }

    @Override
    public void exportAllOrderEntriesToCSV(List<OrderEntryExportData> orderEntries) throws IOException {
        ScheduledWriter writer = this.prepareCsvWriting("C:\\Users\\lisam\\Desktop\\LICENTA\\exports\\order-entries\\");
        this.writeOrderEntryHeader(writer);
        for (OrderEntryExportData orderEntry : orderEntries) {
            if (isFromLast24Hours(orderEntry.getOrderDate())) {
                this.writeOrderEntry(orderEntry, writer);
            }
        }
        writer.getCsvWriter().close();
    }

}
