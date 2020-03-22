package org.tanberg.oving8.office;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Printer {

    private final Map<Employee, EmployeeHistory> historyByEmployee;

    public Printer() {
        this.historyByEmployee = Maps.newHashMap();
    }

    public void printDocument(String document, Employee employee) {
        System.out.println(document);

        this.historyByEmployee.compute(employee, (emp, history) -> {
            if (history == null) {
                history = new EmployeeHistory();
            }

            history.appendDocument(document);
            return history;
        });
    }

    public List<String> getPrintHistory(Employee employee) {
        EmployeeHistory history = this.historyByEmployee.get(employee);
        return history == null ? Collections.emptyList() : history.getDocuments();
    }

    private static class EmployeeHistory {

        private final List<String> documents;

        public EmployeeHistory() {
            this.documents = Lists.newLinkedList();
        }

        protected void appendDocument(String document) {
            this.documents.add(document);
        }

        public List<String> getDocuments() {
            return this.documents;
        }
    }
}
