package csubbcluj.lisamunteanu.exportservice.service;

import csubbcluj.lisamunteanu.exportservice.data.OrderEntryExportData;
import csubbcluj.lisamunteanu.exportservice.data.OrderExportData;

import java.io.IOException;
import java.util.List;

public interface ExportService {

    void exportAllOrdersToCSV(List<OrderExportData> orderExportDataList) throws IOException;

    void exportAllOrderEntriesToCSV(List<OrderEntryExportData> orderEntries) throws IOException;
}
