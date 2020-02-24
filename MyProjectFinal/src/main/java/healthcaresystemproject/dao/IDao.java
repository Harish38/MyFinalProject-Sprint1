package healthcaresystemproject.dao;

import java.sql.Date;

import healthcaresystemproject.dto.DiagnosticCenter;
import healthcaresystemproject.dto.Test;
import healthcaresystemproject.dto.User;

public interface IDao {
public String addCenter(DiagnosticCenter center);
public boolean removeCenter(DiagnosticCenter center);
public String addTest(Test test);
public boolean removeTest(Test test);
public long makeAppointment(User user,DiagnosticCenter center,Test test,Date datetime);
public String register(User user);
public boolean approveAppointment();
}
