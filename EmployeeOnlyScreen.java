package edu.waketech.csc251.hr.person;

import edu.waketech.csc251.hr.mgmt.Executive;
import edu.waketech.csc251.hr.mgmt.Manager;
import edu.waketech.csc251.tools.Screener;

public class EmployeeOnlyScreen implements Screener<Employee> {
    @Override
    public boolean test(Employee obj) {
        return !(obj instanceof Manager) && !(obj instanceof Executive);
    }
}
