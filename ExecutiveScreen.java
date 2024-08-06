package edu.waketech.csc251.hr.mgmt;

import edu.waketech.csc251.hr.person.Employee;
import edu.waketech.csc251.tools.Screener;

public class ExecutiveScreen implements Screener<Employee> {
    @Override
    public boolean test(Employee obj) {
        return obj instanceof Executive;
    }
}
